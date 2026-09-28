package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Set;

/* loaded from: classes4.dex */
public final class zzhya extends AbstractMap implements Serializable {

    /* renamed from: i, reason: collision with root package name */
    public static final Comparator f34495i = new zzhxt();

    /* renamed from: a, reason: collision with root package name */
    public final Comparator f34496a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f34497b;

    /* renamed from: c, reason: collision with root package name */
    public zzhxz f34498c;

    /* renamed from: d, reason: collision with root package name */
    public int f34499d;

    /* renamed from: e, reason: collision with root package name */
    public int f34500e;

    /* renamed from: f, reason: collision with root package name */
    public final zzhxz f34501f;

    /* renamed from: g, reason: collision with root package name */
    public zzhxv f34502g;

    /* renamed from: h, reason: collision with root package name */
    public zzhxx f34503h;

    public zzhya() {
        this(true);
    }

    public final zzhxz a(Object obj, boolean z) {
        int iCompareTo;
        zzhxz zzhxzVar;
        zzhxz zzhxzVar2 = this.f34498c;
        Comparator comparator = f34495i;
        Comparator comparator2 = this.f34496a;
        if (zzhxzVar2 != null) {
            Comparable comparable = comparator2 == comparator ? (Comparable) obj : null;
            while (true) {
                Object obj2 = zzhxzVar2.f34488f;
                iCompareTo = comparable != null ? comparable.compareTo(obj2) : ((zzhxt) comparator2).compare(obj, obj2);
                if (iCompareTo == 0) {
                    return zzhxzVar2;
                }
                zzhxz zzhxzVar3 = iCompareTo < 0 ? zzhxzVar2.f34484b : zzhxzVar2.f34485c;
                if (zzhxzVar3 == null) {
                    break;
                }
                zzhxzVar2 = zzhxzVar3;
            }
        } else {
            iCompareTo = 0;
        }
        if (!z) {
            return null;
        }
        zzhxz zzhxzVar4 = this.f34501f;
        if (zzhxzVar2 != null) {
            zzhxz zzhxzVar5 = zzhxzVar2;
            zzhxzVar = new zzhxz(this.f34497b, zzhxzVar5, obj, zzhxzVar4, zzhxzVar4.f34487e);
            if (iCompareTo < 0) {
                zzhxzVar5.f34484b = zzhxzVar;
            } else {
                zzhxzVar5.f34485c = zzhxzVar;
            }
            d(zzhxzVar5, true);
        } else {
            if (comparator2 == comparator && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName().concat(" is not Comparable"));
            }
            zzhxzVar = new zzhxz(this.f34497b, null, obj, zzhxzVar4, zzhxzVar4.f34487e);
            this.f34498c = zzhxzVar;
        }
        this.f34499d++;
        this.f34500e++;
        return zzhxzVar;
    }

    public final void b(zzhxz zzhxzVar, boolean z) {
        zzhxz zzhxzVar2;
        zzhxz zzhxzVar3;
        int i2;
        if (z) {
            zzhxz zzhxzVar4 = zzhxzVar.f34487e;
            zzhxzVar4.f34486d = zzhxzVar.f34486d;
            zzhxzVar.f34486d.f34487e = zzhxzVar4;
        }
        zzhxz zzhxzVar5 = zzhxzVar.f34484b;
        zzhxz zzhxzVar6 = zzhxzVar.f34485c;
        zzhxz zzhxzVar7 = zzhxzVar.f34483a;
        int i3 = 0;
        if (zzhxzVar5 == null || zzhxzVar6 == null) {
            if (zzhxzVar5 != null) {
                c(zzhxzVar, zzhxzVar5);
                zzhxzVar.f34484b = null;
            } else if (zzhxzVar6 != null) {
                c(zzhxzVar, zzhxzVar6);
                zzhxzVar.f34485c = null;
            } else {
                c(zzhxzVar, null);
            }
            d(zzhxzVar7, false);
            this.f34499d--;
            this.f34500e++;
            return;
        }
        if (zzhxzVar5.f34491i > zzhxzVar6.f34491i) {
            do {
                zzhxzVar3 = zzhxzVar5;
                zzhxzVar5 = zzhxzVar5.f34485c;
            } while (zzhxzVar5 != null);
        } else {
            do {
                zzhxzVar2 = zzhxzVar6;
                zzhxzVar6 = zzhxzVar6.f34484b;
            } while (zzhxzVar6 != null);
            zzhxzVar3 = zzhxzVar2;
        }
        b(zzhxzVar3, false);
        zzhxz zzhxzVar8 = zzhxzVar.f34484b;
        if (zzhxzVar8 != null) {
            i2 = zzhxzVar8.f34491i;
            zzhxzVar3.f34484b = zzhxzVar8;
            zzhxzVar8.f34483a = zzhxzVar3;
            zzhxzVar.f34484b = null;
        } else {
            i2 = 0;
        }
        zzhxz zzhxzVar9 = zzhxzVar.f34485c;
        if (zzhxzVar9 != null) {
            i3 = zzhxzVar9.f34491i;
            zzhxzVar3.f34485c = zzhxzVar9;
            zzhxzVar9.f34483a = zzhxzVar3;
            zzhxzVar.f34485c = null;
        }
        zzhxzVar3.f34491i = Math.max(i2, i3) + 1;
        c(zzhxzVar, zzhxzVar3);
    }

    public final void c(zzhxz zzhxzVar, zzhxz zzhxzVar2) {
        zzhxz zzhxzVar3 = zzhxzVar.f34483a;
        zzhxzVar.f34483a = null;
        if (zzhxzVar2 != null) {
            zzhxzVar2.f34483a = zzhxzVar3;
        }
        if (zzhxzVar3 == null) {
            this.f34498c = zzhxzVar2;
        } else if (zzhxzVar3.f34484b == zzhxzVar) {
            zzhxzVar3.f34484b = zzhxzVar2;
        } else {
            zzhxzVar3.f34485c = zzhxzVar2;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.f34498c = null;
        this.f34499d = 0;
        this.f34500e++;
        zzhxz zzhxzVar = this.f34501f;
        zzhxzVar.f34487e = zzhxzVar;
        zzhxzVar.f34486d = zzhxzVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        zzhxz zzhxzVarA = null;
        if (obj != null) {
            try {
                zzhxzVarA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return zzhxzVarA != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0080 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0080 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(com.google.android.gms.internal.ads.zzhxz r9, boolean r10) {
        /*
            r8 = this;
        L0:
            if (r9 == 0) goto L84
            com.google.android.gms.internal.ads.zzhxz r0 = r9.f34484b
            com.google.android.gms.internal.ads.zzhxz r1 = r9.f34485c
            r2 = 0
            if (r0 == 0) goto Lc
            int r3 = r0.f34491i
            goto Ld
        Lc:
            r3 = r2
        Ld:
            if (r1 == 0) goto L12
            int r4 = r1.f34491i
            goto L13
        L12:
            r4 = r2
        L13:
            int r5 = r3 - r4
            r6 = -2
            r7 = 1
            if (r5 != r6) goto L42
            com.google.android.gms.internal.ads.zzhxz r0 = r1.f34484b
            com.google.android.gms.internal.ads.zzhxz r3 = r1.f34485c
            if (r3 == 0) goto L22
            int r3 = r3.f34491i
            goto L23
        L22:
            r3 = r2
        L23:
            if (r0 == 0) goto L28
            int r0 = r0.f34491i
            goto L29
        L28:
            r0 = r2
        L29:
            int r0 = r0 - r3
            r3 = -1
            if (r0 == r3) goto L3a
            if (r0 != 0) goto L32
            if (r10 != 0) goto L33
            goto L3b
        L32:
            r7 = r10
        L33:
            r8.f(r1)
            r8.e(r9)
            goto L3f
        L3a:
            r2 = r10
        L3b:
            r8.e(r9)
            r7 = r2
        L3f:
            if (r7 != 0) goto L84
            goto L80
        L42:
            r1 = 2
            if (r5 != r1) goto L6d
            com.google.android.gms.internal.ads.zzhxz r1 = r0.f34484b
            com.google.android.gms.internal.ads.zzhxz r3 = r0.f34485c
            if (r3 == 0) goto L4e
            int r3 = r3.f34491i
            goto L4f
        L4e:
            r3 = r2
        L4f:
            if (r1 == 0) goto L54
            int r1 = r1.f34491i
            goto L55
        L54:
            r1 = r2
        L55:
            int r1 = r1 - r3
            if (r1 == r7) goto L65
            if (r1 != 0) goto L5d
            if (r10 != 0) goto L5e
            goto L66
        L5d:
            r7 = r10
        L5e:
            r8.e(r0)
            r8.f(r9)
            goto L6a
        L65:
            r2 = r10
        L66:
            r8.f(r9)
            r7 = r2
        L6a:
            if (r7 == 0) goto L80
            goto L84
        L6d:
            if (r5 != 0) goto L76
            int r3 = r3 + 1
            r9.f34491i = r3
            if (r10 == 0) goto L80
            goto L84
        L76:
            int r0 = java.lang.Math.max(r3, r4)
            int r0 = r0 + r7
            r9.f34491i = r0
            if (r10 != 0) goto L80
            goto L84
        L80:
            com.google.android.gms.internal.ads.zzhxz r9 = r9.f34483a
            goto L0
        L84:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhya.d(com.google.android.gms.internal.ads.zzhxz, boolean):void");
    }

    public final void e(zzhxz zzhxzVar) {
        zzhxz zzhxzVar2 = zzhxzVar.f34484b;
        zzhxz zzhxzVar3 = zzhxzVar.f34485c;
        zzhxz zzhxzVar4 = zzhxzVar3.f34484b;
        zzhxz zzhxzVar5 = zzhxzVar3.f34485c;
        zzhxzVar.f34485c = zzhxzVar4;
        if (zzhxzVar4 != null) {
            zzhxzVar4.f34483a = zzhxzVar;
        }
        c(zzhxzVar, zzhxzVar3);
        zzhxzVar3.f34484b = zzhxzVar;
        zzhxzVar.f34483a = zzhxzVar3;
        int iMax = Math.max(zzhxzVar2 != null ? zzhxzVar2.f34491i : 0, zzhxzVar4 != null ? zzhxzVar4.f34491i : 0) + 1;
        zzhxzVar.f34491i = iMax;
        zzhxzVar3.f34491i = Math.max(iMax, zzhxzVar5 != null ? zzhxzVar5.f34491i : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        zzhxv zzhxvVar = this.f34502g;
        if (zzhxvVar != null) {
            return zzhxvVar;
        }
        zzhxv zzhxvVar2 = new zzhxv(this);
        this.f34502g = zzhxvVar2;
        return zzhxvVar2;
    }

    public final void f(zzhxz zzhxzVar) {
        zzhxz zzhxzVar2 = zzhxzVar.f34484b;
        zzhxz zzhxzVar3 = zzhxzVar.f34485c;
        zzhxz zzhxzVar4 = zzhxzVar2.f34484b;
        zzhxz zzhxzVar5 = zzhxzVar2.f34485c;
        zzhxzVar.f34484b = zzhxzVar5;
        if (zzhxzVar5 != null) {
            zzhxzVar5.f34483a = zzhxzVar;
        }
        c(zzhxzVar, zzhxzVar2);
        zzhxzVar2.f34485c = zzhxzVar;
        zzhxzVar.f34483a = zzhxzVar2;
        int iMax = Math.max(zzhxzVar3 != null ? zzhxzVar3.f34491i : 0, zzhxzVar5 != null ? zzhxzVar5.f34491i : 0) + 1;
        zzhxzVar.f34491i = iMax;
        zzhxzVar2.f34491i = Math.max(iMax, zzhxzVar4 != null ? zzhxzVar4.f34491i : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        zzhxz zzhxzVarA;
        if (obj != null) {
            try {
                zzhxzVarA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        } else {
            zzhxzVarA = null;
        }
        if (zzhxzVarA != null) {
            return zzhxzVarA.f34490h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        zzhxx zzhxxVar = this.f34503h;
        if (zzhxxVar != null) {
            return zzhxxVar;
        }
        zzhxx zzhxxVar2 = new zzhxx(this);
        this.f34503h = zzhxxVar2;
        return zzhxxVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        if (obj2 == null && !this.f34497b) {
            throw new NullPointerException("value == null");
        }
        zzhxz zzhxzVarA = a(obj, true);
        Object obj3 = zzhxzVarA.f34490h;
        zzhxzVarA.f34490h = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        zzhxz zzhxzVarA;
        if (obj != null) {
            try {
                zzhxzVarA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        } else {
            zzhxzVarA = null;
        }
        if (zzhxzVarA != null) {
            b(zzhxzVarA, true);
        }
        if (zzhxzVarA != null) {
            return zzhxzVarA.f34490h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f34499d;
    }

    public zzhya(boolean z) {
        Comparator comparator = f34495i;
        this.f34499d = 0;
        this.f34500e = 0;
        this.f34496a = comparator;
        this.f34497b = z;
        this.f34501f = new zzhxz(z);
    }
}
