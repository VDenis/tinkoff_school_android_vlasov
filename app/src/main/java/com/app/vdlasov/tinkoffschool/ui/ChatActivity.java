package com.app.vdlasov.tinkoffschool.ui;

import com.app.vdlasov.tinkoffschool.R;
import com.app.vdlasov.tinkoffschool.ui.adapter.ChatAdapter;
import com.app.vdlasov.tinkoffschool.ui.common.OnItemClickListener;
import com.app.vdlasov.tinkoffschool.ui.model.MessageItem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        initRecyclerView();
    }

    private void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_chat);
        //recyclerView.hasFixedSize();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ChatAdapter(createDataset(), new OnItemClickListener() {
            @Override
            public void onItemClick(final int position) {
                Toast.makeText(ChatActivity.this, "position = " + position, Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private List<MessageItem> createDataset() {
        List<MessageItem> list = new ArrayList<>();
        list.add(new MessageItem("Nicholas", "message1", "30/03/17", R.layout.item_chat_left_message));
        list.add(new MessageItem("Nicholas", "message2", "30/03/17", R.layout.item_chat_left_message));
        list.add(new MessageItem("Mike", "message3", "30/03/17", R.layout.item_chat_right_message));
        list.add(new MessageItem("Mike", "message4", "30/03/17", R.layout.item_chat_right_message));
        list.add(new MessageItem("Mike", "message5", "30/03/17", R.layout.item_chat_right_message));
        list.add(new MessageItem("Nicholas", "message6", "30/03/17", R.layout.item_chat_left_message));
        return list;
    }
}