package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.OutOfContextTestingActivity;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbsv;
import com.google.android.gms.internal.ads.zzbxv;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzae extends zzba {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OutOfContextTestingActivity f21087b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzbsv f21088c;

    public zzae(zzaz zzazVar, OutOfContextTestingActivity outOfContextTestingActivity, zzbsv zzbsvVar) {
        this.f21087b = outOfContextTestingActivity;
        this.f21088c = zzbsvVar;
        Objects.requireNonNull(zzazVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object a() {
        zzaz.k(this.f21087b, "out_of_context_tester");
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object b() {
        OutOfContextTestingActivity outOfContextTestingActivity = this.f21087b;
        ObjectWrapper objectWrapper = new ObjectWrapper(outOfContextTestingActivity);
        zzbgk.a(outOfContextTestingActivity);
        if (!((Boolean) zzbd.f21150e.f21153c.a(zzbgk.za)).booleanValue()) {
            return null;
        }
        try {
            return ((zzdx) com.google.android.gms.ads.internal.util.client.zzs.a(outOfContextTestingActivity, "com.google.android.gms.ads.DynamiteOutOfContextTesterCreatorImpl", zzad.f21086a)).V2(objectWrapper, this.f21088c);
        } catch (RemoteException | com.google.android.gms.ads.internal.util.client.zzr | NullPointerException e2) {
            zzbxv.c(outOfContextTestingActivity).a("ClientApiBroker.getOutOfContextTester", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object c(zzcr zzcrVar) {
        OutOfContextTestingActivity outOfContextTestingActivity = this.f21087b;
        ObjectWrapper objectWrapper = new ObjectWrapper(outOfContextTestingActivity);
        zzbgk.a(outOfContextTestingActivity);
        if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.za)).booleanValue()) {
            return zzcrVar.n5(objectWrapper, this.f21088c, ModuleDescriptor.MODULE_VERSION);
        }
        return null;
    }
}
