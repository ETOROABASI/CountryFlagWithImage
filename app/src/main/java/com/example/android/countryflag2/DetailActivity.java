package com.example.android.countryflag2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import static com.example.android.countryflag2.R.id.textView;

public class DetailActivity extends AppCompatActivity {
    Toolbar mToolbar;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mToolbar = (Toolbar) findViewById(R.id.toolbarDetail);
        mImageView = (ImageView) findViewById(R.id.imageViewDetail);

        Bundle mBundle = getIntent().getExtras();

        if (mBundle!= null){                                       // if the bunle is not empty do the following\
            Log.v("DetailActivity", "you have clicked");
            mToolbar.setTitle(mBundle.getString("CountryName"));
            mImageView.setImageResource(mBundle.getInt("CountryFlag"));


        }
    }

    public void imageClick(){
        Log.v("DetailActivity", "you have clicked on the image");

        Context context = getApplicationContext();
        CharSequence text = "You have clicked on " + "image";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }
}
