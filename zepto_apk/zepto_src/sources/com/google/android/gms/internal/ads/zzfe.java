package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;

/* loaded from: classes4.dex */
final class zzfe implements zzdx {

    /* renamed from: b, reason: collision with root package name */
    public static final ArrayList f30924b = new ArrayList(50);

    /* renamed from: a, reason: collision with root package name */
    public final Handler f30925a;

    public zzfe(Handler handler) {
        this.f30925a = handler;
    }

    public static /* synthetic */ void h(zzfd zzfdVar) {
        ArrayList arrayList = f30924b;
        synchronized (arrayList) {
            try {
                if (arrayList.size() < 50) {
                    arrayList.add(zzfdVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static zzfd i() {
        zzfd zzfdVar;
        ArrayList arrayList = f30924b;
        synchronized (arrayList) {
            try {
                zzfdVar = arrayList.isEmpty() ? new zzfd() : (zzfd) arrayList.remove(arrayList.size() - 1);
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzfdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdx
    public final boolean a(long j2) {
        return this.f30925a.sendEmptyMessageAtTime(2, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzdx
    public final zzdw b(int i2, int i3, int i4) {
        zzfd zzfdVarI = i();
        zzfdVarI.f30868a = this.f30925a.obtainMessage(i2, i3, i4);
        return zzfdVarI;
    }

    @Override // com.google.android.gms.internal.ads.zzdx
    public final boolean c(zzdw zzdwVar) {
        zzfd zzfdVar = (zzfd) zzdwVar;
        Message message = zzfdVar.f30868a;
        message.getClass();
        boolean zSendMessageAtFrontOfQueue = this.f30925a.sendMessageAtFrontOfQueue(message);
        zzfdVar.f30868a = null;
        h(zzfdVar);
        return zSendMessageAtFrontOfQueue;
    }

    @Override // com.google.android.gms.internal.ads.zzdx
    public final boolean d(Runnable runnable) {
        return this.f30925a.postDelayed(runnable, 1000L);
    }

    @Override // com.google.android.gms.internal.ads.zzdx
    public final boolean e(Runnable runnable) {
        return this.f30925a.post(runnable);
    }

    @Override // com.google.android.gms.internal.ads.zzdx
    public final void f(Runnable runnable) {
        this.f30925a.removeCallbacks(runnable);
    }

    @Override // com.google.android.gms.internal.ads.zzdx
    public final zzdw g(int i2, Object obj) {
        zzfd zzfdVarI = i();
        zzfdVarI.f30868a = this.f30925a.obtainMessage(i2, obj);
        return zzfdVarI;
    }

    @Override // com.google.android.gms.internal.ads.zzdx
    public final zzdw l(int i2) {
        zzfd zzfdVarI = i();
        zzfdVarI.f30868a = this.f30925a.obtainMessage(i2);
        return zzfdVarI;
    }

    @Override // com.google.android.gms.internal.ads.zzdx
    public final void r(int i2) {
        this.f30925a.removeMessages(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzdx
    public final Looper zza() {
        return this.f30925a.getLooper();
    }

    @Override // com.google.android.gms.internal.ads.zzdx
    public final boolean zzb() {
        return this.f30925a.hasMessages(1);
    }

    @Override // com.google.android.gms.internal.ads.zzdx
    public final zzdw zzf(Object obj) {
        zzfd zzfdVarI = i();
        zzfdVarI.f30868a = this.f30925a.obtainMessage(31, 0, 0, obj);
        return zzfdVarI;
    }

    @Override // com.google.android.gms.internal.ads.zzdx
    public final boolean zzh(int i2) {
        return this.f30925a.sendEmptyMessage(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzdx
    public final boolean zzi(int i2, int i3) {
        return this.f30925a.sendEmptyMessageDelayed(i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzdx
    public final void zzm() {
        this.f30925a.removeCallbacksAndMessages(null);
    }
}
