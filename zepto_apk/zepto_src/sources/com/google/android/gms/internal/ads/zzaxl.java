package com.google.android.gms.internal.ads;

import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager$OnChecksumsReadyListener;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzaxl implements PackageManager$OnChecksumsReadyListener {

    /* renamed from: a, reason: collision with root package name */
    public final zzgzf f24436a = new zzgzf();

    public final void onChecksumsReady(List list) {
        if (list == null) {
            this.f24436a.c("");
            return;
        }
        try {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                ApkChecksum apkChecksumC = com.facebook.hermes.intl.a.c(list.get(i2));
                if (apkChecksumC.getType() == 8) {
                    zzgzf zzgzfVar = this.f24436a;
                    zzgvy zzgvyVarF = zzgvy.f33277c.f();
                    byte[] value = apkChecksumC.getValue();
                    zzgzfVar.c(zzgvyVarF.g(value.length, value));
                    return;
                }
            }
        } catch (Throwable unused) {
        }
        this.f24436a.c("");
    }
}
