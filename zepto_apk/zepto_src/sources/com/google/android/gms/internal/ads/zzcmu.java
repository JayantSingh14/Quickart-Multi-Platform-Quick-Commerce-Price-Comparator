package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
final class zzcmu extends zzfaz {

    /* renamed from: a, reason: collision with root package name */
    public final zzfcc f26566a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcmv f26567b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f26568c;

    /* renamed from: d, reason: collision with root package name */
    public final zzfay f26569d;

    /* renamed from: e, reason: collision with root package name */
    public final zzfbm f26570e;

    /* renamed from: f, reason: collision with root package name */
    public final zzfbu f26571f;

    /* renamed from: g, reason: collision with root package name */
    public final zzfcb f26572g;

    /* renamed from: h, reason: collision with root package name */
    public final zzfct f26573h;

    /* renamed from: i, reason: collision with root package name */
    public final zzfcp f26574i;

    /* renamed from: j, reason: collision with root package name */
    public final zzfbi f26575j;

    /* renamed from: k, reason: collision with root package name */
    public final zzijf f26576k;

    public zzcmu(zzcmv zzcmvVar, zzfcc zzfccVar) {
        this.f26567b = zzcmvVar;
        this.f26566a = zzfccVar;
        this.f26568c = zzijf.a(new zzfnp(zzcmvVar.x));
        zzfce zzfceVar = new zzfce(zzfccVar);
        zzfcf zzfcfVar = new zzfcf(zzfccVar);
        zzfcg zzfcgVar = new zzfcg(zzfccVar);
        int i2 = zzcpi.f26865a;
        zzflk zzflkVar = zzflj.f31363a;
        zzclp zzclpVar = zzcmvVar.f26583h;
        zzijf zzijfVar = zzcmvVar.f26580e;
        this.f26569d = new zzfay(zzclpVar, zzijfVar, zzfceVar, zzfcfVar, zzfcgVar);
        int i3 = zzcpc.f26862a;
        this.f26570e = new zzfbm(zzclpVar);
        zzfcd zzfcdVar = new zzfcd(zzfccVar);
        int i4 = zzcpe.f26863a;
        this.f26571f = new zzfbu(zzfcdVar);
        int i5 = zzcpg.f26864a;
        this.f26572g = new zzfcb(zzclpVar, zzijfVar);
        this.f26573h = new zzfct();
        zzfci zzfciVar = new zzfci(zzfccVar);
        zzfcj zzfcjVar = new zzfcj(zzfccVar);
        int i6 = zzcpk.f26866a;
        zzijf zzijfVar2 = zzcmvVar.Y;
        this.f26574i = new zzfcp(zzijfVar2, zzfcgVar, zzfcdVar, zzijfVar, zzfciVar, zzfcjVar);
        int i7 = zzcpa.f26861a;
        this.f26575j = new zzfbi(zzfcdVar, zzijfVar2, zzijfVar);
        zzfch zzfchVar = new zzfch(zzfccVar);
        zzijf zzijfVarA = zzijf.a(zzdvx.f28648a);
        zzijf zzijfVarA2 = zzijf.a(zzdvv.f28647a);
        zzijf zzijfVarA3 = zzijf.a(zzdvz.f28649a);
        zzijf zzijfVarA4 = zzijf.a(zzdwb.f28650a);
        int i8 = zzijk.f34900b;
        zzijj zzijjVar = new zzijj(4);
        zzijjVar.a(zzfmo.GMS_SIGNALS, zzijfVarA);
        zzijjVar.a(zzfmo.BUILD_URL, zzijfVarA2);
        zzijjVar.a(zzfmo.HTTP, zzijfVarA3);
        zzijjVar.a(zzfmo.PRE_PROCESS, zzijfVarA4);
        zzijf zzijfVarA5 = zzijf.a(new zzdwd(zzfchVar, zzcmvVar.f26583h, zzijjVar.c()));
        int i9 = zzijs.f34903c;
        zzijr zzijrVar = new zzijr(0, 1);
        zzijrVar.b(zzijfVarA5);
        this.f26576k = zzijf.a(new zzfmw(zzcmvVar.f26580e, new zzfmx(zzijrVar.c())));
    }

