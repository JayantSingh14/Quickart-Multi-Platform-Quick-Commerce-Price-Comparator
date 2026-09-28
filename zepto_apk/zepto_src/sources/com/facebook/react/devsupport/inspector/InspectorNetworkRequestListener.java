package com.facebook.react.devsupport.inspector;

import androidx.annotation.Nullable;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStripAny;
import java.util.Map;

@DoNotStripAny
/* loaded from: classes.dex */
public class InspectorNetworkRequestListener {
    private final HybridData mHybridData;

    public InspectorNetworkRequestListener(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    public native void onCompletion();

    public native void onData(String str);

    public native void onError(@Nullable String str);

    public native void onHeaders(int i2, Map<String, String> map);
}
