package com.example.studentattendance;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProgrammingAdapter2 extends RecyclerView.Adapter<ProgrammingAdapter2.ProgrammingViewHolder> {

    private String[] data2;
    public ProgrammingAdapter2(String[] data)
    {
        this.data2 = data;
    }
    @NonNull
    @Override
    public ProgrammingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_layout2,parent,false);
        return new ProgrammingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgrammingViewHolder holder, int position) {
        String title = data2[position];
        holder.txtTitle2.setText(title);
    }

    @Override
    public int getItemCount() {
        return data2.length;
    }

    public class ProgrammingViewHolder extends RecyclerView.ViewHolder {
        ImageView imgIcon2;
        TextView txtTitle2;
        public ProgrammingViewHolder(@NonNull View itemView) {
            super(itemView);
            imgIcon2 = (ImageView) itemView.findViewById(R.id.imgIcon2);
            txtTitle2 = (TextView) itemView.findViewById(R.id.textTitle2);
        }
    }
}
