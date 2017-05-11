package net.orgiu.architecture.transformations;

import android.arch.lifecycle.LiveData;


class BackToStringLiveData extends LiveData<String>{

    LiveData<String> fromInt(final int value) {
        setValue(String.valueOf(value));
        return this;
    }
}
