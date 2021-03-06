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
        TextView cTextView = (TextView) rowView.findViewById(R.id.criteria);
        TextView tTextView = (TextView) rowView.findViewById(R.id.team);
        TextView sTextView = (TextView) rowView.findViewById(R.id.score_his);
        
        //String obj = data.get(position).voteContestantHistory.name+"->"+data.get(position).voteCriterionHistory.name+" ; "+data.get(position).voteContestantHistory.score;
        //TODO
        //http://158.108.228.54:8080/
        //no img yet
        //String imageFile = null;
        cTextView.setText(data.get(position).voteCriterionHistory.name);
        tTextView.setText(data.get(position).voteContestantHistory.name);
        sTextView.setText(data.get(position).voteContestantHistory.score+"");
        //no Image yet
        //imageView.setImageDrawable(d);
        return rowView;

    }
	


}
