package com.kunat.exceedvoteclient;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class VotePageFragment extends Fragment {

	 public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";

	 

	 public static final VotePageFragment newInstance(String message)

	 {

	   VotePageFragment f = new VotePageFragment();

	   Bundle bdl = new Bundle(1);

	   bdl.putString(EXTRA_MESSAGE, message);

	   f.setArguments(bdl);

	   return f;

	 }

	 

	 @Override

	 public View onCreateView(LayoutInflater inflater, ViewGroup container,

	   Bundle savedInstanceState) {

	   String message = getArguments().getString(EXTRA_MESSAGE);

	   View v = inflater.inflate(R.layout.fragment_vote, container, false);
	   
	   return v;

	 }

	}

