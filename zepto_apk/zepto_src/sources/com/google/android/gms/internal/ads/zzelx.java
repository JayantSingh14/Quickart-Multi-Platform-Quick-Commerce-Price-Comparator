package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzelx implements zzejm {

    /* renamed from: a, reason: collision with root package name */
    public final Context f29687a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdlv f29688b;

    /* renamed from: c, reason: collision with root package name */
    public zzbto f29689c;

    /* renamed from: d, reason: collision with root package name */
    public final VersionInfoParcel f29690d;

    public zzelx(Context context, zzdlv zzdlvVar, VersionInfoParcel versionInfoParcel) {
        this.f29687a = context;
        this.f29688b = zzdlvVar;
        this.f29690d = versionInfoParcel;
    }

    @Override // com.google.android.gms.internal.ads.zzejm
    public final Object a(zzfic zzficVar, zzfhr zzfhrVar, zzejj zzejjVar) throws zzemv {
        ArrayList arrayList = zzficVar.f31193a.f31185a.f31220h;
        if (!arrayList.contains(Integer.toString(6))) {
            throw new zzemv(2, "Unified must be used for RTB.");
        }
        zzdnm zzdnmVarL = zzdnm.l(this.f29689c);
        if (!arrayList.contains(Integer.toString(zzdnmVarL.q()))) {
            throw new zzemv(1, "No corresponding native ad listener");
        }
        zzdno zzdnoVarD = this.f29688b.d(new zzcwa(zzficVar, zzfhrVar, zzejjVar.f29462a), new zzdnx(zzdnmVarL), new zzdpq(null, null, this.f29689c));
        ((zzekv) zzejjVar.f29464c).Yb(zzdnoVarD.f());
        return zzdnoVarD.g();
    }

    @Override // com.google.android.gms.internal.ads.zzejm
    public final void b(zzfic zzficVar, zzfhr zzfhrVar, zzejj zzejjVar) throws zzfir {
        try {
            zzbuy zzbuyVar = (zzbuy) zzejjVar.f29463b;
            zzbuyVar.zzo(zzfhrVar.Z);
            int i2 = this.f29690d.f21402c;
            int iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.c2)).intValue();
            IInterface iInterface = zzejjVar.f29464c;
            Context context = this.f29687a;
            JSONObject jSONObject = zzfhrVar.v;
            if (i2 < iIntValue) {
                zzbuyVar.u5(zzfhrVar.U, jSONObject.toString(), zzficVar.f31193a.f31185a.f31216d, new ObjectWrapper(context), new zzelw(this, zzejjVar), (zzbtf) iInterface);
                return;
            }
            String str = zzfhrVar.U;
            String string = jSONObject.toString();
            zzfik zzfikVar = zzficVar.f31193a.f31185a;
            zzbuyVar.B1(str, string, zzfikVar.f31216d, new ObjectWrapper(context), new zzelw(this, zzejjVar), (zzbtf) iInterface, zzfikVar.f31222j);
        } catch (RemoteException e2) {
            throw new zzfir(e2);
        }
    }
}
