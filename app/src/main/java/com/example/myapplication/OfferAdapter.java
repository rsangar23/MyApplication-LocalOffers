package com.example.myapplication;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.myapplication.API.HeadingBanner;

import java.util.ArrayList;

public class OfferAdapter extends PagerAdapter {

    private ArrayList<HeadingBanner> headingBanners;
    private LayoutInflater layoutInflater;
    private Context context;

    public OfferAdapter(ArrayList<HeadingBanner> headingBanners, Context context) {
        this.headingBanners = headingBanners;
        this.context = context;
    }

    @Override
    public int getCount() {
        return headingBanners.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.offer_item, container, false);

        ImageView imageView;

        imageView = view.findViewById(R.id.off_img);
//        imageView.setImageResource(headingBanners.get(position).getImage());

        HeadingBanner headingBanner = headingBanners.get(position);

        Glide.with(context)
                .load(headingBanner.getImgs())
                .into(imageView);

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
