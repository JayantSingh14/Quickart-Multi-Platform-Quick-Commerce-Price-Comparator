package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class zzbgc {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f24992a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f24993b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f24994c = new ArrayList();

    public final ArrayList a() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f24993b.iterator();
        while (it.hasNext()) {
            String str = (String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a((zzbgb) it.next());
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        zzbgl.a(arrayList2, new zzbhu("gad:dynamite_module:experiment_id", "", 4));
        zzbgl.a(arrayList2, zzbih.f25142a);
        zzbgl.a(arrayList2, zzbih.f25143b);
        zzbgl.a(arrayList2, zzbih.f25144c);
        zzbgl.a(arrayList2, zzbih.f25145d);
        zzbgl.a(arrayList2, zzbih.f25146e);
        zzbgl.a(arrayList2, zzbih.u);
        zzbgl.a(arrayList2, zzbih.f25147f);
        zzbgl.a(arrayList2, zzbih.f25154m);
        zzbgl.a(arrayList2, zzbih.n);
        zzbgl.a(arrayList2, zzbih.o);
        zzbgl.a(arrayList2, zzbih.p);
        zzbgl.a(arrayList2, zzbih.q);
        zzbgl.a(arrayList2, zzbih.r);
        zzbgl.a(arrayList2, zzbih.s);
        zzbgl.a(arrayList2, zzbih.t);
        zzbgl.a(arrayList2, zzbih.f25148g);
        zzbgl.a(arrayList2, zzbih.f25149h);
        zzbgl.a(arrayList2, zzbih.f25150i);
        zzbgl.a(arrayList2, zzbih.f25151j);
        zzbgl.a(arrayList2, zzbih.f25152k);
        zzbgl.a(arrayList2, zzbih.f25153l);
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    public final ArrayList b() {
        ArrayList arrayListA = a();
        Iterator it = this.f24994c.iterator();
        while (it.hasNext()) {
            String str = (String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a((zzbgb) it.next());
            if (!TextUtils.isEmpty(str)) {
                arrayListA.add(str);
            }
        }
        ArrayList arrayList = new ArrayList();
        zzbgl.a(arrayList, zzbiw.f25221a);
        arrayListA.addAll(arrayList);
        return arrayListA;
    }
}
