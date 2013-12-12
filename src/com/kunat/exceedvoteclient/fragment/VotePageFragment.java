package com.kunat.exceedvoteclient.fragment;

import com.kunat.exceedvoteclient.R;
import com.kunat.exceedvoteclient.activity.VoteActivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.NumberPicker.OnValueChangeListener;
/**
 * Fragment for VoteActivity
 * @author Kunat Pipatanakul
 *
 */
public class VotePageFragment extends Fragment{

	 public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
	 public static final String NAME ="NAME";
	 public static final String DESCRIPTION = "DES";
	 public static final String ID = "ID";
	 private VoteActivity voteActivity;
	 private int value;
	 private NumberPicker np;
	 private int left;
	 private TextView title;
	 private TextView des;
	 private int pageId;
	 
	 public static final VotePageFragment newInstance(VoteActivity voteActivity,int total,String name,String description,int id)

	 {
	
	   VotePageFragment f = new VotePageFragment();
	   f.voteActivity = voteActivity;
	   f.left = total;
	   Bundle bdl = new Bundle(1);
	   f.pageId = id;
	   bdl.putString(NAME, name);
	   bdl.putString(DESCRIPTION, description);
	   f.setArguments(bdl);
	   return f;

	 }


	 public int getValue(){
		 return value;
	 }
	 
	 public void setLeft(int left){
		 this.left = left;
	 }
	 

	 @Override

	 public View onCreateView(LayoutInflater inflater, ViewGroup container,

	   Bundle savedInstanceState) {
	   String name = getArguments().getString(NAME);
	   String description = getArguments().getString(DESCRIPTION);
	   Log.d("Fragment",pageId+"");
	   View v = inflater.inflate(R.layout.fragment_vote, container, false);
	   title = (TextView) v.findViewById(R.id.titleText);
	   des = (TextView) v.findViewById(R.id.desText);
	   title.setText(name);
	   des.setText(description);
	   np = (NumberPicker) v.findViewById(R.id.numberPicker);
	   np.setMaxValue(value+left);
	   np.setValue(value);
	   np.setOnValueChangedListener(new OnValueChangeListener() {
		
		@Override
		public void onValueChange(NumberPicker arg0, int arg1, int arg2) {
			value = arg2;
			voteActivity.valueChange();
		}
	   });
	   return v;

	 }
	 public void updateDisplay(){
		 np.setValue(value);
		 np.setMaxValue(value+left);
	 }
	 public int getPageId(){
		 return pageId;
	 }


	}

