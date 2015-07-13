package com.ljaymori.photogallary.main;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class MainPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<TabParentFragment> items = new ArrayList<TabParentFragment>();

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setInitPages(ArrayList<TabParentFragment> list) {
        items.addAll(list);
    }

    @Override
    public int getItemPosition(Object object) {
        return items.indexOf(object);
    }

    @Override
    public TabParentFragment getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getCount() {
        return items.size();
    }
}
