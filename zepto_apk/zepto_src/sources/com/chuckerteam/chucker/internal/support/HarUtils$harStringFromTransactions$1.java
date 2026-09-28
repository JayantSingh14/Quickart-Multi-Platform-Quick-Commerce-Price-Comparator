package com.chuckerteam.chucker.internal.support;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "com.chuckerteam.chucker.internal.support.HarUtils", f = "HarUtils.kt", l = {17}, m = "harStringFromTransactions")
/* loaded from: classes3.dex */
final class HarUtils$harStringFromTransactions$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f16766a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HarUtils f16767b;

    /* renamed from: c, reason: collision with root package name */
    public int f16768c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HarUtils$harStringFromTransactions$1(HarUtils harUtils, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f16767b = harUtils;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16766a = obj;
        this.f16768c |= Integer.MIN_VALUE;
        return this.f16767b.a(null, null, null, this);
    }
}
