package com.google.android.gms.internal.atv_ads_framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
final class zzdy extends zzec {

    /* renamed from: c, reason: collision with root package name */
    public static final Class f36142c = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

    @Override // com.google.android.gms.internal.atv_ads_framework.zzec
    public final void a(long j2, Object obj) {
        Object objUnmodifiableList;
        List list = (List) zzfz.g(obj, j2);
        if (list instanceof zzdw) {
            objUnmodifiableList = ((zzdw) list).zzd();
        } else {
            if (f36142c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzev) && (list instanceof zzdo)) {
                zzdo zzdoVar = (zzdo) list;
                if (zzdoVar.zzc()) {
                    zzdoVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzfz.k(obj, j2, objUnmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.atv_ads_framework.zzec
    public final void b(Object obj, long j2, Object obj2) {
        zzdv zzdvVar;
        List list = (List) zzfz.g(obj2, j2);
        int size = list.size();
        List listZzg = (List) zzfz.g(obj, j2);
        if (listZzg.isEmpty()) {
            listZzg = listZzg instanceof zzdw ? new zzdv(size) : ((listZzg instanceof zzev) && (listZzg instanceof zzdo)) ? ((zzdo) listZzg).zzg(size) : new ArrayList(size);
            zzfz.k(obj, j2, listZzg);
        } else {
            if (f36142c.isAssignableFrom(listZzg.getClass())) {
                ArrayList arrayList = new ArrayList(listZzg.size() + size);
                arrayList.addAll(listZzg);
                zzfz.k(obj, j2, arrayList);
                zzdvVar = arrayList;
            } else if (listZzg instanceof zzfu) {
                zzdv zzdvVar2 = new zzdv(listZzg.size() + size);
                zzdvVar2.addAll(zzdvVar2.f36141b.size(), (zzfu) listZzg);
                zzfz.k(obj, j2, zzdvVar2);
                zzdvVar = zzdvVar2;
            } else if ((listZzg instanceof zzev) && (listZzg instanceof zzdo)) {
                zzdo zzdoVar = (zzdo) listZzg;
                if (!zzdoVar.zzc()) {
                    listZzg = zzdoVar.zzg(listZzg.size() + size);
                    zzfz.k(obj, j2, listZzg);
                }
            }
            listZzg = zzdvVar;
        }
        int size2 = listZzg.size();
        int size3 = list.size();
        if (size2 > 0 && size3 > 0) {
            listZzg.addAll(list);
        }
        if (size2 > 0) {
            list = listZzg;
        }
        zzfz.k(obj, j2, list);
    }
}
