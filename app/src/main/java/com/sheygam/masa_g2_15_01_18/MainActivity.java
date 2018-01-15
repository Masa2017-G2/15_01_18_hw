package com.sheygam.masa_g2_15_01_18;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button loginBtn;
    private EditText inputEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String email = isAuth();
        if(email!=null){
            startNextActivity(email);
        }

        loginBtn = findViewById(R.id.login_btn);
        inputEmail = findViewById(R.id.input_email);
        loginBtn.setOnClickListener(this);
    }

    private String isAuth(){
//        boolean res = false;
//        String currentUser = getSharedPreferences("AUTH",MODE_PRIVATE)
//                .getString("CURRENT_USER",null);
//        if (currentUser!= null){
//            res = true;
//        }
//        return res;
        return getSharedPreferences("AUTH",MODE_PRIVATE)
                .getString("CURRENT_USER", null);
    }

    private void saveCurrentUser(String email){
        getSharedPreferences("AUTH",MODE_PRIVATE)
                .edit()
                .putString("CURRENT_USER",email)
                .commit();
    }

    private void startNextActivity(String email){

        Intent intent = new Intent(this,ProfileActivity.class);
        intent.putExtra("EMAIL", email);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            getSharedPreferences("AUTH",MODE_PRIVATE)
                    .edit()
                    .remove("CURRENT_USER")
                    .commit();
        }else{
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.login_btn){
            String user = inputEmail.getText().toString();
            saveCurrentUser(user);
            startNextActivity(user);
        }
    }
}
