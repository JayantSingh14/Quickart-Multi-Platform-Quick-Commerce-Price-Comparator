package com.google.android.play.core.splitinstall;

import com.google.android.gms.tasks.Task;
import com.google.android.play.core.splitinstall.internal.zzby;
import java.util.Set;

/* loaded from: classes4.dex */
final class zzl implements SplitInstallManager {

    /* renamed from: a, reason: collision with root package name */
    public final zzby f42121a;

    /* renamed from: b, reason: collision with root package name */
    public final zzby f42122b;

    /* renamed from: c, reason: collision with root package name */
    public final zzby f42123c;

    public zzl(zzby zzbyVar, zzby zzbyVar2, zzby zzbyVar3) {
        this.f42121a = zzbyVar;
        this.f42122b = zzbyVar2;
        this.f42123c = zzbyVar3;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task a(SplitInstallRequest splitInstallRequest) {
        return e().a(splitInstallRequest);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Set b() {
        return e().b();
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final void c(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        e().c(splitInstallStateUpdatedListener);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final void d(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        e().d(splitInstallStateUpdatedListener);
    }

    public final SplitInstallManager e() {
        return this.f42123c.zza() != null ? (SplitInstallManager) this.f42122b.zza() : (SplitInstallManager) this.f42121a.zza();
    }
}
