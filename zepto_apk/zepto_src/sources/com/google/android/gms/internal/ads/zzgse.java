package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzgse extends zzgsg {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzgsk f33144e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgse(zzgsk zzgskVar) {
        super(zzgskVar);
        Objects.requireNonNull(zzgskVar);
        this.f33144e = zzgskVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgsg
    public final Object a(int i2) {
        return this.f33144e.c()[i2];
    }
}
