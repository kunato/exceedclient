package com.kunat.exceedvoteclient.activity;

import java.util.ArrayList;
import java.util.List;

import com.kunat.exceedvoteclient.R;
import com.kunat.exceedvoteclient.adapter.HistoryListAdapter;
import com.kunat.exceedvoteclient.application.ExceedVoteApp;
import com.kunat.exceedvoteclient.model.MyVote;
import com.kunat.exceedvoteclient.model.VoteHistory;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;
/**
 * HistoryActivity is a activity of history page.
 * @author Kunat Pipatanakul
 *
 */
public class HistoryActivity extends Activity implements MyActivity{
	ListView listView;
	List<VoteHistory> data;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_history);
		setTitle("History");
		ExceedVoteApp app = (ExceedVoteApp) getApplication();
		app.request("myvote", this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onCallBack(String result) {
		listView = (ListView) findViewById(R.id.listView1);
		data = new ArrayList<VoteHistory>();
		Log.d("HIS",result);
        MyVote c = ((ExceedVoteApp)getApplication()).getMyVoteFromString(result);
		
		for(VoteHistory v : c.ballot.voteHistories()){
			data.add(v);
			Log.d("TEST",v.voteCriterionHistory.id+"");
		}
		listView.setAdapter(new HistoryListAdapter(getApplicationContext(),R.layout.criteria_list_row, data));
		/**
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent myIntent = new Intent(HistoryActivity.this, VoteActivity.class);
				myIntent.putExtra("name", data.get(position).voteCriterionHistory.id); 
				HistoryActivity.this.startActivity(myIntent);
				
			}
		});
		*/
		
	}

}
