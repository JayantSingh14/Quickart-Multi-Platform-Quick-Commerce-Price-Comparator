package com.google.android.gms.internal.pal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Set;

/* loaded from: classes4.dex */
public final class zzzr extends AbstractMap implements Serializable {

    /* renamed from: h, reason: collision with root package name */
    public static final Comparator f38184h = new zzzk();

    /* renamed from: a, reason: collision with root package name */
    public final Comparator f38185a;

    /* renamed from: b, reason: collision with root package name */
    public zzzq f38186b;

    /* renamed from: c, reason: collision with root package name */
    public int f38187c;

    /* renamed from: d, reason: collision with root package name */
    public int f38188d;

    /* renamed from: e, reason: collision with root package name */
    public final zzzq f38189e;

    /* renamed from: f, reason: collision with root package name */
    public zzzm f38190f;

    /* renamed from: g, reason: collision with root package name */
    public zzzo f38191g;

    public zzzr() {
        Comparator comparator = f38184h;
        this.f38187c = 0;
        this.f38188d = 0;
        this.f38189e = new zzzq();
        this.f38185a = comparator;
    }

    public final zzzq a(Object obj, boolean z) {
        int iCompareTo;
        zzzq zzzqVar;
        Comparator comparator = this.f38185a;
        zzzq zzzqVar2 = this.f38186b;
        Comparator comparator2 = f38184h;
        if (zzzqVar2 != null) {
            Comparable comparable = comparator == comparator2 ? (Comparable) obj : null;
            while (true) {
                Object obj2 = zzzqVar2.f38181f;
                iCompareTo = comparable != null ? comparable.compareTo(obj2) : ((zzzk) comparator).compare(obj, obj2);
                if (iCompareTo == 0) {
                    return zzzqVar2;
                }
                zzzq zzzqVar3 = iCompareTo < 0 ? zzzqVar2.f38177b : zzzqVar2.f38178c;
                if (zzzqVar3 == null) {
                    break;
                }
                zzzqVar2 = zzzqVar3;
            }
        } else {
            iCompareTo = 0;
        }
        if (!z) {
            return null;
        }
        zzzq zzzqVar4 = this.f38189e;
        if (zzzqVar2 != null) {
            zzzqVar = new zzzq(zzzqVar2, obj, zzzqVar4, zzzqVar4.f38180e);
            if (iCompareTo < 0) {
                zzzqVar2.f38177b = zzzqVar;
            } else {
                zzzqVar2.f38178c = zzzqVar;
            }
            c(zzzqVar2, true);
        } else {
            if (comparator == comparator2 && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName().concat(" is not Comparable"));
            }
            zzzqVar = new zzzq(null, obj, zzzqVar4, zzzqVar4.f38180e);
            this.f38186b = zzzqVar;
        }
        this.f38187c++;
        this.f38188d++;
        return zzzqVar;
    }

    public final void b(zzzq zzzqVar, boolean z) {
        zzzq zzzqVar2;
        zzzq zzzqVar3;
        int i2;
        if (z) {
            zzzq zzzqVar4 = zzzqVar.f38180e;
            zzzqVar4.f38179d = zzzqVar.f38179d;
            zzzqVar.f38179d.f38180e = zzzqVar4;
        }
        zzzq zzzqVar5 = zzzqVar.f38177b;
        zzzq zzzqVar6 = zzzqVar.f38178c;
        zzzq zzzqVar7 = zzzqVar.f38176a;
        int i3 = 0;
        if (zzzqVar5 == null || zzzqVar6 == null) {
            if (zzzqVar5 != null) {
                d(zzzqVar, zzzqVar5);
                zzzqVar.f38177b = null;
            } else if (zzzqVar6 != null) {
                d(zzzqVar, zzzqVar6);
                zzzqVar.f38178c = null;
            } else {
                d(zzzqVar, null);
            }
            c(zzzqVar7, false);
            this.f38187c--;
            this.f38188d++;
            return;
        }
        if (zzzqVar5.f38183h > zzzqVar6.f38183h) {
            do {
                zzzqVar3 = zzzqVar5;
                zzzqVar5 = zzzqVar5.f38178c;
            } while (zzzqVar5 != null);
        } else {
            do {
                zzzqVar2 = zzzqVar6;
                zzzqVar6 = zzzqVar6.f38177b;
            } while (zzzqVar6 != null);
            zzzqVar3 = zzzqVar2;
        }
        b(zzzqVar3, false);
        zzzq zzzqVar8 = zzzqVar.f38177b;
        if (zzzqVar8 != null) {
            i2 = zzzqVar8.f38183h;
            zzzqVar3.f38177b = zzzqVar8;
            zzzqVar8.f38176a = zzzqVar3;
            zzzqVar.f38177b = null;
        } else {
            i2 = 0;
        }
        zzzq zzzqVar9 = zzzqVar.f38178c;
        if (zzzqVar9 != null) {
            i3 = zzzqVar9.f38183h;
            zzzqVar3.f38178c = zzzqVar9;
            zzzqVar9.f38176a = zzzqVar3;
            zzzqVar.f38178c = null;
        }
        zzzqVar3.f38183h = Math.max(i2, i3) + 1;
        d(zzzqVar, zzzqVar3);
    }

    public final void c(zzzq zzzqVar, boolean z) {
        while (zzzqVar != null) {
            zzzq zzzqVar2 = zzzqVar.f38177b;
            zzzq zzzqVar3 = zzzqVar.f38178c;
            int i2 = zzzqVar2 != null ? zzzqVar2.f38183h : 0;
            int i3 = zzzqVar3 != null ? zzzqVar3.f38183h : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                zzzq zzzqVar4 = zzzqVar3.f38177b;
                zzzq zzzqVar5 = zzzqVar3.f38178c;
                int i5 = (zzzqVar4 != null ? zzzqVar4.f38183h : 0) - (zzzqVar5 != null ? zzzqVar5.f38183h : 0);
                if (i5 == -1 || (i5 == 0 && !z)) {
                    e(zzzqVar);
                } else {
                    f(zzzqVar3);
                    e(zzzqVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                zzzq zzzqVar6 = zzzqVar2.f38177b;
                zzzq zzzqVar7 = zzzqVar2.f38178c;
                int i6 = (zzzqVar6 != null ? zzzqVar6.f38183h : 0) - (zzzqVar7 != null ? zzzqVar7.f38183h : 0);
                if (i6 == 1 || (i6 == 0 && !z)) {
                    f(zzzqVar);
                } else {
                    e(zzzqVar2);
                    f(zzzqVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                zzzqVar.f38183h = i2 + 1;
                if (z) {
                    return;
                }
            } else {
                zzzqVar.f38183h = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            zzzqVar = zzzqVar.f38176a;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.f38186b = null;
        this.f38187c = 0;
        this.f38188d++;
        zzzq zzzqVar = this.f38189e;
        zzzqVar.f38180e = zzzqVar;
        zzzqVar.f38179d = zzzqVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        zzzq zzzqVarA = null;
        if (obj != null) {
            try {
                zzzqVarA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return zzzqVarA != null;
    }

    public final void d(zzzq zzzqVar, zzzq zzzqVar2) {
        zzzq zzzqVar3 = zzzqVar.f38176a;
        zzzqVar.f38176a = null;
        if (zzzqVar2 != null) {
            zzzqVar2.f38176a = zzzqVar3;
        }
        if (zzzqVar3 == null) {
            this.f38186b = zzzqVar2;
        } else if (zzzqVar3.f38177b == zzzqVar) {
            zzzqVar3.f38177b = zzzqVar2;
        } else {
            zzzqVar3.f38178c = zzzqVar2;
        }
    }

    public final void e(zzzq zzzqVar) {
        zzzq zzzqVar2 = zzzqVar.f38177b;
        zzzq zzzqVar3 = zzzqVar.f38178c;
        zzzq zzzqVar4 = zzzqVar3.f38177b;
        zzzq zzzqVar5 = zzzqVar3.f38178c;
        zzzqVar.f38178c = zzzqVar4;
        if (zzzqVar4 != null) {
            zzzqVar4.f38176a = zzzqVar;
        }
        d(zzzqVar, zzzqVar3);
        zzzqVar3.f38177b = zzzqVar;
        zzzqVar.f38176a = zzzqVar3;
        int iMax = Math.max(zzzqVar2 != null ? zzzqVar2.f38183h : 0, zzzqVar4 != null ? zzzqVar4.f38183h : 0) + 1;
        zzzqVar.f38183h = iMax;
        zzzqVar3.f38183h = Math.max(iMax, zzzqVar5 != null ? zzzqVar5.f38183h : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        zzzm zzzmVar = this.f38190f;
        if (zzzmVar != null) {
            return zzzmVar;
        }
        zzzm zzzmVar2 = new zzzm(this);
        this.f38190f = zzzmVar2;
        return zzzmVar2;
    }

    public final void f(zzzq zzzqVar) {
        zzzq zzzqVar2 = zzzqVar.f38177b;
        zzzq zzzqVar3 = zzzqVar.f38178c;
        zzzq zzzqVar4 = zzzqVar2.f38177b;
        zzzq zzzqVar5 = zzzqVar2.f38178c;
        zzzqVar.f38177b = zzzqVar5;
        if (zzzqVar5 != null) {
            zzzqVar5.f38176a = zzzqVar;
        }
        d(zzzqVar, zzzqVar2);
        zzzqVar2.f38178c = zzzqVar;
        zzzqVar.f38176a = zzzqVar2;
        int iMax = Math.max(zzzqVar3 != null ? zzzqVar3.f38183h : 0, zzzqVar5 != null ? zzzqVar5.f38183h : 0) + 1;
        zzzqVar.f38183h = iMax;
        zzzqVar2.f38183h = Math.max(iMax, zzzqVar4 != null ? zzzqVar4.f38183h : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        zzzq zzzqVarA;
        if (obj != null) {
            try {
                zzzqVarA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        } else {
            zzzqVarA = null;
        }
        if (zzzqVarA != null) {
            return zzzqVarA.f38182g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        zzzo zzzoVar = this.f38191g;
        if (zzzoVar != null) {
            return zzzoVar;
        }
        zzzo zzzoVar2 = new zzzo(this);
        this.f38191g = zzzoVar2;
        return zzzoVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        zzzq zzzqVarA = a(obj, true);
        Object obj3 = zzzqVarA.f38182g;
        zzzqVarA.f38182g = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        zzzq zzzqVarA;
        if (obj != null) {
            try {
                zzzqVarA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        } else {
            zzzqVarA = null;
        }
        if (zzzqVarA != null) {
            b(zzzqVarA, true);
        }
        if (zzzqVarA != null) {
            return zzzqVarA.f38182g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f38187c;
    }
}
