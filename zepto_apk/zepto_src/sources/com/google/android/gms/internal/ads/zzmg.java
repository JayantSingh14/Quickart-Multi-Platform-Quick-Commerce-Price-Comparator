package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
final class zzmg extends zzii {

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f35203k = 0;

    /* renamed from: d, reason: collision with root package name */
    public final int f35204d;

    /* renamed from: e, reason: collision with root package name */
    public final int f35205e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f35206f;

    /* renamed from: g, reason: collision with root package name */
    public final int[] f35207g;

    /* renamed from: h, reason: collision with root package name */
    public final zzbf[] f35208h;

    /* renamed from: i, reason: collision with root package name */
    public final Object[] f35209i;

    /* renamed from: j, reason: collision with root package name */
    public final HashMap f35210j;

    /* JADX WARN: Illegal instructions before constructor call */
    public zzmg(List list, zzxz zzxzVar) {
        zzbf[] zzbfVarArr = new zzbf[list.size()];
        Iterator it = list.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            zzbfVarArr[i3] = ((zzlo) it.next()).zzb();
            i3++;
        }
        Object[] objArr = new Object[list.size()];
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            objArr[i2] = ((zzlo) it2.next()).zza();
            i2++;
        }
        this(zzbfVarArr, objArr, zzxzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final int a() {
        return this.f35204d;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final int c() {
        return this.f35205e;
    }

    @Override // com.google.android.gms.internal.ads.zzii
    public final int p(int i2) {
        return zzfj.p(this.f35206f, i2 + 1, false, false);
    }

    @Override // com.google.android.gms.internal.ads.zzii
    public final int q(int i2) {
        return zzfj.p(this.f35207g, i2 + 1, false, false);
    }

    @Override // com.google.android.gms.internal.ads.zzii
    public final int r(Object obj) {
        Integer num = (Integer) this.f35210j.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.google.android.gms.internal.ads.zzii
    public final zzbf s(int i2) {
        return this.f35208h[i2];
    }

    @Override // com.google.android.gms.internal.ads.zzii
    public final int t(int i2) {
        return this.f35206f[i2];
    }

    @Override // com.google.android.gms.internal.ads.zzii
    public final int u(int i2) {
        return this.f35207g[i2];
    }

    @Override // com.google.android.gms.internal.ads.zzii
    public final Object v(int i2) {
        return this.f35209i[i2];
    }

    public zzmg(zzbf[] zzbfVarArr, Object[] objArr, zzxz zzxzVar) {
        super(zzxzVar);
        this.f35208h = zzbfVarArr;
        int length = zzbfVarArr.length;
        this.f35206f = new int[length];
        this.f35207g = new int[length];
        this.f35209i = objArr;
        this.f35210j = new HashMap();
        int i2 = 0;
        int iA = 0;
        int iC = 0;
        int i3 = 0;
        while (i2 < zzbfVarArr.length) {
            zzbf zzbfVar = zzbfVarArr[i2];
            this.f35208h[i3] = zzbfVar;
            this.f35207g[i3] = iA;
            this.f35206f[i3] = iC;
            iA += zzbfVar.a();
            iC += this.f35208h[i3].c();
            this.f35210j.put(objArr[i3], Integer.valueOf(i3));
            i2++;
            i3++;
        }
        this.f35204d = iA;
        this.f35205e = iC;
    }
}
