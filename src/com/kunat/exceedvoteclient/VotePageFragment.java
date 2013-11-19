package com.kunat.exceedvoteclient;

import java.util.Observable;
import java.util.Observer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;

public class VotePageFragment extends Fragment implements Observer{

	 public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";

	 

	 public static final VotePageFragment newInstance(String message)

	 {
	
	   VotePageFragment f = new VotePageFragment();

	   Bundle bdl = new Bundle(1);

	   bdl.putString(EXTRA_MESSAGE, message);

	   f.setArguments(bdl);
	   return f;

	 }



	private NumberPicker np;

	 

	 @Override

	 public View onCreateView(LayoutInflater inflater, ViewGroup container,

	   Bundle savedInstanceState) {

	   String message = getArguments().getString(EXTRA_MESSAGE);

	   View v = inflater.inflate(R.layout.fragment_vote, container, false);
	   np = (NumberPicker) v.findViewById(R.id.numberPicker);
	   np.setMaxValue(10);
	   return v;

	 }



	@Override
	public void update(Observable observable, Object data) {
		np.setMaxValue(10);
		
	}

	}

