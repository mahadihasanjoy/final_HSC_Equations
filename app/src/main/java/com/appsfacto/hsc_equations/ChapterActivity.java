package com.appsfacto.hsc_equations;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.appsfacto.hsc_equations.helper.Constant;

public class ChapterActivity extends AppCompatActivity {

    int grid_no = 1;
    String title = "Physics 1s Paper";
    String bookName = "math1";
    DrawerLayout drawer;
    ListView mDrawerList;
    WebView wv;
    String url = "file:///android_asset/" + bookName + "/chapter1.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            grid_no = extras.getInt(Constant.GRID_NO);
            title = extras.getString(Constant.TITLE);
            bookName = extras.getString(Constant.BOOK_NAME);
        }

        wv = (WebView) findViewById(R.id.wvChapter);
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);
        url = "file:///android_asset/" + bookName + "/chapter1.html";
        wv.loadUrl(url);

        switch (grid_no) {
            case 1:
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.bg_chapter_1)));
                getSupportActionBar().setTitle(title);

                break;
            case 2:
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.bg_chapter_2)));
                getSupportActionBar().setTitle(title);

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


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.lv_right_drawer);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.custom_textview, getChapterNames(title)));

        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                url = "file:///android_asset/" + bookName + "/chapter" + (position + 1) + ".html";
                wv.loadUrl(url);

                if (drawer.isDrawerOpen(Gravity.RIGHT)) {
                    drawer.closeDrawer(Gravity.RIGHT);
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_chapter_right_side_drawer, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item != null && item.getItemId() == R.id.menu_chapter) {
            if (drawer.isDrawerOpen(Gravity.RIGHT)) {
                drawer.closeDrawer(Gravity.RIGHT);
            } else {
                drawer.openDrawer(Gravity.RIGHT);
            }
            return true;
        }
        return false;
    }

    private String[] getChapterNames(String title) {
        if (title.equals(getResources().getString(R.string.chapter_name_1)))
            return getResources().getStringArray(R.array.physics1);
        else if (title.equals(getResources().getString(R.string.chapter_name_2)))
            return getResources().getStringArray(R.array.physics2);
        else if (title.equals(getResources().getString(R.string.chapter_name_3)))
            return getResources().getStringArray(R.array.chemistry1);
        if (title.equals(getResources().getString(R.string.chapter_name_4)))
            return getResources().getStringArray(R.array.chemistry2);
        if (title.equals(getResources().getString(R.string.chapter_name_5)))
            return getResources().getStringArray(R.array.math1);

        return getResources().getStringArray(R.array.math2);
    }

}
