package com.example.mrlee.contentresolver;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    private ListView listcontact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        listcontact=new ListView(MainActivity.this);//dynamic to product the ListView

        ContentResolver cvr=getContentResolver();//get the ContentResolver

        Cursor cursor=cvr.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);

        //new Adapter conn
        ListAdapter la=new SimpleCursorAdapter(MainActivity.this,android.R.layout.simple_list_item_1,cursor,new String[]{ContactsContract.Contacts.DISPLAY_NAME_PRIMARY},new int[]{android.R.id.text1});

        listcontact.setAdapter(la);//binder

        setContentView(listcontact);


    }



}
