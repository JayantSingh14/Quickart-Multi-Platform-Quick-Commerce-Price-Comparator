package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Objects;

/* loaded from: classes.dex */
final class zzpa implements zzpn {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzpf f39582a;

    public zzpa(zzpf zzpfVar) {
        Objects.requireNonNull(zzpfVar);
        this.f39582a = zzpfVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzpn
    public final void a(String str, String str2, Bundle bundle) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        zzpf zzpfVar = this.f39582a;
        if (!zIsEmpty) {
            zzpfVar.c().p(new zzoz(this, str, str2, bundle));
            return;
        }
        zzib zzibVar = zzpfVar.f39605l;
        if (zzibVar != null) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.b(str2, "AppId not known when logging event");
        }
    }
}
