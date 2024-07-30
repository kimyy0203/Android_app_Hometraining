package com.example.hometraininghelper;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;

public class SearchActivity extends AppCompatActivity implements OnNavigationItemSelectedListener {

    private List<String> list;          // 데이터를 넣은 리스트변수
    private ListView listView;          // 검색을 보여줄 리스트변수
    private EditText editSearch;        // 검색어를 입력할 Input 창
    private SearchAdapter adapter;      // 리스트뷰에 연결할 아답터
    private ArrayList<String> arraylist;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.design_navigation_view);
        toolbar=findViewById(R.id.toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.naviagtion_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        editSearch = (EditText) findViewById(R.id.editSearch);
        listView = (ListView) findViewById(R.id.listView);
        // 리스트를 생성한다.
        list = new ArrayList<String>();

        // 검색에 사용할 데이터을 미리 저장한다.
        settingList();

        // 리스트의 모든 데이터를 arraylist에 복사한다.// list 복사본을 만든다.
        arraylist = new ArrayList<String>();
        arraylist.addAll(list);

        // 리스트에 연동될 아답터를 생성한다.
        adapter = new SearchAdapter(list, this);

        // 리스트뷰에 아답터를 연결한다.
        listView.setAdapter(adapter);

        // input창에 검색어를 입력시 "addTextChangedListener" 이벤트 리스너를 정의한다.
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // input창에 문자를 입력할때마다 호출된다.
                // search 메소드를 호출한다.
                String text = editSearch.getText().toString();
                search(text);
            }
        });
    }

    // 검색을 수행하는 메소드
    public void search(String charText) {

        // 문자 입력시마다 리스트를 지우고 새로 뿌려준다.
        list.clear();

        // 문자 입력이 없을때는 모든 데이터를 보여준다.
        if (charText.length() == 0) {
            list.addAll(arraylist);
        }
        // 문자 입력을 할때..
        else {
            // 리스트의 모든 데이터를 검색한다.
            for (int i = 0; i < arraylist.size(); i++) {
                // arraylist의 모든 데이터에 입력받은 단어(charText)가 포함되어 있으면 true를 반환한다.
                if (arraylist.get(i).toLowerCase().contains(charText)) {
                    // 검색된 데이터를 리스트에 추가한다.
                    list.add(arraylist.get(i));
                }
            }
        }
        // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
        adapter.notifyDataSetChanged();
    }

    // 검색에 사용될 데이터를 리스트에 추가한다.
    private void settingList() {
        String ex1 = new String("어깨");


        list.add(ex1);
        list.add("어깨");

        list.add("팔");


        list.add("다리");
        list.add("복근");
        list.add("가슴");
        list.add("스트레칭");

        list.add("점핑 잭(복근 초급)");
        list.add("플루터 킥(복근 초급)");
        list.add("복부 크런치(복근 초급)");
        list.add("러시안 트위스트(복근 초급)");
        list.add("마운틴 클라이머(복근 초급)");
        list.add("다리 들어올리기(복근 초급)");
        list.add("플랭크(복근 초급)");
        list.add("코브라 스트레칭(복근 초급)");

        list.add("점핑 잭(복근 중급)");
        list.add("플루터 킥(복근 중급)");
        list.add("복부 크런치(복근 중급)");
        list.add("마운틴 클라이머(복근 중급)");
        list.add("러시안 트위스트(복근 중급)");
        list.add("v-업(복근 중급)");
        list.add("바이시클 크런치(복근 중급)");
        list.add("플랭크(복근 중급)");
        list.add("다리 들어올리기(복근 중급)");
        list.add("코브라 스트레칭(복근 중급)");

        list.add("점핑 잭(복근 상급)");
        list.add("플루터 킥(복근 상급)");
        list.add("윗몸 일으키기(복근 상급)");
        list.add("복부 크런치(복근 상급)");
        list.add("바이시클 크런치(복근 상급)");
        list.add("v-업(복근 상급)");
        list.add("러시안 트위스트(복근 상급)");
        list.add("엉덩이 브릿지(복근 상급)");
        list.add("마운틴 클라이머(복근 상급)");
        list.add("플랭크(복근 상급)");
        list.add("코브라 스트레칭(복근 상급)");

        list.add("팔 들어올리기(팔 초급)");
        list.add("옆으로 팔 올리기(팔 초급)");
        list.add("시계 방향으로 팔 돌리기(팔 초급)");
        list.add("시계 반대 방향으로 팔 돌리기(팔 초급)");
        list.add("트리셉스 체어 딥(팔 초급)");
        list.add("푸쉬업(팔 초급)");
        list.add("다이아몬드 푸쉬업(팔 초급)");
        list.add("벽 푸쉬업(팔 초급)");
        list.add("삼두근 스트레칭 왼쪽(팔 초급)");
        list.add("삼두근 스트레칭 오른쪽(팔 초급)");
        list.add("스탠딩 이두근 스트레칭 왼쪽(팔 초급)");
        list.add("스탠딩 이두근 스트레칭 오른쪽(팔 초급)");

        list.add("시계 방향으로 팔 돌리기(팔 중급)");
        list.add("시계 반대 방향으로 팔 돌리기(팔 중급)");
        list.add("트리셉스 체어 딥(팔 중급)");
        list.add("푸쉬업(팔 중급)");
        list.add("밀리터리 푸쉬업(팔 중급)");
        list.add("다이아몬드 푸쉬업(팔 중급)");
        list.add("버피(팔 중급)");
        list.add("삼두근 스트레칭 왼쪽(팔 중급)");
        list.add("삼두근 스트레칭 오른쪽(팔 중급)");
        list.add("스탠딩 이두근 스트레칭 왼쪽(팔 중급)");
        list.add("스탠딩 이두근 스트레칭 오른쪽(팔 중급)");

        list.add("시계 방향으로 팔 돌리기(팔 상급)");
        list.add("시계 반대 방향으로 팔 돌리기(팔 상급)");
        list.add("트리셉스 체어 딥(팔 상급)");
        list.add("바닥 삼두근 딥(팔 상급)");
        list.add("푸쉬업(팔 상급)");
        list.add("와이드 푸쉬업(팔 상급)");
        list.add("밀리터리 푸쉬업(팔 상급)");
        list.add("다이아몬드 푸쉬업(팔 상급)");
        list.add("버피(팔 상급)");
        list.add("삼두근 스트레칭 왼쪽(팔 상급)");
        list.add("삼두근 스트레칭 오른쪽(팔 상급)");
        list.add("스탠딩 이두근 스트레칭 왼쪽(팔 상급)");
        list.add("스탠딩 이두근 스트레칭 오른쪽(팔 상급)");

        list.add("점핑 잭(가슴 초급)");
        list.add("인클라인 푸시업(가슴 초급)");
        list.add("푸쉬업(가슴 초급)");
        list.add("와이드 푸쉬업(가슴 초급)");
        list.add("무릎 푸쉬업(가슴 초급)");
        list.add("코브라 스트레칭(가슴 초급)");
        list.add("가슴 스트레칭(가슴 초급)");

        list.add("점핑 잭(가슴 중급)");
        list.add("무릎 푸쉬업(가슴 중급)");
        list.add("푸쉬업(가슴 중급)");
        list.add("와이드 푸쉬업(가슴 중급)");
        list.add("힌두 푸쉬업(가슴 중급)");
        list.add("디클라인 푸쉬업(가슴 중급)");
        list.add("어깨 스트레칭(가슴 중급)");
        list.add("코브라 스트레칭(가슴 중급)");
        list.add("가슴 스트레칭(가슴 중급)");

        list.add("점핑 잭(가슴 상급)");
        list.add("어깨 스트레칭(가슴 상급)");
        list.add("버피(가슴 상급)");
        list.add("힌두 푸쉬업(가슴 상급)");
        list.add("다이아몬드 푸쉬업(가슴 상급)");
        list.add("박스 푸쉬업(가슴 상급)");
        list.add("디클라인 푸쉬업(가슴 상급)");
        list.add("어깨 스트레칭(가슴 상급)");
        list.add("코브라 스트레칭(가슴 상급)");
        list.add("가슴 스트레칭(가슴 상급)");

        list.add("좌우 뛰기(다리 초급)");
        list.add("스쿼트(다리 초급)");
        list.add("옆으로 누워 다리 올리기 왼쪽(다리 초급)");
        list.add("옆으로 누워 다리 올리기 오른쪽(다리 초급)");
        list.add("백 런지(다리 초급)");
        list.add("무릎 당기기 왼쪽(다리 초급)");
        list.add("무릎 당기기 오른쪽(다리 초급)");
        list.add("카프레이즈(다리 초급)");
        list.add("종아리 스트레칭 왼쪽(다리 초급)");
        list.add("종아리 스트레칭 오른쪽(다리 초급)");

        list.add("점핑 잭(다리 중급)");
        list.add("스쿼트(다리 중급)");
        list.add("파이어 하이드란트 레프트(다리 중급)");
        list.add("파이어 하이드란트 라이트(다리 중급)");
        list.add("런지(다리 중급)");
        list.add("옆으로 누워 다리 올리기 왼쪽(다리 중급)");
        list.add("옆으로 누워 다리 올리기 오른쪽(다리 중급)");
        list.add("무릎 당기기 왼쪽(다리 중급)");
        list.add("무릎 당기기 오른쪽(다리 중급)");
        list.add("카프레이즈(다리 중급)");
        list.add("종아리 스트레칭 왼쪽(다리 중급)");
        list.add("종아리 스트레칭 오른쪽(다리 중급)");

        list.add("점핑 잭(다리 상급)");
        list.add("스쿼트(다리 상급)");
        list.add("와이드 스쿼트(다리 상급)");
        list.add("크로스 런지(다리 상급)");
        list.add("스플릿 스쿼트 오른쪽(다리 상급)");
        list.add("스플릿 스쿼트 왼쪽(다리 상급)");
        list.add("옆으로 누워 다리 올리기 왼쪽(다리 상급)");
        list.add("옆으로 누워 다리 올리기 오른쪽(다리 상급)");
        list.add("점프 스쿼트(다리 상급)");
        list.add("뒤로 다리차기 왼쪽(다리 상급)");
        list.add("뒤로 다리차기 오른쪽(다리 상급)");
        list.add("종아리 스트레칭 왼쪽(다리 상급)");
        list.add("종아리 스트레칭 오른쪽(다리 상급)");

        list.add("점핑 잭(어깨 초급)");
        list.add("팔 들어올리기(어깨 초급)");
        list.add("옆으로 팔 올리기(어깨 초급)");
        list.add("무릎 푸쉬업(어깨 초급)");
        list.add("엎드려서 푸쉬업(어깨 초급)");
        list.add("옆으로 누워 바닥 스트레칭 왼쪽(어깨 초급)");
        list.add("옆으로 누워 바닥 스트레칭 오른쪽(어깨 초급)");

        list.add("점핑 잭(어깨 중급)");
        list.add("삼두근 뒤로 차기(어깨 중급)");
        list.add("인클라인 푸시업(어깨 중급)");
        list.add("바닥 삼두근 딥(어깨 중급)");
        list.add("맴도는 푸쉬업(어깨 중급)");
        list.add("Swimmer and superman(어깨 중급)");
        list.add("옆으로 누워 바닥 스트레칭 왼쪽(어깨 중급)");
        list.add("옆으로 누워 바닥 스트레칭 오른쪽(어깨 중급)");

        list.add("점핑 잭(어깨 상급)");
        list.add("어깨 스윙(어깨 상급)");
        list.add("하이퍼 익스텐션(어깨 상급)");
        list.add("파이크 푸쉬업(어깨 상급)");
        list.add("리버스 푸쉬업(어깨 상급)");
        list.add("힌두 푸쉬업(어깨 상급)");
        list.add("바닥 Y 올리기(어깨 상급)");
        list.add("리버스 스노우 엔젤(어깨 상급)");
        list.add("옆으로 누워 바닥 스트레칭 왼쪽(어깨 상급)");
        list.add("옆으로 누워 바닥 스트레칭 오른쪽(어깨 상급)");

        list.add("어깨 스트레칭1(전신 스트레칭)");
        list.add("어깨 스트레칭2(전신 스트레칭)");
        list.add("무릎 끌어당기기(전신 스트레칭)");
        list.add("Toy shoulder(전신 스트레칭)");
        list.add("가슴 스트레칭(전신 스트레칭)");
        list.add("삼두근 스트레칭(전신 스트레칭)");
        list.add("허리 스트레칭(전신 스트레칭)");
        list.add("무릎 런지 스트레칭(전신 스트레칭)");
        list.add("앉아서 나비 스트레칭(전신 스트레칭)");
        list.add("코브라 스트레칭(전신 스트레칭)");
        list.add("엎드려 스트레칭(전신 스트레칭)");

        list.add("목 들어올리기(목 및 어깨 스트레칭)");
        list.add("옆으로 목 스트레칭 왼쪽(목 및 어깨 스트레칭)");
        list.add("옆으로 목 스트레칭 오른쪽(목 및 어깨 스트레칭)");
        list.add("좌우로 목 스트레칭(목 및 어깨 스트레칭)");
        list.add("어깨 돌리기(목 및 어깨 스트레칭)");
        list.add("손 머리 위로 들어 돌리기(목 및 어깨 스트레칭)");
        list.add("삼두근 스트레칭(목 및 어깨 스트레칭)");
        list.add("등 뒤로 손 깍지 끼기(목 및 어깨 스트레칭)");
        list.add("코브라 스트레칭(목 및 어깨 스트레칭)");

        list.add("손 머리 위로 들어 돌리기(상체 스트레칭)");
        list.add("스탠딩 사이드 밴드(상체 스트레칭)");
        list.add("삼두근 스트레칭 왼쪽(상체 스트레칭)");
        list.add("삼두근 스트레칭 오른쪽(상체 스트레칭)");
        list.add("스탠딩 이두근 스트레칭 왼쪽(상체 스트레칭)");
        list.add("스탠딩 이두근 스트레칭 오른쪽(상체 스트레칭)");
        list.add("가슴 스트레칭(상체 스트레칭)");
        list.add("앉아서 옆으로 굽히기 왼쪽(상체 스트레칭)");
        list.add("앉아서 옆으로 굽히기 오른쪽(상체 스트레칭)");
        list.add("앉아서 척추 트위스트 왼쪽(상체 스트레칭)");
        list.add("앉아서 척추 트위스트 오른쪽(상체 스트레칭)");
        list.add("앞쪽 어깨 스트레칭(상체 스트레칭)");

        list.add("한 쪽 다리 힙 회전(하체 스트레칭)");
        list.add("무릎 돌리기(하체 스트레칭)");
        list.add("스탠딩 내전근 스트레칭(하체 스트레칭)");
        list.add("무릎 런지 스트레칭 왼쪽(하체 스트레칭)");
        list.add("무릎 런지 스트레칭 오른쪽(하체 스트레칭)");
        list.add("앉아서 햄스트링 스트레칭 왼쪽(하체 스트레칭)");
        list.add("앉아서 햄스트링 스트레칭 오른쪽(하체 스트레칭)");
        list.add("앉아서 나비 스트레칭(하체 스트레칭)");
        list.add("무릎 당기기 왼쪽(하체 스트레칭)");
        list.add("무릎 당기기 오른쪽(하체 스트레칭)");
        list.add("반듯이 누워 햄스트링 스트레칭 왼쪽(하체 스트레칭)");
        list.add("반듯이 누워 햄스트링 스트레칭 오른쪽(하체 스트레칭)");
        list.add("쿼드 스트레칭 왼쪽(하체 스트레칭)");
        list.add("쿼드 스트레칭 오른쪽(하체 스트레칭)");
        list.add("종아리 스트레칭 왼쪽(하체 스트레칭)");
        list.add("종아리 스트레칭 오른쪽(하체 스트레칭)");
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
        }
        DrawerLayout drawerLayout
                = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}
