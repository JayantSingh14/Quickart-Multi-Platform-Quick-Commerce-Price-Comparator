package com.google.android.gms.internal.ads;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzwx extends zzvo {
    public static final zzak r;

    /* renamed from: k, reason: collision with root package name */
    public final zzwi[] f35799k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f35800l;

    /* renamed from: m, reason: collision with root package name */
    public final zzbf[] f35801m;
    public final ArrayList n;
    public int o = -1;
    public long[][] p;
    public zzwv q;

    static {
        zzz zzzVar = new zzz();
        zzzVar.f35941a = "MergingMediaSource";
        r = zzzVar.a();
    }

    public zzwx(zzvr zzvrVar, zzwi... zzwiVarArr) {
        this.f35799k = zzwiVarArr;
        this.n = new ArrayList(Arrays.asList(zzwiVarArr));
        this.f35800l = new ArrayList(zzwiVarArr.length);
        int i2 = 0;
        while (true) {
            int length = zzwiVarArr.length;
            if (i2 >= length) {
                this.f35801m = new zzbf[length];
                this.p = new long[0][];
                new HashMap();
                new zzgut(new zzguq(new zzgum()).f33229a.a(), new zzguo());
                return;
            }
            this.f35800l.add(new ArrayList());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwi
    public final zzak a() {
        zzwi[] zzwiVarArr = this.f35799k;
        return zzwiVarArr.length > 0 ? zzwiVarArr[0].a() : r;
    }

    @Override // com.google.android.gms.internal.ads.zzvo, com.google.android.gms.internal.ads.zzwi
    public final void f() throws zzwv {
        zzwv zzwvVar = this.q;
        if (zzwvVar != null) {
            throw zzwvVar;
        }
        super.f();
    }

    @Override // com.google.android.gms.internal.ads.zzwi
    public final void g(zzak zzakVar) {
        this.f35799k[0].g(zzakVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwi
    public final void k(zzwe zzweVar) {
        zzwu zzwuVar = (zzwu) zzweVar;
        int i2 = 0;
        while (true) {
            zzwi[] zzwiVarArr = this.f35799k;
            if (i2 >= zzwiVarArr.length) {
                return;
            }
            List list = (List) this.f35800l.get(i2);
            boolean z = zzwuVar.f35789b[i2];
            zzwe[] zzweVarArr = zzwuVar.f35788a;
            zzwe zzweVar2 = z ? ((zzye) zzweVarArr[i2]).f35899a : zzweVarArr[i2];
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    break;
                }
                if (((zzww) list.get(i3)).f35798b.equals(zzweVar2)) {
                    list.remove(i3);
                    break;
                }
                i3++;
            }
            zzwiVarArr[i2].k(zzwuVar.f35789b[i2] ? ((zzye) zzweVarArr[i2]).f35899a : zzweVarArr[i2]);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwi
    public final zzwe l(zzwg zzwgVar, zzaah zzaahVar, long j2) {
        zzwi[] zzwiVarArr = this.f35799k;
        int length = zzwiVarArr.length;
        zzwe[] zzweVarArr = new zzwe[length];
        zzbf[] zzbfVarArr = this.f35801m;
        int iE = zzbfVarArr[0].e(zzwgVar.f35758a);
        for (int i2 = 0; i2 < length; i2++) {
            zzwg zzwgVarA = zzwgVar.a(zzbfVarArr[i2].f(iE));
            zzweVarArr[i2] = zzwiVarArr[i2].l(zzwgVarA, zzaahVar, j2 - this.p[iE][i2]);
            ((List) this.f35800l.get(i2)).add(new zzww(zzwgVarA, zzweVarArr[i2]));
        }
        return new zzwu(this.p[iE], zzweVarArr);
    }

    @Override // com.google.android.gms.internal.ads.zzvo, com.google.android.gms.internal.ads.zzvf
    public final void p(zzhz zzhzVar) {
        super.p(zzhzVar);
        int i2 = 0;
        while (true) {
            zzwi[] zzwiVarArr = this.f35799k;
            if (i2 >= zzwiVarArr.length) {
                return;
            }
            u(Integer.valueOf(i2), zzwiVarArr[i2]);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvo, com.google.android.gms.internal.ads.zzvf
    public final void r() {
        super.r();
        Arrays.fill(this.f35801m, (Object) null);
        this.o = -1;
        this.q = null;
        ArrayList arrayList = this.n;
        arrayList.clear();
        Collections.addAll(arrayList, this.f35799k);
    }

    @Override // com.google.android.gms.internal.ads.zzvo
    public final void t(Integer num, zzvf zzvfVar, zzbf zzbfVar) {
        int iC;
        if (this.q != null) {
            return;
        }
        if (this.o == -1) {
            iC = zzbfVar.c();
            this.o = iC;
        } else {
            int iC2 = zzbfVar.c();
            int i2 = this.o;
            if (iC2 != i2) {
                this.q = new zzwv();
                return;
            }
            iC = i2;
        }
        int length = this.p.length;
        zzbf[] zzbfVarArr = this.f35801m;
        if (length == 0) {
            this.p = (long[][]) Array.newInstance((Class<?>) Long.TYPE, iC, zzbfVarArr.length);
        }
        ArrayList arrayList = this.n;
        arrayList.remove(zzvfVar);
        zzbfVarArr[num.intValue()] = zzbfVar;
        if (arrayList.isEmpty()) {
            s(zzbfVarArr[0]);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvo
    public final /* synthetic */ zzwg w(Integer num, zzwg zzwgVar) {
        int iIntValue = num.intValue();
        ArrayList arrayList = this.f35800l;
        List list = (List) arrayList.get(iIntValue);
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (((zzww) list.get(i2)).f35797a.equals(zzwgVar)) {
                return ((zzww) ((List) arrayList.get(0)).get(i2)).f35797a;
            }
        }
        return null;
    }
}
