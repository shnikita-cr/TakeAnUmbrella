package com.example.takeanumbrella.ui.rentallocations;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.takeanumbrella.R;
import com.example.takeanumbrella.data.RentalLocation.RentalLocation;

import java.util.ArrayList;


public class RentalLocationsAdapter extends ArrayAdapter<RentalLocation> {
    private final LayoutInflater inflater;
    private final int layout;
    private final ArrayList<RentalLocation> rentalLocationList;

    RentalLocationsAdapter(Context context, int resource, ArrayList<RentalLocation> rentalLocationList) {
        super(context, resource, rentalLocationList);
        this.rentalLocationList = rentalLocationList;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        final RentalLocationsAdapter.ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new RentalLocationsAdapter.ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (RentalLocationsAdapter.ViewHolder) convertView.getTag();
        }

        final RentalLocation rentalLocation = rentalLocationList.get(position);

//        viewHolder.rentalLocationListNumberValue.setText(String.valueOf(position + 1));
//        viewHolder.rentalPlaceAddressValue.setText(rentalLocation.getAdress());
//        viewHolder.vacantUmbrellasCountValue.setText(String.valueOf(rentalLocation.getValidUmbrellaCount()));
        return convertView;
    }

    private static class ViewHolder {
//        final TextView rentalPlaceAddressValue, vacantUmbrellasCountValue, rentalLocationListNumberValue;

        ViewHolder(View view) {
//            rentalPlaceAddressValue = view.findViewById(R.id.rentalPlaceAddressValue);
//            vacantUmbrellasCountValue = view.findViewById(R.id.vacantUmbrellasCountValue);
//            rentalLocationListNumberValue = view.findViewById(R.id.rentalLocationListNumberValue);
        }
    }
}
