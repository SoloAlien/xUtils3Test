package com.example.alien.xutilstest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x.view().inject(this);
    }
    @Event(R.id.btn)
//    @Event(value = R.id.btn,type = View.OnClickListener.class)
    private void click(View view){

        switch (view.getId()){
            case R.id.btn:
                Intent intent=new Intent(this,DBActivity.class);
                startActivity(intent);
                break;
        }
    }
}
