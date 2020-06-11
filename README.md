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


implementation 'com.github.bigdac:BaseDialog1:1.0.3'

```

### 使用方式
```
  简单直接调用
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

//需要界面做更多事情调用获取Dialog
  BaseDialog baseDialog =new BaseDialog.Builder(this)
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
                     .create();

             baseDialog.setText(R.id.tv_title, getString(R.string.app_name));
             EditText editText = baseDialog.getView(R.id.et_content);
             baseDialog.setClickListener(R.id.btn_cancel, v1 -> {
                 baseDialog.dismiss();
             });
             baseDialog.setClickListener(R.id.btn_ensure, v1 -> {
                 Toast.makeText(MainActivity.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
             });

```

### 详细说明
https://blog.csdn.net/weixin_43607099/article/details/105822321

