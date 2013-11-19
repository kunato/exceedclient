package com.kunat.exceedvoteclient;

import java.util.ArrayList;
import java.util.List;
	
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class VoteActivity extends FragmentActivity {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	VotePageAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		setContentView(R.layout.activity_vote);
		
		String header = intent.getStringExtra("key");
		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		//TODO Fragment
		List<VotePageFragment> fragments = new ArrayList<VotePageFragment>();
		fragments.add(VotePageFragment.newInstance("Project 1"));
		fragments.add(VotePageFragment.newInstance("Project 2"));
		fragments.add(VotePageFragment.newInstance("Project 3"));
		fragments.add(VotePageFragment.newInstance("Project 4"));
		fragments.add(VotePageFragment.newInstance("Project 5"));
		mSectionsPagerAdapter = new VotePageAdapter(getSupportFragmentManager(), fragments);
		setTitle(header);
		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

	}
	//TODO
	public void saveVote(){
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.vote_activity_actionbar, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_save:
	            saveVote();
	            return true;
	        
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}



}
