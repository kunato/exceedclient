package com.kunat.exceedvoteclient.adapter;

import java.util.List;

import com.kunat.exceedvoteclient.R;
import com.kunat.exceedvoteclient.model.Criterion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
/**
 * ArrayAdapter implementation for CriterionList
 * @author Kunat Pipatanakul
 *
 */
public class CriteriaListAdapter extends ArrayAdapter<Criterion> {
	private Context context;
	private int textViewResourceId;
	private List<Criterion> data;
	public CriteriaListAdapter(Context context, int textViewResourceId,List<Criterion> c) {
		super(context, textViewResourceId, c);

		this.context = context;
		this.textViewResourceId = textViewResourceId;
		this.data = c;
	}
	@Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(textViewResourceId, parent, false);
        //ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);
        TextView textView = (TextView) rowView.findViewById(R.id.listTextView);

        Criterion obj = data.get(position);
        //TODO
        //no img yet
        //String imageFile = null;
        textView.setText(obj.name);
        //no Image yet
        //imageView.setImageDrawable(d);
        return rowView;

    }
	


}
