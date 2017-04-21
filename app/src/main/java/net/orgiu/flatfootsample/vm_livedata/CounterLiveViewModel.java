package net.orgiu.flatfootsample.vm_livedata;

import com.android.support.lifecycle.LiveData;
import com.android.support.lifecycle.ViewModel;


public class CounterLiveViewModel extends ViewModel{

    private final LiveData<Integer> counter = new LiveData<>();

    public LiveData<Integer> getCounter() {
        if(counter.getValue() == null) {
            counter.setValue(0);
        }

        return counter;
    }

    public void increaseCounter() {
        counter.setValue(safelyIncreaseCurrentValue());
    }

    private Integer safelyIncreaseCurrentValue() {
        Integer currentValue = counter.getValue();
        if (currentValue == null) {
            currentValue = 0;
        }

        return currentValue + 1;
    }
}
