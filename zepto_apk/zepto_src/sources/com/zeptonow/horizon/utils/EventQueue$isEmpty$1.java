package com.zeptonow.horizon.utils;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.utils.EventQueue", f = "EventQueue.kt", l = {85}, m = "isEmpty")
/* loaded from: classes4.dex */
final class EventQueue$isEmpty$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f48259a;

    /* renamed from: b, reason: collision with root package name */
    public int f48260b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f48259a = obj;
        this.f48260b |= Integer.MIN_VALUE;
        throw null;
    }
}
