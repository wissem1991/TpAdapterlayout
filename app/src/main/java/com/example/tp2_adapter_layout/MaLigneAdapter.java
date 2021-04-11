package com.example.tp2_adapter_layout;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MaLigneAdapter extends ArrayAdapter<String> {

    Activity context;
    String[] items;

    MaLigneAdapter(Activity context, String[] items){
        super(context, R.layout.ma_ligne, items);
        this.context = context;
        this.items = items;
    }

    public View getView(int position, View convertView, ViewGroup Parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View ligne = inflater.inflate(R.layout.ma_ligne, null);
        TextView label = (TextView) ligne.findViewById(R.id.note);
        ImageView icone = (ImageView) ligne.findViewById(R.id.monImage);
        label.setText(items[position]);
        float note = Float.valueOf(items[position]);
        icone.setImageResource(
                (note >= 10)? R.drawable.reussite : R.drawable.echoue
        );

        return ligne;
    }
}
