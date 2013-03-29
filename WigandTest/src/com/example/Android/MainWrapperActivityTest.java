package com.example.Android;

import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.SmallTest;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class com.example.Android.MainWrapperActivityTest \
 * com.example.Android.tests/android.test.InstrumentationTestRunner
 */
public class MainWrapperActivityTest extends ActivityUnitTestCase<MainWrapperActivity> {


    public MainWrapperActivityTest() {
        super(MainWrapperActivity.class);

    }

    @SmallTest
    public void testMain(){
           assertTrue(true);
    }

}
