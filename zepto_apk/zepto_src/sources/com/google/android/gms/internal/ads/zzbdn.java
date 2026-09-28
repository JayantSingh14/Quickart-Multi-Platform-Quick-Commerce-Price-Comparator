package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* loaded from: classes4.dex */
final class zzbdn implements Comparator {
    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzbds zzbdsVar = (zzbds) obj;
        zzbds zzbdsVar2 = (zzbds) obj2;
        int i2 = zzbdsVar.f24811c - zzbdsVar2.f24811c;
        return i2 != 0 ? i2 : Long.compare(zzbdsVar.f24809a, zzbdsVar2.f24809a);
    }
}
