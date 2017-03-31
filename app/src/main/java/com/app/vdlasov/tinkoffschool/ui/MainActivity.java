package com.app.vdlasov.tinkoffschool.ui;

import com.app.vdlasov.tinkoffschool.R;
import com.app.vdlasov.tinkoffschool.ui.adapter.DialogsAdapter;
import com.app.vdlasov.tinkoffschool.ui.common.OnItemClickListener;
import com.app.vdlasov.tinkoffschool.ui.model.DialogItem;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
    }

    private void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_dialogs);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new DialogsAdapter(createDataset(), new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this, "position = " + position, Toast.LENGTH_SHORT).show();
                startNextScreen();
            }
        });
        recyclerView.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    private List<DialogItem> createDataset() {
        List<DialogItem> list = new ArrayList<>();
        list.add(new DialogItem("title", "desc"));
        list.add(new DialogItem("title", "desc"));
        list.add(new DialogItem("title", "desc"));
        list.add(new DialogItem("title", "desc"));
        list.add(new DialogItem("title", "desc"));
        list.add(new DialogItem("title", "desc"));
        return list;
    }

    private void startNextScreen() {
        Intent intent = new Intent(this, ChatActivity.class);
        startActivity(intent);
    }
}
