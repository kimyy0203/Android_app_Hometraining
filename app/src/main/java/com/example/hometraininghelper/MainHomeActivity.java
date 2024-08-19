package com.example.hometraininghelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.navigation.NavigationView;

public class MainHomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ImageButton btn_shoulder;
    ImageButton btn_arm;
    ImageButton btn_abs;
    ImageButton btn_chest;
    ImageButton btn_leg;
    ImageButton btn_stretch;
    private long backKeyPressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.design_navigation_view);
        toolbar=findViewById(R.id.toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.naviagtion_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        btn_shoulder = findViewById(R.id.bus); // 어깨 페이지

        btn_shoulder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ShoulderActivity.class);
                startActivity(intent);
            }
        });

        btn_arm = findViewById(R.id.imageView3); // 팔 페이지

        btn_arm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ArmActivity.class);
                startActivity(intent);
            }
        });

        btn_abs = findViewById(R.id.train); // 복근 페이지

        btn_abs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AbsActivity.class);
                startActivity(intent);
            }
        });
        btn_chest = findViewById(R.id.bus1); // 가슴 페이지

        btn_chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChestActivity.class);
                startActivity(intent);
            }
        });
        btn_leg = findViewById(R.id.cycle); // 다리 페이지

        btn_leg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LegActivity.class);
                startActivity(intent);
            }
        });
        btn_stretch = findViewById(R.id.airplane); // 스트레칭 페이지

        btn_stretch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StretchActivity.class);
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