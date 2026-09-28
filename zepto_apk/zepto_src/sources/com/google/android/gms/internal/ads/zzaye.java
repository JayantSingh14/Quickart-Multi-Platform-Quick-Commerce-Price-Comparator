package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzaye {
    public static final String a(Context context, String str, long j2) {
        try {
            zzawy zzawyVarC = zzawz.C();
            zzawyVarC.j();
            ((zzawz) zzawyVarC.f34638b).E(str);
            zzawyVarC.j();
            ((zzawz) zzawyVarC.f34638b).D("0.460000000");
            String packageName = context.getPackageName();
            zzawyVarC.j();
            ((zzawz) zzawyVarC.f34638b).G(packageName);
            long jCurrentTimeMillis = (System.currentTimeMillis() - j2) / 1000;
            zzawyVarC.j();
            ((zzawz) zzawyVarC.f34638b).I(jCurrentTimeMillis);
            long jCurrentTimeMillis2 = System.currentTimeMillis() / 1000;
            zzawyVarC.j();
            ((zzawz) zzawyVarC.f34638b).F(jCurrentTimeMillis2);
            try {
                long j3 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
                zzawyVarC.j();
                ((zzawz) zzawyVarC.f34638b).H(j3);
            } catch (PackageManager.NameNotFoundException unused) {
                zzawyVarC.j();
                ((zzawz) zzawyVarC.f34638b).H(-1L);
            }
            zzaxf zzaxfVarB = zzaxp.b(null, ((zzawz) zzawyVarC.l()).g());
            zzaxfVarB.j();
            ((zzaxg) zzaxfVarB.f34638b).F(5);
            zzaxfVarB.j();
            ((zzaxg) zzaxfVarB.f34638b).G(2);
            return Base64.encodeToString(((zzaxg) zzaxfVarB.l()).g(), 11);
        } catch (UnsupportedEncodingException | GeneralSecurityException unused2) {
            return Integer.toString(7);
        }
    }
}
