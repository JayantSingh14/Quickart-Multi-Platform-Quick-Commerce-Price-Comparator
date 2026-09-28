package com.google.android.gms.internal.ads;

import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes4.dex */
final class zzfys extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f32046a;

    /* renamed from: b, reason: collision with root package name */
    public long f32047b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f32048c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzfza f32049d;

    /* renamed from: e, reason: collision with root package name */
    public int f32050e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfys(zzfza zzfzaVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f32049d = zzfzaVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f32048c = obj;
        this.f32050e |= Integer.MIN_VALUE;
        return this.f32049d.e(this);
    }
}
