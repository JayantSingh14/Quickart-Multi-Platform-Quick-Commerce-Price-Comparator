package com.zeptonow.horizon.domain;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.domain.EventProcessor", f = "EventProcessor.kt", l = {118}, m = "getBatchSize")
/* loaded from: classes.dex */
final class EventProcessor$getBatchSize$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public EventProcessor f48008a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f48009b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ EventProcessor f48010c;

    /* renamed from: d, reason: collision with root package name */
    public int f48011d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventProcessor$getBatchSize$1(EventProcessor eventProcessor, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f48010c = eventProcessor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f48009b = obj;
        this.f48011d |= Integer.MIN_VALUE;
        return this.f48010c.a(null, this);
    }
}
