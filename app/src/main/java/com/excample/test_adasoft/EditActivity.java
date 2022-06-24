package com.excample.test_adasoft;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {
    private Manager mng ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        mng = new Manager(EditActivity.this);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String fname = intent.getStringExtra("fname");
        String lname = intent.getStringExtra("lname");
        String tel = intent.getStringExtra("tel");
        String email = intent.getStringExtra("email");

        System.out.println("Edit"+id);
        System.out.println("Edit"+fname);
        System.out.println("Edit"+lname);
        System.out.println("Edit"+tel);
        System.out.println("Edit"+email);

        TextView id1 = findViewById(R.id.resulteditid);
          id1.setText(id);
        EditText fname1 =findViewById(R.id.resultEditFname);
          fname1.setText(fname);
        EditText Lname1 =findViewById(R.id.resultEditLname);
          Lname1.setText(lname);
        EditText tel1 =findViewById(R.id.resulteditTel);
           tel1.setText(tel);
        EditText email1 =findViewById(R.id.resulteditEmail);
           email1.setText(email);
    }

    public void onCancelEdit(View view){
        Intent intent = new Intent(EditActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void updateData(View view){

        AlertDialog.Builder builder = new AlertDialog.Builder(EditActivity.this);
        builder.setTitle("Confirm Edit");
        builder.setMessage("Are you sure to Edit Data ");
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {

                    TextView id1 = findViewById(R.id.resulteditid);
                    String id11 = id1.getText().toString();
                    EditText fname1 =findViewById(R.id.resultEditFname);
                    String fname11 = fname1.getText().toString();
                    EditText Lname1 =findViewById(R.id.resultEditLname);
                    String Lname11 = Lname1.getText().toString();;
                    EditText tel1 =findViewById(R.id.resulteditTel);
                    String tel11 = tel1.getText().toString();
                    EditText email1 =findViewById(R.id.resulteditEmail);
                    String email11 = email1.getText().toString();

                    boolean res = mng.updateSudent(new Student(id11,fname11,Lname11,tel11,email11));
                        if (res == true) {
                            Toast.makeText(EditActivity.this, "Edit Success", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(EditActivity.this, MainActivity.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(EditActivity.this, "Edit Fail", Toast.LENGTH_LONG).show();
                        }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }
}