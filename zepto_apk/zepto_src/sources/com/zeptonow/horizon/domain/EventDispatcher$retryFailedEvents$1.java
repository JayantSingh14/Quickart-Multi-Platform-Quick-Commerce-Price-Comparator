package com.zeptonow.horizon.domain;

import com.zeptonow.horizon.entity.EventType;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.domain.EventDispatcher", f = "EventDispatcher.kt", l = {77, 80, 84, 88}, m = "retryFailedEvents")
/* loaded from: classes.dex */
final class EventDispatcher$retryFailedEvents$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public EventDispatcher f47955a;

    /* renamed from: b, reason: collision with root package name */
    public EventType f47956b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f47957c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ EventDispatcher f47958d;

    /* renamed from: e, reason: collision with root package name */
    public int f47959e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventDispatcher$retryFailedEvents$1(EventDispatcher eventDispatcher, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f47958d = eventDispatcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f47957c = obj;
        this.f47959e |= Integer.MIN_VALUE;
        return this.f47958d.a(null, this);
    }
}
