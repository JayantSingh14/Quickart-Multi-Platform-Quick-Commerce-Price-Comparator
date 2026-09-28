package com.google.android.play.core.integrity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import java.util.ArrayList;

/* loaded from: classes4.dex */
final class aj {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.play.integrity.internal.s f41775a;

    /* renamed from: b, reason: collision with root package name */
    public final String f41776b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f41777c;

    /* renamed from: d, reason: collision with root package name */
    public final i f41778d;

    /* renamed from: e, reason: collision with root package name */
    public final com.google.android.play.integrity.internal.ae f41779e;

    public aj(Context context, com.google.android.play.integrity.internal.s sVar, at atVar, i iVar) {
        com.google.android.play.integrity.internal.s sVar2;
        this.f41776b = context.getPackageName();
        this.f41775a = sVar;
        this.f41778d = iVar;
        this.f41777c = context;
        com.google.android.play.integrity.internal.s sVar3 = com.google.android.play.integrity.internal.ai.f42169a;
        try {
            if (context.getPackageManager().getApplicationInfo("com.android.vending", 0).enabled) {
                try {
                    if (com.google.android.play.integrity.internal.ai.b(context.getPackageManager().getPackageInfo("com.android.vending", 64).signatures)) {
                        this.f41779e = new com.google.android.play.integrity.internal.ae(context, sVar, "IntegrityService", ak.f41780a, new com.google.android.play.integrity.internal.z() { // from class: com.google.android.play.core.integrity.ae
                            @Override // com.google.android.play.integrity.internal.z
                            public final Object a(IBinder iBinder) {
                                int i2 = com.google.android.play.integrity.internal.m.f42193a;
                                if (iBinder == null) {
                                    return null;
                                }
                                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.integrity.protocol.IIntegrityService");
                                return iInterfaceQueryLocalInterface instanceof com.google.android.play.integrity.internal.n ? (com.google.android.play.integrity.internal.n) iInterfaceQueryLocalInterface : new com.google.android.play.integrity.internal.l(iBinder, "com.google.android.play.core.integrity.protocol.IIntegrityService");
                            }
                        });
                        return;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    sVar2 = sVar;
                    sVar3.c("Play Store package is not found.", new Object[0]);
                }
            } else {
                sVar3.c("Play Store package is disabled.", new Object[0]);
            }
            sVar2 = sVar;
        } catch (PackageManager.NameNotFoundException unused2) {
            sVar2 = sVar;
            sVar3.c("Play Store package is not found.", new Object[0]);
        }
        Object[] objArr = new Object[0];
        sVar2.getClass();
        if (Log.isLoggable("PlayCore", 6)) {
            Log.e("PlayCore", com.google.android.play.integrity.internal.s.d(sVar2.f42194a, "Phonesky is not installed.", objArr));
        }
        this.f41779e = null;
    }

    public static /* bridge */ /* synthetic */ Bundle a(aj ajVar, byte[] bArr, Long l2) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", ajVar.f41776b);
        bundle.putByteArray("nonce", bArr);
        bundle.putInt("playcore.integrity.version.major", 1);
        bundle.putInt("playcore.integrity.version.minor", 4);
        bundle.putInt("playcore.integrity.version.patch", 0);
        if (l2 != null) {
            bundle.putLong("cloud.prj", l2.longValue());
        }
        ArrayList arrayList = new ArrayList();
        com.google.android.play.integrity.internal.d.b(3, arrayList);
        bundle.putParcelableArrayList("event_timestamps", new ArrayList<>(com.google.android.play.integrity.internal.d.a(arrayList)));
        return bundle;
    }
}
