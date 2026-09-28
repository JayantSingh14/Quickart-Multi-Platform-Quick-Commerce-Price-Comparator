package com.zeptoconsumerapp.prefetchmodule;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.zeptoconsumerapp.Startup.AppCoroutineManager;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.internal.ContextScope;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.Type;
import timber.log.Timber;

@Metadata
/* loaded from: classes.dex */
public final class LayoutPrefetchModule extends ReactContextBaseJavaModule {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    private static final String MODULE_NAME = "LayoutPrefetchModule";
    private static final long POLL_INTERVAL_MS = 50;

    @NotNull
    private static final String TAG = "PREFETCHLOGIC";
    private static final long TIMEOUT_MS = 4000;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    @DebugMetadata(c = "com.zeptoconsumerapp.prefetchmodule.LayoutPrefetchModule$awaitAndGetPrefetchResult$1", f = "LayoutPrefetchModule.kt", l = {Type.DNSKEY}, m = "invokeSuspend")
    /* renamed from: com.zeptoconsumerapp.prefetchmodule.LayoutPrefetchModule$awaitAndGetPrefetchResult$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f47792a;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f47794c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Promise f47795d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, Promise promise, Continuation continuation) {
            super(2, continuation);
            this.f47794c = str;
            this.f47795d = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return LayoutPrefetchModule.this.new AnonymousClass1(this.f47794c, this.f47795d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            int i2 = this.f47792a;
            Promise promise = this.f47795d;
            try {
                if (i2 == 0) {
                    ResultKt.b(obj);
                    LayoutPrefetchModule layoutPrefetchModule = LayoutPrefetchModule.this;
                    String str = this.f47794c;
                    this.f47792a = 1;
                    obj = layoutPrefetchModule.awaitApiResult(str, LayoutPrefetchModule.TIMEOUT_MS, this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                promise.resolve((WritableMap) obj);
            } catch (Exception e2) {
                Timber.d(LayoutPrefetchModule.TAG).e(e2, "PREFETCHLOGIC Error waiting for result", new Object[0]);
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putString(CLConstants.OTP_STATUS, "error");
                writableMapCreateMap.putString("error", "Unexpected error: " + e2.getMessage());
                promise.resolve(writableMapCreateMap);
            }
            return Unit.f53572a;
        }
    }

    @Metadata
    @DebugMetadata(c = "com.zeptoconsumerapp.prefetchmodule.LayoutPrefetchModule", f = "LayoutPrefetchModule.kt", l = {71}, m = "awaitApiResult")
    /* renamed from: com.zeptoconsumerapp.prefetchmodule.LayoutPrefetchModule$awaitApiResult$1, reason: invalid class name and case insensitive filesystem */
    /* loaded from: classes4.dex */
    public static final class C01011 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public String f47796a;

        /* renamed from: b, reason: collision with root package name */
        public long f47797b;

        /* renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f47798c;

        /* renamed from: e, reason: collision with root package name */
        public int f47800e;

