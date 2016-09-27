package com.mikepenz.fastadapter.issue218;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.mikepenz.fastadapter.adapters.FastItemAdapter;

import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    FastItemAdapter<SampleItem> fastItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fastItemAdapter = new FastItemAdapter<>();
        fastItemAdapter.withSelectable(true);
        fastItemAdapter.withSelectWithItemUpdate(true);
        fastItemAdapter.withOnlyOneExpandedItem(true);

        for (int i = 0; i < 10; i++) {
            fastItemAdapter.add(new SampleItem(String.valueOf(i))
                    .withSubItems(Collections.singletonList(new SampleSubItem("expanded: " + i))));
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(fastItemAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        SampleItem next = fastItemAdapter.getSelectedItems().iterator().next();
        Toast.makeText(this, next.getModel(), Toast.LENGTH_SHORT).show();

        return true;
    }
}
