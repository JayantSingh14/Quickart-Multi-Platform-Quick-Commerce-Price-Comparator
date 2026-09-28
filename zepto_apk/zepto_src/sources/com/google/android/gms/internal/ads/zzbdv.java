package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* loaded from: classes4.dex */
public final class zzbdv implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        zzbdl zzbdlVar = (zzbdl) obj;
        zzbdl zzbdlVar2 = (zzbdl) obj2;
        float f2 = zzbdlVar.f24798b;
        float f3 = zzbdlVar2.f24798b;
        if (f2 < f3) {
            return -1;
        }
        if (f2 > f3) {
            return 1;
        }
        float f4 = zzbdlVar.f24797a;
        float f5 = zzbdlVar2.f24797a;
        if (f4 < f5) {
            return -1;
        }
        if (f4 > f5) {
            return 1;
        }
        float f6 = (zzbdlVar.f24800d - f2) * (zzbdlVar.f24799c - f4);
        float f7 = (zzbdlVar2.f24800d - f3) * (zzbdlVar2.f24799c - f5);
        if (f6 > f7) {
            return -1;
        }
        return f6 < f7 ? 1 : 0;
    }
}
