package com.nao20010128nao.RC_ON_2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.drawable.BitmapDrawable;
import android.view.Window;
import java.lang.reflect.InvocationTargetException;
import android.view.MenuItem;
import android.support.v7.app.ActionBar;
import android.os.AsyncTask;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.IOException;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.graphics.Color;
import android.util.Log;

public class NoticeActivity extends AppCompatActivity
{
	static String raw;
	
	WebView wv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		getSupportActionBar().setBackgroundDrawable(new BitmapDrawable(MainActivity.ab));
		getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		getSupportActionBar().setCustomView(R.layout.ab_title);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		try {
			Window.class.getMethod("setStatusBarColor", int.class).invoke(getWindow(), MainActivity.notify.getPixel(0, 0));
		} catch (InvocationTargetException e) {} catch (NoSuchMethodException e) {} catch (IllegalArgumentException e) {} catch (IllegalAccessException e) {}
		
		setContentView(R.layout.webview);
		wv=(WebView)findViewById(R.id.wv);
		wv.setWebViewClient(new WebViewClient(){});
		wv.getSettings().setJavaScriptEnabled(true);
		
		new AsyncTask<Void,Void,String>(){
			public String doInBackground(Void... a){
				if(raw==null){
					InputStreamReader isr=null;
					StringWriter sw=new StringWriter();
					try{
						isr=new InputStreamReader(getAssets().open("page.html"));
						char[] buf=new char[435];int r=-1;
						while(true){
							r=isr.read(buf);
							if(r<1){
								break;
							}
							sw.write(buf,0,r);
						}
					}catch(Throwable e){
						
					}finally{
						try {
							if(isr!=null)isr.close();
						} catch (IOException e) {}
					}
					raw=sw.toString();
				}
				
				String html=raw
					.replace("{TITLE}",getIntent().getStringExtra("title"))
					.replace("{CONTENT}",getIntent().getStringExtra("mes"))
					.replace("989898",getTextColor())
					.replace("febabe",getBgColor());
				return html;
			}
			public void onPostExecute(String s){
				wv.loadData(s,"text/html","UTF-8");
			}
		}.execute();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO: Implement this method
		finish();
		return super.onOptionsItemSelected(item);
	}
	
	public String getTextColor(){
		int color=MainActivity.tex.getPixel(5,5);
		Log.d("getTextColor",color+"");
		
		int r=Color.red(color);
		int g=Color.green(color);
		int b=Color.blue(color);
		
		StringBuilder sb=new StringBuilder(6);
		sb.append(Character.forDigit((r>>4)&0xf,16));
		sb.append(Character.forDigit( r    &0xf,16));
		sb.append(Character.forDigit((g>>4)&0xf,16));
		sb.append(Character.forDigit( g    &0xf,16));
		sb.append(Character.forDigit((b>>4)&0xf,16));
		sb.append(Character.forDigit( b    &0xf,16));
		
		Log.d("getTextColor",sb.toString());
		return sb.toString();
	}
	public String getBgColor(){
		int color=MainActivity.bg.getPixel(5,5);
		Log.d("getTextColor",color+"");

		int r=Color.red(color);
		int g=Color.green(color);
		int b=Color.blue(color);

		StringBuilder sb=new StringBuilder(6);
		sb.append(Character.forDigit((r>>4)&0xf,16));
		sb.append(Character.forDigit( r    &0xf,16));
		sb.append(Character.forDigit((g>>4)&0xf,16));
		sb.append(Character.forDigit( g    &0xf,16));
		sb.append(Character.forDigit((b>>4)&0xf,16));
		sb.append(Character.forDigit( b    &0xf,16));

		Log.d("getTextColor",sb.toString());
		return sb.toString();
	}
}
