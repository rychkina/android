package mobi.mobiletech.apps.android.wigand.tests;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.SmallTest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import mobi.mobiletech.apps.android.wigand.MainWrapperActivity;

public class MainWrapperActivityTest extends ActivityUnitTestCase<MainWrapperActivity> {
    MainWrapperActivity mainWrapperActivity;
    private Intent mStartIntent;
    public static final String TEST_WIGAND_URL = "http://wigand.wew.io/";
    public static final String TEST_WIGAND_SERVICE_URL = "http://wigand.wew.io/services.html";

    public MainWrapperActivityTest() {
        super(MainWrapperActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mStartIntent = new Intent(Intent.ACTION_MAIN);
        this.startActivity(mStartIntent, null, null);
        mainWrapperActivity = getActivity();
    }

    @SmallTest
    public void testActivityLoading() {
        assertNotNull(mainWrapperActivity);
    }

    @SmallTest
    public void testWebView() {

        WebView webView = mainWrapperActivity.getmWebView();
        assertNotNull(webView);
        assertTrue(webView.isHorizontalScrollBarEnabled());
        assertTrue(webView.isVerticalScrollBarEnabled());
        assertNotNull(webView.getSettings());
        WebSettings testSettings = webView.getSettings();
        assertTrue(testSettings.getJavaScriptEnabled());
        //assertEquals(TEST_WIGAND_URL, webView.getUrl());

    }

    @SmallTest
    public void testMenu() {
       try {
            mainWrapperActivity.onCreateOptionsMenu(null);
            fail("Error in menu initialization");
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }

    }

    @SmallTest
    public void testUrls() {
        assertEquals(TEST_WIGAND_URL, MainWrapperActivity.WIGAND_URL_BASE);
        assertEquals(TEST_WIGAND_SERVICE_URL, MainWrapperActivity.WIGAND_SERVICES_URL_BASE);
    }

}
