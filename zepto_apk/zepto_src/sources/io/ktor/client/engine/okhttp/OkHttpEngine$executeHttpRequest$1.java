package io.ktor.client.engine.okhttp;

import io.ktor.client.request.HttpRequestData;
import io.ktor.util.date.GMTDate;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngine", f = "OkHttpEngine.kt", l = {103}, m = "executeHttpRequest")
/* loaded from: classes.dex */
final class OkHttpEngine$executeHttpRequest$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public OkHttpEngine f49387a;

    /* renamed from: b, reason: collision with root package name */
    public CoroutineContext f49388b;

    /* renamed from: c, reason: collision with root package name */
    public HttpRequestData f49389c;

    /* renamed from: d, reason: collision with root package name */
    public GMTDate f49390d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f49391e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ OkHttpEngine f49392f;

    /* renamed from: g, reason: collision with root package name */
    public int f49393g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpEngine$executeHttpRequest$1(OkHttpEngine okHttpEngine, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f49392f = okHttpEngine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49391e = obj;
        this.f49393g |= Integer.MIN_VALUE;
        Lazy lazy = OkHttpEngine.f49372i;
        return this.f49392f.c(null, null, null, null, this);
    }
}
