package com.example.android.countryflag2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ETORO on 16/04/2017.
 */

public class MyAdapter extends ArrayAdapter<String> {
    String[] names;
    int[] flags;
    Context mContext;

    public MyAdapter(Context context, String[] countryNames, int[] countryFlags){
        super(context, R.layout.mylistview_items);           //the resource is the id of the view that our custom list view be inside
        this.flags = countryFlags;
        this.names = countryNames;
        this.mContext = context;
    }


    // this method returns the length of the names array

    //without this method we would have an empty activity b/c the adapter would not know the size of your list
    @Override
    public int getCount() {
        return names.length;
    }



    // this method is used to set the values to its appropriate views
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();  //initializing the viewHolder
        if (convertView == null){

            //inflate the layout where our views are resident
            LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.mylistview_items, parent, false);


            // THIS WOULD HAVE BEEN THE CODE WITHOUT THE VIEWHOLDER
//            ImageView mFlag = (ImageView) convertView.findViewById(R.id.imageView);
//            TextView mName = (TextView) convertView.findViewById(R.id.textView);
//
//            //to set the images and text in the array to their respective views
//            mFlag.setImageResource(flags[position]);
//            mName.setText(names[position]);



                    //THIS IS THE CODE WITH THE VIEWHOLDER


            mViewHolder.mFlag = (ImageView) convertView.findViewById(R.id.imageView);
            mViewHolder.mName = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(mViewHolder);

        }else{
            mViewHolder = (ViewHolder) convertView.getTag();
        }

            //to set the images and text in the array to their respective views
            mViewHolder.mFlag.setImageResource(flags[position]);
            mViewHolder.mName.setText(names[position]);




        return convertView; //returns the view xml: convertView hold the mylistview_item.xml
    }

    /**
     * this class is created to enable our scrolling ie, so that the code would not always go and check out the
     * findViewById each time thereby slowing down the scrolling
     */
    static class ViewHolder{
        ImageView mFlag;
        TextView mName;
    }
}
