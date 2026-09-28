package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzfqz {

    /* renamed from: a, reason: collision with root package name */
    public final Context f31680a;

    /* renamed from: b, reason: collision with root package name */
    public final VersionInfoParcel f31681b;

    /* renamed from: c, reason: collision with root package name */
    public final ScheduledExecutorService f31682c;

    /* renamed from: d, reason: collision with root package name */
    public final zzfly f31683d;

    /* renamed from: e, reason: collision with root package name */
    public final ClientApi f31684e = new ClientApi();

    /* renamed from: f, reason: collision with root package name */
    public final zzfjg f31685f;

    /* renamed from: g, reason: collision with root package name */
    public final Clock f31686g;

    /* renamed from: h, reason: collision with root package name */
    public final zzfpp f31687h;

    public zzfqz(Context context, VersionInfoParcel versionInfoParcel, ScheduledExecutorService scheduledExecutorService, zzfly zzflyVar, zzfjg zzfjgVar, Clock clock, zzfpp zzfppVar) {
        this.f31680a = context;
        this.f31681b = versionInfoParcel;
        this.f31682c = scheduledExecutorService;
        this.f31683d = zzflyVar;
        this.f31686g = clock;
        this.f31685f = zzfjgVar;
        this.f31687h = zzfppVar;
    }

    public final zzfqy a(com.google.android.gms.ads.internal.client.zzft zzftVar, com.google.android.gms.ads.internal.client.zzce zzceVar) {
        AdFormat adFormatA = AdFormat.a(zzftVar.f21240b);
        if (adFormatA == null) {
            return null;
        }
        int iOrdinal = adFormatA.ordinal();
        VersionInfoParcel versionInfoParcel = this.f31681b;
        Context context = this.f31680a;
        if (iOrdinal == 1) {
            int i2 = versionInfoParcel.f21402c;
            zzfpy zzfpyVarC = c();
            return new zzfqa(this.f31684e, context, i2, this.f31685f, zzftVar, zzceVar, this.f31682c, this.f31683d, zzfpyVarC, this.f31686g);
        }
        if (iOrdinal == 2) {
            int i3 = versionInfoParcel.f21402c;
            zzfpy zzfpyVarC2 = c();
            return new zzfrd(this.f31684e, context, i3, this.f31685f, zzftVar, zzceVar, this.f31682c, this.f31683d, zzfpyVarC2, this.f31686g);
        }
        if (iOrdinal != 5) {
            return null;
        }
        int i4 = versionInfoParcel.f21402c;
        zzfpy zzfpyVarC3 = c();
        return new zzfpx(this.f31684e, context, i4, this.f31685f, zzftVar, zzceVar, this.f31682c, this.f31683d, zzfpyVarC3, this.f31686g);
    }

    public final zzfqy b(String str, com.google.android.gms.ads.internal.client.zzft zzftVar, com.google.android.gms.ads.internal.client.zzch zzchVar) {
        AdFormat adFormatA = AdFormat.a(zzftVar.f21240b);
        if (adFormatA == null) {
            return null;
        }
        int iOrdinal = adFormatA.ordinal();
        VersionInfoParcel versionInfoParcel = this.f31681b;
        Context context = this.f31680a;
        if (iOrdinal == 1) {
            return new zzfqa(str, this.f31684e, context, versionInfoParcel.f21402c, this.f31685f, zzftVar, zzchVar, this.f31682c, this.f31683d, c(), this.f31686g, this.f31687h);
        }
        if (iOrdinal == 2) {
            return new zzfrd(str, this.f31684e, context, versionInfoParcel.f21402c, this.f31685f, zzftVar, zzchVar, this.f31682c, this.f31683d, c(), this.f31686g, this.f31687h);
        }
        if (iOrdinal != 5) {
            return null;
        }
        return new zzfpx(str, this.f31684e, context, versionInfoParcel.f21402c, this.f31685f, zzftVar, zzchVar, this.f31682c, this.f31683d, c(), this.f31686g, this.f31687h);
    }

    public final zzfpy c() {
        zzbgb zzbgbVar = zzbgk.G;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        return new zzfpy(((Long) zzbdVar.f21153c.a(zzbgbVar)).longValue(), ((Long) zzbdVar.f21153c.a(zzbgk.H)).longValue(), this.f31686g);
    }
}
