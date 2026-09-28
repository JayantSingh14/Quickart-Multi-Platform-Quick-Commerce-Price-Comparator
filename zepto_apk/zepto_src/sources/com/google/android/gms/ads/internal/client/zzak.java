package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbok;
import com.google.android.gms.internal.ads.zzbot;
import com.google.android.gms.internal.ads.zzbox;

/* loaded from: classes4.dex */
final class zzak extends zzba {
    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* synthetic */ Object a() {
        return new zzbox();
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object b() {
        try {
            return ((zzbot) com.google.android.gms.ads.internal.util.client.zzs.a(null, "com.google.android.gms.ads.DynamiteH5AdsManagerCreatorImpl", zzaj.f21095a)).S1(new ObjectWrapper(null), null, new zzbok());
        } catch (RemoteException | com.google.android.gms.ads.internal.util.client.zzr | NullPointerException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object c(zzcr zzcrVar) {
        return zzcrVar.j3(new ObjectWrapper(null), null, ModuleDescriptor.MODULE_VERSION, new zzbok());
    }
}
