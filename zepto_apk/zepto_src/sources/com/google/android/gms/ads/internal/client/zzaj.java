package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzbor;
import com.google.android.gms.internal.ads.zzbos;
import com.google.android.gms.internal.ads.zzbot;

/* loaded from: classes4.dex */
final /* synthetic */ class zzaj implements com.google.android.gms.ads.internal.util.client.zzq {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzaj f21095a = new zzaj();

    @Override // com.google.android.gms.ads.internal.util.client.zzq
    public final Object a(IBinder iBinder) {
        IBinder iBinder2 = iBinder;
        int i2 = zzbos.f25391a;
        if (iBinder2 == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.ads.internal.h5.client.IH5AdsManagerCreator");
        return iInterfaceQueryLocalInterface instanceof zzbot ? (zzbot) iInterfaceQueryLocalInterface : new zzbor(iBinder2, "com.google.android.gms.ads.internal.h5.client.IH5AdsManagerCreator");
    }
}
