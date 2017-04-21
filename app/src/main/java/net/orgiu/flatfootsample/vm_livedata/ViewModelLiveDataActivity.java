package net.orgiu.flatfootsample.vm_livedata;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.android.support.lifecycle.LifecycleActivity;
import com.android.support.lifecycle.Observer;
import com.android.support.lifecycle.ViewModelStore;

import net.orgiu.flatfootsample.R;
import net.orgiu.flatfootsample.common.BaseActivity;

public class ViewModelLiveDataActivity extends BaseActivity {

    private CounterLiveViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = ViewModelStore.get(this, CounterLiveViewModel.class);

        subscribeToLiveDataChanges();
    }

    private void subscribeToLiveDataChanges() {
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer value) {
                counterView().setText(String.valueOf(value));
            }
        };

        viewModel.getCounter().observe(observer);
    }

    @Override
    public void onPlusOneClicked() {
        viewModel.increaseCounter();
    }
}
