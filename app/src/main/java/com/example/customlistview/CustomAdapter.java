package com.example.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    ArrayList<AndroidVersion> androidlist;
    Context context;

    CustomAdapter(Context c) {
        //get the images and names
        androidlist = new ArrayList<>();
        this.context = c;

        String[] cNames = c.getResources().getStringArray(R.array.codeName);//android version names
        String[] apiLevel = c.getResources().getStringArray(R.array.apiLevel);//API levels
        int[] images = {R.drawable.cupcake,R.drawable.donut,R.drawable.eclair,R.drawable.froyo,R.drawable.gingerbread,
                R.drawable.honeycomb,R.drawable.ics,R.drawable.jellybean,R.drawable.kitkat,R.drawable.lollipop};//logos
        for(int i = 0; i<cNames.length; i++){
            androidlist.add(new AndroidVersion(cNames[i],apiLevel[i],images[i]));
        }
    }

    @Override
    public int getCount() {
        return androidlist.size();
    }

    @Override
    public Object getItem(int position) {
        return androidlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewRef = inflater.inflate(R.layout.row, parent, false);
        TextView txtCode = viewRef.findViewById(R.id.Names);
        TextView txtApi = viewRef.findViewById(R.id.ApiLevel);
        ImageView logo = viewRef.findViewById(R.id.logo);

        AndroidVersion temp = androidlist.get(position);

        txtCode.setText(temp.codeName);
        txtApi.setText(temp.apiLevel);
        logo.setImageResource(temp.image);


        return viewRef;
    }
}
