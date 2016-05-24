package com.moviles.movilesapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.moviles.movilesapp.models.FeedItem;

import java.util.List;
import java.util.Map;

/**
 * Created by Francisco on 23-May-16.
 */
public class FeedListAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<FeedItem> feedItems;

    public FeedListAdapter(Activity activity, List<FeedItem> feedItems) {
        this.activity = activity;
        this.feedItems = feedItems;
    }


    @Override
    public int getCount() {
        return feedItems.size();
    }

    @Override
    public Object getItem(int position) {
        return feedItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
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
}
