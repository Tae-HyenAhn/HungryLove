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

public class PageFragment extends Fragment {

    private TextView title, content, pageNo;

    private Book page;

    public PageFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_page, null);

        init(v);
        return v;
    }

    private void init(View v){
        title = (TextView) v.findViewById(R.id.page_title);
        content = (TextView) v.findViewById(R.id.page_content);
        pageNo = (TextView) v.findViewById(R.id.page_no);
        title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), getResources().getString(R.string.typeface_name)));
        content.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), getResources().getString(R.string.typeface_name)));
        pageNo.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), getResources().getString(R.string.typeface_name)));
        page = getBundleData();
        updateUI();
    }

    private void updateUI(){
        if(page != null){
            title.setText(page.getTitle());
            content.setText(page.getContent());
            pageNo.setText(Integer.toString(page.getPageNum()));
        }
    }

    private Book getBundleData(){
        int index = getArguments().getInt("page");
        return BookData.getInstance().getArrayList().get(index);
    }


}
