package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzqe extends zzqt {

    /* renamed from: a, reason: collision with root package name */
    public final zzqj f38022a;

    public zzqe(zzqj zzqjVar) {
        this.f38022a = zzqjVar;
    }

    public static zzqe b(zzqj zzqjVar, zzyw zzywVar, Integer num) throws GeneralSecurityException {
        if (zzywVar.f38164a.f38163a.length != 32) {
            throw new GeneralSecurityException("Invalid key size");
        }
        zzqi zzqiVar = zzqi.f38026e;
        zzqi zzqiVar2 = zzqjVar.f38029b;
        if (zzqiVar2 != zzqiVar && num == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with format with ID requirement");
        }
        if (zzqiVar2 == zzqiVar && num != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with format without ID requirement");
        }
        return new zzqe(zzqjVar);
    }

    @Override // com.google.android.gms.internal.pal.zzqt, com.google.android.gms.internal.pal.zzka
    public final /* synthetic */ zzks a() {
        return this.f38022a;
    }
}
