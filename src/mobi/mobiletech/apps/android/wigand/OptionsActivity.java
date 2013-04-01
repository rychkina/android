package mobi.mobiletech.apps.android.wigand;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

/**
 * Created with IntelliJ IDEA.
 * User: jry
 * Date: 01.04.13
 * Time: 16:38
 */
public class OptionsActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options);

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // DO NOT REMOVE, just having it here seems to fix a weird issue with
        // Time picker where the fields would go blank on rotation.
    }
}