        public C01011(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f47798c = obj;
            this.f47800e |= Integer.MIN_VALUE;
            return LayoutPrefetchModule.this.awaitApiResult(null, 0L, this);
        }
    }

    @Metadata
    @DebugMetadata(c = "com.zeptoconsumerapp.prefetchmodule.LayoutPrefetchModule$awaitApiResult$2", f = "LayoutPrefetchModule.kt", l = {105}, m = "invokeSuspend")
    /* renamed from: com.zeptoconsumerapp.prefetchmodule.LayoutPrefetchModule$awaitApiResult$2, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super WritableMap>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f47801a;

        /* renamed from: b, reason: collision with root package name */
        public int f47802b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f47803c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f47804d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ LayoutPrefetchModule f47805e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(int i2, String str, LayoutPrefetchModule layoutPrefetchModule, Continuation continuation) {
            super(2, continuation);
            this.f47803c = i2;
            this.f47804d = str;
            this.f47805e = layoutPrefetchModule;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.f47803c, this.f47804d, this.f47805e, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x011e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0080 -> B:6:0x000f). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instructions count: 350
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zeptoconsumerapp.prefetchmodule.LayoutPrefetchModule.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayoutPrefetchModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object awaitApiResult(java.lang.String r7, long r8, kotlin.coroutines.Continuation<? super com.facebook.react.bridge.WritableMap> r10) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r10 instanceof com.zeptoconsumerapp.prefetchmodule.LayoutPrefetchModule.C01011
            if (r0 == 0) goto L13
            r0 = r10
            com.zeptoconsumerapp.prefetchmodule.LayoutPrefetchModule$awaitApiResult$1 r0 = (com.zeptoconsumerapp.prefetchmodule.LayoutPrefetchModule.C01011) r0
            int r1 = r0.f47800e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47800e = r1
            goto L18
        L13:
            com.zeptoconsumerapp.prefetchmodule.LayoutPrefetchModule$awaitApiResult$1 r0 = new com.zeptoconsumerapp.prefetchmodule.LayoutPrefetchModule$awaitApiResult$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f47798c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f47800e
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            long r8 = r0.f47797b
            java.lang.String r7 = r0.f47796a
            kotlin.ResultKt.b(r10)
            goto L50
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            kotlin.ResultKt.b(r10)
            r4 = 50
            long r4 = r8 / r4
            int r10 = (int) r4
            int r10 = r10 + 20
            com.zeptoconsumerapp.prefetchmodule.LayoutPrefetchModule$awaitApiResult$2 r2 = new com.zeptoconsumerapp.prefetchmodule.LayoutPrefetchModule$awaitApiResult$2
            r4 = 0
            r2.<init>(r10, r7, r6, r4)
            r0.f47796a = r7
            r0.f47797b = r8
            r0.f47800e = r3
            java.lang.Object r10 = kotlinx.coroutines.TimeoutKt.b(r8, r2, r0)
            if (r10 != r1) goto L50
            return r1
        L50:
            com.facebook.react.bridge.WritableMap r10 = (com.facebook.react.bridge.WritableMap) r10
            if (r10 != 0) goto L88
            com.facebook.react.bridge.WritableMap r10 = com.facebook.react.bridge.Arguments.createMap()
            java.lang.String r0 = "status"
            java.lang.String r1 = "timeout"
            r10.putString(r0, r1)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Prefetch timed out after "
            r0.<init>(r1)
            java.lang.String r1 = "ms"
            java.lang.String r8 = android.support.v4.media.b.p(r0, r8, r1)
            java.lang.String r9 = "error"
            r10.putString(r9, r8)
            java.lang.String r8 = "PREFETCHLOGIC"
            timber.log.Timber$Tree r8 = timber.log.Timber.d(r8)
            java.lang.String r9 = "PREFETCHLOGIC Timeout waiting for "
            java.lang.String r7 = android.support.v4.media.b.C(r9, r7)
            r9 = 0
            java.lang.Object[] r9 = new java.lang.Object[r9]
            r8.d(r7, r9)
            java.lang.String r7 = "run(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r7)
        L88:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptoconsumerapp.prefetchmodule.LayoutPrefetchModule.awaitApiResult(java.lang.String, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final WritableArray convertJsonToArray(JSONArray jSONArray) throws JSONException {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            Object obj = jSONArray.get(i2);
            if (obj instanceof JSONObject) {
                writableArrayCreateArray.pushMap(convertJsonToMap((JSONObject) obj));
            } else if (obj instanceof JSONArray) {
                writableArrayCreateArray.pushArray(convertJsonToArray((JSONArray) obj));
            } else if (obj instanceof String) {
                writableArrayCreateArray.pushString((String) obj);
            } else if (obj instanceof Integer) {
                writableArrayCreateArray.pushInt(((Number) obj).intValue());
            } else if (obj instanceof Double) {
                writableArrayCreateArray.pushDouble(((Number) obj).doubleValue());
            } else if (obj instanceof Boolean) {
                writableArrayCreateArray.pushBoolean(((Boolean) obj).booleanValue());
            } else if (Intrinsics.b(obj, JSONObject.NULL)) {
                writableArrayCreateArray.pushNull();
            } else {
                writableArrayCreateArray.pushString(obj.toString());
            }
        }
        Intrinsics.c(writableArrayCreateArray);
        return writableArrayCreateArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WritableMap convertJsonToMap(JSONObject jSONObject) throws JSONException {
        WritableMap writableMapCreateMap = Arguments.createMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONObject) {
                Intrinsics.c(next);
                writableMapCreateMap.putMap(next, convertJsonToMap((JSONObject) obj));
            } else if (obj instanceof JSONArray) {
                Intrinsics.c(next);
                writableMapCreateMap.putArray(next, convertJsonToArray((JSONArray) obj));
            } else if (obj instanceof String) {
                Intrinsics.c(next);
                writableMapCreateMap.putString(next, (String) obj);
            } else if (obj instanceof Integer) {
                Intrinsics.c(next);
                writableMapCreateMap.putInt(next, ((Number) obj).intValue());
            } else if (obj instanceof Double) {
                Intrinsics.c(next);
                writableMapCreateMap.putDouble(next, ((Number) obj).doubleValue());
            } else if (obj instanceof Boolean) {
                Intrinsics.c(next);
                writableMapCreateMap.putBoolean(next, ((Boolean) obj).booleanValue());
            } else if (Intrinsics.b(obj, JSONObject.NULL)) {
                Intrinsics.c(next);
                writableMapCreateMap.putNull(next);
            } else {
                Intrinsics.c(next);
                writableMapCreateMap.putString(next, obj.toString());
            }
        }
        Intrinsics.c(writableMapCreateMap);
        return writableMapCreateMap;
    }

    @ReactMethod
    public final void awaitAndGetPrefetchResult(@NotNull String requestId, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Timber.d(TAG).d("PREFETCHLOGIC awaitAndGetPrefetchResult called for requestId: " + requestId, new Object[0]);
            AnonymousClass1 block = new AnonymousClass1(requestId, promise, null);
            Intrinsics.checkNotNullParameter(block, "block");
            ContextScope contextScope = AppCoroutineManager.f47547d;
            if (contextScope != null) {
                BuildersKt.c(contextScope, null, block, 3);
            }
        } catch (Exception e2) {
            Timber.d(TAG).e(e2, "PREFETCHLOGIC Error launching coroutine", new Object[0]);
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString(CLConstants.OTP_STATUS, "error");
            writableMapCreateMap.putString("error", "Failed to launch: " + e2.getMessage());
            promise.resolve(writableMapCreateMap);
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return MODULE_NAME;
    }
}
