package com.accenture.horse1.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.accenture.horse1.R;
import com.accenture.horse1.adapters.MyAdapter;
import com.accenture.horse1.data.Horse;

public class SelectItemsFragment extends Fragment {

    private static String TAG = "com.accenture.horse1.SelecItemsFragment";
    int layoutID = R.layout.list_item;
    private OnItemSelectedListener listener;
    private static final int HORSE = 1;
    private int code;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Get a reference to the parent Activity.
        Log.d(TAG, "onAttach");
        //--OnItemSelectedListener listener;
        // This event fires 1st, before creation of fragment or any views
        // The onAttach method is called when the Fragment instance is associated with an Activity.
        // This does not mean the Activity is fully initialized.
        if (context instanceof OnItemSelectedListener) {
            this.listener = (OnItemSelectedListener) context;
        }
    }

    // Called to do the initial creation of the Fragment.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize the Fragment.
        Log.d(TAG, "onCreate");
        if(savedInstanceState == null){
            // Get back arguments
            if(getArguments() != null) {
                code = getArguments().getInt("code", 0);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        return inflater.inflate(R.layout.select_items_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        ListView listView = view.findViewById(R.id.itemsList);
        MyAdapter myAdapter;
        if (code == HORSE) {
            myAdapter = new MyAdapter(getContext(), layoutID, new Horse().getHorseList());
            listView.setAdapter(myAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    // go to activity to load pizza details fragment
                    listener.onItemSelectedListner(position, code); // (3) Communicate with Activity using Listener
                }
            });
        }

    }

    // Called once the parent Activity and the Fragment's UI have
    // been created.
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Complete the Fragment initialization � particularly anything
        // that requires the parent Activity to be initialized or the
        // Fragment's view to be fully inflated.
        Log.d(TAG, "onActivityCreated");
    }

    // Called at the start of the visible lifetime.
    @Override
    public void onStart() {
        super.onStart();
        // Apply any required UI change now that the Fragment is visible.
        Log.d(TAG, "onStart");
    }

    // Called at the start of the active lifetime.
    @Override
    public void onResume() {
        super.onResume();
        // Resume any paused UI updates, threads, or processes required
        // by the Fragment but suspended when it became inactive.
        Log.d(TAG, "onResume");
    }

    // Called at the end of the active lifetime.
    @Override
    public void onPause() {
        // Suspend UI updates, threads, or CPU intensive processes
        // that don't need to be updated when the Activity isn't
        // the active foreground activity.
        // Persist all edits or state changes
        // as after this call the process is likely to be killed.
        super.onPause();
        Log.d(TAG, "onPause");
    }

    // Called to save UI state changes at the
    // end of the active lifecycle.
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate, onCreateView, and
        // onCreateView if the parent Activity is killed and restarted.
        super.onSaveInstanceState(savedInstanceState);
        Log.d(TAG, "onSaveInstanceState");
    }

    // Called at the end of the visible lifetime.
    @Override
    public void onStop() {
        // Suspend remaining UI updates, threads, or processing
        // that aren't required when the Fragment isn't visible.
        super.onStop();
        Log.d(TAG, "onStop");
    }

    // Called when the Fragment's View has been detached.
    @Override
    public void onDestroyView() {
        // Clean up resources related to the View.
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");
    }

    // Called at the end of the full lifetime.
    @Override
    public void onDestroy() {
        // Clean up any resources including ending threads,
        // closing database connections etc.
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    // Called when the Fragment has been detached from its parent Activity.
    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach");
    }

    // Define the events that the fragment will use to communicate
    public interface OnItemSelectedListener {
        // This can be any number of events to be sent to the activity
        void onItemSelectedListner(int position, int code);
    }

}
