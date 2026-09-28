package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzagz implements zzaeo {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f23065a;

    /* renamed from: b, reason: collision with root package name */
    public final zzer f23066b;

    /* renamed from: c, reason: collision with root package name */
    public final zzaev f23067c;

    /* renamed from: d, reason: collision with root package name */
    public zzaer f23068d;

    /* renamed from: e, reason: collision with root package name */
    public zzaga f23069e;

    /* renamed from: f, reason: collision with root package name */
    public int f23070f;

    /* renamed from: g, reason: collision with root package name */
    public zzap f23071g;

    /* renamed from: h, reason: collision with root package name */
    public zzafb f23072h;

    /* renamed from: i, reason: collision with root package name */
    public int f23073i;

    /* renamed from: j, reason: collision with root package name */
    public int f23074j;

    /* renamed from: k, reason: collision with root package name */
    public zzagx f23075k;

    /* renamed from: l, reason: collision with root package name */
    public int f23076l;

    /* renamed from: m, reason: collision with root package name */
    public long f23077m;

    public zzagz() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void a(long j2, long j3) {
        if (j2 == 0) {
            this.f23070f = 0;
        } else {
            zzagx zzagxVar = this.f23075k;
            if (zzagxVar != null) {
                zzagxVar.a(j3);
            }
        }
        this.f23077m = j3 != 0 ? -1L : 0L;
        this.f23076l = 0;
        this.f23066b.y(0);
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void b(zzaer zzaerVar) {
        this.f23068d = zzaerVar;
        zzxk zzxkVar = (zzxk) zzaerVar;
        this.f23069e = zzxkVar.e(0, 1);
        zzxkVar.h();
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final boolean c(zzaep zzaepVar) {
        zzaic zzaicVar = zzaif.f23183a;
        zzap zzapVarA = new zzafi().a((zzaef) zzaepVar, zzaid.f23179a, 0);
        if (zzapVarA != null) {
            int length = zzapVarA.f24032a.length;
        }
        zzer zzerVar = new zzer(4);
        ((zzaef) zzaepVar).t(zzerVar.f30144a, 0, 4, false);
        return zzerVar.P() == 1716281667;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r11v9 com.google.android.gms.internal.ads.zzagx, still in use, count: 2, list:
          (r11v9 com.google.android.gms.internal.ads.zzagx) from 0x0210: MOVE (r39v1 com.google.android.gms.internal.ads.zzagx) = (r11v9 com.google.android.gms.internal.ads.zzagx) (LINE:529)
          (r11v9 com.google.android.gms.internal.ads.zzagx) from 0x01f3: MOVE (r39v3 com.google.android.gms.internal.ads.zzagx) = (r11v9 com.google.android.gms.internal.ads.zzagx) (LINE:500)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:91)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:57)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
        */
    /* JADX WARN: Type inference failed for: r11v10, types: [com.google.android.gms.internal.ads.zzaea, com.google.android.gms.internal.ads.zzagx] */
    @Override // com.google.android.gms.internal.ads.zzaeo
    public final int d(com.google.android.gms.internal.ads.zzaep r39, com.google.android.gms.internal.ads.zzafo r40) {
        /*
            Method dump skipped, instructions count: 1094
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagz.d(com.google.android.gms.internal.ads.zzaep, com.google.android.gms.internal.ads.zzafo):int");
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void zzf() {
    }

    public zzagz(int i2) {
        this.f23065a = new byte[42];
        this.f23066b = new zzer(new byte[32768], 0);
        this.f23067c = new zzaev();
        this.f23070f = 0;
    }
}
