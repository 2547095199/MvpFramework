package mvpframework.bwie.com.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mvpframework.bwie.com.myapplication.R;
import mvpframework.bwie.com.myapplication.presenter.DengLuPresenter;
import mvpframework.bwie.com.myapplication.view.DengLuView;
import mvpframework.bwie.com.myapplication.zbean.DengLuBean;

public class MainActivity extends AppCompatActivity implements DengLuView {

    private EditText phone;
    private EditText mima;
    private Button denglu;
    private Button zhuce;
     DengLuPresenter presenter = new DengLuPresenter(this,this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone = (EditText) findViewById(R.id.phone);
        mima = (EditText) findViewById(R.id.mima);
        denglu = (Button) findViewById(R.id.denglu);
        zhuce = (Button) findViewById(R.id.zhuce);


        denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.login(phone.getText().toString(),mima.getText().toString());
            }
        });
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ZhuCeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showLogin(DengLuBean bean) {
        Toast.makeText(MainActivity.this,bean.getMsg(),Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.wadsd();
    }
}
