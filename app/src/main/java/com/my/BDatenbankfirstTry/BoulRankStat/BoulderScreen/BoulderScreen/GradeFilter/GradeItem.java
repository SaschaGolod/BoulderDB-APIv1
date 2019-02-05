package com.my.BDatenbankfirstTry.BoulRankStat.BoulderScreen.BoulderScreen.GradeFilter;

import android.os.Parcel;
import android.os.Parcelable;

import com.my.BDatenbankfirstTry.BoulRankStat.BoulderScreen.BoulderScreen.BoulderItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GradeItem implements Parcelable {
    public ArrayList<BoulderItem> BoulderProblems = new ArrayList<>();
    public ArrayList counter = new ArrayList<>(6);
    //Anzahl der Routen
    private ArrayList<HashMap<String, Object>> FirstStart = new ArrayList<>();
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;



    public GradeItem(int Lvl1Count, int Lvl2Count, int Lvl3Count, int Lvl4Count, int Lvl5Count, int Lvl6Count, boolean firstStart) {
        CreateKeyGrades(Lvl1Count, Lvl2Count, Lvl3Count, Lvl4Count, Lvl5Count, Lvl6Count);

        a=Lvl1Count;
        b=Lvl2Count;
        c=Lvl3Count;
        d=Lvl4Count;
        e=Lvl5Count;
        f=Lvl6Count;

    }

    protected GradeItem(Parcel in) {
        a = in.readInt();
        b = in.readInt();
        c = in.readInt();
        d = in.readInt();
        e = in.readInt();
        f = in.readInt();

        CreateKeyGrades(a, b, c, d, e, f);
    }

    public static final Creator<GradeItem> CREATOR = new Creator<GradeItem>() {
        @Override
        public GradeItem createFromParcel(Parcel in) {
            return new GradeItem(in);
        }

        @Override
        public GradeItem[] newArray(int size) {
            return new GradeItem[size];
        }
    };

    //Methode in welcher die BouldeProbleme hinzugefügt werden
    public void addProblemBoulderItem(int PositionJson, String name, String lvl, String tags, String tf, String boulder_score, String stone_color, String location, String kategorie, String setter, String date)
    {
        BoulderProblems.add(new BoulderItem(PositionJson, name, lvl, tags, tf, boulder_score, stone_color, location, kategorie, setter, date));
        counter.set(Integer.parseInt(lvl), counter.get(Integer.parseInt(lvl)+1));

    }

    public ArrayList<BoulderItem> getBoulderItemList()
    {
        return BoulderProblems;
    }
    private void CreateKeyGrades(int p1, int p2, int p3, int p4, int p5, int p6) {
        HashMap<String, Object> newBoulder = new HashMap<>();

        newBoulder = new HashMap<>();
        newBoulder.put("lvl", "1⃣ Weiß (Stufe Anfänger)");
        newBoulder.put("checked", "1");
        newBoulder.put("Anzahl", p1);
        FirstStart.add(newBoulder);
        newBoulder = new HashMap<>();
        newBoulder.put("lvl", "2⃣ Gelb (Stufe Fortgeschritten)");
        newBoulder.put("checked", "1");
        newBoulder.put("Anzahl", p2);
        FirstStart.add(newBoulder);
        newBoulder = new HashMap<>();
        newBoulder.put("lvl", "3⃣ Grün (Stufe Hard)");
        newBoulder.put("checked", "1");
        newBoulder.put("Anzahl", p3);
        FirstStart.add(newBoulder);
        newBoulder = new HashMap<>();
        newBoulder.put("lvl", "4⃣ Blau (Stufe Sehr Hard)");
        newBoulder.put("checked", "1");
        newBoulder.put("Anzahl", p4);
        FirstStart.add(newBoulder);
        newBoulder = new HashMap<>();
        newBoulder.put("lvl", "5⃣ Rot (Stufe Meister)");
        newBoulder.put("checked", "1");
        newBoulder.put("Anzahl", p5);
        FirstStart.add(newBoulder);
        newBoulder = new HashMap<>();
        newBoulder.put("lvl", "6⃣ Schwarz (Stufe Champion)");
        newBoulder.put("checked", "1");
        newBoulder.put("Anzahl", p6);
        FirstStart.add(newBoulder);
    }

    public ArrayList getGradeMap(){
        return FirstStart;
    }


    /*private void _IntentExtraKeyTags() {
        HashMap<String, Object> NewTag = new HashMap<>();

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
    }*/


    public String getLvlName(int position) {
        HashMap<String, Object> bla = FirstStart.get(position);
        if (bla.containsKey("lvl")) {
            return bla.get("lvl").toString();
        }
        return "TestName";
    }

    public int getAmountLvl(int position) {
        HashMap<String, Object> bla = FirstStart.get(position);
        if (bla.containsKey("lvl")) {
            return (Integer) bla.get("Anzahl");
        }
        return 998;
    }

    //Liefert die gesamte Anzahl an Routen zurück
    public int getAmountAll() {
        int a = 0;
        for(int i = 0; i < FirstStart.size(); i++)
        {
            a += (Integer) FirstStart.get(i).get("Anzahl");
        }
        return a;
    }

    //Liefert die Anzahl der Schwierigkeitsgrade zurück
    public int getLvlAmount() {
        return FirstStart.size();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(a);
        dest.writeInt(b);
        dest.writeInt(c);
        dest.writeInt(d);
        dest.writeInt(e);
        dest.writeInt(f);
    }


//    SketchwareUtil.showMessage(getApplicationContext(), "Erster Start! Willkommen!");

}
