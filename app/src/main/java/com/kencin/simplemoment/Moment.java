package com.kencin.simplemoment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class Moment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moment);
        ListView listView1;
        listView1 = (ListView) findViewById(R.id.listView1);
        String[] strings = {"img","title","info","time"};//Map的key集合数组
        int[] ids = {R.id.img,R.id.title,R.id.info,R.id.time};//对应布局文件的id
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                getData(), R.layout.listlayout, strings, ids);
        listView1.setAdapter(simpleAdapter);//绑定适配器
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Moment.this,"你单击的是第"+(position+1)+"条数据",Toast.LENGTH_SHORT).show();
            }
        });


        Button fresh=findViewById(R.id.fresh);
        fresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "没啥用的东西",
                        Toast.LENGTH_SHORT).show();
            }
        });
        Button n1=findViewById(R.id.n1);
        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
                HashMap<String, Object> map = null;
                map = new HashMap<String, Object>();
                map.put("title", "Test" );
                map.put("time", "4月13日");
                map.put("info", "你好吗？天气好吗？");
                map.put("img", R.drawable.a1);
                list.add(map);
            }
        });
    }




    private List<HashMap<String, Object>> getData() {
        // 新建一个集合类，用于存放多条数据
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map = null;
        for (int i = 1; i <= 40; i++) {
            map = new HashMap<String, Object>();
            map.put("title", "路人甲" + i);
            map.put("time", "4月13日");
            map.put("info", "你好吗？天气好吗？");
            map.put("img", R.drawable.a1);
            list.add(map);
        }
        return list;
    }
}
