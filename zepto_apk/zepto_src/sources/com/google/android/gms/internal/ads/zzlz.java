package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* loaded from: classes4.dex */
final class zzlz {

    /* renamed from: a, reason: collision with root package name */
    public final zzpn f35166a;

    /* renamed from: e, reason: collision with root package name */
    public final zzly f35170e;

    /* renamed from: h, reason: collision with root package name */
    public final zzoz f35173h;

    /* renamed from: i, reason: collision with root package name */
    public final zzdx f35174i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f35175j;

    /* renamed from: k, reason: collision with root package name */
    public zzhz f35176k;

    /* renamed from: l, reason: collision with root package name */
    public zzxz f35177l = new zzxz();

    /* renamed from: c, reason: collision with root package name */
    public final IdentityHashMap f35168c = new IdentityHashMap();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f35169d = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f35167b = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f35171f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public final HashSet f35172g = new HashSet();

    public zzlz(zzly zzlyVar, zzoz zzozVar, zzdx zzdxVar, zzpn zzpnVar) {
        this.f35166a = zzpnVar;
        this.f35170e = zzlyVar;
        this.f35173h = zzozVar;
        this.f35174i = zzdxVar;
    }

    public final zzbf a(int i2, int i3, List list) {
        ArrayList arrayList = this.f35167b;
        zzgqa.a(i2 >= 0 && i2 <= i3 && i3 <= arrayList.size());
        zzgqa.a(list.size() == i3 - i2);
        for (int i4 = i2; i4 < i3; i4++) {
            ((zzlw) arrayList.get(i4)).f35160a.g((zzak) list.get(i4 - i2));
        }
        return e();
    }

    public final boolean b() {
        return this.f35175j;
    }

