package com.google.android.gms.internal.ads;

import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes4.dex */
final class zzfyw extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f32059a;

    /* renamed from: b, reason: collision with root package name */
    public long f32060b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f32061c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzfza f32062d;

    /* renamed from: e, reason: collision with root package name */
    public int f32063e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfyw(zzfza zzfzaVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f32062d = zzfzaVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f32061c = obj;
        this.f32063e |= Integer.MIN_VALUE;
        return this.f32062d.f(this);
    }
}
