package com.google.android.gms.internal.ads;

import android.media.AudioTrack$StreamEventCallback;
import android.os.Handler;
import androidx.annotation.RequiresApi;
import java.util.Objects;
import java.util.concurrent.Executor;

@RequiresApi
/* loaded from: classes4.dex */
final class zzry {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f35462a;

    /* renamed from: b, reason: collision with root package name */
    public final AudioTrack$StreamEventCallback f35463b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzrz f35464c;

    public /* synthetic */ zzry(zzrz zzrzVar) {
        Objects.requireNonNull(zzrzVar);
        this.f35464c = zzrzVar;
        final Handler handlerN = zzfj.n();
        this.f35462a = handlerN;
        zzrw zzrwVar = new zzrw(this);
        this.f35463b = zzrwVar;
        zzrzVar.f35465a.registerStreamEventCallback(new Executor() { // from class: com.google.android.gms.internal.ads.zzrx
            @Override // java.util.concurrent.Executor
            public final /* synthetic */ void execute(Runnable runnable) {
                handlerN.post(runnable);
            }
        }, zzrwVar);
    }
}
