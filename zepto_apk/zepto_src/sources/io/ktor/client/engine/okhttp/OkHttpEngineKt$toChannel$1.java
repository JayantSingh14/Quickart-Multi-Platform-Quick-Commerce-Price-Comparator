package io.ktor.client.engine.okhttp;

import io.ktor.client.request.HttpRequestData;
import io.ktor.utils.io.WriterScope;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.BufferedSource;

@Metadata
@DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngineKt$toChannel$1", f = "OkHttpEngine.kt", l = {155}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes.dex */
final class OkHttpEngineKt$toChannel$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Closeable f49409a;

    /* renamed from: b, reason: collision with root package name */
    public CoroutineContext f49410b;

    /* renamed from: c, reason: collision with root package name */
    public HttpRequestData f49411c;

    /* renamed from: d, reason: collision with root package name */
    public BufferedSource f49412d;

    /* renamed from: e, reason: collision with root package name */
    public Ref.IntRef f49413e;

    /* renamed from: f, reason: collision with root package name */
    public int f49414f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f49415g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ BufferedSource f49416h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ CoroutineContext f49417i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ HttpRequestData f49418j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpEngineKt$toChannel$1(BufferedSource bufferedSource, CoroutineContext coroutineContext, HttpRequestData httpRequestData, Continuation continuation) {
        super(2, continuation);
        this.f49416h = bufferedSource;
        this.f49417i = coroutineContext;
        this.f49418j = httpRequestData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        OkHttpEngineKt$toChannel$1 okHttpEngineKt$toChannel$1 = new OkHttpEngineKt$toChannel$1(this.f49416h, this.f49417i, this.f49418j, continuation);
        okHttpEngineKt$toChannel$1.f49415g = obj;
        return okHttpEngineKt$toChannel$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((OkHttpEngineKt$toChannel$1) create((WriterScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0044 A[Catch: all -> 0x001e, TryCatch #2 {all -> 0x001e, blocks: (B:6:0x001a, B:27:0x007b, B:15:0x003e, B:17:0x0044, B:19:0x004e, B:22:0x0056, B:24:0x005a, B:28:0x0083, B:13:0x0032), top: B:48:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.Closeable] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0078 -> B:27:0x007b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            r12 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r12.f49414f
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L29
            if (r1 != r2) goto L21
            kotlin.jvm.internal.Ref$IntRef r1 = r12.f49413e
            okio.BufferedSource r4 = r12.f49412d
            io.ktor.client.request.HttpRequestData r5 = r12.f49411c
            kotlin.coroutines.CoroutineContext r6 = r12.f49410b
            java.io.Closeable r7 = r12.f49409a
            java.io.Closeable r7 = (java.io.Closeable) r7
            java.lang.Object r8 = r12.f49415g
            io.ktor.utils.io.WriterScope r8 = (io.ktor.utils.io.WriterScope) r8
            kotlin.ResultKt.b(r13)     // Catch: java.lang.Throwable -> L1e
            goto L7b
        L1e:
            r13 = move-exception
            goto L8d
        L21:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L29:
            kotlin.ResultKt.b(r13)
            java.lang.Object r13 = r12.f49415g
            io.ktor.utils.io.WriterScope r13 = (io.ktor.utils.io.WriterScope) r13
            okio.BufferedSource r7 = r12.f49416h
            kotlin.jvm.internal.Ref$IntRef r1 = new kotlin.jvm.internal.Ref$IntRef     // Catch: java.lang.Throwable -> L1e
            r1.<init>()     // Catch: java.lang.Throwable -> L1e
            kotlin.coroutines.CoroutineContext r4 = r12.f49417i
            io.ktor.client.request.HttpRequestData r5 = r12.f49418j
            r8 = r13
            r6 = r4
            r4 = r7
        L3e:
            boolean r13 = r4.isOpen()     // Catch: java.lang.Throwable -> L1e
            if (r13 == 0) goto L83
            kotlinx.coroutines.Job$Key r13 = kotlinx.coroutines.Job.Key.f54121a     // Catch: java.lang.Throwable -> L1e
            kotlin.coroutines.CoroutineContext$Element r13 = r6.get(r13)     // Catch: java.lang.Throwable -> L1e
            kotlinx.coroutines.Job r13 = (kotlinx.coroutines.Job) r13     // Catch: java.lang.Throwable -> L1e
            if (r13 == 0) goto L53
            boolean r13 = r13.a()     // Catch: java.lang.Throwable -> L1e
            goto L54
        L53:
            r13 = r2
        L54:
            if (r13 == 0) goto L83
            int r13 = r1.f53799a     // Catch: java.lang.Throwable -> L1e
            if (r13 < 0) goto L83
            io.ktor.utils.io.ByteChannel r13 = r8.l0()     // Catch: java.lang.Throwable -> L1e
            io.ktor.client.engine.okhttp.OkHttpEngineKt$toChannel$1$1$1 r9 = new io.ktor.client.engine.okhttp.OkHttpEngineKt$toChannel$1$1$1     // Catch: java.lang.Throwable -> L1e
            r9.<init>()     // Catch: java.lang.Throwable -> L1e
            r12.f49415g = r8     // Catch: java.lang.Throwable -> L1e
            r10 = r7
            java.io.Closeable r10 = (java.io.Closeable) r10     // Catch: java.lang.Throwable -> L1e
            r12.f49409a = r10     // Catch: java.lang.Throwable -> L1e
            r12.f49410b = r6     // Catch: java.lang.Throwable -> L1e
            r12.f49411c = r5     // Catch: java.lang.Throwable -> L1e
            r12.f49412d = r4     // Catch: java.lang.Throwable -> L1e
            r12.f49413e = r1     // Catch: java.lang.Throwable -> L1e
            r12.f49414f = r2     // Catch: java.lang.Throwable -> L1e
            java.lang.Object r13 = r13.C(r2, r9, r12)     // Catch: java.lang.Throwable -> L1e
            if (r13 != r0) goto L7b
            return r0
        L7b:
            io.ktor.utils.io.ByteChannel r13 = r8.l0()     // Catch: java.lang.Throwable -> L1e
            r13.flush()     // Catch: java.lang.Throwable -> L1e
            goto L3e
        L83:
            kotlin.Unit r13 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L1e
            if (r7 == 0) goto L9a
            r7.close()     // Catch: java.lang.Throwable -> L8b
            goto L9a
        L8b:
            r3 = move-exception
            goto L9a
        L8d:
            if (r7 == 0) goto L97
            r7.close()     // Catch: java.lang.Throwable -> L93
            goto L97
        L93:
            r0 = move-exception
            kotlin.ExceptionsKt.a(r13, r0)
        L97:
            r11 = r3
            r3 = r13
            r13 = r11
        L9a:
            if (r3 != 0) goto La2
            kotlin.jvm.internal.Intrinsics.c(r13)
            kotlin.Unit r13 = kotlin.Unit.f53572a
            return r13
        La2:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.okhttp.OkHttpEngineKt$toChannel$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
