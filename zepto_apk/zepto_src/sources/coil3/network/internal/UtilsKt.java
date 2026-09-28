package coil3.network.internal;

import androidx.fragment.app.e;
import coil3.disk.DiskCache;
import coil3.network.NetworkHeaders;
import coil3.network.NetworkResponse;
import coil3.network.NetworkResponseBody;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class UtilsKt {

    @NotNull
    public static final String CACHE_CONTROL = "Cache-Control";

    @NotNull
    public static final String CONTENT_TYPE = "Content-Type";

    @NotNull
    public static final String HTTP_METHOD_GET = "GET";
    public static final int HTTP_RESPONSE_NOT_MODIFIED = 304;
    public static final int HTTP_RESPONSE_OK = 200;

    @NotNull
    public static final String MIME_TYPE_TEXT_PLAIN = "text/plain";

    @Metadata
    @DebugMetadata(c = "coil3.network.internal.UtilsKt", f = "utils.kt", l = {31}, m = "readBuffer")
    /* renamed from: coil3.network.internal.UtilsKt$readBuffer$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
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
            return UtilsKt.readBuffer(null, this);
        }
    }

    public static final void abortQuietly(@NotNull DiskCache.Editor editor) {
        try {
            editor.abort();
        } catch (Exception unused) {
        }
    }

    @NotNull
    public static final NetworkHeaders.Builder append(@NotNull NetworkHeaders.Builder builder, @NotNull String str) {
        int iW = StringsKt.w(str, ':', 0, 6);
        if (iW == -1) {
            throw new IllegalArgumentException("Unexpected header: ".concat(str).toString());
        }
        String strSubstring = str.substring(0, iW);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String string = StringsKt.b0(strSubstring).toString();
        String strSubstring2 = str.substring(iW + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        builder.add(string, strSubstring2);
        return builder;
    }

    public static final void closeQuietly(@NotNull AutoCloseable autoCloseable) {
        try {
            e.z(autoCloseable);
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    @NotNull
    public static final NetworkHeaders plus(@NotNull NetworkHeaders networkHeaders, @NotNull NetworkHeaders networkHeaders2) {
        NetworkHeaders.Builder builderNewBuilder = networkHeaders.newBuilder();
        for (Map.Entry<String, List<String>> entry : networkHeaders2.asMap().entrySet()) {
            builderNewBuilder.set(entry.getKey(), entry.getValue());
        }
        return builderNewBuilder.build();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readBuffer(@org.jetbrains.annotations.NotNull coil3.network.NetworkResponseBody r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super okio.Buffer> r5) throws java.lang.Exception {
        /*
            boolean r0 = r5 instanceof coil3.network.internal.UtilsKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            coil3.network.internal.UtilsKt$readBuffer$1 r0 = (coil3.network.internal.UtilsKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            coil3.network.internal.UtilsKt$readBuffer$1 r0 = new coil3.network.internal.UtilsKt$readBuffer$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r4 = r0.L$1
            okio.Buffer r4 = (okio.Buffer) r4
            java.lang.Object r0 = r0.L$0
            java.lang.AutoCloseable r0 = (java.lang.AutoCloseable) r0
            kotlin.ResultKt.b(r5)     // Catch: java.lang.Throwable -> L2f
            goto L50
        L2f:
            r4 = move-exception
            goto L58
        L31:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L39:
            kotlin.ResultKt.b(r5)
            okio.Buffer r5 = new okio.Buffer     // Catch: java.lang.Throwable -> L55
            r5.<init>()     // Catch: java.lang.Throwable -> L55
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L55
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L55
            r0.label = r3     // Catch: java.lang.Throwable -> L55
            java.lang.Object r0 = r4.writeTo(r5, r0)     // Catch: java.lang.Throwable -> L55
            if (r0 != r1) goto L4e
            return r1
        L4e:
            r0 = r4
            r4 = r5
        L50:
            r5 = 0
            kotlin.jdk7.AutoCloseableKt.a(r0, r5)
            return r4
        L55:
            r5 = move-exception
            r0 = r4
            r4 = r5
        L58:
            throw r4     // Catch: java.lang.Throwable -> L59
        L59:
            r5 = move-exception
            kotlin.jdk7.AutoCloseableKt.a(r0, r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.network.internal.UtilsKt.readBuffer(coil3.network.NetworkResponseBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    public static final NetworkResponseBody requireBody(@NotNull NetworkResponse networkResponse) {
        NetworkResponseBody body = networkResponse.getBody();
        if (body != null) {
            return body;
        }
        throw new IllegalStateException("body == null");
    }
}
