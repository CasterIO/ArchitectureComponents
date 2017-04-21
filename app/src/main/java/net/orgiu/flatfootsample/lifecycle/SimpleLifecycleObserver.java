package net.orgiu.flatfootsample.lifecycle;


import android.util.Log;

import com.android.support.lifecycle.Lifecycle;
import com.android.support.lifecycle.LifecycleObserver;
import com.android.support.lifecycle.LifecycleProvider;
import com.android.support.lifecycle.OnLifecycleEvent;

public class SimpleLifecycleObserver implements LifecycleObserver {
    private static final String TAG = SimpleLifecycleObserver.class.getSimpleName();

    public static SimpleLifecycleObserver bindInto(LifecycleProvider provider) {
        return new SimpleLifecycleObserver(provider);
    }

    private SimpleLifecycleObserver(LifecycleProvider provider) {
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