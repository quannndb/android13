package com.example.anassert;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import BUITIENDUNG.Result;
import LEMINHKHOI.Message;
import PHAHUUHIEU.ReportingAdvisor;
import VUMINHQUAN.StudyPlan;
import VUMINHQUAN.SuggestedSsubjects;
import VUXUANDIEP.MainDocument;
import VUXUANDIEP.MainTimetable;

public class MainActivity extends AppCompatActivity {
    ImageView back,imageTimetable,imageDocument,imageMessage,
            imageResult,imgAnother,imgReport,imgStudyplane,imgSugsub;

    ConstraintLayout logo,logo1;
    TextView txtUsername;
    String tenThongTinDangNhap="login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getID();
        String username = getIntent().getStringExtra("key_username");
        txtUsername.setText(username);
        getBack();
        activity();
    }
    private void getID(){
        imgReport = findViewById(R.id.imgReport);
        imgStudyplane = findViewById(R.id.imgStudyplane);
        imgSugsub = findViewById(R.id.imgSuggestedsubjects);
        imgAnother = findViewById(R.id.imgAnother);
        logo  = findViewById(R.id.logo);
        logo1  = findViewById(R.id.logo1);
        back = findViewById(R.id.imageback);
        imageTimetable = findViewById(R.id.imageTimetable);
        imageDocument = findViewById(R.id.imageDocument);
        imageMessage = findViewById(R.id.imageMessage);
        imageResult = findViewById(R.id.imageResult);
        txtUsername = findViewById(R.id.txtUsername);

    }
    public void activity(){

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có muốn thoát không?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Đăng xuất thành công", Toast.LENGTH_SHORT).show();

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent backLogin = new Intent(MainActivity.this,Login.class);
                                startActivity(backLogin);
                                finish();
                            }
                        }, 500);
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
        imageTimetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTimetbable = new Intent(MainActivity.this, MainTimetable.class);
                startActivity(intentTimetbable);
            }
        });
        imageDocument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDocument = new Intent(MainActivity.this, MainDocument.class);
                startActivity(intentDocument);
            }
        });
        imageMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMesage = new Intent(MainActivity.this, Message.class);
                startActivity(intentMesage);
            }
        });
        imgReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intentWarning  = new Intent(MainActivity.this, ReportingAdvisor.class);
                startActivity(intentWarning);
            }
        });
        imgStudyplane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentStudyplane = new Intent(MainActivity.this, StudyPlan.class);
                startActivity(intentStudyplane);
            }

        });
        imgSugsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSugsub = new Intent(MainActivity.this, SuggestedSsubjects.class);
                startActivity(intentSugsub);
            }
        });
        imageResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent(MainActivity.this, Result.class);
                startActivity(result);
            }
        });
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentImplicit = new Intent(Intent.ACTION_VIEW, Uri.parse("https://bit.ly/46lQ8G9"));
                startActivity(intentImplicit);
            }
        });
        logo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentImplicit1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://fit.haui.edu.vn/vn"));
                startActivity(intentImplicit1);
            }
        });
        imgAnother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sms();
            }
        });
    }
    private void getBack(){
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backLogin = new Intent(MainActivity.this,Login.class);
                startActivity(backLogin);
                finish();
            }
        });
    }
    //Thông báo tính năng đang trong quá trình phát triển
    private void Sms() {
        Toast.makeText(MainActivity.this, "Tính năng đang trong quá trình phát triển", Toast.LENGTH_SHORT).show();
    }
    private void saveLoginState(){
        SharedPreferences preferences=getSharedPreferences(tenThongTinDangNhap,MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        String username = getIntent().getStringExtra("key_username");
        editor.putString("UserName",username );
        editor.commit();
    }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences(tenThongTinDangNhap,MODE_PRIVATE);
        String username = getIntent().getStringExtra("key_username");
        String userName = preferences.getString("UserName",username);
        txtUsername.setText(userName);
    }
}