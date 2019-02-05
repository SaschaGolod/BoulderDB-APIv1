package com.my.BDatenbankfirstTry.BoulRankStat.BoulderScreen.BoulderScreen.GradeFilter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.my.BDatenbankfirstTry.BoulRankStat.BoulderScreen.BoulderActivity;
import com.my.BDatenbankfirstTry.R;
import com.my.BDatenbankfirstTry.SketchwareUtil;

import java.util.ArrayList;
import java.util.HashMap;

public class GradeFilterActivity extends AppCompatActivity {


    private double n = 0;

    private ArrayList<HashMap<String, Object>> grades_topList = new ArrayList<>();

    private ListView boulder_grades_list;
    private TextView total_boulder;

    private SharedPreferences grades;

    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        setContentView(R.layout.grade_filter);
        initialize();
        initializeLogic();
    }

    private void initialize() {

        TextView abbrechen_txt = findViewById(R.id.abbrechen_txt);
        TextView alle_txt = findViewById(R.id.alle_txt);
        TextView keine_txt = findViewById(R.id.keine_txt);
        boulder_grades_list = findViewById(R.id.listview1);
        total_boulder = findViewById(R.id.total_boulder);
        TextView akzeptieren_txt = findViewById(R.id.akzeptieren_txt);


        grades = getSharedPreferences("grades", Activity.MODE_PRIVATE);

        abbrechen_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        alle_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n = 0;
                for (int _repeat32 = 0; _repeat32 < (6); _repeat32++) {
                    grades_topList.get((int) n).put("checked", "1");
                    n++;
                }
                grades.edit().putString("grades", new Gson().toJson(grades_topList)).apply();
                boulder_grades_list.setAdapter(new Listview1Adapter(grades_topList));
                ((BaseAdapter) boulder_grades_list.getAdapter()).notifyDataSetChanged();
            }
        });

        keine_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grades_topList.get(0).put("checked", "1");
                n = 1;
                for (int _repeat24 = 0; _repeat24 < 5; _repeat24++) {
                    grades_topList.get((int) n).put("checked", "0");
                    n++;
                }
                grades.edit().putString("grades", new Gson().toJson(grades_topList)).apply();
                boulder_grades_list.setAdapter(new Listview1Adapter(grades_topList));
                ((BaseAdapter) boulder_grades_list.getAdapter()).notifyDataSetChanged();
            }
        });

        boulder_grades_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {

            }
        });

        akzeptieren_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getApplicationContext(), BoulderActivity.class);
                //Todo das wird weiter gegeben und abgefragt
                i.putExtra("filter", new Gson().toJson(grades_topList));
                i.putExtra("tags", "first");
                startActivity(i);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void initializeLogic() {
        //Objekt wird mit Parceable mit Intent eingelesen :D
        Bundle b = getIntent().getExtras(); //has extra!
        assert b != null;
        GradeItem GradeFilter = b.getParcelable("GradeFilter");
        assert GradeFilter != null;
        SketchwareUtil.showMessage(getApplicationContext(), "GetAmpuntAll" + GradeFilter.getAmountAll());

        GradeItem gradeItem = getIntent().getParcelableExtra("GradeFilter");

        grades_topList = gradeItem.getGradeMap();
        boulder_grades_list.setAdapter(new Listview1Adapter(grades_topList));
        ((BaseAdapter) boulder_grades_list.getAdapter()).notifyDataSetChanged();

        total_boulder.setText(Integer.toString(gradeItem.getAmountAll()));
    }

    @Override
    protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
        super.onActivityResult(_requestCode, _resultCode, _data);

        switch (_requestCode) {

            default:
                break;
        }
    }


    public class Listview1Adapter extends BaseAdapter {
        ArrayList<HashMap<String, Object>> _data;

        Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
            _data = _arr;
        }

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public HashMap<String, Object> getItem(int _index) {
            return _data.get(_index);
        }

        @Override
        public long getItemId(int _index) {
            return _data.size();
        }

        @SuppressLint("InflateParams")
        @Override
        public View getView(final int _position, View _view, ViewGroup _viewGroup) {
            LayoutInflater _inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View _v = _view;
            if (_v == null) {
                assert _inflater != null;
                _v = _inflater.inflate(R.layout.cgrade_filter, null);
            }
            final CheckBox grade = _v.findViewById(R.id.grade);
            final TextView anzahl_der_boulder = _v.findViewById(R.id.anzahl_der_boulder);

            grade.setText(grades_topList.get(_position).get("lvl").toString());
            grade.setChecked(grades_topList.get(_position).get("checked").toString().contains("1"));
            anzahl_der_boulder.setText(grades_topList.get(_position).get("Anzahl").toString());

            grade.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SketchwareUtil.showMessage(getApplicationContext(), "angenommen ".concat("Click"));

                    if (grade.isChecked()) {
                        grades_topList.get(_position).put("checked", "1");
                        grades.edit().putString("grades", new Gson().toJson(grades_topList)).apply();
                    } else {
                        grades_topList.get(_position).put("checked", "0");
                        grades.edit().putString("grades", new Gson().toJson(grades_topList)).apply();
                    }
                }

            });
            return _v;
        }
    }
}
