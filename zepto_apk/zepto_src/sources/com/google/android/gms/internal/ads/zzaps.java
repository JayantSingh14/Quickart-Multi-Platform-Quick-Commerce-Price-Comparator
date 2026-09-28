package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzaps {

    /* renamed from: a, reason: collision with root package name */
    public final int f24105a;

    /* renamed from: b, reason: collision with root package name */
    public final List f24106b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f24107c;

    public zzaps(int i2, String str, int i3, ArrayList arrayList, byte[] bArr) {
        this.f24105a = i3;
        this.f24106b = arrayList == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(arrayList);
        this.f24107c = bArr;
    }

    public final int a() {
        int i2 = this.f24105a;
        if (i2 != 2) {
            return i2 != 3 ? 0 : 512;
        }
        return 2048;
    }
}
