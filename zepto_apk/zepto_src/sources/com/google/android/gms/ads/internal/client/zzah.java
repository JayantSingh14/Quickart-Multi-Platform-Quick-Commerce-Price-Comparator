package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzbws;
import com.google.android.gms.internal.ads.zzbwt;
import com.google.android.gms.internal.ads.zzbwu;

/* loaded from: classes4.dex */
final /* synthetic */ class zzah implements com.google.android.gms.ads.internal.util.client.zzq {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzah f21092a = new zzah();

    @Override // com.google.android.gms.ads.internal.util.client.zzq
    public final Object a(IBinder iBinder) {
        IBinder iBinder2 = iBinder;
        int i2 = zzbwt.f25658a;
        if (iBinder2 == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.ads.internal.offline.IOfflineUtilsCreator");
        return iInterfaceQueryLocalInterface instanceof zzbwu ? (zzbwu) iInterfaceQueryLocalInterface : new zzbws(iBinder2, "com.google.android.gms.ads.internal.offline.IOfflineUtilsCreator");
    }
}
