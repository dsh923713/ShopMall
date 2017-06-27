package com.zmq.shopmall.adapter;

import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.zmq.shopmall.R;
import com.zmq.shopmall.bean.FiltrateItem;
import com.zmq.shopmall.bean.FiltrateItem1;
import com.zmq.shopmall.bean.FiltrateItemContent;

import java.util.List;

/**
 * Created by Administrator on 2017/6/24.
 */

public class FiltrateAllClassifyAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    public static final int TYPE_LEVEL_0 = 0;
    public static final int TYPE_LEVEL_1 = 1;
    public static final int TYPE_PERSON = 2;
    FragmentManager fragmentManager;

    public FiltrateAllClassifyAdapter(FragmentManager fragmentManager,List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_LEVEL_0, R.layout.rv_item_expandable_0);
        addItemType(TYPE_LEVEL_1, R.layout.rv_item_expandable_1);
        addItemType(TYPE_PERSON, R.layout.rv_item_expandable_2);
        this.fragmentManager = fragmentManager;
    }

    @Override
    protected void convert(final BaseViewHolder holder, MultiItemEntity item) {
        Drawable drawable = ContextCompat.getDrawable(mContext, R.mipmap.ic_down_up);
        Drawable drawable1 = ContextCompat.getDrawable(mContext, R.mipmap.ic_goto_up);
        final Drawable drawable2 = ContextCompat.getDrawable(mContext, R.mipmap.ic_tick);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        drawable1.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        drawable2.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        final CheckBox cbChildTitle = holder.getView(R.id.cb_child_title);
        switch (holder.getItemViewType()) {
            case TYPE_LEVEL_0:
                final FiltrateItem filtrateItem = (FiltrateItem) item;
                final CheckBox cbAllClassify = holder.getView(R.id.cb_all_classify);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cbAllClassify.setCompoundDrawables(null, null, cbAllClassify.isChecked() ? drawable2 : null, null);
                        fragmentManager.popBackStack();
                    }
                });
                break;
            case TYPE_LEVEL_1:
                final FiltrateItem1 item1 = (FiltrateItem1) item;
                holder.setText(R.id.tv_item_title, item1.title);
                TextView tv = holder.getView(R.id.tv_item_title);
                tv.setCompoundDrawables(null, null, item1.isExpanded() ? drawable1 : drawable, null);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = holder.getAdapterPosition();
                        if (item1.isExpanded()){
                            collapse(pos);
                        }else {
                            expand(pos);
                        }
                    }
                });
                break;
            case TYPE_PERSON:
                FiltrateItemContent itemContent = (FiltrateItemContent) item;
                holder.setText(R.id.cb_child_title,itemContent.title);

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cbChildTitle.setCompoundDrawables(null, null, cbChildTitle.isChecked() ? drawable2 : null, null);
                        fragmentManager.popBackStack();
                    }
                });
                break;
        }
    }
}
