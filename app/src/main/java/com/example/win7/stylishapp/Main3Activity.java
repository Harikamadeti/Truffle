package com.example.win7.stylishapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    private DrawerLayout mdrawerlayout;
    private ActionBarDrawerToggle mtoggle;
    FragmentTransaction fragment;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mdrawerlayout=(DrawerLayout)findViewById(R.id.draw);
        mtoggle=new ActionBarDrawerToggle(this,mdrawerlayout,R.string.open,R.string.close);
        mdrawerlayout.addDrawerListener(mtoggle);
        mtoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView=(NavigationView)findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        fragment = getSupportFragmentManager().beginTransaction();
                        HomeFragment h1=new HomeFragment();
                        //fragment.add(R.id.frame,h1);
                        fragment.commit();
                        getSupportActionBar().setTitle("Home");
                        menuItem.setChecked(true);
                        mdrawerlayout.closeDrawers();
                        break;
                    case R.id.settings:
                        Intent i=new Intent(Main3Activity.this,SettingsActivity.class);
                        startActivity(i);
                        return true;
                    case R.id.about:
                        fragment = getSupportFragmentManager().beginTransaction();
                        //fragment.add(R.id.frame,new HomeFragment());
                        fragment.commit();
                        getSupportActionBar().setTitle("About");
                        menuItem.setChecked(true);
                        mdrawerlayout.closeDrawers();
                        break;
                    case R.id.logout:
                        Intent i1=new Intent(Main3Activity.this,Main2Activity.class);
                        startActivity(i1);
                        return true;
                }
                return false;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
      }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mtoggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
