package net.orgiu.flatfootsample.lifecycle;


import android.arch.lifecycle.LifecycleOwner;
import android.util.Log;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

public class SimpleLifecycleObserver implements LifecycleObserver {
    private static final String TAG = SimpleLifecycleObserver.class.getSimpleName();

    public static SimpleLifecycleObserver bindInto(LifecycleOwner provider) {
        return new SimpleLifecycleObserver(provider);
    }

    private SimpleLifecycleObserver(LifecycleOwner provider) {
        provider.getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.ON_START)
    public void callMeOnStart() {
        Log.d(TAG, "onStart() has been called!");
    }

    @OnLifecycleEvent(Lifecycle.ON_RESUME)
    public void callMeOnResume() {
        Log.d(TAG, "onResume() has been called!");
    }

    @OnLifecycleEvent(Lifecycle.ON_PAUSE)
    public void callMeOnPause() {
        Log.d(TAG, "onPause() has been called!");
    }

    @OnLifecycleEvent(Lifecycle.ON_STOP)
    public void calleMeOnStop() {
        Log.d(TAG, "onStop() has been called!");
    }
}
