package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzhhs {

    /* renamed from: a, reason: collision with root package name */
    public final Map f33833a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f33834b;

    public /* synthetic */ zzhhs(Map map, Map map2) {
        this.f33833a = map;
        this.f33834b = map2;
    }

    public final Enum a(Object obj) throws GeneralSecurityException {
        Enum r0 = (Enum) this.f33834b.get(obj);
        if (r0 != null) {
            return r0;
        }
        throw new GeneralSecurityException("Unable to convert object enum: ".concat(String.valueOf(obj)));
    }

    public final Object b(Enum r3) throws GeneralSecurityException {
        Object obj = this.f33833a.get(r3);
        if (obj != null) {
            return obj;
        }
        throw new GeneralSecurityException("Unable to convert proto enum: ".concat(String.valueOf(r3)));
    }
}
