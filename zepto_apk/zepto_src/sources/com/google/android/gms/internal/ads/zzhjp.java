package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzhjp {

    /* renamed from: b, reason: collision with root package name */
    public static final zzhxc f33896b = zzhxc.a(new byte[0]);

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f33897a;

    public final Iterable a(byte[] bArr) {
        List list;
        HashMap map = this.f33897a;
        List list2 = (List) map.get(f33896b);
        if (bArr.length >= 5) {
            int length = bArr.length;
            list = (List) map.get(new zzhxc(bArr, 5 > length ? length : 5));
        } else {
            list = null;
        }
        return (list2 == null && list == null) ? new ArrayList() : list2 == null ? list : list == null ? list2 : new zzhjm(this, list, list2);
    }
}
