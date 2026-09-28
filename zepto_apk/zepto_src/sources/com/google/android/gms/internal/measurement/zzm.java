package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzm extends zzai {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzo f37105c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzm(zzn zznVar, zzo zzoVar) {
        super("getValue");
        this.f37105c = zzoVar;
        Objects.requireNonNull(zznVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzao a(zzg zzgVar, List list) {
        zzh.a("getValue", list, 2);
        zzao zzaoVarB = zzgVar.f36956b.b(zzgVar, (zzao) list.get(0));
        zzao zzaoVarB2 = zzgVar.f36956b.b(zzgVar, (zzao) list.get(1));
        String strA = this.f37105c.a(zzaoVarB.zzc());
        return strA != null ? new zzas(strA) : zzaoVarB2;
    }
}
