package com.my.BDatenbankfirstTry.BoulRankStat.BoulderScreen.BoulderScreen;

import android.os.Parcel;
import android.os.Parcelable;

import com.my.BDatenbankfirstTry.R;

public class BoulderItem implements Parcelable {
    private String name;
    private String lvl;
    private String tags;
    private String tf;
    private String boulder_score;
    private String stone_color;
    private String location;
    private String kategorie;
    private String setter;
    private String date;
    private int PositionJson;

    public BoulderItem(int PositionJson, String name, String lvl, String tags, String tf, String boulder_score, String stone_color, String location, String kategorie, String setter, String date) {
        this.PositionJson = PositionJson;
        this.name = name;
        this.lvl = lvl;
        this.tags = tags;
        this.tf = tf;
        this.boulder_score = boulder_score;
        this.stone_color = stone_color;
        this.location = location;
        this.kategorie = kategorie;
        this.setter = setter;
        this.date = date;
    }


    protected BoulderItem(Parcel in) {
        name = in.readString();
        lvl = in.readString();
        tags = in.readString();
        tf = in.readString();
        boulder_score = in.readString();
        stone_color = in.readString();
        location = in.readString();
        kategorie = in.readString();
        setter = in.readString();
        date = in.readString();
    }

    public static final Creator<BoulderItem> CREATOR = new Creator<BoulderItem>() {
        @Override
        public BoulderItem createFromParcel(Parcel in) {
            return new BoulderItem(in);
        }

        @Override
        public BoulderItem[] newArray(int size) {
            return new BoulderItem[size];
        }
    };

    //Ändere Informationen, wenn es nötig ist.
    public void setName(String name) {
        this.name = name;
    }

    //Button FlashClicked bedeutet tf = F, Toped tf=T, Projekt tf = P, leer = X
    public void setTf(String tf) {
        this.tf = tf;
    }

    //Erhalte Informationen und Setze die Informationen, wenn nötig


    public int getPositionJson(){return PositionJson; }

    public String getColorText() {
        return stone_color;
    }

    public int get_image() {
        return _SetImage(stone_color);
    }

    private int _SetImage(String stone_color) {
        if (stone_color.contains("blau")) {
            return R.drawable.blau;
        } else {
            if (stone_color.contains("gelb")) {
                return R.drawable.gelb;
            } else {
                if (stone_color.contains("schwarz")) {
                    return R.drawable.schwarz;
                } else {
                    if (stone_color.contains("lila")) {
                        return R.drawable.lila;
                    } else {
                        if (stone_color.contains("naturstein")) {
                            return R.drawable.naturstein;
                        } else {
                            if (stone_color.contains("volumen")) {
                                return R.drawable.nur_volumen;
                            } else {
                                if (stone_color.contains("orange")) {
                                    return R.drawable.orange;
                                } else {
                                    if (stone_color.contains("pink")) {
                                        return R.drawable.pink;
                                    } else {
                                        if (stone_color.contains("rot")) {
                                            return R.drawable.rot;
                                        } else {
                                            if (stone_color.contains("gr")) {
                                                return R.drawable.gruen;
                                            } else {
                                                if (stone_color.contains("wei")) {
                                                    return R.drawable.weis;
                                                } else {
                                                    return R.drawable.app_icon;
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

    public int getFlashImage() {
        return SetFlashImage(tf);
    }

    private int SetFlashImage(String tf) {
        if (tf.contains("F")) {
            return R.drawable.flash_aktiv;
        } else
            return R.drawable.flash_btn;
    }

    public int getTopImage() {
        return SetTopImage(tf);
    }

    private int SetTopImage(String tf) {
        if (tf.contains("T")) {
            return R.drawable.top_aktiv;
        } else
            return R.drawable.top_btn;
    }

    public int getProjektImage() {
        return SetProjektImage(tf);
    }

    private int SetProjektImage(String tf) {
        if (tf.contains("P")) {
            return R.drawable.projekt_aktiv;
        } else {
            return R.drawable.projekt;
        }
    }

    public String getName() {
        return name;
    }

    public String getLvl() {
        return lvl;
    }

    public String getLvlEmogie() {
        return _SetLvlEmogie(lvl);
    }

    private String _SetLvlEmogie(String lvl) {
        if (lvl.contains("1")) {
            return "1⃣";
        } else {
            if (lvl.contains("2")) {
                return "2⃣";
            } else {
                if (lvl.contains("3")) {
                    return "3⃣";
                } else {
                    if (lvl.contains("4")) {
                        return "4⃣";
                    } else {
                        if (lvl.contains("5")) {
                            return "5⃣";
                        } else {
                            if (lvl.contains("6")) {
                                return "6⃣";
                            } else {
                                return "error";
                            }
                        }
                    }
                }
            }
        }
    }

    public String getTags() {
        return tags;
    }

    public String getTf() {
        return tf;
    }

    public String getBoulder_score() {
        return boulder_score;
    }

    public String getStone_color() {
        return stone_color;
    }

    public String getLocation() {
        return location;
    }

    public String getKategorie() {
        return kategorie;
    }

    public String getSetter() {
        return setter;
    }

    public String getDate() {
        return date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(lvl);
        dest.writeString(tags);
        dest.writeString(tf);
        dest.writeString(boulder_score);
        dest.writeString(stone_color);
        dest.writeString(location);
        dest.writeString(kategorie);
        dest.writeString(setter);
        dest.writeString(date);
    }
}
