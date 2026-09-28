package com.google.android.gms.internal.ads;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.sync.Mutex;

/* loaded from: classes4.dex */
final class zzfyu extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Mutex f32053a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f32054b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzfza f32055c;

    /* renamed from: d, reason: collision with root package name */
    public int f32056d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfyu(zzfza zzfzaVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f32055c = zzfzaVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f32054b = obj;
        this.f32056d |= Integer.MIN_VALUE;
        return this.f32055c.a(this);
    }
}
