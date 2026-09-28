package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzbaz extends zzbbh {

    /* renamed from: h, reason: collision with root package name */
    public final StackTraceElement[] f24656h;

    public zzbaz(zzazt zzaztVar, zzavs zzavsVar, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzaztVar, "ffEAQyBH71yR4B2obQT/Qgb3Fo0ajWwFYmmZt2nfIS2fjNh6ir76IWAmhSUkzxpD", "s+erUKEK0AKg0XrZCH85OEIt0v0u2CGPZAaj/S6Q0Yk=", zzavsVar, i2, 45);
        this.f24656h = stackTraceElementArr;
    }

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void a() {
        StackTraceElement[] stackTraceElementArr = this.f24656h;
        if (stackTraceElementArr != null) {
            zzazk zzazkVar = new zzazk((String) this.f24673e.invoke(null, stackTraceElementArr));
            zzavs zzavsVar = this.f24672d;
            synchronized (zzavsVar) {
                try {
                    long jLongValue = zzazkVar.f24537a.longValue();
                    zzavsVar.j();
                    ((zzawp) zzavsVar.f34638b).P(jLongValue);
                    if (zzazkVar.f24538b.booleanValue()) {
                        int i2 = true != zzazkVar.f24539c.booleanValue() ? 2 : 1;
                        zzavsVar.j();
                        ((zzawp) zzavsVar.f34638b).u0(i2);
                    } else {
                        zzavsVar.j();
                        ((zzawp) zzavsVar.f34638b).u0(3);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
