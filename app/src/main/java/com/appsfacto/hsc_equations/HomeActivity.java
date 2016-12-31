package com.appsfacto.hsc_equations;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.appsfacto.hsc_equations.helper.Constant;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tvChapterName_1, tvChapterName_2,tvChapterName_3,tvChapterName_4,tvChapterName_5,tvChapterName_6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_action_circle_icon);
        getSupportActionBar().setTitle(getResources().getString(R.string.home_title));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.bg_chapter_3)));

        View grid_1 = findViewById(R.id.grid_1);
        grid_1.setOnClickListener(this);
        tvChapterName_1 = (TextView)grid_1.findViewById(R.id.tv_chapter_name);
        tvChapterName_1.setText(getResources().getString(R.string.chapter_name_1));
        grid_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.selector_physics_1));


        View grid_2 = findViewById(R.id.grid_2);
        grid_2.setOnClickListener(this);
        tvChapterName_2 = (TextView)grid_2.findViewById(R.id.tv_chapter_name);
        tvChapterName_2.setText(getResources().getString(R.string.chapter_name_2));
        grid_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.selector_physics_2));


        View grid_3 = findViewById(R.id.grid_3);
        grid_3.setOnClickListener(this);
        tvChapterName_3 = (TextView)grid_3.findViewById(R.id.tv_chapter_name);
        tvChapterName_3.setText(getResources().getString(R.string.chapter_name_3));
        grid_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.selector_chemistry_1));


        View grid_4 = findViewById(R.id.grid_4);
        grid_4.setOnClickListener(this);
        tvChapterName_4 = (TextView)grid_4.findViewById(R.id.tv_chapter_name);
        tvChapterName_4.setText(getResources().getString(R.string.chapter_name_4));
        grid_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.selector_chemistry_2));


        View grid_5 = findViewById(R.id.grid_5);
        grid_5.setOnClickListener(this);
        tvChapterName_5 = (TextView)grid_5.findViewById(R.id.tv_chapter_name);
        tvChapterName_5.setText(getResources().getString(R.string.chapter_name_5));
        grid_5.setBackgroundDrawable(getResources().getDrawable(R.drawable.selector_math_1));


        View grid_6 = findViewById(R.id.grid_6);
        grid_6.setOnClickListener(this);
        tvChapterName_6 = (TextView)grid_6.findViewById(R.id.tv_chapter_name);
        tvChapterName_6.setText(getResources().getString(R.string.chapter_name_6));
        grid_6.setBackgroundDrawable(getResources().getDrawable(R.drawable.selector_math_2));





    }


    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.grid_1:
                i = new Intent(this, ChapterActivity.class);
                i.putExtra(Constant.GRID_NO, 1);
                i.putExtra(Constant.TITLE, getResources().getString(R.string.chapter_name_1));
                i.putExtra(Constant.BOOK_NAME, "physics1");
                startActivity(i);
                break;

            case R.id.grid_2:
                i = new Intent(this, ChapterActivity.class);
                i.putExtra(Constant.GRID_NO, 2);
                i.putExtra(Constant.TITLE,getResources().getString(R.string.chapter_name_2));
                i.putExtra(Constant.BOOK_NAME, "physics2");
                startActivity(i);
                break;

            case R.id.grid_3:
                i = new Intent(this, ChapterActivity.class);
                i.putExtra(Constant.GRID_NO, 3);
                i.putExtra(Constant.TITLE,getResources().getString(R.string.chapter_name_3));
                i.putExtra(Constant.BOOK_NAME, "chemistry1");
                startActivity(i);
                break;

            case R.id.grid_4:
                i = new Intent(this, ChapterActivity.class);
                i.putExtra(Constant.GRID_NO, 4);
                i.putExtra(Constant.TITLE,getResources().getString(R.string.chapter_name_4));
                i.putExtra(Constant.BOOK_NAME, "chemistry2");
                startActivity(i);
                break;

            case R.id.grid_5:
                i = new Intent(this, ChapterActivity.class);
                i.putExtra(Constant.GRID_NO, 5);
                i.putExtra(Constant.TITLE,getResources().getString(R.string.chapter_name_5));
                i.putExtra(Constant.BOOK_NAME, "math1");
                startActivity(i);
                break;

            case R.id.grid_6:
                i = new Intent(this, ChapterActivity.class);
                i.putExtra(Constant.GRID_NO, 6);
                i.putExtra(Constant.TITLE,getResources().getString(R.string.chapter_name_6));
                i.putExtra(Constant.BOOK_NAME, "math2");
                startActivity(i);
                break;

            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menu_id = item.getItemId();
        switch (menu_id) {
            case R.id.action_about:
                startActivity(new Intent(HomeActivity.this, AboutActivity.class));
                break;
            default:
                break;
        }
        return true;
    }
}
