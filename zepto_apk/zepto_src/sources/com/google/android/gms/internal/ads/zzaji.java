package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;

/* loaded from: classes4.dex */
public final class zzaji implements zzaeo {
    public static final /* synthetic */ int q = 0;

    /* renamed from: a, reason: collision with root package name */
    public final zzer f23269a;

    /* renamed from: b, reason: collision with root package name */
    public final zzafk f23270b;

    /* renamed from: c, reason: collision with root package name */
    public final zzafg f23271c;

    /* renamed from: d, reason: collision with root package name */
    public final zzafi f23272d;

    /* renamed from: e, reason: collision with root package name */
    public zzaer f23273e;

    /* renamed from: f, reason: collision with root package name */
    public zzaga f23274f;

    /* renamed from: g, reason: collision with root package name */
    public zzaga f23275g;

    /* renamed from: h, reason: collision with root package name */
    public int f23276h;

    /* renamed from: i, reason: collision with root package name */
    public zzap f23277i;

    /* renamed from: j, reason: collision with root package name */
    public long f23278j;

    /* renamed from: k, reason: collision with root package name */
    public long f23279k;

    /* renamed from: l, reason: collision with root package name */
    public long f23280l;

    /* renamed from: m, reason: collision with root package name */
    public long f23281m;
    public int n;
    public zzajk o;
    public boolean p;

    public zzaji() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void a(long j2, long j3) {
        this.f23276h = 0;
        this.f23278j = -9223372036854775807L;
        this.f23279k = 0L;
        this.n = 0;
        this.f23281m = -1L;
        if (this.o instanceof zzaje) {
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void b(zzaer zzaerVar) {
        this.f23273e = zzaerVar;
        zzaga zzagaVarE = ((zzxk) zzaerVar).e(0, 1);
        this.f23274f = zzagaVarE;
        this.f23275g = zzagaVarE;
        ((zzxk) this.f23273e).h();
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final boolean c(zzaep zzaepVar) {
        return e((zzaef) zzaepVar, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0475  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0497  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x04ee A[PHI: r3
      0x04ee: PHI (r3v1 int) = (r3v0 int), (r3v17 int) binds: [B:185:0x0495, B:199:0x04ed] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x050f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0031  */
    @Override // com.google.android.gms.internal.ads.zzaeo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int d(com.google.android.gms.internal.ads.zzaep r46, com.google.android.gms.internal.ads.zzafo r47) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaji.d(com.google.android.gms.internal.ads.zzaep, com.google.android.gms.internal.ads.zzafo):int");
    }

    public final boolean e(zzaef zzaefVar, boolean z) throws EOFException, InterruptedIOException {
        int iZzm;
        int i2;
        int iA;
        zzaefVar.f22874f = 0;
        long j2 = zzaefVar.f22872d;
        int i3 = true != z ? 131072 : 32768;
        if (j2 == 0) {
            zzap zzapVarA = this.f23272d.a(zzaefVar, null, i3);
            this.f23277i = zzapVarA;
            if (zzapVarA != null) {
                this.f23271c.a(zzapVarA);
            }
            iZzm = (int) zzaefVar.zzm();
            if (!z) {
                zzaefVar.d(iZzm, false);
            }
            i2 = 0;
        } else {
            iZzm = 0;
            i2 = 0;
        }
        int i4 = i2;
        int i5 = i4;
        while (true) {
            if (!f(zzaefVar)) {
                zzer zzerVar = this.f23269a;
                zzerVar.E(0);
                int iB = zzerVar.b();
                if ((i2 == 0 || ((-128000) & iB) == (i2 & (-128000))) && (iA = zzafl.a(iB)) != -1) {
                    i4++;
                    if (i4 != 1) {
                        if (i4 == 4) {
                            break;
                        }
                    } else {
                        this.f23270b.a(iB);
                        i2 = iB;
                    }
                    zzaefVar.f(iA - 4, false);
                } else {
                    int i6 = i5 + 1;
                    if (i5 == i3) {
                        if (z) {
                            return false;
                        }
                        g();
                        throw new EOFException();
                    }
                    if (z) {
                        zzaefVar.f22874f = 0;
                        zzaefVar.f(iZzm + i6, false);
                    } else {
                        zzaefVar.d(1, false);
                    }
                    i4 = 0;
                    i5 = i6;
                    i2 = 0;
                }
            } else if (i4 <= 0) {
                g();
                throw new EOFException();
            }
        }
        if (z) {
            zzaefVar.d(iZzm + i5, false);
        } else {
            zzaefVar.f22874f = 0;
        }
        this.f23276h = i2;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f(com.google.android.gms.internal.ads.zzaef r9) {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzajk r0 = r8.o
            r1 = 1
            if (r0 == 0) goto L1a
            long r2 = r0.zzf()
            r4 = -1
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L1a
            long r4 = r9.zzm()
            r6 = -4
            long r2 = r2 + r6
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 > 0) goto L28
        L1a:
            com.google.android.gms.internal.ads.zzer r0 = r8.f23269a     // Catch: java.io.EOFException -> L28
            byte[] r0 = r0.f30144a     // Catch: java.io.EOFException -> L28
            r2 = 4
            r3 = 0
            boolean r9 = r9.t(r0, r3, r2, r1)     // Catch: java.io.EOFException -> L28
            if (r9 != 0) goto L27
            goto L28
        L27:
            return r3
        L28:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaji.f(com.google.android.gms.internal.ads.zzaef):boolean");
    }

    public final void g() {
        Object obj = this.o;
        if ((obj instanceof zzajd) && ((zzaee) obj).zzb()) {
            long j2 = this.f23281m;
            if (j2 == -1 || j2 == this.o.zzf()) {
                return;
            }
            zzajd zzajdVar = (zzajd) this.o;
            this.o = new zzajd(zzajdVar.f23261h, zzajdVar.f23262i, this.f23281m, zzajdVar.f23260g);
            zzaer zzaerVar = this.f23273e;
            zzaerVar.getClass();
            ((zzxk) zzaerVar).d(this.o);
            this.f23274f.getClass();
            this.o.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void zzf() {
    }

    public zzaji(int i2) {
        this.f23269a = new zzer(10);
        this.f23270b = new zzafk();
        this.f23271c = new zzafg();
        this.f23278j = -9223372036854775807L;
        this.f23272d = new zzafi();
        this.f23275g = new zzael();
        this.f23281m = -1L;
    }
}
