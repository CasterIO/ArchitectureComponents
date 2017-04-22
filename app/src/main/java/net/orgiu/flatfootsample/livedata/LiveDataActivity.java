package net.orgiu.flatfootsample.livedata;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.widget.Toolbar;

import net.orgiu.flatfootsample.R;
import net.orgiu.flatfootsample.common.BaseActivity;
import net.orgiu.flatfootsample.common.CounterLiveData;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LiveDataActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.counter)
    TextView counter;

    CounterLiveData counterLD = new CounterLiveData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        ButterKnife.bind(this);
        setUpToolbar();

        subscribeToLiveData();
    }

    private void setUpToolbar() {
        setActionBar(toolbar);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void subscribeToLiveData() {
        final Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer newValue) {
                counter.setText(String.valueOf(newValue));
            }
        };

        counterLD.observe(this, observer);
    }

    @OnClick(R.id.fab)
    public void onPlusOneClicked() {
        counterLD.increaseCounter();
    }
}
