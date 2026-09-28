package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes3.dex */
public final class zzvy implements Cloneable, zzuv {
    public static final zzvy zza = new zzvy();
    private List zzb;
    private final List zzc;

    public zzvy() {
        List list = Collections.EMPTY_LIST;
        this.zzb = list;
        this.zzc = list;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuv
    public final zzuu zza(zztx zztxVar, zzaao zzaaoVar) {
        Class clsZzc = zzaaoVar.zzc();
        boolean zZzc = zzc(clsZzc, true);
        boolean zZzc2 = zzc(clsZzc, false);
        if (zZzc || zZzc2) {
            return new zzvx(this, zZzc2, zZzc, zztxVar, zzaaoVar);
        }
        return null;
    }

    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzvy clone() {
        try {
            return (zzvy) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final boolean zzc(Class cls, boolean z) {
        List<zzop> list;
        if (z) {
            list = this.zzb;
        } else {
            if (!Enum.class.isAssignableFrom(cls) && zzaab.zzj(cls)) {
                return true;
            }
            list = this.zzc;
        }
        for (zzop zzopVar : list) {
        }
        return false;
    }

    public final boolean zzd(Field field, boolean z) {
        if ((field.getModifiers() & WKSRecord.Service.PROFILE) != 0 || field.isSynthetic() || zzc(field.getType(), z)) {
            return true;
        }
        List<zzop> list = z ? this.zzb : this.zzc;
        if (list.isEmpty()) {
            return false;
        }
        for (zzop zzopVar : list) {
            zzoo zzooVar = (zzoo) zzto.zza(field).getAnnotation(zzoo.class);
            if (zzooVar != null && Arrays.asList(zzooVar.zzb()).contains(zzto.zzb(field))) {
                return true;
            }
        }
        return false;
    }

    public final zzvy zze(zzop zzopVar, boolean z, boolean z2) {
        zzvy zzvyVarClone = clone();
        ArrayList arrayList = new ArrayList(this.zzb);
        zzvyVarClone.zzb = arrayList;
        arrayList.add(zzopVar);
        return zzvyVarClone;
    }
}
