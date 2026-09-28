package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Base64;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class zzbag extends zzbbh {

    /* renamed from: i, reason: collision with root package name */
    public static final zzbbi f24628i = new zzbbi();

    /* renamed from: h, reason: collision with root package name */
    public final Context f24629h;

    public zzbag(zzazt zzaztVar, zzavs zzavsVar, int i2, Context context) {
        super(zzaztVar, "yCCrg1bENISzqqs7fgrfIgqRoB89Hc58RpoZe38mDWknXggRGBdzPAEdsprm/nAh", "ygsxUks9qSJOiPMXEo9qlLCVVsFNNRfyc6WjXaB0M8U=", zzavsVar, i2, 29);
        this.f24629h = context;
    }

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void a() {
        zzavs zzavsVar = this.f24672d;
        zzavsVar.j();
        ((zzawp) zzavsVar.f34638b).C("E");
        Context context = this.f24629h;
        AtomicReference atomicReferenceA = f24628i.a(context.getPackageName());
        if (atomicReferenceA.get() == null) {
            synchronized (atomicReferenceA) {
                try {
                    if (atomicReferenceA.get() == null) {
                        atomicReferenceA.set((String) this.f24673e.invoke(null, context));
                    }
                } finally {
                }
            }
        }
        String str = (String) atomicReferenceA.get();
        zzavs zzavsVar2 = this.f24672d;
        synchronized (zzavsVar2) {
            String strEncodeToString = Base64.encodeToString(str.getBytes(), 11);
            zzavsVar2.j();
            ((zzawp) zzavsVar2.f34638b).C(strEncodeToString);
        }
    }
}
