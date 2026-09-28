package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzbm {

    /* renamed from: a, reason: collision with root package name */
    public final int f25312a;

    /* renamed from: b, reason: collision with root package name */
    public final zzbg f25313b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f25314c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f25315d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean[] f25316e;

    static {
        String str = zzfj.f31254a;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
    }

    public zzbm(zzbg zzbgVar, boolean z, int[] iArr, boolean[] zArr) {
        int i2 = zzbgVar.f24983a;
        this.f25312a = i2;
        zzgqa.a(i2 == iArr.length && i2 == zArr.length);
        this.f25313b = zzbgVar;
        this.f25314c = z && i2 > 1;
        this.f25315d = (int[]) iArr.clone();
        this.f25316e = (boolean[]) zArr.clone();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzbm.class == obj.getClass()) {
            zzbm zzbmVar = (zzbm) obj;
            if (this.f25314c == zzbmVar.f25314c && this.f25313b.equals(zzbmVar.f25313b) && Arrays.equals(this.f25315d, zzbmVar.f25315d) && Arrays.equals(this.f25316e, zzbmVar.f25316e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f25316e) + ((Arrays.hashCode(this.f25315d) + (((this.f25313b.hashCode() * 31) + (this.f25314c ? 1 : 0)) * 31)) * 31);
    }
}
