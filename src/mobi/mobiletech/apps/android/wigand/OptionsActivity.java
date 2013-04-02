package mobi.mobiletech.apps.android.wigand;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RatingBar;

/**
 * Options for wigand application
 * <p/>
 * Created with IntelliJ IDEA.
 * User: jry
 * Date: 01.04.13
 * Time: 16:38
 */
public class OptionsActivity extends Activity {
    CheckBox useCacheEnabled;
    CheckBox useSocialNetworks;
    RatingBar ratingBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options);
        setUseCache();
        setUseSocialNetworks();
        setRatingBar();
    }

    private void setRatingBar() {
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean b) {
                pushRates(rating);
            }
        });
    }

    private void setUseSocialNetworks() {
        useSocialNetworks = (CheckBox) findViewById(R.id.useNetworksCheckbox);
        useSocialNetworks.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                pushUseSocialNetworks(((CheckBox) v).isChecked());
            }

        });
    }

    private void setUseCache() {
        useCacheEnabled = (CheckBox) findViewById(R.id.useCacheCheckbox);
        useCacheEnabled.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                pushUseCache(((CheckBox) v).isChecked());
            }

        });
    }

    public void pushUseCache(boolean isUseCache) {
    }

    public void pushUseSocialNetworks(boolean isUseSocialNetworks) {
    }

    public void pushRates(float rating) {
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
