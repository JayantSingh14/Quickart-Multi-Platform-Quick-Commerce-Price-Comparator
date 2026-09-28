package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public final class zzejv implements zzejm {

    /* renamed from: a, reason: collision with root package name */
    public final Context f29509a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcsq f29510b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgyw f29511c;

    public zzejv(Context context, zzcsq zzcsqVar, zzgyw zzgywVar) {
        this.f29509a = context;
        this.f29510b = zzcsqVar;
        this.f29511c = zzgywVar;
    }

    @Override // com.google.android.gms.internal.ads.zzejm
    public final /* bridge */ /* synthetic */ Object a(zzfic zzficVar, zzfhr zzfhrVar, zzejj zzejjVar) {
        zzcsn zzcsnVarA = this.f29510b.a(new zzcwa(zzficVar, zzfhrVar, zzejjVar.f29462a), new zzdjw(new zzeju(this, zzejjVar, zzfhrVar), null), new zzcso(zzfhrVar.a0));
        zzcsnVarA.a().t0(new zzcqq((zzfji) zzejjVar.f29463b), this.f29511c);
        ((zzekv) zzejjVar.f29464c).Yb(zzcsnVarA.e());
        return zzcsnVarA.g();
    }

    @Override // com.google.android.gms.internal.ads.zzejm
    public final void b(zzfic zzficVar, zzfhr zzfhrVar, zzejj zzejjVar) throws zzfir {
        zzfji zzfjiVar = (zzfji) zzejjVar.f29463b;
        zzfik zzfikVar = zzficVar.f31193a.f31185a;
        String string = zzfhrVar.v.toString();
        Context context = this.f29509a;
        zzbtf zzbtfVar = (zzbtf) zzejjVar.f29464c;
        try {
            zzfjiVar.f31270a.l7(new ObjectWrapper(context), zzfikVar.f31216d, string, zzbtfVar);
        } catch (Throwable th) {
            throw new zzfir(th);
        }
    }
}
