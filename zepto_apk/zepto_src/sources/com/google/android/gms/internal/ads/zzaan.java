package com.google.android.gms.internal.ads;

import java.util.Arrays;
import org.xbill.DNS.Message;

/* loaded from: classes4.dex */
public final class zzaan implements zzaah {

    /* renamed from: a, reason: collision with root package name */
    public int f22592a;

    /* renamed from: b, reason: collision with root package name */
    public int f22593b;

    /* renamed from: c, reason: collision with root package name */
    public int f22594c = 0;

    /* renamed from: d, reason: collision with root package name */
    public zzaaf[] f22595d = new zzaaf[100];

    @Override // com.google.android.gms.internal.ads.zzaah
    public final synchronized void a(zzaag zzaagVar) {
        while (zzaagVar != null) {
            try {
                zzaaf[] zzaafVarArr = this.f22595d;
                int i2 = this.f22594c;
                this.f22594c = i2 + 1;
                zzaafVarArr[i2] = zzaagVar.zzd();
                this.f22593b--;
                zzaagVar = zzaagVar.zze();
            } catch (Throwable th) {
                throw th;
            }
        }
        notifyAll();
    }

    @Override // com.google.android.gms.internal.ads.zzaah
    public final synchronized void b(zzaaf zzaafVar) {
        zzaaf[] zzaafVarArr = this.f22595d;
        int i2 = this.f22594c;
        this.f22594c = i2 + 1;
        zzaafVarArr[i2] = zzaafVar;
        this.f22593b--;
        notifyAll();
    }

    public final synchronized void c(int i2) {
        int i3 = this.f22592a;
        this.f22592a = i2;
        if (i2 < i3) {
            zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaah
    public final synchronized zzaaf zza() {
        zzaaf zzaafVar;
        try {
            int i2 = this.f22593b + 1;
            this.f22593b = i2;
            int i3 = this.f22594c;
            if (i3 > 0) {
                zzaaf[] zzaafVarArr = this.f22595d;
                int i4 = i3 - 1;
                this.f22594c = i4;
                zzaafVar = zzaafVarArr[i4];
                if (zzaafVar == null) {
                    throw null;
                }
                zzaafVarArr[i4] = null;
            } else {
                zzaafVar = new zzaaf(new byte[65536]);
                zzaaf[] zzaafVarArr2 = this.f22595d;
                int length = zzaafVarArr2.length;
                if (i2 > length) {
                    this.f22595d = (zzaaf[]) Arrays.copyOf(zzaafVarArr2, length + length);
                    return zzaafVar;
                }
            }
            return zzaafVar;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaah
    public final synchronized void zzd() {
        int i2 = this.f22592a;
        String str = zzfj.f31254a;
        int iMax = Math.max(0, ((i2 + Message.MAXLENGTH) / 65536) - this.f22593b);
        int i3 = this.f22594c;
        if (iMax >= i3) {
            return;
        }
        Arrays.fill(this.f22595d, iMax, i3, (Object) null);
        this.f22594c = iMax;
    }
}
