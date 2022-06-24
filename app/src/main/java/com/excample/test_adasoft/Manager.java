package com.excample.test_adasoft;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.List;
import java.util.Vector;

public class Manager extends SQLiteOpenHelper {
    public Manager(@Nullable Context context) {
        super(context, "AdasoftDB", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "Create Table IF NOT exists Student(Stuid Text primary key," +
                "StuFname Text,StuLanme Text ,stuTel Text,stuEmail Text )";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "Drop Table if exists Student";
        db.execSQL(sql);
        this.onCreate(db);
    }
    //เพิ่ม
    public boolean addSudent(Student s) {
        long result = -1;
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            System.out.println(s.getId());
            System.out.println(s.getFname());
            System.out.println(s.getLname());
            System.out.println(s.getTel());
            System.out.println(s.getEmail());
            values.put("Stuid", s.getId());
            values.put("StuFname", s.getFname());
            values.put("StuLanme", s.getLname());
            values.put("stuTel", s.getTel());
            values.put("stuEmail", s.getEmail());
            result = db.insert("Student", null, values);
            db.close();
        } catch (Exception e) {

        }
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    // แสดง
    public List<Student> geteSudent() {

//        List<Student> stu = new Vector<Student>();
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery("Select Stuid,StuFname,StuLanme,stuTel,stuEmail from Student", new String[]{});
//        if (cursor != null) {
//            cursor.moveToFirst();
//            Student stus = new Student(cursor.getString(0), cursor.getString(1), cursor.getString(2)
//                    , cursor.getString(3), cursor.getString(4));
//            stu.add(stus);
//        }
//        db.close();
//        return stu;
        List<Student> list = new Vector<Student>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select Stuid,StuFname,StuLanme,stuTel,stuEmail from Student ", new String[]{});
        if (cursor != null) {
            cursor.moveToFirst();
            do {
                Student stu = new Student(cursor.getString(0), cursor.getString(1), cursor.getString(2)
                        , cursor.getString(3), cursor.getString(4));
                list.add(stu);
            } while (cursor.moveToNext());
            db.close();
        }
        return list;

    }
    public List<Student> seachSudent(String keyword) {
        List<Student> list = new Vector<Student>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select Stuid,StuFname,StuLanme,stuTel,stuEmail from Student " +
                "Where StuFname Like ?", new String[]{keyword});
        if (cursor != null) {
            cursor.moveToFirst();
            do {
                Student stu = new Student(cursor.getString(0), cursor.getString(1), cursor.getString(2)
                        , cursor.getString(3), cursor.getString(4));
                list.add(stu);
            } while (cursor.moveToNext());
            db.close();
        }
        return list;
    }
    public boolean updateSudent(Student s) {
        long result = -1;
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("Stuid", s.getId());
            values.put("StuFname", s.getFname());
            values.put("StuLanme", s.getLname());
            values.put("stuTel", s.getTel());
            values.put("stuEmail", s.getEmail());
            result = db.update("Student", values, "Stuid=? ", new String[]{s.getId()});
            db.close();
        } catch (Exception e) {

        }
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean deleteStudent(String id) {
        long result = -1;
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            result = db.delete("Student", "Stuid=?  ", new String[]{id});
            db.close();
        } catch (Exception e) {

        }
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
}
