package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration;
import java.util.Map;

/* loaded from: classes3.dex */
public final class zzeh {
    private final Context zza;
    private final boolean zzb;
    private final long zzc;
    private final TestingConfiguration zzd;
    private final zzee zze;
    private final zzds zzf;

    public zzeh(Context context, zzee zzeeVar, zzel zzelVar, @Nullable Map map, TestingConfiguration testingConfiguration) throws NumberFormatException {
        int i2;
        this.zza = context;
        this.zzb = !zzeeVar.zza;
        long j2 = zzeeVar.zzb;
        this.zzc = j2 <= 0 ? 150L : j2;
        this.zze = zzeeVar;
        this.zzd = testingConfiguration;
        int i3 = zzeeVar.zze;
        if (map != null) {
            try {
                i2 = Integer.parseInt((String) map.get("IDENTITY_TOKEN_CUSTOM_TIMEOUT_AND_MEASUREMENT"));
            } catch (NumberFormatException unused) {
                i2 = 0;
            }
            if (i2 > 0) {
                i3 = i2;
            }
        }
        this.zzf = new zzds(new zzdr(context, i3, zzelVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0080  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.ads.interactivemedia.v3.impl.data.zzbv zza(com.google.ads.interactivemedia.v3.api.BaseRequest r12, java.lang.String r13) {
        /*
            r11 = this;
            java.lang.String r0 = ""
            r1 = 0
            android.content.Context r2 = r11.zza     // Catch: java.lang.Throwable -> L13
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r2 = com.google.android.gms.ads.identifier.AdvertisingIdClient.a(r2)     // Catch: java.lang.Throwable -> L13
            java.lang.String r3 = r2.f21070a     // Catch: java.lang.Throwable -> L13
            boolean r2 = r2.f21071b     // Catch: java.lang.Throwable -> L13
            java.lang.String r4 = "adid"
            r7 = r2
            r5 = r3
        L11:
            r6 = r4
            goto L3a
        L13:
            r3 = r0
            r2 = r1
        L15:
            android.content.Context r4 = r11.zza     // Catch: android.provider.Settings.SettingNotFoundException -> L32
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch: android.provider.Settings.SettingNotFoundException -> L32
            java.lang.String r5 = "advertising_id"
            java.lang.String r5 = android.provider.Settings.Secure.getString(r4, r5)     // Catch: android.provider.Settings.SettingNotFoundException -> L32
            java.lang.String r6 = "limit_ad_tracking"
            int r2 = android.provider.Settings.Secure.getInt(r4, r6)     // Catch: android.provider.Settings.SettingNotFoundException -> L32
            r3 = 1
            if (r2 != r3) goto L2c
            r2 = r3
            goto L2d
        L2c:
            r2 = r1
        L2d:
            java.lang.String r4 = "afai"
            r7 = r2
            goto L11
        L31:
            r3 = r5
        L32:
            java.lang.String r4 = "Failed to get advertising ID."
            com.google.ads.interactivemedia.v3.internal.zzeo.zzd(r4)
            r6 = r0
            r7 = r2
            r5 = r3
        L3a:
            boolean r2 = r11.zzb
            if (r2 == 0) goto L68
            android.content.Context r2 = r11.zza     // Catch: java.lang.Throwable -> L5a java.lang.Throwable -> L61
            com.google.android.gms.internal.appset.zzr r3 = new com.google.android.gms.internal.appset.zzr     // Catch: java.lang.Throwable -> L5a java.lang.Throwable -> L61
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L5a java.lang.Throwable -> L61
            com.google.android.gms.tasks.Task r2 = r3.a()     // Catch: java.lang.Throwable -> L5a java.lang.Throwable -> L61
            long r3 = r11.zzc     // Catch: java.lang.Throwable -> L5a java.lang.Throwable -> L61
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L5a java.lang.Throwable -> L61
            java.lang.Object r2 = com.google.android.gms.tasks.Tasks.b(r2, r3, r8)     // Catch: java.lang.Throwable -> L5a java.lang.Throwable -> L61
            com.google.android.gms.appset.AppSetIdInfo r2 = (com.google.android.gms.appset.AppSetIdInfo) r2     // Catch: java.lang.Throwable -> L5a java.lang.Throwable -> L61
            java.lang.String r3 = r2.f21994a     // Catch: java.lang.Throwable -> L5a java.lang.Throwable -> L61
            int r1 = r2.f21995b     // Catch: java.lang.Throwable -> L5b java.lang.Throwable -> L62
        L57:
            r9 = r1
            r8 = r3
            goto L6a
        L5a:
            r3 = r0
        L5b:
            java.lang.String r2 = "Unable to contact the App Set SDK."
            com.google.ads.interactivemedia.v3.internal.zzeo.zzd(r2)
            goto L57
        L61:
            r3 = r0
        L62:
            java.lang.String r2 = "Timeout getting AppSet ID."
            com.google.ads.interactivemedia.v3.internal.zzeo.zzd(r2)
            goto L57
        L68:
            r8 = r0
            r9 = r1
        L6a:
            android.content.Context r1 = r11.zza
            com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration r2 = r11.zzd
            boolean r1 = com.google.ads.interactivemedia.v3.internal.zzdt.zzb(r1, r2)
            com.google.ads.interactivemedia.v3.internal.zzef r12 = r12.zza()
            com.google.ads.interactivemedia.v3.internal.zzee r2 = r11.zze
            android.content.Context r3 = r11.zza
            boolean r12 = r12.zza(r2, r3, r7, r1)
            if (r12 == 0) goto L8c
            com.google.ads.interactivemedia.v3.internal.zzds r12 = r11.zzf
            if (r1 == 0) goto L87
            com.google.ads.interactivemedia.v3.impl.zzal r0 = com.google.ads.interactivemedia.v3.impl.zzal.GTV
            goto L88
        L87:
            r0 = 0
        L88:
            java.lang.String r0 = r12.zza(r0, r13)
        L8c:
            r10 = r0
            com.google.ads.interactivemedia.v3.impl.data.zzbv r12 = com.google.ads.interactivemedia.v3.impl.data.zzbv.create(r5, r6, r7, r8, r9, r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzeh.zza(com.google.ads.interactivemedia.v3.api.BaseRequest, java.lang.String):com.google.ads.interactivemedia.v3.impl.data.zzbv");
    }
}
