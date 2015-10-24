package xyz.kushal.dynamicspanrecycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import xyz.kushal.adapters.DemoAdapter;

public class MainActivity extends AppCompatActivity
{
    private final static int SPAN_SIZE = 3;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private GridLayoutManager mLayoutManager;

    private ArrayList<String> dummyData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new GridLayoutManager(MainActivity.this, SPAN_SIZE);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup()
        {
            @Override
            public int getSpanSize(int position)
            {
                return (SPAN_SIZE - position % SPAN_SIZE);
            }
        });

        mRecyclerView.setLayoutManager(mLayoutManager);

        List<String> countries = Arrays.asList(getResources().getStringArray(R.array.countries_array));

        for (String country : countries)
            dummyData.add(country);

        mAdapter = new DemoAdapter(dummyData, MainActivity.this);
        mRecyclerView.setAdapter(mAdapter);
    }
}
