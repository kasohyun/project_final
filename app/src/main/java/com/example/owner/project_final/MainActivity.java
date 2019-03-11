package com.example.owner.project_final;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_first=(Button)findViewById(R.id.btn_first);

        Button btn_second=(Button)findViewById(R.id.btn_second);
        Button btn_third=(Button)findViewById(R.id.btn_third);


        btn_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   intent = new Intent().setClass( MainActivity.this,Tab1Activity.class );
                   startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        btn_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent().setClass( MainActivity.this,Tab2Activity.class );
                startActivity(intent);
                overridePendingTransition(0, 0);

            }
        });
        btn_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent().setClass( MainActivity.this,Tab3Activity.class );
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });




    }


}


/** TabHost (Failed) */
/*
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TabHost;
import android.widget.Toolbar;

public class MainActivity extends TabActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent;

        TabHost tabhost =getTabHost();
        tabhost.setup(getLocalActivityManager());


        intent = new Intent().setClass(this, Tab1Activity.class );
        TabHost.TabSpec first = tabhost.newTabSpec("read").setIndicator("오늘하루");
        first.setContent(R.id.first);
        tabhost.addTab(first);
        first.setContent(intent);

        intent = new Intent().setClass(this, Tab2Activity.class );
        TabHost.TabSpec second = tabhost.newTabSpec("location").setIndicator("위치");
        second.setContent(R.id.second);
        tabhost.addTab(second);
        second.setContent(intent);

        intent = new Intent().setClass(this, Tab3Activity.class );
        TabHost.TabSpec third = tabhost.newTabSpec("board").setIndicator("게시판");
        third.setContent(R.id.third);
        tabhost.addTab(third);
        third.setContent(intent);

        tabhost.setCurrentTab(0);

        /* TabHost tabHost = (TabHost) findViewById(R.id.tabhost);
        tabHost.setup(getLocalActivityManager());

        tabhost.addTab(tabhost.newTabSpec("read").setIndicator("오늘하루")
            .setContent(new Intent(this, Tab1Activity.class)));
        tabhost.addTab(tabhost.newTabSpec("location").setIndicator("위치")
                .setContent(new Intent(this, Tab2Activity.class)));
        tabhost.addTab(tabhost.newTabSpec("board").setIndicator("게시판")
                .setContent(new Intent(this, Tab3Activity.class)));*/
/*
        Resources resources = getResources();
        TabHost tabHost = getTabHost();
        TabHost.TabSpec spec1, spec2, spec3;
        Intent intent;

        intent = new Intent().setClass(this, Tab1Activity.class);
        intent = new Intent().setClass(this, Tab2Activity.class);
        intent = new Intent().setClass(this, Tab3Activity.class);

        spec1 = tabHost.newTabSpec("read").setIndicator("오늘하루");
        spec2 = tabHost.newTabSpec("location").setIndicator("위치");
        spec3 = tabHost.newTabSpec("board").setIndicator("게시판");

        spec1.setContent(intent);
        spec2.setContent(intent);
        spec3.setContent(intent);

        tabHost.addTab(spec1);
        tabHost.addTab(spec2);
        tabHost.addTab(spec3);

    }

}
*/

