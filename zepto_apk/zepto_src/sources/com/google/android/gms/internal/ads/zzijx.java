package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.os.RemoteException;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public final class zzijx extends CustomTabsServiceConnection {

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference f34910b;

    public zzijx(zzbhl zzbhlVar) {
        this.f34910b = new WeakReference(zzbhlVar);
    }

    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    public final void a(CustomTabsClient customTabsClient) {
        zzbhl zzbhlVar = (zzbhl) this.f34910b.get();
        if (zzbhlVar != null) {
            zzbhlVar.f25064b = customTabsClient;
            try {
                customTabsClient.f1304a.U8(0L);
            } catch (RemoteException unused) {
            }
            zzbhk zzbhkVar = zzbhlVar.f25066d;
            if (zzbhkVar != null) {
                zzbhkVar.zza();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzbhl zzbhlVar = (zzbhl) this.f34910b.get();
        if (zzbhlVar != null) {
            zzbhlVar.f25064b = null;
            zzbhlVar.f25063a = null;
        }
    }
}
