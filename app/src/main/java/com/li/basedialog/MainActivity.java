package com.li.basedialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.li.mylibrary.dialog.BaseDialog;
import com.li.mylibrary.dialog.DialogClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv_title = findViewById(R.id.tv_title);
        tv_title.setOnClickListener(v -> {
//           直接调用
            new BaseDialog.Builder(this)
                    .setContentView(R.layout.dialog_save)
                    .setPercentWidthAndHeight(75, 45)
                    .setClickListener(R.id.btn_cancel, true)//可以直接取消dialog
                    .setClickListener(R.id.btn_ensure, new DialogClickListener() {
                        @Override
                        public void onDialogClick(View v, BaseDialog baseDialog) {
//                          可以  添加点击事件取消dialog
                            Toast.makeText(MainActivity.this, "点击取消", Toast.LENGTH_SHORT).show();
                            baseDialog.dismiss();
                        }
                    })
                    .create()
                    .show();
//           需要界面做更多事情调用获取Dialog
//           BaseDialog baseDialog =new BaseDialog.Builder(this)
//                    .setContentView(R.layout.dialog_save)
//                    .setPercentWidthAndHeight(75, 45)
//                    .setClickListener(R.id.btn_cancel, true)//可以直接取消dialog
//                    .setClickListener(R.id.btn_ensure, new DialogClickListener() {
//                        @Override
//                        public void onDialogClick(View v, BaseDialog baseDialog) {
////                          可以  添加点击事件取消dialog
//                            Toast.makeText(MainActivity.this, "点击取消", Toast.LENGTH_SHORT).show();
//                            baseDialog.dismiss();
//                        }
//                    })
//                    .create();
//
//            baseDialog.setText(R.id.tv_title, getString(R.string.app_name));
//            EditText editText = baseDialog.getView(R.id.et_content);
//            baseDialog.setClickListener(R.id.btn_cancel, v1 -> {
//                baseDialog.dismiss();
//            });
//            baseDialog.setClickListener(R.id.btn_ensure, v1 -> {
//                Toast.makeText(MainActivity.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
//            });

        });

    }

    public int dip2px(float dpValue) {
        float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
