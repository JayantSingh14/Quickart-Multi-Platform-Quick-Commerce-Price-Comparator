package com.zeptonow.horizon.network;

import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.network.KtorNetworkClient$sendEvents$2", f = "KtorNetworkClient.kt", l = {179, 182}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes.dex */
final class KtorNetworkClient$sendEvents$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public KtorNetworkClient f48120a;

    /* renamed from: b, reason: collision with root package name */
    public int f48121b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f48122c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ KtorNetworkClient f48123d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KtorNetworkClient$sendEvents$2(List list, KtorNetworkClient ktorNetworkClient, Continuation continuation) {
        super(2, continuation);
        this.f48122c = list;
        this.f48123d = ktorNetworkClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new KtorNetworkClient$sendEvents$2(this.f48122c, this.f48123d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((KtorNetworkClient$sendEvents$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x01c8, code lost:
    
        if (r15 == r1) goto L65;
     */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b8  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 473
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptonow.horizon.network.KtorNetworkClient$sendEvents$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
