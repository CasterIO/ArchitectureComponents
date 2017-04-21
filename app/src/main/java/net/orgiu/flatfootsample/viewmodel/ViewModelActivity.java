package net.orgiu.flatfootsample.viewmodel;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toolbar;

import com.android.support.lifecycle.LifecycleActivity;
import com.android.support.lifecycle.ViewModelStore;

import net.orgiu.flatfootsample.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewModelActivity extends LifecycleActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.counter)
    TextView counter;

    private CounterViewModel counterVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);
        ButterKnife.bind(this);
        setUpToolbar();

        counterVM = ViewModelStore.get(this, CounterViewModel.class);
        updateCounterValue(counterVM.getCounter());
    }

    private void setUpToolbar() {
        setActionBar(toolbar);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OnClick(R.id.fab)
    public void onPlusOneClicked() {
        counterVM.increaseCounter();
        updateCounterValue(counterVM.getCounter());
    }

    private void updateCounterValue(int value) {
        counter.setText(String.valueOf(value));
    }

}
