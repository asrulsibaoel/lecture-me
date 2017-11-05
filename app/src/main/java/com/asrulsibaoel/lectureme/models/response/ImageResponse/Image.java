
package com.asrulsibaoel.lectureme.models.response.ImageResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("users_id")
    @Expose
    private Integer usersId;
    @SerializedName("filename")
    @Expose
    private String filename;
    @SerializedName("filetype")
    @Expose
    private String filetype;
    @SerializedName("filesize")
    @Expose
    private Integer filesize;
    @SerializedName("url_cloud")
    @Expose
    private String urlCloud;

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public Integer getFilesize() {
        return filesize;
    }

    public void setFilesize(Integer filesize) {
        this.filesize = filesize;
    }

    public String getUrlCloud() {
        return urlCloud;
    }

    public void setUrlCloud(String urlCloud) {
        this.urlCloud = urlCloud;
    }

}
