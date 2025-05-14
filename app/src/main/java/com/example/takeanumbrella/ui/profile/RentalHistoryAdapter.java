package com.example.takeanumbrella.ui.profile;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.takeanumbrella.R;
import com.example.takeanumbrella.data.Rental.Rental;

import java.sql.Timestamp;
import java.util.ArrayList;

class RentalHistoryAdapter extends ArrayAdapter<Rental> {
    private final LayoutInflater inflater;
    private final int layout;
    private final ArrayList<Rental> rentalList;

    RentalHistoryAdapter(Context context, int resource, ArrayList<Rental> products) {
        super(context, resource, products);
        this.rentalList = products;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Rental rental = rentalList.get(position);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        viewHolder.rentalNumber.setText("№" + "12345");
        viewHolder.rentalStartDate.setText(new SimpleDateFormat("yyyy.MM.dd").format(timestamp));
        viewHolder.rentalCostViewValue.setText("50");
        viewHolder.rentalDurationValue.setText("50:34");

        return convertView;
    }

    private static class ViewHolder {
        final TextView rentalNumber, rentalStartDate, rentalCostViewValue, rentalDurationValue;

        ViewHolder(View view) {
            rentalNumber = view.findViewById(R.id.rentalNumber);
            rentalCostViewValue = view.findViewById(R.id.rentalCostViewValue);
            rentalStartDate = view.findViewById(R.id.rentalStartDate);
            rentalDurationValue = view.findViewById(R.id.rentalDurationValue);
        }
    }
}