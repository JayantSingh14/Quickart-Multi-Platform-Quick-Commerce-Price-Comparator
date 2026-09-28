package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$OnChecksumsReadyListener;
import android.os.Build;
import java.security.cert.CertificateEncodingException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzbbk {
    public static String a(Context context, String str, ArrayList arrayList) throws PackageManager.NameNotFoundException, CertificateEncodingException {
        if (Build.VERSION.SDK_INT <= 30 && !Build.VERSION.CODENAME.equals("S")) {
            return null;
        }
        final zzgzf zzgzfVar = new zzgzf();
        context.getPackageManager().requestChecksums(str, false, 8, arrayList, new PackageManager$OnChecksumsReadyListener() { // from class: com.google.android.gms.internal.ads.zzbbj
            public final void onChecksumsReady(List list) {
                zzgzf zzgzfVar2 = zzgzfVar;
                if (list == null) {
                    zzgzfVar2.c(null);
                    return;
                }
                try {
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ApkChecksum apkChecksumC = com.facebook.hermes.intl.a.c(list.get(i2));
                        if (apkChecksumC.getType() == 8) {
                            byte[] value = apkChecksumC.getValue();
                            char[] cArr = zzazw.f24590a;
                            int length = value.length;
                            char[] cArr2 = new char[length + length];
                            for (int i3 = 0; i3 < value.length; i3++) {
                                byte b2 = value[i3];
                                char[] cArr3 = zzazw.f24590a;
                                int i4 = i3 + i3;
                                cArr2[i4] = cArr3[(b2 & 255) >>> 4];
                                cArr2[i4 + 1] = cArr3[b2 & 15];
                            }
                            zzgzfVar2.c(new String(cArr2));
                            return;
                        }
                    }
                    zzgzfVar2.c(null);
                } catch (Throwable unused) {
                    zzgzfVar2.c(null);
                }
            }
        });
        return (String) zzgzfVar.get();
    }
}
