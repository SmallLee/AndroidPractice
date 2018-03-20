package practice.lxn.cn.androidpractice.pojo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 *
 */

public class Response implements Serializable {
    public String name;
    public String url;
    public String page;
    @SerializedName("isNonProfit")
    private boolean np;
    public boolean flag;

    public boolean isNp(){
        return np;
    }
}
