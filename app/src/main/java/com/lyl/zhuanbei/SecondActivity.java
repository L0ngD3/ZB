package com.lyl.zhuanbei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    EditText mEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
               mEditText = (EditText) findViewById(R.id.shuru);

        Button button = (Button) findViewById(R.id.butsecond);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = mEditText.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("second",s);
                setResult(1,intent);
                finish();
            }
        });
    }
}
