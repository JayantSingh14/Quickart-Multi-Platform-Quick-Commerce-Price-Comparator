package com.google.android.gms.internal.ads;

import java.math.RoundingMode;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
final class zzapz implements zzaqa {

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f24117m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
    public static final int[] n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, WKSRecord.Service.CISCO_FNA, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

    /* renamed from: a, reason: collision with root package name */
    public final zzaer f24118a;

    /* renamed from: b, reason: collision with root package name */
    public final zzaga f24119b;

    /* renamed from: c, reason: collision with root package name */
    public final zzaqe f24120c;

    /* renamed from: d, reason: collision with root package name */
    public final int f24121d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f24122e;

    /* renamed from: f, reason: collision with root package name */
    public final zzer f24123f;

    /* renamed from: g, reason: collision with root package name */
    public final int f24124g;

    /* renamed from: h, reason: collision with root package name */
    public final zzv f24125h;

    /* renamed from: i, reason: collision with root package name */
    public int f24126i;

    /* renamed from: j, reason: collision with root package name */
    public long f24127j;

    /* renamed from: k, reason: collision with root package name */
    public int f24128k;

    /* renamed from: l, reason: collision with root package name */
    public long f24129l;

    public zzapz(zzaer zzaerVar, zzaga zzagaVar, zzaqe zzaqeVar) throws zzat {
        this.f24118a = zzaerVar;
        this.f24119b = zzagaVar;
        this.f24120c = zzaqeVar;
        int i2 = zzaqeVar.f24147b;
        int iMax = Math.max(1, i2 / 10);
        this.f24124g = iMax;
        zzer zzerVar = new zzer(zzaqeVar.f24150e);
        zzerVar.M();
        int iM = zzerVar.M();
        this.f24121d = iM;
        int i3 = zzaqeVar.f24146a;
        int i4 = zzaqeVar.f24148c;
        int iX = android.support.v4.media.a.x(i4 - (i3 * 4), 8, zzaqeVar.f24149d * i3, 1);
        if (iM != iX) {
            throw zzat.a(null, androidx.fragment.app.e.n(iX, iM, "Expected frames per block: ", "; got: ", new StringBuilder(String.valueOf(iX).length() + 34 + String.valueOf(iM).length())));
        }
        String str = zzfj.f31254a;
        int i5 = ((iMax + iM) - 1) / iM;
        this.f24122e = new byte[i5 * i4];
        this.f24123f = new zzer((iM + iM) * i3 * i5);
        int i6 = ((i4 * i2) * 8) / iM;
        zzt zztVar = new zzt();
        zztVar.e("audio/raw");
        zztVar.f35570g = i6;
        zztVar.f35571h = i6;
        zztVar.f35576m = (iMax + iMax) * i3;
        zztVar.D = i3;
        zztVar.E = i2;
        zztVar.F = 2;
        this.f24125h = new zzv(zztVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final void a(long j2) {
        this.f24126i = 0;
        this.f24127j = j2;
        this.f24128k = 0;
        this.f24129l = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final void b(int i2, long j2) {
        this.f24118a.d(new zzaqh(this.f24120c, this.f24121d, i2, j2));
        this.f24119b.c(this.f24125h);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0046 A[ADDED_TO_REGION, EDGE_INSN: B:43:0x0046->B:14:0x0046 BREAK  A[LOOP:0: B:6:0x0025->B:13:0x0040], REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x003d -> B:4:0x0022). Please report as a decompilation issue!!! */
    @Override // com.google.android.gms.internal.ads.zzaqa
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(com.google.android.gms.internal.ads.zzaef r25, long r26) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzapz.c(com.google.android.gms.internal.ads.zzaef, long):boolean");
    }

    public final void d(int i2) {
        zzaqe zzaqeVar = this.f24120c;
        long jU = this.f24127j + zzfj.u(this.f24129l, 1000000L, zzaqeVar.f24147b, RoundingMode.DOWN);
        int i3 = (i2 + i2) * zzaqeVar.f24146a;
        this.f24119b.e(jU, 1, i3, this.f24128k - i3, null);
        this.f24129l += i2;
        this.f24128k -= i3;
    }
}
