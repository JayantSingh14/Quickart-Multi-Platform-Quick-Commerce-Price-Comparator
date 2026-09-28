package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes4.dex */
public abstract class zzvf implements zzwi {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f35696a = new ArrayList(1);

    /* renamed from: b, reason: collision with root package name */
    public final HashSet f35697b = new HashSet(1);

    /* renamed from: c, reason: collision with root package name */
    public final zzwq f35698c = new zzwq();

    /* renamed from: d, reason: collision with root package name */
    public final zztf f35699d = new zztf();

    /* renamed from: e, reason: collision with root package name */
    public Looper f35700e;

    /* renamed from: f, reason: collision with root package name */
    public zzbf f35701f;

    /* renamed from: g, reason: collision with root package name */
    public zzpn f35702g;

    @Override // com.google.android.gms.internal.ads.zzwi
    public final void b(Handler handler, zztg zztgVar) {
        zztf zztfVar = this.f35699d;
        zztfVar.getClass();
        zztfVar.f35585b.add(new zzte(zztgVar));
    }

    @Override // com.google.android.gms.internal.ads.zzwi
    public final void c(Handler handler, zzwr zzwrVar) {
        zzwq zzwqVar = this.f35698c;
        zzwqVar.getClass();
        zzwqVar.f35785b.add(new zzwj(handler, zzwrVar));
    }

    @Override // com.google.android.gms.internal.ads.zzwi
    public final void d(zzwh zzwhVar, zzhz zzhzVar, zzpn zzpnVar) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.f35700e;
        boolean z = true;
        if (looper != null && looper != looperMyLooper) {
            z = false;
        }
        zzgqa.a(z);
        this.f35702g = zzpnVar;
        zzbf zzbfVar = this.f35701f;
        this.f35696a.add(zzwhVar);
        if (this.f35700e == null) {
            this.f35700e = looperMyLooper;
            this.f35697b.add(zzwhVar);
            p(zzhzVar);
        } else if (zzbfVar != null) {
            j(zzwhVar);
            zzwhVar.a(this, zzbfVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwi
    public final void e(zztg zztgVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f35699d.f35585b;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            zzte zzteVar = (zzte) it.next();
            if (zzteVar.f35583a == zztgVar) {
                copyOnWriteArrayList.remove(zzteVar);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwi
    public final void h(zzwr zzwrVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f35698c.f35785b;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            zzwj zzwjVar = (zzwj) it.next();
            if (zzwjVar.f35764b == zzwrVar) {
                copyOnWriteArrayList.remove(zzwjVar);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwi
    public final void i(zzwh zzwhVar) {
        HashSet hashSet = this.f35697b;
        boolean zIsEmpty = hashSet.isEmpty();
        hashSet.remove(zzwhVar);
        if (zIsEmpty || !hashSet.isEmpty()) {
            return;
        }
        q();
    }

    @Override // com.google.android.gms.internal.ads.zzwi
    public final void j(zzwh zzwhVar) {
        this.f35700e.getClass();
        HashSet hashSet = this.f35697b;
        boolean zIsEmpty = hashSet.isEmpty();
        hashSet.add(zzwhVar);
        if (zIsEmpty) {
            o();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwi
    public final void n(zzwh zzwhVar) {
        ArrayList arrayList = this.f35696a;
        arrayList.remove(zzwhVar);
        if (!arrayList.isEmpty()) {
            i(zzwhVar);
            return;
        }
        this.f35700e = null;
        this.f35701f = null;
        this.f35702g = null;
        this.f35697b.clear();
        r();
    }

    public void o() {
    }

    public abstract void p(zzhz zzhzVar);

    public void q() {
    }

    public abstract void r();

    public final void s(zzbf zzbfVar) {
        this.f35701f = zzbfVar;
        ArrayList arrayList = this.f35696a;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((zzwh) arrayList.get(i2)).a(this, zzbfVar);
        }
    }
}
