package mvpframework.bwie.com.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import mvpframework.bwie.com.myapplication.R;
import mvpframework.bwie.com.myapplication.presenter.ZhuCePresenter;
import mvpframework.bwie.com.myapplication.view.ZhuCeView;
import mvpframework.bwie.com.myapplication.zbean.ZhuCeBean;

public class ZhuCeActivity extends AppCompatActivity implements ZhuCeView{

    private TextView fanhui;
    private EditText phone2;
    private EditText mima2;
    private Button zhuce2;
    private ZhuCePresenter presenter = new ZhuCePresenter(this,this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_ce);

        fanhui = (TextView) findViewById(R.id.fanhui);
        phone2 = (EditText) findViewById(R.id.phone2);
        mima2 = (EditText) findViewById(R.id.mima2);
        zhuce2 = (Button) findViewById(R.id.zhuce2);

        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        zhuce2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ZhuCeActivity.this,phone2.getText().toString()+mima2.getText().toString(),Toast.LENGTH_SHORT).show();
                presenter.clickzhuce(phone2.getText().toString(),mima2.getText().toString());
            }
        });



    }
    @Override
    public void ZhuCeview(ZhuCeBean bean) {
        Toast.makeText(ZhuCeActivity.this,bean.getMsg(),Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.wadss();
    }
}
