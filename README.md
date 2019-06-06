
# @mango-chutney/react-native-twitter-kit

## Getting started

`$ npm install @mango-chutney/react-native-twitter-kit --save`

### Mostly automatic installation

`$ react-native link @mango-chutney/react-native-twitter-kit`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `@mango-chutney/react-native-twitter-kit` and add `RNTwitterKit.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNTwitterKit.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNTwitterKitPackage;` to the imports at the top of the file
  - Add `new RNTwitterKitPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':@mango-chutney/react-native-twitter-kit'
  	project(':@mango-chutney/react-native-twitter-kit').projectDir = new File(rootProject.projectDir, 	'../node_modules/@mango-chutney/react-native-twitter-kit/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':@mango-chutney/react-native-twitter-kit')
  	```

## Usage
```javascript
import RNTwitterKit from '@mango-chutney/react-native-twitter-kit';

await RNTwitterKit.compose(options);
```
  

### API

#### `compose: (options: { text?: string, image?: string, url?: string }) => Promise<boolean>`

> **Note:** `image` must be a base64 string.
