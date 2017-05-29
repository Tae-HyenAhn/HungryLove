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
 * Created by Taehyen on 2017-05-06.
 */

public class LastPageFragment extends Fragment {

    private TextView title;

    public LastPageFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_last_page, null);
        init(v);
        return v;
    }

    private void init(View v){
        title = (TextView) v.findViewById(R.id.last_title);
        title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), getResources().getString(R.string.typeface_name)));
    }
}
