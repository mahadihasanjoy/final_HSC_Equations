package com.appsfacto.hsc_equations;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.appsfacto.hsc_equations.helper.Utilities;


public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(getResources().getColor(R.color.bg_chapter_3)));
        getSupportActionBar().setTitle(getResources().getString(R.string.about_title));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tvAppVersion = (TextView) findViewById(R.id.tv_app_name_version);
        StringBuilder stringBuilder = new StringBuilder(tvAppVersion.getText()).append(Utilities.getVersionName(this));
        tvAppVersion.setText(stringBuilder.toString());

        TextView tv_click_to_rate = (TextView)findViewById(R.id.tv_click_to_rate);
        tv_click_to_rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Uri uri = Uri.parse("market://details?id=" + getPackageName());
                    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id="
                                    + getPackageName())));
                }
            }
        });
    }
}