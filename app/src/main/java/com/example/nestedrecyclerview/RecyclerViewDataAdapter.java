package com.example.nestedrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewDataAdapter extends RecyclerView.Adapter<RecyclerViewDataAdapter.ItemRowHolder> {

    private ArrayList<SectionDataModel> dataList;
    private Context mContext;

    public RecyclerViewDataAdapter(Context context, ArrayList<SectionDataModel> dataList) {
        this.dataList = dataList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, null);
        if (v.getLayoutParams() != null){
            //v.getLayoutParams().width = viewGroup.getContext().getResources().getDisplayMetrics().widthPixels/4;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) v.getLayoutParams();
            layoutParams.setMargins(5,5,5,5);
            layoutParams.width = viewGroup.getContext().getResources().getDisplayMetrics().widthPixels/4;
            v.setLayoutParams(layoutParams);
        }else {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(viewGroup.getContext().getResources().getDisplayMetrics().widthPixels/4, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(5,5,5,5);
                v.setLayoutParams(params);
        }

        return new ItemRowHolder(v,viewGroup.getContext().getResources().getDisplayMetrics().widthPixels);
    }

    @Override
    public void onBindViewHolder(ItemRowHolder itemRowHolder, int i) {

        final String sectionName = dataList.get(i).getHeaderTitle();

        ArrayList singleSectionItems = dataList.get(i).getAllItemsInSection();

        itemRowHolder.itemTitle.setText(sectionName);

        SectionListDataAdapter itemListDataAdapter = new SectionListDataAdapter(mContext, singleSectionItems);

        itemRowHolder.recycler_view_list.setHasFixedSize(true);
        itemRowHolder.recycler_view_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        itemRowHolder.recycler_view_list.setAdapter(itemListDataAdapter);



       /* Glide.with(mContext)
                .load(feedItem.getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.bg)
                .into(feedListRowHolder.thumbView);*/
    }

    @Override
    public int getItemCount() {
        return (null != dataList ? dataList.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView itemTitle;

        protected RecyclerView recycler_view_list;


        protected LinearLayout linLayout;


        public ItemRowHolder(View view, int width) {
            super(view);

            this.linLayout = (LinearLayout)view.findViewById(R.id.listItemLinLayout);
            this.itemTitle = (TextView) view.findViewById(R.id.itemTitle);
            this.recycler_view_list = (RecyclerView) view.findViewById(R.id.recycler_view_list);
            //this.recycler_view_list.getLayoutParams().width = width/4;



        }

    }

}
