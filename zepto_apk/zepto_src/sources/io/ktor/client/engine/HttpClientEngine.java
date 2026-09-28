package io.ktor.client.engine;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestData;
import java.io.Closeable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

@Metadata
/* loaded from: classes.dex */
public interface HttpClientEngine extends CoroutineScope, Closeable {

    @Metadata
    @SourceDebugExtension
    public static final class DefaultImpls {
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static final java.lang.Object a(io.ktor.client.engine.HttpClientEngine r7, io.ktor.client.request.HttpRequestData r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) {
            /*
                boolean r0 = r9 instanceof io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1
                if (r0 == 0) goto L13
                r0 = r9
                io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1 r0 = (io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1) r0
                int r1 = r0.f49338d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f49338d = r1
                goto L18
            L13:
                io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1 r0 = new io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1
                r0.<init>(r9)
            L18:
                java.lang.Object r9 = r0.f49337c
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
                int r2 = r0.f49338d
                r3 = 1
                r4 = 2
                if (r2 == 0) goto L3a
                if (r2 == r3) goto L32
                if (r2 != r4) goto L2a
                kotlin.ResultKt.b(r9)
                return r9
            L2a:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L32:
                io.ktor.client.request.HttpRequestData r8 = r0.f49336b
                io.ktor.client.engine.HttpClientEngine r7 = r0.f49335a
                kotlin.ResultKt.b(r9)
                goto L7d
            L3a:
                kotlin.ResultKt.b(r9)
                kotlinx.coroutines.Job r9 = r8.f50014e
                r0.f49335a = r7
                r0.f49336b = r8
                r0.f49338d = r3
                kotlinx.coroutines.CoroutineName r2 = io.ktor.client.engine.HttpClientEngineKt.f49354a
                kotlinx.coroutines.JobImpl r2 = new kotlinx.coroutines.JobImpl
                r2.<init>(r9)
                kotlin.coroutines.CoroutineContext r9 = r7.r()
                kotlin.coroutines.CoroutineContext r9 = r9.plus(r2)
                kotlinx.coroutines.CoroutineName r5 = io.ktor.client.engine.HttpClientEngineKt.f49354a
                kotlin.coroutines.CoroutineContext r9 = r9.plus(r5)
                kotlin.coroutines.CoroutineContext r5 = r0.getContext()
                kotlinx.coroutines.Job$Key r6 = kotlinx.coroutines.Job.Key.f54121a
                kotlin.coroutines.CoroutineContext$Element r5 = r5.get(r6)
                kotlinx.coroutines.Job r5 = (kotlinx.coroutines.Job) r5
                if (r5 != 0) goto L69
                goto L7a
            L69:
                io.ktor.client.engine.UtilsKt$attachToUserJob$cleanupHandler$1 r6 = new io.ktor.client.engine.UtilsKt$attachToUserJob$cleanupHandler$1
                r6.<init>()
                kotlinx.coroutines.DisposableHandle r3 = r5.D(r3, r3, r6)
                io.ktor.client.engine.UtilsKt$attachToUserJob$2 r5 = new io.ktor.client.engine.UtilsKt$attachToUserJob$2
                r5.<init>()
                r2.j0(r5)
            L7a:
                if (r9 != r1) goto L7d
                goto L9e
            L7d:
                kotlin.coroutines.CoroutineContext r9 = (kotlin.coroutines.CoroutineContext) r9
                io.ktor.client.engine.KtorCallContextElement r2 = new io.ktor.client.engine.KtorCallContextElement
                r2.<init>(r9)
                kotlin.coroutines.CoroutineContext r9 = r9.plus(r2)
                io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$2 r2 = new io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$2
                r3 = 0
                r2.<init>(r7, r8, r3)
                kotlinx.coroutines.Deferred r7 = kotlinx.coroutines.BuildersKt.a(r7, r9, r2, r4)
                r0.f49335a = r3
                r0.f49336b = r3
                r0.f49338d = r4
                java.lang.Object r7 = r7.V(r0)
                if (r7 != r1) goto L9f
            L9e:
                return r1
            L9f:
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.HttpClientEngine.DefaultImpls.a(io.ktor.client.engine.HttpClientEngine, io.ktor.client.request.HttpRequestData, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
        }
    }

    void K1(HttpClient httpClient);

    Object Q0(HttpRequestData httpRequestData, ContinuationImpl continuationImpl);

    Set Z0();
}
