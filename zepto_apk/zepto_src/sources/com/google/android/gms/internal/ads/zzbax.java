package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzbax extends zzbbh {

    /* renamed from: h, reason: collision with root package name */
    public List f24653h;

    /* renamed from: i, reason: collision with root package name */
    public final Context f24654i;

    public zzbax(zzazt zzaztVar, zzavs zzavsVar, int i2, Context context) {
        super(zzaztVar, "JC98YOkW1OV00In88Kxh39aoA4/Lc5LugpNahl16Tw21h78xPzCO3AkqsFSMWF+O", "uHu4aeoXgHtmEAr/p8TbphROLjKobmRTgSnNeTPf/24=", zzavsVar, i2, 31);
        this.f24653h = null;
        this.f24654i = context;
    }

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void a() {
        zzavs zzavsVar = this.f24672d;
        zzavsVar.j();
        ((zzawp) zzavsVar.f34638b).D(-1L);
        zzavsVar.j();
        ((zzawp) zzavsVar.f34638b).E(-1L);
        Context context = this.f24654i;
        if (context == null) {
            context = this.f24669a.f24558a;
        }
        if (this.f24653h == null) {
            this.f24653h = (List) this.f24673e.invoke(null, context);
        }
        List list = this.f24653h;
        if (list == null || list.size() != 2) {
            return;
        }
        synchronized (zzavsVar) {
            long jLongValue = ((Long) this.f24653h.get(0)).longValue();
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).D(jLongValue);
            long jLongValue2 = ((Long) this.f24653h.get(1)).longValue();
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).E(jLongValue2);
        }
    }
}
