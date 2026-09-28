package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Optional;

/* loaded from: classes4.dex */
public final class zzaun {

    /* renamed from: a, reason: collision with root package name */
    public final zzati f24397a;

    /* renamed from: b, reason: collision with root package name */
    public final zzauj f24398b;

    /* renamed from: c, reason: collision with root package name */
    public final zzaug f24399c = new zzaug();

    /* renamed from: d, reason: collision with root package name */
    public final zzaub f24400d;

    public zzaun(zzati zzatiVar, zzauj zzaujVar, zzaub zzaubVar) {
        this.f24397a = zzatiVar;
        this.f24398b = zzaujVar;
        this.f24400d = zzaubVar;
    }

    public final Optional a() {
        zzatc zzatcVar;
        try {
            ArrayDeque arrayDeque = this.f24399c.f24393a;
            if (arrayDeque.isEmpty()) {
                throw new zzauf();
            }
            zzaud zzaudVar = (zzaud) arrayDeque.pop();
            long j2 = zzaudVar.f24390a;
            long j3 = zzaudVar.f24391b;
            long j4 = zzaudVar.f24392c;
            zzauj zzaujVar = this.f24398b;
            if (zzaujVar.f24395b < j3) {
                return Optional.of(zzatc.H);
            }
            this.f24400d.a(j2);
            if (j4 == 0) {
                while (zzaujVar.f24395b > j3) {
                    zzaujVar.c();
                }
            }
            return Optional.empty();
        } catch (zzatz e2) {
            e = e2;
            throw new AssertionError(zzatu.a("CEiv6BFfPnitUE+D"), e);
        } catch (zzaua e3) {
            e = e3;
            throw new AssertionError(zzatu.a("CEiv6BFfPnitUE+D"), e);
        } catch (zzauf unused) {
            zzatcVar = zzatc.x;
            return Optional.of(zzatcVar);
        } catch (zzauh unused2) {
            zzatcVar = zzatc.H;
            return Optional.of(zzatcVar);
        }
    }
}
