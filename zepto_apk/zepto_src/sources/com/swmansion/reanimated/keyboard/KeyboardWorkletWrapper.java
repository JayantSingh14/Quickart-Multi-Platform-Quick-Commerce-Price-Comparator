package com.swmansion.reanimated.keyboard;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* loaded from: classes.dex */
public class KeyboardWorkletWrapper {

    @DoNotStrip
    private final HybridData mHybridData;

    @DoNotStrip
    private KeyboardWorkletWrapper(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    public native void invoke(int i2, int i3);
}
