package au.com.mangochutney.twitterkit;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.content.FileProvider;
import android.util.Base64;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.UUID;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

public class RNTwitterKitModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNTwitterKitModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNTwitterKit";
  }

  @ReactMethod
  public void compose(ReadableMap options, Promise promise) throws Exception {
    TweetComposer.Builder builder = new TweetComposer.Builder(reactContext.getCurrentActivity());

    if (options.hasKey("text")) {
      builder.text(options.getString("text"));
    }

    if (options.hasKey("image")) {
      String encodedString = options.getString("image").split(",")[1];

      byte[] decodedString = Base64.decode(encodedString, Base64.DEFAULT);

      Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

      File path = reactContext.getApplicationContext().getExternalCacheDir();

      if (!path.exists() && !path.isDirectory()) {
        path.mkdirs();
      }

      File file = File.createTempFile(UUID.randomUUID().toString(), ".jpg", path);

      FileOutputStream outputStream = new FileOutputStream(file);

      decodedByte.compress(Bitmap.CompressFormat.PNG, 100, outputStream);

      Uri uri = FileProvider.getUriForFile(reactContext.getCurrentActivity(), reactContext.getApplicationContext().getPackageName() + ".provider", file);

      builder.image(uri);
    }

    if (options.hasKey("url")) {
      builder.url(new URL(options.getString("url")));
    }

    builder.show();

    promise.resolve(null);
  }
}
