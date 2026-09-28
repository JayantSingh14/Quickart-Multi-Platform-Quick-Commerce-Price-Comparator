package com.truecaller.android.sdk.common.callbacks;

import com.truecaller.android.sdk.common.TrueException;
import com.truecaller.android.sdk.common.VerificationCallback;
import retrofit2.Call;
import retrofit2.Callback;

/* loaded from: classes4.dex */
abstract class BaseApiCallback<T> implements Callback<T> {

    /* renamed from: a, reason: collision with root package name */
    public final VerificationCallback f47213a;

    /* renamed from: b, reason: collision with root package name */
    public final int f47214b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f47215c;

    public BaseApiCallback(VerificationCallback verificationCallback, boolean z, int i2) {
        this.f47213a = verificationCallback;
        this.f47215c = z;
        this.f47214b = i2;
    }

    @Override // retrofit2.Callback
    public void a(Call call, Throwable th) {
        this.f47213a.onRequestFailure(this.f47214b, new TrueException(2, th.getMessage()));
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0098  */
    @Override // retrofit2.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(retrofit2.Call r6, retrofit2.Response r7) {
        /*
            r5 = this;
            okhttp3.Response r6 = r7.f58224a
            boolean r6 = r6.c()
            if (r6 == 0) goto L10
            java.lang.Object r6 = r7.f58225b
            if (r6 == 0) goto L10
            r5.d(r6)
            return
        L10:
            com.truecaller.android.sdk.common.VerificationCallback r6 = r5.f47213a
            int r0 = r5.f47214b
            okhttp3.ResponseBody$Companion$asResponseBody$1 r7 = r7.f58226c
            if (r7 == 0) goto La6
            com.truecaller.android.sdk.common.ErrorResponse r1 = new com.truecaller.android.sdk.common.ErrorResponse
            r1.<init>()
            com.google.gson.Gson r2 = new com.google.gson.Gson     // Catch: java.lang.Throwable -> L4f
            r2.<init>()     // Catch: java.lang.Throwable -> L4f
            java.io.Reader r7 = r7.c()     // Catch: java.lang.Throwable -> L4f
            java.lang.Class<com.truecaller.android.sdk.common.ErrorResponse> r3 = com.truecaller.android.sdk.common.ErrorResponse.class
            com.google.gson.reflect.TypeToken r4 = new com.google.gson.reflect.TypeToken     // Catch: java.lang.Throwable -> L4f
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L4f
            java.lang.Object r7 = r2.c(r7, r4)     // Catch: java.lang.Throwable -> L4f
            java.lang.Class r2 = com.google.gson.internal.Primitives.a(r3)     // Catch: java.lang.Throwable -> L4f
            java.lang.Object r7 = r2.cast(r7)     // Catch: java.lang.Throwable -> L4f
            com.truecaller.android.sdk.common.ErrorResponse r7 = (com.truecaller.android.sdk.common.ErrorResponse) r7     // Catch: java.lang.Throwable -> L4f
            if (r7 == 0) goto L4a
            java.lang.String r1 = r7.getMessage()     // Catch: java.lang.Throwable -> L48
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L48
            if (r1 == 0) goto L50
            goto L4a
        L48:
            r1 = r7
            goto L4f
        L4a:
            com.truecaller.android.sdk.common.ErrorResponse r1 = new com.truecaller.android.sdk.common.ErrorResponse     // Catch: java.lang.Throwable -> L48
            r1.<init>()     // Catch: java.lang.Throwable -> L48
        L4f:
            r7 = r1
        L50:
            boolean r1 = r5.f47215c
            if (r1 == 0) goto L67
            java.lang.String r1 = "internal service error"
            java.lang.String r2 = r7.getMessage()
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 == 0) goto L67
            r6 = 0
            r5.f47215c = r6
            r5.c()
            goto La5
        L67:
            int r1 = r7.getCode()
            switch(r1) {
                case 4003: goto L98;
                case 4004: goto L8a;
                case 4005: goto L7c;
                default: goto L6e;
            }
        L6e:
            com.truecaller.android.sdk.common.TrueException r1 = new com.truecaller.android.sdk.common.TrueException
            r2 = 2
            java.lang.String r7 = r7.getMessage()
            r1.<init>(r2, r7)
            r6.onRequestFailure(r0, r1)
            goto La5
        L7c:
            com.truecaller.android.sdk.common.TrueException r1 = new com.truecaller.android.sdk.common.TrueException
            r2 = 7
            java.lang.String r7 = r7.getMessage()
            r1.<init>(r2, r7)
            r6.onRequestFailure(r0, r1)
            goto La5
        L8a:
            com.truecaller.android.sdk.common.TrueException r1 = new com.truecaller.android.sdk.common.TrueException
            r2 = 6
            java.lang.String r7 = r7.getMessage()
            r1.<init>(r2, r7)
            r6.onRequestFailure(r0, r1)
            goto La5
        L98:
            com.truecaller.android.sdk.common.TrueException r1 = new com.truecaller.android.sdk.common.TrueException
            r2 = 4
            java.lang.String r7 = r7.getMessage()
            r1.<init>(r2, r7)
            r6.onRequestFailure(r0, r1)
        La5:
            return
        La6:
            com.truecaller.android.sdk.common.TrueException r7 = new com.truecaller.android.sdk.common.TrueException
            r1 = 1
            java.lang.String r2 = "Unknown error"
            r7.<init>(r1, r2)
            r6.onRequestFailure(r0, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.truecaller.android.sdk.common.callbacks.BaseApiCallback.b(retrofit2.Call, retrofit2.Response):void");
    }

    public abstract void c();

    public abstract void d(Object obj);
}
