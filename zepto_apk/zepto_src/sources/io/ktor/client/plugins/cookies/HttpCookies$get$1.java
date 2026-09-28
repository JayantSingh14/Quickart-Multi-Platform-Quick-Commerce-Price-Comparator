package io.ktor.client.plugins.cookies;

import io.ktor.http.Url;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.cookies.HttpCookies", f = "HttpCookies.kt", l = {39, 40}, m = "get")
/* loaded from: classes3.dex */
final class HttpCookies$get$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public HttpCookies f49920a;

    /* renamed from: b, reason: collision with root package name */
    public Url f49921b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f49922c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ HttpCookies f49923d;

    /* renamed from: e, reason: collision with root package name */
    public int f49924e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCookies$get$1(HttpCookies httpCookies, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f49923d = httpCookies;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49922c = obj;
        this.f49924e |= Integer.MIN_VALUE;
        return this.f49923d.b(null, this);
    }
}
