package me.rohanjahagirdar.outofeden.Onboarding;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import me.rohanjahagirdar.outofeden.R;

/**
 * Created by Rohan Jahagirdar on 1/5/2018.
 */

public class IndexAdapterJava extends RecyclerView.Adapter<IndexAdapterJava.LocationViewHolder>{
    @Override
    public LocationViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.index_item, viewGroup, false);
        LocationViewHolder pvh = new LocationViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(LocationViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public static class LocationViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView personName;
        TextView personAge;
        ImageView personPhoto;

        LocationViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card);

        }
    }
}
