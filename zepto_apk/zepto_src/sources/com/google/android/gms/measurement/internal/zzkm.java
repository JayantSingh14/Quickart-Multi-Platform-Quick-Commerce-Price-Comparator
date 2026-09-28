package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Objects;

/* loaded from: classes.dex */
final class zzkm implements zzpn {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzli f39269a;

    public zzkm(zzli zzliVar) {
        Objects.requireNonNull(zzliVar);
        this.f39269a = zzliVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzpn
    public final void a(String str, String str2, Bundle bundle) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        zzli zzliVar = this.f39269a;
        if (zIsEmpty) {
            zzliVar.l("auto", "_err", bundle);
        } else {
            zzliVar.getClass();
            throw new IllegalStateException("Unexpected call on client side");
        }
    }
}
