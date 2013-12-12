package com.kunat.exceedvoteclient.adapter;

import java.util.List;

import com.kunat.exceedvoteclient.R;
import com.kunat.exceedvoteclient.model.VoteHistory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
/**
 * ArrayAdapter implementation of VoteHistory class.
 * @author Kunat Pipatanakul
 *
 */
public class HistoryListAdapter extends ArrayAdapter<VoteHistory> {
	private Context context;
	private int textViewResourceId;
	private List<VoteHistory> data;
	public HistoryListAdapter(Context context, int textViewResourceId,
			List<VoteHistory> objects) {
		super(context, textViewResourceId, objects);

		this.context = context;
		this.textViewResourceId = textViewResourceId;
		this.data = objects;
	}
	@Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(textViewResourceId, parent, false);
        //ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);
        TextView textView = (TextView) rowView.findViewById(R.id.listTextView);

        String obj = "Vote,"+data.get(position).voteContestantHistory.name+" on "+data.get(position).voteCriterionHistory.name+" for "+data.get(position).voteContestantHistory.score;
        //TODO
        //http://158.108.228.54:8080/
        //no img yet
        //String imageFile = null;
        textView.setText(obj);
        //no Image yet
        //imageView.setImageDrawable(d);
        return rowView;

    }
	


}
