package com.udacity.jwdnd.course1.cloudstorage.model;

import org.springframework.stereotype.Service;


@Service
public class File {

    private Integer fileId;
    private String fileName;
    private String contentType;
    private long fileSize;
    private Integer userId;
    private byte[] fileData;

    public File() {

    }

    public File(Integer fileId, String fileName, String contentType, long fileSize, Integer userId, byte[] fileData) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.contentType = contentType;
        this.fileSize = fileSize;
        this.userId = userId;
        this.fileData = fileData;
    }

    public File(String fileName, String contentType, long fileSize, Integer userId, byte[] fileData) {
        this.fileName = fileName;
        this.contentType = contentType;
        this.fileSize = fileSize;
        this.userId = userId;
        this.fileData = fileData;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }


    public String getContentType() {
        return contentType;
    }


    public byte[] getFileData() {
        return fileData;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
