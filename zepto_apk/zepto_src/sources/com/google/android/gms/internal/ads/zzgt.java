package com.google.android.gms.internal.ads;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class zzgt implements zzhb {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f33175a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f33176b = new ArrayList(1);

    /* renamed from: c, reason: collision with root package name */
    public int f33177c;

    /* renamed from: d, reason: collision with root package name */
    public zzhf f33178d;

    public zzgt(boolean z) {
        this.f33175a = z;
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void c(zzhz zzhzVar) {
        zzhzVar.getClass();
        ArrayList arrayList = this.f33176b;
        if (arrayList.contains(zzhzVar)) {
            return;
        }
        arrayList.add(zzhzVar);
        this.f33177c++;
    }

    public final void d(zzhf zzhfVar) {
        for (int i2 = 0; i2 < this.f33177c; i2++) {
            ((zzhz) this.f33176b.get(i2)).getClass();
        }
    }

    public final void e(zzhf zzhfVar) {
        this.f33178d = zzhfVar;
        for (int i2 = 0; i2 < this.f33177c; i2++) {
            ((zzhz) this.f33176b.get(i2)).l(this, zzhfVar, this.f33175a);
        }
    }

    public final void f(int i2) {
        zzhf zzhfVar = this.f33178d;
        String str = zzfj.f31254a;
        for (int i3 = 0; i3 < this.f33177c; i3++) {
            ((zzhz) this.f33176b.get(i3)).m(zzhfVar, this.f33175a, i2);
        }
    }

    public final void g() {
        zzhf zzhfVar = this.f33178d;
        String str = zzfj.f31254a;
        for (int i2 = 0; i2 < this.f33177c; i2++) {
            ((zzhz) this.f33176b.get(i2)).g(zzhfVar, this.f33175a);
        }
        this.f33178d = null;
    }
}
