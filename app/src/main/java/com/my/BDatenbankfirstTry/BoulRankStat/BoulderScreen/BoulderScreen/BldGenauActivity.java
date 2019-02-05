package com.my.BDatenbankfirstTry.BoulRankStat.BoulderScreen.BoulderScreen;

import android.os.*;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import com.my.BDatenbankfirstTry.BoulRankStat.BoulderScreen.BoulderScreen.BoulderItem;
import com.my.BDatenbankfirstTry.R;

public class BldGenauActivity extends AppCompatActivity {

	private ImageView imageview123;
	private TextView boulder_name;
	private TextView boulder_lvl;
	private TextView taga_txt_test;
	private TextView tf;
	private TextView boulder_score;
	private TextView boulder_colour;
	private TextView boulder_location;
	private TextView boulder_wall;
	private TextView boulder_setter;
	private TextView date_test;

	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.bld_genau);
		initialize();
		initializeLogic();
	}
	
	private void initialize() {

		imageview123 = findViewById(R.id.imageview123);

		boulder_name = findViewById(R.id.boulder_name);
		boulder_lvl = findViewById(R.id.boulder_lvl);
		taga_txt_test = findViewById(R.id.taga_txt_test);
		tf = findViewById(R.id.tf);
		boulder_score = findViewById(R.id.boulder_score);
		boulder_colour = findViewById(R.id.boulder_colour);
		boulder_location = findViewById(R.id.boulder_location);
		boulder_wall = findViewById(R.id.boulder_wall);
		boulder_setter = findViewById(R.id.boulder_setter);
		date_test = findViewById(R.id.date_test);
	}
	private void initializeLogic() {

		//Objekt wird mit Parceable mit Intent eingelesen :D
		//Intent intent = getIntent(); //has everything!
        //Bundle b = intent.getExtras(); //has extra!
		//BoulderItem boulderItem boulderItem = b.getParcelable("bm");	//correct!
		BoulderItem boulderItem  = getIntent().getParcelableExtra("BoulderProblem"); //funktioniert auch :D

		boulder_name.setText(boulderItem.getName());
		boulder_lvl.setText(boulderItem.getLvl());
		boulder_wall.setText(boulderItem.getKategorie());
		boulder_location.setText(boulderItem.getLocation());
		boulder_colour.setText(boulderItem.getColorText());
		boulder_score.setText(boulderItem.getBoulder_score());
		tf.setText(boulderItem.getTf());
		boulder_setter.setText(boulderItem.getSetter());
		taga_txt_test.setText(boulderItem.getTags());
		date_test.setText(boulderItem.getDate());
		imageview123.setImageResource(boulderItem.get_image());
	}
}
