package com.boobapp.aristote.finalyeardissertation;

import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.FrameStats;

/**
 * Created by User on 10/16/2017.
 */

public class PageAdapter extends FragmentStatePagerAdapter {

    int NoTabs;
    public PageAdapter(FragmentManager fragmentManager, int NumberOfTabs){
        super (fragmentManager);
        this.NoTabs = NumberOfTabs;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        switch (position){
            case 0:
                Tab1 tab1 = new Tab1();
                return tab1;
            case 1:
                Tab2 tab2 = new Tab2();
                return tab2;
            case 2:
                Tab3 tab3 = new Tab3();
                return tab3;
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return 0;
    }
}
