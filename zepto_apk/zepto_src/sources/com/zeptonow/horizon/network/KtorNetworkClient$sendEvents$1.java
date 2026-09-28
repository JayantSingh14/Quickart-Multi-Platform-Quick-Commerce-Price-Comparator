package com.zeptonow.horizon.network;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.network.KtorNetworkClient", f = "KtorNetworkClient.kt", l = {42}, m = "sendEvents-gIAlu-s")
/* loaded from: classes.dex */
final class KtorNetworkClient$sendEvents$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f48117a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ KtorNetworkClient f48118b;

    /* renamed from: c, reason: collision with root package name */
    public int f48119c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KtorNetworkClient$sendEvents$1(KtorNetworkClient ktorNetworkClient, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f48118b = ktorNetworkClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f48117a = obj;
        this.f48119c |= Integer.MIN_VALUE;
        Object objB = this.f48118b.b(null, this);
        return objB == CoroutineSingletons.f53689a ? objB : new Result(objB);
    }
}
