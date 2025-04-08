package com.example.takeanumbrella.ui.profile;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupWindow;
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

        Timestamp timestamp = rental.getStartTimeStamp();
        viewHolder.rentalNumber.setText("#" + rental.getRentalId());
        viewHolder.rentalStartDate.setText(new SimpleDateFormat("yyyy.MM.dd").format(timestamp));
        viewHolder.rentalCostViewValue.setText( rental.getRentalCost()+"USD");
        viewHolder.rentalDurationValue.setText(rental.getDuration()+"days");
        viewHolder.rentalStatusValue.setText("OK");

        return convertView;
    }

    private static class ViewHolder {
        final TextView rentalNumber, rentalStartDate, rentalCostViewValue, rentalDurationValue, rentalStatusValue;

        ViewHolder(View view) {
            rentalNumber = view.findViewById(R.id.rentalNumber);
            rentalCostViewValue = view.findViewById(R.id.rentalCostViewValue);
            rentalStartDate = view.findViewById(R.id.rentalStartDate);
            rentalDurationValue = view.findViewById(R.id.rentalDurationValue);
            rentalStatusValue = view.findViewById(R.id.rentalStatusValue);
            view.findViewById(R.id.rental_button).setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    showPopup(v);
                }
            });

        }
        private void showPopup(View anchorView){
            Context context = anchorView.getContext();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View popupView = inflater.inflate(R.layout.popup_box_detail_history_rental, null);
            PopupWindow popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
            popupWindow.showAtLocation(anchorView, Gravity.CENTER, 0, 0);
            Button closeButton = popupView.findViewById(R.id.detail_button);
            closeButton.setOnClickListener(view -> popupWindow.dismiss());
        }
    }
}