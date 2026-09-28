package com.swmansion.reanimated.layoutReanimation;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.soloader.SoLoader;
import com.swmansion.reanimated.ReanimatedModule;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes.dex */
public class LayoutAnimations {
    private final WeakReference<ReactApplicationContext> mContext;
    private WeakReference<AnimationsManager> mWeakAnimationsManager = new WeakReference<>(null);

    @DoNotStrip
    private final HybridData mHybridData = initHybrid();

    /* loaded from: classes4.dex */
    public static class Types {
        static final int ENTERING = 1;
        static final int EXITING = 2;
        static final int LAYOUT = 3;
        static final int SHARED_ELEMENT_TRANSITION = 4;
        static final int SHARED_ELEMENT_TRANSITION_PROGRESS = 5;
    }

    static {
        SoLoader.m("reanimated");
    }

    public LayoutAnimations(ReactApplicationContext reactApplicationContext) {
        this.mContext = new WeakReference<>(reactApplicationContext);
    }

    private void endLayoutAnimation(int i2, boolean z) {
        AnimationsManager animationsManager = getAnimationsManager();
        if (animationsManager == null) {
            return;
        }
        animationsManager.endLayoutAnimation(i2, z);
    }

    private AnimationsManager getAnimationsManager() {
        if (this.mWeakAnimationsManager.get() != null) {
            return this.mWeakAnimationsManager.get();
        }
        ReactApplicationContext reactApplicationContext = this.mContext.get();
        if (reactApplicationContext == null) {
            return null;
        }
        AnimationsManager animationsManager = ((ReanimatedModule) reactApplicationContext.getNativeModule(ReanimatedModule.class)).getNodesManager().getAnimationsManager();
        this.mWeakAnimationsManager = new WeakReference<>(animationsManager);
        return animationsManager;
    }

    private native HybridData initHybrid();

    private void progressLayoutAnimation(int i2, Map<String, Object> map, boolean z) {
        AnimationsManager animationsManager = getAnimationsManager();
        if (animationsManager == null) {
            return;
        }
        animationsManager.progressLayoutAnimation(i2, map, z);
    }

    public native void cancelAnimationForTag(int i2);

    public native void checkDuplicateSharedTag(int i2, int i3);

    public native void clearAnimationConfigForTag(int i2);

    public native int findPrecedingViewTagForTransition(int i2);

    public native int[] getSharedGroup(int i2);

    public native boolean hasAnimationForTag(int i2, int i3);

    public native boolean isLayoutAnimationEnabled();

    public native boolean shouldAnimateExiting(int i2, boolean z);

    public native void startAnimationForTag(int i2, int i3, Map<String, String> map);
}
