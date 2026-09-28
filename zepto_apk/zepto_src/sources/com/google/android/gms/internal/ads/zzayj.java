package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzayj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzayk f24488a;

    public zzayj(zzayk zzaykVar) {
        Objects.requireNonNull(zzaykVar);
        this.f24488a = zzaykVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zBooleanValue;
        zzayk zzaykVar = this.f24488a;
        if (zzaykVar.f24493b != null) {
            return;
        }
        synchronized (zzayk.f24489c) {
            if (zzaykVar.f24493b != null) {
                return;
            }
            boolean z = false;
            try {
                zBooleanValue = ((Boolean) zzbgk.a3.c()).booleanValue();
            } catch (IllegalStateException unused) {
                zBooleanValue = false;
            }
            if (zBooleanValue) {
                try {
                    zzayk.f24490d = zzfwb.a(this.f24488a.f24492a.f24558a, "ADSHIELD");
                    z = zBooleanValue;
                } catch (Throwable unused2) {
                }
            } else {
                z = zBooleanValue;
            }
            this.f24488a.f24493b = Boolean.valueOf(z);
            zzayk.f24489c.open();
        }
    }
}
