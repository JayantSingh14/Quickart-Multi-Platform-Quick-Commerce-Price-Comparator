package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public final class zzcbt implements zzbck {

    /* renamed from: a, reason: collision with root package name */
    public final Context f25856a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f25857b;

    /* renamed from: c, reason: collision with root package name */
    public final String f25858c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f25859d;

    public zzcbt(Context context, String str) {
        this.f25856a = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.f25858c = str;
        this.f25859d = false;
        this.f25857b = new Object();
    }

    public final void a(boolean z) {
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        zzcbw zzcbwVar = zztVar.y;
        Context context = this.f25856a;
        if (zzcbwVar.a(context)) {
            synchronized (this.f25857b) {
                try {
                    if (this.f25859d == z) {
                        return;
                    }
                    this.f25859d = z;
                    String str = this.f25858c;
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    if (this.f25859d) {
                        zzcbw zzcbwVar2 = zztVar.y;
                        if (zzcbwVar2.a(context)) {
                            zzcbwVar2.j(context, str, "beginAdUnitExposure");
                        }
                    } else {
                        zzcbw zzcbwVar3 = zztVar.y;
                        if (zzcbwVar3.a(context)) {
                            zzcbwVar3.j(context, str, "endAdUnitExposure");
                        }
                    }
                } finally {
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbck
    public final void u0(zzbcj zzbcjVar) {
        a(zzbcjVar.f24707j);
    }
}
