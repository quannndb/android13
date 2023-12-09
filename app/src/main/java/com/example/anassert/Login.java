package com.example.anassert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class Login extends AppCompatActivity {
    Button btnLogin,btnSignup;
    EditText editUsername, editPassword;
    TextView txtMiss;
    CheckBox chkLuuThongTin;
    String tenThongTinDangNhap="login";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getID();
        app();
    }
    private void app(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveLoginState();
                String user = editUsername.getText().toString();
                String password = editPassword.getText().toString();
                if(user.equals("")  || password.equals("") ){
                    Toast.makeText(Login.this,"Yêu cầu nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
                }else{

                        Toast.makeText(Login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                String username = editUsername.getText().toString().trim();
                                Intent intentMain = new Intent(Login.this, MainActivity.class);
                                intentMain.putExtra("key_username", username);
                                startActivity(intentMain);
                                finish();
                            }
                        }, 500);

                }
            }
        });
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sms();
            }
        });
        txtMiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sms();
            }
        });
    }
    private void Sms(){
        Toast.makeText(Login.this, "Chức năng đang trong quá trình phát triển", Toast.LENGTH_SHORT).show();
    }
    private void getID(){
        btnLogin =  findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);
        editUsername = findViewById(R.id.editUsername) ;
        editPassword = findViewById(R.id.editPassword);
        txtMiss  = findViewById(R.id.txtMiss);
        chkLuuThongTin = findViewById(R.id.chkLuuThongTin);
    }
    private void saveLoginState(){
        SharedPreferences preferences=getSharedPreferences(tenThongTinDangNhap,MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("UserName", editUsername.getText().toString());
        editor.putString("PassWord", editPassword.getText().toString());
        editor.putBoolean("Save", chkLuuThongTin.isChecked());
        editor.commit();
    }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences(tenThongTinDangNhap,MODE_PRIVATE);
        String userName = preferences.getString("UserName","");
        String pass = preferences.getString("PassWord","");
        boolean save = preferences.getBoolean("Save",false);
        if (save) {
            editUsername.setText(userName);
            editPassword.setText(pass);
            chkLuuThongTin.setChecked(save);
        }
    }
}