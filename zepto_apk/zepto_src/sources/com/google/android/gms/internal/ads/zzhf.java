package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzhf {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f33690f = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Uri f33691a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f33692b;

    /* renamed from: c, reason: collision with root package name */
    public final long f33693c;

    /* renamed from: d, reason: collision with root package name */
    public final long f33694d;

    /* renamed from: e, reason: collision with root package name */
    public final int f33695e;

    static {
        zzal.a("media3.datasource");
    }

    public zzhf(Uri uri, long j2, long j3) {
        this(uri, Collections.EMPTY_MAP, j2, j3, 0);
    }

    public final String toString() {
        String string = this.f33691a.toString();
        int length = string.length();
        long j2 = this.f33693c;
        int length2 = String.valueOf(j2).length();
        long j3 = this.f33694d;
        int length3 = String.valueOf(j3).length();
        int i2 = this.f33695e;
        StringBuilder sb = new StringBuilder(length + 15 + length2 + 2 + length3 + 8 + String.valueOf(i2).length() + 1);
        android.support.v4.media.a.u(sb, "DataSpec[GET ", string, ", ");
        sb.append(j2);
        androidx.fragment.app.e.A(sb, ", ", j3, ", null, ");
        return android.support.v4.media.b.o(sb, i2, "]");
    }

    public zzhf(Uri uri, Map map, long j2, long j3, int i2) {
        boolean z = false;
        boolean z2 = j2 >= 0;
        zzgqa.a(z2);
        zzgqa.a(z2);
        if (j3 > 0) {
            z = true;
        } else if (j3 == -1) {
            j3 = -1;
            z = true;
        }
        zzgqa.a(z);
        uri.getClass();
        this.f33691a = uri;
        this.f33692b = Collections.unmodifiableMap(new HashMap(map));
        this.f33693c = j2;
        this.f33694d = j3;
        this.f33695e = i2;
    }
}
