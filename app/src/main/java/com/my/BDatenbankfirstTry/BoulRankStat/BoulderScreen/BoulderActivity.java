package com.my.BDatenbankfirstTry.BoulRankStat.BoulderScreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.SearchView;
import android.widget.Toast;

import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.my.BDatenbankfirstTry.BoulRankStat.BoulderScreen.BoulderScreen.GradeFilter.GradeFilterActivity;
import com.my.BDatenbankfirstTry.BoulRankStat.BoulderScreen.BoulderScreen.GradeFilter.GradeItem;
import com.my.BDatenbankfirstTry.BoulRankStat.BoulderScreen.BoulderScreen.boulder_recyclerViewAdapter;
import com.my.BDatenbankfirstTry.BoulRankStat.BoulderScreen.BoulderScreen.FragmentBoulder;
import com.my.BDatenbankfirstTry.BoulRankStat.BoulderScreen.RankingScreen.FragmentRanking;
import com.my.BDatenbankfirstTry.BoulRankStat.BoulderScreen.StatistikScreen.FragmentStatistik;
import com.my.BDatenbankfirstTry.LoginActivity;
import com.my.BDatenbankfirstTry.R;
import com.my.BDatenbankfirstTry.SketchwareUtil;

import java.util.ArrayList;

public class BoulderActivity extends AppCompatActivity {
    ArrayList<String> selectionFilter = new ArrayList<>();
    private Intent i = new Intent();
    MaterialSearchView searchView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boulder_main);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        searchView = findViewById(R.id.search_view);
        TabLayout tabLayout = findViewById(R.id.tabs);
        ViewPager viewPager = findViewById(R.id.viewpager);

        NestedScrollView scrollView = findViewById(R.id.nestedScrollViewId);
        scrollView.setFillViewport(true);
        //Adding Fragments
        final ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new FragmentBoulder(), "Boulder");
        adapter.AddFragment(new FragmentRanking(), "Ranking");
        adapter.AddFragment(new FragmentStatistik(), "Statistik");

        //adaper Setup
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        if(getIntent().hasExtra("filter"))
        {
            //Todo weiter implimentireren damit grades gefiltert werden
            SketchwareUtil.showMessage(getApplicationContext(), "Actifity has extra filter");
        }


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                toolbar.setTitle(adapter.getPageTitle(tab.getPosition()));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        tabLayout.setupWithViewPager(viewPager);

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                SketchwareUtil.showMessage(getApplicationContext(), query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                RecyclerView recyclerView;
                recyclerView = findViewById(R.id.recyclerView123);

                boulder_recyclerViewAdapter adapterRecy = (boulder_recyclerViewAdapter) recyclerView.getAdapter();

                adapterRecy.getFilter().filter(newText);

                return true;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //Do some magic
            }

            @Override
            public void onSearchViewClosed() {
                //Do some magic
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);

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

    public void itemClick(View view) {
        //Button Filter Setup
        CheckBox todo = findViewById(R.id.TodoCheckBox123123);
        CheckBox done = findViewById(R.id.Done123123);
        CheckBox projekt = findViewById(R.id.projekt123123);
        boolean checked = ((CheckBox) view).isChecked();
        RecyclerView recyclerView;
        recyclerView = findViewById(R.id.recyclerView123);

        boulder_recyclerViewAdapter adapterRecy = (boulder_recyclerViewAdapter) recyclerView.getAdapter();

        switch (view.getId()) {
            case R.id.TodoCheckBox123123:
                if (checked) {
                    adapterRecy.getFilter().filter("$todo");
                    selectionFilter.add("todo");
                    if (selectionFilter.contains("done")) {
                        done.setChecked(false);
                        selectionFilter.remove("done");
                    }
                } else {
                    adapterRecy.getFilter().filter("");
                    selectionFilter.remove("todo");
                    if (selectionFilter.contains("projekt")) {
                        selectionFilter.remove("projekt");
                        projekt.setChecked(false);
                    }
                }
                break;
            case R.id.Done123123:
                if (checked) {
                    selectionFilter.add("done");
                    adapterRecy.getFilter().filter("$done");
                    if (selectionFilter.contains("todo")) {
                        todo.setChecked(false);
                        selectionFilter.remove("todo");
                    }
                    if (selectionFilter.contains("projekt")) {
                        adapterRecy.getFilter().filter("");
                        projekt.setChecked(false);
                        selectionFilter.remove("projekt");
                    }
                } else {
                    selectionFilter.remove("done");
                    adapterRecy.getFilter().filter("");
                }
                break;

            case R.id.projekt123123:
                if (checked) {
                    selectionFilter.add("projekt");
                    adapterRecy.getFilter().filter("$projekt");
                    if (!selectionFilter.contains("todo")) {
                        selectionFilter.add("todo");
                        todo.setChecked(true);
                    }
                    if (selectionFilter.contains("done")) {
                        selectionFilter.remove("done");
                        done.setChecked(false);
                    }
                } else {
                    selectionFilter.remove("projekt");
                    adapterRecy.getFilter().filter("$todo");
                }
        }
    }

    public void tagsClick(View v)
    {
        Toast.makeText(getApplicationContext(), "Tags Clicked", Toast.LENGTH_SHORT).show();

    }

    public void GradeSettingClick(View v)
    {
        Toast.makeText(getApplicationContext(), "Grade Clicked", Toast.LENGTH_SHORT).show();

        //Todo mit Shared Preferences Lösen, damit Daten gespeichert werden
        GradeItem item = new GradeItem(1, 2, 3, 4, 5, 6, true);
        i.putExtra("GradeFilter", item);
        i.setClass(getApplicationContext(), GradeFilterActivity.class);
        startActivity(i);
    }
}
