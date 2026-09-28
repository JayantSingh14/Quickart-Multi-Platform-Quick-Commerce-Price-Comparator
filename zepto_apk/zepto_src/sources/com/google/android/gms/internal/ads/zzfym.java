package com.google.android.gms.internal.ads;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.sync.MutexImpl;

/* loaded from: classes4.dex */
final class zzfym extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f32023a;

    /* renamed from: b, reason: collision with root package name */
    public MutexImpl f32024b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f32025c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzfza f32026d;

    /* renamed from: e, reason: collision with root package name */
    public int f32027e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfym(zzfza zzfzaVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f32026d = zzfzaVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f32025c = obj;
        this.f32027e |= Integer.MIN_VALUE;
        return this.f32026d.k(this);
    }
}
