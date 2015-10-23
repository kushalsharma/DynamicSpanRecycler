package xyz.kushal.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import xyz.kushal.dynamicspanrecycler.R;

/**
 * Created by Kush on 10/23/2015.
 * A demo adapter for inflating data in recycler view.
 */

public class DemoAdapter extends RecyclerView.Adapter {

    private ArrayList<String> dummyData = new ArrayList<>();
    private Activity activity;
    private LayoutInflater mInflater;

    public DemoAdapter(ArrayList<String> dummyData, Activity activity) {
        this.dummyData = dummyData;
        this.activity = activity;

        mInflater = (LayoutInflater) this.activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        switch (viewType) {
            case 3:
                v = mInflater.inflate(R.layout.layout_large, parent, false);
                return new LargeViewHolder(v);
            case 2:
                v = mInflater.inflate(R.layout.layout_medium, parent, false);
                return new MediumViewHolder(v);
            case 1:
                v = mInflater.inflate(R.layout.layout_small, parent, false);
                return new SmallViewHolder(v);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (getItemViewType(position)) {
            case 3:
                ((LargeViewHolder) holder).getDummyTextView().setText(dummyData.get(position));
                break;
            case 2:
                ((MediumViewHolder) holder).getDummyTextView().setText(dummyData.get(position));
                break;
            case 1:
                ((SmallViewHolder) holder).getDummyTextView().setText(dummyData.get(position));
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return (3 - position % 3);
    }

    @Override
    public int getItemCount() {
        return dummyData.size();
    }

    class LargeViewHolder extends RecyclerView.ViewHolder {

        private TextView dummyTextView;

        public LargeViewHolder(View itemView) {
            super(itemView);
            dummyTextView = (TextView) itemView.findViewById(R.id.dummy_text);
        }

        public TextView getDummyTextView() {
            return dummyTextView;
        }
    }

    class MediumViewHolder extends RecyclerView.ViewHolder {
        private TextView dummyTextView;

        public MediumViewHolder(View itemView) {
            super(itemView);
            dummyTextView = (TextView) itemView.findViewById(R.id.dummy_text);
        }

        public TextView getDummyTextView() {
            return dummyTextView;
        }
    }

    class SmallViewHolder extends RecyclerView.ViewHolder {
        private TextView dummyTextView;

        public SmallViewHolder(View itemView) {
            super(itemView);
            dummyTextView = (TextView) itemView.findViewById(R.id.dummy_text);
        }

        public TextView getDummyTextView() {
            return dummyTextView;
        }
    }
}
