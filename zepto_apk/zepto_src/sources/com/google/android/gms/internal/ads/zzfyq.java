package com.google.android.gms.internal.ads;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.sync.MutexImpl;

/* loaded from: classes4.dex */
final class zzfyq extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public long f32039a;

    /* renamed from: b, reason: collision with root package name */
    public MutexImpl f32040b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f32041c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzfza f32042d;

    /* renamed from: e, reason: collision with root package name */
    public int f32043e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfyq(zzfza zzfzaVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f32042d = zzfzaVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f32041c = obj;
        this.f32043e |= Integer.MIN_VALUE;
        return this.f32042d.g(this);
    }
}
