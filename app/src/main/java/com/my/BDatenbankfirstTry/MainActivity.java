package com.my.BDatenbankfirstTry;

import android.os.*;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

import java.util.Timer;
import java.util.TimerTask;
import android.view.View;
import com.my.BDatenbankfirstTry.BoulRankStat.BoulderScreen.BoulderActivity;

import android.support.v4.content.ContextCompat;
import android.support.v4.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class MainActivity extends AppCompatActivity {

	private Timer _timer = new Timer();

	private double click_exit = 0;

	private TextView textview3;
	
	private Intent intent = new Intent();

	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize();
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
		}
		else {
			initializeLogic();
		}
	}
	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (1000 == requestCode) {
			initializeLogic();
		}
	}
	
	private void initialize() {

		Button button1 = findViewById(R.id.button1);
		Button button2 = findViewById(R.id.button2);
		textview3 = findViewById(R.id.textview3);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				//intent.putExtra("filter", "first");
				//intent.putExtra("tags", "first");
				intent.setClass(getApplicationContext(), BoulderActivity.class);
				startActivity(intent);
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				intent.setClass(getApplicationContext(), AddProblemsActivity.class);
				startActivity(intent);
			}
		});
	}
	private void initializeLogic() {
		textview3.setText(FileUtil.readFile(FileUtil.getExternalStorageDir().concat("/010/BDaten4.json")));
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);

		switch (_requestCode) {

			default:
			break;
		}
	}

	@Override
	public void onBackPressed() {
		if (click_exit == 0) {
			SketchwareUtil.showMessage(getApplicationContext(), "Click again to exit");
			TimerTask timerExit = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							click_exit = 1;
						}
					});
				}
			};
			_timer.schedule(timerExit, (0));
			timerExit = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							click_exit = 1;
						}
					});
				}
			};
			_timer.schedule(timerExit, 1500);
		}
		if (click_exit == 1) {
			finish();
		}
	}
	
}
