package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.ext.SdkExtensions;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzetr implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f30314a;

    /* renamed from: b, reason: collision with root package name */
    public final VersionInfoParcel f30315b;

    public zzetr(VersionInfoParcel versionInfoParcel, zzgyw zzgywVar) {
        this.f30315b = versionInfoParcel;
        this.f30314a = zzgywVar;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return ((zzgxi) this.f30314a).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzetq
            @Override // java.util.concurrent.Callable
            public final Object call() {
                VersionInfoParcel versionInfoParcel = this.f30313a.f30315b;
                zzbgb zzbgbVar = zzbgk.hb;
                zzbgi zzbgiVar = com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c;
                if (!((Boolean) zzbgiVar.a(zzbgbVar)).booleanValue()) {
                    return new zzets(null);
                }
                com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
                int extensionVersion = 0;
                try {
                    int i2 = Build.VERSION.SDK_INT;
                    if (i2 >= 30 && SdkExtensions.getExtensionVersion(30) > 3) {
                        extensionVersion = SdkExtensions.getExtensionVersion(1000000);
                    } else if (((Boolean) zzbgiVar.a(zzbgk.kb)).booleanValue() && versionInfoParcel.f21402c >= ((Integer) zzbgiVar.a(zzbgk.jb)).intValue() && i2 >= 31 && SdkExtensions.getExtensionVersion(31) >= 9) {
                        extensionVersion = SdkExtensions.getExtensionVersion(31);
                    }
                } catch (Exception e2) {
                    com.google.android.gms.ads.internal.zzt.C.f21684h.d("AdUtil.getAdServicesExtensionVersion", e2);
                }
                return new zzets(Integer.valueOf(extensionVersion));
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 54;
    }
}
