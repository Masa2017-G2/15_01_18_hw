package com.sheygam.masa_g2_15_01_18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    private String currentUser;
    private EditText inputEmail, inputName, inputPhone, inputDesc;
    private Button saveBtn, logoutBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        currentUser = getIntent().getStringExtra("EMAIL");
        inputEmail = findViewById(R.id.input_email);
        inputName = findViewById(R.id.input_name);
        inputPhone = findViewById(R.id.input_phone);
        inputDesc = findViewById(R.id.input_desc);
        saveBtn = findViewById(R.id.save_btn);
        logoutBtn = findViewById(R.id. logout_btn);
        saveBtn.setOnClickListener(this);
        logoutBtn.setOnClickListener(this);
        loadProfile();

    }

    private void loadProfile() {
        String str = getSharedPreferences("PROFILES",MODE_PRIVATE)
                .getString(currentUser,null);
        if(str != null){
            Profile p = Profile.newInstance(str);
            inputName.setText(p.getName());
            inputEmail.setText(p.getEmail());
            inputPhone.setText(p.getPhone());
            inputDesc.setText(p.getDesc());
        }
    }

    private void saveProfile(){
        String name = inputName.getText().toString();
        String email = inputEmail.getText().toString();
        String phone = inputPhone.getText().toString();
        String desc = inputDesc.getText().toString();
        Profile p = new Profile(name,email,phone,desc);
        getSharedPreferences("PROFILES",MODE_PRIVATE)
                .edit()
                .putString(currentUser,p.toString())
                .commit();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.logout_btn){
            setResult(RESULT_OK);
            finish();
        }else if(v.getId() == R.id.save_btn){
            saveProfile();
        }
    }
}
