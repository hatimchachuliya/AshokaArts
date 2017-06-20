package com.example.android.internship;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class Handicrafts extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
//THIS IS ARTIFACTS FILE
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;
    NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handicrafts);

        nv=(NavigationView)findViewById(R.id.mynavigation);
        nv.setNavigationItemSelectedListener(this);

        mToolbar=(Toolbar)findViewById(R.id.nav_action);
        setSupportActionBar(mToolbar);

        mDrawerLayout=(DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        final ArrayList<Items> itemObject = new ArrayList<Items>();

        itemObject.add(new Items("",R.mipmap.a20));
        itemObject.add(new Items("",R.mipmap.a1));
        itemObject.add(new Items("",R.mipmap.a2));
        itemObject.add(new Items("",R.mipmap.a3));
        itemObject.add(new Items("",R.mipmap.a4));
        itemObject.add(new Items("",R.mipmap.a5));
        itemObject.add(new Items("",R.mipmap.a6));
        itemObject.add(new Items("",R.mipmap.a7));
        itemObject.add(new Items("",R.mipmap.a18));
        itemObject.add(new Items("",R.mipmap.a11));
        itemObject.add(new Items("",R.mipmap.a12));
        itemObject.add(new Items("",R.mipmap.a14));
        itemObject.add(new Items("",R.mipmap.a15));
        itemObject.add(new Items("",R.mipmap.a17));
        itemObject.add(new Items("",R.mipmap.a8));


        ItemAdapter adapter = new ItemAdapter(this, itemObject);

        // Get a reference to the ListView, and attach the adapter to the listView.
        GridView newGrdidView = (GridView) findViewById(R.id.gridview);
        newGrdidView.setAdapter(adapter);
        final int []images={R.mipmap.a1,R.mipmap.a2,R.mipmap.a3,R.mipmap.a4,R.mipmap.a5,R.mipmap.a6,R.mipmap.a7,R.mipmap.a8,R.mipmap.a8,
                R.mipmap.a9,R.mipmap.a10,R.mipmap.a12,R.mipmap.a13,R.mipmap.a14,R.mipmap.a15,R.mipmap.a16,R.mipmap.a17,R.mipmap.a18,R.mipmap.a11,
                R.mipmap.a19,R.mipmap.a20};

        newGrdidView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(Handicrafts.this,
                        Main3Activity.class);
                int mImageId =0;
                intent.putExtra("img",images[position]);
                startActivity(intent);

            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item))
        {return true;}
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId())
        {
            case R.id.paint:
                Intent paintIntent=new Intent(Handicrafts.this,MainActivity.class);
                startActivity(paintIntent);
                break;
            case R.id.covers:
                Intent collageIntent=new Intent(Handicrafts.this,collages.class);
                startActivity(collageIntent);
                break;
            case R.id.artifacts:
                Intent craftsIntent=new Intent(Handicrafts.this,Handicrafts.class);
                startActivity(craftsIntent);
                break;

            case R.id.cont:
                Intent contactIntent=new Intent(Handicrafts.this,Contact.class);
                startActivity(contactIntent);
                break;
            case R.id.abut:
                Intent aboutIntent=new Intent(Handicrafts.this,About.class);
                startActivity(aboutIntent);
                break;
        }
        return true;
    }
}
