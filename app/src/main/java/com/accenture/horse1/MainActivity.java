package com.accenture.horse1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Toast;

import com.accenture.horse1.fragment.ButtonsFragment;
import com.accenture.horse1.fragment.SelectItemsFragment;

public class MainActivity extends AppCompatActivity implements ButtonsFragment.OnButtonClickListner, SelectItemsFragment.OnItemSelectedListener
{
    private static String TAG = "com.accenture.horse1.MainActivity";
    private static final int REQUEST_SELECT_CONTACT = 1;
    private static final int HORSE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            ButtonsFragment buttonsFragment = new ButtonsFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.frameLayout, buttonsFragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onButtonClick(int code) {
        Bundle args = new Bundle();
        if (code == HORSE) {
            args.putInt("code", HORSE);
            SelectItemsFragment selectItemsFragment = new SelectItemsFragment();
            selectItemsFragment.setArguments(args);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout, selectItemsFragment);
            fragmentTransaction.commit();
        }
    }

    /*@Override
    public void onTeamButtonClick() {
        Toast.makeText(this, "onTeamButtonClick",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_SELECT_CONTACT);
        }
    }*/

   /* @Override
    public void onViewTableButtonClick() {
        Toast.makeText(this, "onViewTableButtonClick",Toast.LENGTH_SHORT).show();
        TableViewFragment tableViewFragment = new TableViewFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, tableViewFragment);
        fragmentTransaction.commit();
    }*/

    @Override
    public void onItemSelectedListner(int position, int code) {
        /*Toast.makeText(this, "Called By Fragment A: position - "+ position, Toast.LENGTH_SHORT).show();*/
        Bundle args = new Bundle();
        args.putInt("position", position);
        args.putInt("code", code);
        ButtonsFragment buttonsFragment = new ButtonsFragment();
        buttonsFragment.setArguments(args);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, buttonsFragment);
        fragmentTransaction.commit();
    }

}
