package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes4.dex */
public final class zzabd {

    /* renamed from: g, reason: collision with root package name */
    public static final Comparator f22632g = null;

    /* renamed from: h, reason: collision with root package name */
    public static final Comparator f22633h = null;

    /* renamed from: d, reason: collision with root package name */
    public int f22637d;

    /* renamed from: e, reason: collision with root package name */
    public int f22638e;

    /* renamed from: f, reason: collision with root package name */
    public int f22639f;

    /* renamed from: b, reason: collision with root package name */
    public final zzaba[] f22635b = new zzaba[5];

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f22634a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public int f22636c = -1;

    public final void a(float f2, int i2) {
        zzaba zzabaVar;
        int i3 = this.f22636c;
        ArrayList arrayList = this.f22634a;
        if (i3 != 1) {
            Collections.sort(arrayList, zzabc.f22631a);
            this.f22636c = 1;
        }
        int i4 = this.f22639f;
        zzaba[] zzabaVarArr = this.f22635b;
        if (i4 > 0) {
            int i5 = i4 - 1;
            this.f22639f = i5;
            zzabaVar = zzabaVarArr[i5];
        } else {
            zzabaVar = new zzaba();
        }
        int i6 = this.f22637d;
        this.f22637d = i6 + 1;
        zzabaVar.f22627a = i6;
        zzabaVar.f22628b = i2;
        zzabaVar.f22629c = f2;
        arrayList.add(zzabaVar);
        this.f22638e += i2;
        while (true) {
            int i7 = this.f22638e;
            if (i7 <= 2000) {
                return;
            }
            int i8 = i7 - 2000;
            zzaba zzabaVar2 = (zzaba) arrayList.get(0);
            int i9 = zzabaVar2.f22628b;
            if (i9 <= i8) {
                this.f22638e -= i9;
                arrayList.remove(0);
                int i10 = this.f22639f;
                if (i10 < 5) {
                    this.f22639f = i10 + 1;
                    zzabaVarArr[i10] = zzabaVar2;
                }
            } else {
                zzabaVar2.f22628b = i9 - i8;
                this.f22638e -= i8;
            }
        }
    }

    public final float b() {
        int i2 = this.f22636c;
        ArrayList arrayList = this.f22634a;
        if (i2 != 0) {
            Collections.sort(arrayList, zzabb.f22630a);
            this.f22636c = 0;
        }
        float f2 = this.f22638e;
        int i3 = 0;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            float f3 = 0.5f * f2;
            zzaba zzabaVar = (zzaba) arrayList.get(i4);
            i3 += zzabaVar.f22628b;
            if (i3 >= f3) {
                return zzabaVar.f22629c;
            }
        }
        if (arrayList.isEmpty()) {
            return Float.NaN;
        }
        return ((zzaba) arrayList.get(arrayList.size() - 1)).f22629c;
    }
}
