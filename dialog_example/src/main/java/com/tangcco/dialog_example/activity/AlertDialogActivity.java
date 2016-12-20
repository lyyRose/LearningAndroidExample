package com.tangcco.dialog_example.activity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tangcco.dialog_example.R;


/**
 * 对话框
 */
public class AlertDialogActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btnNormalDilalog;
    private Button btnListDialog;
    private Button btnSingleChoiceDialog;
    private Button btnMultiChoiceDialog;
    private Button btnCustomViewDialog;
    private Button btnCancelAndDismissListener;

    /**
     * 对话框按钮点击事件
     */
    private DialogInterface.OnClickListener dialogButtonClickListener = new DialogInterface.OnClickListener() {
        /**
         * @param dialog
         * @param which    BUTTON_POSITIVE = -1   BUTTON_NEGATIVE = -2  BUTTON_NEUTRAL = -3  **
         */

        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_NEUTRAL:
                    toastMsg("点击了 Neutral Button");
                    dialog.dismiss();//关闭对话框
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    toastMsg("点击了 Netral Button");
                    //取消对话框 , 对话框同样会关闭。会先触发 OnCancelListener 然后再触发 OnDismissListener
                    dialog.cancel();
                    break;
                case DialogInterface.BUTTON_POSITIVE:
                    toastMsg("点击了 Positive Button");
                    dialog.dismiss();//关闭对话框
                    break;
            }


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        initView();
    }

    /**
     * @param view
     */
    @Override
    public void onClick(View view) {

        AlertDialog.Builder builder = getCommonBuilder();

        String[] listDataArr = {"选项1", "选项2", "选项3", "选项4", "选项5"};

        switch (view.getId()) {
            case R.id.btn_dialog_normal_dialog:
                //设置对话框显示的信息
                builder.setMessage("对话框要显示的信息");

                AlertDialog dialog = builder.create();
                //调用 AlertDialog 的show()方法 对话框才会显示
                dialog.show();
                break;

            case R.id.btn_dialog_list_dialog:

                //参数1 String[] 设置列表显示的Item 数据 , 参数2 每个item点击时的监听事件
                builder.setItems(listDataArr, new DialogInterface.OnClickListener() {
                    /**
                     * @param dialogInterface
                     * @param index 选择ITEM的index
                     */
                    @Override
                    public void onClick(DialogInterface dialogInterface, int index) {
                        // AlertDialog 将列表数据 通过内部的ListView显示出来
                        // 同过 getListView().getAdapter().getItem(index) 可以去出 当前的内容
                        // 单选多选时 同理
                        String clickItemContent = (String) ((AlertDialog) dialogInterface).getListView().getAdapter().getItem(index);

                        toastMsg("你选择了第 " + index + "条数据 \n Item的内容是 +" + clickItemContent);
                    }
                });

                builder.create().show();
                break;

            case R.id.btn_dialog_single_choice_dialog:

                //参数1、3  参见上方↑; 参数2 默认选中的Item index
                builder.setSingleChoiceItems(listDataArr, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int index) {
                        // 参见上方↑
                        String clickItemContent = (String) ((AlertDialog) dialog).getListView().getAdapter().getItem(index);

                        toastMsg("你选择了第 " + index + "条数据 \n Item的内容是 +" + clickItemContent);
                    }
                });

                builder.create().show();
                ;
                break;

            case R.id.btn_dialog_multi_choice_dialog:

                //设置每一个Item的默认选中状态   ** 元素的个数 必须跟 listDataArr 中元素个数一致 不然会报错
                boolean[] checkedItems = {false, true, true, false, false};

                builder.setMultiChoiceItems(listDataArr, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    /**
                     * @param dialogInterface
                     * @param index 点击Item的index
                     * @param isChecked 点击后的选中状态
                     */
                    @Override
                    public void onClick(DialogInterface dialogInterface, int index, boolean isChecked) {
                        toastMsg("index = " + index + "; checked " + isChecked);
                    }
                });

                builder.create().show();
                break;
            case R.id.btn_dialog_custom_view_dialog:

                //加载自定义View
                View customLoginView = getLayoutInflater().inflate(R.layout.dialog_login,null);
                //找到customLoginView中的控件
                final EditText etUsername = (EditText) customLoginView.findViewById(R.id.et_dialog_login_username);
                final EditText etPassword = (EditText) customLoginView.findViewById(R.id.et_dialog_login_password);
                Button btnLogin = (Button) customLoginView.findViewById(R.id.btn_dialog_login);

                //使用setView()方法设置自定义View
                AlertDialog.Builder customViewBuilder = new AlertDialog.Builder(this);
                customViewBuilder.setView(customLoginView);

                final AlertDialog loginDialog = customViewBuilder.create();
                loginDialog.show();

                btnLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        toastMsg("do login\n username = " + etUsername.getText().toString() + "\n passowrd = " + etPassword.getText().toString());
                        loginDialog.dismiss();
                    }
                });

                break;

            case R.id.btn_dialog_cancelable_dismiss_listener:
                builder.setMessage("cancleable设置为false back键和点击对话框以外的部分 对话框不会消失,需要主动使用对话框的dismiss()方法  ");
                //对话框消失监听
                builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                       toastMsg("Dialog dismiss");
                    }
                });
                //
                builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        toastMsg("Dialog Canceled");
                    }
                });
                //设置是是否可以取消
                builder.setCancelable(false);
                builder.create().show();
                break;



        }

    }

    /**
     * 获得一个通用的Builder
     * 设置了 标题  Icon 和3个Button
     *
     * @return
     */
    private AlertDialog.Builder getCommonBuilder() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("这是Title")//设置标题
                //设置标题前的icon图标
                .setIcon(R.mipmap.ic_launcher)
                //Neutral 中立的 中性的
                //设置一个中性的Button 一般用于“忽略”、“以后提醒我”等操作.
                .setNeutralButton("neutral", dialogButtonClickListener)
                //negative 消极的
                //设置一个消极的Button 一般用于"取消"操作
                .setNegativeButton("negative", dialogButtonClickListener)
                .setPositiveButton("positive", dialogButtonClickListener);
        return builder;

    }


    /**
     * 初始化 控件
     */
    private void initView() {
        btnNormalDilalog = (Button) findViewById(R.id.btn_dialog_normal_dialog);
        btnListDialog = (Button) findViewById(R.id.btn_dialog_list_dialog);
        btnSingleChoiceDialog = (Button) findViewById(R.id.btn_dialog_single_choice_dialog);
        btnMultiChoiceDialog = (Button) findViewById(R.id.btn_dialog_multi_choice_dialog);
        btnCustomViewDialog = (Button) findViewById(R.id.btn_dialog_custom_view_dialog);
        btnCancelAndDismissListener = (Button) findViewById(R.id.btn_dialog_cancelable_dismiss_listener);

        btnNormalDilalog.setOnClickListener(this);
        btnListDialog.setOnClickListener(this);
        btnSingleChoiceDialog.setOnClickListener(this);
        btnMultiChoiceDialog.setOnClickListener(this);
        btnCustomViewDialog.setOnClickListener(this);
        btnCancelAndDismissListener.setOnClickListener(this);
    }

    private void toastMsg(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