    public final void c(zzhz zzhzVar) {
        zzgqa.f(!this.f35175j);
        this.f35176k = zzhzVar;
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f35167b;
            if (i2 >= arrayList.size()) {
                this.f35175j = true;
                return;
            }
            zzlw zzlwVar = (zzlw) arrayList.get(i2);
            m(zzlwVar);
            this.f35172g.add(zzlwVar);
            i2++;
        }
    }

    public final void d(zzwe zzweVar) {
        IdentityHashMap identityHashMap = this.f35168c;
        zzlw zzlwVar = (zzlw) identityHashMap.remove(zzweVar);
        zzlwVar.getClass();
        zzlwVar.f35160a.k(zzweVar);
        zzlwVar.f35162c.remove(((zzvy) zzweVar).f35741a);
        if (!identityHashMap.isEmpty()) {
            k();
        }
        n(zzlwVar);
    }

    public final zzbf e() {
        ArrayList arrayList = this.f35167b;
        if (arrayList.isEmpty()) {
            return zzbf.f24868a;
        }
        int iA = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            zzlw zzlwVar = (zzlw) arrayList.get(i2);
            zzlwVar.f35163d = iA;
            iA += zzlwVar.f35160a.o.f35734b.a();
        }
        return new zzmg(arrayList, this.f35177l);
    }

    public final zzbf f(List list, zzxz zzxzVar) {
        ArrayList arrayList = this.f35167b;
        l(0, arrayList.size());
        return g(arrayList.size(), list, zzxzVar);
    }

    public final zzbf g(int i2, List list, zzxz zzxzVar) {
        if (!list.isEmpty()) {
            this.f35177l = zzxzVar;
            for (int i3 = i2; i3 < list.size() + i2; i3++) {
                zzlw zzlwVar = (zzlw) list.get(i3 - i2);
                ArrayList arrayList = this.f35167b;
                if (i3 > 0) {
                    zzlw zzlwVar2 = (zzlw) arrayList.get(i3 - 1);
                    zzlwVar.f35163d = zzlwVar2.f35160a.o.f35734b.a() + zzlwVar2.f35163d;
                    zzlwVar.f35164e = false;
                    zzlwVar.f35162c.clear();
                } else {
                    zzlwVar.f35163d = 0;
                    zzlwVar.f35164e = false;
                    zzlwVar.f35162c.clear();
                }
                int iA = zzlwVar.f35160a.o.f35734b.a();
                for (int i4 = i3; i4 < arrayList.size(); i4++) {
                    ((zzlw) arrayList.get(i4)).f35163d += iA;
                }
                arrayList.add(i3, zzlwVar);
                this.f35169d.put(zzlwVar.f35161b, zzlwVar);
                if (this.f35175j) {
                    m(zzlwVar);
                    if (this.f35168c.isEmpty()) {
                        this.f35172g.add(zzlwVar);
                    } else {
                        zzlv zzlvVar = (zzlv) this.f35171f.get(zzlwVar);
                        if (zzlvVar != null) {
                            zzlvVar.f35157a.i(zzlvVar.f35158b);
                        }
                    }
                }
            }
        }
        return e();
    }

    public final zzbf h(int i2, int i3, zzxz zzxzVar) {
        boolean z = false;
        if (i2 >= 0 && i2 <= i3 && i3 <= this.f35167b.size()) {
            z = true;
        }
        zzgqa.a(z);
        this.f35177l = zzxzVar;
        l(i2, i3);
        return e();
    }

    public final zzbf i() {
        zzgqa.a(this.f35167b.size() >= 0);
        this.f35177l = null;
        return e();
    }

    public final zzbf j(zzxz zzxzVar) {
        int size = this.f35167b.size();
        if (zzxzVar.f35885b.length != size) {
            zzxzVar = new zzxz(new Random(zzxzVar.f35884a.nextLong())).a(size);
        }
        this.f35177l = zzxzVar;
        return e();
    }

    public final void k() {
        Iterator it = this.f35172g.iterator();
        while (it.hasNext()) {
            zzlw zzlwVar = (zzlw) it.next();
            if (zzlwVar.f35162c.isEmpty()) {
                zzlv zzlvVar = (zzlv) this.f35171f.get(zzlwVar);
                if (zzlvVar != null) {
                    zzlvVar.f35157a.i(zzlvVar.f35158b);
                }
                it.remove();
            }
        }
    }

    public final void l(int i2, int i3) {
        while (true) {
            i3--;
            if (i3 < i2) {
                return;
            }
            ArrayList arrayList = this.f35167b;
            zzlw zzlwVar = (zzlw) arrayList.remove(i3);
            this.f35169d.remove(zzlwVar.f35161b);
            int i4 = -zzlwVar.f35160a.o.f35734b.a();
            for (int i5 = i3; i5 < arrayList.size(); i5++) {
                ((zzlw) arrayList.get(i5)).f35163d += i4;
            }
            zzlwVar.f35164e = true;
            if (this.f35175j) {
                n(zzlwVar);
            }
        }
    }

    public final void m(zzlw zzlwVar) {
        zzwb zzwbVar = zzlwVar.f35160a;
        zzwh zzwhVar = new zzwh() { // from class: com.google.android.gms.internal.ads.zzlx
            @Override // com.google.android.gms.internal.ads.zzwh
            public final void a(zzvf zzvfVar, zzbf zzbfVar) {
                zzdx zzdxVar = ((zzlc) this.f35165a.f35170e).f35075h;
                zzdxVar.r(2);
                zzdxVar.zzh(22);
            }
        };
        zzlu zzluVar = new zzlu(this, zzlwVar);
        this.f35171f.put(zzlwVar, new zzlv(zzwbVar, zzwhVar, zzluVar));
        String str = zzfj.f31254a;
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == null) {
            looperMyLooper = Looper.getMainLooper();
        }
        zzwbVar.c(new Handler(looperMyLooper, null), zzluVar);
        Looper looperMyLooper2 = Looper.myLooper();
        if (looperMyLooper2 == null) {
            looperMyLooper2 = Looper.getMainLooper();
        }
        zzwbVar.b(new Handler(looperMyLooper2, null), zzluVar);
        zzwbVar.d(zzwhVar, this.f35176k, this.f35166a);
    }

    public final void n(zzlw zzlwVar) {
        if (zzlwVar.f35164e && zzlwVar.f35162c.isEmpty()) {
            zzlv zzlvVar = (zzlv) this.f35171f.remove(zzlwVar);
            zzlvVar.getClass();
            zzwh zzwhVar = zzlvVar.f35158b;
            zzwi zzwiVar = zzlvVar.f35157a;
            zzwiVar.n(zzwhVar);
            zzlu zzluVar = zzlvVar.f35159c;
            zzwiVar.h(zzluVar);
            zzwiVar.e(zzluVar);
            this.f35172g.remove(zzlwVar);
        }
    }
}
