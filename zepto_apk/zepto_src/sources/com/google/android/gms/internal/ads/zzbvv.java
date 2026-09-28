package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzbvv implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbvx f25615a;

    public zzbvv(zzbvx zzbvxVar) {
        Objects.requireNonNull(zzbvxVar);
        this.f25615a = zzbvxVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f25615a.f(true);
    }
}
