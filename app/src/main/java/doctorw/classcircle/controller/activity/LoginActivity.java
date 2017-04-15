package doctorw.classcircle.controller.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.smssdk.contact.a;
import doctorw.classcircle.R;
import doctorw.classcircle.model.Model;
import doctorw.classcircle.model.bean.ParentInfo;

public class LoginActivity extends BaseActivity {

    @Bind(R.id.tv_phone)
    EditText tvPhone;
    @Bind(R.id.tv_password)
    EditText tvPassword;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//        ButterKnife.bind(this);
//    }

    @Override
    protected void onActivityCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.denglu, R.id.tv_forget, R.id.tv_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.denglu:
                denglu();
                startActivity(MainActivity.class);
                break;
            case R.id.tv_forget:
                forget();

                break;
            case R.id.tv_register:
                startActivity(RegisterActivity.class);
                break;
            default:
                break;
        }
    }

    //忘记密码
    private void forget() {
        showToast("怪我喽......");
    }


    //登录
    private void denglu() {
        //1获取用户名，密码
        final String phone = getText(tvPhone);
        final String password = getText(tvPassword);
        //2 判断是否符合要求

        //3 具体的登录逻辑处理
        // （1）自己服务器登录

        Model.getInstance().getGlobalThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                // （2）环信服务器登录
                EMClient.getInstance().login(phone, password, new EMCallBack() {
                    @Override
                    public void onSuccess() {
                        //对模型层做的处理
                        Model.getInstance().loginSuccess();

                        //保存用户账号信息到数据库（保存到服务器数据库）
                        Model.getInstance().getParentUserAccountDao().addParentAccount(new ParentInfo(phone));

                        //切换到主线程
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //提是登录成功
                                showToast("登录成功");
                                //跳转到主界面
                                startActivity(MainActivity.class);
                                finish();
                            }
                        });
                    }

                    @Override
                    public void onError(int i, String s) {

                    }

                    @Override
                    public void onProgress(int i, final String s) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                showToast("登录失败"+ s);
                            }
                        });

                    }
                });


            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}

//        HttpHeaders headers = new HttpHeaders();
//        headers.put("commonHeaderKey1", "commonHeaderValue1");    //header不支持中文
//        headers.put("commonHeaderKey2", "commonHeaderValue2");
//        HttpParams params = new HttpParams();
//        params.put("commonParamsKey1", "commonParamsValue1");     //param支持中文,直接传,不要自己编码
//        params.put("commonParamsKey2", "这里支持中文参数");


//        File file = new File("/mnt/sdcard/pic.png");
//        AjaxParams params = new AjaxParams();
//        params.put("name", "mich");
//        try {
//
//            params.put("key",file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

//        params.put("password", "123456");
//        params.put("phone", "11");


//        FinalHttp fh = new FinalHttp();
//        fh.post("http://localhost:8080/classcircle/headPic.do", params, new AjaxCallBack(){
//            @Override
//            public void onLoading(long count, long current) {
//                showToast("cheonLoadingngg");
//            }
//
//            @Override
//            public void onSuccess(Object o) {
//                showToast("succeed");
//                super.onSuccess(o);
//            }
//        });
//
//        HashMap<String, String> params = new HashMap<>();
//        File file = new File("/mnt/sdcard/123.mp4");
//        if(file == null){
//            showToast("路径错误");
//        }
//        params.put("no","'P2014");
//        params.put("name", "11111");
//        params.put("password", "123456789");

//        params.put("key4", "其实你怎么高兴怎么写都行");
//        JSONObject jsonObject = new JSONObject(params);
//
//        Log.d("login,",file.toString());
//
//        OkGo.get("http://loger.iask.in/classcircle/userImage/1491893639088123.mp4")//
//                .tag(this)//
//                .execute(new FileCallback(Environment.getExternalStorageDirectory().getAbsolutePath(), "11111.mp4") {  //文件下载时，可以指定下载的文件目录和文件名
//                    @Override
//                    public void onSuccess(File file, Call call, Response response) {
//                        // file 即为文件数据，文件保存在指定目录
//                        showToast("chenggggg");
//                    }
//
//                    @Override
//                    public void downloadProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
//                        //这里回调下载进度(该回调在主线程,可以直接更新ui)
//                    }
//                });
//        OkGo.post("http://loger.iask.in/classcircle/headPic.do")//
//                .tag(this)//
//                .params("no","P2014")
//                .params("file1",file)
////                .params("name", "wqang")
////                .params("password", "123456789")
////                .upJson(jsonObject.toString())//
//                .execute(new StringCallback() {
//                    @Override
//                    public void onSuccess(String s, Call call, Response response) {
//                        //上传成功
//                        showToast("chenggong");
//                    }
//
//                    @Override
//                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
//                        //这里回调上传进度(该回调在主线程,可以直接更新ui)
//                    }
//                });

