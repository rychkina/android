package mobi.mobiletech.apps.android.wigand;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;


public class MainWrapperActivity extends Activity {
    WebView mWebView;
    public static final String HTTP_WIGAND_SERVICES_HTML = "http://wigand.wew.io/services.html";
    public static final  String url = "http://wigand.wew.io/";

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mWebView = (WebView) findViewById(R.id.webView1);
        mWebView.setVerticalScrollBarEnabled(true);
        mWebView.setHorizontalScrollBarEnabled(true);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new PageWebViewClient());
        mWebView.loadUrl(url);
        setWebChromeClientProps();

    }

    /**
     * Handling back button to go back in web history
     *
     * @param keyCode code of key, that've been pressed
     * @param event   object to manipulate event
     * @return event not cancelled
     */
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void setWebChromeClientProps() {
        final Activity MyActivity = this;
        mWebView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                MyActivity.setTitle(R.string.loading);
                MyActivity.setProgress(progress * 100);
                if (progress == 100) {
                    MyActivity.setTitle(R.string.app_name);
                }
            }
        });
    }

    //Meny med div
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        createMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return menuChoice(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);
        createMenu(menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return menuChoice(item);
    }

    private static void createMenu(Menu menu) {
        menu.setQwertyMode(true);
        MenuItem backMenuItem = menu.add(0, 0, 0, R.string.back_menu);
        {
            backMenuItem.setAlphabeticShortcut('b');
            //icon
            backMenuItem.setIcon(R.drawable.back);
        }
        MenuItem forwardMenuItem = menu.add(0, 1, 1, R.string.forward_menu);
        {
            forwardMenuItem.setAlphabeticShortcut('f');
            forwardMenuItem.setIcon(R.drawable.forward);
        }
        MenuItem reloadMenuItem = menu.add(0, 2, 2, R.string.reload_menu);
        {
            reloadMenuItem.setAlphabeticShortcut('r');
            reloadMenuItem.setIcon(R.drawable.update);
        }
        MenuItem homeMenuItem = menu.add(0, 3, 3, R.string.home_menu);
        {
            homeMenuItem.setAlphabeticShortcut('h');
            homeMenuItem.setIcon(R.drawable.wigand);
        }
        MenuItem servicesMenuItem = menu.add(0, 4, 4, R.string.services_menu);
        {
            servicesMenuItem.setAlphabeticShortcut('t');
            servicesMenuItem.setIcon(R.drawable.play);
        }
        MenuItem optionsMenuItem = menu.add(0, 5, 5, R.string.options_menu);
        {
            optionsMenuItem.setAlphabeticShortcut('o');
            optionsMenuItem.setIcon(R.drawable.flash);
        }

    }

    private boolean menuChoice(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                mWebView.goBack();
                Toast.makeText(this, item.getTitle(),
                        Toast.LENGTH_LONG).show();
                return true;
            case 1:
                mWebView.goForward();
                Toast.makeText(this, item.getTitle(),
                        Toast.LENGTH_LONG).show();
                return true;
            case 2:
                mWebView.reload();
                Toast.makeText(this, item.getTitle(),
                        Toast.LENGTH_LONG).show();
                return true;
            case 3:
                mWebView.loadUrl(url);
                Toast.makeText(this, item.getTitle(),
                        Toast.LENGTH_LONG).show();
                return true;
            case 4:
                Toast.makeText(this, item.getTitle(),
                        Toast.LENGTH_LONG).show();
                mWebView.loadUrl(HTTP_WIGAND_SERVICES_HTML);

                return true;
            case 5:
                Toast.makeText(this, item.getTitle(),
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, MainWrapperActivity.class);
                startActivity(intent);
                return true;
        }
        return false;
    }
}
