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
    List<data> dataList;

    public DataAdapter(Context context, List<data> dataList) {
        this.context = context;
        this.dataList = dataList;
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
        holder.rowId.setText(dataList.get(position).getId());
        holder.rowName.setText(dataList.get(position).getFirst_name());
        holder.rowLastName.setText(dataList.get(position).getLast_name());
        holder.rowEmail.setText(dataList.get(position).getEmail());

        Glide.with(context)
                .load(dataList.get(position).getAvatar())
                .into(holder.rowImage);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final Context context;
        ImageView rowImage;
        TextView rowName, rowLastName, rowId, rowEmail;

        public ViewHolder(View itemView) {
            super(itemView);
            rowId = itemView.findViewById(R.id.textView);
            rowImage = itemView.findViewById(R.id.imageView);
            rowName = itemView.findViewById(R.id.textView2);
            rowLastName = itemView.findViewById(R.id.textView3);
            rowEmail = itemView.findViewById(R.id.textView4);
            context = itemView.getContext();
        }
    }
}
