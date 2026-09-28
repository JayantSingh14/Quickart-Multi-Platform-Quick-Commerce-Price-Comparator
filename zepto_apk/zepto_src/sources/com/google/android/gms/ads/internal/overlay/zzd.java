package com.google.android.gms.ads.internal.overlay;

import android.view.View;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzd implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzm f21347a;

    public zzd(zzm zzmVar) {
        Objects.requireNonNull(zzmVar);
        this.f21347a = zzmVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        zzm zzmVar = this.f21347a;
        zzmVar.w = 2;
        zzmVar.f21360b.finish();
    }
}
