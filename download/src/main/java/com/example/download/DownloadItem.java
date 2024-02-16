package com.example.download;

public class DownloadItem {
    private String name;
    private int progress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public DownloadItem(String name, int progress) {
        this.name = name;
        this.progress = progress;
    }
}
