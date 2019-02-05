package com.my.BDatenbankfirstTry;

import android.os.*;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.util.*;

import java.util.*;

import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;
import java.util.ArrayList;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.content.Intent;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.my.BDatenbankfirstTry.BoulRankStat.BoulderScreen.BoulderScreen.FragmentBoulder;
import com.my.BDatenbankfirstTry.BoulRankStat.BoulderScreen.ViewPagerAdapter;
import com.my.BDatenbankfirstTry.BoulRankStat.BoulderScreen.RankingScreen.FragmentRanking;
import com.my.BDatenbankfirstTry.BoulRankStat.BoulderScreen.StatistikScreen.FragmentStatistik;

import android.support.v4.content.ContextCompat;
import android.support.v4.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class testtesttest extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    private String Wand_vorheriges_ele = "";
    private boolean filterTodo = false;
    private boolean filterDone = false;
    private boolean filterProjekt = false;
    private boolean Element_Visible = false;
    private boolean Element_withHeader = false;
    private double itemTagsList = 0;
    private String LvlEmogie = "";

    private ArrayList<HashMap<String, Object>> BDatenbank_map = new ArrayList<>();
    private ArrayList<HashMap<String, Object>> filter_map_setting = new ArrayList<>();
    private ArrayList<HashMap<String, Object>> FirstStart = new ArrayList<>();
    private ArrayList<HashMap<String, Object>> tagsListMap = new ArrayList<>();
    private ArrayList<String> tagsAktiV = new ArrayList<>();
    private ArrayList<String> menu = new ArrayList<>();
    private ArrayList<HashMap<String, Object>> list_ranking = new ArrayList<>();


    private Intent i = new Intent();
    private SharedPreferences grade_filter_setting;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.login:
                SketchwareUtil.showMessage(getApplicationContext(), "Login Activity starten");
                i.setClass(getApplicationContext(), LoginActivity.class);
                startActivity(i);
                return true;
            case R.id.location:
                SketchwareUtil.showMessage(getApplicationContext(), "Account Location ausgewählt");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        setContentView(R.layout.boulder_main);

        tabLayout = findViewById(R.id.tabs);
        appBarLayout = findViewById(R.id.appbar);
        viewPager = findViewById(R.id.viewpager);
        //Adding Fragments
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new FragmentBoulder(), "Boulder");
        adapter.AddFragment(new FragmentRanking(), "Ranking");
        adapter.AddFragment(new FragmentStatistik(), "Statistik");
        //adaper Setum
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        initialize();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
        } else {
            //initializeLogic();
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

        Toolbar toolbar = findViewById(R.id._toolbar1);
        setSupportActionBar(toolbar);

        grade_filter_setting = getSharedPreferences("grade_filter_setting", Activity.MODE_PRIVATE);
    }


    private void initializeLogic() {
        grade_filter_setting.edit().putString("input", "close").apply();
        filterTodo = false;
        grade_filter_setting.edit().putString("filterTodo", "notChecked").apply();
        filterDone = false;
        grade_filter_setting.edit().putString("filterDone", "notChecked").apply();
        filterProjekt = false;
        grade_filter_setting.edit().putString("filterProjekt", "notChecked").apply();
        if (FileUtil.readFile(FileUtil.getExternalStorageDir().concat("/010/".concat("BDaten.json"))).startsWith("[")) {
            BDatenbank_map = new Gson().fromJson(FileUtil.readFile(FileUtil.getExternalStorageDir().concat("/010/".concat("BDaten.json"))), new TypeToken<ArrayList<HashMap<String, Object>>>() {
            }.getType());
        }
        _IntentExtraKeyGrades();
        _IntentExtraKeyTags();
        filter_map_setting = new Gson().fromJson(grade_filter_setting.getString("filter", ""), new TypeToken<ArrayList<HashMap<String, Object>>>() {
        }.getType());
        itemTagsList = 1;
        for (int _repeat204 = 0; _repeat204 < (int) ((tagsListMap.size() - 1)); _repeat204++) {
            if (tagsListMap.get((int) itemTagsList).get("checked").toString().contains("1")) {
                tagsAktiV.add(tagsListMap.get((int) itemTagsList).get("image").toString());
            }
            itemTagsList++;
        }
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

    private void _Background(final TextView _Element, final double _position) {
        if (BDatenbank_map.get((int) _position).get("TF").toString().contains("F")) {
            _Element.setBackgroundColor(0xFF3F51B5);
        } else {
            if (BDatenbank_map.get((int) _position).get("TF").toString().contains("T")) {
                _Element.setBackgroundColor(0xFF8BC34A);
            } else {
                if (BDatenbank_map.get((int) _position).get("TF").toString().contains("P")) {
                    _Element.setBackgroundColor(0xFF607D8B);
                } else {
                    _Element.setBackgroundColor(0xFFFFFFFF);
                }
            }
        }
    }


    private void _DoBtnFlash(final View _FlashItem, final double _position) {
        BDatenbank_map.get((int) _position).put("TF", "F");
        _FlashItem.setBackgroundColor(0xFF3F51B5);
        FileUtil.writeFile(FileUtil.getExternalStorageDir().concat("/010/".concat("BDaten.json")), new Gson().toJson(BDatenbank_map));
    }


    private void _DoBtnTop(final View _Top, final double _position) {
        BDatenbank_map.get((int) _position).put("TF", "T");
        _Top.setBackgroundColor(0xFF4CAF50);
        FileUtil.writeFile(FileUtil.getExternalStorageDir().concat("/010/".concat("BDaten.json")), new Gson().toJson(BDatenbank_map));
    }


    private void _SetImage(final ImageView _image, final double _position) {
        if (BDatenbank_map.get((int) _position).get("b_color").toString().contains("blau")) {
            _image.setImageResource(R.drawable.blau);
        } else {
            if (BDatenbank_map.get((int) _position).get("b_color").toString().contains("gelb")) {
                _image.setImageResource(R.drawable.gelb);
            } else {
                if (BDatenbank_map.get((int) _position).get("b_color").toString().contains("gr")) {
                    _image.setImageResource(R.drawable.gruen);
                } else {
                    if (BDatenbank_map.get((int) _position).get("b_color").toString().contains("lila")) {
                        _image.setImageResource(R.drawable.lila);
                    } else {
                        if (BDatenbank_map.get((int) _position).get("b_color").toString().contains("naturstein")) {
                            _image.setImageResource(R.drawable.naturstein);
                        } else {
                            if (BDatenbank_map.get((int) _position).get("b_color").toString().contains("Volumen")) {
                                _image.setImageResource(R.drawable.nur_volumen);
                            } else {
                                if (BDatenbank_map.get((int) _position).get("b_color").toString().contains("orange")) {
                                    _image.setImageResource(R.drawable.orange);
                                } else {
                                    if (BDatenbank_map.get((int) _position).get("b_color").toString().contains("pink")) {
                                        _image.setImageResource(R.drawable.pink);
                                    } else {
                                        if (BDatenbank_map.get((int) _position).get("b_color").toString().contains("rot")) {
                                            _image.setImageResource(R.drawable.rot);
                                        } else {
                                            if (BDatenbank_map.get((int) _position).get("b_color").toString().contains("schwarz")) {
                                                _image.setImageResource(R.drawable.schwarz);
                                            } else {
                                                if (BDatenbank_map.get((int) _position).get("b_color").toString().contains("wei")) {
                                                    _image.setImageResource(R.drawable.weis);
                                                } else {

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


    private void _SetElementName(final TextView _element_name, final double _position) {
        String NewEmogie = "";

        _SetLvlEmogie(_position);
        if (BDatenbank_map.get((int) _position).get("location").toString().contains("New")) {
            BDatenbank_map.get((int) _position).put("location", BDatenbank_map.get((int) _position).get("location").toString().replace("New", ""));
            NewEmogie = "🆕";
        } else {
            NewEmogie = "";
        }
        _element_name.setText(BDatenbank_map.get((int) _position).get("name").toString().concat(BDatenbank_map.get((int) _position).get("tag").toString()).concat("\n").concat(LvlEmogie).concat(NewEmogie));
        _Background(_element_name, _position);
    }


    private void _DoBtnProjekt(final View _Projekt, final double _position) {
        BDatenbank_map.get((int) _position).put("TF", "P");
        _Projekt.setBackgroundColor(0xFF607D8B);
        FileUtil.writeFile(FileUtil.getExternalStorageDir().concat("/010/".concat("BDaten.json")), new Gson().toJson(BDatenbank_map));
    }


    private void _SetItem2(final boolean _Visible, final TextView _kategorie_txt, final TextView _element_name, final TextView _wandgenau, final ImageView _boul_colour, final View _flash_btn, final View _top_btn, final View _projekt_btn, final double _position, final boolean _withHeader) {
        if (_Visible) {
            if (_withHeader) {
                _kategorie_txt.setVisibility(View.VISIBLE);
                _element_name.setVisibility(View.VISIBLE);
                _wandgenau.setVisibility(View.VISIBLE);
                _boul_colour.setVisibility(View.VISIBLE);
                _flash_btn.setVisibility(View.VISIBLE);
                _top_btn.setVisibility(View.VISIBLE);
                _projekt_btn.setVisibility(View.VISIBLE);
                _kategorie_txt.setText(BDatenbank_map.get((int) _position).get("wall").toString());
                _SetElementName(_element_name, _position);
                Wand_vorheriges_ele = BDatenbank_map.get((int) _position).get("wall").toString();
            } else {
                _kategorie_txt.setVisibility(View.GONE);
                _element_name.setVisibility(View.VISIBLE);
                _wandgenau.setVisibility(View.VISIBLE);
                _boul_colour.setVisibility(View.VISIBLE);
                _flash_btn.setVisibility(View.VISIBLE);
                _top_btn.setVisibility(View.VISIBLE);
                _projekt_btn.setVisibility(View.VISIBLE);
                _SetElementName(_element_name, _position);
            }
            _SetImage(_boul_colour, _position);
            _wandgenau.setText(BDatenbank_map.get((int) _position).get("location").toString());
        } else {
            _kategorie_txt.setVisibility(View.GONE);
            _element_name.setVisibility(View.GONE);
            _wandgenau.setVisibility(View.GONE);
            _boul_colour.setVisibility(View.GONE);
            _flash_btn.setVisibility(View.GONE);
            _top_btn.setVisibility(View.GONE);
            _projekt_btn.setVisibility(View.GONE);
        }
    }


    private void _ShowList1KeyInput(final double _position) {
        if (grade_filter_setting.getString("input", "").equals("close")) {
            Element_Visible = true;
            _ShowList0SetHeader(_position);
        } else {
            if (BDatenbank_map.get((int) _position).get("name").toString().toLowerCase().contains(grade_filter_setting.getString("input", "").toLowerCase()) || BDatenbank_map.get((int) _position).get("location").toString().toLowerCase().contains(grade_filter_setting.getString("input", "").toLowerCase())) {
                Element_Visible = true;
                _ShowList0SetHeader(_position);
            } else {
                Element_Visible = false;
            }
        }
    }


    private void _ShowList2(final double _position) {
        if (0 < Double.parseDouble(BDatenbank_map.get((int) _position).get("lvl").toString())) {
            if ("1".equals(filter_map_setting.get((int) Double.parseDouble(BDatenbank_map.get((int) _position).get("lvl").toString()) - 1).get("checked").toString())) {
                _ShowList1KeyInput(_position);
            } else {
                Element_Visible = false;
            }
        } else {
            Element_Visible = false;
        }
    }


    private void _ShowList3KeyTodo(final double _position) {
        if (grade_filter_setting.getString("filterTodo", "").equals("notChecked")) {
            _ShowList2(_position);
        } else {
            if (!(BDatenbank_map.get((int) _position).get("TF").toString().equals("T") || BDatenbank_map.get((int) _position).get("TF").toString().equals("F"))) {
                _ShowList2(_position);
            } else {
                Element_Visible = false;
            }
        }
    }


    private void _ShowList4KeyDone(final double _position) {
        if (grade_filter_setting.getString("filterDone", "").equals("notChecked")) {
            _ShowList3KeyTodo(_position);
        } else {
            if (BDatenbank_map.get((int) _position).get("TF").toString().equals("T") || BDatenbank_map.get((int) _position).get("TF").toString().equals("F")) {
                _ShowList3KeyTodo(_position);
            } else {
                Element_Visible = false;
            }
        }
    }


    private void _ShowList5KeyProjekt(final double _position) {
        if (grade_filter_setting.getString("filterProjekt", "").equals("notChecked")) {
            _ShowList4KeyDone(_position);
        } else {
            if (BDatenbank_map.get((int) _position).get("TF").toString().equals("P")) {
                _ShowList4KeyDone(_position);
            } else {
                Element_Visible = false;
            }
        }
    }


    private void _IntentExtraKeyGrades() {
        HashMap<String, Object> newBoulder = new HashMap<>();


        if (getIntent().getStringExtra("filter").contains("[")) {
            grade_filter_setting.edit().putString("filter", getIntent().getStringExtra("filter")).commit();
        } else {
            if (!grade_filter_setting.getString("filter", "").contains("[")) {
                if (getIntent().getStringExtra("filter").contains("first")) {
                    SketchwareUtil.showMessage(getApplicationContext(), "Erster Start! Willkommen!");
                    newBoulder = new HashMap<>();
                    newBoulder.put("lvl", "1⃣ Weiß (Stufe Anfänger)");
                    newBoulder.put("checked", "1");
                    newBoulder.put("Anzahl", "999");
                    FirstStart.add(newBoulder);
                    newBoulder = new HashMap<>();
                    newBoulder.put("lvl", "2⃣ Gelb (Stufe Fortgeschritten)");
                    newBoulder.put("checked", "1");
                    newBoulder.put("Anzahl", "999");
                    FirstStart.add(newBoulder);
                    newBoulder = new HashMap<>();
                    newBoulder.put("lvl", "3⃣ Grün (Stufe Hard)");
                    newBoulder.put("checked", "1");
                    newBoulder.put("Anzahl", "999");
                    FirstStart.add(newBoulder);
                    newBoulder = new HashMap<>();
                    newBoulder.put("lvl", "4⃣ Blau (Stufe Sehr Hard)");
                    newBoulder.put("checked", "1");
                    newBoulder.put("Anzahl", "999");
                    FirstStart.add(newBoulder);
                    newBoulder = new HashMap<>();
                    newBoulder.put("lvl", "5⃣ Rot (Stufe Meister)");
                    newBoulder.put("checked", "1");
                    newBoulder.put("Anzahl", "999");
                    FirstStart.add(newBoulder);
                    newBoulder = new HashMap<>();
                    newBoulder.put("lvl", "6⃣ Schwarz (Stufe Champion)");
                    newBoulder.put("checked", "1");
                    newBoulder.put("Anzahl", "999");
                    FirstStart.add(newBoulder);
                    grade_filter_setting.edit().putString("filter", new Gson().toJson(FirstStart)).commit();
                }
            }
        }
    }


    private void _IntentExtraKeyTags() {
        HashMap<String, Object> NewTag = new HashMap<>();

        if (getIntent().getStringExtra("tags").contains("[")) {
            grade_filter_setting.edit().putString("tags", getIntent().getStringExtra("tags")).commit();
        } else {
            if (!grade_filter_setting.getString("tags", "").contains("[")) {
                if (getIntent().getStringExtra("tags").contains("first")) {
                    SketchwareUtil.showMessage(getApplicationContext(), "Erster Start! 0o2! Korrekt");
                    NewTag = new HashMap<>();
                    NewTag.put("name", "onlyTags");
                    NewTag.put("image", "");
                    NewTag.put("checked", "0");
                    tagsListMap.add(NewTag);
                    NewTag = new HashMap<>();
                    NewTag.put("name", "POWER");
                    NewTag.put("image", "💪");
                    NewTag.put("checked", "0");
                    tagsListMap.add(NewTag);
                    NewTag = new HashMap<>();
                    NewTag.put("name", "POCKETS");
                    NewTag.put("image", "🧀");
                    NewTag.put("checked", "0");
                    tagsListMap.add(NewTag);
                    NewTag = new HashMap<>();
                    NewTag.put("name", "CRIMPY");
                    NewTag.put("image", "🔪");
                    NewTag.put("checked", "0");
                    tagsListMap.add(NewTag);
                    NewTag = new HashMap<>();
                    NewTag.put("name", "SLOPER");
                    NewTag.put("image", "🖐");
                    NewTag.put("checked", "0");
                    tagsListMap.add(NewTag);
                    NewTag = new HashMap<>();
                    NewTag.put("name", "CORE");
                    NewTag.put("image", "⚡");
                    NewTag.put("checked", "0");
                    tagsListMap.add(NewTag);
                    NewTag = new HashMap<>();
                    NewTag.put("name", "PINCHES");
                    NewTag.put("image", "🗜");
                    NewTag.put("checked", "0");
                    tagsListMap.add(NewTag);
                    NewTag = new HashMap<>();
                    NewTag.put("name", "MOBILITY");
                    NewTag.put("image", "🤸");
                    NewTag.put("checked", "0");
                    tagsListMap.add(NewTag);
                    NewTag = new HashMap<>();
                    NewTag.put("name", "COMMITMENT");
                    NewTag.put("image", "😱");
                    NewTag.put("checked", "0");
                    tagsListMap.add(NewTag);
                    NewTag = new HashMap<>();
                    NewTag.put("name", "BALANCE");
                    NewTag.put("image", "🎈");
                    NewTag.put("checked", "0");
                    tagsListMap.add(NewTag);
                    NewTag = new HashMap<>();
                    NewTag.put("name", "COMPLEXITY");
                    NewTag.put("image", "💭");
                    NewTag.put("checked", "0");
                    tagsListMap.add(NewTag);
                    NewTag = new HashMap<>();
                    NewTag.put("name", "SHOULDER");
                    NewTag.put("image", "🏋️‍♂️");
                    NewTag.put("checked", "0");
                    tagsListMap.add(NewTag);
                    NewTag = new HashMap<>();
                    NewTag.put("name", "DYNO");
                    NewTag.put("image", "🚀");
                    NewTag.put("checked", "0");
                    tagsListMap.add(NewTag);
                    NewTag = new HashMap<>();
                    NewTag.put("name", "POWER ENDURANCE");
                    NewTag.put("image", "🏇");
                    NewTag.put("checked", "0");
                    tagsListMap.add(NewTag);
                    NewTag = new HashMap<>();
                    NewTag.put("name", "COORDINATION");
                    NewTag.put("image", "🏂");
                    NewTag.put("checked", "0");
                    tagsListMap.add(NewTag);
                    grade_filter_setting.edit().putString("tags", new Gson().toJson(tagsListMap)).commit();
                }
            }
        }
        tagsListMap = new Gson().fromJson(grade_filter_setting.getString("tags", ""), new TypeToken<ArrayList<HashMap<String, Object>>>() {
        }.getType());
    }


    private void _isItemInTagsList(final double _position) {
        if (itemTagsList < tagsAktiV.size()) {
            if (BDatenbank_map.get((int) _position).get("tag").toString().contains(tagsAktiV.get((int) (itemTagsList)))) {
                _ShowList5KeyProjekt(_position);
            } else {
                itemTagsList++;
                _isItemInTagsList(_position);
            }
        } else {
            Element_Visible = false;
        }
    }


    private void _ShowList0SetHeader(final double _position) {
        Element_withHeader = !Wand_vorheriges_ele.equals(BDatenbank_map.get((int) _position).get("wall").toString());
    }


    private void _ShowList6KeyTags(final double _position) {
        if (tagsListMap.get((int) 0).get("checked").toString().contains("0")) {
            _ShowList5KeyProjekt(_position);
        } else {
            itemTagsList = 0;
            if (BDatenbank_map.get((int) _position).get("tag").toString().equals("")) {
                Element_Visible = false;
            } else {
                _isItemInTagsList(_position);
            }
        }
    }


    private void _SetBtnImage(final ImageView _flash_btn, final ImageView _top_btn, final ImageView _projekt_btn, final double _position) {
        if (BDatenbank_map.get((int) _position).get("TF").toString().contains("F")) {
            _flash_btn.setImageResource(R.drawable.flash_aktiv);
            _top_btn.setImageResource(R.drawable.top_btn);
            _projekt_btn.setImageResource(R.drawable.projekt);
        } else {
            if (BDatenbank_map.get((int) _position).get("TF").toString().contains("T")) {
                _flash_btn.setImageResource(R.drawable.flash_btn);
                _top_btn.setImageResource(R.drawable.top_aktiv);
                _projekt_btn.setImageResource(R.drawable.projekt);
            } else {
                if (BDatenbank_map.get((int) _position).get("TF").toString().contains("P")) {
                    _flash_btn.setImageResource(R.drawable.flash_btn);
                    _top_btn.setImageResource(R.drawable.top_btn);
                    _projekt_btn.setImageResource(R.drawable.projekt_aktiv);
                } else {
                    _flash_btn.setImageResource(R.drawable.flash_btn);
                    _top_btn.setImageResource(R.drawable.top_btn);
                    _projekt_btn.setImageResource(R.drawable.projekt);
                }
            }
        }
    }


    private void _SetLvlEmogie(final double _position) {
        if (BDatenbank_map.get((int) _position).get("lvl").toString().equals("1")) {
            LvlEmogie = "1⃣";
        } else {
            if (BDatenbank_map.get((int) _position).get("lvl").toString().equals("2")) {
                LvlEmogie = "2⃣";
            } else {
                if (BDatenbank_map.get((int) _position).get("lvl").toString().equals("3")) {
                    LvlEmogie = "3⃣";
                } else {
                    if (BDatenbank_map.get((int) _position).get("lvl").toString().equals("4")) {
                        LvlEmogie = "4⃣";
                    } else {
                        if (BDatenbank_map.get((int) _position).get("lvl").toString().equals("5")) {
                            LvlEmogie = "5⃣";
                        } else {
                            if (BDatenbank_map.get((int) _position).get("lvl").toString().equals("6")) {
                                LvlEmogie = "6⃣";
                            } else {
                                LvlEmogie = "error";
                            }
                        }
                    }
                }
            }
        }
    }

    public class Listview_rankingAdapter extends BaseAdapter {
        ArrayList<HashMap<String, Object>> _data;

        public Listview_rankingAdapter(ArrayList<HashMap<String, Object>> _arr) {
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
                _v = _inflater.inflate(R.layout.ranking_list, null);
            }

            final LinearLayout linear1 = (LinearLayout) _v.findViewById(R.id.linear1);
            final ImageView imageview1 = (ImageView) _v.findViewById(R.id.imageview1);
            final TextView textview3 = (TextView) _v.findViewById(R.id.textview3);
            final TextView textview1 = (TextView) _v.findViewById(R.id.textview1);
            final TextView textview2 = (TextView) _v.findViewById(R.id.textview2);


            return _v;
        }
    }

    public class BoulderlistviewAdapter extends BaseAdapter {
        ArrayList<HashMap<String, Object>> _data;

        public BoulderlistviewAdapter(ArrayList<HashMap<String, Object>> _arr) {
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
                _v = _inflater.inflate(R.layout.boulder_with_header, null);
            }

            final TextView kategorie_txt = (TextView) _v.findViewById(R.id.kategorie_txt);
            final LinearLayout header_with_item = (LinearLayout) _v.findViewById(R.id.header_with_item);
            final ImageView boul_colour = (ImageView) _v.findViewById(R.id.boul_colour123);
            final TextView element_name = (TextView) _v.findViewById(R.id.element_name123);
            final TextView wandgenau = (TextView) _v.findViewById(R.id.wandgenau123);
            final ImageView flash_image = (ImageView) _v.findViewById(R.id.flash_image);
            final ImageView top_image = (ImageView) _v.findViewById(R.id.top_image);
            final ImageView projekt_image = (ImageView) _v.findViewById(R.id.projekt_image);

            if (_position == 0) {
                Wand_vorheriges_ele = "nix";
            }
            _ShowList6KeyTags(_position);
            _SetItem2(Element_Visible, kategorie_txt, element_name, wandgenau, boul_colour, flash_image, top_image, projekt_image, _position, Element_withHeader);
            _SetBtnImage(flash_image, top_image, projekt_image, _position);
            flash_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View _view) {
                    _DoBtnFlash(element_name, _position);
                    flash_image.setImageResource(R.drawable.flash_aktiv);
                    top_image.setImageResource(R.drawable.top_btn);
                    projekt_image.setImageResource(R.drawable.projekt);
                }
            });
            top_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View _view) {
                    _DoBtnTop(element_name, _position);
                    flash_image.setImageResource(R.drawable.flash_btn);
                    top_image.setImageResource(R.drawable.top_aktiv);
                    projekt_image.setImageResource(R.drawable.projekt);
                }
            });
            projekt_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View _view) {
                    _DoBtnProjekt(element_name, _position);
                    flash_image.setImageResource(R.drawable.flash_btn);
                    top_image.setImageResource(R.drawable.top_btn);
                    projekt_image.setImageResource(R.drawable.projekt_aktiv);
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
