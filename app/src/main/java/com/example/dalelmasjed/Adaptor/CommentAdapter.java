package com.example.dalelmasjed.Adaptor;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dalelmasjed.Model.Comment;
import com.example.dalelmasjed.R;

import java.util.List;

public class CommentAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Comment> commentList;


    public CommentAdapter(Activity activity, List<Comment> CommentItems) {
        this.activity = activity;
        this.commentList = CommentItems;
    }

    @Override
    public int getCount() {
        return commentList.size();
    }

    @Override
    public Object getItem(int location) {
        return commentList.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {

        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.commentlayout, null);

        TextView comment = convertView.findViewById(R.id.thecommenttxt);

        final  Comment m = commentList.get(position);
        comment.setText(m.getNote());

        return convertView;
    }

}