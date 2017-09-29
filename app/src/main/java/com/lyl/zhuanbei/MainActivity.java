package com.lyl.zhuanbei;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ProgressBar p1,p2,p3;
    TextView t1,t2,t3;
    String lefe,GJ,MJ;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找到控件
        Button but= (Button) findViewById(R.id.button);
        button3= (Button) findViewById(R.id.button3);

        p1 = (ProgressBar) findViewById(R.id.pblife);
        p2 = (ProgressBar) findViewById(R.id.pbgj);
        p3 = (ProgressBar) findViewById(R.id.pb_mj);

        t1 = (TextView) findViewById(R.id.te_life);
        t2 = (TextView) findViewById(R.id.te_gj);
        t3 = (TextView) findViewById(R.id.te_mj);

        initPB();//此函数功能设置进度条的最大值


        //点击按钮实现跳转功能
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent init = new Intent(MainActivity.this,Main2Activity.class);
                startActivityForResult(init,1);
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent init1 = new Intent(MainActivity.this,SecondActivity.class);
                startActivityForResult(init1,2);
            }
        });
    }
    public void initPB(){
        p1.setMax(1000);
        p2.setMax(1000);
        p3.setMax(1000);
    }

    //获取返回的值。这一个方法接收Intent给我们返回的值
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1) {//requestCode 表示开始发送数据时的值 例如：startActivityForResult(init,1);
            String s = data.getStringExtra("key");//通过键值获取我们传送过来的值
            Log.d("Main", s);
            String name = data.getStringExtra("name");
            Log.d("Main", name);
            lefe = data.getStringExtra("SM");
            Log.d("Main", lefe);
            GJ = data.getStringExtra("GJ");
            Log.d("Main", GJ);
            MJ = data.getStringExtra("MJ");
            Log.d("Main", MJ);
            updata();//更新进度条的值和textView上的值

        }else if (requestCode==2){
             String second =data.getStringExtra("second");
             Log.d("Second",second);
        }

    }

    public void updata(){
        int pb1 =p1.getProgress();//获取进度条的值
        int pb2 = p2.getProgress();
        int pb3 = p3.getProgress();

        Log.d("progress", String.valueOf(pb1));

        p1.setProgress(pb1+Integer.parseInt(lefe));//重新设置进度条上的值
        p2.setProgress(pb2+Integer.parseInt(GJ));
        p3.setProgress(pb3+Integer.parseInt(MJ));

        int i1 =pb1+Integer.parseInt(lefe) ;//获取进度条上原有的值，加上再一次输入的值。
        int i2 =pb2+Integer.parseInt(GJ) ;
        int i3 =pb3+Integer.parseInt(MJ) ;

        t1.setText(String.valueOf(i1));//设置后面的TextView
        t2.setText(String.valueOf(i2));
        t3.setText(String.valueOf(i3));
    }
}
