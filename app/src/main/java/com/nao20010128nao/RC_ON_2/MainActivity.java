package com.nao20010128nao.RC_ON_2;

import android.app.*;
import android.os.*;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;

public class MainActivity extends Activity 
{
	EditText mes,title;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		title=(EditText)findViewById(R.id.texTitle);
		mes=(EditText)findViewById(R.id.texMes);
		findViewById(R.id.btnEdtMes).setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				title.setVisibility(View.GONE);
				mes.setVisibility(View.VISIBLE);
			}
		});
		findViewById(R.id.btnEdtTitle).setOnClickListener(new View.OnClickListener(){
				public void onClick(View v){
					title.setVisibility(View.VISIBLE);
					mes.setVisibility(View.GONE);
				}
			});
		findViewById(R.id.start).setOnClickListener(new View.OnClickListener(){
				public void onClick(View v){
					startActivity(new Intent(MainActivity.this,NoticeActivity.class));
				}
			});
		
    }
}
