package mobi.mobiletech.apps.android.wigand;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * User: jry
 * Date: 28.03.13
 * Time: 12:38
 */
class PageWebViewClient extends WebViewClient {


    /**
     * Check cookies when page started loading from any URL
     *
     * @param view WebView, which loading the page
     * @param url currently loading URL
     * @param favicon favicon for requested URL
     */
    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
    }
}