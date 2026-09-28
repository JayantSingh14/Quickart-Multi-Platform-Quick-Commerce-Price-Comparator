package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
final /* synthetic */ class zzjm implements zzla {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzkp f35005a;

    @Override // com.google.android.gms.internal.ads.zzla
    public final /* synthetic */ void a(final zzkz zzkzVar) {
        final zzkp zzkpVar = this.f35005a;
        zzkpVar.getClass();
        zzkpVar.f35043j.e(new Runnable() { // from class: com.google.android.gms.internal.ads.zzkb
            @Override // java.lang.Runnable
            public final void run() {
                boolean z;
                zzkp zzkpVar2 = zzkpVar;
                zzkz zzkzVar2 = zzkzVar;
                int i2 = zzkpVar2.D - zzkzVar2.f35061c;
                zzkpVar2.D = i2;
                boolean z2 = true;
                if (zzkzVar2.f35062d) {
                    zzkpVar2.E = zzkzVar2.f35063e;
                    zzkpVar2.F = true;
                }
                if (i2 == 0) {
                    zzbf zzbfVar = zzkzVar2.f35060b.f35179a;
                    if (!zzkpVar2.X.f35179a.g() && zzbfVar.g()) {
                        zzkpVar2.Y = -1;
                        zzkpVar2.Z = 0L;
                    }
                    if (!zzbfVar.g()) {
                        List listAsList = Arrays.asList(((zzmg) zzbfVar).f35208h);
                        int size = listAsList.size();
                        ArrayList arrayList = zzkpVar2.p;
                        zzgqa.f(size == arrayList.size());
                        for (int i3 = 0; i3 < listAsList.size(); i3++) {
                            ((zzkl) arrayList.get(i3)).f35029b = (zzbf) listAsList.get(i3);
                        }
                    }
                    long j2 = -9223372036854775807L;
                    if (zzkpVar2.F) {
                        if (zzkzVar2.f35060b.f35180b.equals(zzkpVar2.X.f35180b) && zzkzVar2.f35060b.f35182d == zzkpVar2.X.r) {
                            z2 = false;
                        }
                        if (z2) {
                            if (zzbfVar.g() || zzkzVar2.f35060b.f35180b.b()) {
                                j2 = zzkzVar2.f35060b.f35182d;
                            } else {
                                zzma zzmaVar = zzkzVar2.f35060b;
                                zzwg zzwgVar = zzmaVar.f35180b;
                                long j3 = zzmaVar.f35182d;
                                zzbfVar.o(zzwgVar.f35758a, zzkpVar2.o);
                                j2 = j3;
                            }
                        }
                        z = z2;
                    } else {
                        z = false;
                    }
                    zzkpVar2.F = false;
                    zzkpVar2.h(zzkzVar2.f35060b, 1, z, zzkpVar2.E, j2, -1);
                }
            }
        });
    }
}
