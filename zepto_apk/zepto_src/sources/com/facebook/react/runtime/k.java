package com.facebook.react.runtime;

import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final /* synthetic */ class k implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        AtomicInteger atomicInteger = ReactHostImpl.A;
        ReactMarker.logMarker(ReactMarkerConstants.REACT_BRIDGELESS_LOADING_END, 1);
    }
}
