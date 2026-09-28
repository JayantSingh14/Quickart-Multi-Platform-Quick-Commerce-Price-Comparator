package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* loaded from: classes4.dex */
public final class zzalz implements zzaer {

    /* renamed from: a, reason: collision with root package name */
    public final zzaer f23511a;

    /* renamed from: b, reason: collision with root package name */
    public final zzalw f23512b;

    /* renamed from: c, reason: collision with root package name */
    public final SparseArray f23513c = new SparseArray();

    /* renamed from: d, reason: collision with root package name */
    public boolean f23514d;

    public zzalz(zzaer zzaerVar, zzalw zzalwVar) {
        this.f23511a = zzaerVar;
        this.f23512b = zzalwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final void d(zzafr zzafrVar) {
        this.f23511a.d(zzafrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final zzaga e(int i2, int i3) {
        zzaer zzaerVar = this.f23511a;
        if (i3 != 3) {
            this.f23514d = true;
            return zzaerVar.e(i2, i3);
        }
        SparseArray sparseArray = this.f23513c;
        zzamb zzambVar = (zzamb) sparseArray.get(i2);
        if (zzambVar != null) {
            return zzambVar;
        }
        zzamb zzambVar2 = new zzamb(zzaerVar.e(i2, 3), this.f23512b);
        sparseArray.put(i2, zzambVar2);
        return zzambVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final void h() {
        this.f23511a.h();
        if (!this.f23514d) {
            return;
        }
        int i2 = 0;
        while (true) {
            SparseArray sparseArray = this.f23513c;
            if (i2 >= sparseArray.size()) {
                return;
            }
            ((zzamb) sparseArray.valueAt(i2)).f23539i = true;
            i2++;
        }
    }
}
