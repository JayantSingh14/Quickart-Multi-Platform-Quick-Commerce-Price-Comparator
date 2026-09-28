package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IInterface;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzene implements zzejm {

    /* renamed from: a, reason: collision with root package name */
    public final Context f29856a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f29857b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdtj f29858c;

    public zzene(Context context, Executor executor, zzdtj zzdtjVar) {
        this.f29856a = context;
        this.f29857b = executor;
        this.f29858c = zzdtjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzejm
    public final Object a(zzfic zzficVar, zzfhr zzfhrVar, zzejj zzejjVar) {
        zzdtf zzdtfVarA = this.f29858c.a(new zzcwa(zzficVar, zzfhrVar, zzejjVar.f29462a), new zzdtg(new zzend(this, zzejjVar, zzfhrVar), null));
        zzdtfVarA.a().t0(new zzcqq((zzfji) zzejjVar.f29463b), this.f29857b);
        ((zzekv) zzejjVar.f29464c).Yb((zzenj) ((zzcnx) zzdtfVarA).P.zzb());
        return zzdtfVarA.g();
    }

    @Override // com.google.android.gms.internal.ads.zzejm
    public final void b(zzfic zzficVar, zzfhr zzfhrVar, zzejj zzejjVar) {
        zzfir zzfirVar;
        try {
            zzfik zzfikVar = zzficVar.f31193a.f31185a;
            int i2 = zzfikVar.p.f31184a;
            JSONObject jSONObject = zzfhrVar.v;
            IInterface iInterface = zzejjVar.f29464c;
            Object obj = zzejjVar.f29463b;
            Context context = this.f29856a;
            com.google.android.gms.ads.internal.client.zzm zzmVar = zzfikVar.f31216d;
            if (i2 == 3) {
                zzfji zzfjiVar = (zzfji) obj;
                try {
                    zzfjiVar.f31270a.cb(new ObjectWrapper(context), zzmVar, jSONObject.toString(), (zzbtf) iInterface);
                    return;
                } finally {
                }
            }
            zzfji zzfjiVar2 = (zzfji) obj;
            try {
                zzfjiVar2.f31270a.A1(new ObjectWrapper(context), zzmVar, jSONObject.toString(), (zzbtf) iInterface);
                return;
            } finally {
            }
        } catch (Exception e2) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Fail to load ad from adapter ".concat(String.valueOf(zzejjVar.f29462a)), e2);
        }
        int i32 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.g("Fail to load ad from adapter ".concat(String.valueOf(zzejjVar.f29462a)), e2);
    }
}
