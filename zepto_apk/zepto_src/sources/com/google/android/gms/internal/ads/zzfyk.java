package com.google.android.gms.internal.ads;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.sync.MutexImpl;

/* loaded from: classes4.dex */
final class zzfyk extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public MutexImpl f32016a;

    /* renamed from: b, reason: collision with root package name */
    public long f32017b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f32018c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzfza f32019d;

    /* renamed from: e, reason: collision with root package name */
    public int f32020e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfyk(zzfza zzfzaVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f32019d = zzfzaVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f32018c = obj;
        this.f32020e |= Integer.MIN_VALUE;
        return this.f32019d.c(this);
    }
}
