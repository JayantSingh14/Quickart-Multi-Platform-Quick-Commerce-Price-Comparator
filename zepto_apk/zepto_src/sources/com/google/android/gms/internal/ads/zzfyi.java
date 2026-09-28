package com.google.android.gms.internal.ads;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.sync.Mutex;

/* loaded from: classes4.dex */
final class zzfyi extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Mutex f32012a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f32013b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzfza f32014c;

    /* renamed from: d, reason: collision with root package name */
    public int f32015d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfyi(zzfza zzfzaVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f32014c = zzfzaVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f32013b = obj;
        this.f32015d |= Integer.MIN_VALUE;
        return this.f32014c.i(this);
    }
}
