package com.lyl.zhuanbei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    EditText text,t1,t2,t3,t4;
    Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //找到控件输入框
        text = (EditText) findViewById(R.id.et_text);
        t1 = (EditText) findViewById(R.id.shop_name);
        t2 = (EditText) findViewById(R.id.shop_sm);
        t3 = (EditText) findViewById(R.id.shop_gj);
        t4 = (EditText) findViewById(R.id.shop_mj);

        mButton = (Button) findViewById(R.id.but2);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击按钮后获取我们输入的值‘

                String text2 = text.getText().toString();
                String Name = t1.getText().toString();
                String SM = t2.getText().toString();
                String GJ = t3.getText().toString();
                String MJ = t4.getText().toString();

                //实例化intent 调用putExtra()方法传输我们获取的值，利用键值对的方法传输
                Intent intent = new Intent();
                intent.putExtra("key",text2);
                intent.putExtra("name",Name);
                intent.putExtra("SM",SM);
                intent.putExtra("GJ",GJ);
                intent.putExtra("MJ",MJ);

                setResult(1,intent);
                finish();
            }
        });

    }
}
