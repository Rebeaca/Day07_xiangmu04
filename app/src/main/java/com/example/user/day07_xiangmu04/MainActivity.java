package com.example.user.day07_xiangmu04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.user.day07_xiangmu04.Business.Guess;

public class MainActivity extends AppCompatActivity {
    private Button bt_low,bt_high;
    private ImageView show;
    private Guess g1=new Guess();
    private Intent intent1=new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化空间
        init();
        //设置监听事件
        bt_low.setOnClickListener(new ButtonListener());
        bt_high.setOnClickListener(new ButtonListener());
    }

    private void init() {
        bt_high= (Button) findViewById(R.id.button2);
        bt_low= (Button) findViewById(R.id.button1);
        show= (ImageView) findViewById(R.id.imageView);
        intent1.setClass(MainActivity.this,GameActivity.class);
    }
    public class ButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button1:
                    //跳转界面------------传参LEVEL_LOW
                    intent1.putExtra(Guess.LEVEL_LOW_S,g1.Level(Guess.LEVEL_LOW_S));
                   startActivityForResult(intent1,1);//第一个参数是intent，第二个是请求吗
                    break;
                case R.id.button2:
                    //跳转界面------------传参LEVEL_HIGH
                    intent1.putExtra(Guess.LEVEL_HIGH_S,g1.Level(Guess.LEVEL_HIGH_S));
                    startActivityForResult(intent1,2);//第一个参数是intent，第二个是请求吗
                    break;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==Guess.RESULT_LOW){
            show.setBackgroundResource(R.drawable.no);
        }else if (resultCode==Guess.RESULT_HIGH){
            show.setBackgroundResource(R.drawable.ok);
        }
        else {
            show.setBackgroundResource(R.drawable.ic_launcher);
        }
    }
}
