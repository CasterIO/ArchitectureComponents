package net.orgiu.architecture.transformations;


import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

public class CalculationViewModel extends ViewModel{

    private final MutableLiveData<String> inputName = new MutableLiveData<>();
    private final LiveData<Integer> nameCounting = Transformations.map(inputName, new Function<String, Integer>() {
        @Override
        public Integer apply(String s) {
            return s.length();
        }
    });

    public void setName(String name) {
        inputName.setValue(name);
    }

    LiveData<Integer> getCount() {
        return nameCounting;
    }
}
