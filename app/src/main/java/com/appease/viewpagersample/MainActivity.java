package com.appease.viewpagersample;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ItemPagerAdapter pagerAdapter;
    private List<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        initializeItems();

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setPageTransformer(false, new CustomPageTransformer());
        pagerAdapter = new ItemPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(1);

        pagerAdapter.setItems(items);
    }

    private void initializeItems() {
        items = new ArrayList<>();
        items.add(new Item("PAGE BLUE", R.drawable.blue));
        items.add(new Item("PAGE GREEN", R.drawable.green));
        items.add(new Item("PAGE LIGHT GREEN", R.drawable.lightgreen));
        items.add(new Item("PAGE RED", R.drawable.red));
        items.add(new Item("PAGE TURQUOISE", R.drawable.turqoise));
    }

    public class CustomPageTransformer implements ViewPager.PageTransformer {

        public static final float ALPHA_VALUE = 0.8f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            View backgroundImageView = view.findViewById(R.id.background_color);

            View contentView1 = view.findViewById(R.id.item_container);

            if (position < -1) {
                // This page is way off-screen to the left
            } else if (position <= 0) { // [-1,0]
                // This page is moving out to the left

                if (backgroundImageView != null) {
                    // Fade the image in
                    backgroundImageView.setAlpha(ALPHA_VALUE + position);
                }

                // But swipe the contentView
                swipeContent(position, pageWidth, contentView1);

                // Counteract the default swipe
                view.setTranslationX(pageWidth * -position);

            } else if (position <= 1) { // (0,1]
                // This page is moving in from the right

                // Counteract the default swipe
                view.setTranslationX(pageWidth * -position);

                swipeContent(position, pageWidth, contentView1);

                if (backgroundImageView != null) {
                    // Fade the image out
                    backgroundImageView.setAlpha(ALPHA_VALUE - position);
                }

            } else {
                // This page is way off-screen to the right
            }

            contentView1.bringToFront();
        }

        private void swipeContent(float position, int pageWidth, View view) {
            if (view != null) {
                view.setTranslationX(pageWidth * position);
            }
        }
    }
}
