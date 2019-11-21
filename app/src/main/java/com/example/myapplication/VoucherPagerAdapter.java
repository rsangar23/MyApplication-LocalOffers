package com.example.myapplication;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.API.Example;

import java.util.ArrayList;

public class VoucherPagerAdapter extends PagerAdapter {
    private ArrayList<Example> examples;
    LayoutInflater layoutInflater;
    Context context;

    public VoucherPagerAdapter(ArrayList<Example> examples, Context context) {
        this.examples = examples;
        this.context = context;
    }

    @Override
    public int getCount() {
        return examples.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.voucher_item, container, false);

        TextView textView, textView1;

        textView = view.findViewById(R.id.vc_vtxt);
        textView1 = view.findViewById(R.id.vc_vamt);

        Example example = examples.get(position);

        textView.setText(example.getVtxt());
        textView1.setText(example.getVamt());

        container.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}

