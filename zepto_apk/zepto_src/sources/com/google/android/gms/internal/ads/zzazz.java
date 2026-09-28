package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzazz extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbaa f24597a;

    public zzazz(zzbaa zzbaaVar) {
        Objects.requireNonNull(zzbaaVar);
        this.f24597a = zzbaaVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.f24597a.c();
    }
}
