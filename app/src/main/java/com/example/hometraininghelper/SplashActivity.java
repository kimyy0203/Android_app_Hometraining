package com.example.hometraininghelper;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity  extends AppCompatActivity {
//SplashActivity는 AppCompatActivity를 상속받아 액티비티로서 동작한다.
//이 액티비티는 앱이 시작될 때 보여줄 스플래시 화면을 담당한다.
    @Override
    protected void onCreate(Bundle savedInstanceStare) {
    //onCreate 메서드는 액티비티가 생성될 때 호출된다. Bundle savedInstanceState는
    //이전에 저장된 액티비티의 상태를 담고 있는 객체로, 이 메서드를 통해 액티비티의 초기 설정을 한다.
        super.onCreate(savedInstanceStare);
        setContentView(R.layout.activity_splash);
        //setContentView(R.layout.activity_splash)는 XML 파일(activity_splash.xml)을 사용하여 스플래시 화면의 UI를 설정한다.

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
        //Handler 객체를 생성한다. Handler는 스레드 간에 메시지를 전달하거나, 지연된 작업을 수행하는 데 사용된다.
        //postDelayed 메서드는 특정 작업을 일정 시간(밀리초 단위) 뒤에 실행하도록 한다. 여기서는 Runnable 객체가 3초 후에 실행되도록 설정한다.
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
    @Override
    protected void onPause() {
    //postDelayed 메서드는 특정 작업을 일정 시간(밀리초 단위) 뒤에 실행하도록 한다. 여기서는 Runnable 객체가 3초 후에 실행되도록 설정한다.
        super.onPause();
        finish();
    }
}
