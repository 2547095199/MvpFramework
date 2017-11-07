package mvpframework.bwie.com.mvpframework;

import android.telecom.Call;

import java.io.IOException;
import java.util.HashMap;

import mvpframework.bwie.com.mvpframework.model.Imodel;
import mvpframework.bwie.com.mvpframework.okhtp.okhttp.okhttp.OkHttp3Utils;

/**
 * Created by CZ on 2017/11/7.
 */
public class usermodel implements Imodel {
    String result;

    @Override
    public String login(User user) {
        HashMap<String, String> map = new HashMap<>();
        map.put("mobile", user.getUsername());
        map.put("password", user.getPassword());
        OkHttp3Utils.getInstance().doPost(API.LOGIN, map, new GsonObjectCallback<UserBean>() {
            @Override
            public String onUi(UserBean userBean) {
                String code = userBean.getCode();
                if (code.equals("0")) {
                    result = "true";
                } else {
                    result = "fales";
                }
                return code;
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
        return result;
    }
}

