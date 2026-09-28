package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import com.google.android.gms.internal.ads.zzayq;
import com.google.android.gms.internal.ads.zzbhq;
import com.google.android.gms.internal.ads.zzcdo;
import com.google.android.gms.internal.ads.zzclg;
import com.google.android.gms.internal.ads.zzclp;
import com.google.android.gms.internal.ads.zzcmg;
import com.google.android.gms.internal.ads.zzdxj;
import com.google.android.gms.internal.ads.zzfio;
import com.google.android.gms.internal.ads.zzfjj;
import com.google.android.gms.internal.ads.zzfpi;
import com.google.android.gms.internal.ads.zzgyw;
import com.google.android.gms.internal.ads.zzijf;
import com.google.android.gms.internal.ads.zzijg;
import com.google.android.gms.internal.ads.zzijh;
import com.google.android.gms.internal.ads.zzijo;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzav implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijh f21807a;

    /* renamed from: b, reason: collision with root package name */
    public final zzclp f21808b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f21809c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f21810d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f21811e;

    /* renamed from: f, reason: collision with root package name */
    public final zzijf f21812f;

    /* renamed from: g, reason: collision with root package name */
    public final zzijf f21813g;

    /* renamed from: h, reason: collision with root package name */
    public final zzcmg f21814h;

    /* renamed from: i, reason: collision with root package name */
    public final zzbhq f21815i;

    /* renamed from: j, reason: collision with root package name */
    public final zzijf f21816j;

    /* renamed from: k, reason: collision with root package name */
    public final zzijf f21817k;

    /* renamed from: l, reason: collision with root package name */
    public final zzijf f21818l;

    public zzav(zzijh zzijhVar, zzclp zzclpVar, zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3, zzijf zzijfVar4, zzijf zzijfVar5, zzcmg zzcmgVar, zzbhq zzbhqVar, zzijf zzijfVar6, zzijf zzijfVar7, zzijf zzijfVar8) {
        this.f21807a = zzijhVar;
        this.f21808b = zzclpVar;
        this.f21809c = zzijfVar;
        this.f21810d = zzijfVar2;
        this.f21811e = zzijfVar3;
        this.f21812f = zzijfVar4;
        this.f21813g = zzijfVar5;
        this.f21814h = zzcmgVar;
        this.f21815i = zzbhqVar;
        this.f21816j = zzijfVar6;
        this.f21817k = zzijfVar7;
        this.f21818l = zzijfVar8;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzclg zzclgVar = (zzclg) this.f21807a.f34899a;
        Context contextA = this.f21808b.a();
        zzayq zzayqVar = (zzayq) this.f21809c.zzb();
        zzfjj zzfjjVar = (zzfjj) this.f21810d.zzb();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzau(zzclgVar, contextA, zzayqVar, zzfjjVar, zzgywVar, (ScheduledExecutorService) this.f21811e.zzb(), (zzdxj) this.f21812f.zzb(), (zzfpi) this.f21813g.zzb(), this.f21814h.a(), this.f21815i.zzb(), (zzfio) this.f21816j.zzb(), (zzo) this.f21817k.zzb(), (zzf) this.f21818l.zzb());
    }
}
