package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
final class zzadj extends zzadn {
    private static final Class zza = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

    private zzadj() {
        super(null);
    }

    private static List zzf(Object obj, long j2, int i2) {
        List list = (List) zzafu.zzf(obj, j2);
        if (list.isEmpty()) {
            List zzadgVar = list instanceof zzadh ? new zzadg(i2) : ((list instanceof zzaeh) && (list instanceof zzacw)) ? ((zzacw) list).zzd(i2) : new ArrayList(i2);
            zzafu.zzs(obj, j2, zzadgVar);
            return zzadgVar;
        }
        if (zza.isAssignableFrom(list.getClass())) {
            ArrayList arrayList = new ArrayList(list.size() + i2);
            arrayList.addAll(list);
            zzafu.zzs(obj, j2, arrayList);
            return arrayList;
        }
        if (list instanceof zzafp) {
            zzadg zzadgVar2 = new zzadg(list.size() + i2);
            zzadgVar2.addAll(zzadgVar2.size(), (zzafp) list);
            zzafu.zzs(obj, j2, zzadgVar2);
            return zzadgVar2;
        }
        if ((list instanceof zzaeh) && (list instanceof zzacw)) {
            zzacw zzacwVar = (zzacw) list;
            if (!zzacwVar.zzc()) {
                zzacw zzacwVarZzd = zzacwVar.zzd(list.size() + i2);
                zzafu.zzs(obj, j2, zzacwVarZzd);
                return zzacwVarZzd;
            }
        }
        return list;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzadn
    public final List zza(Object obj, long j2) {
        return zzf(obj, j2, 10);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzadn
    public final void zzb(Object obj, long j2) {
        Object objUnmodifiableList;
        List list = (List) zzafu.zzf(obj, j2);
        if (list instanceof zzadh) {
            objUnmodifiableList = ((zzadh) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzaeh) && (list instanceof zzacw)) {
                zzacw zzacwVar = (zzacw) list;
                if (zzacwVar.zzc()) {
                    zzacwVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzafu.zzs(obj, j2, objUnmodifiableList);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzadn
    public final void zzc(Object obj, Object obj2, long j2) {
        List list = (List) zzafu.zzf(obj2, j2);
        List listZzf = zzf(obj, j2, list.size());
        int size = listZzf.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            listZzf.addAll(list);
        }
        if (size > 0) {
            list = listZzf;
        }
        zzafu.zzs(obj, j2, list);
    }

    public /* synthetic */ zzadj(zzadi zzadiVar) {
        super(null);
    }
}
