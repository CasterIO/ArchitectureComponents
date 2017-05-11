package net.orgiu.architecture.livedata;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;

import net.orgiu.architecture.R;
import net.orgiu.architecture.common.BaseActivity;
import net.orgiu.architecture.common.CounterLiveData;

import butterknife.OnClick;

public class LiveDataActivity extends BaseActivity {

    CounterLiveData counterLD = new CounterLiveData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        subscribeToLiveData();
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
