package com.example.user.day07_xiangmu04;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.day07_xiangmu04.Business.Guess;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private TextView timer,hint;
    private EditText input;
    private Button check;
    private Intent intent=getIntent();
    private int RandomNum=0;
    private String flag;//定义一个标志，来存放结果（输赢）
    private Guess bb=new Guess();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //初始化空间
        init();
        //设置监听事件
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //比对结果
                flag= bb.Check(input.getText().toString(),RandomNum);
                if (flag.equals("相等")){
                    setResult(Guess.RESULT_HIGH);
                    finish();
                }
                else if (flag.equals("大于")){
                    //更新ui，大了或者小了
                    hint.setText("大于");
                    setResult(Guess.RESULT_LOW);
                }
                else if (flag.equals("小于")){
                    //更新ui，大了或者小了
                    setResult(Guess.RESULT_LOW);
                    hint.setText("小于");
                }
                Toast.makeText(GameActivity.this,"结果是："+flag+"随机数是："+RandomNum+"你的输入是："+input.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
    private void init() {
        check= (Button) findViewById(R.id.button_bd);
        timer= (TextView) findViewById(R.id.tv_timer);
        hint= (TextView) findViewById(R.id.hint);
        input= (EditText) findViewById(R.id.editText_input);
        new Task().execute();

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1){
            RandomNum=Integer.parseInt(intent.getStringExtra(Guess.LEVEL_LOW_S));
        }
        if (requestCode==2){
            RandomNum=Integer.parseInt(intent.getStringExtra(Guess.LEVEL_HIGH_S));
        }
    }
    public class Task extends AsyncTask<Void, Integer, String> {

        @Override
        protected String doInBackground(Void... params) {
            for (int i=1;i<=30;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i);
            }
            return null;

        }

        @Override
        protected void onPostExecute(String s) {
            setResult(Guess.RESULT_LOW);
            finish();
            super.onPostExecute(s);

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            timer.setText(values[0]+"");
            super.onProgressUpdate(values);

        }

    }
}
