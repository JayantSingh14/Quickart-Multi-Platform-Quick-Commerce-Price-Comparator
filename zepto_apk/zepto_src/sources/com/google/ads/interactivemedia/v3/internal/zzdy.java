package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;

/* loaded from: classes3.dex */
public final class zzdy {
    private final Context zza;
    private final zzdx zzb;
    private final zzel zzc;

    public zzdy(Context context, zzdx zzdxVar, zzel zzelVar) {
        this.zza = context;
        this.zzb = zzdxVar;
        this.zzc = zzelVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0087 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map zza() {
        /*
            r11 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            android.content.Context r1 = r11.zza
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r1.getPackageName()
            r2.append(r3)
            java.lang.String r3 = "_preferences"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r3 = 0
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r2, r3)
            if (r1 != 0) goto L25
            goto Lbb
        L25:
            com.google.ads.interactivemedia.v3.internal.zzdx r2 = r11.zzb
            com.google.ads.interactivemedia.v3.internal.zzqi r2 = r2.zzb
            com.google.ads.interactivemedia.v3.internal.zzqk r2 = r2.entrySet()
            com.google.ads.interactivemedia.v3.internal.zzrl r2 = r2.iterator()
        L31:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto Lbb
            java.lang.Object r4 = r2.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = (java.lang.String) r4
            boolean r6 = r1.contains(r5)
            if (r6 == 0) goto L31
            int r6 = r4.hashCode()     // Catch: java.lang.ClassCastException -> L98
            r7 = -1950496919(0xffffffff8bbdc769, float:-7.310019E-32)
            r8 = -1
            r9 = 1
            r10 = 2
            if (r6 == r7) goto L7a
            r7 = -1808118735(0xffffffff943a4c31, float:-9.405626E-27)
            if (r6 == r7) goto L70
            r7 = 1729365000(0x67140408, float:6.989846E23)
            if (r6 == r7) goto L66
            goto L84
        L66:
            java.lang.String r6 = "Boolean"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L84
            r4 = r10
            goto L85
        L70:
            java.lang.String r6 = "String"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L84
            r4 = r3
            goto L85
        L7a:
            java.lang.String r6 = "Number"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L84
            r4 = r9
            goto L85
        L84:
            r4 = r8
        L85:
            if (r4 == 0) goto La6
            if (r4 == r9) goto L9a
            if (r4 == r10) goto L8c
            goto L31
        L8c:
            boolean r4 = r1.getBoolean(r5, r3)     // Catch: java.lang.ClassCastException -> L98
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch: java.lang.ClassCastException -> L98
            r0.put(r5, r4)     // Catch: java.lang.ClassCastException -> L98
            goto L31
        L98:
            r4 = move-exception
            goto Lb0
        L9a:
            int r4 = r1.getInt(r5, r8)     // Catch: java.lang.ClassCastException -> L98
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch: java.lang.ClassCastException -> L98
            r0.put(r5, r4)     // Catch: java.lang.ClassCastException -> L98
            goto L31
        La6:
            java.lang.String r4 = ""
            java.lang.String r4 = r1.getString(r5, r4)     // Catch: java.lang.ClassCastException -> L98
            r0.put(r5, r4)     // Catch: java.lang.ClassCastException -> L98
            goto L31
        Lb0:
            com.google.ads.interactivemedia.v3.internal.zzel r5 = r11.zzc
            com.google.ads.interactivemedia.v3.impl.data.zzbx r6 = com.google.ads.interactivemedia.v3.impl.data.zzbx.IDENTITY_MANAGER
            com.google.ads.interactivemedia.v3.impl.data.zzbz r7 = com.google.ads.interactivemedia.v3.impl.data.zzbz.GET_CONSENT_SETTINGS
            r5.zzd(r6, r7, r4)
            goto L31
        Lbb:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzdy.zza():java.util.Map");
    }
}
