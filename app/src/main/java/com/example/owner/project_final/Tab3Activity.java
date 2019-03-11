package com.example.owner.project_final;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Tab3Activity extends MainActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab3);

        final Button purchaseButton = (Button) findViewById(R.id.purchaseButton);
        final Button foodButton = (Button) findViewById(R.id.foodButton);
        final Button hobbyButton = (Button) findViewById(R.id.hobbyButton);
        final Button roomButton = (Button) findViewById(R.id.roomButton);
        final ImageButton myButton = (ImageButton) findViewById(R.id.myButton);
        final ImageButton writeButton = (ImageButton) findViewById(R.id.writeButton);



        purchaseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                //다음페이지로 화면을 전환
                //화면 전환시 사용하는 클래스
                Intent intent1 = new Intent(Tab3Activity.this, PurchaseMapActivity.class);
                //화면전환하기
                startActivity(intent1);
            }

        });

        foodButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent2 = new Intent(Tab3Activity.this, FoodActivity.class);
                startActivity(intent2);
            }
        });

        roomButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent3 = new Intent(Tab3Activity.this, RoomActivity.class);
                startActivity(intent3);
            }
        });

        hobbyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent4 = new Intent(Tab3Activity.this, HobbyActivity.class);
                startActivity(intent4);
            }
        });

        myButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent5 = new Intent(Tab3Activity.this, MypageActivity.class);
                startActivity(intent5);
            }
        });

        writeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent6 = new Intent(Tab3Activity.this, WriteActivity.class);
                startActivity(intent6);
            }
        });

        //------------------------------------------------------------------------------------------
        Button btn3_first=(Button)findViewById(R.id.btn3_first);
        Button btn3_second=(Button)findViewById(R.id.btn3_second);
        Button btn3_third=(Button)findViewById(R.id.btn3_third);


        btn3_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent().setClass( Tab3Activity.this,Tab1Activity.class );
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        btn3_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent().setClass( Tab3Activity.this,Tab2Activity.class );
                startActivity(intent);
                overridePendingTransition(0, 0);

            }
        });
        btn3_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent().setClass( Tab3Activity.this,Tab3Activity.class );
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

    }
}
