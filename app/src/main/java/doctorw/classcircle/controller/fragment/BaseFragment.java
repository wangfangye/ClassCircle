package doctorw.classcircle.controller.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;


public abstract class BaseFragment extends Fragment {

    /**
     * 上下文
     */
    protected  ViewGroup mContainer;
    protected  LayoutInflater mInflater;
    protected  Context mContext;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }



//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        mContainer = container;
//        mInflater = inflater;
//        return initView();
//    }

    /**
     * 强制子类重写，实现子类特有的ui
     * @return
     */

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
        initSetUpView();
    }

    /**
     * 当孩子需要初始化数据，或者联网请求绑定数据，展示数据的 等等可以重写该方法
     */
    protected void initData() {

    }

    protected  void initSetUpView(){

    }

    protected void initView(){

    }


    protected void hideSoftKeyboard(EditText et) {
        InputMethodManager imm =(InputMethodManager)mContext.getSystemService(
                mContext.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(et.getWindowToken(), 0);
    }

    public void showToast(String msg) {
        Toast.makeText(this.getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public LayoutInflater getmInflater() {
        return mInflater;
    }

    public ViewGroup getmContainer() {
        return mContainer;
    }
}
