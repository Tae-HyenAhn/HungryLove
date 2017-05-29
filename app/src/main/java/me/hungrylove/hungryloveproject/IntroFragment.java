package me.hungrylove.hungryloveproject;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Taehyen on 2017-04-27.
 */

public class IntroFragment extends Fragment {

    private TextView introTv, pageNo;

    public IntroFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_intro, null);
        init(v);
        return v;
    }

    private void init(View v){
        introTv = (TextView) v.findViewById(R.id.intro_content);
        pageNo = (TextView) v.findViewById(R.id.intro_pagenum);
        introTv.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), getResources().getString(R.string.typeface_name)));
        pageNo.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), getResources().getString(R.string.typeface_name)));
    }

}
