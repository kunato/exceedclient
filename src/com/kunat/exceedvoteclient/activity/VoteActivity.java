package com.kunat.exceedvoteclient.activity;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import com.kunat.exceedvoteclient.R;
import com.kunat.exceedvoteclient.adapter.VotePageAdapter;
import com.kunat.exceedvoteclient.application.ExceedVoteApp;
import com.kunat.exceedvoteclient.fragment.VotePageFragment;
import com.kunat.exceedvoteclient.model.Ballot;
import com.kunat.exceedvoteclient.model.Contestant;
import com.kunat.exceedvoteclient.model.ContestantList;
import com.kunat.exceedvoteclient.model.ScoreCard;
import com.kunat.exceedvoteclient.model.Vote;
	
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

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
	private int criteriaId;
	private int type;
	int total = 10;

	private ArrayList<VotePageFragment> fragments;

	private ArrayList<Contestant> data;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		setContentView(R.layout.activity_vote);
		criteriaId = intent.getIntExtra("id", 0);
		type = intent.getIntExtra("type", -1);
		if(type == 1){
			total = 1;
		}
		
		Log.d("type",type+"");
		String header = intent.getStringExtra("key");
		setTitle(header);
		ExceedVoteApp app = (ExceedVoteApp) getApplication();
		app.request("contestant", this);
		

	}
	public void valueChange(){
		if(type == 2){
			return;
		}
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
	public void saveVote(){
		Log.d("Vote","to "+criteriaId);
		Serializer serializer = new Persister();
		Ballot ballot = new Ballot();
		for(VotePageFragment i : fragments){
			ScoreCard sc = new ScoreCard(i.getPageId(),i.getValue());
			ballot.addScoreCard(sc);
		}
		Vote vote = new Vote(ballot);
		String result = "";
		OutputStream output = new OutputStream()
	    {
	        private StringBuilder string = new StringBuilder();
	        @Override
	        public void write(int b) throws IOException {
	            this.string.append((char) b );
	        }

	        
	        public String toString(){
	            return this.string.toString();
	        }
	    };
		try {
			serializer.write(vote, output);
			result = output.toString();
			Log.d("Vote",result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ExceedVoteApp app = (ExceedVoteApp) getApplication();
		app.vote(criteriaId+"/vote", this, result);
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
        	fragments.add(VotePageFragment.newInstance(this,total,i.name,i.description,i.id));
        	Log.d("VoteA",i.id+"");
    	}
		
		
		
		mSectionsPagerAdapter = new VotePageAdapter(getSupportFragmentManager(), fragments);
		
		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		mViewPager.setOffscreenPageLimit(0);
		
	}
	public void onVoteFinish(String result){
		Log.d("Vote",result);
		if(!result.equals("error")){
			Toast.makeText(getApplicationContext(),"Vote finished", Toast.LENGTH_LONG).show();
			finish();
		}
		else{
			Toast.makeText(getApplicationContext(), "Something wrong please try again", Toast.LENGTH_LONG).show();
		}
	}

}
