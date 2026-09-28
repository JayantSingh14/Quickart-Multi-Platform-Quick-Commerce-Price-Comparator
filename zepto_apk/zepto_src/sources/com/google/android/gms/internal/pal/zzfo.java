package com.google.android.gms.internal.pal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.dynamic.RemoteCreator;

/* loaded from: classes4.dex */
public final class zzfo extends RemoteCreator {

    /* renamed from: a, reason: collision with root package name */
    public static final zzfo f37739a = new zzfo("com.google.android.gms.ads.adshield.AdShieldCreatorImpl");

    @Override // com.google.android.gms.dynamic.RemoteCreator
    public final Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.adshield.internal.IAdShieldCreator");
        return iInterfaceQueryLocalInterface instanceof zzfs ? (zzfs) iInterfaceQueryLocalInterface : new zzfs(iBinder, "com.google.android.gms.ads.adshield.internal.IAdShieldCreator");
    }
}
