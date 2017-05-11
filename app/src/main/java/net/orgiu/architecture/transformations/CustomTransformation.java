package net.orgiu.architecture.transformations;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;

public class CustomTransformation {

    public static LiveData<String> customToString(LiveData<Integer> source) {
        MediatorLiveData<String> mediator = new MediatorLiveData<>();
        mediator.addSource(source, value -> mediator.setValue(String.valueOf(value)));
        return mediator;
    }
}
