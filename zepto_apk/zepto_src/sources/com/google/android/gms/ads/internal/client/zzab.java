package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzbwz;
import com.google.android.gms.internal.ads.zzbxa;
import com.google.android.gms.internal.ads.zzbxb;

/* loaded from: classes4.dex */
final /* synthetic */ class zzab implements com.google.android.gms.ads.internal.util.client.zzq {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzab f21083a = new zzab();

    @Override // com.google.android.gms.ads.internal.util.client.zzq
    public final Object a(IBinder iBinder) {
        IBinder iBinder2 = iBinder;
        int i2 = zzbxa.f25661a;
        if (iBinder2 == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        return iInterfaceQueryLocalInterface instanceof zzbxb ? (zzbxb) iInterfaceQueryLocalInterface : new zzbwz(iBinder2);
    }
}
