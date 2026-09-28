package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public final class zzgjq implements zzgje {

    /* renamed from: a, reason: collision with root package name */
    public final Context f32742a;

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f32743b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgbc f32744c;

    /* renamed from: d, reason: collision with root package name */
    public final String f32745d;

    /* renamed from: e, reason: collision with root package name */
    public final String f32746e;

    /* renamed from: f, reason: collision with root package name */
    public final zzgnc f32747f;

    /* renamed from: g, reason: collision with root package name */
    public final zzgjs f32748g;

    public zzgjq(Context context, ExecutorService executorService, zzgad zzgadVar, zzgbc zzgbcVar, zzgnc zzgncVar, zzgjs zzgjsVar) {
        this.f32742a = context;
        this.f32743b = executorService;
        this.f32744c = zzgbcVar;
        this.f32747f = zzgncVar;
        this.f32748g = zzgjsVar;
        this.f32745d = zzgadVar.I();
        this.f32746e = zzgadVar.O().E();
    }

    public static zzgcq a(int i2) {
        zzgcp zzgcpVarF = zzgcq.F();
        zzgcpVarF.j();
        ((zzgcq) zzgcpVarF.f34638b).K(i2);
        return (zzgcq) zzgcpVarF.l();
    }

    @Override // com.google.android.gms.internal.ads.zzgje
    public final zzgye zza() {
        int i2;
        zzbbl zzbblVarC = zzbbm.C();
        byte[] bArrA = zzatg.a();
        zzhzl zzhzlVar = zzhzl.f34557b;
        zzhzl zzhzlVarV = zzhzl.v(0, bArrA, bArrA.length);
        zzbblVarC.j();
        ((zzbbm) zzbblVarC.f34638b).D(zzhzlVarV);
        long j2 = Build.VERSION.SDK_INT;
        zzbblVarC.j();
        ((zzbbm) zzbblVarC.f34638b).E(j2);
        String str = Build.MODEL;
        zzbblVarC.j();
        ((zzbbm) zzbblVarC.f34638b).F(str);
        Context context = this.f32742a;
        String packageName = context.getPackageName();
        zzbblVarC.j();
        ((zzbbm) zzbblVarC.f34638b).G(packageName);
        try {
            i2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            i2 = -1;
        }
        zzbblVarC.j();
        ((zzbbm) zzbblVarC.f34638b).H(i2);
        zzbblVarC.j();
        ((zzbbm) zzbblVarC.f34638b).I(this.f32745d);
        byte[] bArrG = ((zzbbm) zzbblVarC.l()).g();
        zzgvx zzgvxVar = (zzgvx) zzgvy.f33276b;
        Character ch2 = zzgvxVar.f33273e;
        zzgvy zzgvyVarI = zzgvxVar;
        if (ch2 != null) {
            zzgvyVarI = zzgvxVar.i(zzgvxVar.f33272d, null);
        }
        zzgye zzgyeVar = (zzgye) zzgym.i(zzgye.s(this.f32744c.a(Uri.parse(this.f32746e).buildUpon().appendQueryParameter("aspq", zzgvyVarI.g(bArrG.length, bArrG)).build().toString())), new zzgpr() { // from class: com.google.android.gms.internal.ads.zzgjp
            @Override // com.google.android.gms.internal.ads.zzgpr
            public final Object apply(Object obj) {
                zzgbb zzgbbVar = (zzgbb) obj;
                zzgjq zzgjqVar = this.f32741a;
                zzgjqVar.getClass();
                int iZza = zzgbbVar.zza();
                zzgnc zzgncVar = zzgjqVar.f32747f;
                if (iZza != 200) {
                    zzgncVar.c(20003, new String(zzatg.a(), StandardCharsets.UTF_8));
                    return zzgjq.a(7);
                }
                try {
                    String strZzb = zzgbbVar.zzb();
                    if (TextUtils.isEmpty(strZzb)) {
                        zzgncVar.b(20004);
                        return zzgjq.a(8);
                    }
                    zzbbo zzbboVarD = zzbbo.D(zzgay.a(strZzb, true), zziab.a());
                    if (zzbboVarD.C().E() && zzbboVarD.C().C()) {
                        if (!zzgjqVar.f32748g.a(zzbboVarD)) {
                            zzgncVar.b(20006);
                            return zzgjq.a(12);
                        }
                        zzgcp zzgcpVarF = zzgcq.F();
                        zzgcr zzgcrVarG = zzgcs.G();
                        zzbbw zzbbwVarD = zzbboVarD.C().D();
                        zzgcrVarG.j();
                        ((zzgcs) zzgcrVarG.f34638b).J(zzbbwVarD);
                        zzgcpVarF.j();
                        ((zzgcq) zzgcpVarF.f34638b).G((zzgcs) zzgcrVarG.l());
                        zzhzl zzhzlVarF = zzbboVarD.C().F();
                        zzgcpVarF.j();
                        ((zzgcq) zzgcpVarF.f34638b).H(zzhzlVarF);
                        zzgcpVarF.j();
                        ((zzgcq) zzgcpVarF.f34638b).K(2);
                        return (zzgcq) zzgcpVarF.l();
                    }
                    zzgncVar.b(20004);
                    return zzgjq.a(8);
                } catch (Throwable th) {
                    zzgncVar.d(20005, th);
                    return zzgjq.a(6);
                }
            }
        }, this.f32743b);
        zzgpr zzgprVar = new zzgpr() { // from class: com.google.android.gms.internal.ads.zzgjn
            @Override // com.google.android.gms.internal.ads.zzgpr
            public final /* synthetic */ Object apply(Object obj) {
                this.f32739a.f32747f.b(20007);
                return zzgjq.a(13);
            }
        };
        zzgyb zzgybVar = zzgyb.f33369a;
        zzgye zzgyeVar2 = (zzgye) zzgym.e((zzgye) zzgym.e(zzgyeVar, UnknownHostException.class, zzgprVar, zzgybVar), SocketException.class, new zzgpr() { // from class: com.google.android.gms.internal.ads.zzgjo
            @Override // com.google.android.gms.internal.ads.zzgpr
            public final /* synthetic */ Object apply(Object obj) {
                this.f32740a.f32747f.b(20008);
                return zzgjq.a(13);
            }
        }, zzgybVar);
        this.f32747f.e(20002, zzgyeVar2);
        return zzgyeVar2;
    }
}
