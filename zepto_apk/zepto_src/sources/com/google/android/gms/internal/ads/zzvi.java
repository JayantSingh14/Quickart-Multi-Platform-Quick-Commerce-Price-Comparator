package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzvi implements zzwz {

    /* renamed from: a, reason: collision with root package name */
    public final zzaeu f35704a;

    /* renamed from: b, reason: collision with root package name */
    public zzaeo f35705b;

    /* renamed from: c, reason: collision with root package name */
    public zzaef f35706c;

    public zzvi(zzaeu zzaeuVar) {
        this.f35704a = zzaeuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void a(long j2, long j3) {
        zzaeo zzaeoVar = this.f35705b;
        zzaeoVar.getClass();
        zzaeoVar.a(j2, j3);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void b(zzhb zzhbVar, Uri uri, Map map, long j2, long j3, zzaer zzaerVar) throws zzyi {
        boolean z;
        boolean z2 = true;
        zzaef zzaefVar = new zzaef(zzhbVar, j2, j3);
        this.f35706c = zzaefVar;
        if (this.f35705b != null) {
            return;
        }
        zzaeo[] zzaeoVarArrA = this.f35704a.a(uri, map);
        int length = zzaeoVarArrA.length;
        zzgvs zzgvsVar = zzgtd.f33183b;
        zzgrz.b(length, "expectedSize");
        zzgta zzgtaVar = new zzgta(length);
        if (length == 1) {
            this.f35705b = zzaeoVarArrA[0];
        } else {
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                zzaeo zzaeoVar = zzaeoVarArrA[i2];
                try {
                } catch (EOFException unused) {
                    z = this.f35705b != null || zzaefVar.f22872d == j2;
                } catch (Throwable th) {
                    if (this.f35705b == null && zzaefVar.f22872d != j2) {
                        z2 = false;
                    }
                    zzgqa.f(z2);
                    zzaefVar.f22874f = 0;
                    throw th;
                }
                if (zzaeoVar.c(zzaefVar)) {
                    this.f35705b = zzaeoVar;
                    zzaefVar.f22874f = 0;
                    break;
                } else {
                    zzgtaVar.d(zzaeoVar.zzb());
                    z = this.f35705b != null || zzaefVar.f22872d == j2;
                    zzgqa.f(z);
                    zzaefVar.f22874f = 0;
                    i2++;
                }
            }
            if (this.f35705b == null) {
                Iterator it = zzgud.b(zzgtd.s(zzaeoVarArrA), zzvh.f35703a).iterator();
                StringBuilder sb = new StringBuilder();
                zzgpu.a(sb, it, ", ");
                String string = sb.toString();
                throw new zzyi(android.support.v4.media.b.s(new StringBuilder(string.length() + 58), "None of the available extractors (", string, ") could read the stream."), zzgtaVar.f());
            }
        }
        this.f35705b.b(zzaerVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final int c(zzafo zzafoVar) {
        zzaef zzaefVar;
        zzaeo zzaeoVar = this.f35705b;
        if (zzaeoVar == null || (zzaefVar = this.f35706c) == null) {
            throw null;
        }
        return zzaeoVar.d(zzaefVar, zzafoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void zzb() {
        zzaeo zzaeoVar = this.f35705b;
        if (zzaeoVar != null) {
            zzaeoVar.zzf();
            this.f35705b = null;
        }
        this.f35706c = null;
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void zzc() {
        zzaeo zzaeoVar = this.f35705b;
        if (zzaeoVar != null && (zzaeoVar instanceof zzaji)) {
            ((zzaji) zzaeoVar).p = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final long zzd() {
        zzaef zzaefVar = this.f35706c;
        if (zzaefVar != null) {
            return zzaefVar.f22872d;
        }
        return -1L;
    }
}
