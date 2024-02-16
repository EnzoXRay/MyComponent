package com.example.download;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DownloadListAdapter extends RecyclerView.Adapter<DownloadListAdapter.MyViewHolder> {

    private List<DownloadItem> mList;

    public DownloadListAdapter(List<DownloadItem> list){
        this.mList = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_download, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DownloadItem item = mList.get(position);
        holder.tvName.setText(item.getName());
        holder.pb.setProgress(item.getProgress());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class  MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tvName;

        private ProgressBar pb;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            pb = itemView.findViewById(R.id.pb);
        }
    }
}
