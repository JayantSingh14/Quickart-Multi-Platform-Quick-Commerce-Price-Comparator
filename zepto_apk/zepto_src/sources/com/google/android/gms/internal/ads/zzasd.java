package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@VisibleForTesting
/* loaded from: classes4.dex */
final class zzasd {

    /* renamed from: a, reason: collision with root package name */
    public long f24261a;

    /* renamed from: b, reason: collision with root package name */
    public final String f24262b;

    /* renamed from: c, reason: collision with root package name */
    public final String f24263c;

    /* renamed from: d, reason: collision with root package name */
    public final long f24264d;

    /* renamed from: e, reason: collision with root package name */
    public final long f24265e;

    /* renamed from: f, reason: collision with root package name */
    public final long f24266f;

    /* renamed from: g, reason: collision with root package name */
    public final long f24267g;

    /* renamed from: h, reason: collision with root package name */
    public final List f24268h;

    public zzasd(String str, String str2, long j2, long j3, long j4, long j5, List list) {
        this.f24262b = str;
        this.f24263c = true == "".equals(str2) ? null : str2;
        this.f24264d = j2;
        this.f24265e = j3;
        this.f24266f = j4;
        this.f24267g = j5;
        this.f24268h = list;
    }

    public static zzasd a(zzase zzaseVar) throws IOException {
        if (zzasg.g(zzaseVar) != 538247942) {
            throw new IOException();
        }
        String strK = zzasg.k(zzaseVar);
        String strK2 = zzasg.k(zzaseVar);
        long jI = zzasg.i(zzaseVar);
        long jI2 = zzasg.i(zzaseVar);
        long jI3 = zzasg.i(zzaseVar);
        long jI4 = zzasg.i(zzaseVar);
        int iG = zzasg.g(zzaseVar);
        if (iG < 0) {
            throw new IOException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(iG).length() + 20), iG, "readHeaderList size="));
        }
        List arrayList = iG == 0 ? Collections.EMPTY_LIST : new ArrayList();
        for (int i2 = 0; i2 < iG; i2++) {
            arrayList.add(new zzarc(zzasg.k(zzaseVar).intern(), zzasg.k(zzaseVar).intern()));
        }
        return new zzasd(strK, strK2, jI, jI2, jI3, jI4, arrayList);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v2 */
    public zzasd(String str, zzaqt zzaqtVar) {
        String str2 = zzaqtVar.f24174b;
        long j2 = zzaqtVar.f24175c;
        long j3 = zzaqtVar.f24176d;
        long j4 = zzaqtVar.f24177e;
        long j5 = zzaqtVar.f24178f;
        List arrayList = zzaqtVar.f24180h;
        if (arrayList == 0) {
            Map map = zzaqtVar.f24179g;
            arrayList = new ArrayList(map.size());
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(new zzarc((String) entry.getKey(), (String) entry.getValue()));
            }
        }
        this(str, str2, j2, j3, j4, j5, arrayList);
    }
}
