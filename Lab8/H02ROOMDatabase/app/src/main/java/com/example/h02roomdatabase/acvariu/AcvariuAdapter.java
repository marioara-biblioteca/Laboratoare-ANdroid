package com.example.h02roomdatabase.acvariu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.h02roomdatabase.R;

import java.util.List;

public class AcvariuAdapter extends BaseAdapter {
    private Context ctx;
    private List<Acvariu> acvarii;

    public AcvariuAdapter(Context ctx, List<Acvariu> acvarii) {
        this.ctx = ctx;
        this.acvarii = acvarii;
    }

    @Override
    public int getCount() {
        return acvarii.size();
    }

    @Override
    public Object getItem(int i) {
        return acvarii.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Acvariu a=acvarii.get(i);
        LayoutInflater inflater=LayoutInflater.from(this.ctx);
        View v = inflater.inflate(R.layout.acvariu_layout,viewGroup,false);


        TextView material=v.findViewById(R.id.material);
        material.setText(a.getMaterial());
        TextView cantitate=v.findViewById(R.id.cantitate);
        cantitate.setText(a.getCapacitatePesti()+"");
        return v;
    }
}
