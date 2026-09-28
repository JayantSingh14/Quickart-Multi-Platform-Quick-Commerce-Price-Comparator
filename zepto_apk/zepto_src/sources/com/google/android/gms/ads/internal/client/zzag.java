package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbsv;
import com.google.android.gms.internal.ads.zzccm;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzag extends zzba {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f21090b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzbsv f21091c;

    public zzag(zzaz zzazVar, Context context, zzbsv zzbsvVar) {
        this.f21090b = context;
        this.f21091c = zzbsvVar;
        Objects.requireNonNull(zzazVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object a() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object b() {
        Context context = this.f21090b;
        try {
            return ((zzccm) com.google.android.gms.ads.internal.util.client.zzs.a(context, "com.google.android.gms.ads.DynamiteSignalGeneratorCreatorImpl", zzaf.f21089a)).K0(new ObjectWrapper(context), this.f21091c);
        } catch (RemoteException | com.google.android.gms.ads.internal.util.client.zzr | NullPointerException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object c(zzcr zzcrVar) {
        return zzcrVar.n7(new ObjectWrapper(this.f21090b), this.f21091c, ModuleDescriptor.MODULE_VERSION);
    }
}
