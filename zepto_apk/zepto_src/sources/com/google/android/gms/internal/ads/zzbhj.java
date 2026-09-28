package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public final class zzbhj extends CustomTabsServiceConnection {

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f25058b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    public Context f25059c;

    /* renamed from: d, reason: collision with root package name */
    public zzdxe f25060d;

    /* renamed from: e, reason: collision with root package name */
    public CustomTabsSession f25061e;

    /* renamed from: f, reason: collision with root package name */
    public CustomTabsClient f25062f;

    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    public final void a(CustomTabsClient customTabsClient) {
        this.f25062f = customTabsClient;
        try {
            customTabsClient.f1304a.U8(0L);
        } catch (RemoteException unused) {
        }
        this.f25061e = customTabsClient.b(new zzbhg(this));
    }

    public final CustomTabsSession b() {
        if (this.f25061e == null) {
            ((zzcdn) zzcdo.f25982a).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbhi
                @Override // java.lang.Runnable
                public final void run() {
                    String strA;
                    zzbhj zzbhjVar = this.f25057a;
                    Context context = zzbhjVar.f25059c;
                    if (zzbhjVar.f25062f != null || context == null || (strA = CustomTabsClient.a(context, null)) == null || strA.equals(context.getPackageName())) {
                        return;
                    }
                    zzbhjVar.f1351a = context.getApplicationContext();
                    Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
                    if (!TextUtils.isEmpty(strA)) {
                        intent.setPackage(strA);
                    }
                    context.bindService(intent, zzbhjVar, 33);
                }
            });
        }
        return this.f25061e;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f25062f = null;
        this.f25061e = null;
    }
}
