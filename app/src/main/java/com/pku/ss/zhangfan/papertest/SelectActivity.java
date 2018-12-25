package com.pku.ss.zhangfan.papertest;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

//import com.orhanobut.logger.Logger;
import com.pku.ss.zhangfan.papertest.R;
//import com.pku.ss.zhangfan.papertest.SystemTestSystem;
//import com.pku.ss.zhangfan.papertest.Util.Action;
//import com.pku.ss.zhangfan.papertest.Utils.BmobUtils;
//import com.pku.ss.zhangfan.papertest.Util.OperateSQLite;
//import com.pku.ss.zhangfan.papertest.adapter.PaperListAdapter;
//import com.pku.ss.zhangfan.papertest.beans.Grade;
//import com.pku.ss.zhangfan.papertest.beans.Paper;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class SelectActivity extends Activity implements View.OnClickListener{

    private ListView paperList;
    //private List<Paper> papers = new ArrayList<Paper>();
    //private PaperListAdapter adapter;
    //private OperateSQLite operateSQLite;
    private String[] data={"物理","化学","数学"};
    private Button gototest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_activity);
        //EventBus.getDefault().register(this);


        paperList = (ListView) findViewById(R.id.lv_paper);

        ArrayAdapter<String>adapter=new ArrayAdapter<String>(SelectActivity.this,android.R.layout.simple_list_item_1,data);
        paperList.setAdapter(adapter);

        gototest = (Button) findViewById(R.id.gototest);
        gototest.setOnClickListener(this);


    }




    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.gototest:
                Intent i1 = new Intent(SelectActivity.this, com.pku.ss.zhangfan.papertest.MainActivity.class);
                startActivity(i1);
                break;
        }
    }




}
