package com.google.android.gms.internal.ads;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.sync.MutexImpl;

/* loaded from: classes4.dex */
final class zzfyy extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public MutexImpl f32066a;

    /* renamed from: b, reason: collision with root package name */
    public long f32067b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f32068c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzfza f32069d;

    /* renamed from: e, reason: collision with root package name */
    public int f32070e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfyy(zzfza zzfzaVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f32069d = zzfzaVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f32068c = obj;
        this.f32070e |= Integer.MIN_VALUE;
        return this.f32069d.d(this);
    }
}
