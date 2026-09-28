package com.google.android.gms.internal.consent_sdk;

import android.net.Uri;
import android.util.Log;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
final class zzcb implements zzd {
    public final void a(String str) {
        Log.d("UserMessagingPlatform", "Receive consent action: ".concat(String.valueOf(str)));
        Uri uri = Uri.parse(str);
        uri.getQueryParameter("action");
        uri.getQueryParameter("args");
        throw null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    @Override // com.google.android.gms.internal.consent_sdk.zzd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f(java.lang.String r8, org.json.JSONObject r9) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.consent_sdk.zzcb.f(java.lang.String, org.json.JSONObject):boolean");
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzd
    public final Executor zza() {
        Objects.requireNonNull(null);
        throw null;
    }
}
