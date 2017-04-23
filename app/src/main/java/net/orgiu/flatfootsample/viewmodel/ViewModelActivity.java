package net.orgiu.flatfootsample.viewmodel;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import net.orgiu.flatfootsample.R;
import net.orgiu.flatfootsample.common.BaseActivity;

import butterknife.OnClick;

public class ViewModelActivity extends BaseActivity {

    private CounterViewModel counterVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        counterVM = ViewModelProviders.of(this).get(CounterViewModel.class);
        updateCounterValue(counterVM.getCounter());
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
