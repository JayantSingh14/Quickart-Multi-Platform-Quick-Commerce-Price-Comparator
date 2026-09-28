package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes4.dex */
public abstract class zzbxm extends zzbcc implements zzbxn {
    public static zzbxn Xb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.query.IUpdateUrlsCallback");
        return iInterfaceQueryLocalInterface instanceof zzbxn ? (zzbxn) iInterfaceQueryLocalInterface : new zzbxl(iBinder, "com.google.android.gms.ads.internal.query.IUpdateUrlsCallback");
    }
}
