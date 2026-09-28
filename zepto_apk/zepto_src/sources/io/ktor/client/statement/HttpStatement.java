package io.ktor.client.statement;

import io.ktor.client.HttpClient;
import io.ktor.client.engine.HttpClientEngineCapabilityKt;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.client.request.HttpRequestBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class HttpStatement {

    /* renamed from: a, reason: collision with root package name */
    public final HttpRequestBuilder f50075a;

    /* renamed from: b, reason: collision with root package name */
    public final HttpClient f50076b;

    public HttpStatement(HttpRequestBuilder builder, HttpClient client) {
        Set setKeySet;
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(client, "client");
        this.f50075a = builder;
        this.f50076b = client;
        Map map = (Map) builder.f50008f.f(HttpClientEngineCapabilityKt.f49353a);
        if (map == null || (setKeySet = map.keySet()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (obj instanceof HttpClientPlugin) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            HttpClientPlugin httpClientPlugin = (HttpClientPlugin) it.next();
            if (HttpClientPluginKt.b(this.f50076b, httpClientPlugin) == null) {
                throw new IllegalArgumentException(("Consider installing " + httpClientPlugin + " plugin because the request requires it to be installed").toString());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(io.ktor.client.statement.HttpResponse r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.client.statement.HttpStatement$cleanup$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.client.statement.HttpStatement$cleanup$1 r0 = (io.ktor.client.statement.HttpStatement$cleanup$1) r0
            int r1 = r0.f50080d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50080d = r1
            goto L18
        L13:
            io.ktor.client.statement.HttpStatement$cleanup$1 r0 = new io.ktor.client.statement.HttpStatement$cleanup$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f50078b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50080d
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.b(r6)
            goto L5c
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            kotlin.ResultKt.b(r6)
            kotlin.coroutines.CoroutineContext r6 = r5.r()
            kotlinx.coroutines.Job$Key r2 = kotlinx.coroutines.Job.Key.f54121a
            kotlin.coroutines.CoroutineContext$Element r6 = r6.get(r2)
            kotlin.jvm.internal.Intrinsics.c(r6)
            kotlinx.coroutines.CompletableJob r6 = (kotlinx.coroutines.CompletableJob) r6
            r6.complete()
            io.ktor.utils.io.ByteReadChannel r5 = r5.a()     // Catch: java.lang.Throwable -> L51
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)     // Catch: java.lang.Throwable -> L51
            r2 = 0
            r5.l(r2)     // Catch: java.lang.Throwable -> L51
        L51:
            r0.f50077a = r6
            r0.f50080d = r3
            java.lang.Object r5 = r6.T0(r0)
            if (r5 != r1) goto L5c
            return r1
        L5c:
            kotlin.Unit r5 = kotlin.Unit.f53572a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpStatement.a(io.ktor.client.statement.HttpResponse, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final Object b(Continuation continuation) {
        return c(new HttpStatement$execute$4(2, null), (ContinuationImpl) continuation);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:57|(1:(1:(1:(1:(2:14|15)(3:16|17|50))(3:21|22|23))(5:24|53|25|42|(2:44|49)(1:45)))(2:29|30))(3:32|33|(2:35|49)(1:36))|37|55|38|(3:41|42|(0)(0))|49) */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0095, code lost:
    
        r10 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a0, code lost:
    
        if (r2.a(r11, r0) == r1) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(kotlin.jvm.functions.Function2 r10, kotlin.coroutines.jvm.internal.ContinuationImpl r11) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r11 instanceof io.ktor.client.statement.HttpStatement$execute$1
            if (r0 == 0) goto L13
            r0 = r11
            io.ktor.client.statement.HttpStatement$execute$1 r0 = (io.ktor.client.statement.HttpStatement$execute$1) r0
            int r1 = r0.f50085e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50085e = r1
            goto L18
        L13:
            io.ktor.client.statement.HttpStatement$execute$1 r0 = new io.ktor.client.statement.HttpStatement$execute$1
            r0.<init>(r9, r11)
        L18:
            java.lang.Object r11 = r0.f50083c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50085e
            r3 = 0
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r2 == 0) goto L64
            if (r2 == r7) goto L58
            if (r2 == r6) goto L47
            if (r2 == r5) goto L41
            if (r2 == r4) goto L35
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L35:
            java.lang.Object r10 = r0.f50081a
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            kotlin.ResultKt.b(r11)     // Catch: java.util.concurrent.CancellationException -> L3e
            goto La3
        L3e:
            r10 = move-exception
            goto La4
        L41:
            java.lang.Object r10 = r0.f50081a
            kotlin.ResultKt.b(r11)     // Catch: java.util.concurrent.CancellationException -> L3e
            return r10
        L47:
            java.lang.Object r10 = r0.f50082b
            io.ktor.client.statement.HttpResponse r10 = (io.ktor.client.statement.HttpResponse) r10
            java.lang.Object r2 = r0.f50081a
            io.ktor.client.statement.HttpStatement r2 = (io.ktor.client.statement.HttpStatement) r2
            kotlin.ResultKt.b(r11)     // Catch: java.lang.Throwable -> L53
            goto L87
        L53:
            r11 = move-exception
            r8 = r11
            r11 = r10
            r10 = r8
            goto L96
        L58:
            java.lang.Object r10 = r0.f50082b
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            java.lang.Object r2 = r0.f50081a
            io.ktor.client.statement.HttpStatement r2 = (io.ktor.client.statement.HttpStatement) r2
            kotlin.ResultKt.b(r11)     // Catch: java.util.concurrent.CancellationException -> L3e
            goto L75
        L64:
            kotlin.ResultKt.b(r11)
            r0.f50081a = r9     // Catch: java.util.concurrent.CancellationException -> L3e
            r0.f50082b = r10     // Catch: java.util.concurrent.CancellationException -> L3e
            r0.f50085e = r7     // Catch: java.util.concurrent.CancellationException -> L3e
            java.lang.Object r11 = r9.d(r0)     // Catch: java.util.concurrent.CancellationException -> L3e
            if (r11 != r1) goto L74
            goto La2
        L74:
            r2 = r9
        L75:
            io.ktor.client.statement.HttpResponse r11 = (io.ktor.client.statement.HttpResponse) r11     // Catch: java.util.concurrent.CancellationException -> L3e
            r0.f50081a = r2     // Catch: java.lang.Throwable -> L95
            r0.f50082b = r11     // Catch: java.lang.Throwable -> L95
            r0.f50085e = r6     // Catch: java.lang.Throwable -> L95
            java.lang.Object r10 = r10.invoke(r11, r0)     // Catch: java.lang.Throwable -> L95
            if (r10 != r1) goto L84
            goto La2
        L84:
            r8 = r11
            r11 = r10
            r10 = r8
        L87:
            r0.f50081a = r11     // Catch: java.util.concurrent.CancellationException -> L3e
            r0.f50082b = r3     // Catch: java.util.concurrent.CancellationException -> L3e
            r0.f50085e = r5     // Catch: java.util.concurrent.CancellationException -> L3e
            java.lang.Object r10 = r2.a(r10, r0)     // Catch: java.util.concurrent.CancellationException -> L3e
            if (r10 != r1) goto L94
            goto La2
        L94:
            return r11
        L95:
            r10 = move-exception
        L96:
            r0.f50081a = r10     // Catch: java.util.concurrent.CancellationException -> L3e
            r0.f50082b = r3     // Catch: java.util.concurrent.CancellationException -> L3e
            r0.f50085e = r4     // Catch: java.util.concurrent.CancellationException -> L3e
            java.lang.Object r11 = r2.a(r11, r0)     // Catch: java.util.concurrent.CancellationException -> L3e
            if (r11 != r1) goto La3
        La2:
            return r1
        La3:
            throw r10     // Catch: java.util.concurrent.CancellationException -> L3e
        La4:
            java.lang.Throwable r10 = io.ktor.client.utils.ExceptionUtilsJvmKt.a(r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpStatement.c(kotlin.jvm.functions.Function2, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(kotlin.coroutines.jvm.internal.ContinuationImpl r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.client.statement.HttpStatement$executeUnsafe$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.client.statement.HttpStatement$executeUnsafe$1 r0 = (io.ktor.client.statement.HttpStatement$executeUnsafe$1) r0
            int r1 = r0.f50090c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50090c = r1
            goto L18
        L13:
            io.ktor.client.statement.HttpStatement$executeUnsafe$1 r0 = new io.ktor.client.statement.HttpStatement$executeUnsafe$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f50088a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50090c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r6)     // Catch: java.util.concurrent.CancellationException -> L27
            goto L52
        L27:
            r6 = move-exception
            goto L59
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L31:
            kotlin.ResultKt.b(r6)
            io.ktor.client.request.HttpRequestBuilder r6 = new io.ktor.client.request.HttpRequestBuilder     // Catch: java.util.concurrent.CancellationException -> L27
            r6.<init>()     // Catch: java.util.concurrent.CancellationException -> L27
            io.ktor.client.request.HttpRequestBuilder r2 = r5.f50075a     // Catch: java.util.concurrent.CancellationException -> L27
            java.lang.String r4 = "builder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)     // Catch: java.util.concurrent.CancellationException -> L27
            kotlinx.coroutines.Job r4 = r2.f50007e     // Catch: java.util.concurrent.CancellationException -> L27
            r6.f50007e = r4     // Catch: java.util.concurrent.CancellationException -> L27
            r6.d(r2)     // Catch: java.util.concurrent.CancellationException -> L27
            io.ktor.client.HttpClient r2 = r5.f50076b     // Catch: java.util.concurrent.CancellationException -> L27
            r0.f50090c = r3     // Catch: java.util.concurrent.CancellationException -> L27
            java.lang.Object r6 = r2.a(r6, r0)     // Catch: java.util.concurrent.CancellationException -> L27
            if (r6 != r1) goto L52
            return r1
        L52:
            io.ktor.client.call.HttpClientCall r6 = (io.ktor.client.call.HttpClientCall) r6     // Catch: java.util.concurrent.CancellationException -> L27
            io.ktor.client.statement.HttpResponse r6 = r6.e()     // Catch: java.util.concurrent.CancellationException -> L27
            return r6
        L59:
            java.lang.Throwable r6 = io.ktor.client.utils.ExceptionUtilsJvmKt.a(r6)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpStatement.d(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final String toString() {
        return "HttpStatement[" + this.f50075a.f50003a + ']';
    }
}
