package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzgsd extends zzgsg {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzgsk f33143e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgsd(zzgsk zzgskVar) {
        super(zzgskVar);
        Objects.requireNonNull(zzgskVar);
        this.f33143e = zzgskVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgsg
    public final /* bridge */ /* synthetic */ Object a(int i2) {
        return new zzgsi(this.f33143e, i2);
    }
}
