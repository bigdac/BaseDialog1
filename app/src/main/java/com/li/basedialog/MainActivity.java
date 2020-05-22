package com.li.basedialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.li.mylibrary.dialog.BaseDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv_title = findViewById(R.id.tv_title);
        tv_title.setOnClickListener(v -> {
            BaseDialog baseDialog = new BaseDialog.Builder(this)
                    .setContentView(R.layout.dialog_save)
                    .setPercentWidthAndHeight(75, 45)
                    .setClickListener(R.id.btn_cancel,  v1 -> {//自定义取消按钮
                        Toast.makeText(MainActivity.this,"取消"  , Toast.LENGTH_SHORT).show();
                    },true)//可以取消dialog
                    .setClickListener(R.id.btn_ensure, v1 -> {
                        Toast.makeText(MainActivity.this,"确定"  , Toast.LENGTH_SHORT).show(); })
                    .show();
            //           需要界面读取数据用下方的方法
            baseDialog.setText(R.id.tv_title, getString(R.string.app_name));
            EditText editText = baseDialog.getView(R.id.et_content);
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
