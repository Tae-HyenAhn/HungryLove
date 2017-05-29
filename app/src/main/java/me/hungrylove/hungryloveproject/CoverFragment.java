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

public class CoverFragment extends Fragment {

    private TextView bookTitle, author;
    private Typeface typeface;

    public CoverFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cover, null);
        init(v);

        return v;
    }

    private void init(View v){
        bookTitle = (TextView) v.findViewById(R.id.cover_title);
        author = (TextView) v.findViewById(R.id.cover_author);
        bookTitle.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), getResources().getString(R.string.typeface_name)));
        author.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), getResources().getString(R.string.typeface_name)));
    }

}
