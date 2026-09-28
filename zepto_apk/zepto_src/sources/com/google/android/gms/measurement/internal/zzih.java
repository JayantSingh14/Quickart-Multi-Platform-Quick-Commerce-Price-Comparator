package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;

/* loaded from: classes4.dex */
final class zzih implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzah f39111a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzjc f39112b;

    public zzih(zzjc zzjcVar, zzah zzahVar) {
        this.f39111a = zzahVar;
        this.f39112b = zzjcVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        zzjc zzjcVar = this.f39112b;
        zzjcVar.f39177a.A();
        zzah zzahVar = this.f39111a;
        Object objB = zzahVar.f38678c.b();
        zzpf zzpfVar = zzjcVar.f39177a;
        if (objB == null) {
            zzpfVar.getClass();
            zzr zzrVarO = zzpfVar.O((String) Preconditions.checkNotNull(zzahVar.f38676a));
            if (zzrVarO != null) {
                zzpfVar.Y(zzahVar, zzrVarO);
                return;
            }
            return;
        }
        zzpfVar.getClass();
        zzr zzrVarO2 = zzpfVar.O((String) Preconditions.checkNotNull(zzahVar.f38676a));
        if (zzrVarO2 != null) {
            zzpfVar.X(zzahVar, zzrVarO2);
        }
    }
}
