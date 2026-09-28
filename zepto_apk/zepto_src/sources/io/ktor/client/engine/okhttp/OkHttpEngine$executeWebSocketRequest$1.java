package io.ktor.client.engine.okhttp;

import io.ktor.util.date.GMTDate;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngine", f = "OkHttpEngine.kt", l = {92}, m = "executeWebSocketRequest")
/* loaded from: classes3.dex */
final class OkHttpEngine$executeWebSocketRequest$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public OkHttpEngine f49395a;

    /* renamed from: b, reason: collision with root package name */
    public CoroutineContext f49396b;

    /* renamed from: c, reason: collision with root package name */
    public GMTDate f49397c;

    /* renamed from: d, reason: collision with root package name */
    public OkHttpWebsocketSession f49398d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f49399e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ OkHttpEngine f49400f;

    /* renamed from: g, reason: collision with root package name */
    public int f49401g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpEngine$executeWebSocketRequest$1(OkHttpEngine okHttpEngine, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f49400f = okHttpEngine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49399e = obj;
        this.f49401g |= Integer.MIN_VALUE;
        Lazy lazy = OkHttpEngine.f49372i;
        return this.f49400f.e(null, null, null, this);
    }
}
