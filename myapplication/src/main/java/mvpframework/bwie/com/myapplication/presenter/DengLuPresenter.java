package mvpframework.bwie.com.myapplication.presenter;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;

import mvpframework.bwie.com.myapplication.activity.MainActivity;
import mvpframework.bwie.com.myapplication.model.MyDengLuModel;
import mvpframework.bwie.com.myapplication.okhttp.okhttp.OnUiCallback;
import mvpframework.bwie.com.myapplication.view.DengLuView;
import mvpframework.bwie.com.myapplication.zbean.DengLuBean;
import okhttp3.Call;

/**
 * Created by CZ on 2017/11/7.
 */
public class DengLuPresenter {
    DengLuView view;
    Context context;
    private final MyDengLuModel model;

    public DengLuPresenter(MainActivity view, Context context) {
        this.view = view;
        this.context = context;
        model = new MyDengLuModel();
    }
    public void login(String phone,String mima){
        model.getNetData(phone, mima, new OnUiCallback() {
            @Override
            public void onFailed(Call call, IOException e) {

            }

            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                DengLuBean bean = gson.fromJson(result, DengLuBean.class);
                view.showLogin(bean);
            }
        });
    }
    public void wadsd(){
        view = null;
    }
}
