package com.example.basiccustomview.exercise.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Project: BasicCustomView
 * Create By: ChenFuXu
 * DateTime: 2022/11/16 21:45
 **/
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return loadView(inflater, container);
    }

    protected View loadView(LayoutInflater inflater, ViewGroup container) {
        int resId = getResourceId();
        return inflater.inflate(resId, container, false);
    }

    protected abstract int getResourceId();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
