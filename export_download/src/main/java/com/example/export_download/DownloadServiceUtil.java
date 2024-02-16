package com.example.export_download;

import com.alibaba.android.arouter.launcher.ARouter;

public class DownloadServiceUtil {

    public static void navigateDownloadPage(){
        ARouter.getInstance()
                .build(DownloadRouterTable.PATH_PAGE_DOWNLOAD)
                .navigation();
    }

    public static IDownloadService getService(){
        return (IDownloadService) ARouter.getInstance().build(DownloadRouterTable.PATH_SERVICE_DOWNLOAD).navigation();
    }

    public static int getDownloadProgress(String name){
        return getService().getDownloadProgress(name);
    }


}
