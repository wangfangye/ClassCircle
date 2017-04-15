package doctorw.classcircle.controller.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import doctorw.classcircle.R;


public class StudyFragment extends BaseFragment {


    private static final String TAG = StudyFragment.class.getSimpleName();//"CommonFragment"

    private View mView;

//    @Override
//    protected View initView() {
//        mView = getmInflater().inflate(R.layout.fg_study,getmContainer(),false);
//        return mView;
//    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fg_study,container,false);
        return mView;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG, "自定义Fragment数据被初始化了...");
    }
}
