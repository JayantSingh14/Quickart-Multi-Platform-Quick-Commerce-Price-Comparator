package com.google.android.gms.internal.ads;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.sync.MutexImpl;

/* loaded from: classes4.dex */
final class zzfyf extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f32000a;

    /* renamed from: b, reason: collision with root package name */
    public MutexImpl f32001b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f32002c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzfza f32003d;

    /* renamed from: e, reason: collision with root package name */
    public int f32004e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfyf(zzfza zzfzaVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f32003d = zzfzaVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f32002c = obj;
        this.f32004e |= Integer.MIN_VALUE;
        return this.f32003d.h(null, this);
    }
}
