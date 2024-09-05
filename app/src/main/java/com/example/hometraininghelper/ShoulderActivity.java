package com.example.hometraininghelper;

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

/* 해당 액티비티 클래스는 홈트 운동 부위 중에 어깨에 해당하는 부분이다. 이 액티비티를 통해 어깨의 초급, 중급, 고급 운동으로 넘어갈 수 있다.
또한 드로어 메뉴를 통해 메인 메뉴 화면이 아닌 다른 화면에서도 다른 운동 부위로 넘어갈 수 있도록 하는 동작과
또 다른 옵션 메뉴(검색 기능과 같은 옵션)를 사용할 수 있도록 구현하였다. */
public class ShoulderActivity extends Activity implements NavigationView.OnNavigationItemSelectedListener{

    // 드로어 메뉴를 구성하기 위해 필요한 3가지 객체 생성
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    ImageButton btn_easy; // 운동 난이도 하
    ImageButton btn_normal; // 운동 난이도 중
    ImageButton btn_hard; // 운동 난이도 상

    /* 해당 onCreate 메서드는 사용자가 다양한 버튼을 클릭할 때 다른 액티비티로 이동하는 기능을 구현하였다.
    이를 통해 버튼 클릭 이벤트를 처리하여 각각의 운동 레벨(초급, 중급, 고급)로 이동할 수 있다.
    또한 드로어 메뉴와 툴바의 상호 작용을 설정하여, 메인 메뉴 화면이 아니라 다른 화면에서도 사용자가 원하는 운동 부위로 넘어갈 수 있는
    기능을 제공한다. */
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState); // 부모 클래스의 onCreate 메서드를 호출하여 기본적인 초기화를 수행한다.
        setContentView(R.layout.activity_shoulder); // 현재 액티비티의 레이아웃을 activity_shoulder.xml로 설정한다.

        // 아래 내용은 AbsActivity에 있는 드로어 메뉴 구성하는 부분과 동일하므로 해당 클래스 참고 바람
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.design_navigation_view);
        toolbar=findViewById(R.id.toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.naviagtion_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        btn_easy = findViewById(R.id.basic); // 어깨 초급

        btn_easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ShoulderEasyActivity.class);
                startActivity(intent);
            }
        });

        btn_normal = findViewById(R.id.nor); // 어깨 중급

        btn_normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ShoulderNorActivity.class);
                startActivity(intent);
            }
        });

        btn_hard = findViewById(R.id.high); // 어깨 고급

        btn_hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ShoulderHardActivity.class);
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