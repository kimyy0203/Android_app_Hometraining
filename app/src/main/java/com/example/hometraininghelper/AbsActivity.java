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
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

/* 해당 액티비티 클래스는 홈트 운동 부위 중에 복근에 해당하는 부분이다. 이 액티비티를 통해 복근의 초급, 중급, 고급 운동으로 넘어갈 수 있다.
또한 드로어 메뉴를 통해 메인 메뉴 화면이 아닌 다른 화면에서도 다른 운동 부위로 넘어갈 수 있도록 하는 동작과
또 다른 옵션 메뉴(검색 기능과 같은 옵션)를 사용할 수 있도록 구현하였다. */
public class AbsActivity extends Activity implements NavigationView.OnNavigationItemSelectedListener {

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
    protected void onCreate(Bundle savedInstanceState) { // 안드로이드 액티비티가 생성될 때 호출되는 메서드이다.
        super.onCreate(savedInstanceState); // 부모 클래스의 onCreate 메서드를 호출하여 기본적인 초기화를 수행한다.
        setContentView(R.layout.activity_abs); // 현재 액티비티의 레이아웃을 activity_abs.xml로 설정한다.

        drawerLayout = findViewById(R.id.drawer_layout);
        /* Android의 레이아웃 중 하나로, 화면의 가장자리에서 슬라이드 하여 나타나는 드로어(메뉴)를 구현하는 데 사용된다.
        일반적으로 좌측에서 오른쪽으로 슬라이드하여 열리는 사이드 메뉴를 만들 때 사용한다. */
        navigationView = findViewById(R.id.design_navigation_view);
        /* NavigationView는 DrawerLayout 내에 포함되어 드로어 메뉴의 항목들을 표시하는 뷰이다.
        일반적으로 앱의 네비게이션 메뉴를 구성하며, XML 파일로 메뉴 항목을 정의할 수 있다. */
        toolbar = findViewById(R.id.toolbar);
        /* 앱의 상단에 위치하는 UI 요소로, 기존의 ActionBar를 대체할 수 있는 도구 중 하나이다.
        Toolbar는 앱의 제목, 네비게이션 버튼, 옵션 메뉴, 로고, 기타 사용자 정의 뷰 등을 표시하는 데 사용된다. */

        navigationView.bringToFront(); // navigatoinView를 화면의 가장 앞쪽으로 가져온다. 이를 사용하면 다른 뷰들보다 드로어가 상단에 표시된다.
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.naviagtion_drawer_close);
        /* ActionBarDrawerToggle 객체를 생성한다.
        이 객체는 드로어와 액티비티 간의 동기화를 처리한다. 드로어가 열리거나 닫힐 때 툴바의 아이콘이 변경되는 것을 처리한다. */
        drawerLayout.addDrawerListener(toggle);
        // drawerLayout에 ActionBarDrawerToggle 객체를 리스너로 추가한다.
        toggle.syncState();
        // toggle 객체의 상태를 현재 DrawerLayout의 상태와 동기화한다. 예를 들어 드로어가 열려 있으면 네비게이션 버튼 아이콘을 변경한다.

        navigationView.setNavigationItemSelectedListener(this);
        /* navigationView의 메뉴 항목이 선택될 때 발생할 이벤트를 처리하기 위해 현재 클래스(this)를 리스너로 설정한다.
        이 클래스는 NavigationView.OnNavigationItemSelected 인터페이스를 구현해야 한다. */

        btn_easy = findViewById(R.id.basic); // 복근 초급

        btn_easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AbsEasyActivity.class);
                startActivity(intent);
            }
        });

        btn_normal = findViewById(R.id.nor); // 복근 중급

        btn_normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AbsNorActivity.class);
                startActivity(intent);
            }
        });

        btn_hard = findViewById(R.id.high); // 복근 고급

        btn_hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AbsHardActivity.class);
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
