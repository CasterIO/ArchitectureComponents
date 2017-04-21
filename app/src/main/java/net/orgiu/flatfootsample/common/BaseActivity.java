package net.orgiu.flatfootsample.common;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.widget.Toolbar;

import com.android.support.lifecycle.LifecycleActivity;

import net.orgiu.flatfootsample.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public abstract class BaseActivity extends LifecycleActivity{

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.counter)
    TextView counter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        ButterKnife.bind(this);
        setUpToolbar();
    }

    private void setUpToolbar() {
        setActionBar(toolbar);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public TextView counterView() {
        return counter;
    }

    @OnClick(R.id.fab)
    public abstract void onPlusOneClicked();
}
