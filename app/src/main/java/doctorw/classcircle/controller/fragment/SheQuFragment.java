package doctorw.classcircle.controller.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import doctorw.classcircle.R;
import doctorw.classcircle.controller.adapter.ViewPagerAdapter;


public class SheQuFragment extends BaseFragment {


    @Bind(R.id.tableLayout_Shequ)
    TabLayout tableLayoutShequ;
    @Bind(R.id.vPager_shequ)
    ViewPager vPagerShequ;
    private View mView;

    ArrayList<MyFragment> fragments;
    ViewPagerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
      mView = inflater.inflate(R.layout.fg_shequ,container,false);
        ButterKnife.bind(this,mView);
        return mView;
    }

    @Override
    protected void initSetUpView() {
        super.initSetUpView();
    }

    @Override
    protected void initData() {
        super.initData();
        //初始化数据
        fragments = new ArrayList<>();
        for (int i=0;i<12;i++){
            fragments.add(new MyFragment("标题"+i,"内容"+i));
        }

        //设置ViewPager的适配器
        adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(),fragments);
        vPagerShequ.setAdapter(adapter);
        //关联ViewPager
        tableLayoutShequ.setupWithViewPager(vPagerShequ);
        //设置固定的
//        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tableLayoutShequ.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
