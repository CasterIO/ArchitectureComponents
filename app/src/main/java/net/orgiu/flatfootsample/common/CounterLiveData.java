package net.orgiu.flatfootsample.common;

import android.arch.lifecycle.LiveData;


public class CounterLiveData extends LiveData<Integer>{

    public CounterLiveData() {
        setValue(0);
    }

    @Override
    protected void onActive() {

    }

    @Override
    protected void onInactive() {

    }

    public void increaseCounter() {
        setValue(getValue() + 1);
    }
}
