package com.swmansion.reanimated.layoutReanimation;

import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.ViewManagerRegistry;
import com.facebook.yoga.YogaDirection;

/* loaded from: classes.dex */
public abstract class ReanimatedNativeHierarchyManagerBase extends NativeViewHierarchyManager {
    public ReanimatedNativeHierarchyManagerBase(ViewManagerRegistry viewManagerRegistry) {
        super(viewManagerRegistry);
    }

    @Override // com.facebook.react.uimanager.NativeViewHierarchyManager
    public synchronized void updateLayout(int i2, int i3, int i4, int i5, int i6, int i7, YogaDirection yogaDirection) throws Throwable {
        try {
            super.updateLayout(i2, i3, i4, i5, i6, i7, yogaDirection);
            updateLayoutCommon(i2, i3, i4, i5, i6, i7);
        } catch (Throwable th) {
            th = th;
            while (true) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
    }

    public abstract void updateLayoutCommon(int i2, int i3, int i4, int i5, int i6, int i7);
}
