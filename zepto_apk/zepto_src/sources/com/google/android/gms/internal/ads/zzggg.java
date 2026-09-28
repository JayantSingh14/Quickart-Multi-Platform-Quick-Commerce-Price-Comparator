package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.UnsupportedEncodingException;

/* loaded from: classes4.dex */
public final class zzggg {

    /* renamed from: a, reason: collision with root package name */
    public final Context f32542a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgnc f32543b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgec f32544c;

    /* renamed from: d, reason: collision with root package name */
    public final String f32545d;

    public zzggg(Context context, zzgnc zzgncVar, zzgec zzgecVar, zzgad zzgadVar) {
        this.f32542a = context;
        this.f32543b = zzgncVar;
        this.f32544c = zzgecVar;
        this.f32545d = zzgadVar.I();
    }

    public final String a(long j2) {
        String string;
        boolean z;
        zzgna zzgnaVarA = this.f32543b.a(55);
        try {
            try {
                zzgnaVarA.a();
                zzawy zzawyVarC = zzawz.C();
                String str = this.f32545d;
                zzawyVarC.j();
                ((zzawz) zzawyVarC.f34638b).E(str);
                zzawyVarC.j();
                ((zzawz) zzawyVarC.f34638b).D("0.815976881");
                Context context = this.f32542a;
                String packageName = context.getPackageName();
                zzawyVarC.j();
                ((zzawz) zzawyVarC.f34638b).G(packageName);
                long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                zzawyVarC.j();
                ((zzawz) zzawyVarC.f34638b).F(jCurrentTimeMillis);
                long jCurrentTimeMillis2 = (System.currentTimeMillis() - j2) / 1000;
                zzawyVarC.j();
                ((zzawz) zzawyVarC.f34638b).I(jCurrentTimeMillis2);
                try {
                    long j3 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
                    zzawyVarC.j();
                    ((zzawz) zzawyVarC.f34638b).H(j3);
                } catch (PackageManager.NameNotFoundException unused) {
                    zzawyVarC.j();
                    ((zzawz) zzawyVarC.f34638b).H(-1L);
                }
                zzgec zzgecVar = this.f32544c;
                synchronized (zzgecVar) {
                    z = zzgecVar.f32373d;
                }
                if (!z) {
                    zzgecVar.a();
                }
                zzaxf zzaxfVarD = zzgecVar.d(null, ((zzawz) zzawyVarC.l()).g());
                zzaxfVarD.j();
                ((zzaxg) zzaxfVarD.f34638b).F(5);
                zzaxfVarD.j();
                ((zzaxg) zzaxfVarD.f34638b).G(2);
                byte[] bArrG = ((zzaxg) zzaxfVarD.l()).g();
                zzgvx zzgvxVar = (zzgvx) zzgvy.f33276b;
                string = (zzgvxVar.f33273e == null ? zzgvxVar : zzgvxVar.i(zzgvxVar.f33272d, null)).g(bArrG.length, bArrG);
            } catch (Throwable th) {
                zzgnaVarA.c();
                throw th;
            }
        } catch (UnsupportedEncodingException e2) {
            zzgnaVarA.b(e2);
            string = Integer.toString(7);
        } catch (Throwable th2) {
            zzgnaVarA.b(th2);
            throw th2;
        }
        zzgnaVarA.c();
        return string;
    }
}
