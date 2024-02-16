package com.example.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.export_download.DownloadServiceUtil;
import com.example.export_download.IDownloadService;

@Route(path = "/home/homeFragment")
public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView mTitle = view.findViewById(com.example.base.R.id.tv_title);
        mTitle.setText("Home Page");

        ImageView mBtnBack = view.findViewById(com.example.base.R.id.btn_back);
        mBtnBack.setVisibility(View.GONE);

        Button btnDownload = view.findViewById(R.id.btn_download);
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadServiceUtil.navigateDownloadPage();
            }
        });

        TextView tv1 = view.findViewById(R.id.tv1);
        IDownloadService downloadService = DownloadServiceUtil.getService();
        if(downloadService == null){
            tv1.setText("Weibo:0%");
        }else{
            tv1.setText("Weibo:" + downloadService.getDownloadProgress("weibo") + "%");
        }
    }

}
