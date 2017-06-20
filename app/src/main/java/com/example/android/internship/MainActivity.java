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

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

    //THIS IS PAINTING FILE
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;
    NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


        itemObject.add(new Items("",R.mipmap.p2));
        itemObject.add(new Items("",R.mipmap.p3));
        itemObject.add(new Items("",R.mipmap.p4));
        itemObject.add(new Items("",R.mipmap.p5));
        itemObject.add(new Items("",R.mipmap.p6));
        itemObject.add(new Items("",R.mipmap.p7));
        itemObject.add(new Items("",R.mipmap.p8));
        itemObject.add(new Items("",R.mipmap.p9));
        itemObject.add(new Items("",R.mipmap.p10));
        itemObject.add(new Items("",R.mipmap.p11));
        itemObject.add(new Items("",R.mipmap.p12));








        ItemAdapter adapter = new ItemAdapter(this, itemObject);

        // Get a reference to the ListView, and attach the adapter to the listView.
        GridView newGrdidView = (GridView) findViewById(R.id.gridview);
        newGrdidView.setAdapter(adapter);
final int []images={R.mipmap.p1,R.mipmap.p2,R.mipmap.p3,R.mipmap.p4,R.mipmap.p5,R.mipmap.p6,R.mipmap.p7,R.mipmap.p8,
        R.mipmap.p12,R.mipmap.p9,R.mipmap.p10,R.mipmap.p11};

newGrdidView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(MainActivity.this,
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
                Intent paintIntent=new Intent(MainActivity.this,MainActivity.class);
                startActivity(paintIntent);
                break;
            case R.id.covers:
                Intent collageIntent=new Intent(MainActivity.this,collages.class);
                startActivity(collageIntent);
                break;
            case R.id.artifacts:
                Intent craftsIntent=new Intent(MainActivity.this,Handicrafts.class);
                startActivity(craftsIntent);
                break;

            case R.id.cont:
                Intent contactIntent=new Intent(MainActivity.this,Contact.class);
                startActivity(contactIntent);
                break;
            case R.id.abut:
                Intent aboutIntent=new Intent(MainActivity.this,About.class);
                startActivity(aboutIntent);
                break;


        }
        return true;
    }
}
