package com.moviles.movilesapp.models;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.format.DateUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.moviles.movilesapp.R;

/**
 * Created by Francisco on 23-May-16.
 */
public class FeedListAdapter extends FirebaseListAdapter<FeedItem> {

    final long ONE_MEGABYTE = 1024 * 1024;

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
        TextView nameField = (TextView) v.findViewById(R.id.name);
        TextView msgTxtField = (TextView) v.findViewById(R.id.msgTxt);
        TextView timestamp = (TextView) v.findViewById(R.id.timestamp);
        TextView petNameField = (TextView) v.findViewById(R.id.petName);
        ImageView image = (ImageView) v.findViewById(R.id.feedImage);
        TextView address = (TextView) v.findViewById(R.id.address);

        CharSequence timeAgo = DateUtils.getRelativeTimeSpanString(
                Long.parseLong(model.getTimestamp()),
                System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS
        );

        nameField.setText(model.getName());
        msgTxtField.setText(model.getMsgTxt());
        petNameField.setText(" - " + model.getPetName());
        timestamp.setText(timeAgo);
        address.setText("Cerca de: " + model.getAddress());

        String imageUrl = model.getImageUrl();
        if (imageUrl != null && !imageUrl.equals("")) {
            setImage(image, imageUrl);
        }
    }

    private void setImage(final ImageView imageView, String imageUrl) {
        StorageReference ref = FirebaseStorage
                .getInstance().getReference()
                .child(Constants.STORAGE_IMAGES)
                .child(imageUrl);

        ref.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                imageView.setImageBitmap(bitmap);

                ViewGroup.LayoutParams params = imageView.getLayoutParams();
                params.width = imageView.getWidth();
                params.height = imageView.getWidth() * bitmap.getHeight() / bitmap.getWidth();
                imageView.setLayoutParams(params);
            }
        });
    }
}
