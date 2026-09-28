package com.google.android.play.core.appupdate;

import android.content.IntentFilter;
import com.google.android.play.core.appupdate.internal.zzaf;

/* loaded from: classes.dex */
public final class zzd implements zzaf {

    /* renamed from: a, reason: collision with root package name */
    public final zzk f41714a;

    public zzd(zzk zzkVar) {
        this.f41714a = zzkVar;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzaf
    public final Object zza() {
        return new zzc(new com.google.android.play.core.appupdate.internal.zzm("AppUpdateListenerRegistry"), new IntentFilter("com.google.android.play.core.install.ACTION_INSTALL_STATUS"), this.f41714a.f41724a.f41722a);
    }
}
