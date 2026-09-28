package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.support.v4.media.b;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class zzbb {

    /* renamed from: a, reason: collision with root package name */
    public final String f38750a;

    /* renamed from: b, reason: collision with root package name */
    public final String f38751b;

    /* renamed from: c, reason: collision with root package name */
    public final String f38752c;

    /* renamed from: d, reason: collision with root package name */
    public final long f38753d;

    /* renamed from: e, reason: collision with root package name */
    public final long f38754e;

    /* renamed from: f, reason: collision with root package name */
    public final zzbe f38755f;

    public zzbb(zzib zzibVar, String str, String str2, String str3, long j2, long j3, Bundle bundle) {
        zzbe zzbeVar;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.f38750a = str2;
        this.f38751b = str3;
        this.f38752c = true == TextUtils.isEmpty(str) ? null : str;
        this.f38753d = j2;
        this.f38754e = j3;
        if (j3 != 0 && j3 > j2) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38961i.b(zzgt.o(str2), "Event created with reverse previous/current timestamps. appId");
        }
        if (bundle == null || bundle.isEmpty()) {
            zzbeVar = new zzbe(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    zzgt zzgtVar2 = zzibVar.f39089f;
                    zzib.l(zzgtVar2);
                    zzgtVar2.f38958f.a("Param name can't be null");
                    it.remove();
                } else {
                    zzpo zzpoVar = zzibVar.f39092i;
                    zzib.j(zzpoVar);
                    Object objN = zzpoVar.n(bundle2.get(next), next);
                    if (objN == null) {
                        zzgt zzgtVar3 = zzibVar.f39089f;
                        zzib.l(zzgtVar3);
                        zzgtVar3.f38961i.b(zzibVar.f39093j.b(next), "Param value can't be null");
                        it.remove();
                    } else {
                        zzpo zzpoVar2 = zzibVar.f39092i;
                        zzib.j(zzpoVar2);
                        zzpoVar2.v(bundle2, next, objN);
                    }
                }
            }
            zzbeVar = new zzbe(bundle2);
        }
        this.f38755f = zzbeVar;
    }

    public final zzbb a(zzib zzibVar, long j2) {
        return new zzbb(zzibVar, this.f38752c, this.f38750a, this.f38751b, this.f38753d, j2, this.f38755f);
    }

    public final String toString() {
        String string = this.f38755f.toString();
        String str = this.f38750a;
        int length = String.valueOf(str).length();
        String str2 = this.f38751b;
        StringBuilder sb = new StringBuilder(length + 22 + String.valueOf(str2).length() + 10 + string.length() + 1);
        b.B(sb, "Event{appId='", str, "', name='", str2);
        return b.s(sb, "', params=", string, "}");
    }

    public zzbb(zzib zzibVar, String str, String str2, String str3, long j2, long j3, zzbe zzbeVar) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzbeVar);
        this.f38750a = str2;
        this.f38751b = str3;
        this.f38752c = true == TextUtils.isEmpty(str) ? null : str;
        this.f38753d = j2;
        this.f38754e = j3;
        if (j3 != 0 && j3 > j2) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38961i.c("Event created with reverse previous/current timestamps. appId, name", zzgt.o(str2), zzgt.o(str3));
        }
        this.f38755f = zzbeVar;
    }
}
