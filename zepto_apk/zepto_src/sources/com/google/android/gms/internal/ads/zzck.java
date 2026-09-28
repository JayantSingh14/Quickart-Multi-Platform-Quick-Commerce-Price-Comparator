package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class zzck {

    /* renamed from: a, reason: collision with root package name */
    public final zzgtd f26458a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f26459b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public ByteBuffer[] f26460c = new ByteBuffer[0];

    /* renamed from: d, reason: collision with root package name */
    public boolean f26461d;

    public zzck(zzgtd zzgtdVar) {
        this.f26458a = zzgtdVar;
        zzcl zzclVar = zzcl.f26484e;
        this.f26461d = false;
    }

    public final zzcl a(zzcl zzclVar) throws zzcn {
        if (zzclVar.equals(zzcl.f26484e)) {
            throw new zzcn("Unhandled input format:", zzclVar);
        }
        int i2 = 0;
        while (true) {
            zzgtd zzgtdVar = this.f26458a;
            if (i2 >= ((zzguy) zzgtdVar).f33234d) {
                return zzclVar;
            }
            zzco zzcoVar = (zzco) ((zzguy) zzgtdVar).get(i2);
            zzcl zzclVarC = zzcoVar.c(zzclVar);
            if (zzcoVar.zzc()) {
                zzgqa.f(!zzclVarC.equals(r0));
                zzclVar = zzclVarC;
            }
            i2++;
        }
    }

    public final void b(zzcm zzcmVar) {
        ArrayList arrayList = this.f26459b;
        arrayList.clear();
        this.f26461d = false;
        long jA = zzcmVar.f26530a;
        int i2 = 0;
        while (true) {
            zzgtd zzgtdVar = this.f26458a;
            if (i2 >= ((zzguy) zzgtdVar).f33234d) {
                break;
            }
            zzco zzcoVar = (zzco) ((zzguy) zzgtdVar).get(i2);
            new zzcm(jA);
            zzcoVar.zzi();
            if (zzcoVar.zzc()) {
                jA = zzcoVar.a(jA);
                zzgqa.f(jA >= 0);
                arrayList.add(zzcoVar);
            }
            i2++;
        }
        this.f26460c = new ByteBuffer[arrayList.size()];
        for (int i3 = 0; i3 <= f(); i3++) {
            this.f26460c[i3] = ((zzco) arrayList.get(i3)).zzf();
        }
    }

    public final boolean c() {
        return !this.f26459b.isEmpty();
    }

    public final boolean d() {
        return this.f26461d && ((zzco) this.f26459b.get(f())).zzg() && !this.f26460c[f()].hasRemaining();
    }

    public final void e(ByteBuffer byteBuffer) {
        boolean z;
        do {
            int i2 = 0;
            z = false;
            while (i2 <= f()) {
                if (!this.f26460c[i2].hasRemaining()) {
                    ArrayList arrayList = this.f26459b;
                    zzco zzcoVar = (zzco) arrayList.get(i2);
                    if (!zzcoVar.zzg()) {
                        ByteBuffer byteBuffer2 = i2 > 0 ? this.f26460c[i2 - 1] : byteBuffer.hasRemaining() ? byteBuffer : zzco.f26781a;
                        long jRemaining = byteBuffer2.remaining();
                        zzcoVar.b(byteBuffer2);
                        this.f26460c[i2] = zzcoVar.zzf();
                        boolean z2 = true;
                        if (jRemaining - byteBuffer2.remaining() <= 0 && !this.f26460c[i2].hasRemaining()) {
                            z2 = false;
                        }
                        z |= z2;
                    } else if (!this.f26460c[i2].hasRemaining() && i2 < f()) {
                        ((zzco) arrayList.get(i2 + 1)).zze();
                    }
                }
                i2++;
            }
        } while (z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzck)) {
            return false;
        }
        zzgtd zzgtdVar = this.f26458a;
        int size = zzgtdVar.size();
        zzgtd zzgtdVar2 = ((zzck) obj).f26458a;
        if (size != zzgtdVar2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < zzgtdVar.size(); i2++) {
            if (zzgtdVar.get(i2) != zzgtdVar2.get(i2)) {
                return false;
            }
        }
        return true;
    }

    public final int f() {
        return this.f26460c.length - 1;
    }

    public final int hashCode() {
        return this.f26458a.hashCode();
    }
}
