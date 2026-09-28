package com.zeptonow.horizon.utils;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.sync.MutexImpl;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.utils.EventQueue", f = "EventQueue.kt", l = {85}, m = "clear")
/* loaded from: classes.dex */
final class EventQueue$clear$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public EventQueue f48243a;

    /* renamed from: b, reason: collision with root package name */
    public MutexImpl f48244b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f48245c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ EventQueue f48246d;

    /* renamed from: e, reason: collision with root package name */
    public int f48247e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventQueue$clear$1(EventQueue eventQueue, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f48246d = eventQueue;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f48245c = obj;
        this.f48247e |= Integer.MIN_VALUE;
        return this.f48246d.a(this);
    }
}
