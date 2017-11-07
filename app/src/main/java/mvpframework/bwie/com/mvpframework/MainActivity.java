package mvpframework.bwie.com.mvpframework;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements Iview, View.OnClickListener {
    private UserPresenter userPresenter;
    private EditText etUserName;
    private EditText etPassword;
    private ProgressDialog loginProgreess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUserName = (EditText) findViewById(R.id.username);
        etPassword = (EditText) findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(this);
        userPresenter = new UserPresenter(this);

    }

    @Override
    public void onLoginSuccess() {
        loginProgreess.dismiss();
        Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFailed(String error) {
        loginProgreess.dismiss();
        Toast.makeText(MainActivity.this, "====", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        String username = etUserName.getText().toString().trim();
        String password = etPassword.getText().toString().trim();


        loginProgreess = ProgressDialog.show(this, "登录", "正在登录...");
        userPresenter.Login(new User(password, username));
    }
}

