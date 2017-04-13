package com.app.vdlasov.tinkoffschool.ui;

import com.app.vdlasov.tinkoffschool.R;
import com.app.vdlasov.tinkoffschool.ui.widgets.ProgressButton;
import com.app.vdlasov.tinkoffschool.utils.Credentials;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText login;

    private EditText password;

    //private Button button;
    private ProgressButton button;

    private LoginTask loginTask = new LoginTask();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // If user already login, navigate to the next page
        if (Credentials.isUserLogin(LoginActivity.this)) {
            startNextScreen();
        }

        login = (EditText) findViewById(R.id.edit_text_login);
        password = (EditText) findViewById(R.id.edit_text_password);
        //button = (Button) findViewById(R.id.btn_enter);
        button = (ProgressButton) findViewById(R.id.btn_enter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginTask.execute();
                //startNextScreen();
            }
        });
    }

    private void startNextScreen() {
        // Save user email and pass
        Credentials.loginUser(LoginActivity.this, login.getText().toString(), password.getText().toString());
        Intent intent = new Intent(this, NavigationActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        //Intent intent = new Intent(this, MainActivity.class);
        //intent.putExtra("LOGIN", login.getText().toString());
        startActivity(intent);
    }

    public static void logoutAndNavigateToLoginActivity(Activity context) {
        Credentials.logoutUser(context);
        Intent intent = new Intent(context, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
        context.finish();
    }

    private class LoginTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            button.showProgress();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            button.hideProgress();
            startNextScreen();
        }
    }
}

