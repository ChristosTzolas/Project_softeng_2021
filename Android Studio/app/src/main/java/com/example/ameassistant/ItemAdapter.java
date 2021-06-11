package com.example.ameassistant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    ListView myListView ;
    String[] it_ids;
    String[] it_vol_ids;
    String[] dates_and_times;
    String[] locations;
    String[] to_or_froms;
    String[] nums_seats;

    public ItemAdapter(Context c, String[] it_id, String[] it_vol_it, String[] date_and_time, String[] location, String[] to_or_from, String[] num_seats){
        it_ids = it_id;
        it_vol_ids = it_vol_it;
        dates_and_times = date_and_time;
        locations = location;
        to_or_froms = to_or_from;
        nums_seats = num_seats;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return it_ids.length;
    }

    @Override
    public Object getItem(int position) {
        return it_ids[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = mInflater.inflate(R.layout.my_listview_detail, null);
        TextView itIdListTextView = (TextView) v.findViewById(R.id.itIdListTextView);
        TextView itVolIdListTextView = (TextView) v.findViewById(R.id.itVolIdListTextView);
        TextView dateTimeListTextView = (TextView) v.findViewById(R.id.dateTimeListTextView);
        TextView locationsListTextView = (TextView) v.findViewById(R.id.locationsListTextView);
        TextView toOrFromListTextView = (TextView) v.findViewById(R.id.toOrFromListTextView);
        TextView numSeatsListTextView = (TextView) v.findViewById(R.id.numSeatsListTextView);

        String itid = it_ids[position];
        String itvolid = it_vol_ids[position];
        String datetime = dates_and_times[position];
        String locat = locations[position];
        String toorfrom = to_or_froms[position];
        String numseats = nums_seats[position];

        itIdListTextView.setText(itid);
        itVolIdListTextView.setText(itvolid);
        dateTimeListTextView.setText(datetime);
        locationsListTextView.setText(locat);
        toOrFromListTextView.setText(toorfrom);
        numSeatsListTextView.setText(numseats);



        return v;
    }
}
