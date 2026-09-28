package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public final class zzjr {

    /* renamed from: a, reason: collision with root package name */
    public final Context f39212a;

    /* renamed from: b, reason: collision with root package name */
    public final Boolean f39213b;

    /* renamed from: c, reason: collision with root package name */
    public final long f39214c;

    /* renamed from: d, reason: collision with root package name */
    public final com.google.android.gms.internal.measurement.zzdd f39215d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f39216e;

    /* renamed from: f, reason: collision with root package name */
    public final Long f39217f;

    /* renamed from: g, reason: collision with root package name */
    public final String f39218g;

    public zzjr(Context context, com.google.android.gms.internal.measurement.zzdd zzddVar, Long l2) {
        this.f39216e = true;
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.f39212a = applicationContext;
        this.f39217f = l2;
        if (zzddVar != null) {
            this.f39215d = zzddVar;
            this.f39216e = zzddVar.f36833c;
            this.f39214c = zzddVar.f36832b;
            this.f39218g = zzddVar.f36835e;
            Bundle bundle = zzddVar.f36834d;
            if (bundle != null) {
                this.f39213b = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
