package net.orgiu.flatfootsample.viewmodel;

import com.android.support.lifecycle.ViewModel;


public class CounterViewModel extends ViewModel{

    private int i = 0;

    public int getCounter() {
        return i;
    }

    public void increaseCounter() {
        i++;
    }
}
