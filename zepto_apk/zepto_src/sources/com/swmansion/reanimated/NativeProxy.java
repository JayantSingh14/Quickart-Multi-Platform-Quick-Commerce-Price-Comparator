package com.swmansion.reanimated;

import androidx.annotation.OptIn;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.queue.MessageQueueThread;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.swmansion.reanimated.layoutReanimation.LayoutAnimations;
import com.swmansion.reanimated.layoutReanimation.NativeMethodsHolder;
import com.swmansion.reanimated.nativeProxy.NativeProxyCommon;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Objects;

/* loaded from: classes.dex */
public class NativeProxy extends NativeProxyCommon {

    @DoNotStrip
    private final HybridData mHybridData;

    @OptIn
    public NativeProxy(ReactApplicationContext reactApplicationContext, String str) {
        super(reactApplicationContext);
        CallInvokerHolderImpl callInvokerHolderImpl = (CallInvokerHolderImpl) reactApplicationContext.getJSCallInvokerHolder();
        LayoutAnimations layoutAnimations = new LayoutAnimations(reactApplicationContext);
        ReanimatedMessageQueueThread reanimatedMessageQueueThread = new ReanimatedMessageQueueThread();
        JavaScriptContextHolder javaScriptContextHolder = reactApplicationContext.getJavaScriptContextHolder();
        Objects.requireNonNull(javaScriptContextHolder);
        this.mHybridData = initHybrid(javaScriptContextHolder.get(), callInvokerHolderImpl, this.mAndroidUIScheduler, layoutAnimations, reanimatedMessageQueueThread, str);
        prepareLayoutAnimations(layoutAnimations);
        installJSIBindings();
    }

    public static NativeMethodsHolder createNativeMethodsHolder(LayoutAnimations layoutAnimations) {
        final WeakReference weakReference = new WeakReference(layoutAnimations);
        return new NativeMethodsHolder() { // from class: com.swmansion.reanimated.NativeProxy.1
            @Override // com.swmansion.reanimated.layoutReanimation.NativeMethodsHolder
            public void cancelAnimation(int i2) {
                LayoutAnimations layoutAnimations2 = (LayoutAnimations) weakReference.get();
                if (layoutAnimations2 != null) {
                    layoutAnimations2.cancelAnimationForTag(i2);
                }
            }

            @Override // com.swmansion.reanimated.layoutReanimation.NativeMethodsHolder
            public void checkDuplicateSharedTag(int i2, int i3) {
                LayoutAnimations layoutAnimations2 = (LayoutAnimations) weakReference.get();
                if (layoutAnimations2 != null) {
                    layoutAnimations2.checkDuplicateSharedTag(i2, i3);
                }
            }

            @Override // com.swmansion.reanimated.layoutReanimation.NativeMethodsHolder
            public void clearAnimationConfig(int i2) {
                LayoutAnimations layoutAnimations2 = (LayoutAnimations) weakReference.get();
                if (layoutAnimations2 != null) {
                    layoutAnimations2.clearAnimationConfigForTag(i2);
                }
            }

            @Override // com.swmansion.reanimated.layoutReanimation.NativeMethodsHolder
            public int findPrecedingViewTagForTransition(int i2) {
                LayoutAnimations layoutAnimations2 = (LayoutAnimations) weakReference.get();
                if (layoutAnimations2 != null) {
                    return layoutAnimations2.findPrecedingViewTagForTransition(i2);
                }
                return -1;
            }

            @Override // com.swmansion.reanimated.layoutReanimation.NativeMethodsHolder
            public int[] getSharedGroup(int i2) {
                LayoutAnimations layoutAnimations2 = (LayoutAnimations) weakReference.get();
                return layoutAnimations2 != null ? layoutAnimations2.getSharedGroup(i2) : new int[0];
            }

            @Override // com.swmansion.reanimated.layoutReanimation.NativeMethodsHolder
            public boolean hasAnimation(int i2, int i3) {
                LayoutAnimations layoutAnimations2 = (LayoutAnimations) weakReference.get();
                if (layoutAnimations2 != null) {
                    return layoutAnimations2.hasAnimationForTag(i2, i3);
                }
                return false;
            }

            @Override // com.swmansion.reanimated.layoutReanimation.NativeMethodsHolder
            public boolean isLayoutAnimationEnabled() {
                LayoutAnimations layoutAnimations2 = (LayoutAnimations) weakReference.get();
                if (layoutAnimations2 != null) {
                    return layoutAnimations2.isLayoutAnimationEnabled();
                }
                return false;
            }

            @Override // com.swmansion.reanimated.layoutReanimation.NativeMethodsHolder
            public boolean shouldAnimateExiting(int i2, boolean z) {
                LayoutAnimations layoutAnimations2 = (LayoutAnimations) weakReference.get();
                if (layoutAnimations2 != null) {
                    return layoutAnimations2.shouldAnimateExiting(i2, z);
                }
                return false;
            }

            @Override // com.swmansion.reanimated.layoutReanimation.NativeMethodsHolder
            public void startAnimation(int i2, int i3, HashMap<String, Object> map) {
                LayoutAnimations layoutAnimations2 = (LayoutAnimations) weakReference.get();
                if (layoutAnimations2 != null) {
                    HashMap map2 = new HashMap();
                    for (String str : map.keySet()) {
                        String string = map.get(str).toString();
                        if (str.endsWith("TransformMatrix")) {
                            map2.put(str, Utils.simplifyStringNumbersList(string));
                        } else {
                            map2.put(str, string);
                        }
                    }
                    layoutAnimations2.startAnimationForTag(i2, i3, map2);
                }
            }
        };
    }

    @OptIn
    private native HybridData initHybrid(long j2, CallInvokerHolderImpl callInvokerHolderImpl, AndroidUIScheduler androidUIScheduler, LayoutAnimations layoutAnimations, MessageQueueThread messageQueueThread, String str);

    @Override // com.swmansion.reanimated.nativeProxy.NativeProxyCommon
    public HybridData getHybridData() {
        return this.mHybridData;
    }

    public native boolean isAnyHandlerWaitingForEvent(String str, int i2);

    public native void performOperations();
}
