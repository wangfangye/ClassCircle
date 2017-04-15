package doctorw.classcircle.model;

import android.content.Context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import doctorw.classcircle.model.dao.ParentUserAccountDao;

/**
 * Created by asus on 2017/4/9.
 */

//数据模型层的全局类
public class Model {

    //创建对象
    private static Model model = new Model();
    private Context mContext;

    ParentUserAccountDao parentUserAccountDao;
    private ExecutorService executors = Executors.newCachedThreadPool();


    //私有化构造
    private Model() {

    }

    //获取单例对象
    public  static  Model getInstance(){
        return  model;
    }

    //初始化方法
    public  void  init(Context context){
        mContext = context;
        //创建用户账号数据库的操作类对象
         parentUserAccountDao = new ParentUserAccountDao(mContext);
    }
    //获取全局线程池对象
    public ExecutorService getGlobalThreadPool(){
        return executors;
    }

    //用户登录成功后 对模型层做的处理
    public void loginSuccess() {
    }

    //数据库操作类
    public ParentUserAccountDao getParentUserAccountDao(){
        return parentUserAccountDao;
    }

}
