package com.example.myapplication;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationViewHolder> {

    ArrayList<Category> categories;
    Context context;


    public LocationAdapter(ArrayList<Category> categories, Context context) {
        this.categories = categories;
        this.context = context;
    }

    @NonNull
    @Override
    public LocationAdapter.LocationViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.location_item, viewGroup, false);

        return new LocationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationAdapter.LocationViewHolder locationViewHolder, int i) {

        final int post = locationViewHolder.getAdapterPosition();
        final Category category = categories.get(i);

        locationViewHolder.txt.setText(category.getCName());
//        locationViewHolder.txt1.setText(category.getCatId());

        locationViewHolder.txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((PickLocation) context).userItemClick(v, post);
//                int pos = -1;
//                pos = categories.indexOf(category.getCName());
//                Log.d(TAG, "onClick: " + pos);
//
//                Intent intent = new Intent(context, Main2Activity.class);
//                intent.putExtra("pos", pos);
//                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class LocationViewHolder extends RecyclerView.ViewHolder{

        TextView txt, txt1;
        RelativeLayout layout;
        Context context;

        public LocationViewHolder(@NonNull View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.loc_txt);
            txt1 = itemView.findViewById(R.id.loc_txt1);
            layout = itemView.findViewById(R.id.rel_loc);

            context = itemView.getContext();
//            itemView.setOnClickListener(this);
//            layout.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(context, Main2Activity.class);
////                    Bundle bundle = new Bundle();
////                    bundle.putSerializable("DATA",  categories.get(getAdapterPosition()));
////                    intent.putExtras(bundle);
//                    intent.putExtra("pos", getAdapterPosition());
//                    context.startActivity(intent);
//
//                }
//            });
        }

//        @Override
//        public void onClick(View v) {
//            if (mClickListener != null) mClickListener.onItemClick(v, getAdapterPosition());
//        }
    }

}
