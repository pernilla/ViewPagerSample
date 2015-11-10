package com.appease.viewpagersample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by pernilla on 10/11/15.
 */

public class ItemPageFragment extends Fragment {

    private Item item;

    public ItemPageFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        item  = new Item(arguments.getString(ItemPagerAdapter.ITEM_HEADER_ARG), arguments.getInt(ItemPagerAdapter.ITEM_IMAGE_ARG));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.content_main_item, container, false);

        ImageView imageView = (ImageView)rootView.findViewById(R.id.background_color);
        TextView textView = (TextView)rootView.findViewById(R.id.page_header);

        imageView.setBackgroundResource(item.getImageResourceId());
        textView.setText(item.getHeader());
        return rootView;
    }
}
