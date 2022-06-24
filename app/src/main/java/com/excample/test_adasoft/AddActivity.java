package com.excample.test_adasoft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    private Manager mng ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mng = new Manager(AddActivity.this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

    }
    public void onaddApply(View view){
        EditText Ids = findViewById(R.id.resultid);
        String id = Ids.getText().toString();
        EditText Fnames = findViewById(R.id.resultEditFname);
        String fanme = Fnames.getText().toString();
        EditText Lnames = findViewById(R.id.resultEditLname);
        String lname = Lnames.getText().toString();
        EditText Tels = findViewById(R.id.resulteditTel);
        String tel = Tels.getText().toString();
        EditText Emails = findViewById(R.id.resulteditEmail);
        String email = Emails.getText().toString();

        mng.addSudent(new Student(id,fanme,lname,tel,email));
        Intent intent = new Intent(AddActivity.this, MainActivity.class);
        startActivity(intent);

    }
    public void onCancel(View view){
        Intent intent = new Intent(AddActivity.this, MainActivity.class);
        startActivity(intent);
    }
}