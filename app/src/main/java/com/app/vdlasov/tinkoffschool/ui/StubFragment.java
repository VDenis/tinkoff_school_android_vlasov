package com.app.vdlasov.tinkoffschool.ui;

import com.app.vdlasov.tinkoffschool.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Denis on 01.04.2017.
 */

public class StubFragment extends Fragment {

    static final String ARG_TITLE = "title";

    private String title;

    public static StubFragment newInstance(String title) {
        StubFragment fragment = new StubFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_TITLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stub, container, false);
        TextView textViewTitle = (TextView) view.findViewById(R.id.text_view_stub);
        textViewTitle.setText(title);
        return view;
    }
}
