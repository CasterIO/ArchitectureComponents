package net.orgiu.flatfootsample.common;


import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toolbar;

import android.arch.lifecycle.LifecycleActivity;

import net.orgiu.flatfootsample.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public abstract class BaseActivity extends AppCompatActivity implements LifecycleRegistryOwner{

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.counter)
    TextView counter;

    private final LifecycleRegistry registry = new LifecycleRegistry(this);

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

    @Override
    public LifecycleRegistry getLifecycle() {
        return registry;
    }
}
