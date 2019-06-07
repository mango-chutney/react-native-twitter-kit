package com.rntwitterkitexample;

import com.facebook.react.ReactActivity;
import android.os.Bundle;
import com.twitter.sdk.android.core.Twitter;

public class MainActivity extends ReactActivity {

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "RNTwitterKitExample";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Twitter.initialize(this);
        super.onCreate(savedInstanceState);
    }
}
