package com.facebook.react.modules.debug;

import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class DidJSUpdateUiDuringFrameDetector implements NotThreadSafeBridgeIdleDebugListener, NotThreadSafeViewHierarchyUpdateDebugListener {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f19080a = new ArrayList(20);

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f19081b = new ArrayList(20);

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f19082c = new ArrayList(20);

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f19083d = new ArrayList(20);

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f19084e = true;

    @Override // com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener
    public final synchronized void a() {
        this.f19083d.add(Long.valueOf(System.nanoTime()));
    }

    @Override // com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener
    public final synchronized void b() {
        this.f19082c.add(Long.valueOf(System.nanoTime()));
    }

    @Override // com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener
    public final synchronized void onBridgeDestroyed() {
    }

    @Override // com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener
    public final synchronized void onTransitionToBridgeBusy() {
        this.f19081b.add(Long.valueOf(System.nanoTime()));
    }

    @Override // com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener
    public final synchronized void onTransitionToBridgeIdle() {
        this.f19080a.add(Long.valueOf(System.nanoTime()));
    }
}
