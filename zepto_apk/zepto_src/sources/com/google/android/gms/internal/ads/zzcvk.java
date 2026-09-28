package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Collection;

/* loaded from: classes4.dex */
public class zzcvk implements zzems {

    /* renamed from: a, reason: collision with root package name */
    public final zzfic f27227a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfhr f27228b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdbj f27229c;

    /* renamed from: d, reason: collision with root package name */
    public final zzdbw f27230d;

    /* renamed from: e, reason: collision with root package name */
    public final zzfdr f27231e;

    /* renamed from: f, reason: collision with root package name */
    public final zzdad f27232f;

    /* renamed from: g, reason: collision with root package name */
    public final zzdfb f27233g;

    /* renamed from: h, reason: collision with root package name */
    public final zzdca f27234h;

    /* renamed from: i, reason: collision with root package name */
    public final zzdig f27235i;

    /* renamed from: j, reason: collision with root package name */
    public final zzcze f27236j;

    /* renamed from: k, reason: collision with root package name */
    public final zzdyh f27237k;

    public zzcvk(zzcvj zzcvjVar) {
        this.f27227a = zzcvjVar.f27216a;
        this.f27228b = zzcvjVar.f27217b;
        this.f27229c = zzcvjVar.f27218c;
        this.f27230d = zzcvjVar.f27219d;
        this.f27231e = zzcvjVar.f27220e;
        this.f27232f = zzcvjVar.f27221f;
        this.f27233g = zzcvjVar.f27222g;
        this.f27234h = zzcvjVar.f27223h;
        this.f27235i = zzcvjVar.f27224i;
        this.f27236j = zzcvjVar.f27225j;
        this.f27237k = zzcvjVar.f27226k;
    }

    public void a() {
        this.f27230d.zzg();
        this.f27234h.t(this);
    }

    public final void b() {
        zzdyh zzdyhVar;
        Collection collection = this.f27228b.C0;
        if (collection == null) {
            return;
        }
        AbstractCollection abstractCollection = (AbstractCollection) collection;
        if (abstractCollection.isEmpty() || (zzdyhVar = this.f27237k) == null) {
            return;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.C8)).booleanValue() || abstractCollection.isEmpty()) {
            return;
        }
        zzgvs zzgvsVarU = ((zzgtd) collection).listIterator(0);
        while (true) {
            zzgra zzgraVar = (zzgra) zzgvsVarU;
            if (!zzgraVar.hasNext()) {
                return;
            }
            zzdyi zzdyiVar = (zzdyi) zzgraVar.next();
            int[] iArr = zzdyiVar.f28793b;
            int length = iArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (iArr[i2] == 1) {
                    zzdyhVar.a(zzdyiVar.f28792a, com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis(), 1);
                    break;
                }
                i2++;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzems
    public final void zzm() {
        this.f27235i.zzi();
    }
}
