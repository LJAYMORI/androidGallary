package com.ljaymori.photogallary.main.video;

public class VideoItemData {

    private String filePath;
    private String fileName;
    private String fileType;
    private String fileThumbnail;
    private String takenDate;
    private float fileSize;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileThumbnail() {
        return fileThumbnail;
    }

    public void setFileThumbnail(String fileThumbnail) {
        this.fileThumbnail = fileThumbnail;
    }

    public String getTakenDate() {
        return takenDate;
    }

    public void setTakenDate(String takenDate) {
        this.takenDate = takenDate;
    }

    public float getFileSize() {
        return fileSize;
    }

    public void setFileSize(float fileSize) {
        this.fileSize = fileSize;
    }
}
