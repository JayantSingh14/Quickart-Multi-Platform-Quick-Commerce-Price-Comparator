package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzlu implements zzwr, zztg {

    /* renamed from: a, reason: collision with root package name */
    public final zzlw f35155a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzlz f35156b;

    public zzlu(zzlz zzlzVar, zzlw zzlwVar) {
        Objects.requireNonNull(zzlzVar);
        this.f35156b = zzlzVar;
        this.f35155a = zzlwVar;
    }

    public final Pair a(zzwg zzwgVar) {
        zzwg zzwgVarA;
        zzlw zzlwVar = this.f35155a;
        zzwg zzwgVar2 = null;
        if (zzwgVar != null) {
            int i2 = 0;
            while (true) {
                ArrayList arrayList = zzlwVar.f35162c;
                if (i2 >= arrayList.size()) {
                    zzwgVarA = null;
                    break;
                }
                if (((zzwg) arrayList.get(i2)).f35761d == zzwgVar.f35761d) {
                    Object obj = zzlwVar.f35161b;
                    int i3 = zzmg.f35203k;
                    zzwgVarA = zzwgVar.a(Pair.create(obj, zzwgVar.f35758a));
                    break;
                }
                i2++;
            }
            if (zzwgVarA == null) {
                return null;
            }
            zzwgVar2 = zzwgVarA;
        }
        return Pair.create(Integer.valueOf(zzlwVar.f35163d), zzwgVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzwr
    public final void d(int i2, zzwg zzwgVar, final zzvx zzvxVar, final zzwc zzwcVar, final int i3) {
        final Pair pairA = a(zzwgVar);
        if (pairA != null) {
            this.f35156b.f35174i.e(new Runnable() { // from class: com.google.android.gms.internal.ads.zzlt
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Pair pair = pairA;
                    int iIntValue = ((Integer) pair.first).intValue();
                    zzwg zzwgVar2 = (zzwg) pair.second;
                    this.f35150a.f35156b.f35173h.d(iIntValue, zzwgVar2, zzvxVar, zzwcVar, i3);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwr
    public final void e(int i2, zzwg zzwgVar, final zzwc zzwcVar) {
        final Pair pairA = a(zzwgVar);
        if (pairA != null) {
            this.f35156b.f35174i.e(new Runnable() { // from class: com.google.android.gms.internal.ads.zzls
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Pair pair = pairA;
                    this.f35147a.f35156b.f35173h.e(((Integer) pair.first).intValue(), (zzwg) pair.second, zzwcVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwr
    public final void g(int i2, zzwg zzwgVar, final zzvx zzvxVar, final zzwc zzwcVar, final IOException iOException, final boolean z) {
        final Pair pairA = a(zzwgVar);
        if (pairA != null) {
            this.f35156b.f35174i.e(new Runnable() { // from class: com.google.android.gms.internal.ads.zzlr
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Pair pair = pairA;
                    this.f35141a.f35156b.f35173h.g(((Integer) pair.first).intValue(), (zzwg) pair.second, zzvxVar, zzwcVar, iOException, z);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwr
    public final void i(int i2, zzwg zzwgVar, final zzvx zzvxVar, final zzwc zzwcVar) {
        final Pair pairA = a(zzwgVar);
        if (pairA != null) {
            this.f35156b.f35174i.e(new Runnable() { // from class: com.google.android.gms.internal.ads.zzlq
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Pair pair = pairA;
                    this.f35137a.f35156b.f35173h.i(((Integer) pair.first).intValue(), (zzwg) pair.second, zzvxVar, zzwcVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwr
    public final void j(int i2, zzwg zzwgVar, final zzvx zzvxVar, final zzwc zzwcVar) {
        final Pair pairA = a(zzwgVar);
        if (pairA != null) {
            this.f35156b.f35174i.e(new Runnable() { // from class: com.google.android.gms.internal.ads.zzlp
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Pair pair = pairA;
                    this.f35133a.f35156b.f35173h.j(((Integer) pair.first).intValue(), (zzwg) pair.second, zzvxVar, zzwcVar);
                }
            });
        }
    }
}
