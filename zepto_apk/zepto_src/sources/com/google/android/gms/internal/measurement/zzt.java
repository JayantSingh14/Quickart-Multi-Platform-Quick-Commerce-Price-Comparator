package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes4.dex */
public final class zzt extends zzai {

    /* renamed from: c, reason: collision with root package name */
    public final zzr f37319c;

    public zzt(zzr zzrVar) {
        super("internal.logger");
        this.f37319c = zzrVar;
        this.f36763b.put("log", new zzs(this, false, true));
        this.f36763b.put("silent", new zzp("silent"));
        ((zzai) this.f36763b.get("silent")).d("log", new zzs(this, true, true));
        this.f36763b.put("unmonitored", new zzq("unmonitored"));
        ((zzai) this.f36763b.get("unmonitored")).d("log", new zzs(this, false, false));
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzao a(zzg zzgVar, List list) {
        return zzao.o0;
    }
}
