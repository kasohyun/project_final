package com.example.owner.project_final;

/** ViewPager - Fragment
 *  TabHost (Failed)
 */

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.owner.project_final.model.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends LoginActivity {

    private EditText email;
    private EditText password;
    private EditText name;
    private EditText cname;
    private EditText birth;
    private EditText number;
    private Button signup;
    //private String splash_background;

    //FirebaseDatabase fd;
    //DatabaseReference fdRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        FirebaseRemoteConfig mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        String splash_background = mFirebaseRemoteConfig.getString("splash_background");
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.parseColor(splash_background));
        }
        */
        email = (EditText)findViewById(R.id.registerActivity_edittext_email);
        password = (EditText)findViewById(R.id.registerActivity_edittext_password);
        name = (EditText)findViewById(R.id.registerActivity_edittext_name);
        signup = (Button)findViewById(R.id.registerActivity_button_signup);
        cname = (EditText)findViewById(R.id.registerActivity_edittext_cname);
        number = (EditText)findViewById(R.id.registerActivity_edittext_number);
        birth = (EditText)findViewById(R.id.registerActivity_edittext_birth);
        //signup.setBackgroundColor(Color.parseColor(splash_background));

        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                if (email.getText().toString() == null || name.getText().toString() == null || password.getText().toString() == null || cname.getText().toString() == null || number.getText().toString() == null || birth.getText().toString() == null || name.getText().toString() == null) {
                    return;
                }
                FirebaseAuth.getInstance()
                        .createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                UserModel userModel = new UserModel();
                                userModel.userName = name.getText().toString();

                                String uid = task.getResult().getUser().getUid();
                                FirebaseDatabase.getInstance().getReference().child("users").child(uid).setValue(userModel);

                            }
                        });
            }
        });

/*
        fd = FirebaseDatabase.getInstance();
        fdRef = fd.getReference("users");
        // CRUD 작업의 기준이 되는 노드를 레퍼런스로 가져옵니다.
        // users 이하의 노드들을 가리킴

        .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = fdRef.push().getKey(); // 키를생성하고 키 값을 가져온다.

                String name = nameText.getText().toString();
                String birth = birthText.getText().toString();
                String id = idText.getText().toString();
                String password = passwordText.getText().toString();
                String cname = cnameText.getText().toString();
                String address = addressText.getText().toString();
                String number = numberText.getText().toString();

                String auth = authText.getText().toString();
                Map<String, String > postValues = new HashMap<>();
                // Map<key, value> 형태로 저장합니다.
                // Map 인터페이스의 한 종류로 ( "Key", value) 로 이뤄져 있다
                // key 값을 중복이 불가능 하고 value는 중복이 가능. value에 null값도 사용 가능하다.
                // 멀티쓰레드에서 동시에 HashMap을 건드려 Key - value값을 사용하면 문제가 될 수 있다. 멀티쓰레드에서는 HashTable을 쓴다
                postValues.put("name", name);
                postValues.put("birth", birth);
                postValues.put("id", id);
                postValues.put("password", password);
                postValues.put("cname", cname);
                postValues.put("address", address);
                postValues.put("number", number);

                // postValues.put("auth",auth); 인증번호 - SMTP사용
                DatabaseReference keyRef = fdRef.child(key);
                // fdRef의 자식 키값을 가리킨다.
                keyRef.setValue(postValues);
                // 클래스
                Toast.makeText(getApplicationContext(), "가입완료.",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class );
                startActivity(intent);
                finish();
            }
        });
*/

    }
}
