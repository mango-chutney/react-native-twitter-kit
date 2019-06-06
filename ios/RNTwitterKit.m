
#import "RNTwitterKit.h"

#import <TwitterKit/TWTRKit.h>

@implementation RNTwitterKit

- (dispatch_queue_t)methodQueue {
  return dispatch_get_main_queue();
}

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(compose
                  : (NSDictionary *)options resolver
                  : (RCTPromiseResolveBlock)resolve rejecter
                  : (RCTPromiseRejectBlock)reject) {
  TWTRComposer *composer = [[TWTRComposer alloc] init];

  if ([options objectForKey:@"text"] && [options objectForKey:@"text"] != [NSNull null]) {
    [composer setText:options[@"text"]];
  }

  if ([options objectForKey:@"image"] && [options objectForKey:@"image"] != [NSNull null]) {
    NSError *error;

    NSURL *url = [NSURL URLWithString:options[@"image"]];

    NSData *data = [NSData dataWithContentsOfURL:url];

    if (!data) {
      reject(@"E_IMAGE_DATA_FAILED", @"Image data could not be created", error);

      return;
    }

    UIImage *image = [UIImage imageWithData:data];

    [composer setImage:image];
  }

  if ([options objectForKey:@"url"] && [options objectForKey:@"url"] != [NSNull null]) {
    NSURL *url = [NSURL URLWithString:options[@"url"]];

    [composer setURL:url];
  }

  UIViewController *root =
      [[[[UIApplication sharedApplication] delegate] window] rootViewController];

  while (root.presentedViewController) {
    root = root.presentedViewController;
  }

  [composer showFromViewController:root
                        completion:^(TWTRComposerResult result) {
                          resolve(@(result));

                          return;
                        }];
}

@end
