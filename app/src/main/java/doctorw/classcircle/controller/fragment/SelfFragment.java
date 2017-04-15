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


public class SelfFragment extends BaseFragment {


    private static final String TAG = SelfFragment.class.getSimpleName();//"CommonFragment"
    //private TextView textView;
    private  View mView;

//    @Override
//    protected View initView() {
//
//        mView = getmInflater().inflate(R.layout.fg_self,getmContainer(),false);
//
//        return mView;
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fg_self,container,false);
        return mView;
    }

    @Override
    protected void initData() {
        super.initData();
       // textView.setText("其他页面");
    }

}
