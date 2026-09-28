package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzhjn {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f33893a = new HashMap();

    public final void a(zzhxc zzhxcVar, Object obj) throws GeneralSecurityException {
        List list;
        byte[] bArr = zzhxcVar.f34461a;
        if (bArr.length != 0 && bArr.length != 5) {
            throw new GeneralSecurityException("PrefixMap only supports 0 and 5 byte prefixes");
        }
        HashMap map = this.f33893a;
        if (map.containsKey(zzhxcVar)) {
            list = (List) map.get(zzhxcVar);
        } else {
            ArrayList arrayList = new ArrayList();
            map.put(zzhxcVar, arrayList);
            list = arrayList;
        }
        list.add(obj);
    }
}
