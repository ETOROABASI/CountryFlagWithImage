package com.example.android.countryflag2;


// the Adapter holds the data while the ListView populates the data from the Adapter unto the ListView layout
// so without your Adapter, there would be nothing to populate on the ListView layout

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import static com.example.android.countryflag2.R.string.app_name;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;
    ListView mListView;

    String[] countryNames = {"Australia","Bosnia", "Brazil", "China", "France", "Germany", "India",
                            "Ireland", "Italy", "Mexico", "Nigeria", "Poland","Russia", "Spain", "USA"};
    int [] countryFlags = {R.drawable.australia, R.drawable.bosnia, R.drawable.brazil, R.drawable.china,R.drawable.france,
                            R.drawable.germany, R.drawable.india, R.drawable.ireland, R.drawable.italy, R.drawable.mexico,
                            R.drawable.nigeria, R.drawable.poland, R.drawable.russia, R.drawable.spain, R.drawable.usa};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView mTextView = (TextView) mToolbar.findViewById(R.id.toolbarTextView);
        mTextView.setText(getResources().getString(app_name));  //in order to centre the text, I put a textview as a child
                                                                //of the Toolbar View, using the Toolbar object to call
                                                                // the TextView in it
        mTextView.setTextSize(25);


                //COULD USE THIS TO SET THE NAME DIRECTLY ON THE TOOLBAR
//        mToolbar.setTitle(getResources().getString(app_name)); // could still use .getString(R.string.app_name)
//        mToolbar.setLogo(R.drawable.bosnia);    //to set a logo
//        mToolbar.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);



        mListView = (ListView) findViewById(R.id.listView);

        //calling the constructor
        MyAdapter myAdapter = new MyAdapter(MainActivity.this, countryNames, countryFlags);

        mListView.setAdapter(myAdapter);   // sets the list view to your custom adapter


        // sets a listener so that when an item i clicked, it goes to the next activity
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){

                Intent mIntent = new Intent (MainActivity.this, DetailActivity.class);
                mIntent.putExtra("CountryName", countryNames[i]);
                mIntent.putExtra("CountryFlag", countryFlags[i]);  //this is just a key, it doesn't mean that it has
                                                                //converted the int array to string variable
                startActivity(mIntent);

            }
        });
    }
}
