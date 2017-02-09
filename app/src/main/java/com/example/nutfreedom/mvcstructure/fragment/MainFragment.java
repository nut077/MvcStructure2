package com.example.nutfreedom.mvcstructure.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nutfreedom.mvcstructure.R;

public class MainFragment extends Fragment {

    private int someVar;
    private TextView tvHello;

    public static MainFragment newInstance(int someVar) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putInt("someVar", someVar);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        someVar = getArguments().getInt("someVar");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        tvHello = (TextView) rootView.findViewById(R.id.tvHello);
    }

    public void setHelloText(String text) {
        tvHello.setText(text);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {

        }
    }
}
