package io.ktor.client.engine.okhttp;

import io.ktor.client.request.HttpRequestData;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngine", f = "OkHttpEngine.kt", l = {61, WKSRecord.Service.BOOTPC, 70}, m = "execute")
/* loaded from: classes.dex */
final class OkHttpEngine$execute$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public OkHttpEngine f49382a;

    /* renamed from: b, reason: collision with root package name */
    public HttpRequestData f49383b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f49384c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ OkHttpEngine f49385d;

    /* renamed from: e, reason: collision with root package name */
    public int f49386e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpEngine$execute$1(OkHttpEngine okHttpEngine, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f49385d = okHttpEngine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49384c = obj;
        this.f49386e |= Integer.MIN_VALUE;
        return this.f49385d.Q0(null, this);
    }
}
