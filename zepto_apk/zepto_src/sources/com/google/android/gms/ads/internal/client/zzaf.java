package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzcck;
import com.google.android.gms.internal.ads.zzccl;
import com.google.android.gms.internal.ads.zzccm;

/* loaded from: classes4.dex */
final /* synthetic */ class zzaf implements com.google.android.gms.ads.internal.util.client.zzq {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzaf f21089a = new zzaf();

    @Override // com.google.android.gms.ads.internal.util.client.zzq
    public final Object a(IBinder iBinder) {
        IBinder iBinder2 = iBinder;
        int i2 = zzccl.f25884a;
        if (iBinder2 == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalGeneratorCreator");
        return iInterfaceQueryLocalInterface instanceof zzccm ? (zzccm) iInterfaceQueryLocalInterface : new zzcck(iBinder2, "com.google.android.gms.ads.internal.signals.ISignalGeneratorCreator");
    }
}
