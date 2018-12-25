package com.pku.ss.zhangfan.papertest;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;




public class Login extends Activity implements View.OnClickListener{

    private EditText inputUsername;
    private EditText inputPassword;
    private ProgressDialog waitDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);
        inputUsername = (EditText) findViewById(R.id.username);
        inputPassword = (EditText) findViewById(R.id.password);
        Button loginBtn = (Button) findViewById(R.id.loginb);
        TextView register = (TextView) findViewById(R.id.register);

        loginBtn.setOnClickListener(this);
        register.setOnClickListener(this);
//
//        Account account = OperateShareprefrence.loadShareprefrence(this);
//        if(account!=null){
//            inputUsername.setText(account.getAccount());
//            inputPassword.setText(account.getPassword());
//        }
    }

    private boolean prepareForLogin() {
//        if (((ConnectivityManager) getApplicationContext().getSystemService(CONNECTIVITY_SERVICE)).getActiveNetworkInfo() == null) {
//            Toast.makeText(this, "网络异常", Toast.LENGTH_SHORT).show();
//            return true;
//        }

//        if (inputUsername.length() == 0) {
//            inputUsername.setError("请输入账号");
//            inputUsername.requestFocus();
//            return true;
//        }
//
//        if (inputPassword.length() == 0) {
//            inputPassword.setError("请输入密码");
//            inputPassword.requestFocus();
//            return true;
//        }

        return false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loginb:
                //if (prepareForLogin()) {
                //    return;
                //}
                // if the data has ready
                //final String username = inputUsername.getText().toString();
                //final String password = inputPassword.getText().toString();
                waitDialog = new ProgressDialog(this);
                waitDialog.setMessage("登录中");
                waitDialog.setCancelable(false);
                waitDialog.show();
                startActivity(new Intent(Login.this, SelectActivity.class));

                break;
            case R.id.register:
             //   startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
        }
    }

}
