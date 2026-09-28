package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLogging;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.tasks.OnFailureListener;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes4.dex */
public final class zzgp {

    /* renamed from: d, reason: collision with root package name */
    public static zzgp f38940d;

    /* renamed from: a, reason: collision with root package name */
    public final zzib f38941a;

    /* renamed from: b, reason: collision with root package name */
    public final TelemetryLoggingClient f38942b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicLong f38943c = new AtomicLong(-1);

    public zzgp(Context context, zzib zzibVar) {
        this.f38942b = TelemetryLogging.getClient(context, TelemetryLoggingOptions.builder().setApi("measurement:api").build());
        this.f38941a = zzibVar;
    }

    public static zzgp a(zzib zzibVar) {
        if (f38940d == null) {
            f38940d = new zzgp(zzibVar.f39084a, zzibVar);
        }
        return f38940d;
    }

    public final synchronized void b(int i2, int i3, long j2, long j3) {
        final long jElapsedRealtime = this.f38941a.f39094k.elapsedRealtime();
        AtomicLong atomicLong = this.f38943c;
        if (atomicLong.get() != -1 && jElapsedRealtime - atomicLong.get() <= 1800000) {
            return;
        }
        this.f38942b.log(new TelemetryData(0, Arrays.asList(new MethodInvocation(36301, i2, 0, j2, j3, null, null, 0, i3)))).c(new OnFailureListener() { // from class: com.google.android.gms.measurement.internal.zzgo
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final /* synthetic */ void onFailure(Exception exc) {
                this.f38938a.f38943c.set(jElapsedRealtime);
            }
        });
    }
}
