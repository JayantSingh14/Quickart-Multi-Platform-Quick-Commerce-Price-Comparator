package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
final class zzha extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final zzpf f38996a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f38997b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f38998c;

    public zzha(zzpf zzpfVar) {
        Preconditions.checkNotNull(zzpfVar);
        this.f38996a = zzpfVar;
    }

    public final void a() {
        zzpf zzpfVar = this.f38996a;
        zzpfVar.k0();
        zzpfVar.c().g();
        zzpfVar.c().g();
        if (this.f38997b) {
            zzpfVar.b().n.a("Unregistering connectivity change receiver");
            this.f38997b = false;
            this.f38998c = false;
            try {
                zzpfVar.f39605l.f39084a.unregisterReceiver(this);
            } catch (IllegalArgumentException e2) {
                zzpfVar.b().f38958f.b(e2, "Failed to unregister the network broadcast receiver");
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        zzpf zzpfVar = this.f38996a;
        zzpfVar.k0();
        String action = intent.getAction();
        zzpfVar.b().n.b(action, "NetworkBroadcastReceiver received action");
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            zzpfVar.b().f38961i.b(action, "NetworkBroadcastReceiver received unknown action");
            return;
        }
        zzgy zzgyVar = zzpfVar.f39595b;
        zzpf.S(zzgyVar);
        boolean zK = zzgyVar.k();
        if (this.f38998c != zK) {
            this.f38998c = zK;
            zzpfVar.c().p(new zzgz(this, zK));
        }
    }
}
