package com.google.android.play.core.splitinstall.internal;

import android.content.Context;
import com.google.android.play.core.splitcompat.SplitCompat;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public final class zzak implements com.google.android.play.core.splitinstall.zzh {

    /* renamed from: a, reason: collision with root package name */
    public final Context f41956a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.play.core.splitcompat.zze f41957b;

    /* renamed from: c, reason: collision with root package name */
    public final zzam f41958c;

    /* renamed from: d, reason: collision with root package name */
    public final ThreadPoolExecutor f41959d;

    public zzak(Context context, ThreadPoolExecutor threadPoolExecutor, zzam zzamVar, com.google.android.play.core.splitcompat.zze zzeVar) {
        this.f41956a = context;
        this.f41957b = zzeVar;
        this.f41958c = zzamVar;
        this.f41959d = threadPoolExecutor;
    }

    @Override // com.google.android.play.core.splitinstall.zzh
    public final void a(List list, com.google.android.play.core.splitinstall.zzf zzfVar) {
        if (SplitCompat.f41899e.get() == null) {
            throw new IllegalStateException("Ingestion should only be called in SplitCompat mode.");
        }
        this.f41959d.execute(new zzaj(this, list, zzfVar));
    }
}
