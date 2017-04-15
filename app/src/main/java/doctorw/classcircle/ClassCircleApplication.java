package doctorw.classcircle;

import android.app.Application;
import android.content.Context;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.controller.EaseUI;

import cn.smssdk.SMSSDK;
import doctorw.classcircle.model.Model;

/**
 * Created by asus on 2017/4/7.
 */

public class ClassCircleApplication extends Application {
    private static Context mContext;

    public static Context getmContext() {
        return mContext;
    }

    @Override
  public void onCreate() {
        super.onCreate();
        //短信验证SDK的初始化
        SMSSDK.initSDK(this, "1cecd19a5632e", "58edb27da1be2048e71f22d6b69d2a0c");

        EMOptions options = new EMOptions();
        //接受邀请 false（在好友同意之后接受邀请）
        options.setAcceptInvitationAlways(false);
        //接受群邀请  false（同意后接受群邀请）
        options.setAutoAcceptGroupInvitation(false);
        EaseUI.getInstance().init(this,options);
//        OkGo.init(this);
        //初始化程序模型层
        Model.getInstance().init(this);
    }

    // 获取全局上下文对象
    public static Context getGlobalApplication(){
        return mContext;
    }

}
