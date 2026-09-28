package com.google.android.gms.measurement.internal;

import androidx.fragment.app.e;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzie implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzr f39101a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzjc f39102b;

    public zzie(zzjc zzjcVar, zzr zzrVar) {
        this.f39101a = zzrVar;
        Objects.requireNonNull(zzjcVar);
        this.f39102b = zzjcVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        zzjc zzjcVar = this.f39102b;
        zzjcVar.f39177a.A();
        zzpf zzpfVar = zzjcVar.f39177a;
        e.y(zzpfVar);
        zzr zzrVar = this.f39101a;
        Preconditions.checkNotNull(zzrVar);
        String str = zzrVar.f39648a;
        Preconditions.checkNotEmpty(str);
        int i2 = 0;
        if (zzpfVar.d0().q(null, zzfx.z0)) {
            long jCurrentTimeMillis = zzpfVar.f().currentTimeMillis();
            int iO = zzpfVar.d0().o(null, zzfx.i0);
            zzpfVar.d0();
            long jLongValue = jCurrentTimeMillis - ((Long) zzfx.f38906e.a(null)).longValue();
            while (i2 < iO && zzpfVar.G(jLongValue, null)) {
                i2++;
            }
        } else {
            zzpfVar.d0();
            long jIntValue = ((Integer) zzfx.f38913l.a(null)).intValue();
            while (i2 < jIntValue && zzpfVar.G(0L, str)) {
                i2++;
            }
        }
        if (zzpfVar.d0().q(null, zzfx.A0)) {
            zzpfVar.c().g();
            zzpfVar.F();
        }
        com.google.android.gms.internal.measurement.zzin zzinVarA = com.google.android.gms.internal.measurement.zzin.a(zzrVar.E);
        zzot zzotVar = zzpfVar.f39603j;
        zzotVar.g();
        if (zzinVarA != com.google.android.gms.internal.measurement.zzin.CLIENT_UPLOAD_ELIGIBLE || zzot.j(str)) {
            return;
        }
        zzhs zzhsVar = zzotVar.f39551b.f39594a;
        zzpf.S(zzhsVar);
        com.google.android.gms.internal.measurement.zzgl zzglVarS = zzhsVar.s(str);
        if (zzglVarS == null || !zzglVarS.G() || zzglVarS.H().t().isEmpty()) {
            return;
        }
        zzpfVar.b().n.b(str, "[sgtm] Going background, trigger client side upload. appId");
        zzpfVar.r(zzpfVar.f().currentTimeMillis(), str);
    }
}
