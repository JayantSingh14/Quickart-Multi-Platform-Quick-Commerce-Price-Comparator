package com.facebook.react.uimanager.events;

import com.facebook.react.fabric.events.FabricEventEmitter;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface EventDispatcher {
    void a();

    void b(BatchEventDispatchedListener batchEventDispatchedListener);

    void c();

    void d(EventDispatcherListener eventDispatcherListener);

    void e(EventDispatcherListener eventDispatcherListener);

    void f();

    void g(Event event);

    void h(BatchEventDispatchedListener batchEventDispatchedListener);

    void i(FabricEventEmitter fabricEventEmitter);

    void j(RCTEventEmitter rCTEventEmitter);
}
