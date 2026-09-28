package com.google.android.gms.internal.ads;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzbar extends zzbbh {

    /* renamed from: h, reason: collision with root package name */
    public final zzazl f24647h;

    public zzbar(zzazt zzaztVar, zzavs zzavsVar, int i2, zzazl zzazlVar) {
        super(zzaztVar, "sl6J6ogR1CQFBNHXqYqYlsoHhQEQ3GzqykotbgjuxxtAslvwVDD28XhO/FGDcWNY", "etPaLFHhmzrmC9guV7/txSJ19uqkwWx/gSnrE4vBCvs=", zzavsVar, i2, 94);
        this.f24647h = zzazlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void a() {
        Method method = this.f24673e;
        zzazl zzazlVar = this.f24647h;
        List list = zzazlVar.f24540a;
        zzazlVar.f24540a = Collections.EMPTY_LIST;
        int iIntValue = ((Integer) method.invoke(null, list)).intValue();
        zzavs zzavsVar = this.f24672d;
        synchronized (zzavsVar) {
            int iA = zzawe.a(iIntValue);
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).x0(iA);
        }
    }
}
