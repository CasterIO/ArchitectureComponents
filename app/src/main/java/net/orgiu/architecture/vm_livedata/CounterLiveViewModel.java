package net.orgiu.architecture.vm_livedata;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import net.orgiu.architecture.common.CounterLiveData;


public class CounterLiveViewModel extends ViewModel {

    private final CounterLiveData counter = new CounterLiveData();

    public LiveData<Integer> getCounter() {

        return counter;
    }

    public void increaseCounter() {
        counter.increaseCounter();
    }
}
