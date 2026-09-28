package io.ktor.client.plugins.cookies;

import io.ktor.http.Url;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.cookies.HttpCookies", f = "HttpCookies.kt", l = {78}, m = "saveCookiesFrom$ktor_client_core")
/* loaded from: classes3.dex */
final class HttpCookies$saveCookiesFrom$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public HttpCookies f49929a;

    /* renamed from: b, reason: collision with root package name */
    public Url f49930b;

    /* renamed from: c, reason: collision with root package name */
    public Iterator f49931c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f49932d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ HttpCookies f49933e;

    /* renamed from: f, reason: collision with root package name */
    public int f49934f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCookies$saveCookiesFrom$1(HttpCookies httpCookies, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f49933e = httpCookies;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49932d = obj;
        this.f49934f |= Integer.MIN_VALUE;
        return this.f49933e.c(null, this);
    }
}
