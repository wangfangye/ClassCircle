package doctorw.classcircle.controller.adapter.baseAdapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class ViewHolder {
    private SparseArray<View> mViews;

    private int mPosition;
    private View mConvertView;

    public ViewHolder(Context context, ViewGroup parent, int layoutId,
                      int position) {

        this.mPosition = position;
        this.mViews = new SparseArray<View>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent,
                false);
        mConvertView.setTag(this);
    }

    // 入口函数,获得ViewHolder
    public static ViewHolder get(Context context, View convertView,
                                 ViewGroup parent, int layoutId, int position) {
        if (convertView == null) {
            return new ViewHolder(context, parent, layoutId, position);
        } else {
            ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.mPosition = position;//更新position
            return holder;
        }
    }

    //通过viewId获取控件
    public  <T extends View > T getView(int viewId){
        View view = mViews.get(viewId);
        if(view ==null){
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T)view;
    }

    public View getmConvertView() {
        return mConvertView;
    }

    //写设置textview的方法,可以实现链式编程
    /**
     * 设置TextView的值
     * @param viewId
     * @param text
     * @return
     */
    public ViewHolder setText(int viewId,String text){
        TextView tv = getView(viewId);
        tv.setText(text);
        return  this;
    }

//    /**
//     * 设置ImageView的值
//     * @param viewId
//     * @param resourceId
//     * @return
//     */
    public ViewHolder setImageResource(int viewId,int resId){
        ImageView iv = getView(viewId);
        iv.setImageResource(resId);
        return  this;
    }

    /**
     * 设置Bitmap
     * @param viewId
     * @param bitmap
     * @return
     */
    public ViewHolder setImageBitmap(int viewId,Bitmap bitmap){
        ImageView iv = getView(viewId);
        iv.setImageBitmap(bitmap);
        return  this;
    }

    /**
     * 加载网络图片
     * @param viewId
     * @param url
     * @return
     */
    public ViewHolder setImageURI(int viewId,String url){
        ImageView view  = getView(viewId);
        //Imageloader.getInstance().loadImg(view,url);
        // view.setImageURI(url);
        return  this;
    }
}
