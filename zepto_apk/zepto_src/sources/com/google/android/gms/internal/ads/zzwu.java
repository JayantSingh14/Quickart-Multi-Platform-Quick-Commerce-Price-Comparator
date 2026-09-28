package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;

/* loaded from: classes4.dex */
final class zzwu implements zzwe, zzwd {

    /* renamed from: a, reason: collision with root package name */
    public final zzwe[] f35788a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean[] f35789b;

    /* renamed from: c, reason: collision with root package name */
    public final IdentityHashMap f35790c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f35791d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f35792e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public zzwd f35793f;

    /* renamed from: g, reason: collision with root package name */
    public zzyh f35794g;

    /* renamed from: h, reason: collision with root package name */
    public zzwe[] f35795h;

    /* renamed from: i, reason: collision with root package name */
    public zzvq f35796i;

    public zzwu(long[] jArr, zzwe... zzweVarArr) {
        this.f35788a = zzweVarArr;
        zzgvs zzgvsVar = zzgtd.f33183b;
        zzgtd zzgtdVar = zzguy.f33232e;
        this.f35796i = new zzvq(zzgtdVar, zzgtdVar);
        this.f35790c = new IdentityHashMap();
        this.f35795h = new zzwe[0];
        this.f35789b = new boolean[zzweVarArr.length];
        for (int i2 = 0; i2 < zzweVarArr.length; i2++) {
            long j2 = jArr[i2];
            if (j2 != 0) {
                this.f35789b[i2] = true;
                this.f35788a[i2] = new zzye(zzweVarArr[i2], j2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final long a(long j2) {
        long jA = this.f35795h[0].a(j2);
        int i2 = 1;
        while (true) {
            zzwe[] zzweVarArr = this.f35795h;
            if (i2 >= zzweVarArr.length) {
                return jA;
            }
            if (zzweVarArr[i2].a(jA) != jA) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final boolean b(zzli zzliVar) {
        ArrayList arrayList = this.f35791d;
        if (arrayList.isEmpty()) {
            return this.f35796i.b(zzliVar);
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((zzwe) arrayList.get(i2)).b(zzliVar);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final void c(long j2) {
        for (zzwe zzweVar : this.f35795h) {
            zzweVar.c(j2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwd
    public final void d(zzwe zzweVar) {
        zzwe[] zzweVarArr;
        ArrayList arrayList = this.f35791d;
        arrayList.remove(zzweVar);
        if (arrayList.isEmpty()) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                zzweVarArr = this.f35788a;
                if (i2 >= zzweVarArr.length) {
                    break;
                }
                i3 += zzweVarArr[i2].zzd().f35905a;
                i2++;
            }
            zzbg[] zzbgVarArr = new zzbg[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < zzweVarArr.length; i5++) {
                zzyh zzyhVarZzd = zzweVarArr[i5].zzd();
                int i6 = zzyhVarZzd.f35905a;
                int i7 = 0;
                while (i7 < i6) {
                    zzbg zzbgVarA = zzyhVarZzd.a(i7);
                    int i8 = zzbgVarA.f24983a;
                    zzv[] zzvVarArr = new zzv[i8];
                    int i9 = 0;
                    while (i9 < i8) {
                        zzv zzvVar = zzbgVarA.f24986d[i9];
                        zzvVar.getClass();
                        zzt zztVar = new zzt(zzvVar);
                        String str = zzvVar.f35679a;
                        if (str == null) {
                            str = "";
                        }
                        zzwe[] zzweVarArr2 = zzweVarArr;
                        StringBuilder sb = new StringBuilder(str.length() + androidx.fragment.app.e.a(i5, 1));
                        sb.append(i5);
                        sb.append(":");
                        sb.append(str);
                        zztVar.f35564a = sb.toString();
                        zzvVarArr[i9] = new zzv(zztVar);
                        i9++;
                        zzweVarArr = zzweVarArr2;
                    }
                    zzwe[] zzweVarArr3 = zzweVarArr;
                    int iA = androidx.fragment.app.e.a(i5, 1);
                    String str2 = zzbgVarA.f24984b;
                    StringBuilder sb2 = new StringBuilder(iA + String.valueOf(str2).length());
                    sb2.append(i5);
                    sb2.append(":");
                    sb2.append(str2);
                    zzbg zzbgVar = new zzbg(sb2.toString(), zzvVarArr);
                    this.f35792e.put(zzbgVar, zzbgVarA);
                    zzbgVarArr[i4] = zzbgVar;
                    i7++;
                    i4++;
                    zzweVarArr = zzweVarArr3;
                }
            }
            this.f35794g = new zzyh(zzbgVarArr);
            zzwd zzwdVar = this.f35793f;
            zzwdVar.getClass();
            zzwdVar.d(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxx
    public final /* bridge */ /* synthetic */ void e(zzxy zzxyVar) {
        zzwd zzwdVar = this.f35793f;
        zzwdVar.getClass();
        zzwdVar.e(this);
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final long f(zzzw[] zzzwVarArr, boolean[] zArr, zzxw[] zzxwVarArr, boolean[] zArr2, long j2) {
        int length;
        IdentityHashMap identityHashMap;
        int[] iArr;
        int[] iArr2;
        int length2 = zzzwVarArr.length;
        int[] iArr3 = new int[length2];
        int[] iArr4 = new int[length2];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            length = zzzwVarArr.length;
            identityHashMap = this.f35790c;
            if (i3 >= length) {
                break;
            }
            zzxw zzxwVar = zzxwVarArr[i3];
            Integer num = zzxwVar == null ? null : (Integer) identityHashMap.get(zzxwVar);
            iArr3[i3] = num == null ? -1 : num.intValue();
            zzzw zzzwVar = zzzwVarArr[i3];
            if (zzzwVar != null) {
                String str = zzzwVar.zza().f24984b;
                iArr4[i3] = Integer.parseInt(str.substring(0, str.indexOf(":")));
            } else {
                iArr4[i3] = -1;
            }
            i3++;
        }
        identityHashMap.clear();
        zzxw[] zzxwVarArr2 = new zzxw[length];
        zzxw[] zzxwVarArr3 = new zzxw[length];
        zzzw[] zzzwVarArr2 = new zzzw[length];
        zzwe[] zzweVarArr = this.f35788a;
        ArrayList arrayList = new ArrayList(zzweVarArr.length);
        long j3 = j2;
        int i4 = 0;
        while (i4 < zzweVarArr.length) {
            int i5 = i2;
            while (i5 < zzzwVarArr.length) {
                zzxwVarArr3[i5] = iArr3[i5] == i4 ? zzxwVarArr[i5] : null;
                if (iArr4[i5] == i4) {
                    zzzw zzzwVar2 = zzzwVarArr[i5];
                    zzzwVar2.getClass();
                    iArr = iArr4;
                    iArr2 = iArr3;
                    zzbg zzbgVar = (zzbg) this.f35792e.get(zzzwVar2.zza());
                    zzbgVar.getClass();
                    zzzwVarArr2[i5] = new zzwt(zzzwVar2, zzbgVar);
                } else {
                    iArr = iArr4;
                    iArr2 = iArr3;
                    zzzwVarArr2[i5] = null;
                }
                i5++;
                iArr4 = iArr;
                iArr3 = iArr2;
            }
            int[] iArr5 = iArr4;
            int[] iArr6 = iArr3;
            ArrayList arrayList2 = arrayList;
            zzwe[] zzweVarArr2 = zzweVarArr;
            int i6 = i4;
            long jF = zzweVarArr[i4].f(zzzwVarArr2, zArr, zzxwVarArr3, zArr2, j3);
            if (i6 == 0) {
                j3 = jF;
            } else if (jF != j3) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z = false;
            for (int i7 = 0; i7 < zzzwVarArr.length; i7++) {
                if (iArr5[i7] == i6) {
                    zzxw zzxwVar2 = zzxwVarArr3[i7];
                    zzxwVar2.getClass();
                    zzxwVarArr2[i7] = zzxwVar2;
                    identityHashMap.put(zzxwVar2, Integer.valueOf(i6));
                    z = true;
                } else if (iArr6[i7] == i6) {
                    zzgqa.f(zzxwVarArr3[i7] == null);
                }
            }
            if (z) {
                arrayList2.add(zzweVarArr2[i6]);
            }
            i4 = i6 + 1;
            arrayList = arrayList2;
            zzweVarArr = zzweVarArr2;
            iArr4 = iArr5;
            iArr3 = iArr6;
            i2 = 0;
        }
        int i8 = i2;
        ArrayList arrayList3 = arrayList;
        System.arraycopy(zzxwVarArr2, i8, zzxwVarArr, i8, length);
        this.f35795h = (zzwe[]) arrayList3.toArray(new zzwe[i8]);
        this.f35796i = new zzvq(arrayList3, zzgud.b(arrayList3, zzws.f35786a));
        return j3;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final void g(long j2) {
        this.f35796i.g(j2);
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final long i(long j2, zzmq zzmqVar) {
        zzwe[] zzweVarArr = this.f35795h;
        return (zzweVarArr.length > 0 ? zzweVarArr[0] : this.f35788a[0]).i(j2, zzmqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final void j(zzwd zzwdVar, long j2) {
        this.f35793f = zzwdVar;
        ArrayList arrayList = this.f35791d;
        zzwe[] zzweVarArr = this.f35788a;
        Collections.addAll(arrayList, zzweVarArr);
        for (zzwe zzweVar : zzweVarArr) {
            zzweVar.j(this, j2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final void zzc() {
        int i2 = 0;
        while (true) {
            zzwe[] zzweVarArr = this.f35788a;
            if (i2 >= zzweVarArr.length) {
                return;
            }
            zzweVarArr[i2].zzc();
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final zzyh zzd() {
        zzyh zzyhVar = this.f35794g;
        zzyhVar.getClass();
        return zzyhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final long zzh() {
        long j2 = -9223372036854775807L;
        for (zzwe zzweVar : this.f35795h) {
            long jZzh = zzweVar.zzh();
            if (jZzh == -9223372036854775807L) {
                if (j2 != -9223372036854775807L && zzweVar.a(j2) != j2) {
                    throw new IllegalStateException("Unexpected child seekToUs result.");
                }
            } else if (j2 == -9223372036854775807L) {
                for (zzwe zzweVar2 : this.f35795h) {
                    if (zzweVar2 == zzweVar) {
                        break;
                    }
                    if (zzweVar2.a(jZzh) != jZzh) {
                        throw new IllegalStateException("Unexpected child seekToUs result.");
                    }
                }
                j2 = jZzh;
            } else if (jZzh != j2) {
                throw new IllegalStateException("Conflicting discontinuities.");
            }
        }
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final long zzi() {
        return this.f35796i.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final long zzl() {
        return this.f35796i.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final boolean zzn() {
        return this.f35796i.zzn();
    }
}
