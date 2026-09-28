package com.google.android.gms.internal.ads;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzaod implements zzapt {

    /* renamed from: a, reason: collision with root package name */
    public final zzgtd f23851a;

    public zzaod(List list) {
        this.f23851a = (zzgtd) list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v4 */
    public final List a(zzaps zzapsVar) {
        String str;
        int i2;
        List listSingletonList;
        zzer zzerVar = new zzer(zzapsVar.f24107c);
        ArrayList arrayList = this.f23851a;
        while (zzerVar.B() > 0) {
            int iK = zzerVar.K();
            int iK2 = zzerVar.f30145b + zzerVar.K();
            if (iK == 134) {
                arrayList = new ArrayList();
                int iK3 = zzerVar.K() & 31;
                for (int i3 = 0; i3 < iK3; i3++) {
                    String strK = zzerVar.k(3, StandardCharsets.UTF_8);
                    int iK4 = zzerVar.K();
                    boolean z = (iK4 & 128) != 0;
                    if (z) {
                        i2 = iK4 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i2 = 1;
                    }
                    byte bK = (byte) zzerVar.K();
                    zzerVar.G(1);
                    if (z) {
                        int i4 = bK & 64;
                        byte[] bArr = zzdo.f28067a;
                        listSingletonList = Collections.singletonList(i4 != 0 ? new byte[]{1} : new byte[]{0});
                    } else {
                        listSingletonList = null;
                    }
                    zzt zztVar = new zzt();
                    zztVar.e(str);
                    zztVar.f35567d = strK;
                    zztVar.I = i2;
                    zztVar.o = listSingletonList;
                    arrayList.add(new zzv(zztVar));
                }
            }
            zzerVar.E(iK2);
            arrayList = arrayList;
        }
        return arrayList;
    }

    public zzaod() {
        this(0);
    }

    public zzaod(int i2) {
        zzgvs zzgvsVar = zzgtd.f33183b;
        this.f23851a = zzguy.f33232e;
    }
}
