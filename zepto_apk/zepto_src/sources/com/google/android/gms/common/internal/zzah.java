package com.google.android.gms.common.internal;

import android.net.Uri;

/* loaded from: classes4.dex */
public final class zzah {
    private static final Uri zza = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* JADX WARN: Removed duplicated region for block: B:25:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b9 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.Intent zza(android.content.Context r5, com.google.android.gms.common.internal.zzn r6) throws com.google.android.gms.common.internal.zzaf, android.os.RemoteException {
        /*
            java.lang.String r0 = "ServiceBindIntentUtils"
            java.lang.String r1 = r6.zza()
            if (r1 != 0) goto L16
            android.content.Intent r5 = new android.content.Intent
            r5.<init>()
            android.content.ComponentName r6 = r6.zzc()
            android.content.Intent r5 = r5.setComponent(r6)
            return r5
        L16:
            boolean r2 = r6.zzd()
            r3 = 0
            if (r2 == 0) goto La9
            java.lang.String r2 = "serviceActionBundleKey"
            android.os.Bundle r2 = androidx.fragment.app.e.i(r2, r1)
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch: java.lang.IllegalArgumentException -> L39 android.os.RemoteException -> L3b
            android.net.Uri r4 = com.google.android.gms.common.internal.zzah.zza     // Catch: java.lang.IllegalArgumentException -> L39 android.os.RemoteException -> L3b
            android.content.ContentProviderClient r5 = r5.acquireUnstableContentProviderClient(r4)     // Catch: java.lang.IllegalArgumentException -> L39 android.os.RemoteException -> L3b
            if (r5 == 0) goto L42
            java.lang.String r4 = "serviceIntentCall"
            android.os.Bundle r2 = r5.call(r4, r3, r2)     // Catch: java.lang.Throwable -> L3d
            r5.release()     // Catch: java.lang.IllegalArgumentException -> L39 android.os.RemoteException -> L3b
            goto L58
        L39:
            r5 = move-exception
            goto L4a
        L3b:
            r5 = move-exception
            goto L4a
        L3d:
            r2 = move-exception
            r5.release()     // Catch: java.lang.IllegalArgumentException -> L39 android.os.RemoteException -> L3b
            throw r2     // Catch: java.lang.IllegalArgumentException -> L39 android.os.RemoteException -> L3b
        L42:
            android.os.RemoteException r5 = new android.os.RemoteException     // Catch: java.lang.IllegalArgumentException -> L39 android.os.RemoteException -> L3b
            java.lang.String r2 = "Failed to acquire ContentProviderClient"
            r5.<init>(r2)     // Catch: java.lang.IllegalArgumentException -> L39 android.os.RemoteException -> L3b
            throw r5     // Catch: java.lang.IllegalArgumentException -> L39 android.os.RemoteException -> L3b
        L4a:
            java.lang.String r2 = "Dynamic intent resolution failed: "
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r2.concat(r5)
            android.util.Log.w(r0, r5)
            r2 = r3
        L58:
            if (r2 != 0) goto L5b
            goto L71
        L5b:
            java.lang.String r5 = "serviceResponseIntentKey"
            android.os.Parcelable r5 = r2.getParcelable(r5)
            android.content.Intent r5 = (android.content.Intent) r5
            if (r5 == 0) goto L67
            r3 = r5
            goto L71
        L67:
            java.lang.String r5 = "serviceMissingResolutionIntentKey"
            android.os.Parcelable r5 = r2.getParcelable(r5)
            android.app.PendingIntent r5 = (android.app.PendingIntent) r5
            if (r5 != 0) goto L7d
        L71:
            if (r3 != 0) goto La9
            java.lang.String r5 = "Dynamic lookup for intent failed for action: "
            java.lang.String r5 = r5.concat(r1)
            android.util.Log.w(r0, r5)
            goto La9
        L7d:
            int r6 = r1.length()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r6 = r6 + 72
            r2.<init>(r6)
            java.lang.String r6 = "Dynamic lookup for intent failed for action "
            r2.append(r6)
            r2.append(r1)
            java.lang.String r6 = " but has possible resolution"
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            android.util.Log.w(r0, r6)
            com.google.android.gms.common.internal.zzaf r6 = new com.google.android.gms.common.internal.zzaf
            com.google.android.gms.common.ConnectionResult r0 = new com.google.android.gms.common.ConnectionResult
            r1 = 25
            r0.<init>(r1, r5)
            r6.<init>(r0)
            throw r6
        La9:
            if (r3 != 0) goto Lb9
            android.content.Intent r5 = new android.content.Intent
            r5.<init>(r1)
            java.lang.String r6 = r6.zzb()
            android.content.Intent r5 = r5.setPackage(r6)
            return r5
        Lb9:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzah.zza(android.content.Context, com.google.android.gms.common.internal.zzn):android.content.Intent");
    }
}
