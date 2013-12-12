package com.kunat.exceedvoteclient.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.kunat.exceedvoteclient.R;
import com.kunat.exceedvoteclient.adapter.CriteriaListAdapter;
import com.kunat.exceedvoteclient.application.ExceedVoteApp;
import com.kunat.exceedvoteclient.model.Criterion;
import com.kunat.exceedvoteclient.model.CriterionList;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
/**
 * MainActivity is a activity that user choose the criteria to vote on.
 * @author Kunat Pipatanakul
 *
 */
public class MainActivity extends Activity implements MyActivity{
	ListView listView;
	List<Criterion> data;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ExceedVoteApp app = (ExceedVoteApp) getApplication();
		Log.d("TAG", app.getUser().toString());
		setContentView(R.layout.activity_main);
		setTitle("Choose Criteria");
		app.request("criterion", this);
	}
	@Override
	public void onCallBack(String result) {
		Log.d("TAG", result);
		Serializer serializer = new Persister();
        CriterionList c = null;
		try {
			c = serializer.read(CriterionList.class, result);
		
        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listView = (ListView) findViewById(R.id.listView1);
		//TODO convert result to Criterion
		data = new ArrayList<Criterion>();
		for(Criterion i : c.getCriterions()){
        	data.add(i);
        }
		listView.setAdapter(new CriteriaListAdapter(getApplicationContext(),R.layout.criteria_list_row, data));
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent myIntent = new Intent(MainActivity.this, VoteActivity.class);
				myIntent.putExtra("name", data.get(position).name); 
				myIntent.putExtra("id", data.get(position).id);
				myIntent.putExtra("type", data.get(position).type);
				MainActivity.this.startActivity(myIntent);
				
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main_activity_actionbar, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	public void openHistory(){
		Intent myIntent = new Intent(MainActivity.this, HistoryActivity.class);
		MainActivity.this.startActivity(myIntent);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_history:
	            openHistory();
	            return true;
	        
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	

}
