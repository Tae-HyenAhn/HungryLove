package me.hungrylove.hungryloveproject;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout closeArea;
    private TextView close, purchase, share, insta, getBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        init();
    }

    private void init(){
        closeArea = (LinearLayout) findViewById(R.id.menu_close_area);
        closeArea.setClickable(true);
        closeArea.setOnClickListener(this);

        close = (TextView) findViewById(R.id.menu_close_text);
        close.setTypeface(Typeface.createFromAsset(getAssets(), getResources().getString(R.string.typeface_name)));


        purchase = (TextView) findViewById(R.id.menu_purchase);
        purchase.setTypeface(Typeface.createFromAsset(getAssets(), getResources().getString(R.string.typeface_name)));
        purchase.setClickable(true);
        purchase.setOnClickListener(this);

        share = (TextView) findViewById(R.id.menu_share);
        share.setTypeface(Typeface.createFromAsset(getAssets(), getResources().getString(R.string.typeface_name)));
        share.setClickable(true);
        share.setOnClickListener(this);

        insta = (TextView) findViewById(R.id.menu_author_page);
        insta.setTypeface(Typeface.createFromAsset(getAssets(), getResources().getString(R.string.typeface_name)));
        insta.setClickable(true);
        insta.setOnClickListener(this);

        getBooks = (TextView) findViewById(R.id.menu_get_books);
        getBooks.setTypeface(Typeface.createFromAsset(getAssets(), getResources().getString(R.string.typeface_name)));
        getBooks.setClickable(true);
        getBooks.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.menu_close_area:
                finish();
                break;
            case R.id.menu_purchase:
                goPurchasePage();
                break;
            case R.id.menu_author_page:
                goAuthorPage();
                break;
            case R.id.menu_share:
                shareSNS();
                break;
            case R.id.menu_get_books:
                sendEmailForGetBooks();
                break;

        }
    }

    private void shareSNS(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "'사랑에 휘청여도 배는 고프다 - 안승현 독립 출판 시집' -" +
                " https://play.google.com/store/apps/details?id=me.hungrylove.hungryloveproject");
        startActivity(Intent.createChooser(intent, "공유하기"));
    }

    private void goPurchasePage(){
        Uri uri = Uri.parse("http://storefarm.naver.com/proustbook/products/666501080");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void goAuthorPage(){
        Uri uri = Uri.parse("https://www.instagram.com/ahnseong_poem/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void sendEmailForGetBooks(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"qq558@naver.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "[입고문의 합니다]");
        startActivity(Intent.createChooser(intent, "입고문의 메일 보내기"));
    }
}
