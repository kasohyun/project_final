package com.example.owner.project_final;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Calendar;
import java.util.Date;

import static android.icu.util.Calendar.YEAR;

public class Tab1Activity extends MainActivity {
    // 달력받아와서
    // 체크박스 등록 -> 알림창으로 나타내기

    //------------------------------------------------------------------------------------------
    //Dialog dia;
    //------------------------------------------------------------------------------------------
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference userCR  = db.collection("users"); // 파이어베이스 콜렉션(모든유저들의 값)



    int year, month, date ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab1);

       final CalendarView cal1 = (CalendarView)findViewById(R.id.cal1);


       /* cal1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

            }
        });*/

        //------------------------------------------------------------------------------------------

        Button btn1_first=(Button)findViewById(R.id.btn1_first);
        Button btn1_second=(Button)findViewById(R.id.btn1_second);
        Button btn1_third=(Button)findViewById(R.id.btn1_third);   // 삭제될 예정


        btn1_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent().setClass( Tab1Activity.this,Tab1Activity.class );
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        btn1_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent().setClass( Tab1Activity.this,Tab2Activity.class );
                startActivity(intent);
                overridePendingTransition(0, 0);

            }
        });
        btn1_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent().setClass( Tab1Activity.this,Tab3Activity.class );
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });


        //------------------------------------------------------------------------------------------


        cal1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year1, int month1, int dayOfMonth1) {
                year = year1 ;
                month = month1+1;
                date = dayOfMonth1 ;


                String data = String.format("%d-%d-%d", year, month, date);
               //  userCR.whereEqualTo( ,data);

                if(db.collection("users").document(data).get() != null){

                    db.collection("users")
                            .get()
                            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                    if (task.isSuccessful()) {
                                        for (QueryDocumentSnapshot document : task.getResult()) {
                                            System.out.println("성공");
                                        }
                                    } else {
                                        System.out.println("실패");
                                    }
                                }
                            });

                    Intent intent = new Intent(getApplicationContext(), checkbox_tab1.class);
                    intent.putExtra("today", data);
                    startActivity(intent);

                }
                else{


                    Intent intent = new Intent(getApplicationContext(), checkbox_tab1.class);
                    intent.putExtra("today", data);
                    startActivity(intent);

                }




            }
        });

        // 1. 날짜가 입력된날짜로만 뜸 선택된날짜로 출력안됨 - 완료!!!
        // 2. 데이터베이스에 저장한 값들을 날짜에 맞게 불러올수있어야함
        // OrderByChild()
        // 3. 선택된 날짜를 통해 알고리즘? 작성하여 메세지를 제공할수있어야함




    }





}
