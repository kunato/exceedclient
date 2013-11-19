package com.kunat.exceedvoteclient;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class VotePageAdapter extends FragmentPagerAdapter {

  private List<VotePageFragment> fragments;


  public VotePageAdapter(FragmentManager fm, List<VotePageFragment> fragments2) {

    super(fm);

    this.fragments = fragments2;

  }

  @Override 

  public Fragment getItem(int position) {

    return this.fragments.get(position);

  }


  @Override

  public int getCount() {

    return this.fragments.size();

  }

}

