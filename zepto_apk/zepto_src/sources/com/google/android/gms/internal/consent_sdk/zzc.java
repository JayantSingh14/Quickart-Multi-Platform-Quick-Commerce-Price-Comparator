package com.google.android.gms.internal.consent_sdk;

import android.support.v4.media.b;
import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final /* synthetic */ class zzc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f36526a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f36527b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzd[] f36528c;

    public /* synthetic */ zzc(String str, String str2, zzd[] zzdVarArr) {
        this.f36526a = str;
        this.f36527b = str2;
        this.f36528c = zzdVarArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final JSONObject jSONObject;
        String str = this.f36526a;
        if (TextUtils.isEmpty(str)) {
            Log.d("UserMessagingPlatform", "Error on action: empty action name");
            return;
        }
        final String lowerCase = str.toLowerCase();
        String str2 = this.f36527b;
        if (TextUtils.isEmpty(str2)) {
            jSONObject = new JSONObject();
        } else {
            try {
                jSONObject = new JSONObject(str2);
            } catch (JSONException unused) {
                Log.d("UserMessagingPlatform", "Action[" + lowerCase + "]: failed to parse args: " + str2);
                return;
            }
        }
        Log.d("UserMessagingPlatform", "Action[" + lowerCase + "]: " + jSONObject.toString());
        int i2 = 0;
        while (true) {
            zzd[] zzdVarArr = this.f36528c;
            if (i2 >= zzdVarArr.length) {
                return;
            }
            final zzd zzdVar = zzdVarArr[i2];
            FutureTask futureTask = new FutureTask(new Callable() { // from class: com.google.android.gms.internal.consent_sdk.zzb
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return Boolean.valueOf(zzdVar.f(lowerCase, jSONObject));
                }
            });
            zzdVar.zza().execute(futureTask);
            try {
            } catch (InterruptedException e2) {
                Log.d("UserMessagingPlatform", "Thread interrupted for Action[" + lowerCase + "]: ", e2);
            } catch (ExecutionException e3) {
                Log.d("UserMessagingPlatform", b.D("Failed to run Action[", lowerCase, "]: "), e3.getCause());
            }
            if (((Boolean) futureTask.get()).booleanValue()) {
                return;
            } else {
                i2++;
            }
        }
    }
}
