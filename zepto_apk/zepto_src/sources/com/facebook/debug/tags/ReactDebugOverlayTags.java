package com.facebook.debug.tags;

import android.graphics.Color;
import com.facebook.debug.debugoverlay.model.DebugOverlayTag;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class ReactDebugOverlayTags {

    /* renamed from: a, reason: collision with root package name */
    public static final DebugOverlayTag f17190a;

    /* renamed from: b, reason: collision with root package name */
    public static final DebugOverlayTag f17191b;

    /* renamed from: c, reason: collision with root package name */
    public static final DebugOverlayTag f17192c;

    /* renamed from: d, reason: collision with root package name */
    public static final DebugOverlayTag f17193d;

    static {
        new DebugOverlayTag("Performance", "Markers for Performance");
        Color.rgb(156, 39, 176);
        new DebugOverlayTag("Navigation", "Tag for navigation");
        f17190a = new DebugOverlayTag("RN Core", "Tag for React Native Core");
        f17191b = new DebugOverlayTag("Bridge Calls", "JS to Java calls (warning: this is spammy)");
        Color.rgb(128, 0, 128);
        f17192c = new DebugOverlayTag("Native Module", "Native Module init");
        f17193d = new DebugOverlayTag("UI Manager", "UI Manager View Operations (requires restart\nwarning: this is spammy)");
        new DebugOverlayTag("FabricUIManager", "Fabric UI Manager View Operations");
        new DebugOverlayTag("FabricReconciler", "Reconciler for Fabric");
        Color.rgb(255, 153, 0);
        new DebugOverlayTag("Relay", "including prefetching");
    }
}
