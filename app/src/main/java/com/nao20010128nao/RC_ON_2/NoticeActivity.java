package com.nao20010128nao.RC_ON_2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.drawable.BitmapDrawable;
import android.view.Window;
import java.lang.reflect.InvocationTargetException;
import android.view.MenuItem;
import android.support.v7.app.ActionBar;

public class NoticeActivity extends AppCompatActivity
{
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
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO: Implement this method
		finish();
		return super.onOptionsItemSelected(item);
	}
}
