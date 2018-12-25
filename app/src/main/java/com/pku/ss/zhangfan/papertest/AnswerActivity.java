package com.pku.ss.zhangfan.papertest;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.json.JSONArray;

public class AnswerActivity extends Activity implements View.OnClickListener {
    ImageView imgBack;
    TextView tv_title;
    TextView tv_content;
    TextView tv_next;
    TextView tv_last;
    RadioButton rb_a;
    RadioButton rb_b;
    RadioButton rb_c;
    RadioButton rb_d;
    RadioGroup rg_select_answer;

    private ArrayList<DataAnswer> dataList = new ArrayList<>();
    private int selectPostion = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        initData();
        initView();
        setData();
    }


    private void initView() {
        imgBack = (ImageView) this.findViewById(R.id.img_back);
        tv_title = (TextView) this.findViewById(R.id.tv_title);
        tv_content = (TextView) this.findViewById(R.id.tv_content);
        tv_last = (TextView) this.findViewById(R.id.tv_last);
        tv_next = (TextView) this.findViewById(R.id.tv_next);
        rg_select_answer = (RadioGroup) this.findViewById(R.id.rg_select_answer);
        rb_a = (RadioButton) this.findViewById(R.id.rb_a);
        rb_b = (RadioButton) this.findViewById(R.id.rb_b);
        rb_c = (RadioButton) this.findViewById(R.id.rb_c);
        rb_d = (RadioButton) this.findViewById(R.id.rb_d);
        tv_last.setOnClickListener(this);
        tv_next.setOnClickListener(this);
        imgBack.setOnClickListener(this);
    }


    private void initData() {
        String question = "[ { \"que\":\"正弦函数的取值范围是\", \"ans\":4, \"A\":\"(-1,1)\", \"B\":\"(-1,1]\", \"C\":\"[-1,1)\", \"D\":\"[-1,1]\" } , { \"que\":\"三角形的内角和是多少度？\", \"ans\":2, \"A\":\"90\", \"B\":\"180\", \"C\":\"270\", \"D\":\"360\" } , { \"que\":\"下列不是质数的有\", \"ans\":3, \"A\":\"2\", \"B\":\"17\", \"C\":\"27\", \"D\":\"37\" } , { \"que\":\"一元二次方程最多有几个解？\", \"ans\":2, \"A\":\"1\", \"B\":\"2\", \"C\":\"3\", \"D\":\"4\" } , { \"que\":\"以下说法正确的是\", \"ans\":1, \"A\":\"矩形一定是平行四边形\", \"B\":\"平行四边形一定是矩形\", \"C\":\"矩形一定是菱形\", \"D\":\"菱形一定是矩形\" } , { \"que\":\"以下不能判断全等三角形的是\", \"ans\":4, \"A\":\"SAS\", \"B\":\"AAS\", \"C\":\"ASA\", \"D\":\"SSA\" } , { \"que\":\"下列不存在的正多面体是\", \"ans\":4, \"A\":\"正四面体\", \"B\":\"正八面体\", \"C\":\"正十二面体\", \"D\":\"正十六面体\" } , { \"que\":\"180度的角是\", \"ans\":3, \"A\":\"直角\", \"B\":\"钝角\", \"C\":\"平角\", \"D\":\"周角\" } , { \"que\":\"正十二边形的外角和是多少度？\", \"ans\":4, \"A\":\"30\", \"B\":\"90\", \"C\":\"180\", \"D\":\"360\" } , { \"que\":\"关于正多边形以下说法正确的是\", \"ans\":3, \"A\":\"边长相等的多边形一定是正多边形\", \"B\":\"角相等的多边形一定是正多边形\", \"C\":\"边长和角均相等的多边形一定是正多边形\", \"D\":\"边长和角均相等的多边形不一定是正多边形\" } ]";
        try {
            JSONArray jsonArray = new JSONArray(question);
            for (int i = 0; i < jsonArray.length(); i++) {
                //循环遍历，依次取出JSONObject对象
                //用getInt和getString方法取出对应键值
                try {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String que = jsonObject.getString("que");
                    int ans = jsonObject.getInt("ans");
                    String sA = jsonObject.getString("A");
                    String sB = jsonObject.getString("B");
                    String sC = jsonObject.getString("C");
                    String sD = jsonObject.getString("D");

                    dataList.add(new DataAnswer(que, sA, sB, sC, sD, ans));
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        /*
        dataList.add(new DataAnswer("三角形有几个角",
                "1", "2", "3", "4", 3));
        */
    }

    private void setData() {
        tv_title.setText("第" + Utils.toHanzi(selectPostion + 1 + "") + "题");
        tv_content.setText(dataList.get(selectPostion).getName());
        rb_a.setText("A:  "+dataList.get(selectPostion).getSelect_a());
        rb_b.setText("B:  "+dataList.get(selectPostion).getSelect_b());
        rb_c.setText("C:  "+dataList.get(selectPostion).getSelect_c());
        rb_d.setText("D:  "+dataList.get(selectPostion).getSelect_d());
        rg_select_answer.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_a:
                        dataList.get(selectPostion).setIs_select_postion(1);
                        break;
                    case R.id.rb_b:
                        dataList.get(selectPostion).setIs_select_postion(2);
                        break;
                    case R.id.rb_c:
                        dataList.get(selectPostion).setIs_select_postion(3);
                        break;
                    case R.id.rb_d:
                        dataList.get(selectPostion).setIs_select_postion(4);
                        break;
                    default:
                        break;
                }
            }
        });
        if (dataList.get(selectPostion).getIs_select_postion() != 0) {
            switch (dataList.get(selectPostion).getIs_select_postion()) {
                case 1:
                    rb_a.setChecked(true);
                    break;
                case 2:
                    rb_b.setChecked(true);
                    break;
                case 3:
                    rb_c.setChecked(true);
                    break;
                case 4:
                    rb_d.setChecked(true);
                    break;
                default:
                    break;
            }
        }else {
            rg_select_answer.clearCheck();
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_next:
                if (selectPostion == 9) {
                    new DialogUtils(AnswerActivity.this, R.layout.view_dialog) {
                        @Override
                        public void initLayout(ViewHelper helper, final Dialog dialog) {
                            helper.setViewClick(R.id.tv_cancel, new ViewHelper.ViewClickCallBack() {
                                @Override
                                public void doClickAction(View v) {
                                    dialog.dismiss();
                                }
                            });
                            helper.setViewClick(R.id.tv_ok, new ViewHelper.ViewClickCallBack() {
                                @Override
                                public void doClickAction(View v) {
                                    dialog.dismiss();
                                    Intent intent = new Intent();
                                    intent.putParcelableArrayListExtra("result", dataList);
                                    setResult(1002, intent);
                                    finish();
                                }
                            });
                        }
                    };
                    return;
                }
                selectPostion++;
                setData();
                break;
            case R.id.tv_last:
                if (selectPostion == 0) {
                    Toast.makeText(AnswerActivity.this, "这是第一题", Toast.LENGTH_SHORT).show();
                    return;
                }
                selectPostion--;
                setData();
                break;
            case R.id.img_back:
                finish();
                break;
        }
    }
}
