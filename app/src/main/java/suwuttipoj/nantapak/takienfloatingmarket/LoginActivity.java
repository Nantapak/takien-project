package suwuttipoj.nantapak.takienfloatingmarket;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class LoginActivity extends AppCompatActivity {

    //Explicit
    private EditText userEditText, passwordEditText;
    private String userString, passwordString;
    private static final String urlJSON = "http://swiftcodingthai.com/ton/get_data.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Bind Widget
        userEditText = (EditText) findViewById(R.id.editText12);
        passwordEditText = (EditText) findViewById(R.id.editText13);

    } //Main Method

    public void clickMyLogin(View view) {

        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        if (userString.equals("") || passwordString.equals("")) {

            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "Have Space",
                    "Please Fill All Every Blank");

        } else {

            SynMember synMember = new SynMember(this);
            synMember.execute(urlJSON);

        }



    }   //clickMyLogin

    private class SynMember extends AsyncTask<String, Void, String> {

        //Ecplicit
        private Context context;

        public SynMember(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(String... params) {

            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(params[0]).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();

            } catch (Exception e) {
                Log.d("2octV1", "e doInBack ==>" + e.toString());
                return null;
            }

        }   //doInBack

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("2octV1", "JSON ==>" + s);

        }   // onPost

    } // SynMember Class


    public void clickCancel(View view) {
        finish();
    }

    public void clickNewRegis(View view) {
        startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
    }

}     // Main Class
