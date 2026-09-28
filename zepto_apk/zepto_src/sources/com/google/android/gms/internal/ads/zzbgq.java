package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@Deprecated
/* loaded from: classes4.dex */
public final class zzbgq {
    public static final void a(final zzbgp zzbgpVar, zzbgn zzbgnVar) {
        File externalStorageDirectory;
        Context context = zzbgnVar.f25026c;
        if (context == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        }
        String str = zzbgnVar.f25027d;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
        LinkedHashMap linkedHashMap = zzbgnVar.f25025b;
        zzbgpVar.f25033e = context;
        zzbgpVar.f25034f = str;
        zzbgpVar.f25032d = zzbgnVar.f25024a;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        zzbgpVar.f25036h = atomicBoolean;
        atomicBoolean.set(((Boolean) zzbif.f25139c.c()).booleanValue());
        if (zzbgpVar.f25036h.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            zzbgpVar.f25037i = new File(zzfwk.a(externalStorageDirectory, "sdk_csi_data.txt"));
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            zzbgpVar.f25030b.put((String) entry.getKey(), (String) entry.getValue());
        }
        ((zzcdn) zzcdo.f25982a).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbgo
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                LinkedHashMap linkedHashMap2;
                zzbgp zzbgpVar2 = zzbgpVar;
                zzbgpVar2.getClass();
                while (true) {
                    try {
                        zzbgz zzbgzVar = (zzbgz) zzbgpVar2.f25029a.take();
                        zzbgy zzbgyVarB = zzbgzVar.b();
                        if (!TextUtils.isEmpty(zzbgyVarB.f25046a)) {
                            LinkedHashMap linkedHashMap3 = zzbgpVar2.f25030b;
                            synchronized (zzbgzVar.f25050c) {
                                com.google.android.gms.ads.internal.zzt.C.f21684h.a();
                                linkedHashMap2 = zzbgzVar.f25049b;
                            }
                            zzbgpVar2.b(zzbgpVar2.a(linkedHashMap3, linkedHashMap2), zzbgyVarB);
                        }
                    } catch (InterruptedException e2) {
                        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.g("CsiReporter:reporter interrupted", e2);
                        return;
                    }
                }
            }
        });
        HashMap map = zzbgpVar.f25031c;
        zzbgv zzbgvVar = zzbgv.f25039b;
        map.put("action", zzbgvVar);
        map.put("ad_format", zzbgvVar);
        map.put("e", zzbgv.f25040c);
    }
}
