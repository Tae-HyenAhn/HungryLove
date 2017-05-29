package me.hungrylove.hungryloveproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import me.hungrylove.hungryloveproject.kotlin.BookJsonParser;


public class SplashActivity extends AppCompatActivity {

    private ImageView loading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading.setVisibility(View.VISIBLE);
            }

            @Override
            protected Void doInBackground(Void... params) {

                //Kotlin 버전
                BookJsonParser.INSTANCE.bookJsonParse(getApplicationContext(), BookData.getInstance().getArrayList());

                //Java 버전
                /*
                AssetManager assetManager = getResources().getAssets();

                try{
                    AssetManager.AssetInputStream ais = (AssetManager.AssetInputStream) assetManager.open("json/hungry_love01.json");
                    BufferedReader br = new BufferedReader(new InputStreamReader(ais));

                    StringBuilder sb = new StringBuilder();
                    String str="";
                    while((str = br.readLine())!=null){
                        sb.append(str);
                    }

                    String res = sb.toString();
                    Log.d("TAG", res);
                    try{
                        JSONArray jarray = new JSONArray(res);
                        for(int i=0; i< jarray.length(); i++){
                            JSONObject jObject = jarray.getJSONObject(i);
                            BookData.getInstance().getArrayList().add(new Book(jObject.getInt("page_num"), jObject.getString("boo_title"),
                                    jObject.getString("author"), jObject.getString("intro"), jObject.getString("title"), jObject.getString("content")));
                        }
                    } catch(JSONException e){
                        e.printStackTrace();
                    }

                } catch (IOException e){
                    e.printStackTrace();
                }
                */

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                loading.setVisibility(View.INVISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                final int loadedPageNo = getCurrentPage();
                                if(loadedPageNo > 1 && loadedPageNo < 60){
                                    AlertDialog.Builder continueDialogBuilder = new AlertDialog.Builder(SplashActivity.this);
                                    continueDialogBuilder.
                                            setMessage(getResources().getString(R.string.dialog_title))
                                            .setCancelable(false)
                                            .setPositiveButton(getResources().getString(R.string.dialog_first), new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                                    intent.putExtra(getResources().getString(R.string.intent_page_no), 0);
                                                    startActivity(intent);
                                                    dialog.dismiss();
                                                    finish();
                                                }
                                            })
                                            .setNegativeButton(getResources().getString(R.string.dialog_continue), new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                                    intent.putExtra(getResources().getString(R.string.intent_page_no), loadedPageNo);
                                                    startActivity(intent);
                                                    dialog.dismiss();
                                                    finish();
                                                }
                                            });

                                    AlertDialog alertDialog = continueDialogBuilder.create();
                                    alertDialog.show();

                                }else{
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    intent.putExtra(getResources().getString(R.string.intent_page_no), 0);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });
                    }
                }, 1000);
            }
        }.execute();
    }

    private void init(){
        //Fabric init..
        Fabric.with(this, new Crashlytics());
        loading = (ImageView) findViewById(R.id.splash_laoding);
        Glide.with(this).load(R.raw.splash_loading).into(loading);
        BookData.getInstance().getArrayList().clear();
    }

    /**
     * 종료 했을 당시의 페이지를 다시 불러온다
     * @return
     */
    private int getCurrentPage(){
        SharedPreferences pref = getSharedPreferences(getResources().getString(R.string.pref_key), MODE_PRIVATE);
        return pref.getInt(getResources().getString(R.string.page_no), 0);
    }




}
