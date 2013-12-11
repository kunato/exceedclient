package com.kunat.exceedvoteclient.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import com.kunat.exceedvoteclient.R;
import com.kunat.exceedvoteclient.R.id;
import com.kunat.exceedvoteclient.R.layout;
import com.kunat.exceedvoteclient.R.menu;
import com.kunat.exceedvoteclient.adapter.VotePageAdapter;
import com.kunat.exceedvoteclient.application.ExceedVoteApp;
import com.kunat.exceedvoteclient.fragment.VotePageFragment;
import com.kunat.exceedvoteclient.model.Contestant;
import com.kunat.exceedvoteclient.model.ContestantList;
import com.kunat.exceedvoteclient.model.Criterion;
import com.kunat.exceedvoteclient.model.CriterionList;
	
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

public class VoteActivity extends FragmentActivity implements MyActivity{

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
	int total = 10;

	private ArrayList<VotePageFragment> fragments;

	private ArrayList<Contestant> data;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		setContentView(R.layout.activity_vote);
		
		String header = intent.getStringExtra("key");
		setTitle(header);
		ExceedVoteApp app = (ExceedVoteApp) getApplication();
		app.request("contestant", this);
		

	}
	//TODO
	public void valueChange(){
		int sum = 0;
		for(VotePageFragment i : fragments){
			sum += i.getValue();
		}
		for(VotePageFragment i : fragments){
			i.setLeft(total - sum);
			if(i.getView() != null) {
				i.updateDisplay(); // do what updates are required
	         }
		}
		
	}
	//TODO
	public void saveVote(){
		Log.d("VoteActivty","voteSave click");
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
	@Override
	public void onCallBack(String result) {
		Log.d("TAG", result);
		Serializer serializer = new Persister();
        ContestantList c = null;
		try {
			c = serializer.read(ContestantList.class, result);
		
        
		} catch (Exception e) {
			Log.d("ERROR",e.getMessage());
			e.printStackTrace();
		}
		fragments = new ArrayList<VotePageFragment>();
		data = new ArrayList<Contestant>();
		for(Contestant i : c.getContestantList()){
        	data.add(i);
        	fragments.add(VotePageFragment.newInstance(this,total,i.name,i.description));
    	}
		
		
		
		mSectionsPagerAdapter = new VotePageAdapter(getSupportFragmentManager(), fragments);
		
		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		mViewPager.setOffscreenPageLimit(0);
		
	}

}
