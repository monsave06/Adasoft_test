package com.excample.test_adasoft;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

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

import java.util.List;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    private Manager mng;
    private List<Student> stu =new Vector<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mng = new Manager(MainActivity.this);

          stu = mng.geteSudent();

        LinearLayout result = findViewById(R.id.ListStudentresult);
        result.removeAllViews();
        for(Student st : stu){
            CheckBox ts = new CheckBox(MainActivity.this);
            ts.setText("\n   ID : "+st.getId()+"\n"+
                       "   Name : "+st.getFname()+" "+st.getLname()+
                    "\n   Tel : "+st.getTel()+
                    "\n   Email : "+st.getEmail());
            result.addView(ts);
        }


    }
    protected void onResume() {
        super.onResume();
        this.refresh();
    }

    public void refresh (){
        stu = mng.geteSudent();
        LinearLayout result = findViewById(R.id.ListStudentresult);
        result.removeAllViews();
        for(Student st : stu){
            CheckBox ts = new CheckBox(MainActivity.this);
            ts.setText("\n   ID : "+st.getId()+"\n"+
                    "   Name : "+st.getFname()+" "+st.getLname()+
                    "\n   Tel : "+st.getTel()+
                    "\n   Email : "+st.getEmail());
            result.addView(ts);
        }
    }
    public void OncilckAdd(View view){
        Intent intent = new Intent(MainActivity.this, AddActivity.class);
        startActivity(intent);

    }
    public void OncilckSearch( View view){
        EditText et = findViewById(R.id.TextSearch);
        String Search1 = et.getText().toString();

        stu= mng.seachSudent(Search1+"%");
        LinearLayout results = findViewById(R.id.ListStudentresult);
        results.removeAllViews();
        for(Student st : stu){
//            TextView t = new TextView(this);
            CheckBox te = new CheckBox(MainActivity.this);
            te.setText("\n   ID : "+st.getId()+"\n"+
                    "   Name : "+st.getFname()+" "+st.getLname()+
                    "\n   Tel : "+st.getTel()+
                    "\n   Email : "+st.getEmail());
            results.addView(te);
        }
    }

    public void OnDeleteClick(View view) {
        LinearLayout result = findViewById(R.id.ListStudentresult);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Confirm Delete");
        builder.setMessage("Are you sure to delete ");
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                try {
                    for (int i = 0; i<result.getChildCount(); i++) {
                        CheckBox c = (CheckBox) result.getChildAt(i);
                        if (c.isChecked()) {
                            mng.deleteStudent(stu.get(i).getId());
                            Toast.makeText(MainActivity.this, "ลบข้อมูลสำเร็จ", Toast.LENGTH_LONG).show();
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                onResume();
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

   public void OncilckEdit(View v){
       LinearLayout result = findViewById(R.id.ListStudentresult);
                   for (int i = 0; i<result.getChildCount(); i++) {
                       CheckBox c = (CheckBox) result.getChildAt(i);
                       if (c.isChecked()) {
                           Intent intent = new Intent(MainActivity.this, EditActivity.class);
                           String idA =stu.get(i).getId();
                           String FnameA =stu.get(i).getFname();
                           String LnameA =stu.get(i).getLname();
                           String TelA =stu.get(i).getTel();
                           String EmailA =stu.get(i).getEmail();

                           intent.putExtra("id",idA);
                           intent.putExtra("fname",FnameA);
                           intent.putExtra("lname",LnameA);
                           intent.putExtra("tel",TelA);
                           intent.putExtra("email",EmailA);
                           startActivity(intent);
                           finish();

                       }
                   }
   }

}