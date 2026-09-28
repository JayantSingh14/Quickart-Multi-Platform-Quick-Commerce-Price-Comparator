package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;

/* loaded from: classes4.dex */
public final class zzeps extends com.google.android.gms.ads.internal.client.zzbp {

    /* renamed from: a, reason: collision with root package name */
    public final zzera f30067a;

    public zzeps(Context context, zzclg zzclgVar, zzfij zzfijVar, zzdnw zzdnwVar, com.google.android.gms.ads.internal.client.zzbk zzbkVar) {
        zzerc zzercVar = new zzerc(zzdnwVar, zzclgVar.d());
        zzercVar.f30153b.f30103a.set(zzbkVar);
        this.f30067a = new zzera(new zzerm(zzclgVar, context, zzercVar, zzfijVar), zzfijVar.f31202c);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final synchronized void P7(com.google.android.gms.ads.internal.client.zzm zzmVar, int i2) {
        this.f30067a.a(zzmVar, i2);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void U0(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        this.f30067a.a(zzmVar, 1);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final synchronized String zzf() {
        String str;
        zzera zzeraVar = this.f30067a;
        synchronized (zzeraVar) {
            try {
                zzdad zzdadVar = zzeraVar.f30149c;
                str = zzdadVar != null ? zzdadVar.f27543a : null;
            } catch (RemoteException e2) {
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
            }
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0010  */
    @Override // com.google.android.gms.ads.internal.client.zzbq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized boolean zzg() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzera r0 = r2.f30067a     // Catch: java.lang.Throwable -> L17
            monitor-enter(r0)     // Catch: java.lang.Throwable -> L17
            com.google.android.gms.internal.ads.zzerm r1 = r0.f30147a     // Catch: java.lang.Throwable -> L14
            com.google.android.gms.internal.ads.zzcvz r1 = r1.f30171f     // Catch: java.lang.Throwable -> L14
            if (r1 == 0) goto L10
            boolean r1 = r1.f27255c     // Catch: java.lang.Throwable -> L14
            if (r1 == 0) goto L10
            r1 = 1
            goto L11
        L10:
            r1 = 0
        L11:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L17
            monitor-exit(r2)
            return r1
        L14:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            throw r1     // Catch: java.lang.Throwable -> L17
        L17:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L17
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeps.zzg():boolean");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final synchronized String zzh() {
        String str;
        zzera zzeraVar = this.f30067a;
        synchronized (zzeraVar) {
            try {
                zzdad zzdadVar = zzeraVar.f30149c;
                str = zzdadVar != null ? zzdadVar.f27543a : null;
            } catch (RemoteException e2) {
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
            }
        }
        return str;
    }
}
