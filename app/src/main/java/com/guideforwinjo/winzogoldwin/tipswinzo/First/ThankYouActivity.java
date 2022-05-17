package com.guideforwinjo.winzogoldwin.tipswinzo.First;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.guideforwinjo.winzogoldwin.tipswinzo.ADS.LocalAds;
import com.guideforwinjo.winzogoldwin.R;

public class ThankYouActivity extends AppCompatActivity {
    Context context = this;


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.activity_thankyou);

        LocalAds blueLocalAds = new LocalAds(this);
        blueLocalAds.call_localads_api((RecyclerView) findViewById(R.id.moreappslist));

        findViewById(R.id.exit_dialog_exit).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                finishAffinity();
            }
        });
        findViewById(R.id.exit_dialog_cancel).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });
        findViewById(R.id.exit_rate).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                ThankYouActivity vancedThankYouActivity = ThankYouActivity.this;
                vancedThankYouActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}
