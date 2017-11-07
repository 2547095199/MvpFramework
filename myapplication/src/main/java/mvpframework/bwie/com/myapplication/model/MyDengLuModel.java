package mvpframework.bwie.com.myapplication.model;

import java.util.HashMap;

import mvpframework.bwie.com.myapplication.okhttp.okhttp.OkHttp3Utils;

/**
 * Created by CZ on 2017/11/7.
 */
public class MyDengLuModel implements DengluModel {
    @Override
    public void getNetData(String phone, String mima, okhttp3.Callback callback) {
        HashMap<String, String> map = new HashMap<>();
        map.put("mobile",phone);
        map.put("password",mima);
        OkHttp3Utils.doPost("http://120.27.23.105/user/login",map,callback);
    }
}
