package com.example.export_download;

import com.alibaba.android.arouter.facade.template.IProvider;

public interface IDownloadService extends IProvider {
    int getDownloadProgress(String name);
}
