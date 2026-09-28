package com.google.android.gms.internal.ads;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzbjg extends zzbjq {

    /* renamed from: i, reason: collision with root package name */
    public static final int f25231i;

    /* renamed from: j, reason: collision with root package name */
    public static final int f25232j;

    /* renamed from: a, reason: collision with root package name */
    public final String f25233a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f25234b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f25235c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final int f25236d;

    /* renamed from: e, reason: collision with root package name */
    public final int f25237e;

    /* renamed from: f, reason: collision with root package name */
    public final int f25238f;

    /* renamed from: g, reason: collision with root package name */
    public final int f25239g;

    /* renamed from: h, reason: collision with root package name */
    public final int f25240h;

    static {
        int iRgb = Color.rgb(12, 174, 206);
        f25231i = Color.rgb(204, 204, 204);
        f25232j = iRgb;
    }

    public zzbjg(String str, List list, Integer num, Integer num2, Integer num3, int i2, int i3) {
        this.f25233a = str;
        for (int i4 = 0; i4 < list.size(); i4++) {
            zzbjj zzbjjVar = (zzbjj) list.get(i4);
            this.f25234b.add(zzbjjVar);
            this.f25235c.add(zzbjjVar);
        }
        this.f25236d = num != null ? num.intValue() : f25231i;
        this.f25237e = num2 != null ? num2.intValue() : f25232j;
        this.f25238f = num3 != null ? num3.intValue() : 12;
        this.f25239g = i2;
        this.f25240h = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzbjr
    public final String zzb() {
        return this.f25233a;
    }

    @Override // com.google.android.gms.internal.ads.zzbjr
    public final ArrayList zzc() {
        return this.f25235c;
    }
}
