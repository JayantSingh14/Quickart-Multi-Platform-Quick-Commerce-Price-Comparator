package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzov implements zzgv {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f39567a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f39568b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzpf f39569c;

    public zzov(zzpf zzpfVar, String str, ArrayList arrayList) {
        this.f39567a = str;
        this.f39568b = arrayList;
        Objects.requireNonNull(zzpfVar);
        this.f39569c = zzpfVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgv
    public final void a(String str, int i2, IOException iOException, byte[] bArr, Map map) {
        this.f39569c.x(true, i2, iOException, bArr, this.f39567a, this.f39568b);
    }
}
