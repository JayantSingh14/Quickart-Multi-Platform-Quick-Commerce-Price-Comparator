package com.facebook.react.uimanager.events;

import com.facebook.common.logging.FLog;
import com.facebook.react.fabric.events.FabricEventEmitter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class BlackHoleEventDispatcher implements EventDispatcher {

    /* renamed from: a, reason: collision with root package name */
    public static final BlackHoleEventDispatcher f19706a = new BlackHoleEventDispatcher();

    @Metadata
    public static final class Companion {
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public final void a() {
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public final void b(BatchEventDispatchedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public final void c() {
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public final void d(EventDispatcherListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public final void e(EventDispatcherListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public final void g(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        FLog.a("BlackHoleEventDispatcher", "Trying to emit event to JS, but the React instance isn't ready. Event: " + event.getEventName());
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public final void h(BatchEventDispatchedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public final void i(FabricEventEmitter eventEmitter) {
        Intrinsics.checkNotNullParameter(eventEmitter, "eventEmitter");
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public final void j(RCTEventEmitter eventEmitter) {
        Intrinsics.checkNotNullParameter(eventEmitter, "eventEmitter");
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public final void f() {
    }
}
