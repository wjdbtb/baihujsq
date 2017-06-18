package com.example.administrator.myjsqyy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.Reader;

public class MainActivity extends AppCompatActivity {
//    private TextView ding_view;
//    private RadioGroup actors_rop;
    //定义数组
    private EditText editText[][]=new EditText[3][4];
    //修改胡大小的
    private EditText the_size;
    //定义胡大小
    private double size=0.5;
    //定义活鸟
    private int dphn[]={0,0,0,0};
    //定义托鸟
    private int dptn[]={0,0,0,0};
    //定义胡息
    private int dphx[]={0,0,0,0};
    //输赢钱
    double out[]={0,0,0,0};
    private  TextView the_out[]=new TextView[4];
    private Button out_btn,clean_btn,xx_btn;
    // private  MyCalculateOnClickListener mycal =new MyoutAnnu

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        the_out[0]=(TextView)findViewById(R.id.out1);
        the_out[1]=(TextView)findViewById(R.id.out2);
        the_out[2]=(TextView)findViewById(R.id.out3);
        the_out[3]=(TextView)findViewById(R.id.out4);
        the_size=(EditText)findViewById(R.id.size);
        editText[0][0]=(EditText)findViewById(R.id.editText11);
        editText[0][1]=(EditText)findViewById(R.id.editText21);
        editText[0][2]=(EditText)findViewById(R.id.editText31);
        editText[0][3]=(EditText)findViewById(R.id.editText41);
        editText[1][0]=(EditText)findViewById(R.id.editText12);
        editText[1][1]=(EditText)findViewById(R.id.editText22);
        editText[1][2]=(EditText)findViewById(R.id.editText32);
        editText[1][3]=(EditText)findViewById(R.id.editText42);
        editText[2][0]=(EditText)findViewById(R.id.editText13);
        editText[2][1]=(EditText)findViewById(R.id.editText23);
        editText[2][2]=(EditText)findViewById(R.id.editText33);
        editText[2][3]=(EditText)findViewById(R.id.editText43);

    }

  //  class MyClearAnnu implements View.OnClickListener{}

    public void onClick1(View v){
            clear();
        }
    public void onClick(View v){
        init();
        tomath();
        quout();
    }
    public void onClick2(View v){
        System.exit(0);
    }


    private  void  clear(){//清除
        for (int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                editText[i][j].setText("0");
            }
        }
        for(int i=0;i<4;i++){
            the_out[i].setText("0");
        }
    }

    //初始化检查
    private void  init(){
        for (int i=0;i<3;i++){
            for (int j=0;j<4;j++){
                if(editText[i][j].getText().toString().equals(""))
                    editText[i][j].setText("0");
            }
        }
        if(the_size.getText().toString().equals(""))
            the_size.setText("0.5");
        try{
            for(int i=0;i<4;i++){
                dphn[i]=Integer.parseInt(editText[0][i].getText().toString());
                dptn[i]=Integer.parseInt(editText[1][i].getText().toString());
                dphx[i]=Integer.parseInt(editText[2][i].getText().toString());
            }
            size=Double.parseDouble(the_size.getText().toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //比较
    private  int conpare(int a,int b){
    if (a==b) return 0;
    else if(a>b) return 1;
    else return -1;
    }
    //四舍五入
    private  int myInt(int dphx) {
        if (dphx >= 0) {
            if (dphx % 10 < 5)
                dphx = dphx / 10 * 10;
            else
                dphx = (dphx / 10 + 1) * 10;
        }
        else {
            if (dphx % 10 < 5)
                dphx = dphx / 10 * 10;
            else
                dphx = (dphx / 10 - 1) * 10;
        }
        return dphx;
    }
    //计算方法
    private void tomath(){
        out[0]= out[1]= out[2]= out[3]=0;//初始化
        //两两计算
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                //计算托鸟
                out[i]+=conpare(dphx[i],dphx[j])*(dptn[i]+dptn[j]);
                //计算活鸟
                out[i]+=(myInt(dphx[i])-myInt(dphx[j]))*(dphn[i]+1)*(dphn[j]+1)*size;
            }
        }
    }
    private void  quout(){
        for (int i=0;i<4;i++){
            the_out[i].setText(String.valueOf(Math.round(out[i]*10/10.0)));
        }
    }



}
