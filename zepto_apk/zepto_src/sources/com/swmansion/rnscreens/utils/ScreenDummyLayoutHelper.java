package com.swmansion.rnscreens.utils;

import com.facebook.jni.annotations.DoNotStrip;
import com.facebook.react.bridge.LifecycleEventListener;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@DoNotStrip
@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class ScreenDummyLayoutHelper implements LifecycleEventListener {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f47152a = new Companion();

    /* renamed from: b, reason: collision with root package name */
    public static final WeakReference f47153b = new WeakReference(null);

    @Metadata
    public static final class Companion {
        @JvmStatic
        @DoNotStrip
        @Nullable
        public final ScreenDummyLayoutHelper getInstance() {
            return (ScreenDummyLayoutHelper) ScreenDummyLayoutHelper.f47153b.get();
        }
    }

    @DoNotStrip
    private final float computeDummyLayout(int i2, boolean z) {
        throw null;
    }

    @JvmStatic
    @DoNotStrip
    @Nullable
    public static final ScreenDummyLayoutHelper getInstance() {
        return f47152a.getInstance();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public final void onHostDestroy() {
        throw null;
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public final void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public final void onHostResume() {
        throw null;
    }
}
