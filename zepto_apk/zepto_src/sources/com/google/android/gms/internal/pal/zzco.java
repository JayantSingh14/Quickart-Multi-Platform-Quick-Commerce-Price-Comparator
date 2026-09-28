package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
final class zzco implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcp f37577a;

    public zzco(zzcp zzcpVar) {
        this.f37577a = zzcpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zBooleanValue;
        if (this.f37577a.f37582b != null) {
            return;
        }
        synchronized (zzcp.f37578c) {
            if (this.f37577a.f37582b != null) {
                return;
            }
            boolean z = false;
            try {
                zBooleanValue = ((Boolean) zzgk.f37768e.a()).booleanValue();
            } catch (IllegalStateException unused) {
                zBooleanValue = false;
            }
            if (zBooleanValue) {
                try {
                    zzcp.f37579d = zzhp.a(this.f37577a.f37581a.f37634a);
                    z = zBooleanValue;
                } catch (Throwable unused2) {
                }
            } else {
                z = zBooleanValue;
            }
            this.f37577a.f37582b = Boolean.valueOf(z);
            zzcp.f37578c.open();
        }
    }
}
