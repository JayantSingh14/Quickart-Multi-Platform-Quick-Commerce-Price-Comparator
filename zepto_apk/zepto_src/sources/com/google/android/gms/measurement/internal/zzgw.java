package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.util.Map;

@WorkerThread
/* loaded from: classes.dex */
final class zzgw implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final zzgv f38970a;

    /* renamed from: b, reason: collision with root package name */
    public final int f38971b;

    /* renamed from: c, reason: collision with root package name */
    public final IOException f38972c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f38973d;

    /* renamed from: e, reason: collision with root package name */
    public final String f38974e;

    /* renamed from: f, reason: collision with root package name */
    public final Map f38975f;

    public /* synthetic */ zzgw(String str, zzgv zzgvVar, int i2, IOException iOException, byte[] bArr, Map map) {
        Preconditions.checkNotNull(zzgvVar);
        this.f38970a = zzgvVar;
        this.f38971b = i2;
        this.f38972c = iOException;
        this.f38973d = bArr;
        this.f38974e = str;
        this.f38975f = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f38970a.a(this.f38974e, this.f38971b, this.f38972c, this.f38973d, this.f38975f);
    }
}
