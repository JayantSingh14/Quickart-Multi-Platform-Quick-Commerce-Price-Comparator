package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.IOException;
import org.json.JSONException;

/* loaded from: classes4.dex */
public final class zzelg implements zzejm {

    /* renamed from: a, reason: collision with root package name */
    public final Context f29635a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdkz f29636b;

    /* renamed from: c, reason: collision with root package name */
    public final VersionInfoParcel f29637c;

    /* renamed from: d, reason: collision with root package name */
    public final zzgyw f29638d;

    public zzelg(Context context, VersionInfoParcel versionInfoParcel, zzdkz zzdkzVar, zzgyw zzgywVar) {
        this.f29635a = context;
        this.f29637c = versionInfoParcel;
        this.f29636b = zzdkzVar;
        this.f29638d = zzgywVar;
    }

    @Override // com.google.android.gms.internal.ads.zzejm
    public final /* bridge */ /* synthetic */ Object a(zzfic zzficVar, zzfhr zzfhrVar, zzejj zzejjVar) {
        zzdjt zzdjtVarD = this.f29636b.d(new zzcwa(zzficVar, zzfhrVar, zzejjVar.f29462a), new zzdjw(new zzelf(this, zzejjVar, zzfhrVar), null));
        zzdjtVarD.a().t0(new zzcqq((zzfji) zzejjVar.f29463b), this.f29638d);
        ((zzekv) zzejjVar.f29464c).Yb(zzdjtVarD.e());
        return zzdjtVarD.g();
    }

    @Override // com.google.android.gms.internal.ads.zzejm
    public final void b(zzfic zzficVar, zzfhr zzfhrVar, zzejj zzejjVar) throws JSONException, zzfir, IOException {
        zzfji zzfjiVar = (zzfji) zzejjVar.f29463b;
        zzfik zzfikVar = zzficVar.f31193a.f31185a;
        String string = zzfhrVar.v.toString();
        String strI = com.google.android.gms.ads.internal.util.zzbp.i(zzfhrVar.s);
        Context context = this.f29635a;
        zzbtf zzbtfVar = (zzbtf) zzejjVar.f29464c;
        try {
            zzfjiVar.f31270a.a4(new ObjectWrapper(context), zzfikVar.f31216d, string, strI, zzbtfVar);
        } catch (Throwable th) {
            throw new zzfir(th);
        }
    }
}