    @Override // com.google.android.gms.internal.ads.zzfaz
    public final zzfaa a() {
        zzcmv zzcmvVar = this.f26567b;
        Context context = zzcmvVar.f26577b.f26510b;
        zzijo.a(context);
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        new zzccp();
        zzfcc zzfccVar = this.f26566a;
        zzfcd.a(zzfccVar);
        zzfbs zzfbsVar = new zzfbs();
        zzijf zzijfVar = zzcmvVar.f26580e;
        zzeyj zzeyjVar = new zzeyj(zzfbsVar, 0L, (ScheduledExecutorService) zzijfVar.zzb());
        new zzbxc();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) zzijfVar.zzb();
        zzcli zzcliVar = zzcmvVar.f26577b;
        zzijo.a(zzcliVar.f26510b);
        zzeyj zzeyjVar2 = new zzeyj(new zzfbz(scheduledExecutorService), ((Long) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.S4)).longValue(), (ScheduledExecutorService) zzijfVar.zzb());
        zzccs zzccsVar = new zzccs();
        Context context2 = zzcliVar.f26510b;
        zzijo.a(context2);
        ScheduledExecutorService scheduledExecutorService2 = (ScheduledExecutorService) zzijfVar.zzb();
        zzbza zzbzaVar = zzfccVar.f30832a;
        zzeyj zzeyjVar3 = new zzeyj(new zzfaw(zzccsVar, context2, scheduledExecutorService2, zzgywVar, zzfccVar.f30833b, zzbzaVar.f25731l, zzbzaVar.f25730k), 0L, (ScheduledExecutorService) zzijfVar.zzb());
        zzeyj zzeyjVar4 = new zzeyj(new zzfcr(zzgywVar), 0L, (ScheduledExecutorService) zzijfVar.zzb());
        new zzbey();
        zzijo.a(context2);
        zzfbk zzfbkVar = new zzfbk(zzgywVar);
        new zzbfu();
        zzijo.a(zzgywVar);
        ArrayList arrayList = zzfccVar.f30832a.f25724e;
        zzijo.a(arrayList);
        zzfbw zzfbwVar = new zzfbw(zzgywVar, arrayList);
        zzfbc zzfbcVarD = d();
        zzezx zzezxVar = (zzezx) zzcmvVar.S0.zzb();
        String str = zzbzaVar.f25723d;
        zzijo.a(str);
        new zzbem();
        zzijf zzijfVar2 = zzcmvVar.Y;
        zzfbg zzfbgVar = new zzfbg((zzcda) zzijfVar2.zzb(), (ScheduledExecutorService) zzijfVar.zzb(), zzgywVar);
        zzcda zzcdaVar = (zzcda) zzijfVar2.zzb();
        new zzccq();
        zzijo.a(str);
        return new zzfaa(context, zzgywVar, zzgtn.n(zzeyjVar, zzeyjVar2, zzeyjVar3, zzeyjVar4, zzfbkVar, zzfbwVar, zzfbcVarD, zzezxVar, zzfbgVar, new zzfcn(zzcdaVar, zzbzaVar.f25730k, zzgywVar, (ScheduledExecutorService) zzijfVar.zzb(), zzfccVar.a(), zzbzaVar.o)), (zzfno) this.f26568c.zzb(), (zzdxe) zzcmvVar.f26587l.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzfaz
    public final zzfmu b() {
        return (zzfmu) this.f26576k.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzfaz
    public final zzfno c() {
        return (zzfno) this.f26568c.zzb();
    }

    public final zzfbc d() {
        new zzccs();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        zzfcc zzfccVar = this.f26566a;
        String string = zzfccVar.f30832a.f25720a.getString("ms");
        if (string == null) {
            string = "";
        }
        PackageInfo packageInfo = zzfccVar.f30832a.f25725f;
        return new zzfbc(zzgywVar, string);
    }
}
