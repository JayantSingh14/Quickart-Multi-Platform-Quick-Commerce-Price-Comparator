package coil3.network.okhttp.internal;

import coil3.network.NetworkClientKt;
import coil3.network.NetworkHeaders;
import coil3.network.NetworkResponse;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class UtilsKt {

    @Metadata
    @DebugMetadata(c = "coil3.network.okhttp.internal.UtilsKt", f = "utils.kt", l = {39}, m = "readByteString")
    /* renamed from: coil3.network.okhttp.internal.UtilsKt$readByteString$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UtilsKt.readByteString(null, this);
        }
    }

    @Metadata
    @DebugMetadata(c = "coil3.network.okhttp.internal.UtilsKt", f = "utils.kt", l = {32}, m = "toRequest")
    /* renamed from: coil3.network.okhttp.internal.UtilsKt$toRequest$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00861 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C00861(Continuation<? super C00861> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UtilsKt.toRequest(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readByteString(coil3.network.NetworkRequestBody r4, kotlin.coroutines.Continuation<? super okio.ByteString> r5) {
        /*
            boolean r0 = r5 instanceof coil3.network.okhttp.internal.UtilsKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            coil3.network.okhttp.internal.UtilsKt$readByteString$1 r0 = (coil3.network.okhttp.internal.UtilsKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            coil3.network.okhttp.internal.UtilsKt$readByteString$1 r0 = new coil3.network.okhttp.internal.UtilsKt$readByteString$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r4 = r0.L$0
            okio.Buffer r4 = (okio.Buffer) r4
            kotlin.ResultKt.b(r5)
            goto L47
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.b(r5)
            okio.Buffer r5 = new okio.Buffer
            r5.<init>()
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r4 = r4.writeTo(r5, r0)
            if (r4 != r1) goto L46
            return r1
        L46:
            r4 = r5
        L47:
            long r0 = r4.f56914b
            okio.ByteString r4 = r4.s0(r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.network.okhttp.internal.UtilsKt.readByteString(coil3.network.NetworkRequestBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Headers toHeaders(NetworkHeaders networkHeaders) {
        Headers.Builder builder = new Headers.Builder();
        for (Map.Entry<String, List<String>> entry : networkHeaders.asMap().entrySet()) {
            String key = entry.getKey();
            Iterator<String> it = entry.getValue().iterator();
            while (it.hasNext()) {
                builder.d(key, it.next());
            }
        }
        return builder.e();
    }

    private static final NetworkHeaders toNetworkHeaders(Headers headers) {
        NetworkHeaders.Builder builder = new NetworkHeaders.Builder();
        Iterator<Pair<? extends String, ? extends String>> it = headers.iterator();
        while (it.hasNext()) {
            Pair<? extends String, ? extends String> next = it.next();
            builder.add((String) next.f53533a, (String) next.f53534b);
        }
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NetworkResponse toNetworkResponse(Response response) {
        BufferedSource bufferedSourceSource;
        int i2 = response.f56353d;
        NetworkHeaders networkHeaders = toNetworkHeaders(response.f56355f);
        ResponseBody responseBody = response.f56356g;
        return new NetworkResponse(i2, response.f56360k, response.f56361l, networkHeaders, (responseBody == null || (bufferedSourceSource = responseBody.source()) == null) ? null : NetworkClientKt.NetworkResponseBody(bufferedSourceSource), response);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object toRequest(coil3.network.NetworkRequest r6, kotlin.coroutines.Continuation<? super okhttp3.Request> r7) {
        /*
            boolean r0 = r7 instanceof coil3.network.okhttp.internal.UtilsKt.C00861
            if (r0 == 0) goto L13
            r0 = r7
            coil3.network.okhttp.internal.UtilsKt$toRequest$1 r0 = (coil3.network.okhttp.internal.UtilsKt.C00861) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            coil3.network.okhttp.internal.UtilsKt$toRequest$1 r0 = new coil3.network.okhttp.internal.UtilsKt$toRequest$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r6 = r0.L$3
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r1 = r0.L$2
            okhttp3.Request$Builder r1 = (okhttp3.Request.Builder) r1
            java.lang.Object r2 = r0.L$1
            okhttp3.Request$Builder r2 = (okhttp3.Request.Builder) r2
            java.lang.Object r0 = r0.L$0
            coil3.network.NetworkRequest r0 = (coil3.network.NetworkRequest) r0
            kotlin.ResultKt.b(r7)
            goto L6f
        L38:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L40:
            kotlin.ResultKt.b(r7)
            okhttp3.Request$Builder r7 = new okhttp3.Request$Builder
            r7.<init>()
            java.lang.String r2 = r6.getUrl()
            r7.i(r2)
            java.lang.String r2 = r6.getMethod()
            coil3.network.NetworkRequestBody r5 = r6.getBody()
            if (r5 == 0) goto L89
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r7
            r0.L$3 = r2
            r0.label = r3
            java.lang.Object r0 = readByteString(r5, r0)
            if (r0 != r1) goto L6a
            return r1
        L6a:
            r1 = r7
            r7 = r0
            r0 = r6
            r6 = r2
            r2 = r1
        L6f:
            okio.ByteString r7 = (okio.ByteString) r7
            if (r7 == 0) goto L84
            okhttp3.RequestBody$Companion r3 = okhttp3.RequestBody.Companion
            r3.getClass()
            java.lang.String r3 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r3)
            okhttp3.RequestBody$Companion$toRequestBody$1 r3 = new okhttp3.RequestBody$Companion$toRequestBody$1
            r3.<init>(r4, r7)
            r4 = r3
            goto L8f
        L84:
            r7 = r0
            r0 = r6
            r6 = r7
            r7 = r1
            goto L8b
        L89:
            r0 = r2
            r2 = r7
        L8b:
            r1 = r0
            r0 = r6
            r6 = r1
            r1 = r7
        L8f:
            r1.f(r6, r4)
            coil3.network.NetworkHeaders r6 = r0.getHeaders()
            okhttp3.Headers r6 = toHeaders(r6)
            r2.e(r6)
            okhttp3.Request r6 = r2.b()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.network.okhttp.internal.UtilsKt.toRequest(coil3.network.NetworkRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
