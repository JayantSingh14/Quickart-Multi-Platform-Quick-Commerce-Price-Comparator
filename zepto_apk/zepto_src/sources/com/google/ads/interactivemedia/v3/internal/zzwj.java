package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes3.dex */
public final class zzwj extends AbstractMap implements Serializable {
    private static final Comparator zze = new zzwc();
    zzwi zza;
    int zzb;
    int zzc;
    final zzwi zzd;
    private final Comparator zzf;
    private final boolean zzg;
    private zzwe zzh;
    private zzwg zzi;

    public zzwj() {
        this(zze, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0080 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0080 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzf(com.google.ads.interactivemedia.v3.internal.zzwi r9, boolean r10) {
        /*
            r8 = this;
        L0:
            if (r9 == 0) goto L84
            com.google.ads.interactivemedia.v3.internal.zzwi r0 = r9.zzb
            com.google.ads.interactivemedia.v3.internal.zzwi r1 = r9.zzc
            r2 = 0
            if (r0 == 0) goto Lc
            int r3 = r0.zzi
            goto Ld
        Lc:
            r3 = r2
        Ld:
            if (r1 == 0) goto L12
            int r4 = r1.zzi
            goto L13
        L12:
            r4 = r2
        L13:
            int r5 = r3 - r4
            r6 = -2
            r7 = 1
            if (r5 != r6) goto L42
            com.google.ads.interactivemedia.v3.internal.zzwi r0 = r1.zzb
            com.google.ads.interactivemedia.v3.internal.zzwi r3 = r1.zzc
            if (r3 == 0) goto L22
            int r3 = r3.zzi
            goto L23
        L22:
            r3 = r2
        L23:
            if (r0 == 0) goto L28
            int r0 = r0.zzi
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
            r8.zzi(r1)
            r8.zzh(r9)
            goto L3f
        L3a:
            r2 = r10
        L3b:
            r8.zzh(r9)
            r7 = r2
        L3f:
            if (r7 != 0) goto L84
            goto L80
        L42:
            r1 = 2
            if (r5 != r1) goto L6d
            com.google.ads.interactivemedia.v3.internal.zzwi r1 = r0.zzb
            com.google.ads.interactivemedia.v3.internal.zzwi r3 = r0.zzc
            if (r3 == 0) goto L4e
            int r3 = r3.zzi
            goto L4f
        L4e:
            r3 = r2
        L4f:
            if (r1 == 0) goto L54
            int r1 = r1.zzi
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
            r8.zzh(r0)
            r8.zzi(r9)
            goto L6a
        L65:
            r2 = r10
        L66:
            r8.zzi(r9)
            r7 = r2
        L6a:
            if (r7 == 0) goto L80
            goto L84
        L6d:
            if (r5 != 0) goto L76
            int r3 = r3 + 1
            r9.zzi = r3
            if (r10 == 0) goto L80
            goto L84
        L76:
            int r0 = java.lang.Math.max(r3, r4)
            int r0 = r0 + r7
            r9.zzi = r0
            if (r10 != 0) goto L80
            goto L84
        L80:
            com.google.ads.interactivemedia.v3.internal.zzwi r9 = r9.zza
            goto L0
        L84:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzwj.zzf(com.google.ads.interactivemedia.v3.internal.zzwi, boolean):void");
    }

    private final void zzg(zzwi zzwiVar, zzwi zzwiVar2) {
        zzwi zzwiVar3 = zzwiVar.zza;
        zzwiVar.zza = null;
        if (zzwiVar2 != null) {
            zzwiVar2.zza = zzwiVar3;
        }
        if (zzwiVar3 == null) {
            this.zza = zzwiVar2;
        } else if (zzwiVar3.zzb == zzwiVar) {
            zzwiVar3.zzb = zzwiVar2;
        } else {
            zzwiVar3.zzc = zzwiVar2;
        }
    }

    private final void zzh(zzwi zzwiVar) {
        zzwi zzwiVar2 = zzwiVar.zzb;
        zzwi zzwiVar3 = zzwiVar.zzc;
        zzwi zzwiVar4 = zzwiVar3.zzb;
        zzwi zzwiVar5 = zzwiVar3.zzc;
        zzwiVar.zzc = zzwiVar4;
        if (zzwiVar4 != null) {
            zzwiVar4.zza = zzwiVar;
        }
        zzg(zzwiVar, zzwiVar3);
        zzwiVar3.zzb = zzwiVar;
        zzwiVar.zza = zzwiVar3;
        int iMax = Math.max(zzwiVar2 != null ? zzwiVar2.zzi : 0, zzwiVar4 != null ? zzwiVar4.zzi : 0) + 1;
        zzwiVar.zzi = iMax;
        zzwiVar3.zzi = Math.max(iMax, zzwiVar5 != null ? zzwiVar5.zzi : 0) + 1;
    }

    private final void zzi(zzwi zzwiVar) {
        zzwi zzwiVar2 = zzwiVar.zzb;
        zzwi zzwiVar3 = zzwiVar.zzc;
        zzwi zzwiVar4 = zzwiVar2.zzb;
        zzwi zzwiVar5 = zzwiVar2.zzc;
        zzwiVar.zzb = zzwiVar5;
        if (zzwiVar5 != null) {
            zzwiVar5.zza = zzwiVar;
        }
        zzg(zzwiVar, zzwiVar2);
        zzwiVar2.zzc = zzwiVar;
        zzwiVar.zza = zzwiVar2;
        int iMax = Math.max(zzwiVar3 != null ? zzwiVar3.zzi : 0, zzwiVar5 != null ? zzwiVar5.zzi : 0) + 1;
        zzwiVar.zzi = iMax;
        zzwiVar2.zzi = Math.max(iMax, zzwiVar4 != null ? zzwiVar4.zzi : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.zza = null;
        this.zzb = 0;
        this.zzc++;
        zzwi zzwiVar = this.zzd;
        zzwiVar.zze = zzwiVar;
        zzwiVar.zzd = zzwiVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return zzc(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        zzwe zzweVar = this.zzh;
        if (zzweVar != null) {
            return zzweVar;
        }
        zzwe zzweVar2 = new zzwe(this);
        this.zzh = zzweVar2;
        return zzweVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        zzwi zzwiVarZzc = zzc(obj);
        if (zzwiVarZzc != null) {
            return zzwiVarZzc.zzh;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        zzwg zzwgVar = this.zzi;
        if (zzwgVar != null) {
            return zzwgVar;
        }
        zzwg zzwgVar2 = new zzwg(this);
        this.zzi = zzwgVar2;
        return zzwgVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        if (obj2 == null && !this.zzg) {
            throw new NullPointerException("value == null");
        }
        zzwi zzwiVarZza = zza(obj, true);
        Object obj3 = zzwiVarZza.zzh;
        zzwiVarZza.zzh = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        zzwi zzwiVarZzd = zzd(obj);
        if (zzwiVarZzd != null) {
            return zzwiVarZzd.zzh;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zzb;
    }

    public final zzwi zza(Object obj, boolean z) {
        int iCompareTo;
        zzwi zzwiVar;
        Comparator comparator = this.zzf;
        zzwi zzwiVar2 = this.zza;
        if (zzwiVar2 != null) {
            Comparable comparable = comparator == zze ? (Comparable) obj : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(zzwiVar2.zzf) : comparator.compare(obj, zzwiVar2.zzf);
                if (iCompareTo == 0) {
                    return zzwiVar2;
                }
                zzwi zzwiVar3 = iCompareTo < 0 ? zzwiVar2.zzb : zzwiVar2.zzc;
                if (zzwiVar3 == null) {
                    break;
                }
                zzwiVar2 = zzwiVar3;
            }
        } else {
            iCompareTo = 0;
        }
        int i2 = iCompareTo;
        if (!z) {
            return null;
        }
        zzwi zzwiVar4 = this.zzd;
        if (zzwiVar2 != null) {
            zzwi zzwiVar5 = zzwiVar2;
            zzwiVar = new zzwi(this.zzg, zzwiVar5, obj, zzwiVar4, zzwiVar4.zze);
            if (i2 < 0) {
                zzwiVar5.zzb = zzwiVar;
            } else {
                zzwiVar5.zzc = zzwiVar;
            }
            zzf(zzwiVar5, true);
        } else {
            if (comparator == zze && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName().concat(" is not Comparable"));
            }
            zzwiVar = new zzwi(this.zzg, null, obj, zzwiVar4, zzwiVar4.zze);
            this.zza = zzwiVar;
        }
        this.zzb++;
        this.zzc++;
        return zzwiVar;
    }

    public final zzwi zzb(Map.Entry entry) {
        zzwi zzwiVarZzc = zzc(entry.getKey());
        if (zzwiVarZzc == null || !Objects.equals(zzwiVarZzc.zzh, entry.getValue())) {
            return null;
        }
        return zzwiVarZzc;
    }

    public final zzwi zzc(Object obj) {
        if (obj != null) {
            try {
                return zza(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    public final zzwi zzd(Object obj) {
        zzwi zzwiVarZzc = zzc(obj);
        if (zzwiVarZzc != null) {
            zze(zzwiVarZzc, true);
        }
        return zzwiVarZzc;
    }

    public final void zze(zzwi zzwiVar, boolean z) {
        zzwi zzwiVar2;
        zzwi zzwiVar3;
        int i2;
        if (z) {
            zzwi zzwiVar4 = zzwiVar.zze;
            zzwiVar4.zzd = zzwiVar.zzd;
            zzwiVar.zzd.zze = zzwiVar4;
        }
        zzwi zzwiVar5 = zzwiVar.zzb;
        zzwi zzwiVar6 = zzwiVar.zzc;
        zzwi zzwiVar7 = zzwiVar.zza;
        int i3 = 0;
        if (zzwiVar5 == null || zzwiVar6 == null) {
            if (zzwiVar5 != null) {
                zzg(zzwiVar, zzwiVar5);
                zzwiVar.zzb = null;
            } else if (zzwiVar6 != null) {
                zzg(zzwiVar, zzwiVar6);
                zzwiVar.zzc = null;
            } else {
                zzg(zzwiVar, null);
            }
            zzf(zzwiVar7, false);
            this.zzb--;
            this.zzc++;
            return;
        }
        if (zzwiVar5.zzi > zzwiVar6.zzi) {
            do {
                zzwiVar3 = zzwiVar5;
                zzwiVar5 = zzwiVar5.zzc;
            } while (zzwiVar5 != null);
        } else {
            do {
                zzwiVar2 = zzwiVar6;
                zzwiVar6 = zzwiVar6.zzb;
            } while (zzwiVar6 != null);
            zzwiVar3 = zzwiVar2;
        }
        zze(zzwiVar3, false);
        zzwi zzwiVar8 = zzwiVar.zzb;
        if (zzwiVar8 != null) {
            i2 = zzwiVar8.zzi;
            zzwiVar3.zzb = zzwiVar8;
            zzwiVar8.zza = zzwiVar3;
            zzwiVar.zzb = null;
        } else {
            i2 = 0;
        }
        zzwi zzwiVar9 = zzwiVar.zzc;
        if (zzwiVar9 != null) {
            i3 = zzwiVar9.zzi;
            zzwiVar3.zzc = zzwiVar9;
            zzwiVar9.zza = zzwiVar3;
            zzwiVar.zzc = null;
        }
        zzwiVar3.zzi = Math.max(i2, i3) + 1;
        zzg(zzwiVar, zzwiVar3);
    }

    public zzwj(Comparator comparator, boolean z) {
        this.zzb = 0;
        this.zzc = 0;
        this.zzf = comparator;
        this.zzg = z;
        this.zzd = new zzwi(z);
    }

    public zzwj(boolean z) {
        this(zze, false);
    }
}
