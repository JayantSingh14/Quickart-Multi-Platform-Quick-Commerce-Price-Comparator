package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzbkj;
import com.google.android.gms.internal.ads.zzbkk;
import com.google.android.gms.internal.ads.zzbkl;

/* loaded from: classes4.dex */
final /* synthetic */ class zzax implements com.google.android.gms.ads.internal.util.client.zzq {
    @Override // com.google.android.gms.ads.internal.util.client.zzq
    public final Object a(IBinder iBinder) {
        IBinder iBinder2 = iBinder;
        int i2 = zzbkk.f25284a;
        if (iBinder2 == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegateCreator");
        return iInterfaceQueryLocalInterface instanceof zzbkl ? (zzbkl) iInterfaceQueryLocalInterface : new zzbkj(iBinder2);
    }
}
