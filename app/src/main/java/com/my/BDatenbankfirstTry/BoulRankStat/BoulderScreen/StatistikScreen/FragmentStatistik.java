package com.my.BDatenbankfirstTry.BoulRankStat.BoulderScreen.StatistikScreen;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.my.BDatenbankfirstTry.R;

public class FragmentStatistik extends Fragment {
    View view;
    public FragmentStatistik() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.boulder_statistik_fragment, container, false);
        return view;
    }
}
