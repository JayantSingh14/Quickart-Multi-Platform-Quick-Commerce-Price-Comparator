package com.google.android.gms.internal.pal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
final class zzadp extends zzadt {

    /* renamed from: c, reason: collision with root package name */
    public static final Class f37427c = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

    public static List d(Object obj, long j2, int i2) {
        List list = (List) zzafs.f37500c.m(j2, obj);
        if (list.isEmpty()) {
            List zzadmVar = list instanceof zzadn ? new zzadm(i2) : ((list instanceof zzaem) && (list instanceof zzadf)) ? ((zzadf) list).zzd(i2) : new ArrayList(i2);
            zzafs.h(obj, j2, zzadmVar);
            return zzadmVar;
        }
        if (f37427c.isAssignableFrom(list.getClass())) {
            ArrayList arrayList = new ArrayList(list.size() + i2);
            arrayList.addAll(list);
            zzafs.h(obj, j2, arrayList);
            return arrayList;
        }
        if (list instanceof zzafn) {
            zzadm zzadmVar2 = new zzadm(list.size() + i2);
            zzadmVar2.addAll(zzadmVar2.f37426b.size(), (zzafn) list);
            zzafs.h(obj, j2, zzadmVar2);
            return zzadmVar2;
        }
        if ((list instanceof zzaem) && (list instanceof zzadf)) {
            zzadf zzadfVar = (zzadf) list;
            if (!zzadfVar.zzc()) {
                zzadf zzadfVarZzd = zzadfVar.zzd(list.size() + i2);
                zzafs.h(obj, j2, zzadfVarZzd);
                return zzadfVarZzd;
            }
        }
        return list;
    }

    @Override // com.google.android.gms.internal.pal.zzadt
    public final List a(Object obj, long j2) {
        return d(obj, j2, 10);
    }

    @Override // com.google.android.gms.internal.pal.zzadt
    public final void b(Object obj, long j2) {
        Object objUnmodifiableList;
        List list = (List) zzafs.f37500c.m(j2, obj);
        if (list instanceof zzadn) {
            objUnmodifiableList = ((zzadn) list).zze();
        } else {
            if (f37427c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzaem) && (list instanceof zzadf)) {
                zzadf zzadfVar = (zzadf) list;
                if (zzadfVar.zzc()) {
                    zzadfVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzafs.h(obj, j2, objUnmodifiableList);
    }

    @Override // com.google.android.gms.internal.pal.zzadt
    public final void c(zzacz zzaczVar, zzacz zzaczVar2, long j2) {
        List list = (List) zzafs.f37500c.m(j2, zzaczVar2);
        List listD = d(zzaczVar, j2, list.size());
        int size = listD.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            listD.addAll(list);
        }
        if (size > 0) {
            list = listD;
        }
        zzafs.h(zzaczVar, j2, list);
    }
}
