package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes4.dex */
final /* synthetic */ class zzbfl implements com.google.android.gms.ads.internal.util.client.zzq {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzbfl f24894a = new zzbfl();

    @Override // com.google.android.gms.ads.internal.util.client.zzq
    public final Object a(IBinder iBinder) {
        IBinder iBinder2 = iBinder;
        int i2 = zzbcf.f24691a;
        if (iBinder2 == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.ads.clearcut.IClearcut");
        return iInterfaceQueryLocalInterface instanceof zzbcg ? (zzbcg) iInterfaceQueryLocalInterface : new zzbce(iBinder2, "com.google.android.gms.ads.clearcut.IClearcut");
    }
}
