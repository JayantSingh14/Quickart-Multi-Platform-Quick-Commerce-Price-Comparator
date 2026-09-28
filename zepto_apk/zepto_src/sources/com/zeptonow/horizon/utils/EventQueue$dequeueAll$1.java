package com.zeptonow.horizon.utils;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.sync.MutexImpl;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.utils.EventQueue", f = "EventQueue.kt", l = {85}, m = "dequeueAll")
/* loaded from: classes.dex */
final class EventQueue$dequeueAll$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public EventQueue f48248a;

    /* renamed from: b, reason: collision with root package name */
    public MutexImpl f48249b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f48250c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ EventQueue f48251d;

    /* renamed from: e, reason: collision with root package name */
    public int f48252e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventQueue$dequeueAll$1(EventQueue eventQueue, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f48251d = eventQueue;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f48250c = obj;
        this.f48252e |= Integer.MIN_VALUE;
        return this.f48251d.b(this);
    }
}
