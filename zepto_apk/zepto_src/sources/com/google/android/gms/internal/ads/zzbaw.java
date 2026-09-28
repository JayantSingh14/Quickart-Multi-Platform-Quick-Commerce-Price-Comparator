package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
public final class zzbaw extends zzbbh {
    public zzbaw(zzazt zzaztVar, zzavs zzavsVar, int i2) {
        super(zzaztVar, "ExKA4wjDRRYdztAsabUEoV5NOADo4vSkAwQNa4IGw0yLC0NQlDOhDdBTfDT5YHOb", "1Gz3ZRhjJNvXJ0g284S9b/dpVAajMMfg8CE3pBcFNFA=", zzavsVar, i2, 73);
    }

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void a() {
        zzavs zzavsVar = this.f24672d;
        try {
            int i2 = 1;
            if (true == ((Boolean) this.f24673e.invoke(null, this.f24669a.f24558a)).booleanValue()) {
                i2 = 2;
            }
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).v0(i2);
        } catch (InvocationTargetException unused) {
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).v0(3);
        }
    }
}
