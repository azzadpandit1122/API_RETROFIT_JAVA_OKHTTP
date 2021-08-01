package com.example.movieappusingrecyclerviewretrofit.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movieappusingrecyclerviewretrofit.Model_Class.data;
import com.example.movieappusingrecyclerviewretrofit.R;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    Context context;
    List<data> renametoDataList;

    public DataAdapter(Context context, List<data> renametoDataList) {
        this.context = context;
        this.renametoDataList = renametoDataList;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        holder.rowName.setText(renametoDataList.get(position).getFirst_name());
        holder.rowLastName.setText(renametoDataList.get(position).getLast_name());
        holder.rowEmail.setText(renametoDataList.get(position).getEmail());

        Glide.with(context)
                .load(renametoDataList.get(position).getAvatar())
                .into(holder.rowImage);

    }

    @Override
    public int getItemCount() {
        return renametoDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final Context context;
        ImageView rowImage;
        TextView rowName, rowLastName, rowEmail;

        public ViewHolder(View itemView) {
            super(itemView);
            rowImage = itemView.findViewById(R.id.imageView);
            rowName = itemView.findViewById(R.id.textView2);
            rowLastName = itemView.findViewById(R.id.textView3);
            rowEmail = itemView.findViewById(R.id.textView4);
            context = itemView.getContext();
        }
    }
}
