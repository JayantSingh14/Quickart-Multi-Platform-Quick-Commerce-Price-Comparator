package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Range;

/* loaded from: classes4.dex */
public final class zzaca {

    /* renamed from: a, reason: collision with root package name */
    public final Context f22696a;

    /* renamed from: b, reason: collision with root package name */
    public final zzacm f22697b;

    /* renamed from: c, reason: collision with root package name */
    public zzbs f22698c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f22699d;

    /* renamed from: e, reason: collision with root package name */
    public zzfc f22700e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f22701f;

    /* renamed from: g, reason: collision with root package name */
    public long f22702g = 15000;

    /* renamed from: h, reason: collision with root package name */
    public final zzacn f22703h;

    public zzaca(Context context, zzacm zzacmVar) {
        this.f22696a = context.getApplicationContext();
        this.f22697b = zzacmVar;
        zzacn zzacnVar = new zzacn();
        Range range = new Range(Double.valueOf(0.0d), Double.valueOf(1.0d));
        zzacnVar.f22746d = range;
        zzacnVar.f22745c = ((Double) range.getUpper()).doubleValue();
        zzacnVar.f22743a = -9223372036854775807L;
        zzacnVar.f22744b = -9223372036854775807L;
        this.f22703h = zzacnVar;
        this.f22700e = zzdn.f27991a;
    }
}
