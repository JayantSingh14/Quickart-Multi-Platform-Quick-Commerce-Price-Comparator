package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.TrafficStats;
import android.os.StrictMode;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzcjh {
    public static final zzcir a(final Context context, final VersionInfoParcel versionInfoParcel, final com.google.android.gms.ads.internal.zza zzaVar, final com.google.android.gms.ads.internal.zzn zznVar, final zzayq zzayqVar, final zzbfj zzbfjVar, final zzbhr zzbhrVar, final zzclb zzclbVar, final zzdxe zzdxeVar, final zzeif zzeifVar, final zzfhr zzfhrVar, final zzfhu zzfhuVar, final zzfio zzfioVar, final String str, final boolean z, final boolean z2) throws zzcjg {
        zzbgk.a(context);
        try {
            zzgqs zzgqsVar = new zzgqs() { // from class: com.google.android.gms.internal.ads.zzcjd
                @Override // com.google.android.gms.internal.ads.zzgqs
                public final Object zza() {
                    zzclb zzclbVar2 = zzclbVar;
                    String str2 = str;
                    boolean z3 = z;
                    boolean z4 = z2;
                    zzeif zzeifVar2 = zzeifVar;
                    zzdxe zzdxeVar2 = zzdxeVar;
                    com.google.android.gms.ads.internal.zzn zznVar2 = zznVar;
                    com.google.android.gms.ads.internal.zza zzaVar2 = zzaVar;
                    zzbfj zzbfjVar2 = zzbfjVar;
                    zzfhr zzfhrVar2 = zzfhrVar;
                    zzfhu zzfhuVar2 = zzfhuVar;
                    zzfio zzfioVar2 = zzfioVar;
                    zzayq zzayqVar2 = zzayqVar;
                    zzbhr zzbhrVar2 = zzbhrVar;
                    VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
                    Context context2 = context;
                    try {
                        TrafficStats.setThreadStatsTag(264);
                        int i2 = zzcju.L0;
                        zzckt zzcktVar = new zzckt(context2);
                        zzcktVar.setBaseContext(context2);
                        zzcjn zzcjnVar = new zzcjn(new zzcju(zzcktVar, zzclbVar2, str2, z3, zzayqVar2, zzbhrVar2, versionInfoParcel2, zznVar2, zzaVar2, zzbfjVar2, zzfhrVar2, zzfhuVar2, zzfioVar2), zzdxeVar2);
                        zzcjnVar.setWebViewClient(com.google.android.gms.ads.internal.zzt.C.f21682f.i(zzcjnVar, zzbfjVar2, z4, zzeifVar2));
                        zzcjnVar.setWebChromeClient(new zzciq(zzcjnVar));
                        return zzcjnVar;
                    } finally {
                        TrafficStats.clearThreadStatsTag();
                    }
                }
            };
            StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
            try {
                StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
                Object objZza = zzgqsVar.zza();
                StrictMode.setThreadPolicy(threadPolicy);
                return (zzcir) objZza;
            } catch (Throwable th) {
                StrictMode.setThreadPolicy(threadPolicy);
                throw th;
            }
        } catch (Throwable th2) {
            throw new zzcjg("Webview initialization failed.", th2);
        }
    }
}
