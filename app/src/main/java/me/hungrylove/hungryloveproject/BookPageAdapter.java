package me.hungrylove.hungryloveproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Taehyen on 2017-04-27.
 */

public class BookPageAdapter extends FragmentStatePagerAdapter {

    public BookPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                CoverFragment coverFragment = new CoverFragment();
                return coverFragment;
            case 1:
                BlankFragment blankFragment = new BlankFragment();
                return blankFragment;
            case 2:
                IntroFragment introFragment = new IntroFragment();
                return introFragment;
            case 59:
                LastPageFragment lastPageFragment = new LastPageFragment();
                return lastPageFragment;
            case 60:
                BlankFragment blankFragment1 = new BlankFragment();
                return blankFragment1;
            case 61:
                BackCoverFragment backCoverFragment = new BackCoverFragment();
                return backCoverFragment;
            default:
                PageFragment pageFragment = new PageFragment();
                Bundle bundle = new Bundle(1);
                bundle.putInt("page", position);
                pageFragment.setArguments(bundle);
                return pageFragment;
        }
    }

    @Override
    public int getCount() {
        return BookData.getInstance().getArrayList().size();
    }
}
