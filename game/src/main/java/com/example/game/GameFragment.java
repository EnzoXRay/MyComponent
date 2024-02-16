package com.example.game;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.export_download.DownloadServiceUtil;
import com.example.export_download.IDownloadService;

@Route(path = "/game/gameFragment")
public class GameFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView mTitle = view.findViewById(com.example.base.R.id.tv_title);
        mTitle.setText("Game Page");

        ImageView mBtnBack = view.findViewById(com.example.base.R.id.btn_back);
        mBtnBack.setVisibility(View.GONE);

        TextView tv1 = view.findViewById(R.id.tv1);

        try {
            IDownloadService downloadService = DownloadServiceUtil.getService();
            tv1.setText("Tiktok:" + downloadService.getDownloadProgress("tiktok") + "%");
        }catch (Exception e){
            tv1.setText("Tiktok:0%");
        }
    }

}
