package com.example.hometraininghelper;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

/* 해당 액티비티 클래스는 홈트 운동 부위 중에 복근에 해당하는 중급 부분이다.
이 클래스는 특별한 동작 없이 단순히 복근 중급에 해당되는 레이아웃을 연결하여 관련된 유튜브 영상을 볼 수 있도록하며,
드로어 메뉴를 생성하고 설정하여, 이 해당 화면에서도 다른 운동 부위로 넘어가거나 다른 옵션 메뉴를 사용할 수 있도록 한다. */
public class AbsNorActivity extends Activity implements NavigationView.OnNavigationItemSelectedListener{

    // 드로어 메뉴를 구성하기 위해 필요한 3가지 객체 생성
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    /* 해당 onCreate 메서드는 복근 초급에 해당되는 영상을 보여주는 레이아웃을 설정하여, 해당 영상을 볼 수 있도록한다.
    또한 드로어 메뉴와 툴바의 상호 작용을 설정하여, 메인 메뉴 화면이 아니라 다른 화면에서도 사용자가 원하는 운동 부위로 넘어갈 수 있는
    기능을 제공한다. */
    @Override
    protected void onCreate(Bundle savedInstanceState){
        // 아래 내용은 AbsActivity에 있는 드로어 구성하는 부분과 동일하므로 해당 클래스 참고 바람
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_nor);

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.design_navigation_view);
        toolbar=findViewById(R.id.toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.naviagtion_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
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
        switch (item.getItemId()){
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