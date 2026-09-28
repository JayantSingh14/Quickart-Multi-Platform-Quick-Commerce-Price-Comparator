package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzfc extends zzfg {
    public zzfc(zzdu zzduVar, zzr zzrVar, int i2) {
        super(zzduVar, "6CWPidOWJZFxRWI8V7yi3OiMbOhIWZX/jTayTGRwqCM0W8dtKHQOPe60TuQicfhG", "gYPijpNio6OwLgbzbH6IuWSNtvp7bCV5UMbKZJCVNdg=", zzrVar, i2, 48);
    }

    @Override // com.google.android.gms.internal.pal.zzfg
    public final void a() {
        this.f37726d.m(3);
        boolean zBooleanValue = ((Boolean) this.f37727e.invoke(null, this.f37723a.f37634a)).booleanValue();
        synchronized (this.f37726d) {
            try {
                if (zBooleanValue) {
                    this.f37726d.m(2);
                } else {
                    this.f37726d.m(1);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
