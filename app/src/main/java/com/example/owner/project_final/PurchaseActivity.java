package com.example.owner.project_final;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PurchaseActivity extends AppCompatActivity {

    ArrayList<PurchaseList> purchaseListArrayList = new ArrayList<PurchaseList>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        Button preButton = (Button)findViewById(R.id.pButton);

        preButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                //이전 페이지로 화면전환
                Intent intent = new Intent (PurchaseActivity.this, PurchaseMapActivity.class);

                startActivity(intent);
            }

        });

        //------------------------------------------------------------------------------------------

        PurchaseList pl1 = new PurchaseList();
        pl1.img = R.drawable.apple;
        pl1.name = "사과";
        pl1.tradeLocation = "가천대학교";
        pl1.tradeDate = "2018.12.22";
        purchaseListArrayList.add(pl1);
        purchaseListArrayList.add(new PurchaseList(R.drawable.hotpack,"핫팩","태평초등학교","2018.12.27"));
        purchaseListArrayList.add(new PurchaseList(R.drawable.tangerine,"귤","복정파출소","2018.12.23"));

        // adapter
        KakaoAdapter adapter = new KakaoAdapter(
                getApplicationContext(), // 현재 화면의 제어권자
                R.layout.purchaselistrow,             // 한행을 그려줄 layout
                purchaseListArrayList);                     // 다량의 데이터

        ListView lv = (ListView)findViewById(R.id.purchaseList);
        lv.setAdapter(adapter);

        // 이벤트 처리
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Log.d("test", "아이템클릭, postion : " + position +
                        ", id : " + id);
            }
        });

    }
}

class KakaoAdapter extends BaseAdapter {
    Context context;     // 현재 화면의 제어권자
    int layout;              // 한행을 그려줄 layout
    ArrayList<PurchaseList> al;     // 다량의 데이터
    LayoutInflater inf; // 화면을 그려줄 때 필요
    public KakaoAdapter(Context context, int layout, ArrayList<PurchaseList> al) {
        this.context = context;
        this.layout = layout;
        this.al = al;
        this.inf = (LayoutInflater)context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() { // 총 데이터의 개수를 리턴
        return al.size();
    }
    @Override
    public Object getItem(int position) { // 해당번째의 데이터 값
        return al.get(position);
    }
    @Override
    public long getItemId(int position) { // 해당번째의 고유한 id 값
        return position;
    }
    @Override // 해당번째의 행에 내용을 셋팅(데이터와 레이아웃의 연결관계 정의)
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = inf.inflate(layout, null);

        ImageView iv = (ImageView)convertView.findViewById(R.id.imageView1);
        TextView tvName=(TextView)convertView.findViewById(R.id.tvName);
        TextView tvSex =(TextView)convertView.findViewById(R.id.tvOrigin);
        TextView tvBirthDay=(TextView)convertView.findViewById(R.id.tvShipDate);

        PurchaseList m = al.get(position);

        iv.setImageResource(m.img);
        tvName.setText(m.name);
        tvSex.setText("거래 장소:"+m.tradeLocation);
        tvBirthDay.setText("거래 일시:" + m.tradeDate);
        return convertView;
    }
}

class PurchaseList { // 자바 빈 (java Bean)
    int img; // 사진 - res/drawable
    String name = "";
    String tradeLocation = "";
    String tradeDate = "";

    // 생성자가 있으면 객체 생성시 편리하다
    public PurchaseList(int img, String name, String tradeLocation, String tradeDate) {
        this.img = img;
        this.name = name;
        this.tradeLocation = tradeLocation;
        this.tradeDate = tradeDate;
    }
    public PurchaseList() {}// 기존 코드와 호환을 위해서 생성자 작업시 기본생성자도 추가
}