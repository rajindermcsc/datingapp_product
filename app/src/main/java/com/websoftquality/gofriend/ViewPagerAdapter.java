package com.websoftquality.gofriend;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] fragments;


    public ViewPagerAdapter(FragmentManager fm){
        super(fm);

        fragments= new Fragment[]{
//            new Chats(),
//            new Calls(),
//            new Contacts()
        };
    }

    @Override
    public Fragment getItem(int i) {
        return fragments[i];
    }

    @Override
    public int getCount() {
        return fragments.length;//3
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        String title = getItem(position).getClass().getName();

        return title.subSequence(title.lastIndexOf(".")+1,title.length());
    }
}
