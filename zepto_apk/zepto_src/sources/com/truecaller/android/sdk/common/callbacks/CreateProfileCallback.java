package com.truecaller.android.sdk.common.callbacks;

import androidx.annotation.RestrictTo;
import com.truecaller.android.sdk.common.VerificationRequestManagerImpl;
import com.truecaller.android.sdk.common.models.TrueProfile;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;

@RestrictTo
/* loaded from: classes4.dex */
public class CreateProfileCallback implements Callback<JSONObject> {

    /* renamed from: a, reason: collision with root package name */
    public final String f47217a;

    /* renamed from: b, reason: collision with root package name */
    public final TrueProfile f47218b;

    /* renamed from: c, reason: collision with root package name */
    public final VerificationRequestManagerImpl f47219c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f47220d = true;

    public CreateProfileCallback(String str, TrueProfile trueProfile, VerificationRequestManagerImpl verificationRequestManagerImpl) {
        this.f47217a = str;
        this.f47218b = trueProfile;
        this.f47219c = verificationRequestManagerImpl;
    }

    @Override // retrofit2.Callback
    public final void a(Call call, Throwable th) {
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x005e -> B:23:0x0060). Please report as a decompilation issue!!! */
    @Override // retrofit2.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(retrofit2.Call r6, retrofit2.Response r7) {
        /*
            r5 = this;
            okhttp3.ResponseBody$Companion$asResponseBody$1 r6 = r7.f58226c
            if (r6 == 0) goto L8b
            java.lang.String r7 = "errors"
            java.lang.String r0 = "message"
            r1 = 0
            com.google.gson.Gson r2 = new com.google.gson.Gson     // Catch: java.lang.Throwable -> L5e
            r2.<init>()     // Catch: java.lang.Throwable -> L5e
            java.io.Reader r6 = r6.c()     // Catch: java.lang.Throwable -> L5e
            java.lang.Class<java.util.Map> r3 = java.util.Map.class
            com.google.gson.reflect.TypeToken r4 = new com.google.gson.reflect.TypeToken     // Catch: java.lang.Throwable -> L5e
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L5e
            java.lang.Object r6 = r2.c(r6, r4)     // Catch: java.lang.Throwable -> L5e
            java.lang.Class r2 = com.google.gson.internal.Primitives.a(r3)     // Catch: java.lang.Throwable -> L5e
            java.lang.Object r6 = r2.cast(r6)     // Catch: java.lang.Throwable -> L5e
            java.util.Map r6 = (java.util.Map) r6     // Catch: java.lang.Throwable -> L5e
            if (r6 == 0) goto L5e
            boolean r2 = r6.containsKey(r0)     // Catch: java.lang.Throwable -> L5e
            if (r2 == 0) goto L3a
            java.lang.Object r6 = r6.get(r0)     // Catch: java.lang.Throwable -> L5e
            boolean r7 = r6 instanceof java.lang.String     // Catch: java.lang.Throwable -> L5e
            if (r7 == 0) goto L5e
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L5e
            goto L60
        L3a:
            boolean r0 = r6.containsKey(r7)     // Catch: java.lang.Throwable -> L5e
            if (r0 == 0) goto L5e
            java.lang.Object r6 = r6.get(r7)     // Catch: java.lang.Throwable -> L5e
            boolean r7 = r6 instanceof java.util.List     // Catch: java.lang.Throwable -> L5e
            if (r7 == 0) goto L5e
            r7 = r6
            java.util.List r7 = (java.util.List) r7     // Catch: java.lang.Throwable -> L5e
            boolean r7 = r7.isEmpty()     // Catch: java.lang.Throwable -> L5e
            if (r7 != 0) goto L5e
            java.util.List r6 = (java.util.List) r6     // Catch: java.lang.Throwable -> L5e
            java.lang.Object r6 = r6.get(r1)     // Catch: java.lang.Throwable -> L5e
            boolean r7 = r6 instanceof java.lang.String     // Catch: java.lang.Throwable -> L5e
            if (r7 == 0) goto L5e
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L5e
            goto L60
        L5e:
            java.lang.String r6 = "Unknown error"
        L60:
            boolean r7 = r5.f47220d
            if (r7 == 0) goto L8b
            java.lang.String r7 = "internal service error"
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L8b
            r5.f47220d = r1
            com.truecaller.android.sdk.common.VerificationRequestManagerImpl r6 = r5.f47219c
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "Bearer "
            r7.<init>(r0)
            java.lang.String r0 = r5.f47217a
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            com.truecaller.android.sdk.common.network.ProfileService r6 = r6.f47195a
            com.truecaller.android.sdk.common.models.TrueProfile r0 = r5.f47218b
            retrofit2.Call r6 = r6.a(r7, r0)
            r6.N(r5)
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.truecaller.android.sdk.common.callbacks.CreateProfileCallback.b(retrofit2.Call, retrofit2.Response):void");
    }
}
