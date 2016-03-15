package com.nao20010128nao.RC_ON_2;

import android.app.*;
import android.os.*;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class MainActivity extends Activity 
{
	public static Bitmap ab,tex,notify;
	
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
		ab=BitmapFactory.decodeResource(getResources(),R.drawable.abcol);
		tex=BitmapFactory.decodeResource(getResources(),R.drawable.texcol);
		notify=BitmapFactory.decodeResource(getResources(),R.drawable.notifycol);
    }
}
