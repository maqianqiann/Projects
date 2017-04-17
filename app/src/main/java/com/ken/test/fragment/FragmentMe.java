package com.ken.test.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ken.test.R;
import com.ken.test.activity.FirstActivity;
import com.ken.test.activity.LogActivity;

/**
 * Created by lenovo on 2017/4/13.
 */

public class FragmentMe extends Fragment implements View.OnClickListener{

    private View view;
    private Button log;
    private FirstActivity activity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.wode_layout,null);
        activity = (FirstActivity) getActivity();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        log = (Button) view.findViewById(R.id.wo_log);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.wo_log:
                Intent intent=new Intent(activity,LogActivity.class);
                startActivityForResult(intent,0);

                break;

        }
    }
}
