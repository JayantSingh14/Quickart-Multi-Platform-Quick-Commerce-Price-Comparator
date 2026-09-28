package com.swmansion.rnscreens.bottomsheet;

import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class DimmingViewPointerEventsImpl implements ReactPointerEventsView {

    /* renamed from: a, reason: collision with root package name */
    public final DimmingView f47098a;

    public DimmingViewPointerEventsImpl(DimmingView dimmingView) {
        Intrinsics.checkNotNullParameter(dimmingView, "dimmingView");
        this.f47098a = dimmingView;
    }

    @Override // com.facebook.react.uimanager.ReactPointerEventsView
    public final PointerEvents getPointerEvents() {
        return this.f47098a.getBlockGestures$react_native_screens_release() ? PointerEvents.f19428e : PointerEvents.f19425b;
    }
}
