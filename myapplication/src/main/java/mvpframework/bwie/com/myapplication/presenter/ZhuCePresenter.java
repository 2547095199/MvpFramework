package mvpframework.bwie.com.myapplication.presenter;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;

import mvpframework.bwie.com.myapplication.model.MyZhuCeModel;
import mvpframework.bwie.com.myapplication.okhttp.okhttp.OnUiCallback;
import mvpframework.bwie.com.myapplication.view.ZhuCeView;
import mvpframework.bwie.com.myapplication.zbean.ZhuCeBean;
import okhttp3.Call;

/**
 * Created by CZ on 2017/11/7.
 */
public class ZhuCePresenter {
    Context context;
    ZhuCeView view;
     MyZhuCeModel model;

    public ZhuCePresenter(Context context, ZhuCeView view) {
        this.context = context;
        this.view = view;
        model = new MyZhuCeModel();
    }
    public void clickzhuce(String phone2, String mima2){
        model.getnetZhuCedata(phone2, mima2, new OnUiCallback() {
            @Override
            public void onFailed(Call call, IOException e) {

            }

            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                ZhuCeBean bean = gson.fromJson(result, ZhuCeBean.class);
                view.ZhuCeview(bean);
            }
        });

    }
    public void wadss(){

        view=null;
    }
}
