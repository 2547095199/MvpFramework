package mvpframework.bwie.com.myapplication.model;

import java.util.HashMap;

import mvpframework.bwie.com.myapplication.okhttp.okhttp.OkHttp3Utils;
import okhttp3.Callback;

/**
 * Created by CZ on 2017/11/7.
 */
public class MyZhuCeModel implements ZhuCeModel {


    @Override
    public void getnetZhuCedata(String phone2, String mima2, Callback callback) {
        HashMap<String, String> map = new HashMap<>();
        map.put("mobile",phone2);
        map.put("password",mima2);
        OkHttp3Utils.doPost("http://120.27.23.105/user/reg",map,callback);
    }
}
