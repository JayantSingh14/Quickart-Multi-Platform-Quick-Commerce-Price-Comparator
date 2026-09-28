package io.ktor.client.plugins.cookies;

import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import java.io.Closeable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class HttpCookies implements Closeable, AutoCloseable {

    /* renamed from: d, reason: collision with root package name */
    public static final Companion f49898d = new Companion();

    /* renamed from: e, reason: collision with root package name */
    public static final AttributeKey f49899e = new AttributeKey("HttpCookies");

    /* renamed from: a, reason: collision with root package name */
    public final AcceptAllCookiesStorage f49900a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f49901b;

    /* renamed from: c, reason: collision with root package name */
    public final Job f49902c;

    @Metadata
    public static final class Companion implements HttpClientPlugin<Config, HttpCookies> {
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final void a(Object obj, HttpClient scope) {
            HttpCookies plugin = (HttpCookies) obj;
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            scope.f49262e.g(HttpRequestPipeline.f50018h, new HttpCookies$Companion$install$1(plugin, null));
            scope.f49264g.g(HttpSendPipeline.f50031h, new HttpCookies$Companion$install$2(plugin, null));
            scope.f49265h.g(HttpReceivePipeline.f50059h, new HttpCookies$Companion$install$3(plugin, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final Object b(Function1 block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Config config = new Config();
            block.invoke(config);
            return new HttpCookies(config.f49913b, config.f49912a);
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final AttributeKey getKey() {
            return HttpCookies.f49899e;
        }
    }

    @KtorDsl
    @Metadata
    public static final class Config {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f49912a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final AcceptAllCookiesStorage f49913b = new AcceptAllCookiesStorage();
    }

    public HttpCookies(AcceptAllCookiesStorage storage, ArrayList defaults) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(defaults, "defaults");
        this.f49900a = storage;
        this.f49901b = defaults;
        this.f49902c = BuildersKt.c(GlobalScope.f54113a, Dispatchers.f54092b, new HttpCookies$initializer$1(this, null), 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(io.ktor.client.request.HttpRequestBuilder r21, kotlin.coroutines.jvm.internal.ContinuationImpl r22) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.HttpCookies.a(io.ktor.client.request.HttpRequestBuilder, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(io.ktor.http.Url r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.client.plugins.cookies.HttpCookies$get$1
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.client.plugins.cookies.HttpCookies$get$1 r0 = (io.ktor.client.plugins.cookies.HttpCookies$get$1) r0
            int r1 = r0.f49924e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f49924e = r1
            goto L18
        L13:
            io.ktor.client.plugins.cookies.HttpCookies$get$1 r0 = new io.ktor.client.plugins.cookies.HttpCookies$get$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f49922c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f49924e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.b(r7)
            return r7
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            io.ktor.http.Url r6 = r0.f49921b
            io.ktor.client.plugins.cookies.HttpCookies r2 = r0.f49920a
            kotlin.ResultKt.b(r7)
            goto L4f
        L3a:
            kotlin.ResultKt.b(r7)
            kotlinx.coroutines.Job r7 = r5.f49902c
            r0.f49920a = r5
            r0.f49921b = r6
            r0.f49924e = r4
            kotlinx.coroutines.JobSupport r7 = (kotlinx.coroutines.JobSupport) r7
            java.lang.Object r7 = r7.T0(r0)
            if (r7 != r1) goto L4e
            goto L5e
        L4e:
            r2 = r5
        L4f:
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage r7 = r2.f49900a
            r2 = 0
            r0.f49920a = r2
            r0.f49921b = r2
            r0.f49924e = r3
            java.lang.Object r6 = r7.b(r6, r0)
            if (r6 != r1) goto L5f
        L5e:
            return r1
        L5f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.HttpCookies.b(io.ktor.http.Url, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r0v4, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r29v0 */
    /* JADX WARN: Type inference failed for: r29v1, types: [int] */
    /* JADX WARN: Type inference failed for: r29v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(io.ktor.client.statement.HttpResponse r39, kotlin.coroutines.jvm.internal.ContinuationImpl r40) throws java.lang.NumberFormatException, java.io.EOFException {
        /*
            Method dump skipped, instructions count: 1310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.HttpCookies.c(io.ktor.client.statement.HttpResponse, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f49900a.getClass();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(io.ktor.client.request.HttpRequestBuilder r9, kotlin.coroutines.jvm.internal.ContinuationImpl r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof io.ktor.client.plugins.cookies.HttpCookies$sendCookiesWith$1
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.client.plugins.cookies.HttpCookies$sendCookiesWith$1 r0 = (io.ktor.client.plugins.cookies.HttpCookies$sendCookiesWith$1) r0
            int r1 = r0.f49938d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f49938d = r1
            goto L18
        L13:
            io.ktor.client.plugins.cookies.HttpCookies$sendCookiesWith$1 r0 = new io.ktor.client.plugins.cookies.HttpCookies$sendCookiesWith$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.f49936b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f49938d
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            io.ktor.client.request.HttpRequestBuilder r9 = r0.f49935a
            kotlin.ResultKt.b(r10)
            goto L53
        L29:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L31:
            kotlin.ResultKt.b(r10)
            io.ktor.http.URLBuilder r10 = r9.f50003a
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r2)
            io.ktor.http.URLBuilder r2 = new io.ktor.http.URLBuilder
            r4 = 0
            r2.<init>(r4)
            io.ktor.http.URLUtilsKt.b(r2, r10)
            io.ktor.http.Url r10 = r2.b()
            r0.f49935a = r9
            r0.f49938d = r3
            java.lang.Object r10 = r8.b(r10, r0)
            if (r10 != r1) goto L53
            return r1
        L53:
            java.util.List r10 = (java.util.List) r10
            r0 = r10
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            java.lang.String r1 = "Cookie"
            if (r0 != 0) goto La6
            org.slf4j.Logger r0 = io.ktor.client.plugins.cookies.HttpCookiesKt.f49939a
            r2 = r10
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            io.ktor.client.plugins.cookies.HttpCookiesKt$renderClientCookies$1 r6 = io.ktor.client.plugins.cookies.HttpCookiesKt$renderClientCookies$1.f49944b
            r4 = 0
            r5 = 0
            java.lang.String r3 = "; "
            r7 = 30
            java.lang.String r10 = kotlin.collections.CollectionsKt.E(r2, r3, r4, r5, r6, r7)
            io.ktor.http.HeadersBuilder r0 = r9.f50005c
            java.util.List r2 = io.ktor.http.HttpHeaders.f50204a
            r0.getClass()
            java.lang.String r2 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r2)
            r0.k(r10)
            java.util.List r0 = r0.g(r1)
            r0.clear()
            r0.add(r10)
            org.slf4j.Logger r0 = io.ktor.client.plugins.cookies.HttpCookiesKt.f49939a
            java.lang.String r1 = "Sending cookie "
            java.lang.String r2 = " for "
            java.lang.StringBuilder r10 = android.support.v4.media.b.y(r1, r10, r2)
            io.ktor.http.URLBuilder r9 = r9.f50003a
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r0.r(r9)
            goto Lad
        La6:
            io.ktor.http.HeadersBuilder r9 = r9.f50005c
            java.util.List r10 = io.ktor.http.HttpHeaders.f50204a
            r9.i(r1)
        Lad:
            kotlin.Unit r9 = kotlin.Unit.f53572a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.HttpCookies.e(io.ktor.client.request.HttpRequestBuilder, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
