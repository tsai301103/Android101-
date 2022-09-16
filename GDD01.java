package com.tqc.gdd01;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GDD01 extends Activity
{
//  step 1 將UI物件在主程式宣告  Button 類別  button1 物件
  private Button button1;
  private TextView text1;
  private String[] s1={"美味蟹堡","義式香腸堡","蔬菜水果堡","香蕉潛艇堡","香烤雞肉堡"};
  private boolean[] checkedList = new boolean[s1.length];

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
// step 2 連結物件 使用findViewById(R.id.button1) , R是resource的意思
// 布局等资源都会在gen目录里的R。java自动生成对应的id
    button1 = (Button) findViewById(R.id.button1);
    text1 = (TextView) findViewById(R.id.text1);

    button1.setOnClickListener(new Button.OnClickListener()
    {
      @Override
      public void onClick(View v)
      {
        //TO DO
        // step 3 會有預設的五個false
        final boolean[] tmp=new boolean[s1.length];
        //  step 4 arraycopy(copyfrom, [from 0], target,[from 0], length)
        System.arraycopy(checkedList,0,tmp,0,checkedList.length);
        //step 5 new AlertDialog
        //setTitle->setMultiChoiceItems->setPositiveButton->show()
        new AlertDialog.Builder(GDD01.this)
                .setTitle(R.string.str2)
//                setMultiChoiceItems(選項,改變字串布林, callback
                .setMultiChoiceItems(s1, tmp, new DialogInterface.OnMultiChoiceClickListener() {
                  @Override
                  public void onClick(DialogInterface dialogInterface, int which, boolean b) {
                  }
                })
                //這邊的confirm直接打入後，選擇O--> 跳出OnClickListener
                .setPositiveButton("confirm", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialogInterface, int which) {
                    System.arraycopy(tmp,0,checkedList,0,checkedList.length);
//                    String msg = getResources().getString(R.string.str2);
                      String msg = getString(R.string.str2);
                    for(int i=0;i<checkedList.length;i++){
                      if (checkedList[i]){
                        msg += "\n" + s1[i];
                      }
                    }
                    text1.setText(msg);  //寫入text1 (屬於UI的TextView)

                  }
                })
                .setNegativeButton("離開", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialogInterface, int i) {

                  }
                })
                .show();
      }
    });
  }
}

