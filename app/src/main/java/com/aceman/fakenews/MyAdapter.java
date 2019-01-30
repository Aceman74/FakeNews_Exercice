package com.aceman.fakenews;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.oc.rss.fake.FakeNews;
import com.oc.rss.fake.FakeNewsList;

import java.util.List;

/**
 * Created by Lionel JOFFRAY - on 30/01/2019.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    static String mGetContent;
    List<FakeNews> list = FakeNewsList.all;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder

    static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView mTextView;
        WebView mWebView;

        MyViewHolder(View view) {
            super(view);
            mTextView  = view.findViewById(R.id.title_list);
            mWebView = view.findViewById(R.id.web_view1);
        }
    }
    // Provide a suitable constructor (depends on the kind of dataset)
    MyAdapter(List<FakeNews> myList) {
        list = myList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_maker, parent, false);
        return new MyViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int i) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final FakeNews actualItem = list.get(i);

        holder.mTextView.setText(actualItem.title);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyAdapter.mGetContent = actualItem.htmlContent;
                view.getContext().startActivity(new Intent(view.getContext(),WebViewActivity.class));
            }
        });

    }
    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return list.size();
    }

    private Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

}
