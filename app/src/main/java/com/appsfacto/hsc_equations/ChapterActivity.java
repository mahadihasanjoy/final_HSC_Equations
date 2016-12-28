package com.appsfacto.hsc_equations;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.appsfacto.hsc_equations.helper.Constant;

public class ChapterActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    int grid_no = 1;
    String title = "Physics 1st Paper";
    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            grid_no = extras.getInt(Constant.GRID_NO);
            title = extras.getString(Constant.TITLE);
        }
        setSupportActionBar(toolbar);
        wv= (WebView)findViewById(R.id.wvChapter);
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);
        switch (grid_no) {
            case 1:
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.bg_chapter_1)));
                getSupportActionBar().setTitle(title);
                wv.loadUrl("file:///android_asset/phy/chapter1.html");
                break;
            case 2:
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.bg_chapter_2)));
                getSupportActionBar().setTitle(title);
                wv.loadUrl("file:///android_asset/index.html");
                break;
            case 3:
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.bg_chapter_3)));
                getSupportActionBar().setTitle(title);


                break;
            case 4:
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.bg_chapter_4)));
                getSupportActionBar().setTitle(title);

                break;
            case 5:
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.bg_chapter_5)));
                getSupportActionBar().setTitle(title);

                break;
            case 6:
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.bg_chapter_6)));
                getSupportActionBar().setTitle(title);

                break;

            default:
                break;
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.chapter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.chapter_1) {
            // Handle the camera action
            wv.loadUrl("file:///android_asset/phy/chapter1.html");
        } else if (id == R.id.chapter_2) {
            wv.loadUrl("file:///android_asset/phy/chapter2.html");
        } else if (id == R.id.chapter_3) {

        } else if (id == R.id.chapter_4) {

        } else if (id == R.id.chapter_5) {

        } else if (id == R.id.chapter_6) {

        } else if (id == R.id.chapter_7) {

        } else if (id == R.id.chapter_8) {

        } else if (id == R.id.chapter_9) {

        } else if (id == R.id.chapter_10) {
            wv.loadUrl("file:///android_asset/math/Chapter10.html");

        } else if (id == R.id.chapter_11) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
