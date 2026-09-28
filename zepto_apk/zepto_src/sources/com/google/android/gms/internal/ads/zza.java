package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zza {

    /* renamed from: a, reason: collision with root package name */
    public final int f22569a;

    /* renamed from: b, reason: collision with root package name */
    public final Uri[] f22570b;

    /* renamed from: c, reason: collision with root package name */
    public final zzak[] f22571c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f22572d;

    /* renamed from: e, reason: collision with root package name */
    public final long[] f22573e;

    /* renamed from: f, reason: collision with root package name */
    public final String[] f22574f;

    /* renamed from: g, reason: collision with root package name */
    public final zzb[] f22575g;

    static {
        String str = zzfj.f31254a;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
        Integer.toString(8, 36);
        Integer.toString(9, 36);
        Integer.toString(10, 36);
        Integer.toString(11, 36);
    }

    public zza(int i2, int[] iArr, zzak[] zzakVarArr, long[] jArr, String[] strArr, zzb[] zzbVarArr) {
        Uri uri;
        int length = iArr.length;
        int length2 = zzakVarArr.length;
        int i3 = 0;
        zzgqa.a(length == length2);
        zzgqa.a(length == zzbVarArr.length);
        this.f22569a = i2;
        this.f22572d = iArr;
        this.f22571c = zzakVarArr;
        this.f22573e = jArr;
        this.f22570b = new Uri[length2];
        while (true) {
            Uri[] uriArr = this.f22570b;
            if (i3 >= uriArr.length) {
                this.f22574f = strArr;
                this.f22575g = zzbVarArr;
                return;
            }
            zzak zzakVar = zzakVarArr[i3];
            if (zzakVar == null) {
                uri = null;
            } else {
                zzag zzagVar = zzakVar.f23332b;
                zzagVar.getClass();
                uri = zzagVar.f22978a;
            }
            uriArr[i3] = uri;
            i3++;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zza.class == obj.getClass()) {
            zza zzaVar = (zza) obj;
            if (this.f22569a == zzaVar.f22569a && Arrays.equals(this.f22571c, zzaVar.f22571c) && Arrays.equals(this.f22572d, zzaVar.f22572d) && Arrays.equals(this.f22573e, zzaVar.f22573e) && Arrays.equals(this.f22574f, zzaVar.f22574f) && Arrays.equals(this.f22575g, zzaVar.f22575g)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Arrays.hashCode(this.f22575g) + ((((Arrays.hashCode(this.f22573e) + ((Arrays.hashCode(this.f22572d) + ((Arrays.hashCode(this.f22571c) + (((this.f22569a * 31) - 1) * 961)) * 31)) * 31)) * 29791) + Arrays.hashCode(this.f22574f)) * 31)) * 31;
    }
}
