package com.example.lab4.lab6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab4.R;

import java.util.List;

public class AcvariuAdapter extends BaseAdapter {
    private Context ctx;
    private List<ACVariu> acVarius;

    public AcvariuAdapter(Context ctx, List<ACVariu> acVarius) {
        this.ctx = ctx;
        this.acVarius =acVarius;
    }

    @Override
    public int getCount() {
        return  this.acVarius.size();
    }

    @Override
    public Object getItem(int i) {
        return this.acVarius.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(R.layout.acvariu_layout, viewGroup,false);
        ImageView iv = v.findViewById(R.id.imageView);
        TextView tv1 = v.findViewById(R.id.textView);

        ACVariu acVariu = (ACVariu) getItem(i);
        iv.setImageResource(acVariu.getImagine());
        tv1.setText(acVariu.getMaterial());
        return v;
    }
}
