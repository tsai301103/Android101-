package com.tqc.gdd01;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class orderSystem extends Activity
{
  private Button button1;
  private TextView text1;
  private String[] s1={"美味蟹堡","義式香腸堡","蔬菜水果堡","香蕉潛艇堡","香烤雞肉堡"};
  private boolean[] checkedList = new boolean[s1.length];

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    button1 = (Button) findViewById(R.id.button1);
    text1 = (TextView) findViewById(R.id.text1);

    button1.setOnClickListener(new Button.OnClickListener()
    {
      @Override
      public void onClick(View v)
      {
        //TO DO
        final boolean[]tmp = new boolean[s1.length];
        System.arraycopy(checkedList,0,tmp,0,s1.length);

        new AlertDialog.Builder(orderSystem.this)
                .setTitle(R.string.str0)
                .setMultiChoiceItems(s1, tmp, new DialogInterface.OnMultiChoiceClickListener() {
                  @Override
                  public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                  }
                })
                .setPositiveButton("confirm", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialogInterface, int i) {
                    String msg="";
                    System.arraycopy(tmp,0,checkedList,0,s1.length);
                    for (int k=0; k<s1.length;k++){
                      if (checkedList[k]){
                        msg += s1[k]+"\n";
                      }
                    }
                    text1.setText(msg);
                  }
                })
                .setNegativeButton("leave", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialogInterface, int i) {

                  }
                })
                .show();
      }
    });
  }
}

