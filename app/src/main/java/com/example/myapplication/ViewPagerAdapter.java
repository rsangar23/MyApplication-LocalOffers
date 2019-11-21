package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

//    private ArrayList<Category> categories;
//    private Context context;

    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> stringList = new ArrayList<>();
//    ModelAdapter modelAdapter;


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }


//    public ViewPagerAdapter(FragmentManager fm, ArrayList<Category> categories, Context context) {
//        super(fm);
//        this.categories = categories;
//        this.context = context;
//    }

    @Override
    public Fragment getItem(int i) {

        return fragmentList.get(i);

//        switch (i){
//            case 0:
////                fragment = new NewOfferFragment();
////                bundle = new Bundle();
////                bundle.putInt("position", position);
////                fragment.setArguments(bundle);
//                return new MyFragment();
//
//            case 1:
////                fragment1 = new FoodFragment();
////                bundle = new Bundle();
////                bundle.putInt("position", position);
////                fragment1.setArguments(bundle);
//                return new FragmentStore();
//
//            case 2:
//
//                return new FragmentExplore();
//
//            default :
//                return new MyFragment();
//
//
//        }

    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return stringList.get(position);

//        return categories.get(position).getCName();
    }
//    @Nullable
//    @Override
//    public CharSequence getPageTitle(int position) {
//        switch (position) {
//            case 0:
//                return "New Offers";
//            case 1:
//                return "Food & Drinks";
//            case 2:
//                return "Clothing & Fashions";
//        }
//
//        return null;
//    }


    public void AddFragment(Fragment fragment, String title){
        fragmentList.add(fragment);
        stringList.add(title);
    }
}
