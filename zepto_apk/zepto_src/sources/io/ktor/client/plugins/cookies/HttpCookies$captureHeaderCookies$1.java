package io.ktor.client.plugins.cookies;

import io.ktor.http.Url;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.cookies.HttpCookies", f = "HttpCookies.kt", l = {54}, m = "captureHeaderCookies$ktor_client_core")
/* loaded from: classes3.dex */
final class HttpCookies$captureHeaderCookies$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public HttpCookies f49914a;

    /* renamed from: b, reason: collision with root package name */
    public Url f49915b;

    /* renamed from: c, reason: collision with root package name */
    public Iterator f49916c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f49917d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ HttpCookies f49918e;

    /* renamed from: f, reason: collision with root package name */
    public int f49919f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCookies$captureHeaderCookies$1(HttpCookies httpCookies, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f49918e = httpCookies;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49917d = obj;
        this.f49919f |= Integer.MIN_VALUE;
        return this.f49918e.a(null, this);
    }
}
