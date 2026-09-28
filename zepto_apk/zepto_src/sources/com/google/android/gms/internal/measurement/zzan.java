package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzan extends zzai implements zzak {

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f36766c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f36767d;

    /* renamed from: e, reason: collision with root package name */
    public final zzg f36768e;

    public zzan(zzan zzanVar) {
        super(zzanVar.f36762a);
        ArrayList arrayList = new ArrayList(zzanVar.f36766c.size());
        this.f36766c = arrayList;
        arrayList.addAll(zzanVar.f36766c);
        ArrayList arrayList2 = new ArrayList(zzanVar.f36767d.size());
        this.f36767d = arrayList2;
        arrayList2.addAll(zzanVar.f36767d);
        this.f36768e = zzanVar.f36768e;
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzao a(zzg zzgVar, List list) {
        zzat zzatVar;
        zzg zzgVarC = this.f36768e.c();
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f36766c;
            int size = arrayList.size();
            zzatVar = zzao.o0;
            if (i2 >= size) {
                break;
            }
            if (i2 < list.size()) {
                zzgVarC.f((String) arrayList.get(i2), zzgVar.f36956b.b(zzgVar, (zzao) list.get(i2)));
            } else {
                zzgVarC.f((String) arrayList.get(i2), zzatVar);
            }
            i2++;
        }
        Iterator it = this.f36767d.iterator();
        while (it.hasNext()) {
            zzao zzaoVar = (zzao) it.next();
            zzaw zzawVar = zzgVarC.f36956b;
            zzao zzaoVarB = zzawVar.b(zzgVarC, zzaoVar);
            if (zzaoVarB instanceof zzap) {
                zzaoVarB = zzawVar.b(zzgVarC, zzaoVar);
            }
            if (zzaoVarB instanceof zzag) {
                return ((zzag) zzaoVarB).f36759a;
            }
        }
        return zzatVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzai, com.google.android.gms.internal.measurement.zzao
    public final zzao f() {
        return new zzan(this);
    }

    public zzan(String str, ArrayList arrayList, List list, zzg zzgVar) {
        super(str);
        this.f36766c = new ArrayList();
        this.f36768e = zzgVar;
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f36766c.add(((zzao) it.next()).zzc());
            }
        }
        this.f36767d = new ArrayList(list);
    }
}
