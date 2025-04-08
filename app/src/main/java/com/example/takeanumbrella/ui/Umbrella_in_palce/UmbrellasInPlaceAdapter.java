package com.example.takeanumbrella.ui.Umbrella_in_palce;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.takeanumbrella.R;
import com.example.takeanumbrella.data.Rental.Rental;
import com.example.takeanumbrella.data.Umbrella.Umbrella;


import java.util.ArrayList;
public class UmbrellasInPlaceAdapter extends ArrayAdapter<Umbrella>{
    private final LayoutInflater inflater;
    private final int layout;

    private final ArrayList<Umbrella> UmbrellaList;

    UmbrellasInPlaceAdapter(Context context, int source, ArrayList<Umbrella> umbrellas) {
        super(context, source, umbrellas);
        this.inflater = LayoutInflater.from(context);
        this.layout = source;
        this.UmbrellaList = umbrellas;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Umbrella umbrellas = UmbrellaList.get(position);
        return convertView;
    }
    private static class ViewHolder{
        ViewHolder(View view){

        }
    };


}
