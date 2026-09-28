package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbsv;
import com.google.android.gms.internal.ads.zzbwu;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzai extends zzba {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f21093b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzbsv f21094c;

    public zzai(zzaz zzazVar, Context context, zzbsv zzbsvVar) {
        this.f21093b = context;
        this.f21094c = zzbsvVar;
        Objects.requireNonNull(zzazVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object a() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object b() {
        Context context = this.f21093b;
        try {
            return ((zzbwu) com.google.android.gms.ads.internal.util.client.zzs.a(context, "com.google.android.gms.ads.DynamiteOfflineUtilsCreatorImpl", zzah.f21092a)).K0(new ObjectWrapper(context), this.f21094c);
        } catch (RemoteException | com.google.android.gms.ads.internal.util.client.zzr | NullPointerException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object c(zzcr zzcrVar) {
        return zzcrVar.G6(new ObjectWrapper(this.f21093b), this.f21094c, ModuleDescriptor.MODULE_VERSION);
    }
}
