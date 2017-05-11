package net.orgiu.architecture.common;


import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import net.orgiu.architecture.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public abstract class BaseActivity extends AppCompatActivity implements LifecycleRegistryOwner {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.counter)
    public TextView counter;

    private final LifecycleRegistry registry = new LifecycleRegistry(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        ButterKnife.bind(this);
        setUpToolbar();
    }

    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
