package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Map;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
final class zzbmo implements zzbnn {
    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) {
        zzgnu zzgnuVar;
        com.google.android.gms.ads.internal.overlay.zzz zzzVar = com.google.android.gms.ads.internal.zzt.C.s;
        if (!zzzVar.f21398e || (zzgnuVar = zzzVar.f21397d) == null) {
            com.google.android.gms.ads.internal.util.zze.k("LastMileDelivery not connected");
            return;
        }
        zzgnk zzgnkVar = new zzgnk();
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Ec)).booleanValue() || TextUtils.isEmpty(zzzVar.f21395b)) {
            String str = zzzVar.f21394a;
            if (str != null) {
                zzgnkVar.f32973a = str;
            } else {
                zzzVar.c("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzgnkVar.f32974b = zzzVar.f21395b;
        }
        final zzgnl zzgnlVar = new zzgnl(zzgnkVar.f32973a, zzgnkVar.f32974b);
        final zzgor zzgorVar = zzzVar.f21399f;
        final zzgom zzgomVar = ((zzgnw) zzgnuVar).f33001a;
        zzgpd zzgpdVar = zzgomVar.f33027a;
        if (zzgpdVar == null) {
            zzgom.f33025c.c("error: %s", "Play Store not found.");
        } else if (zzgom.c(zzgorVar, "Failed to apply OverlayDisplayDismissRequest: missing appId and sessionToken.", Arrays.asList(zzgnlVar.a(), zzgnlVar.b()))) {
            zzgpdVar.a(new zzgoz(zzgpdVar, new Runnable() { // from class: com.google.android.gms.internal.ads.zzgny
                @Override // java.lang.Runnable
                public final void run() {
                    zzgnt zzgntVar = zzgnlVar;
                    zzgor zzgorVar2 = zzgorVar;
                    zzgom zzgomVar2 = zzgomVar;
                    String str2 = zzgomVar2.f33028b;
                    try {
                        zzgpd zzgpdVar2 = zzgomVar2.f33027a;
                        if (zzgpdVar2 == null) {
                            throw null;
                        }
                        zzgnh zzgnhVar = zzgpdVar2.f33048j;
                        if (zzgnhVar == null) {
                            return;
                        }
                        final Bundle bundle = new Bundle();
                        bundle.putString("callerPackage", str2);
                        zzgom.b(zzgntVar.a(), new zzgol() { // from class: com.google.android.gms.internal.ads.zzgog
                            @Override // com.google.android.gms.internal.ads.zzgol
                            public final /* synthetic */ void a(String str3) {
                                zzgpe zzgpeVar = zzgom.f33025c;
                                bundle.putString("sessionToken", str3);
                            }
                        });
                        zzgom.b(zzgntVar.b(), new zzgol() { // from class: com.google.android.gms.internal.ads.zzgoh
                            @Override // com.google.android.gms.internal.ads.zzgol
                            public final /* synthetic */ void a(String str3) {
                                zzgpe zzgpeVar = zzgom.f33025c;
                                bundle.putString(CLConstants.SALT_FIELD_APP_ID, str3);
                            }
                        });
                        zzgnhVar.m2(bundle, new zzgok(zzgomVar2, zzgorVar2));
                    } catch (RemoteException e2) {
                        zzgom.f33025c.d(e2, "dismiss overlay display from: %s", str2);
                    }
                }
            }));
        }
    }
}
