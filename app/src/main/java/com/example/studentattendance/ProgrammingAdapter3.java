
package com.example.studentattendance;

        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

public class ProgrammingAdapter3 extends RecyclerView.Adapter<ProgrammingAdapter3.ProgrammingViewHolder> {

    private String[] data3;
    public ProgrammingAdapter3(String[] data)
    {
        this.data3 = data;
    }
    @NonNull
    @Override
    public ProgrammingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_layout3,parent,false);
        return new ProgrammingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgrammingViewHolder holder, int position) {
        String title = data3[position];
        holder.txtTitle3.setText(title);
    }

    @Override
    public int getItemCount() {
        return data3.length;
    }

    public class ProgrammingViewHolder extends RecyclerView.ViewHolder {
        ImageView imgIcon3;
        TextView txtTitle3;
        public ProgrammingViewHolder(@NonNull View itemView) {
            super(itemView);
            imgIcon3 = (ImageView) itemView.findViewById(R.id.imgIcon3);
            txtTitle3 = (TextView) itemView.findViewById(R.id.textTitle3);
        }
    }
}
