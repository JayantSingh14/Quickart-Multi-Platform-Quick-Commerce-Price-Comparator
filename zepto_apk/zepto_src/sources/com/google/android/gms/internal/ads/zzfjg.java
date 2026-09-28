package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class zzfjg {

    /* renamed from: d, reason: collision with root package name */
    public static zzfjg f31266d;

    /* renamed from: a, reason: collision with root package name */
    public final Context f31267a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.client.zzcy f31268b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReference f31269c = new AtomicReference();

    public zzfjg(Context context, com.google.android.gms.ads.internal.client.zzcy zzcyVar) {
        this.f31267a = context;
        this.f31268b = zzcyVar;
    }

    public static zzfjg a(Context context) {
        synchronized (zzfjg.class) {
            try {
                zzfjg zzfjgVar = f31266d;
                if (zzfjgVar != null) {
                    return zzfjgVar;
                }
                Context applicationContext = context.getApplicationContext();
                long jLongValue = ((Long) zzbil.f25189b.c()).longValue();
                com.google.android.gms.ads.internal.client.zzcy zzcyVarAsInterface = null;
                if (jLongValue > 0 && jLongValue <= 254380000) {
                    try {
                        zzcyVarAsInterface = com.google.android.gms.ads.internal.client.zzcx.asInterface((IBinder) applicationContext.getClassLoader().loadClass("com.google.android.gms.ads.internal.client.LiteSdkInfo").getConstructor(Context.class).newInstance(applicationContext));
                    } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
                        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.d("Failed to retrieve lite SDK info.", e2);
                    }
                }
                zzfjg zzfjgVar2 = new zzfjg(applicationContext, zzcyVarAsInterface);
                f31266d = zzfjgVar2;
                return zzfjgVar2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(zzbsz zzbszVar) {
        zzbsz adapterCreator;
        boolean zBooleanValue = ((Boolean) zzbil.f25188a.c()).booleanValue();
        AtomicReference atomicReference = this.f31269c;
        if (!zBooleanValue) {
            while (!atomicReference.compareAndSet(null, zzbszVar) && atomicReference.get() == null) {
            }
            return;
        }
        com.google.android.gms.ads.internal.client.zzcy zzcyVar = this.f31268b;
        if (zzcyVar == null) {
            adapterCreator = null;
        } else {
            try {
                adapterCreator = zzcyVar.getAdapterCreator();
            } catch (RemoteException unused) {
            }
        }
        if (adapterCreator == null) {
            adapterCreator = zzbszVar;
        }
        while (!atomicReference.compareAndSet(null, adapterCreator) && atomicReference.get() == null) {
        }
    }
}
