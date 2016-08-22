package com.example.administrator.mydialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView_show);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //根据布局文件，创建菜单；追加到menu上去
        getMenuInflater().inflate(R.menu.main_opt_menu, menu);


        return super.onCreateOptionsMenu(menu);
    }

    /**
     * 菜单项--点击事件处理
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_new:
                showNewDialog();//显示“新建菜单”
                break;
            case R.id.action_edit:

                break;
            default:break;
        }

        return super.onOptionsItemSelected(item);
    }

    String[] jobs ={"研发","运营","产品","商务",""};
    boolean[] checkItems = {false,false,true,false};

    private void showNewDialog() {

        new AlertDialog.Builder(this).setTitle("默认对话框")
//                .setMessage("Dialog里显示的消息")
                .setCancelable(false)
                .setPositiveButton("确定", null)
                .setNegativeButton("取消", null)
                .setNeutralButton("更多", null)

//                .setItems(jobs,     //不需要确定按钮，选中自动确认
//                        new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                String job = jobs[which];
//                                textView.setText(job);
//                            }
//                        })


                        //单选对话框，需要确定取消按钮
//                .setSingleChoiceItems(jobs
//                        , -1,
//                        new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//
//                            }
//                        })


                //多选对话框，需要确定取消按钮
                .setMultiChoiceItems(R.array.city,
                        checkItems,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            /**
                             * 多选菜单项--点击
                             * @param dialog    事件源
                             * @param which     点击的一项
                             * @param isChecked 是否被选中
                             */
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                checkItems[which] = isChecked;
                            }
                        })

                .create().show();
    }
}
