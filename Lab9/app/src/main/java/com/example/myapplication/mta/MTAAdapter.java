package com.example.myapplication.mta;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;

public class MTAAdapter extends BaseAdapter {
    private Context ctx;
    private List<MTA> mtaImages;

    public MTAAdapter(Context ctx, List<MTA> mtaImages) {
        this.ctx = ctx;
        this.mtaImages = mtaImages;
    }

    @Override
    public int getCount() {
        return this.mtaImages.size();
    }

    @Override
    public Object getItem(int i) {
        return this.mtaImages.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater=LayoutInflater.from(ctx);
        View v=layoutInflater.inflate(R.layout.item_layout,viewGroup,false);
        ImageView iv=v.findViewById(R.id.imageView);
        TextView titlu=v.findViewById(R.id.titleText);
        MTA mtaimage=(MTA)getItem(i);
        iv.setImageBitmap(mtaimage.getImage());
        titlu.setText(""+mtaimage.getTitle());
        return v;
    }
}
