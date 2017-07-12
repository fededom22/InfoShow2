package com.fededom.infoshow.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.fededom.infoshow.Fragments.CalendarFragment;
import com.fededom.infoshow.Fragments.DestacadoFragment;
import com.fededom.infoshow.Fragments.FragmentRefresher;
import com.fededom.infoshow.Genre;
import com.fededom.infoshow.R;

import java.util.ArrayList;
import java.util.List;

public class TabAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;

    String tabTitles[] = new String[]{"1", "2"};
    Context context;

    public TabAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        fragmentList = new ArrayList<>();
        fragmentList.add(new DestacadoFragment());
        fragmentList.add(new CalendarFragment());
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }


    @Override
    public CharSequence getPageTitle(int position){
        return tabTitles[position];
    }


    public View getTabView(int position){
        View tab = LayoutInflater.from(this.context).inflate(R.layout.tab_layout, null);
        ImageView tv = (ImageView) tab.findViewById(R.id.tab_name);
        if (position == 0)
           tv.setImageResource(R.mipmap.ic_star);
        else
            tv.setImageResource(R.mipmap.ic_calendar);

        return tab;
    }


    public void pageSelected(Genre genre) {
        for (Fragment fragment : fragmentList) {
            FragmentRefresher fr = (FragmentRefresher) fragment;
            fr.updateUI(genre);
        }
    }
}