package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes4.dex */
public abstract class zzvo extends zzvf {

    /* renamed from: h, reason: collision with root package name */
    public final HashMap f35724h = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    public Handler f35725i;

    /* renamed from: j, reason: collision with root package name */
    public zzhz f35726j;

    @Override // com.google.android.gms.internal.ads.zzwi
    public void f() {
        Iterator it = this.f35724h.values().iterator();
        while (it.hasNext()) {
            ((zzvn) it.next()).f35721a.f();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void o() {
        for (zzvn zzvnVar : this.f35724h.values()) {
            zzvnVar.f35721a.j(zzvnVar.f35722b);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public void p(zzhz zzhzVar) {
        this.f35726j = zzhzVar;
        this.f35725i = zzfj.n();
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void q() {
        for (zzvn zzvnVar : this.f35724h.values()) {
            zzvnVar.f35721a.i(zzvnVar.f35722b);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public void r() {
        HashMap map = this.f35724h;
        for (zzvn zzvnVar : map.values()) {
            zzwi zzwiVar = zzvnVar.f35721a;
            zzwiVar.n(zzvnVar.f35722b);
            zzvm zzvmVar = zzvnVar.f35723c;
            zzwiVar.h(zzvmVar);
            zzwiVar.e(zzvmVar);
        }
        map.clear();
    }

    public abstract void t(Integer num, zzvf zzvfVar, zzbf zzbfVar);

    public final void u(final Integer num, zzwi zzwiVar) {
        HashMap map = this.f35724h;
        zzgqa.a(!map.containsKey(num));
        zzwh zzwhVar = new zzwh() { // from class: com.google.android.gms.internal.ads.zzvl
            @Override // com.google.android.gms.internal.ads.zzwh
            public final /* synthetic */ void a(zzvf zzvfVar, zzbf zzbfVar) {
                this.f35715a.t(num, zzvfVar, zzbfVar);
            }
        };
        zzvm zzvmVar = new zzvm(this, num);
        map.put(num, new zzvn(zzwiVar, zzwhVar, zzvmVar));
        Handler handler = this.f35725i;
        handler.getClass();
        zzwiVar.c(handler, zzvmVar);
        Handler handler2 = this.f35725i;
        handler2.getClass();
        zzwiVar.b(handler2, zzvmVar);
        zzhz zzhzVar = this.f35726j;
        zzpn zzpnVar = this.f35702g;
        zzpnVar.getClass();
        zzwiVar.d(zzwhVar, zzhzVar, zzpnVar);
        if (this.f35697b.isEmpty()) {
            zzwiVar.i(zzwhVar);
        }
    }

    public zzwg w(Integer num, zzwg zzwgVar) {
        throw null;
    }

    public void v(Integer num) {
    }

    public void x(Integer num, long j2) {
    }
}
