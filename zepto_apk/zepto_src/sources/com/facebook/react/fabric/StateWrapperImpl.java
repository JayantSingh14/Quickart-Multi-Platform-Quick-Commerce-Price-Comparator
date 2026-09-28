package com.facebook.react.fabric;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.jni.HybridClassBase;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.mapbuffer.ReadableMapBuffer;
import com.facebook.react.uimanager.StateWrapper;

@DoNotStrip
@SuppressLint({"MissingNativeLoadLibrary"})
@Nullsafe
/* loaded from: classes3.dex */
public class StateWrapperImpl extends HybridClassBase implements StateWrapper {
    private static final String TAG = "StateWrapperImpl";

    static {
        FabricSoLoader.staticInit();
    }

    private StateWrapperImpl() {
        initHybrid();
    }

    private native ReadableNativeMap getStateDataImpl();

    private native ReadableMapBuffer getStateMapBufferDataImpl();

    private native void initHybrid();

    @Override // com.facebook.react.uimanager.StateWrapper
    public void destroyState() {
        if (isValid()) {
            resetNative();
        }
    }

    @Nullable
    public ReadableNativeMap getStateData() {
        if (isValid()) {
            return getStateDataImpl();
        }
        FLog.g(TAG, "Race between StateWrapperImpl destruction and getState");
        return null;
    }

    @Override // com.facebook.react.uimanager.StateWrapper
    @Nullable
    public ReadableMapBuffer getStateDataMapBuffer() {
        if (isValid()) {
            return getStateMapBufferDataImpl();
        }
        FLog.g(TAG, "Race between StateWrapperImpl destruction and getState");
        return null;
    }

    public String toString() {
        if (!isValid()) {
            return "<destroyed>";
        }
        ReadableMapBuffer stateMapBufferDataImpl = getStateMapBufferDataImpl();
        if (stateMapBufferDataImpl != null) {
            return stateMapBufferDataImpl.toString();
        }
        ReadableNativeMap stateDataImpl = getStateDataImpl();
        return stateDataImpl == null ? "<unexpected null>" : stateDataImpl.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.StateWrapper
    public void updateState(@NonNull WritableMap writableMap) {
        if (isValid()) {
            updateStateImpl((NativeMap) writableMap);
        } else {
            FLog.g(TAG, "Race between StateWrapperImpl destruction and updateState");
        }
    }

    public native void updateStateImpl(@NonNull NativeMap nativeMap);
}
