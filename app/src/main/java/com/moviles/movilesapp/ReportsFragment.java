package com.moviles.movilesapp;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moviles.movilesapp.models.Constants;
import com.moviles.movilesapp.models.FeedItem;
import com.moviles.movilesapp.models.OnFragmentInteractionListener;
import com.moviles.movilesapp.models.User;

import java.math.BigInteger;
import java.security.SecureRandom;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * Use the {@link ReportsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReportsFragment extends BaseFragment implements View.OnClickListener {

    private static final String TAG = ReportsFragment.class.getSimpleName();

    public ReportsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ReportsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ReportsFragment newInstance(String param1, String param2) {
        ReportsFragment fragment = new ReportsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reports, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bindButton();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.postReportBtn:
                EditText msgTxtField = (EditText) getActivity().findViewById(R.id.msgTxtField);
                String msgTxt = msgTxtField.getText().toString();
                sendReport(msgTxt);
                break;
            case R.id.randomReportBtn:
                sendRandomReport();
                break;
        }    }

    private void bindButton() {
        final Activity activity = getActivity();
        activity.findViewById(R.id.postReportBtn).setOnClickListener(this);
        activity.findViewById(R.id.randomReportBtn).setOnClickListener(this);
    }

    private void sendReport(final String msgTxt) {
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        final DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference();
        dbRef.child(Constants.DB_USERS_NODE).child(uid).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        User user = dataSnapshot.getValue(User.class);
                        String name = user.getFirstName() + " " + user.getLastName();
                        String timeStamp = String.valueOf(System.currentTimeMillis());
                        FeedItem item = new FeedItem(name, msgTxt, timeStamp);
                        dbRef.child(Constants.DB_FEED_NODE).push().setValue(item);
                        Toast.makeText(getActivity(), "Report created successfully", Toast.LENGTH_SHORT).show();
                        getActivity().onBackPressed();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {}
                }
        );
    }

    private void sendRandomReport() {
        String randomMessage = new BigInteger(130, new SecureRandom()).toString(32);
        sendReport(randomMessage);
        Toast.makeText(getActivity(), "Random report sent", Toast.LENGTH_SHORT).show();
    }

}
