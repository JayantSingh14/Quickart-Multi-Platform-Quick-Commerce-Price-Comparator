package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.math.BigInteger;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class zzgh extends zzg {

    /* renamed from: c, reason: collision with root package name */
    public String f38916c;

    /* renamed from: d, reason: collision with root package name */
    public String f38917d;

    /* renamed from: e, reason: collision with root package name */
    public int f38918e;

    /* renamed from: f, reason: collision with root package name */
    public String f38919f;

    /* renamed from: g, reason: collision with root package name */
    public String f38920g;

    /* renamed from: h, reason: collision with root package name */
    public long f38921h;

    /* renamed from: i, reason: collision with root package name */
    public final long f38922i;

    /* renamed from: j, reason: collision with root package name */
    public final long f38923j;

    /* renamed from: k, reason: collision with root package name */
    public List f38924k;

    /* renamed from: l, reason: collision with root package name */
    public String f38925l;

    /* renamed from: m, reason: collision with root package name */
    public int f38926m;
    public String n;
    public String o;
    public long p;
    public String q;

    public zzgh(zzib zzibVar, long j2, long j3) {
        super(zzibVar);
        this.p = 0L;
        this.q = null;
        this.f38922i = j2;
        this.f38923j = j3;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final boolean j() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0253 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x024d  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzr k(java.lang.String r48) throws java.lang.IllegalAccessException, java.security.NoSuchAlgorithmException, java.lang.ClassNotFoundException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 829
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgh.k(java.lang.String):com.google.android.gms.measurement.internal.zzr");
    }

    public final void l() {
        String str;
        g();
        zzib zzibVar = this.f39180a;
        zzhg zzhgVar = zzibVar.f39088e;
        zzib.j(zzhgVar);
        boolean zI = zzhgVar.n().i(zzjj.ANALYTICS_STORAGE);
        zzgt zzgtVar = zzibVar.f39089f;
        if (zI) {
            byte[] bArr = new byte[16];
            zzpo zzpoVar = zzibVar.f39092i;
            zzib.j(zzpoVar);
            zzpoVar.c0().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        } else {
            zzib.l(zzgtVar);
            zzgtVar.f38965m.a("Analytics Storage consent is not granted");
            str = null;
        }
        zzib.l(zzgtVar);
        zzgtVar.f38965m.a("Resetting session stitching token to ".concat(str == null ? "null" : "not null"));
        this.o = str;
        this.p = zzibVar.f39094k.currentTimeMillis();
    }

    public final String m() {
        h();
        Preconditions.checkNotNull(this.f38916c);
        return this.f38916c;
    }

    public final String n() {
        g();
        h();
        Preconditions.checkNotNull(this.n);
        return this.n;
    }
}
