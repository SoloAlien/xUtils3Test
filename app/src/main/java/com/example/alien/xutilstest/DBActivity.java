package com.example.alien.xutilstest;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.xutils.DbManager;
import org.xutils.db.sqlite.SqlInfo;
import org.xutils.db.table.DbModel;
import org.xutils.ex.DbException;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

public class DBActivity extends AppCompatActivity {
    private DbManager db;
    private MyApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        x.view().inject(this);
        application = new MyApplication();
        db = x.getDb(application.getDaoConfig());//拿到DbManager对象
    }

    @Event({R.id.btn_add, R.id.btn_query})
    private void option(View view) {
        switch (view.getId()) {
            //添加操作
            case R.id.btn_add:
                Student stu1 = new Student();
                stu1.setName("张三");
                stu1.setSex("男");
                Student stu2 = new Student();
                stu2.setName("李四");
                stu2.setSex("女");
                try {
                    db.saveOrUpdate(stu1);
                    db.save(stu2);
                    Toast.makeText(DBActivity.this, "添加了数据", Toast.LENGTH_SHORT).show();
                } catch (DbException e) {
                    e.printStackTrace();
                }
                break;
            //查询操作
            case R.id.btn_query:
                try {
                    Student stu = db.findFirst(Student.class);
                    Log.e("TAG", "option: " + stu.getName() + "\t" + stu.getSex());
                    Student student = db.findById(Student.class, 2);
                    Log.e("TAG", "option: " + student.getName() + "\t" + student.getSex());
                    List<Student> all = db.findAll(Student.class);
                    Log.e("TAG", "option: " + all.get(0).getName() + "\t" + all.get(1).getName());
                } catch (DbException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
