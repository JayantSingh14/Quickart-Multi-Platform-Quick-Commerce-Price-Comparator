package coil3.network.okhttp.internal;

import coil3.network.NetworkClient;
import coil3.network.NetworkRequest;
import coil3.network.NetworkResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@JvmInline
/* loaded from: classes.dex */
public final class CallFactoryNetworkClient implements NetworkClient {

    @NotNull
    private final Call.Factory callFactory;

    @Metadata
    @DebugMetadata(c = "coil3.network.okhttp.internal.CallFactoryNetworkClient", f = "utils.kt", l = {24, 24, 25}, m = "executeRequest-impl")
    /* renamed from: coil3.network.okhttp.internal.CallFactoryNetworkClient$executeRequest$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends ContinuationImpl {
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
            return CallFactoryNetworkClient.m24executeRequestimpl(null, null, null, this);
        }
    }

    private /* synthetic */ CallFactoryNetworkClient(Call.Factory factory) {
        this.callFactory = factory;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ CallFactoryNetworkClient m20boximpl(Call.Factory factory) {
        return new CallFactoryNetworkClient(factory);
    }

    @NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static Call.Factory m21constructorimpl(@NotNull Call.Factory factory) {
        return factory;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m22equalsimpl(Call.Factory factory, Object obj) {
        return (obj instanceof CallFactoryNetworkClient) && Intrinsics.b(factory, ((CallFactoryNetworkClient) obj).m27unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m23equalsimpl0(Call.Factory factory, Call.Factory factory2) {
        return Intrinsics.b(factory, factory2);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: executeRequest-impl, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> java.lang.Object m24executeRequestimpl(okhttp3.Call.Factory r8, @org.jetbrains.annotations.NotNull coil3.network.NetworkRequest r9, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super coil3.network.NetworkResponse, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r11) {
        /*
            boolean r0 = r11 instanceof coil3.network.okhttp.internal.CallFactoryNetworkClient.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r11
            coil3.network.okhttp.internal.CallFactoryNetworkClient$executeRequest$1 r0 = (coil3.network.okhttp.internal.CallFactoryNetworkClient.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            coil3.network.okhttp.internal.CallFactoryNetworkClient$executeRequest$1 r0 = new coil3.network.okhttp.internal.CallFactoryNetworkClient$executeRequest$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L51
            if (r2 == r5) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r8 = r0.L$0
            java.io.Closeable r8 = (java.io.Closeable) r8
            kotlin.ResultKt.b(r11)     // Catch: java.lang.Throwable -> L32
            goto L8b
        L32:
            r9 = move-exception
            goto L93
        L34:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3c:
            java.lang.Object r8 = r0.L$0
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            kotlin.ResultKt.b(r11)
            goto L75
        L44:
            java.lang.Object r8 = r0.L$1
            okhttp3.Call$Factory r8 = (okhttp3.Call.Factory) r8
            java.lang.Object r9 = r0.L$0
            r10 = r9
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            kotlin.ResultKt.b(r11)
            goto L61
        L51:
            kotlin.ResultKt.b(r11)
            r0.L$0 = r10
            r0.L$1 = r8
            r0.label = r5
            java.lang.Object r11 = coil3.network.okhttp.internal.UtilsKt.access$toRequest(r9, r0)
            if (r11 != r1) goto L61
            goto L89
        L61:
            okhttp3.Request r11 = (okhttp3.Request) r11
            okhttp3.internal.connection.RealCall r8 = r8.a(r11)
            r0.L$0 = r10
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r11 = coil3.network.okhttp.internal.CallsKt.await(r8, r0)
            if (r11 != r1) goto L74
            goto L89
        L74:
            r8 = r10
        L75:
            r9 = r11
            java.io.Closeable r9 = (java.io.Closeable) r9
            r10 = r9
            okhttp3.Response r10 = (okhttp3.Response) r10     // Catch: java.lang.Throwable -> L8f
            coil3.network.NetworkResponse r10 = coil3.network.okhttp.internal.UtilsKt.access$toNetworkResponse(r10)     // Catch: java.lang.Throwable -> L8f
            r0.L$0 = r9     // Catch: java.lang.Throwable -> L8f
            r0.label = r3     // Catch: java.lang.Throwable -> L8f
            java.lang.Object r11 = r8.invoke(r10, r0)     // Catch: java.lang.Throwable -> L8f
            if (r11 != r1) goto L8a
        L89:
            return r1
        L8a:
            r8 = r9
        L8b:
            kotlin.io.CloseableKt.a(r8, r6)
            return r11
        L8f:
            r8 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
        L93:
            throw r9     // Catch: java.lang.Throwable -> L94
        L94:
            r10 = move-exception
            kotlin.io.CloseableKt.a(r8, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.network.okhttp.internal.CallFactoryNetworkClient.m24executeRequestimpl(okhttp3.Call$Factory, coil3.network.NetworkRequest, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m25hashCodeimpl(Call.Factory factory) {
        return factory.hashCode();
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m26toStringimpl(Call.Factory factory) {
        return "CallFactoryNetworkClient(callFactory=" + factory + ')';
    }

    public boolean equals(Object obj) {
        return m22equalsimpl(this.callFactory, obj);
    }

    @Override // coil3.network.NetworkClient
    @Nullable
    public <T> Object executeRequest(@NotNull NetworkRequest networkRequest, @NotNull Function2<? super NetworkResponse, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return m24executeRequestimpl(this.callFactory, networkRequest, function2, continuation);
    }

    public int hashCode() {
        return m25hashCodeimpl(this.callFactory);
    }

    public String toString() {
        return m26toStringimpl(this.callFactory);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Call.Factory m27unboximpl() {
        return this.callFactory;
    }
}
