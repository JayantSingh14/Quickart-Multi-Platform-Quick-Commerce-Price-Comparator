package com.google.android.gms.measurement.internal;

import android.app.BroadcastOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzox extends zzay {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzpf f39573e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzox(zzpf zzpfVar, zzjf zzjfVar) {
        super(zzjfVar);
        Objects.requireNonNull(zzpfVar);
        this.f39573e = zzpfVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzay
    public final void a() {
        zzpf zzpfVar = this.f39573e;
        zzpfVar.c().g();
        String str = (String) zzpfVar.q.pollFirst();
        if (str != null) {
            zzpfVar.I = zzpfVar.f().elapsedRealtime();
            zzpfVar.b().n.b(str, "Sending trigger URI notification to app");
            Intent intent = new Intent();
            intent.setAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
            intent.setPackage(str);
            Context context = zzpfVar.f39605l.f39084a;
            if (Build.VERSION.SDK_INT < 34) {
                context.sendBroadcast(intent);
            } else {
                context.sendBroadcast(intent, null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
            }
        }
        zzpfVar.F();
    }
}
