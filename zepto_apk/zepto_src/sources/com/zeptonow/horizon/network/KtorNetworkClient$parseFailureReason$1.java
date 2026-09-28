package com.zeptonow.horizon.network;

import io.ktor.client.plugins.ResponseException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.network.KtorNetworkClient", f = "KtorNetworkClient.kt", l = {94, 105}, m = "parseFailureReason")
/* loaded from: classes4.dex */
final class KtorNetworkClient$parseFailureReason$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ResponseException f48112a;

    /* renamed from: b, reason: collision with root package name */
    public StringBuilder f48113b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f48114c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ KtorNetworkClient f48115d;

    /* renamed from: e, reason: collision with root package name */
    public int f48116e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KtorNetworkClient$parseFailureReason$1(KtorNetworkClient ktorNetworkClient, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f48115d = ktorNetworkClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f48114c = obj;
        this.f48116e |= Integer.MIN_VALUE;
        return KtorNetworkClient.c(this.f48115d, null, this);
    }
}
