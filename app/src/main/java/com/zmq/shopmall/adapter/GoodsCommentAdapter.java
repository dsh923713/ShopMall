package com.zmq.shopmall.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;
import com.jaeger.ninegridimageview.NineGridImageView;
import com.jaeger.ninegridimageview.NineGridImageViewAdapter;
import com.zmq.shopmall.R;
import com.zmq.shopmall.bean.GoodsCommentBean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/15.
 */

public class GoodsCommentAdapter extends BaseQuickAdapter<GoodsCommentBean, BaseViewHolder> {

    public GoodsCommentAdapter(@Nullable List<GoodsCommentBean> data) {
        super(R.layout.rv_item_goods_comment, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, GoodsCommentBean item) {
        holder.setImageResource(R.id.riv_goods_comment_user, item.getUserIcon()).setText(R.id.tv_user_name, item.getUserName())
                .setText(R.id.tv_goods_comment, item.getGoodsComment());
        SimpleRatingBar simpleRatingBar = holder.getView(R.id.srb_goods_comment);
        simpleRatingBar.setRating(item.getSrbRating());
        NineGridImageView<GoodsCommentBean.GoodsCommentImage> nineGrid = holder.getView(R.id.ngiv_goods);
        nineGrid.setAdapter(new NineGridImageViewAdapter<GoodsCommentBean.GoodsCommentImage>() {
            @Override
            protected void onDisplayImage(Context context, ImageView imageView, GoodsCommentBean.GoodsCommentImage goodsCommentImage) {
                Glide.with(context).load(goodsCommentImage.getImageId()).into(imageView); //加载图片
            }
        });
        nineGrid.setImagesData(item.getImages());//设置数据源 必须放在最后  否则图片加载不出来

    }
}
