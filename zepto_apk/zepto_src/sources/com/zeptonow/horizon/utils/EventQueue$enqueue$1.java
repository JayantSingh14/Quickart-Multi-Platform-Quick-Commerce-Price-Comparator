package com.zeptonow.horizon.utils;

import com.zeptonow.horizon.entity.Event;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.sync.MutexImpl;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.utils.EventQueue", f = "EventQueue.kt", l = {85}, m = "enqueue")
/* loaded from: classes4.dex */
final class EventQueue$enqueue$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public EventQueue f48253a;

    /* renamed from: b, reason: collision with root package name */
    public Event f48254b;

    /* renamed from: c, reason: collision with root package name */
    public MutexImpl f48255c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f48256d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ EventQueue f48257e;

    /* renamed from: f, reason: collision with root package name */
    public int f48258f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventQueue$enqueue$1(EventQueue eventQueue, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f48257e = eventQueue;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f48256d = obj;
        this.f48258f |= Integer.MIN_VALUE;
        return this.f48257e.c(null, this);
    }
}
