package com.example.goodluck.backup3.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.goodluck.backup3.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GOODLUCK on 10/31/2015.
 */

    public class minRecyclerAdapter extends RecyclerView.Adapter<minRecyclerAdapter.VersionViewHolder> {
        public static List<String> testActivitiesList = new ArrayList<String>();
        public static List<String> testActivitiesSubList = new ArrayList<String>();
        Context context;
        boolean isTestList = false;
      OnItemClickListener clickListener;
        List<String> versionModels;

        public void setHomeActivitiesList(Context context) {
            String[] listArray = context.getResources().getStringArray(R.array.test_activities);
            String[] subTitleArray = context.getResources().getStringArray(R.array.test_activities_subtitle);
            for (int i = 0; i < listArray.length; ++i) {
                testActivitiesList.add(listArray[i]);
                testActivitiesSubList.add(subTitleArray[i]);
            }
        }

        public minRecyclerAdapter(Context context) {
            isTestList = true;
            this.context = context;
            setHomeActivitiesList(context);
        }

    @Override
    public VersionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerlist_item, parent, false);
        return new VersionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VersionViewHolder versionViewHolder, int i) {
        if (isTestList) {
            versionViewHolder.title.setText(testActivitiesList.get(i));
            versionViewHolder.subTitle.setText(testActivitiesSubList.get(i));
        } else {
            versionViewHolder.title.setText(versionModels.get(i));
        }
    }
    @Override
    public int getItemCount() {
        if (isTestList)
            return 1;
        else
            return versionModels == null ? 0 : versionModels.size();
    }


    class VersionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            CardView cardItemLayout;
            TextView title;
            TextView subTitle;

            public VersionViewHolder(View itemView) {
                super(itemView);

                cardItemLayout = (CardView) itemView.findViewById(R.id.cardlist_item);
                title = (TextView) itemView.findViewById(R.id.listitem_name);
                subTitle = (TextView) itemView.findViewById(R.id.listitem_subname);

                if (isTestList) {
                    itemView.setOnClickListener(this);
                } else {
                    subTitle.setVisibility(View.GONE);
                }
            }

            @Override
            public void onClick(View v) {
                clickListener.onItemClick(v, getPosition());
            }
        }
            public interface OnItemClickListener {
                public void onItemClick(View view, int position);
            }
        public void SetOnItemClickListener(final OnItemClickListener itemClickListener) {
            this.clickListener = itemClickListener;
        }
     }


