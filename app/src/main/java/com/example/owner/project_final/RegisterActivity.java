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

    }
}
