package com.example.hometraininghelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.navigation.NavigationView;

/* 해당 액티비티 클래스는 앱 시작 시, 가장 먼저 실행되는 앱의 메인 화면에 대한 동작을 구성하는 클래스이다.
이 클래스는 홈 트레이닝 메인 페이지와 웨이트 트레이닝 메인 페이지로 이동할 수 있는 두가지 버튼에 대한 동작을 구현한다.
또한 드로어 메뉴를 통해 메인 메뉴 화면이 아닌 다른 화면에서도 다른 운동 부위로 넘어갈 수 있도록 하는 동작과
또 다른 옵션 메뉴(검색 기능과 같은 옵션)를 사용할 수 있도록 구현하였다. */
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // 드로어 메뉴를 구성하기 위해 필요한 3가지 객체 생성
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    Button btn_home; // 홈 트레이닝 메인 페이지
    Button btn_weight; // 웨이트 트레이닝 메인 페이지
    private long backKeyPressedTime = 0;

    /* 해당 onCreate 메서드는 사용자가 버튼을 클릭할 때 다른 액티비티로 이동하는 기능을 구현하였다.
    이를 통해 버튼 클릭 이벤트를 처리하여 홈 트레이닝 메인 페이지와 웨이트 트레이닝 메인 페이지로 이동할 수 있다.
    또한 드로어 메뉴와 툴바의 상호 작용을 설정하여, 메인 메뉴 화면이 아니라 다른 화면에서도 사용자가 원하는 운동 부위로 넘어갈 수 있는
    기능을 제공한다. */
    @SuppressLint({"MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // 부모 클래스의 onCreate 메서드를 호출하여 기본적인 초기화를 수행한다.
        setContentView(R.layout.activity_main_main); // 현재 액티비티의 레이아웃을 activity_main_main.xml로 설정한다.

        // 아래 내용은 AbsActivity에 있는 드로어 메뉴 구성하는 부분과 동일하므로 해당 클래스 참고 바람
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.design_navigation_view);
        toolbar = findViewById(R.id.toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.naviagtion_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        btn_home = findViewById(R.id.home_training); // 홈 트레이닝 메인 페이지

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainHomeActivity.class);
                startActivity(intent);
            }
        });

        btn_weight = findViewById(R.id.weight_training); // 웨이트 트레이닝 메인 페이지

        btn_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainWeightActivity.class);
                startActivity(intent);
            }
        });
    }

    /* 뒤로 가기 동작, 메인 메뉴에서 뒤로 가기 동작 시 종료할 지 물어본 후 종료 진행 */
    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() > backKeyPressedTime + 2500) {
            backKeyPressedTime = System.currentTimeMillis();
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("정말로 종료하시겠습니까?");
            builder.setTitle("종료 알림창")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            moveTaskToBack(true);
                            finish();
                            android.os.Process.killProcess(android.os.Process.myPid());
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.setTitle("종료 알림창");
            alert.show();
            return;
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