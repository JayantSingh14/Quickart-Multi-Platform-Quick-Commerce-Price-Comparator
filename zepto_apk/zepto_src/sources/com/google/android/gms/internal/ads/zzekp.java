package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IInterface;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzekp implements zzejm {

    /* renamed from: a, reason: collision with root package name */
    public final Context f29559a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcuh f29560b;

    /* renamed from: c, reason: collision with root package name */
    public View f29561c;

    /* renamed from: d, reason: collision with root package name */
    public zzbti f29562d;

    public zzekp(Context context, zzcuh zzcuhVar) {
        this.f29559a = context;
        this.f29560b = zzcuhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzejm
    public final Object a(zzfic zzficVar, final zzfhr zzfhrVar, final zzejj zzejjVar) throws zzfir {
        final View view;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.P8)).booleanValue() && zzfhrVar.g0) {
            try {
                view = (View) ObjectWrapper.z0(this.f29562d.zze());
                boolean zZzf = this.f29562d.zzf();
                if (view == null) {
                    throw new zzfir(new Exception("BannerRtbAdapterWrapper interscrollerView should not be null"));
                }
                if (zZzf) {
                    try {
                        view = (View) ((zzgxf) zzgym.h(zzgyq.f33377b, new zzgxu() { // from class: com.google.android.gms.internal.ads.zzekm
                            @Override // com.google.android.gms.internal.ads.zzgxu
                            public final /* synthetic */ ListenableFuture zza(Object obj) {
                                return zzgym.a(zzcuw.a(this.f29553a.f29559a, view, zzfhrVar));
                            }
                        }, zzcdo.f25987f)).get();
                    } catch (InterruptedException | ExecutionException e2) {
                        throw new zzfir(e2);
                    }
                }
            } catch (RemoteException e3) {
                throw new zzfir(e3);
            }
        } else {
            view = this.f29561c;
        }
        zzctd zzctdVarD = this.f29560b.d(new zzcwa(zzficVar, zzfhrVar, zzejjVar.f29462a), new zzctj(view, null, new zzcvi() { // from class: com.google.android.gms.internal.ads.zzekn
            @Override // com.google.android.gms.internal.ads.zzcvi
            public final com.google.android.gms.ads.internal.client.zzed zza() throws zzfir {
                try {
                    return ((zzbuy) zzejjVar.f29463b).zzh();
                } catch (RemoteException e4) {
                    throw new zzfir(e4);
                }
            }
        }, (zzfhs) zzfhrVar.u.get(0)));
        zzctdVarD.i().w0(view);
        ((zzekv) zzejjVar.f29464c).Yb(zzctdVarD.f());
        return zzctdVarD.g();
    }

    @Override // com.google.android.gms.internal.ads.zzejm
    public final void b(zzfic zzficVar, zzfhr zzfhrVar, zzejj zzejjVar) throws zzfir {
        try {
            zzbuy zzbuyVar = (zzbuy) zzejjVar.f29463b;
            zzbuyVar.zzo(zzfhrVar.Z);
            boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.P8)).booleanValue();
            IInterface iInterface = zzejjVar.f29464c;
            Context context = this.f29559a;
            JSONObject jSONObject = zzfhrVar.v;
            if (zBooleanValue && zzfhrVar.g0) {
                String str = zzfhrVar.U;
                String string = jSONObject.toString();
                zzfik zzfikVar = zzficVar.f31193a.f31185a;
                zzbuyVar.k8(str, string, zzfikVar.f31216d, new ObjectWrapper(context), new zzeko(this, zzejjVar), (zzbtf) iInterface, zzfikVar.f31218f);
                return;
            }
            String str2 = zzfhrVar.U;
            String string2 = jSONObject.toString();
            zzfik zzfikVar2 = zzficVar.f31193a.f31185a;
            zzbuyVar.S3(str2, string2, zzfikVar2.f31216d, new ObjectWrapper(context), new zzeko(this, zzejjVar), (zzbtf) iInterface, zzfikVar2.f31218f);
        } catch (RemoteException e2) {
            throw new zzfir(e2);
        }
    }
}
