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

/* 해당 액티비티 클래스는 웨이트 트레이닝 화면 구성의 동작을 구현한 클래스이다. 웨이트에 해당되는 여러 운동 부위들의 이미지 버튼을 생성하여,
사용자가 원하는 부위를 클릭했을 시에 해당 부위와 관련된 운동기구들을 선택할 수 있도록 화면을 넘어가게 한다.
또한 드로어 메뉴를 통해 메인 메뉴 화면이 아닌 다른 화면에서도 다른 운동 부위로 넘어갈 수 있도록 하는 동작과
또 다른 옵션 메뉴(검색 기능과 같은 옵션)를 사용할 수 있도록 구현하였다. */
public class MainWeightActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // 드로어 메뉴를 구성하기 위해 필요한 3가지 객체 생성
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    ImageButton btn_shoulder_weight; // 어깨(weight) 페이지
    ImageButton btn_arm_weight; // 팔(weight) 페이지
    ImageButton btn_back_weight; // 등(weight) 페이지
    ImageButton btn_chest_weight; // 가슴(weight) 페이지
    ImageButton btn_leg_weight; // 하체(weight) 페이지
    ImageButton btn_diet_weight; // 다이어트(weight) 페이지

    /* 해당 onCreate 메서드는 사용자가 다양한 이미지 버튼을 클릭할 때 다른 액티비티로 이동하는 기능을 구현하였다.
    이를 통해 이미지 버튼 클릭 이벤트를 처리하여 각각의 운동 기구들로 이동할 수 있다.
    또한 드로어 메뉴와 툴바의 상호 작용을 설정하여, 메인 메뉴 화면이 아니라 다른 화면에서도 사용자가 원하는 운동 부위로 넘어갈 수 있는
    기능을 제공한다. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // 부모 클래스의 onCreate 메서드를 호출하여 기본적인 초기화를 수행한다.
        setContentView(R.layout.activity_main_weight); // 현재 액티비티의 레이아웃을 activity_main_weight.xml로 설정한다.

        // 아래 내용은 AbsActivity에 있는 드로어 메뉴 구성하는 부분과 동일하므로 해당 클래스 참고 바람
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.design_navigation_view);
        toolbar = findViewById(R.id.toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.naviagtion_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        btn_shoulder_weight = findViewById(R.id.sh_w); // 어깨(weight) 페이지

        btn_shoulder_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WeightShoulderActivity.class);
                startActivity(intent);
            }
        });

        btn_arm_weight = findViewById(R.id.ar_w); // 팔(weight) 페이지

        btn_arm_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WeightArmActivity.class);
                startActivity(intent);
            }
        });

        btn_back_weight = findViewById(R.id.ba_w); // 등(weight) 페이지

        btn_back_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WeightBackActivity.class);
                startActivity(intent);
            }
        });

        btn_chest_weight = findViewById(R.id.ch_w); // 가슴(weight) 페이지

        btn_chest_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WeightChestActivity.class);
                startActivity(intent);
            }
        });

        btn_leg_weight = findViewById(R.id.le_w); // 하체(weight) 페이지

        btn_leg_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WeightLegActivity.class);
                startActivity(intent);
            }
        });

        btn_diet_weight = findViewById(R.id.di_w); // 다이어트(weight) 페이지

        btn_diet_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WeightDietActivity.class);
                startActivity(intent);
            }
        });
    }

    /* 뒤로 가기 동작 */
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /* 화면 왼쪽 상단 메뉴 동작 구현 */
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_search: // 운동 검색
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/c/LeapFitnessOfficial"));
                startActivity(intent);
                break;
            case R.id.nav_shoulder: // 어깨(홈트)
                Intent intent1 = new Intent(getApplicationContext(), ShoulderActivity.class);
                startActivity(intent1);
                break;
            case R.id.nav_arm: // 팔(홈트)
                Intent intent2 = new Intent(getApplicationContext(), ArmActivity.class);
                startActivity(intent2);
                break;
            case R.id.nav_chest: // 가슴(홈트)
                Intent intent3 = new Intent(getApplicationContext(), ChestActivity.class);
                startActivity(intent3);
                break;
            case R.id.nav_abodminal_muscles: // 복근(홈트)
                Intent intent4 = new Intent(getApplicationContext(), AbsActivity.class);
                startActivity(intent4);
                break;
            case R.id.nav_leg: // 다리(홈트)
                Intent intent5 = new Intent(getApplicationContext(), LegActivity.class);
                startActivity(intent5);
                break;
            case R.id.nav_stretching: // 스트레칭(홈트)
                Intent intent6 = new Intent(getApplicationContext(), StretchActivity.class);
                startActivity(intent6);
                break;
            case R.id.nav_login: // 로그인
                Intent intent7 = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent7);
                break;
            case R.id.nav_profile: // 마이페이지
                Intent intent8 = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent8);
                break;
            case R.id.nav_weight_shoulder: // 어깨(웨이트)
                Intent intent9 = new Intent(getApplicationContext(), WeightShoulderActivity.class);
                startActivity(intent9);
                break;
            case R.id.nav_weight_arm: // 팔(웨이트)
                Intent intent10 = new Intent(getApplicationContext(), WeightArmActivity.class);
                startActivity(intent10);
                break;
            case R.id.nav_weight_chest: // 가슴(웨이트)
                Intent intent11 = new Intent(getApplicationContext(), WeightChestActivity.class);
                startActivity(intent11);
                break;
            case R.id.nav_weight_back: // 등(웨이트)
                Intent intent12 = new Intent(getApplicationContext(), WeightBackActivity.class);
                startActivity(intent12);
                break;
            case R.id.nav_weight_leg: // 하체(웨이트)
                Intent intent13 = new Intent(getApplicationContext(), WeightLegActivity.class);
                startActivity(intent13);
                break;
            case R.id.nav_weight_diet: // 다이어트(웨이트)
                Intent intent14 = new Intent(getApplicationContext(), WeightDietActivity.class);
                startActivity(intent14);
                break;
        }
        DrawerLayout drawerLayout
                = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}