package com.facebook.react.runtime;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.infer.annotation.ThreadSafe;
import com.facebook.react.ReactHost;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.fabric.SurfaceHandlerBinding;
import com.facebook.react.interfaces.fabric.ReactSurface;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.runtime.internal.bolts.Task;
import com.facebook.react.uimanager.events.BlackHoleEventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcher;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

@Nullsafe
@ThreadSafe
/* loaded from: classes3.dex */
public class ReactSurfaceImpl implements ReactSurface {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f19278a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f19279b;

    /* renamed from: c, reason: collision with root package name */
    public final SurfaceHandlerBinding f19280c;

    /* renamed from: d, reason: collision with root package name */
    public Context f19281d;

    public ReactSurfaceImpl(Activity activity, String str, Bundle bundle) {
        SurfaceHandlerBinding surfaceHandlerBinding = new SurfaceHandlerBinding(str);
        this.f19278a = new AtomicReference(null);
        this.f19279b = new AtomicReference(null);
        this.f19280c = surfaceHandlerBinding;
        this.f19281d = activity;
        surfaceHandlerBinding.setProps(bundle == null ? new WritableNativeMap() : (NativeMap) Arguments.fromBundle(bundle));
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        surfaceHandlerBinding.setLayoutConstraints(View.MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels, Integer.MIN_VALUE), 0, 0, I18nUtil.a(activity), I18nUtil.b(activity), activity.getResources().getDisplayMetrics().density);
    }

    public final void a(ReactHost reactHost) {
        boolean z = reactHost instanceof ReactHostImpl;
        if (z) {
            AtomicReference atomicReference = this.f19279b;
            ReactHostImpl reactHostImpl = (ReactHostImpl) reactHost;
            while (!atomicReference.compareAndSet(null, reactHostImpl)) {
                if (atomicReference.get() != null) {
                    throw new IllegalStateException("This surface is already attached to a host!");
                }
            }
        }
        if (!z) {
            throw new IllegalArgumentException("ReactSurfaceImpl.attach can only attach to ReactHostImpl.");
        }
    }

    public final EventDispatcher b() {
        ReactHostImpl reactHostImpl = (ReactHostImpl) this.f19279b.get();
        if (reactHostImpl == null) {
            return null;
        }
        ReactInstance reactInstance = reactHostImpl.f19250l;
        return reactInstance == null ? BlackHoleEventDispatcher.f19706a : reactInstance.f19265d.getEventDispatcher();
    }

    public final synchronized void c(int i2, int i3, int i4, int i5) {
        this.f19280c.setLayoutConstraints(i2, i3, i4, i5, I18nUtil.a(this.f19281d), I18nUtil.b(this.f19281d), this.f19281d.getResources().getDisplayMetrics().density);
    }

    @Override // com.facebook.react.interfaces.fabric.ReactSurface
    public final ViewGroup getView() {
        return (ViewGroup) this.f19278a.get();
    }

    @Override // com.facebook.react.interfaces.fabric.ReactSurface
    public final Task start() {
        if (this.f19278a.get() == null) {
            return Task.d(new IllegalStateException("Trying to call ReactSurface.start(), but view is not created."));
        }
        ReactHostImpl reactHostImpl = (ReactHostImpl) this.f19279b.get();
        if (reactHostImpl == null) {
            return Task.d(new IllegalStateException("Trying to call ReactSurface.start(), but no ReactHost is attached."));
        }
        String str = "startSurface(surfaceId = " + this.f19280c.getSurfaceId() + ")";
        reactHostImpl.r(str, "Schedule");
        reactHostImpl.q("attachSurface(surfaceId = " + this.f19280c.getSurfaceId() + ")");
        synchronized (reactHostImpl.f19245g) {
            reactHostImpl.f19245g.add(this);
        }
        g gVar = new g(reactHostImpl, str, this, 0);
        Executor executor = reactHostImpl.f19243e;
        String strD = android.support.v4.media.b.D("callAfterGetOrCreateReactInstance(", str, ")");
        if (executor == null) {
            executor = ReactNativeFeatureFlags.f18968a.useImmediateExecutorInAndroidBridgeless() ? Task.f19311g : reactHostImpl.f19243e;
        }
        return Task.a(new a(reactHostImpl, 1), reactHostImpl.f19243e).c(new j(1), Task.f19311g).l(new b(reactHostImpl, strD, gVar, 1), executor).b(new i(reactHostImpl, 7));
    }

    @Override // com.facebook.react.interfaces.fabric.ReactSurface
    public final Task stop() {
        ReactHostImpl reactHostImpl = (ReactHostImpl) this.f19279b.get();
        if (reactHostImpl == null) {
            return Task.d(new IllegalStateException("Trying to call ReactSurface.stop(), but no ReactHost is attached."));
        }
        String str = "stopSurface(surfaceId = " + this.f19280c.getSurfaceId() + ")";
        reactHostImpl.r(str, "Schedule");
        reactHostImpl.q("detachSurface(surfaceId = " + this.f19280c.getSurfaceId() + ")");
        synchronized (reactHostImpl.f19245g) {
            reactHostImpl.f19245g.remove(this);
        }
        return reactHostImpl.k(str, new g(reactHostImpl, str, this, 1), reactHostImpl.f19243e).k();
    }
}
