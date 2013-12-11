package com.kunat.exceedvoteclient.fragment;

import com.kunat.exceedvoteclient.R;
import com.kunat.exceedvoteclient.R.id;
import com.kunat.exceedvoteclient.R.layout;
import com.kunat.exceedvoteclient.activity.VoteActivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;

public class VotePageFragment extends Fragment{

	 public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
	 private VoteActivity voteActivity;
	 private int value;
	 private NumberPicker np;
	 private int left;
	 
	 public static final VotePageFragment newInstance(String message,VoteActivity voteActivity,int total)

	 {
	
	   VotePageFragment f = new VotePageFragment();
	   f.voteActivity = voteActivity;
	   f.left = total;
	   Bundle bdl = new Bundle(1);

	   bdl.putString(EXTRA_MESSAGE, message);

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

	   String message = getArguments().getString(EXTRA_MESSAGE);

	   View v = inflater.inflate(R.layout.fragment_vote, container, false);
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



	}

