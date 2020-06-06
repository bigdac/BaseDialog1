# BaseDialog
自定义dialog（类AlertDialog）

### 引入

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}


implementation 'com.github.bigdac:BaseDialog1:1.0.2'

```

### 使用方式
```
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv_title = findViewById(R.id.tv_title);
        tv_title.setOnClickListener(v -> {
            BaseDialog baseDialog = new BaseDialog.Builder(this)
                      //设置布局
                    .setContentView(R.layout.dialog_save)
                    //设置布占屏幕的百分比 1-100
                    .setPercentWidthAndHeight(75, 45)
                    //直接设置点击事件1
                    .setClickListener(R.id.btn_cancel,  v1 -> {//自定义取消按钮
                        Toast.makeText(MainActivity.this,"取消"  , Toast.LENGTH_SHORT).show();
                    },true)//可以取消dialog
                     //直接设置点击事件2
                    .setClickListener(R.id.btn_ensure, v1 -> {
                        Toast.makeText(MainActivity.this,"确定"  , Toast.LENGTH_SHORT).show(); })
                     //  显示dialog
                    .show();
            //           需要界面读取数据用下方的方法
            baseDialog.setText(R.id.tv_title, getString(R.string.app_name));
            EditText editText = baseDialog.getView(R.id.et_content);
            //dialog 支持直接设置点击事件
//            baseDialog.setClickListener(R.id.btn_cancel, v1 -> {
//                baseDialog.dismiss();
//            });
//            baseDialog.setClickListener(R.id.btn_ensure, v1 -> {
//                Toast.makeText(MainActivity.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
//            });

        });

    }

```

### 详细说明
https://blog.csdn.net/weixin_43607099/article/details/105822321

