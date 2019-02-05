package com.my.BDatenbankfirstTry.BoulRankStat.BoulderScreen.BoulderScreen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.my.BDatenbankfirstTry.R;

import java.util.ArrayList;
import java.util.List;

public class boulder_recyclerViewAdapter extends RecyclerView.Adapter<boulder_recyclerViewAdapter.ExampleViewHolder> implements Filterable {
    private List<BoulderItem> mExampleList;
    private List<BoulderItem> mExampleListFull;

    private OnItemClickListener mLisener;

    @Override
    public Filter getFilter() {
        return getFilter213;
    }


    public interface OnItemClickListener {
        void onItemClick(int position);

        void onFlashClick(int position);

        void onTopClick(int position);

        void onProjektClick(int position);
    }


    public void setOnItemClickListener(OnItemClickListener listener) {
        mLisener = listener;
    }


    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView boul_colour;
        public TextView element_name;
        public TextView wandgenau;
        public ImageView flashBtn;
        public ImageView topBtn;
        public ImageView projektBtn;
        private final Context mcontext;


        public ExampleViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);

            boul_colour = itemView.findViewById(R.id.boul_colour123);
            element_name = itemView.findViewById(R.id.element_name123);
            wandgenau = itemView.findViewById(R.id.wandgenau123);
            flashBtn = itemView.findViewById(R.id.flash_image);
            topBtn = itemView.findViewById(R.id.top_image);
            projektBtn = itemView.findViewById(R.id.projekt_image);

            this.mcontext = itemView.getContext();

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);

                        }
                    }
                }
            });

            flashBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onFlashClick(position);

                        }
                    }
                }
            });

            topBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onTopClick(position);
                        }
                    }
                }
            });

            projektBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onProjektClick(position);
                        }
                    }
                }
            });
        }
    }


    public boulder_recyclerViewAdapter(ArrayList<BoulderItem> exampleList) {
        //für SUCHE
        this.mExampleList = exampleList;
        mExampleListFull = new ArrayList<>(mExampleList);

    }

    @NonNull
    @Override
    public boulder_recyclerViewAdapter.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.boulder_item, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v, mLisener);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull boulder_recyclerViewAdapter.ExampleViewHolder holder, int position) {
        //Hier werden die Ganzen Sachen gesetzt :)
        BoulderItem currentItem = mExampleList.get(position);
        holder.boul_colour.setImageResource(currentItem.get_image());
        //todo tags setzen richtig
        holder.element_name.setText(currentItem.getName() + "\n" + currentItem.getLvlEmogie() + currentItem.getTags());
        holder.wandgenau.setText(currentItem.getLocation().replace("-> ", "-->\n"));
        holder.flashBtn.setImageResource(currentItem.getFlashImage());
        holder.topBtn.setImageResource(currentItem.getTopImage());
        holder.projektBtn.setImageResource(currentItem.getProjektImage());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }


    private Filter getFilter213 = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<BoulderItem> filteredList = new ArrayList<>();
            if (constraint == "$todo") {
                for (BoulderItem item : mExampleListFull) {
                    if (!(item.getTf().toLowerCase().contains("t") || item.getTf().toLowerCase().contains("f"))) {
                        filteredList.add(item);
                    }
                }
            } else if (constraint == "$done") {
                for (BoulderItem item : mExampleListFull) {
                    if (item.getTf().toLowerCase().contains("t") || item.getTf().toLowerCase().contains("f")) {
                        filteredList.add(item);
                    }
                }
            }else if(constraint == "$projekt")
            {
                for(BoulderItem item : mExampleListFull)
                {
                    if(item.getTf().toLowerCase().contains("p"))
                    {
                        filteredList.add(item);
                    }
                }
            }else if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mExampleListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase();
                for (BoulderItem item : mExampleListFull) {
                    if (item.getName().toLowerCase().contains(filterPattern) || item.getLocation().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;


            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mExampleList.clear();
            mExampleList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}



