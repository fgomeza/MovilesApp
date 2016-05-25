package com.moviles.movilesapp.models;

import android.app.Activity;
import android.content.Context;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.moviles.movilesapp.R;
import com.moviles.movilesapp.models.FeedItem;

import java.util.List;
import java.util.Map;

/**
 * Created by Francisco on 23-May-16.
 */
public class FeedListAdapter extends FirebaseListAdapter<FeedItem> {


    /**
     * @param activity    The activity containing the ListView
     */
    public FeedListAdapter(Activity activity) {
        super(FirebaseDatabase.getInstance().getReference().child(Constants.DB_FEED_NODE),
                FeedItem.class,
                R.layout.feed_item,
                activity);
    }

    /*
    private View a(int position, View convertView, ViewGroup parent) {
        if (inflater == null) {
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.feed_item, null);
        }

        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView msgTxt = (TextView) convertView.findViewById(R.id.msgTxt);

        FeedItem item = feedItems.get(position);

        name.setText(item.getName());
        msgTxt.setText(item.getMsgTxt());

        return convertView;
    }
    */

    @Override
    protected void populateView(View v, FeedItem model) {
        TextView name = (TextView) v.findViewById(R.id.name);
        TextView msgTxt = (TextView) v.findViewById(R.id.msgTxt);
        TextView timestamp = (TextView) v.findViewById(R.id.timestamp);

        name.setText(model.getName());
        msgTxt.setText(model.getMsgTxt());
        CharSequence timeAgo = DateUtils.getRelativeTimeSpanString(
                Long.parseLong(model.getTimestamp()),
                System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS
        );
        timestamp.setText(timeAgo);
    }
}
