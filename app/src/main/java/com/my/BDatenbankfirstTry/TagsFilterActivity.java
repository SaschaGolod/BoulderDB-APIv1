package com.my.BDatenbankfirstTry;

import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.util.*;
import java.util.*;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import android.widget.LinearLayout;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.Intent;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.my.BDatenbankfirstTry.BoulRankStat.BoulderScreen.BoulderActivity;

public class TagsFilterActivity extends AppCompatActivity {
	
	
	private double tagItem = 0;
	
	private ArrayList<HashMap<String, Object>> TagsListmap = new ArrayList<>();

	private CheckBox checkbox1;
	private ListView listview1;
	
	private SharedPreferences tags;
	private Intent i = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.tags_filter);
		initialize();
		initializeLogic();
	}
	
	private void initialize() {
		LinearLayout linear2;
		TextView abbrechen_txt;
		TextView alle_txt;
		TextView keine_txt;
		TextView akzeptieren_txt;

        checkbox1 = findViewById(R.id.checkbox1);
		listview1 = findViewById(R.id.listview1);
		linear2 = findViewById(R.id.linear2);
		abbrechen_txt = findViewById(R.id.abbrechen_txt);
		alle_txt = findViewById(R.id.alle_txt);
		keine_txt = findViewById(R.id.keine_txt);
		akzeptieren_txt = findViewById(R.id.akzeptieren_txt);
		tags = getSharedPreferences("tags", Activity.MODE_PRIVATE);
		
		checkbox1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (TagsListmap.get(0).get("checked").toString().equals("1")) {
					TagsListmap.get(0).put("checked", "0");
				}
				else {
					TagsListmap.get(0).put("checked", "1");
				}
				listview1.setAdapter(new Listview1Adapter(TagsListmap));
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			}
		});
		
		linear2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				
			}
		});
		
		abbrechen_txt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				finish();
			}
		});
		
		alle_txt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				checkbox1.setChecked(true);
				tagItem = 0;
				for(int _repeat13 = 0; _repeat13 < (TagsListmap.size()); _repeat13++) {
					TagsListmap.get((int)tagItem).put("checked", "1");
					tagItem++;
				}
				listview1.setAdapter(new Listview1Adapter(TagsListmap));
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			}
		});
		
		keine_txt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				checkbox1.setChecked(false);
				tagItem = 0;
				for(int _repeat12 = 0; _repeat12 < (TagsListmap.size()); _repeat12++) {
					TagsListmap.get((int)tagItem).put("checked", "0");
					tagItem++;
				}
				listview1.setAdapter(new Listview1Adapter(TagsListmap));
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			}
		});
		
		akzeptieren_txt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				tags.edit().putString("tags", new Gson().toJson(TagsListmap)).apply();
				i.putExtra("tags", new Gson().toJson(TagsListmap));
				i.putExtra("filter", "first");
				i.setClass(getApplicationContext(), BoulderActivity.class);
				startActivity(i);
			}
		});
	}
	private void initializeLogic() {
		TagsListmap = new Gson().fromJson(getIntent().getStringExtra("tags"), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		checkbox1.setChecked(TagsListmap.get(0).get("checked").toString().equals("1"));
		listview1.setAdapter(new Listview1Adapter(TagsListmap));
		((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
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
		finish();
	}
	public class Listview1Adapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		@Override
		public View getView(final int _position, View _view, ViewGroup _viewGroup) {
			LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _v = _view;
			if (_v == null) {
				_v = _inflater.inflate(R.layout.tags_boxlist, null);
			}
			
			final CheckBox checkbox_tags = _v.findViewById(R.id.checkbox_tags);
			
			if (_position == 0) {
				checkbox_tags.setVisibility(View.GONE);
			}
			else {
				checkbox_tags.setVisibility(View.VISIBLE);
				checkbox_tags.setText(TagsListmap.get(_position).get("image").toString().concat(TagsListmap.get(_position).get("name").toString()));
				checkbox_tags.setChecked(TagsListmap.get(_position).get("checked").toString().equals("1"));
				if (TagsListmap.get(0).get("checked").toString().equals("1")) {
					checkbox_tags.setEnabled(true);
				}
				else {
					checkbox_tags.setEnabled(false);
				}
			}
			checkbox_tags.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (TagsListmap.get(_position).get("checked").toString().equals("1")) {
						TagsListmap.get(_position).put("checked", "0");
					}
					else {
						TagsListmap.get(_position).put("checked", "1");
					}
				}
			});
			
			return _v;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
