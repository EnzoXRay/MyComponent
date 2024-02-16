package com.example.download;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.export_download.DownloadRouterTable;
import com.example.export_download.IDownloadService;

import java.util.HashMap;
import java.util.Map;

@Route(path = DownloadRouterTable.PATH_SERVICE_DOWNLOAD)
public class DownloadServiceImpl implements IDownloadService {

    @Override
    public int getDownloadProgress(String name) {
        Map<String, Integer>  progressMap = new HashMap<>();
        progressMap.put("tiktok", 47);
        progressMap.put("weibo", 89);
        return progressMap.get(name);
    }

    @Override
    public void init(Context context) {

    }
}
