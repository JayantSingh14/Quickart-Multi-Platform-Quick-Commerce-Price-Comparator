package com.facebook.react.fabric;

import com.facebook.infer.annotation.Nullsafe;
import com.facebook.jni.HybridClassBase;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.fabric.mounting.LayoutMetricsConversions;
import com.facebook.react.interfaces.fabric.SurfaceHandler;

@Nullsafe
/* loaded from: classes3.dex */
public class SurfaceHandlerBinding extends HybridClassBase implements SurfaceHandler {
    public static final int DISPLAY_MODE_HIDDEN = 2;
    public static final int DISPLAY_MODE_SUSPENDED = 1;
    public static final int DISPLAY_MODE_VISIBLE = 0;
    private static final int NO_SURFACE_ID = 0;

    static {
        FabricSoLoader.staticInit();
    }

    public SurfaceHandlerBinding(String str) {
        initHybrid(0, str);
    }

    private native void initHybrid(int i2, String str);

    private native void setDisplayMode(int i2);

    private native void setLayoutConstraintsNative(float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2, float f8);

    @Override // com.facebook.react.interfaces.fabric.SurfaceHandler
    public native String getModuleName();

    @Override // com.facebook.react.interfaces.fabric.SurfaceHandler
    public native int getSurfaceId();

    @Override // com.facebook.react.interfaces.fabric.SurfaceHandler
    public native boolean isRunning();

    @Override // com.facebook.react.interfaces.fabric.SurfaceHandler
    public void setLayoutConstraints(int i2, int i3, int i4, int i5, boolean z, boolean z2, float f2) {
        setLayoutConstraintsNative(LayoutMetricsConversions.getMinSize(i2) / f2, LayoutMetricsConversions.getMaxSize(i2) / f2, LayoutMetricsConversions.getMinSize(i3) / f2, LayoutMetricsConversions.getMaxSize(i3) / f2, i4 / f2, i5 / f2, z, z2, f2);
    }

    @Override // com.facebook.react.interfaces.fabric.SurfaceHandler
    public void setMountable(boolean z) {
        setDisplayMode(!z ? 1 : 0);
    }

    @Override // com.facebook.react.interfaces.fabric.SurfaceHandler
    public native void setProps(NativeMap nativeMap);
}
