package com.google.android.gms.internal.ads;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.sync.MutexImpl;

/* loaded from: classes4.dex */
final class zzfyo extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public MutexImpl f32030a;

    /* renamed from: b, reason: collision with root package name */
    public long f32031b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f32032c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzfza f32033d;

    /* renamed from: e, reason: collision with root package name */
    public int f32034e;

    /* renamed from: f, reason: collision with root package name */
    public String f32035f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfyo(zzfza zzfzaVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f32033d = zzfzaVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f32032c = obj;
        this.f32034e |= Integer.MIN_VALUE;
        return this.f32033d.b(null, this);
    }
}
