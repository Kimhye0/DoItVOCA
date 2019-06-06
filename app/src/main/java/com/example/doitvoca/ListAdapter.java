package com.example.doitvoca;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    int Check_num=0;
    LayoutInflater inflater = null;
    private ArrayList<Word> m_oData = null;
    private int nListCnt = 0;
    public ListAdapter(ArrayList<Word> _oData)
    {
        m_oData = _oData;
        nListCnt = m_oData.size();
    }

    @Override
    public int getCount()
    {
        Log.i("TAG", "getCount");
        return nListCnt;
    }

    @Override
    public Object getItem(int position)
    {
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (convertView == null)
        {
            final Context context = parent.getContext();
            if (inflater == null)
            {
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }
            convertView = inflater.inflate(R.layout.activity_list, parent, false);
        }
        TextView oTextWord =  convertView.findViewById(R.id.EnglishInput);
        TextView oTextMeaning =  convertView.findViewById(R.id.MeaningInput);
        oTextWord.setText(m_oData.get(position).EnglishInput);
        oTextMeaning.setText(m_oData.get(position).MeaningInput);
        return convertView;
    }
}
