package com.google.android.gms.internal.ads;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.sync.MutexImpl;

/* loaded from: classes4.dex */
final class zzfyh extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public long f32007a;

    /* renamed from: b, reason: collision with root package name */
    public MutexImpl f32008b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f32009c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzfza f32010d;

    /* renamed from: e, reason: collision with root package name */
    public int f32011e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfyh(zzfza zzfzaVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f32010d = zzfzaVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f32009c = obj;
        this.f32011e |= Integer.MIN_VALUE;
        return this.f32010d.j(0L, this);
    }
}
