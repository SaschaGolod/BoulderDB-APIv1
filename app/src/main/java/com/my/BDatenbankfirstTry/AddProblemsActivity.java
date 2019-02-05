package com.my.BDatenbankfirstTry;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;

import java.util.*;
import java.text.*;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.HashMap;
import java.util.ArrayList;

import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.HorizontalScrollView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.BaseAdapter;
import android.app.Activity;
import android.content.SharedPreferences;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;

import android.view.View;
import android.widget.AdapterView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.support.v4.content.ContextCompat;
import android.support.v4.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class AddProblemsActivity extends AppCompatActivity {

    private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();

    private Toolbar _toolbar;
    private HashMap<String, Object> New_problem = new HashMap<>();
    private double n = 0;
    private double i = 0;
    private double c = 0;
    private double Wandnummer = 0;
    private double o = 0;
    private double x0 = 0;
    private double x1 = 0;
    private double Boulder_Colour = 0;
    private double WallForHeader = 0;

    private ArrayList<String> Schwierigkeitsgrad = new ArrayList<>();
    private ArrayList<String> Wand = new ArrayList<>();
    private ArrayList<HashMap<String, Object>> BDaten = new ArrayList<>();
    private ArrayList<String> BoulderColour = new ArrayList<>();
    private ArrayList<Double> Zahlen_1bis20 = new ArrayList<>();
    private ArrayList<String> Zahlen_bis20 = new ArrayList<>();
    private ArrayList<HashMap<String, Object>> BDaten_sortier = new ArrayList<>();
    private ArrayList<HashMap<String, Object>> neueListBugMap = new ArrayList<>();
    private ArrayList<HashMap<String, Object>> Lvl1Maps = new ArrayList<>();
    private ArrayList<HashMap<String, Object>> Lvl2Maps = new ArrayList<>();
    private ArrayList<HashMap<String, Object>> Lvl3Maps = new ArrayList<>();
    private ArrayList<HashMap<String, Object>> Lvl4Maps = new ArrayList<>();
    private ArrayList<HashMap<String, Object>> Lvl5Maps = new ArrayList<>();
    private ArrayList<HashMap<String, Object>> Lvl6Maps = new ArrayList<>();
    private ArrayList<HashMap<String, Object>> grades_count = new ArrayList<>();

    private ScrollView vscroll1;
    private LinearLayout linear1;
    private LinearLayout linear3;
    private LinearLayout linear4;
    private LinearLayout linear6;
    private LinearLayout linear10;
    private LinearLayout linear5;
    private LinearLayout linear8;
    private LinearLayout linear9;
    private LinearLayout linear7;
    private TextView textview7;
    private HorizontalScrollView hscroll1;
    private TextView textview2;
    private EditText name;
    private Button save;
    private Button load_db;
    private TextView textview3;
    private Spinner spinner_lvl;
    private Button button1;
    private TextView von_wand;
    private Spinner vo_wand;
    private Spinner vo_wand_nr;
    private TextView textview6;
    private Spinner nach_wand;
    private Spinner nach_wand_nr;
    private TextView textview4;
    private EditText score;
    private TextView setter;
    private EditText sette_edit;
    private TextView boulder_color;
    private Spinner boul_color;
    private Button delete_all;
    private Button sortiere_btn;
    private Button button2;
    private ListView listview3;

    private SharedPreferences BDatenbank_User;
    private DatabaseReference BoulderDB = _firebase.getReference("AppData/user");
    private ChildEventListener _BoulderDB_child_listener;
    private DatabaseReference BoulderDB_Amulett = _firebase.getReference("AppData/Amulett");
    private ChildEventListener _BoulderDB_Amulett_child_listener;
    private DatabaseReference BoulderDB_Beule = _firebase.getReference("AppData/Beule");
    private ChildEventListener _BoulderDB_Beule_child_listener;
    private DatabaseReference BoulderDB_Dach = _firebase.getReference("AppData/Dach");
    private ChildEventListener _BoulderDB_Dach_child_listener;
    private DatabaseReference BoulderDB_Kippwand = _firebase.getReference("AppData/Kippwand");
    private ChildEventListener _BoulderDB_Kippwand_child_listener;
    private DatabaseReference BoulderDB_Komet = _firebase.getReference("AppData/Komet");
    private ChildEventListener _BoulderDB_Komet_child_listener;
    private DatabaseReference BoulderDB_Kurve = _firebase.getReference("AppData/Kurve");
    private ChildEventListener _BoulderDB_Kurve_child_listener;
    private DatabaseReference BoulderDB_Rondell = _firebase.getReference("AppData/Rondell");
    private ChildEventListener _BoulderDB_Rondell_child_listener;
    private DatabaseReference BoulderDB_Strahlenwa = _firebase.getReference("AppData/Strahlenwand");
    private ChildEventListener _BoulderDB_Strahlenwa_child_listener;
    private DatabaseReference BoulderDB_Torbogen = _firebase.getReference("AppData/Torbogen");
    private ChildEventListener _BoulderDB_Torbogen_child_listener;
    private DatabaseReference BoulderDB_Turm = _firebase.getReference("AppData/Turm");
    private ChildEventListener _BoulderDB_Turm_child_listener;
    private DatabaseReference BoulderDB_Uboot = _firebase.getReference("AppData/Uboot");
    private ChildEventListener _BoulderDB_Uboot_child_listener;
    private DatabaseReference BoulderDB_Wabenwand = _firebase.getReference("AppData/Wabenwand");
    private ChildEventListener _BoulderDB_Wabenwand_child_listener;
    private DatabaseReference BoulderDB_Wettkampf = _firebase.getReference("AppData/Wettkampfwand");
    private ChildEventListener _BoulderDB_Wettkampf_child_listener;
    private DatabaseReference BoulderDB_Wuerfel = _firebase.getReference("AppData/Wuerfel");
    private ChildEventListener _BoulderDB_Wuerfel_child_listener;
    private DatabaseReference BoulderDB_Pyramide = _firebase.getReference("AppData/Pyramide");
    private ChildEventListener _BoulderDB_Pyramide_child_listener;
    private DatabaseReference BoulderDB_Drehblock = _firebase.getReference("AppData/Drehblock");
    private ChildEventListener _BoulderDB_Drehblock_child_listener;
    private DatabaseReference JsonFile = _firebase.getReference("Bdaten4");
    private ChildEventListener _JsonFile_child_listener;

    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        setContentView(R.layout.add_problems);
        initialize();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
        } else {
            initializeLogic();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1000) {
            initializeLogic();
        }
    }

    private void initialize() {

        _toolbar = (Toolbar) findViewById(R.id._toolbar);
        setSupportActionBar(_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        _toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
                onBackPressed();
            }
        });
        vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
        linear1 = (LinearLayout) findViewById(R.id.linear1);
        linear3 = (LinearLayout) findViewById(R.id.linear3);
        linear4 = (LinearLayout) findViewById(R.id.linear4);
        linear6 = (LinearLayout) findViewById(R.id.linear6);
        linear10 = (LinearLayout) findViewById(R.id.linear10);
        linear5 = (LinearLayout) findViewById(R.id.linear5);
        linear8 = (LinearLayout) findViewById(R.id.linear8);
        linear9 = (LinearLayout) findViewById(R.id.linear9);
        linear7 = (LinearLayout) findViewById(R.id.linear7);
        textview7 = (TextView) findViewById(R.id.textview7);
        hscroll1 = (HorizontalScrollView) findViewById(R.id.hscroll1);
        textview2 = (TextView) findViewById(R.id.textview2);
        name = (EditText) findViewById(R.id.name);
        save = (Button) findViewById(R.id.save);
        load_db = (Button) findViewById(R.id.load_db);
        textview3 = (TextView) findViewById(R.id.textview3);
        spinner_lvl = (Spinner) findViewById(R.id.spinner_lvl);
        button1 = (Button) findViewById(R.id.button1);
        von_wand = (TextView) findViewById(R.id.von_wand);
        vo_wand = (Spinner) findViewById(R.id.vo_wand);
        vo_wand_nr = (Spinner) findViewById(R.id.vo_wand_nr);
        textview6 = (TextView) findViewById(R.id.textview6);
        nach_wand = (Spinner) findViewById(R.id.nach_wand);
        nach_wand_nr = (Spinner) findViewById(R.id.nach_wand_nr);
        textview4 = (TextView) findViewById(R.id.textview4);
        score = (EditText) findViewById(R.id.score);
        setter = (TextView) findViewById(R.id.setter);
        sette_edit = (EditText) findViewById(R.id.sette_edit);
        boulder_color = (TextView) findViewById(R.id.boulder_color);
        boul_color = (Spinner) findViewById(R.id.boul_color);
        delete_all = (Button) findViewById(R.id.delete_all);
        sortiere_btn = (Button) findViewById(R.id.sortiere_btn);
        button2 = (Button) findViewById(R.id.button2);
        listview3 = (ListView) findViewById(R.id.listview3);
        BDatenbank_User = getSharedPreferences("BDatenbank_User", Activity.MODE_PRIVATE);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                New_problem = new HashMap<>();
                New_problem.put("setter", sette_edit.getText().toString());
                New_problem.put("name", name.getText().toString());
                New_problem.put("lvl", String.valueOf((long) (spinner_lvl.getSelectedItemPosition())));
                New_problem.put("wall", Wand.get((int) (vo_wand.getSelectedItemPosition())));
                New_problem.put("location", Wand.get((int) (vo_wand.getSelectedItemPosition())).concat(Zahlen_bis20.get((int) (vo_wand_nr.getSelectedItemPosition())).concat("-->".concat(Wand.get((int) (nach_wand.getSelectedItemPosition())).concat(Zahlen_bis20.get((int) (nach_wand_nr.getSelectedItemPosition())))))));
                New_problem.put("b_color", BoulderColour.get((int) (boul_color.getSelectedItemPosition())));
                New_problem.put("score", score.getText().toString());
                New_problem.put("TF", "X");
                BDaten.add(New_problem);
                _SaveOnline();
                listview3.setAdapter(new Listview3Adapter(BDaten));
                ((BaseAdapter) listview3.getAdapter()).notifyDataSetChanged();
                FileUtil.writeFile(FileUtil.getExternalStorageDir().concat("/010/".concat("BDaten.json")), new Gson().toJson(BDaten));
            }
        });

        load_db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _GetDataBtnClicked();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        vo_wand.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
                final int _position = _param3;

            }

            @Override
            public void onNothingSelected(AdapterView<?> _param1) {

            }
        });

        delete_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _deleteAllBtnClicked();
                listview3.setAdapter(new Listview3Adapter(BDaten));
                ((BaseAdapter) listview3.getAdapter()).notifyDataSetChanged();
            }
        });

        sortiere_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BDaten_sortier.clear();
                c = 0;
                Wandnummer = 1;
                for (int _repeat26 = 0; _repeat26 < (int) (Wand.size()); _repeat26++) {
                    c = 0;
                    for (int _repeat16 = 0; _repeat16 < (int) (BDaten.size()); _repeat16++) {
                        if (BDaten.get((int) c).get("wall").toString().contains(Wand.get((int) (Wandnummer)))) {
                            New_problem = new HashMap<>();
                            New_problem.put("name", BDaten.get((int) c).get("name").toString());
                            New_problem.put("lvl", BDaten.get((int) c).get("lvl").toString());
                            New_problem.put("wall", BDaten.get((int) c).get("wall").toString());
                            New_problem.put("location", BDaten.get((int) c).get("location").toString());
                            New_problem.put("b_color", BDaten.get((int) c).get("b_color").toString());
                            New_problem.put("score", BDaten.get((int) c).get("score").toString());
                            New_problem.put("TF", BDaten.get((int) c).get("TF").toString());
                            New_problem.put("setter", BDaten.get((int) c).get("setter").toString());
                            BDaten_sortier.add(New_problem);
                        } else {
                            c++;
                        }
                    }
                    Wandnummer++;
                }
                FileUtil.writeFile(FileUtil.getExternalStorageDir().concat("/010/".concat("BDaten.json")), new Gson().toJson(BDaten_sortier));
                ((BaseAdapter) listview3.getAdapter()).notifyDataSetChanged();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _MagicBtnClicked();
            }
        });

        listview3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
                final int _position = _param3;
                SketchwareUtil.showMessage(getApplicationContext(), String.valueOf((long) (_position)).concat("klicked"));
            }
        });

        listview3.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
                final int _position = _param3;
                SketchwareUtil.showMessage(getApplicationContext(), "longklicked");
                return true;
            }
        });

        _BoulderDB_child_listener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildChanged(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildMoved(DataSnapshot _param1, String _param2) {

            }

            @Override
            public void onChildRemoved(DataSnapshot _param1) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onCancelled(DatabaseError _param1) {
                final int _errorCode = _param1.getCode();
                final String _errorMessage = _param1.getMessage();

            }
        };
        BoulderDB.addChildEventListener(_BoulderDB_child_listener);

        _BoulderDB_Amulett_child_listener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildChanged(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildMoved(DataSnapshot _param1, String _param2) {

            }

            @Override
            public void onChildRemoved(DataSnapshot _param1) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onCancelled(DatabaseError _param1) {
                final int _errorCode = _param1.getCode();
                final String _errorMessage = _param1.getMessage();

            }
        };
        BoulderDB_Amulett.addChildEventListener(_BoulderDB_Amulett_child_listener);

        _BoulderDB_Beule_child_listener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildChanged(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildMoved(DataSnapshot _param1, String _param2) {

            }

            @Override
            public void onChildRemoved(DataSnapshot _param1) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onCancelled(DatabaseError _param1) {
                final int _errorCode = _param1.getCode();
                final String _errorMessage = _param1.getMessage();

            }
        };
        BoulderDB_Beule.addChildEventListener(_BoulderDB_Beule_child_listener);

        _BoulderDB_Dach_child_listener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildChanged(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildMoved(DataSnapshot _param1, String _param2) {

            }

            @Override
            public void onChildRemoved(DataSnapshot _param1) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onCancelled(DatabaseError _param1) {
                final int _errorCode = _param1.getCode();
                final String _errorMessage = _param1.getMessage();

            }
        };
        BoulderDB_Dach.addChildEventListener(_BoulderDB_Dach_child_listener);

        _BoulderDB_Kippwand_child_listener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildChanged(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildMoved(DataSnapshot _param1, String _param2) {

            }

            @Override
            public void onChildRemoved(DataSnapshot _param1) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onCancelled(DatabaseError _param1) {
                final int _errorCode = _param1.getCode();
                final String _errorMessage = _param1.getMessage();

            }
        };
        BoulderDB_Kippwand.addChildEventListener(_BoulderDB_Kippwand_child_listener);

        _BoulderDB_Komet_child_listener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildChanged(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildMoved(DataSnapshot _param1, String _param2) {

            }

            @Override
            public void onChildRemoved(DataSnapshot _param1) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onCancelled(DatabaseError _param1) {
                final int _errorCode = _param1.getCode();
                final String _errorMessage = _param1.getMessage();

            }
        };
        BoulderDB_Komet.addChildEventListener(_BoulderDB_Komet_child_listener);

        _BoulderDB_Kurve_child_listener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildChanged(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildMoved(DataSnapshot _param1, String _param2) {

            }

            @Override
            public void onChildRemoved(DataSnapshot _param1) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onCancelled(DatabaseError _param1) {
                final int _errorCode = _param1.getCode();
                final String _errorMessage = _param1.getMessage();

            }
        };
        BoulderDB_Kurve.addChildEventListener(_BoulderDB_Kurve_child_listener);

        _BoulderDB_Rondell_child_listener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildChanged(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildMoved(DataSnapshot _param1, String _param2) {

            }

            @Override
            public void onChildRemoved(DataSnapshot _param1) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onCancelled(DatabaseError _param1) {
                final int _errorCode = _param1.getCode();
                final String _errorMessage = _param1.getMessage();

            }
        };
        BoulderDB_Rondell.addChildEventListener(_BoulderDB_Rondell_child_listener);

        _BoulderDB_Strahlenwa_child_listener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildChanged(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildMoved(DataSnapshot _param1, String _param2) {

            }

            @Override
            public void onChildRemoved(DataSnapshot _param1) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onCancelled(DatabaseError _param1) {
                final int _errorCode = _param1.getCode();
                final String _errorMessage = _param1.getMessage();

            }
        };
        BoulderDB_Strahlenwa.addChildEventListener(_BoulderDB_Strahlenwa_child_listener);

        _BoulderDB_Torbogen_child_listener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildChanged(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildMoved(DataSnapshot _param1, String _param2) {

            }

            @Override
            public void onChildRemoved(DataSnapshot _param1) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onCancelled(DatabaseError _param1) {
                final int _errorCode = _param1.getCode();
                final String _errorMessage = _param1.getMessage();

            }
        };
        BoulderDB_Torbogen.addChildEventListener(_BoulderDB_Torbogen_child_listener);

        _BoulderDB_Turm_child_listener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildChanged(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildMoved(DataSnapshot _param1, String _param2) {

            }

            @Override
            public void onChildRemoved(DataSnapshot _param1) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onCancelled(DatabaseError _param1) {
                final int _errorCode = _param1.getCode();
                final String _errorMessage = _param1.getMessage();

            }
        };
        BoulderDB_Turm.addChildEventListener(_BoulderDB_Turm_child_listener);

        _BoulderDB_Uboot_child_listener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildChanged(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildMoved(DataSnapshot _param1, String _param2) {

            }

            @Override
            public void onChildRemoved(DataSnapshot _param1) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onCancelled(DatabaseError _param1) {
                final int _errorCode = _param1.getCode();
                final String _errorMessage = _param1.getMessage();

            }
        };
        BoulderDB_Uboot.addChildEventListener(_BoulderDB_Uboot_child_listener);

        _BoulderDB_Wabenwand_child_listener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildChanged(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildMoved(DataSnapshot _param1, String _param2) {

            }

            @Override
            public void onChildRemoved(DataSnapshot _param1) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onCancelled(DatabaseError _param1) {
                final int _errorCode = _param1.getCode();
                final String _errorMessage = _param1.getMessage();

            }
        };
        BoulderDB_Wabenwand.addChildEventListener(_BoulderDB_Wabenwand_child_listener);

        _BoulderDB_Wettkampf_child_listener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildChanged(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildMoved(DataSnapshot _param1, String _param2) {

            }

            @Override
            public void onChildRemoved(DataSnapshot _param1) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onCancelled(DatabaseError _param1) {
                final int _errorCode = _param1.getCode();
                final String _errorMessage = _param1.getMessage();

            }
        };
        BoulderDB_Wettkampf.addChildEventListener(_BoulderDB_Wettkampf_child_listener);

        _BoulderDB_Wuerfel_child_listener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildChanged(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildMoved(DataSnapshot _param1, String _param2) {

            }

            @Override
            public void onChildRemoved(DataSnapshot _param1) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onCancelled(DatabaseError _param1) {
                final int _errorCode = _param1.getCode();
                final String _errorMessage = _param1.getMessage();

            }
        };
        BoulderDB_Wuerfel.addChildEventListener(_BoulderDB_Wuerfel_child_listener);

        _BoulderDB_Pyramide_child_listener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildChanged(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildMoved(DataSnapshot _param1, String _param2) {

            }

            @Override
            public void onChildRemoved(DataSnapshot _param1) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onCancelled(DatabaseError _param1) {
                final int _errorCode = _param1.getCode();
                final String _errorMessage = _param1.getMessage();

            }
        };
        BoulderDB_Pyramide.addChildEventListener(_BoulderDB_Pyramide_child_listener);

        _BoulderDB_Drehblock_child_listener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildChanged(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildMoved(DataSnapshot _param1, String _param2) {

            }

            @Override
            public void onChildRemoved(DataSnapshot _param1) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onCancelled(DatabaseError _param1) {
                final int _errorCode = _param1.getCode();
                final String _errorMessage = _param1.getMessage();

            }
        };
        BoulderDB_Drehblock.addChildEventListener(_BoulderDB_Drehblock_child_listener);

        _JsonFile_child_listener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildChanged(DataSnapshot _param1, String _param2) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onChildMoved(DataSnapshot _param1, String _param2) {

            }

            @Override
            public void onChildRemoved(DataSnapshot _param1) {
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };
                final String _childKey = _param1.getKey();
                final HashMap<String, Object> _childValue = _param1.getValue(_ind);

            }

            @Override
            public void onCancelled(DatabaseError _param1) {
                final int _errorCode = _param1.getCode();
                final String _errorMessage = _param1.getMessage();

            }
        };
        JsonFile.addChildEventListener(_JsonFile_child_listener);
    }

    private void initializeLogic() {
        if (FileUtil.readFile(FileUtil.getExternalStorageDir().concat("/010/".concat("BDaten.json"))).startsWith("[")) {
            BDaten = new Gson().fromJson(FileUtil.readFile(FileUtil.getExternalStorageDir().concat("/010/".concat("BDaten.json"))), new TypeToken<ArrayList<HashMap<String, Object>>>() {
            }.getType());
        }
        Schwierigkeitsgrad.add("");
        Schwierigkeitsgrad.add("Weiß");
        Schwierigkeitsgrad.add("Gelb");
        Schwierigkeitsgrad.add("Grün");
        Schwierigkeitsgrad.add("Blau");
        Schwierigkeitsgrad.add("Rot");
        Schwierigkeitsgrad.add("Schwarz");
        Wand.add("");
        Wand.add("Amulett");
        Wand.add("Beule");
        Wand.add("Dach");
        Wand.add("Drehblock");
        Wand.add("Kippwand");
        Wand.add("Komet");
        Wand.add("Kurve");
        Wand.add("Pyramide");
        Wand.add("Rondell");
        Wand.add("Strahlenwand");
        Wand.add("Torbogen");
        Wand.add("Turm");
        Wand.add("U-Boot");
        Wand.add("Wabenwand");
        Wand.add("Wettkampfwand");
        Wand.add("Würfel");
        BoulderColour.add("");
        BoulderColour.add("blau");
        BoulderColour.add("gelb");
        BoulderColour.add("grün");
        BoulderColour.add("lila");
        BoulderColour.add("naturstein");
        BoulderColour.add("nurVolumen");
        BoulderColour.add("orange");
        BoulderColour.add("pink");
        BoulderColour.add("rot");
        BoulderColour.add("schwarz");
        BoulderColour.add("weiß");

        for (int _repeat121 = 0; _repeat121 < (int) (20); _repeat121++) {
            i++;
            Zahlen_bis20.add(String.valueOf((long) (i)));
        }
        spinner_lvl.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, Schwierigkeitsgrad));
        ((ArrayAdapter) spinner_lvl.getAdapter()).notifyDataSetChanged();
        boul_color.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, BoulderColour));
        ((ArrayAdapter) boul_color.getAdapter()).notifyDataSetChanged();
        vo_wand_nr.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, Schwierigkeitsgrad));
        ((ArrayAdapter) spinner_lvl.getAdapter()).notifyDataSetChanged();
        boul_color.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, BoulderColour));
        ((ArrayAdapter) boul_color.getAdapter()).notifyDataSetChanged();
        vo_wand.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, Wand));
        ((ArrayAdapter) vo_wand.getAdapter()).notifyDataSetChanged();
        nach_wand.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, Wand));
        ((ArrayAdapter) nach_wand.getAdapter()).notifyDataSetChanged();
        vo_wand_nr.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, Zahlen_bis20));
        ((ArrayAdapter) vo_wand_nr.getAdapter()).notifyDataSetChanged();
        nach_wand_nr.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, Zahlen_bis20));
        ((ArrayAdapter) nach_wand_nr.getAdapter()).notifyDataSetChanged();
        listview3.setAdapter(new Listview3Adapter(BDaten));
        ((BaseAdapter) listview3.getAdapter()).notifyDataSetChanged();

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

    private void _SaveOnline() {
        SketchwareUtil.showMessage(getApplicationContext(), "SavedOnline");
        if (String.valueOf((long) (vo_wand.getSelectedItemPosition())).equals("1")) {
            BoulderDB_Amulett.push().updateChildren(New_problem);
        } else {
            if (String.valueOf((long) (vo_wand.getSelectedItemPosition())).equals("2")) {
                BoulderDB_Beule.push().updateChildren(New_problem);
            } else {
                if (String.valueOf((long) (vo_wand.getSelectedItemPosition())).equals("3")) {
                    BoulderDB_Dach.push().updateChildren(New_problem);
                } else {
                    if (String.valueOf((long) (vo_wand.getSelectedItemPosition())).equals("4")) {
                        BoulderDB_Drehblock.push().updateChildren(New_problem);
                    } else {
                        if (String.valueOf((long) (vo_wand.getSelectedItemPosition())).equals("5")) {
                            BoulderDB_Kippwand.push().updateChildren(New_problem);
                        } else {
                            if (String.valueOf((long) (vo_wand.getSelectedItemPosition())).equals("6")) {
                                BoulderDB_Komet.push().updateChildren(New_problem);
                            } else {
                                if (String.valueOf((long) (vo_wand.getSelectedItemPosition())).equals("7")) {
                                    BoulderDB_Kurve.push().updateChildren(New_problem);
                                } else {
                                    if (String.valueOf((long) (vo_wand.getSelectedItemPosition())).equals("8")) {
                                        BoulderDB_Pyramide.push().updateChildren(New_problem);
                                    } else {
                                        if (String.valueOf((long) (vo_wand.getSelectedItemPosition())).equals("9")) {
                                            BoulderDB_Rondell.push().updateChildren(New_problem);
                                        } else {
                                            if (String.valueOf((long) (vo_wand.getSelectedItemPosition())).equals("10")) {
                                                BoulderDB_Strahlenwa.push().updateChildren(New_problem);
                                            } else {
                                                if (String.valueOf((long) (vo_wand.getSelectedItemPosition())).equals("11")) {
                                                    BoulderDB_Torbogen.push().updateChildren(New_problem);
                                                } else {
                                                    if (String.valueOf((long) (vo_wand.getSelectedItemPosition())).equals("12")) {
                                                        BoulderDB_Turm.push().updateChildren(New_problem);
                                                    } else {
                                                        if (String.valueOf((long) (vo_wand.getSelectedItemPosition())).equals("13")) {
                                                            BoulderDB_Uboot.push().updateChildren(New_problem);
                                                        } else {
                                                            if (String.valueOf((long) (vo_wand.getSelectedItemPosition())).equals("14")) {
                                                                BoulderDB_Wabenwand.push().updateChildren(New_problem);
                                                            } else {
                                                                if (String.valueOf((long) (vo_wand.getSelectedItemPosition())).equals("15")) {
                                                                    BoulderDB_Wettkampf.push().updateChildren(New_problem);
                                                                } else {
                                                                    if (String.valueOf((long) (vo_wand.getSelectedItemPosition())).equals("16")) {
                                                                        BoulderDB_Wuerfel.push().updateChildren(New_problem);
                                                                    } else {
                                                                        BoulderDB.push().updateChildren(New_problem);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    private void _addListmap() {
        o = 0;
        for (int _repeat11 = 0; _repeat11 < (int) (BDaten_sortier.size()); _repeat11++) {
            New_problem = BDaten_sortier.get((int) o);
            BDaten.add(New_problem);
            o++;
        }
    }


    private void _SetKey() {
        if (neueListBugMap.get((int) x0).get("name").toString().replace("New", " ").replace("\n", " ").contains("       ".concat(Wand.get((int) (WallForHeader))))) {
            New_problem.put("wall", Wand.get((int) (WallForHeader)));
        } else {
            WallForHeader++;
            if (WallForHeader < 17) {
                _SetKey();
            } else {
                if (neueListBugMap.get((int) x0).get("name").toString().contains("rfel")) {
                    New_problem.put("wall", "Würfel");
                } else {
                    New_problem.put("wall", "fail to find");
                }
            }
        }
    }


    private void _SetKeyLvl() {
        if (neueListBugMap.get((int) x0).get("lvl").toString().contains(String.valueOf((long) (x1)))) {
            New_problem.put("lvl", String.valueOf((long) (x1)));
        } else {
            x1++;
            _SetKeyLvl();
        }
    }


    private void _SaveOnline_with() {
        if (New_problem.get("wall").toString().equals("Amulett")) {
            BoulderDB_Amulett.push().updateChildren(New_problem);
        } else {
            if (New_problem.get("wall").toString().equals("Beule")) {
                BoulderDB_Beule.push().updateChildren(New_problem);
            } else {
                if (New_problem.get("wall").toString().equals("Dach")) {
                    BoulderDB_Dach.push().updateChildren(New_problem);
                } else {
                    if (New_problem.get("wall").toString().equals("Drehblock")) {
                        BoulderDB_Drehblock.push().updateChildren(New_problem);
                    } else {
                        if (New_problem.get("wall").toString().equals("Kippwand")) {
                            BoulderDB_Kippwand.push().updateChildren(New_problem);
                        } else {
                            if (New_problem.get("wall").toString().equals("Komet")) {
                                BoulderDB_Komet.push().updateChildren(New_problem);
                            } else {
                                if (New_problem.get("wall").toString().equals("Kurve")) {
                                    BoulderDB_Kurve.push().updateChildren(New_problem);
                                } else {
                                    if (New_problem.get("wall").toString().equals("Pyramide")) {
                                        BoulderDB_Pyramide.push().updateChildren(New_problem);
                                    } else {
                                        if (New_problem.get("wall").toString().equals("Rondell")) {
                                            BoulderDB_Rondell.push().updateChildren(New_problem);
                                        } else {
                                            if (New_problem.get("wall").toString().equals("Strahlenwand")) {
                                                BoulderDB_Strahlenwa.push().updateChildren(New_problem);
                                            } else {
                                                if (New_problem.get("wall").toString().equals("Torbogen")) {
                                                    BoulderDB_Torbogen.push().updateChildren(New_problem);
                                                } else {
                                                    if (New_problem.get("wall").toString().equals("Turm")) {
                                                        BoulderDB_Turm.push().updateChildren(New_problem);
                                                    } else {
                                                        if (New_problem.get("wall").toString().equals("U-Boot")) {
                                                            BoulderDB_Uboot.push().updateChildren(New_problem);
                                                        } else {
                                                            if (New_problem.get("wall").toString().equals("Wabenwand")) {
                                                                BoulderDB_Wabenwand.push().updateChildren(New_problem);
                                                            } else {
                                                                if (New_problem.get("wall").toString().equals("Wettkampfwand")) {
                                                                    BoulderDB_Wettkampf.push().updateChildren(New_problem);
                                                                } else {
                                                                    if (New_problem.get("wall").toString().equals("Würfel")) {
                                                                        BoulderDB_Wuerfel.push().updateChildren(New_problem);
                                                                    } else {
                                                                        BoulderDB.push().updateChildren(New_problem);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    private void _SetKeyColor() {
        if (neueListBugMap.get((int) x0).get("b_color").toString().contains(BoulderColour.get((int) (Boulder_Colour)))) {
            New_problem.put("b_color", BoulderColour.get((int) (Boulder_Colour)));
        } else {
            Boulder_Colour++;
            if (Boulder_Colour < 12) {
                _SetKeyColor();
            } else {
                if (neueListBugMap.get((int) x0).get("b_color").toString().contains("gr")) {
                    New_problem.put("b_color", "gruen");
                } else {
                    if (neueListBugMap.get((int) x0).get("b_color").toString().contains("wei")) {
                        New_problem.put("b_color", "weis");
                    } else {
                        New_problem.put("b_color", neueListBugMap.get((int) x0).get("b_color").toString());
                    }
                }
            }
        }
    }


    private void _deleteAllBtnClicked() {
        FileUtil.writeFile(FileUtil.getExternalStorageDir().concat("/010/".concat("BDaten.json")), "");
        SketchwareUtil.showMessage(getApplicationContext(), "saved");
        if (FileUtil.readFile(FileUtil.getExternalStorageDir().concat("/010/".concat("BDaten.json"))).startsWith("[")) {
            BDaten = new Gson().fromJson(FileUtil.readFile(FileUtil.getExternalStorageDir().concat("/010/".concat("BDaten.json"))), new TypeToken<ArrayList<HashMap<String, Object>>>() {
            }.getType());
        } else {
            BDaten.clear();
        }
    }


    private void _GetDataBtnClicked() {
        BoulderDB_Amulett.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot _dataSnapshot) {
                BDaten_sortier = new ArrayList<>();
                try {
                    GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                    };
                    for (DataSnapshot _data : _dataSnapshot.getChildren()) {
                        HashMap<String, Object> _map = _data.getValue(_ind);
                        BDaten_sortier.add(_map);
                    }
                } catch (Exception _e) {
                    _e.printStackTrace();
                }
                _addListmap();
                BoulderDB_Beule.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot _dataSnapshot) {
                        BDaten_sortier = new ArrayList<>();
                        try {
                            GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                            };
                            for (DataSnapshot _data : _dataSnapshot.getChildren()) {
                                HashMap<String, Object> _map = _data.getValue(_ind);
                                BDaten_sortier.add(_map);
                            }
                        } catch (Exception _e) {
                            _e.printStackTrace();
                        }
                        _addListmap();
                        BoulderDB_Dach.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot _dataSnapshot) {
                                BDaten_sortier = new ArrayList<>();
                                try {
                                    GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                                    };
                                    for (DataSnapshot _data : _dataSnapshot.getChildren()) {
                                        HashMap<String, Object> _map = _data.getValue(_ind);
                                        BDaten_sortier.add(_map);
                                    }
                                } catch (Exception _e) {
                                    _e.printStackTrace();
                                }
                                _addListmap();
                                BoulderDB_Kippwand.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot _dataSnapshot) {
                                        BDaten_sortier = new ArrayList<>();
                                        try {
                                            GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                                            };
                                            for (DataSnapshot _data : _dataSnapshot.getChildren()) {
                                                HashMap<String, Object> _map = _data.getValue(_ind);
                                                BDaten_sortier.add(_map);
                                            }
                                        } catch (Exception _e) {
                                            _e.printStackTrace();
                                        }
                                        _addListmap();
                                        BoulderDB_Komet.addListenerForSingleValueEvent(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(DataSnapshot _dataSnapshot) {
                                                BDaten_sortier = new ArrayList<>();
                                                try {
                                                    GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                                                    };
                                                    for (DataSnapshot _data : _dataSnapshot.getChildren()) {
                                                        HashMap<String, Object> _map = _data.getValue(_ind);
                                                        BDaten_sortier.add(_map);
                                                    }
                                                } catch (Exception _e) {
                                                    _e.printStackTrace();
                                                }
                                                _addListmap();
                                                BoulderDB_Kurve.addListenerForSingleValueEvent(new ValueEventListener() {
                                                    @Override
                                                    public void onDataChange(DataSnapshot _dataSnapshot) {
                                                        BDaten_sortier = new ArrayList<>();
                                                        try {
                                                            GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                                                            };
                                                            for (DataSnapshot _data : _dataSnapshot.getChildren()) {
                                                                HashMap<String, Object> _map = _data.getValue(_ind);
                                                                BDaten_sortier.add(_map);
                                                            }
                                                        } catch (Exception _e) {
                                                            _e.printStackTrace();
                                                        }
                                                        _addListmap();
                                                        BoulderDB_Rondell.addListenerForSingleValueEvent(new ValueEventListener() {
                                                            @Override
                                                            public void onDataChange(DataSnapshot _dataSnapshot) {
                                                                BDaten_sortier = new ArrayList<>();
                                                                try {
                                                                    GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                                                                    };
                                                                    for (DataSnapshot _data : _dataSnapshot.getChildren()) {
                                                                        HashMap<String, Object> _map = _data.getValue(_ind);
                                                                        BDaten_sortier.add(_map);
                                                                    }
                                                                } catch (Exception _e) {
                                                                    _e.printStackTrace();
                                                                }
                                                                _addListmap();
                                                                BoulderDB_Strahlenwa.addListenerForSingleValueEvent(new ValueEventListener() {
                                                                    @Override
                                                                    public void onDataChange(DataSnapshot _dataSnapshot) {
                                                                        BDaten_sortier = new ArrayList<>();
                                                                        try {
                                                                            GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                                                                            };
                                                                            for (DataSnapshot _data : _dataSnapshot.getChildren()) {
                                                                                HashMap<String, Object> _map = _data.getValue(_ind);
                                                                                BDaten_sortier.add(_map);
                                                                            }
                                                                        } catch (Exception _e) {
                                                                            _e.printStackTrace();
                                                                        }
                                                                        _addListmap();
                                                                        BoulderDB_Torbogen.addListenerForSingleValueEvent(new ValueEventListener() {
                                                                            @Override
                                                                            public void onDataChange(DataSnapshot _dataSnapshot) {
                                                                                BDaten_sortier = new ArrayList<>();
                                                                                try {
                                                                                    GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                                                                                    };
                                                                                    for (DataSnapshot _data : _dataSnapshot.getChildren()) {
                                                                                        HashMap<String, Object> _map = _data.getValue(_ind);
                                                                                        BDaten_sortier.add(_map);
                                                                                    }
                                                                                } catch (Exception _e) {
                                                                                    _e.printStackTrace();
                                                                                }
                                                                                _addListmap();
                                                                                BoulderDB_Turm.addListenerForSingleValueEvent(new ValueEventListener() {
                                                                                    @Override
                                                                                    public void onDataChange(DataSnapshot _dataSnapshot) {
                                                                                        BDaten_sortier = new ArrayList<>();
                                                                                        try {
                                                                                            GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                                                                                            };
                                                                                            for (DataSnapshot _data : _dataSnapshot.getChildren()) {
                                                                                                HashMap<String, Object> _map = _data.getValue(_ind);
                                                                                                BDaten_sortier.add(_map);
                                                                                            }
                                                                                        } catch (Exception _e) {
                                                                                            _e.printStackTrace();
                                                                                        }
                                                                                        _addListmap();
                                                                                        BoulderDB_Uboot.addListenerForSingleValueEvent(new ValueEventListener() {
                                                                                            @Override
                                                                                            public void onDataChange(DataSnapshot _dataSnapshot) {
                                                                                                BDaten_sortier = new ArrayList<>();
                                                                                                try {
                                                                                                    GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                                                                                                    };
                                                                                                    for (DataSnapshot _data : _dataSnapshot.getChildren()) {
                                                                                                        HashMap<String, Object> _map = _data.getValue(_ind);
                                                                                                        BDaten_sortier.add(_map);
                                                                                                    }
                                                                                                } catch (Exception _e) {
                                                                                                    _e.printStackTrace();
                                                                                                }
                                                                                                _addListmap();
                                                                                                BoulderDB_Wabenwand.addListenerForSingleValueEvent(new ValueEventListener() {
                                                                                                    @Override
                                                                                                    public void onDataChange(DataSnapshot _dataSnapshot) {
                                                                                                        BDaten_sortier = new ArrayList<>();
                                                                                                        try {
                                                                                                            GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                                                                                                            };
                                                                                                            for (DataSnapshot _data : _dataSnapshot.getChildren()) {
                                                                                                                HashMap<String, Object> _map = _data.getValue(_ind);
                                                                                                                BDaten_sortier.add(_map);
                                                                                                            }
                                                                                                        } catch (Exception _e) {
                                                                                                            _e.printStackTrace();
                                                                                                        }
                                                                                                        _addListmap();
                                                                                                        BoulderDB_Wettkampf.addListenerForSingleValueEvent(new ValueEventListener() {
                                                                                                            @Override
                                                                                                            public void onDataChange(DataSnapshot _dataSnapshot) {
                                                                                                                BDaten_sortier = new ArrayList<>();
                                                                                                                try {
                                                                                                                    GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                                                                                                                    };
                                                                                                                    for (DataSnapshot _data : _dataSnapshot.getChildren()) {
                                                                                                                        HashMap<String, Object> _map = _data.getValue(_ind);
                                                                                                                        BDaten_sortier.add(_map);
                                                                                                                    }
                                                                                                                } catch (Exception _e) {
                                                                                                                    _e.printStackTrace();
                                                                                                                }
                                                                                                                _addListmap();
                                                                                                                BoulderDB_Wuerfel.addListenerForSingleValueEvent(new ValueEventListener() {
                                                                                                                    @Override
                                                                                                                    public void onDataChange(DataSnapshot _dataSnapshot) {
                                                                                                                        BDaten_sortier = new ArrayList<>();
                                                                                                                        try {
                                                                                                                            GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                                                                                                                            };
                                                                                                                            for (DataSnapshot _data : _dataSnapshot.getChildren()) {
                                                                                                                                HashMap<String, Object> _map = _data.getValue(_ind);
                                                                                                                                BDaten_sortier.add(_map);
                                                                                                                            }
                                                                                                                        } catch (Exception _e) {
                                                                                                                            _e.printStackTrace();
                                                                                                                        }
                                                                                                                        _addListmap();
                                                                                                                        BoulderDB_Pyramide.addListenerForSingleValueEvent(new ValueEventListener() {
                                                                                                                            @Override
                                                                                                                            public void onDataChange(DataSnapshot _dataSnapshot) {
                                                                                                                                BDaten_sortier = new ArrayList<>();
                                                                                                                                try {
                                                                                                                                    GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                                                                                                                                    };
                                                                                                                                    for (DataSnapshot _data : _dataSnapshot.getChildren()) {
                                                                                                                                        HashMap<String, Object> _map = _data.getValue(_ind);
                                                                                                                                        BDaten_sortier.add(_map);
                                                                                                                                    }
                                                                                                                                } catch (Exception _e) {
                                                                                                                                    _e.printStackTrace();
                                                                                                                                }
                                                                                                                                _addListmap();
                                                                                                                                BoulderDB_Drehblock.addListenerForSingleValueEvent(new ValueEventListener() {
                                                                                                                                    @Override
                                                                                                                                    public void onDataChange(DataSnapshot _dataSnapshot) {
                                                                                                                                        BDaten_sortier = new ArrayList<>();
                                                                                                                                        try {
                                                                                                                                            GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                                                                                                                                            };
                                                                                                                                            for (DataSnapshot _data : _dataSnapshot.getChildren()) {
                                                                                                                                                HashMap<String, Object> _map = _data.getValue(_ind);
                                                                                                                                                BDaten_sortier.add(_map);
                                                                                                                                            }
                                                                                                                                        } catch (Exception _e) {
                                                                                                                                            _e.printStackTrace();
                                                                                                                                        }
                                                                                                                                        _addListmap();
                                                                                                                                        FileUtil.writeFile(FileUtil.getExternalStorageDir().concat("/010/".concat("BDaten.json")), new Gson().toJson(BDaten));
                                                                                                                                        listview3.setAdapter(new Listview3Adapter(BDaten));
                                                                                                                                        ((BaseAdapter) listview3.getAdapter()).notifyDataSetChanged();
                                                                                                                                    }

                                                                                                                                    @Override
                                                                                                                                    public void onCancelled(DatabaseError _databaseError) {
                                                                                                                                    }
                                                                                                                                });
                                                                                                                            }

                                                                                                                            @Override
                                                                                                                            public void onCancelled(DatabaseError _databaseError) {
                                                                                                                            }
                                                                                                                        });
                                                                                                                    }

                                                                                                                    @Override
                                                                                                                    public void onCancelled(DatabaseError _databaseError) {
                                                                                                                    }
                                                                                                                });
                                                                                                            }

                                                                                                            @Override
                                                                                                            public void onCancelled(DatabaseError _databaseError) {
                                                                                                            }
                                                                                                        });
                                                                                                    }

                                                                                                    @Override
                                                                                                    public void onCancelled(DatabaseError _databaseError) {
                                                                                                    }
                                                                                                });
                                                                                            }

                                                                                            @Override
                                                                                            public void onCancelled(DatabaseError _databaseError) {
                                                                                            }
                                                                                        });
                                                                                    }

                                                                                    @Override
                                                                                    public void onCancelled(DatabaseError _databaseError) {
                                                                                    }
                                                                                });
                                                                            }

                                                                            @Override
                                                                            public void onCancelled(DatabaseError _databaseError) {
                                                                            }
                                                                        });
                                                                    }

                                                                    @Override
                                                                    public void onCancelled(DatabaseError _databaseError) {
                                                                    }
                                                                });
                                                            }

                                                            @Override
                                                            public void onCancelled(DatabaseError _databaseError) {
                                                            }
                                                        });
                                                    }

                                                    @Override
                                                    public void onCancelled(DatabaseError _databaseError) {
                                                    }
                                                });
                                            }

                                            @Override
                                            public void onCancelled(DatabaseError _databaseError) {
                                            }
                                        });
                                    }

                                    @Override
                                    public void onCancelled(DatabaseError _databaseError) {
                                    }
                                });
                            }

                            @Override
                            public void onCancelled(DatabaseError _databaseError) {
                            }
                        });
                    }

                    @Override
                    public void onCancelled(DatabaseError _databaseError) {
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError _databaseError) {
            }
        });
        JsonFile.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot _dataSnapshot) {
                BDaten_sortier = new ArrayList<>();
                try {
                    GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                    };
                    for (DataSnapshot _data : _dataSnapshot.getChildren()) {
                        HashMap<String, Object> _map = _data.getValue(_ind);
                        BDaten_sortier.add(_map);
                    }
                } catch (Exception _e) {
                    _e.printStackTrace();
                }
                FileUtil.writeFile(FileUtil.getExternalStorageDir().concat("/010/".concat("grade_anzahl.json")), new Gson().toJson(BDaten_sortier));
                SketchwareUtil.showMessage(getApplicationContext(), "DataReloaded");
            }

            @Override
            public void onCancelled(DatabaseError _databaseError) {
            }
        });
    }


    private void _SetKey_name_location() {
        if (neueListBugMap.get((int) x0).get("name").toString().contains("^")) {
            New_problem.put("name", "^");
            New_problem.put("location", neueListBugMap.get((int) x0).get("name").toString().replace("^", " ").replace("W�rfel", "Würfel").replace("\n", "").replace("-&gt; ", "-->\n").concat("\n").replace("       ", "").trim());
        } else {
            New_problem.put("name", neueListBugMap.get((int) x0).get("name").toString().replace("W�rfel", "Würfel").replace("\n", "").replace("-&gt;", "/n-->").concat("\n"));
            New_problem.put("location", neueListBugMap.get((int) x0).get("name").toString().replace("^", " ").replace("W�rfel", "Würfel").replace("\n", "").replace("-&gt; ", "-->\n").concat("\n").replace("       ", "").trim());
        }
    }


    private void _MagicBtnClicked() {
        neueListBugMap = new Gson().fromJson(FileUtil.readFile(FileUtil.getExternalStorageDir().concat("/010/BDaten4.json")), new TypeToken<ArrayList<HashMap<String, Object>>>() {
        }.getType());
        BDaten.clear();
        x0 = 0;
        for (int _repeat16 = 0; _repeat16 < (int) (neueListBugMap.size()); _repeat16++) {
            New_problem = new HashMap<>();
            _SetKey_name_location();
            New_problem.put("lvl", neueListBugMap.get((int) x0).get("lvl").toString().replace("\n", "").replace(" ", ""));
            New_problem.put("tag", neueListBugMap.get((int) x0).get("Tags").toString().replace("\n", "").replace(" ", ""));
            WallForHeader = 1;
            _SetKey();
            Boulder_Colour = 1;
            _SetKeyColor();
            New_problem.put("score", neueListBugMap.get((int) x0).get("score").toString().replace("\n", "").replace(" ", ""));
            New_problem.put("TF", "X");
            New_problem.put("setter", neueListBugMap.get((int) x0).get("setter").toString().replace("\n", "").replace(" ", ""));
            New_problem.put("data", neueListBugMap.get((int) x0).get("Data").toString().replace("\n", "").replace(" ", ""));
            _SaveMapToLvlMaps();
            x0++;
        }
        _SaveOnlineWithLook();
        _deleteAllBtnClicked();
        _GetDataBtnClicked();
        listview3.setAdapter(new Listview3Adapter(BDaten));
        ((BaseAdapter) listview3.getAdapter()).notifyDataSetChanged();
    }


    private void _SaveMapToLvlMaps() {
        if (New_problem.get("lvl").toString().equals("1")) {
            Lvl1Maps.add(New_problem);
        } else {
            if (New_problem.get("lvl").toString().equals("2")) {
                Lvl2Maps.add(New_problem);
            } else {
                if (New_problem.get("lvl").toString().equals("3")) {
                    Lvl3Maps.add(New_problem);
                } else {
                    if (New_problem.get("lvl").toString().equals("4")) {
                        Lvl4Maps.add(New_problem);
                    } else {
                        if (New_problem.get("lvl").toString().equals("5")) {
                            Lvl5Maps.add(New_problem);
                        } else {
                            if (New_problem.get("lvl").toString().equals("6")) {
                                Lvl6Maps.add(New_problem);
                            } else {
                                SketchwareUtil.showMessage(getApplicationContext(), "error in lvl Sort!");
                            }
                        }
                    }
                }
            }
        }
    }


    private void _SaveOnlineWithLook() {
        x0 = 0;
        for (int _repeat11 = 0; _repeat11 < (int) (Lvl1Maps.size()); _repeat11++) {
            New_problem = new HashMap<>();
            New_problem.put("name", Lvl1Maps.get((int) x0).get("name").toString());
            New_problem.put("wall", Lvl1Maps.get((int) x0).get("wall").toString());
            New_problem.put("lvl", Lvl1Maps.get((int) x0).get("lvl").toString());
            New_problem.put("tag", Lvl1Maps.get((int) x0).get("tag").toString());
            New_problem.put("location", Lvl1Maps.get((int) x0).get("location").toString());
            New_problem.put("b_color", Lvl1Maps.get((int) x0).get("b_color").toString());
            New_problem.put("score", Lvl1Maps.get((int) x0).get("score").toString());
            New_problem.put("TF", "X");
            New_problem.put("setter", Lvl1Maps.get((int) x0).get("setter").toString());
            New_problem.put("data", Lvl1Maps.get((int) x0).get("data").toString());
            _SaveOnline_with();
            x0++;
        }
        x0 = 0;
        for (int _repeat45 = 0; _repeat45 < (int) (Lvl2Maps.size()); _repeat45++) {
            New_problem = new HashMap<>();
            New_problem.put("name", Lvl2Maps.get((int) x0).get("name").toString());
            New_problem.put("wall", Lvl2Maps.get((int) x0).get("wall").toString());
            New_problem.put("lvl", Lvl2Maps.get((int) x0).get("lvl").toString());
            New_problem.put("tag", Lvl2Maps.get((int) x0).get("tag").toString());
            New_problem.put("location", Lvl2Maps.get((int) x0).get("location").toString());
            New_problem.put("b_color", Lvl2Maps.get((int) x0).get("b_color").toString());
            New_problem.put("score", Lvl2Maps.get((int) x0).get("score").toString());
            New_problem.put("TF", "X");
            New_problem.put("setter", Lvl2Maps.get((int) x0).get("setter").toString());
            New_problem.put("data", Lvl2Maps.get((int) x0).get("data").toString());
            _SaveOnline_with();
            x0++;
        }
        x0 = 0;
        for (int _repeat79 = 0; _repeat79 < (int) (Lvl3Maps.size()); _repeat79++) {
            New_problem = new HashMap<>();
            New_problem.put("name", Lvl3Maps.get((int) x0).get("name").toString());
            New_problem.put("wall", Lvl3Maps.get((int) x0).get("wall").toString());
            New_problem.put("lvl", Lvl3Maps.get((int) x0).get("lvl").toString());
            New_problem.put("tag", Lvl3Maps.get((int) x0).get("tag").toString());
            New_problem.put("location", Lvl3Maps.get((int) x0).get("location").toString());
            New_problem.put("b_color", Lvl3Maps.get((int) x0).get("b_color").toString());
            New_problem.put("score", Lvl3Maps.get((int) x0).get("score").toString());
            New_problem.put("TF", "X");
            New_problem.put("setter", Lvl3Maps.get((int) x0).get("setter").toString());
            New_problem.put("data", Lvl3Maps.get((int) x0).get("data").toString());
            _SaveOnline_with();
            x0++;
        }
        x0 = 0;
        for (int _repeat113 = 0; _repeat113 < (int) (Lvl4Maps.size()); _repeat113++) {
            New_problem = new HashMap<>();
            New_problem.put("name", Lvl4Maps.get((int) x0).get("name").toString());
            New_problem.put("wall", Lvl4Maps.get((int) x0).get("wall").toString());
            New_problem.put("lvl", Lvl4Maps.get((int) x0).get("lvl").toString());
            New_problem.put("tag", Lvl4Maps.get((int) x0).get("tag").toString());
            New_problem.put("location", Lvl4Maps.get((int) x0).get("location").toString());
            New_problem.put("b_color", Lvl4Maps.get((int) x0).get("b_color").toString());
            New_problem.put("score", Lvl4Maps.get((int) x0).get("score").toString());
            New_problem.put("TF", "X");
            New_problem.put("setter", Lvl4Maps.get((int) x0).get("setter").toString());
            New_problem.put("data", Lvl4Maps.get((int) x0).get("data").toString());
            _SaveOnline_with();
            x0++;
        }
        x0 = 0;
        for (int _repeat147 = 0; _repeat147 < (int) (Lvl5Maps.size()); _repeat147++) {
            New_problem = new HashMap<>();
            New_problem.put("name", Lvl5Maps.get((int) x0).get("name").toString());
            New_problem.put("wall", Lvl5Maps.get((int) x0).get("wall").toString());
            New_problem.put("lvl", Lvl5Maps.get((int) x0).get("lvl").toString());
            New_problem.put("tag", Lvl5Maps.get((int) x0).get("tag").toString());
            New_problem.put("location", Lvl5Maps.get((int) x0).get("location").toString());
            New_problem.put("b_color", Lvl5Maps.get((int) x0).get("b_color").toString());
            New_problem.put("score", Lvl5Maps.get((int) x0).get("score").toString());
            New_problem.put("TF", "X");
            New_problem.put("setter", Lvl5Maps.get((int) x0).get("setter").toString());
            New_problem.put("data", Lvl5Maps.get((int) x0).get("data").toString());
            _SaveOnline_with();
            x0++;
        }
        x0 = 0;
        for (int _repeat181 = 0; _repeat181 < (int) (Lvl6Maps.size()); _repeat181++) {
            New_problem = new HashMap<>();
            New_problem.put("name", Lvl6Maps.get((int) x0).get("name").toString());
            New_problem.put("wall", Lvl6Maps.get((int) x0).get("wall").toString());
            New_problem.put("lvl", Lvl6Maps.get((int) x0).get("lvl").toString());
            New_problem.put("tag", Lvl6Maps.get((int) x0).get("tag").toString());
            New_problem.put("location", Lvl6Maps.get((int) x0).get("location").toString());
            New_problem.put("b_color", Lvl6Maps.get((int) x0).get("b_color").toString());
            New_problem.put("score", Lvl6Maps.get((int) x0).get("score").toString());
            New_problem.put("TF", "X");
            New_problem.put("setter", Lvl6Maps.get((int) x0).get("setter").toString());
            New_problem.put("data", Lvl6Maps.get((int) x0).get("data").toString());
            _SaveOnline_with();
            x0++;
        }
        New_problem = new HashMap<>();
        New_problem.put("anzahl", String.valueOf((long) (Lvl1Maps.size())));
        JsonFile.push().updateChildren(New_problem);
        New_problem.put("anzahl", String.valueOf((long) (Lvl2Maps.size())));
        JsonFile.push().updateChildren(New_problem);
        New_problem.put("anzahl", String.valueOf((long) (Lvl3Maps.size())));
        JsonFile.push().updateChildren(New_problem);
        New_problem.put("anzahl", String.valueOf((long) (Lvl4Maps.size())));
        JsonFile.push().updateChildren(New_problem);
        New_problem.put("anzahl", String.valueOf((long) (Lvl5Maps.size())));
        JsonFile.push().updateChildren(New_problem);
        New_problem.put("anzahl", String.valueOf((long) (Lvl6Maps.size())));
        JsonFile.push().updateChildren(New_problem);
        New_problem.clear();
        New_problem.put("total", String.valueOf((long) (Lvl6Maps.size() + (Lvl5Maps.size() + (Lvl4Maps.size() + (Lvl3Maps.size() + (Lvl2Maps.size() + Lvl1Maps.size())))))));
        JsonFile.push().updateChildren(New_problem);
    }


    public class Listview3Adapter extends BaseAdapter {
        ArrayList<HashMap<String, Object>> _data;

        public Listview3Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
            LayoutInflater _inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View _v = _view;
            if (_v == null) {
                _v = _inflater.inflate(R.layout.add_cview, null);
            }

            final LinearLayout back = (LinearLayout) _v.findViewById(R.id.back);
            final LinearLayout linear3 = (LinearLayout) _v.findViewById(R.id.linear3);
            final LinearLayout linear4 = (LinearLayout) _v.findViewById(R.id.linear4);
            final LinearLayout linear5 = (LinearLayout) _v.findViewById(R.id.linear5);
            final Button btn_change = (Button) _v.findViewById(R.id.btn_change);
            final TextView x = (TextView) _v.findViewById(R.id.x);
            final Button btn_delete = (Button) _v.findViewById(R.id.btn_delete);
            final TextView name = (TextView) _v.findViewById(R.id.name);
            final TextView stufe = (TextView) _v.findViewById(R.id.stufe);
            final TextView wand = (TextView) _v.findViewById(R.id.wand);
            final TextView score = (TextView) _v.findViewById(R.id.score);
            final TextView setter = (TextView) _v.findViewById(R.id.setter);
            final TextView extra = (TextView) _v.findViewById(R.id.extra);

            if (_position == 0) {
                n = BDaten.size();
                n--;
            }
            name.setText(BDaten.get((int) n - _position).get("name").toString());
            stufe.setText(BDaten.get((int) n - _position).get("lvl").toString());
            wand.setText(BDaten.get((int) n - _position).get("wall").toString());
            score.setText(BDaten.get((int) n - _position).get("score").toString());
            setter.setText(BDaten.get((int) n - _position).get("setter").toString());
            extra.setText(BDaten.get((int) n - _position).get("b_color").toString());
            btn_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View _view) {
                    back.setVisibility(View.GONE);
                    BDaten.remove((int) (n - _position));
                    FileUtil.writeFile(FileUtil.getExternalStorageDir().concat("/010/".concat("BDaten.json")), new Gson().toJson(BDaten));
                }
            });
            btn_change.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View _view) {
                    SketchwareUtil.showMessage(getApplicationContext(), "Btn_changes klicked");
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
        ArrayList<Double> _result = new ArrayList<Double>();
        SparseBooleanArray _arr = _list.getCheckedItemPositions();
        for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
            if (_arr.valueAt(_iIdx))
                _result.add((double) _arr.keyAt(_iIdx));
        }
        return _result;
    }

    @Deprecated
    public float getDip(int _input) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
    }

    @Deprecated
    public int getDisplayWidthPixels() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    @Deprecated
    public int getDisplayHeightPixels() {
        return getResources().getDisplayMetrics().heightPixels;
    }

}
