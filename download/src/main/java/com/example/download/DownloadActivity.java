package com.example.download;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.export_download.DownloadRouterTable;
import com.example.export_download.DownloadServiceUtil;
import com.example.export_download.IDownloadService;

import java.util.ArrayList;
import java.util.List;

@Route(path = DownloadRouterTable.PATH_PAGE_DOWNLOAD)
public class DownloadActivity extends AppCompatActivity {
    private List<DownloadItem> mList = new ArrayList<>();
    private DownloadListAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        TextView mTitle = findViewById(com.example.base.R.id.tv_title);
        mTitle.setText("Download Page");

        RecyclerView mRv = findViewById(R.id.rv);;
        mAdapter = new DownloadListAdapter(mList);
        mRv.setAdapter(mAdapter);

        init();
    }

    private void init(){
        IDownloadService downloadService  = DownloadServiceUtil.getService();
        DownloadItem item1 = new DownloadItem("tiktok", downloadService.getDownloadProgress("tiktok"));
        mList.add(item1);

        DownloadItem item2 = new DownloadItem("weibo", downloadService.getDownloadProgress("weibo"));
        mList.add(item2);

        mAdapter.notifyDataSetChanged();
    }
}
