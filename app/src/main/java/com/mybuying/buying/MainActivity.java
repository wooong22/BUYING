package com.mybuying.buying;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

import com.mybuying.buying.buying.AgencyActivity;
import com.mybuying.buying.buying.RecommendActivity;

public class MainActivity extends AppCompatActivity {

    TabHost tabHost;
//
//    private static final String TAB_TAB1 = "tab1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        tabHost.addTab(tabHost.newTabSpec("home").setIndicator("home").setContent(R.id.home));
        tabHost.addTab(tabHost.newTabSpec("buying").setIndicator("buying").setContent(R.id.buying));
        tabHost.addTab(tabHost.newTabSpec("my").setIndicator("my").setContent(R.id.my));

//        TabHost.TabSpec spec = tabHost.newTabSpec("home");
//        TabView tabView = new TabView(this);
//        tabView.setTitle("HOME");
//        spec.setIndicator(tabView);
////        spec.setIndicator("TAB 1");
//        spec.setContent(R.id.home);
//        tabHost.addTab(spec);

//        spec = tabHost.newTabSpec("buying");
//        tabView = new TabView(this);
//        tabView.setTitle("BUYING");
//        spec.setIndicator(tabView);
////        spec.setIndicator("TAB 2");
//        spec.setContent(R.id.buying);
//        tabHost.addTab(spec);
//
//        spec = tabHost.newTabSpec("my");
//        tabView = new TabView(this);
//        tabView.setTitle("MY");
//        spec.setIndicator(tabView);
////        spec.setIndicator("TAB 3");
//        spec.setContent(R.id.my);
//        tabHost.addTab(spec);

        Button button = (Button)findViewById(R.id.recommend);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecommendActivity.class);
                intent.putExtra("tabHost", "2".toString()); // 뒤에 넘어가는 1은 탭인덱스
                startActivity(intent);
        //        ((RecommendActivity) getParent()).getTabHost().setCurrentTab(1);

         //                      RecommendActivity.tabHost.setCurrentTab(1);

            }
        });

        button = (Button)findViewById(R.id.agency);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AgencyActivity.class);
                startActivity(intent);
 //               AgencyActivity.tabHost.setCurrentTab(1);
            }
        });
    }



}