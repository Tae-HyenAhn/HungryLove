package me.hungrylove.hungryloveproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.os.CancellationSignal;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ViewPager bookPager;

    private TextView menuText;
    private LinearLayout menuArea;

    private View.OnClickListener menuClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        bookPager = (ViewPager) findViewById(R.id.main_pager);
        bookPager.setAdapter(new BookPageAdapter(getSupportFragmentManager()));
        bookPager.setCurrentItem(getIntent().getExtras().getInt(getResources().getString(R.string.intent_page_no)));

        menuText = (TextView) findViewById(R.id.main_menu_txt);
        menuText.setTypeface(Typeface.createFromAsset(getAssets(), getResources().getString(R.string.typeface_name)));
        menuArea = (LinearLayout) findViewById(R.id.main_menu_area);
        menuArea.setEnabled(true);
        menuArea.setClickable(true);
        menuArea.setOnClickListener(menuClickListener);
    }

    @Override
    protected void onDestroy() {
        Log.d("NOW_PAGE", "pn: "+bookPager.getCurrentItem());
        saveCurrentPage(bookPager.getCurrentItem());
        super.onDestroy();
    }

    /**
     * 종료했을 때의 페이지 넘버를 저장한다
     * @param page 종료 당시 보던 페이지 넘버
     */
    private void saveCurrentPage(int page){
        if(bookPager != null){
            SharedPreferences pref = getSharedPreferences(getResources().getString(R.string.pref_key), MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putInt(getResources().getString(R.string.page_no), page);
            editor.commit();
        }
    }
}
