package com.kunat.exceedvoteclient.activity;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import com.kunat.exceedvoteclient.R;
import com.kunat.exceedvoteclient.R.id;
import com.kunat.exceedvoteclient.R.layout;
import com.kunat.exceedvoteclient.R.menu;
import com.kunat.exceedvoteclient.adapter.CriteriaListAdapter;
import com.kunat.exceedvoteclient.model.Criterion;
import com.kunat.exceedvoteclient.model.CriterionList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class HistoryActivity extends Activity implements MyActivity{
	ListView listView;
	List<Criterion> data;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_history);
		setTitle("History");
		
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
				Intent myIntent = new Intent(HistoryActivity.this, VoteActivity.class);
				myIntent.putExtra("name", data.get(position).name); 
				//myIntent.putExtra("score", data.get(position).value);
				HistoryActivity.this.startActivity(myIntent);
				
			}
		});
		
	}

}
