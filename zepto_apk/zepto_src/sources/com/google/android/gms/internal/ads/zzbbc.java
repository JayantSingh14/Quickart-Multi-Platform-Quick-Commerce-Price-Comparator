package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzbbc extends zzbbh {

    /* renamed from: h, reason: collision with root package name */
    public static volatile Long f24659h;

    /* renamed from: i, reason: collision with root package name */
    public static final Object f24660i = new Object();

    public zzbbc(zzazt zzaztVar, zzavs zzavsVar, int i2) {
        super(zzaztVar, "VYNLVwJcUVwKHNYqtTAMU2Cbdf8xQvz3Fr3MGMTI+Feinwv11ysZpnAq/2AMk2I1", "XCAdtiyR5t8AMQ7u4CMXLD5NJ9dD+Tw+KRPDn9OS+vQ=", zzavsVar, i2, 33);
    }

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void a() {
        if (f24659h == null) {
            synchronized (f24660i) {
                try {
                    if (f24659h == null) {
                        f24659h = (Long) this.f24673e.invoke(null, null);
                    }
                } finally {
                }
            }
        }
        zzavs zzavsVar = this.f24672d;
        synchronized (zzavsVar) {
            long jLongValue = f24659h.longValue();
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).F(jLongValue);
        }
    }
}
