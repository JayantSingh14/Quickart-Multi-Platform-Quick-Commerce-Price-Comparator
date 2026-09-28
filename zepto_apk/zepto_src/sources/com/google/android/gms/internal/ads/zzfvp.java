package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.common.util.Hex;
import java.io.File;

/* loaded from: classes4.dex */
public final class zzfvp {

    /* renamed from: a, reason: collision with root package name */
    public final File f31937a;

    /* renamed from: b, reason: collision with root package name */
    public final File f31938b;

    /* renamed from: c, reason: collision with root package name */
    public final SharedPreferences f31939c;

    /* renamed from: d, reason: collision with root package name */
    public final zzbbq f31940d;

    public zzfvp(Context context, zzbbq zzbbqVar) {
        this.f31939c = context.getSharedPreferences("pcvmspf", 0);
        File dir = context.getDir("pccache", 0);
        zzfvq.d(dir, false);
        this.f31937a = dir;
        File dir2 = context.getDir("tmppccache", 0);
        zzfvq.d(dir2, true);
        this.f31938b = dir2;
        this.f31940d = zzbbqVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(com.google.android.gms.internal.ads.zzbbs r9, com.google.android.gms.internal.ads.zzfvv r10) throws java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 411
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfvp.a(com.google.android.gms.internal.ads.zzbbs, com.google.android.gms.internal.ads.zzfvv):boolean");
    }

    public final zzbby b(int i2) throws IllegalArgumentException {
        SharedPreferences sharedPreferences = this.f31939c;
        String string = i2 == 1 ? sharedPreferences.getString(e(), null) : sharedPreferences.getString(d(), null);
        if (!TextUtils.isEmpty(string)) {
            try {
                byte[] bArrStringToBytes = Hex.stringToBytes(string);
                zzhzl zzhzlVar = zzhzl.f34557b;
                zzbby zzbbyVarH = zzbby.H(zzhzl.v(0, bArrStringToBytes, bArrStringToBytes.length));
                String strC = zzbbyVarH.C();
                File fileA = zzfvq.a(c(), strC, "pcam.jar");
                if (!fileA.exists()) {
                    fileA = zzfvq.a(c(), strC, "pcam");
                }
                File fileA2 = zzfvq.a(c(), strC, "pcbc");
                if (fileA.exists()) {
                    if (fileA2.exists()) {
                        return zzbbyVarH;
                    }
                }
            } catch (zzibg unused) {
            }
        }
        return null;
    }

    public final File c() {
        File file = new File(this.f31937a, Integer.toString(this.f31940d.f24687a));
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public final String d() {
        int i2 = this.f31940d.f24687a;
        return androidx.fragment.app.e.r(new StringBuilder(String.valueOf(i2).length() + 6), i2, "FBAMTD");
    }

    public final String e() {
        int i2 = this.f31940d.f24687a;
        return androidx.fragment.app.e.r(new StringBuilder(String.valueOf(i2).length() + 6), i2, "LATMTD");
    }
}
