package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IInterface;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzenz implements zzejm {

    /* renamed from: a, reason: collision with root package name */
    public final Context f29935a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f29936b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdtj f29937c;

    public zzenz(Context context, Executor executor, zzdtj zzdtjVar) {
        this.f29935a = context;
        this.f29936b = executor;
        this.f29937c = zzdtjVar;
    }

    public static final void c(zzfic zzficVar, zzfhr zzfhrVar, zzejj zzejjVar) throws zzfir {
        try {
            zzfji zzfjiVar = (zzfji) zzejjVar.f29463b;
            try {
                zzfjiVar.f31270a.r7(zzficVar.f31193a.f31185a.f31216d, zzfhrVar.v.toString());
            } catch (Throwable th) {
                throw new zzfir(th);
            }
        } catch (Exception e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Fail to load ad from adapter ".concat(String.valueOf(zzejjVar.f29462a)), e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzejm
    public final Object a(zzfic zzficVar, zzfhr zzfhrVar, zzejj zzejjVar) {
        zzdtf zzdtfVarA = this.f29937c.a(new zzcwa(zzficVar, zzfhrVar, zzejjVar.f29462a), new zzdtg(new zzenx(this, zzejjVar, zzfhrVar), null));
        zzdtfVarA.a().t0(new zzcqq((zzfji) zzejjVar.f29463b), this.f29936b);
        zzcnx zzcnxVar = (zzcnx) zzdtfVarA;
        zzdbr zzdbrVar = (zzdbr) zzcnxVar.z.zzb();
        zzdai zzdaiVarB = zzdtfVarA.b();
        zzdcv zzdcvVar = (zzdcv) zzcnxVar.H.zzb();
        zzdja zzdjaVarI = zzdtfVarA.i();
        zzekw zzekwVar = (zzekw) zzejjVar.f29464c;
        zzeny zzenyVar = new zzeny(this, zzdcvVar, zzdaiVarB, zzdbrVar, zzdjaVarI);
        synchronized (zzekwVar) {
            zzekwVar.f29585a = zzenyVar;
        }
        return zzdtfVarA.g();
    }

    @Override // com.google.android.gms.internal.ads.zzejm
    public final void b(zzfic zzficVar, zzfhr zzfhrVar, zzejj zzejjVar) throws zzfir {
        zzfji zzfjiVar = (zzfji) zzejjVar.f29463b;
        if (zzfjiVar.a()) {
            c(zzficVar, zzfhrVar, zzejjVar);
            return;
        }
        zzenw zzenwVar = new zzenw(this, zzficVar, zzfhrVar, zzejjVar);
        IInterface iInterface = zzejjVar.f29464c;
        zzekw zzekwVar = (zzekw) iInterface;
        synchronized (zzekwVar) {
            zzekwVar.f29587c = zzenwVar;
        }
        Context context = this.f29935a;
        zzfik zzfikVar = zzficVar.f31193a.f31185a;
        zzbzx zzbzxVar = (zzbzx) iInterface;
        String string = zzfhrVar.v.toString();
        try {
            zzfjiVar.f31270a.i8(new ObjectWrapper(context), zzfikVar.f31216d, zzbzxVar, string);
        } catch (Throwable th) {
            throw new zzfir(th);
        }
    }
}
