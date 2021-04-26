package com.surajdev.androidfinaltest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends BaseAdapter {
    private ArrayList<Place> data;
    private LayoutInflater inflater;

    public PlaceAdapter(Context context,ArrayList<Place>data)
    {
        this.data=data;
        inflater= LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.list_row,null);
            holder=new ViewHolder();
            holder.plName=convertView.findViewById(R.id.tvPlaceName);
            holder.plPrice = convertView.findViewById(R.id.pricetovit);
            holder.plImage=convertView.findViewById(R.id.ivPlaceImage);

            convertView.setTag(holder);
        }
        else
            holder=(ViewHolder)convertView.getTag();
        holder.plName.setText(data.get(position).getName());
        holder.plPrice.setText(String.valueOf(data.get(position).getPrice()));
        int imgID=convertView.getResources().getIdentifier(data.get(position).getImages().get(0),"mipmap",inflater.getContext().getPackageName());
        holder.plImage.setImageResource(imgID);

        return convertView;
    }
    private class ViewHolder{
        //objects upon the list_row xml file
        TextView plName;
        ImageView plImage;
        TextView plPrice;

    }
}
