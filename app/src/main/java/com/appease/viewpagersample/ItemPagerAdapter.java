package com.appease.viewpagersample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pernilla on 10/11/15.
 */

public class ItemPagerAdapter extends FragmentStatePagerAdapter {
    public static final String ITEM_HEADER_ARG = "item_image_args";
    public static final String ITEM_IMAGE_ARG = "item_image_args";
    private final List<Item> items;

    public ItemPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.items = new ArrayList<>();
    }

    public void setItems(List<Item> bookModels) {
        items.clear();
        items.addAll(bookModels);
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        Item item = items.get(position);
        Fragment fragment = new ItemPageFragment();
        Bundle args = new Bundle();
        args.putString(ITEM_HEADER_ARG, item.getHeader());
        args.putInt(ITEM_HEADER_ARG, item.getImageResourceId());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        if(items != null)
            return items.size();

        return 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "•";
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
