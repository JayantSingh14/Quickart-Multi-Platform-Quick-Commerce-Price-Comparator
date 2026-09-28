package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.media.AudioTrack$StreamEventCallback;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzrw extends AudioTrack$StreamEventCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzry f35460a;

    public zzrw(zzry zzryVar) {
        Objects.requireNonNull(zzryVar);
        this.f35460a = zzryVar;
    }

    public final void onDataRequest(AudioTrack audioTrack, int i2) {
        zzed zzedVar = this.f35460a.f35464c.f35472h;
        zzedVar.c(-1, zzrv.f35459a);
        zzedVar.d();
    }

    public final void onPresentationEnded(AudioTrack audioTrack) {
        zzed zzedVar = this.f35460a.f35464c.f35472h;
        zzedVar.c(-1, zzrt.f35457a);
        zzedVar.d();
    }

    public final void onTearDown(AudioTrack audioTrack) {
        zzed zzedVar = this.f35460a.f35464c.f35472h;
        zzedVar.c(-1, zzru.f35458a);
        zzedVar.d();
    }
}
