package net.orgiu.architecture.vm_livedata;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import net.orgiu.architecture.common.BaseActivity;

public class ViewModelLiveDataActivity extends BaseActivity {

    private CounterLiveViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = ViewModelProviders.of(this).get(CounterLiveViewModel.class);

        subscribeToLiveDataChanges();
    }

    private void subscribeToLiveDataChanges() {
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer value) {
                counterView().setText(String.valueOf(value));
            }
        };

        viewModel.getCounter().observe(this, observer);
    }

    @Override
    public void onPlusOneClicked() {
        viewModel.increaseCounter();
    }
}
