package com.example.hometraininghelper;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class WeightBackActivity extends Activity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_weight);

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.design_navigation_view);
        toolbar=findViewById(R.id.toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.naviagtion_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        btn_1 = findViewById(R.id.lat_pull_down); // 랫 풀 다운

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BackLatPullDownActivity.class);
                startActivity(intent);
            }
        });

        btn_2 = findViewById(R.id.cable_arm_pull_down); // 케이블 암풀다운

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BackCableArmPullDownActivity.class);
                startActivity(intent);
            }
        });

        btn_3 = findViewById(R.id.seated_row); // 시티드 로우

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BackSeatedRowActivity.class);
                startActivity(intent);
            }
        });

        btn_4 = findViewById(R.id.one_arm_row); // 원 암 로우

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BackOneArmRowActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_search:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/c/LeapFitnessOfficial"));
                startActivity(intent);
                break;
            case R.id.nav_shoulder:
                Intent intent1 = new Intent(getApplicationContext(),ShoulderActivity.class);
                startActivity(intent1);
                break;
            case R.id.nav_arm:
                Intent intent2 = new Intent(getApplicationContext(),ArmActivity.class);
                startActivity(intent2);
                break;
            case R.id.nav_chest:
                Intent intent3 = new Intent(getApplicationContext(),ChestActivity.class);
                startActivity(intent3);
                break;
            case R.id.nav_abodminal_muscles:
                Intent intent4 = new Intent(getApplicationContext(),AbsActivity.class);
                startActivity(intent4);
                break;
            case R.id.nav_leg:
                Intent intent5 = new Intent(getApplicationContext(),LegActivity.class);
                startActivity(intent5);
                break;
            case R.id.nav_stretching:
                Intent intent6 = new Intent(getApplicationContext(),StretchActivity.class);
                startActivity(intent6);
                break;
            case R.id.nav_login:
                Intent intent7 = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent7);
                break;
            case R.id.nav_profile:
                Intent intent8 = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent8);
                break;
            case R.id.nav_weight_shoulder:
                Intent intent9 = new Intent(getApplicationContext(),WeightShoulderActivity.class);
                startActivity(intent9);
                break;
            case R.id.nav_weight_arm:
                Intent intent10 = new Intent(getApplicationContext(),WeightArmActivity.class);
                startActivity(intent10);
                break;
            case R.id.nav_weight_chest:
                Intent intent11 = new Intent(getApplicationContext(),WeightChestActivity.class);
                startActivity(intent11);
                break;
            case R.id.nav_weight_back:
                Intent intent12 = new Intent(getApplicationContext(),WeightBackActivity.class);
                startActivity(intent12);
                break;
            case R.id.nav_weight_leg:
                Intent intent13 = new Intent(getApplicationContext(),WeightLegActivity.class);
                startActivity(intent13);
                break;
            case R.id.nav_weight_diet:
                Intent intent14 = new Intent(getApplicationContext(),WeightDietActivity.class);
                startActivity(intent14);
                break;
        }
        DrawerLayout drawerLayout
                = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}
