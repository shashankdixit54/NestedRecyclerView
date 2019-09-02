package com.example.nestedrecyclerview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.opengl.Visibility;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder> {

    private ArrayList<SingleItemModel> itemsList;
    private Context mContext;

    public SectionListDataAdapter(Context context, ArrayList<SingleItemModel> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_single_card, null);
        if (v.getLayoutParams() != null){
            v.getLayoutParams().width = viewGroup.getContext().getResources().getDisplayMetrics().widthPixels/4-5;
        }else {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(viewGroup.getContext().getResources().getDisplayMetrics().widthPixels/4-5, ViewGroup.LayoutParams.WRAP_CONTENT);
            v.setLayoutParams(params);
        }
        SingleItemRowHolder mh = new SingleItemRowHolder(v,viewGroup.getContext().getResources().getDisplayMetrics().widthPixels);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {

        SingleItemModel singleItem = itemsList.get(i);


        holder.tvTitle.setText(singleItem.getName());


       /* Glide.with(mContext)
                .load(feedItem.getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.bg)
                .into(feedListRowHolder.thumbView);*/
    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvTitle;

        protected ImageView itemImage, calenderImg;

        protected LinearLayout mainLayout,calenderView,percentLay;


        public SingleItemRowHolder(View view, int width) {
            super(view);

            this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);

            //this.tvTitle .getLayoutParams().width = width/6;
            //this.itemImage = (ImageView) view.findViewById(R.id.itemImage);
            this.mainLayout = (LinearLayout) view.findViewById(R.id.mainLinLayout);
            //mainLayout.getLayoutParams().width = width/4;
            //this.calenderImg = (ImageView)view.findViewById(R.id.calanderImage);
            this.calenderView = (LinearLayout) view.findViewById(R.id.calenderLayout);
            this.percentLay = (LinearLayout) view.findViewById(R.id.percentLayout);


            this.mainLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (calenderView.getVisibility() == View.VISIBLE) {
                        calenderView.setVisibility(View.GONE);
                    }else{
                        calenderView.setVisibility(View.VISIBLE);
                    }
                    Toast.makeText(v.getContext(), tvTitle.getText(), Toast.LENGTH_SHORT).show();

                }
            });

        }

    }

}
