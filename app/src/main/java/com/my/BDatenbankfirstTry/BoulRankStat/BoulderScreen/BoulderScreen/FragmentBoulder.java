package com.my.BDatenbankfirstTry.BoulRankStat.BoulderScreen.BoulderScreen;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.my.BDatenbankfirstTry.BoulRankStat.BoulderScreen.BoulderScreen.GradeFilter.GradeItem;
import com.my.BDatenbankfirstTry.FileUtil;
import com.my.BDatenbankfirstTry.R;

import java.util.ArrayList;
import java.util.HashMap;

public class FragmentBoulder extends Fragment {
    View view;
    ArrayList<BoulderItem> BoulderItemList = new ArrayList<>();
    GradeItem grades;
    private ArrayList<HashMap<String, Object>> BDatenbank_map = new ArrayList<>();

    private Context mContext;

    public FragmentBoulder() {

        initializeLogic();

    }

    private void initializeLogic() {

        if (FileUtil.readFile(FileUtil.getExternalStorageDir().concat("/010/".concat("BDaten.json"))).startsWith("[")) {
            BDatenbank_map = new Gson().fromJson(FileUtil.readFile(FileUtil.getExternalStorageDir().concat("/010/".concat("BDaten.json"))), new TypeToken<ArrayList<HashMap<String, Object>>>() {
            }.getType());
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.boulder_content_fragment, container, false);
        //TODO TOOLBAR SEARCH VIEW IMPLIMENTIEREN mit versteckter anzeige
        //Toolbar toolbar = get

        CreateExampleList();
        buildRecyclerView();

        return view;
    }

    private void buildRecyclerView() {
        RecyclerView mRecyclerView;
        final boulder_recyclerViewAdapter mAdapter;
        RecyclerView.LayoutManager mlayoutManager;


        mRecyclerView = view.findViewById(R.id.recyclerView123);
        mRecyclerView.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mAdapter = new boulder_recyclerViewAdapter(BoulderItemList);
        mRecyclerView.setLayoutManager(mlayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new boulder_recyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //Click auf Item Startet Aktivity
                mContext = view.getContext();

                Intent intent = new Intent(mContext, BldGenauActivity.class);
                intent.putExtra("BoulderProblem", BoulderItemList.get(position));
                mContext.startActivity(intent);
            }

            @Override
            public void onFlashClick(int position) {
                if(BoulderItemList.get(position).getTf().contains("F"))
                {
                    BtnPressTF_and_Save(position, "X");

                }else {
                    BtnPressTF_and_Save(position, "F");
                }
            }

            @Override
            public void onTopClick(int position) {
                if(BoulderItemList.get(position).getTf().contains("T"))
                {
                    BtnPressTF_and_Save(position, "X");
                }else {
                    BtnPressTF_and_Save(position, "T");
                }
            }

            @Override
            public void onProjektClick(int position) {
                if(BoulderItemList.get(position).getTf().contains("P")){
                    BtnPressTF_and_Save(position, "X");
                }else
                {
                    BtnPressTF_and_Save(position, "P");
                }
            }

            private void BtnPressTF_and_Save(int position, String value) {
                BoulderItemList.get(position).setTf(value);
                mAdapter.notifyItemChanged(position);

                //Offlin Save
                position = BoulderItemList.get(position).getPositionJson();
                BDatenbank_map.get(position).put("TF", value);
                FileUtil.writeFile(FileUtil.getExternalStorageDir().concat("/010/".concat("BDaten.json")), new Gson().toJson(BDatenbank_map));
            }
        });
    }

    private void CreateExampleList() {
        //Json Elemente in die BoulderItemList hinzufügen
        for(int position = 0; position < BDatenbank_map.size(); position++)
        {
            //Error
            //grades.addProblemBoulderItem(position, BDatenbank_map.get(position).get("name").toString(), BDatenbank_map.get(position).get("lvl").toString(), BDatenbank_map.get(position).get("tag").toString(), BDatenbank_map.get(position).get("TF").toString(), BDatenbank_map.get(position).get("score").toString(), BDatenbank_map.get(position).get("b_color").toString(), BDatenbank_map.get(position).get("location").toString(), BDatenbank_map.get(position).get("wall").toString(), BDatenbank_map.get(position).get("setter").toString(), BDatenbank_map.get(position).get("data").toString());
            BoulderItemList.add(new BoulderItem(position, BDatenbank_map.get(position).get("name").toString(), BDatenbank_map.get(position).get("lvl").toString(), BDatenbank_map.get(position).get("tag").toString(), BDatenbank_map.get(position).get("TF").toString(), BDatenbank_map.get(position).get("score").toString(), BDatenbank_map.get(position).get("b_color").toString(), BDatenbank_map.get(position).get("location").toString(), BDatenbank_map.get(position).get("wall").toString(), BDatenbank_map.get(position).get("setter").toString(), BDatenbank_map.get(position).get("data").toString() ));
        }
        //BoulderItemList = grades.getBoulderItemList();
    }
}
