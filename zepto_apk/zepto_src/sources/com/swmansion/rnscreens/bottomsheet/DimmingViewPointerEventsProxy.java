package com.swmansion.rnscreens.bottomsheet;

import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;
import kotlin.Metadata;

@Metadata
/* loaded from: classes4.dex */
public final class DimmingViewPointerEventsProxy implements ReactPointerEventsView {

    /* renamed from: a, reason: collision with root package name */
    public DimmingViewPointerEventsImpl f47099a;

    @Override // com.facebook.react.uimanager.ReactPointerEventsView
    public final PointerEvents getPointerEvents() {
        DimmingViewPointerEventsImpl dimmingViewPointerEventsImpl = this.f47099a;
        return dimmingViewPointerEventsImpl != null ? dimmingViewPointerEventsImpl.getPointerEvents() : PointerEvents.f19425b;
    }
}
