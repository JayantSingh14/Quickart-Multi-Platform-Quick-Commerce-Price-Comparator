package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Objects;
import javax.crypto.Mac;

/* loaded from: classes4.dex */
final class zzhwq extends ThreadLocal {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzhwr f34427a;

    public zzhwq(zzhwr zzhwrVar) {
        Objects.requireNonNull(zzhwrVar);
        this.f34427a = zzhwrVar;
    }

    @Override // java.lang.ThreadLocal
    public final Object initialValue() throws InvalidKeyException {
        try {
            zzhwc zzhwcVar = zzhwc.f34415c;
            zzhwr zzhwrVar = this.f34427a;
            Mac mac = (Mac) zzhwcVar.f34420a.a(zzhwrVar.f34429b);
            mac.init(zzhwrVar.f34430c);
            return mac;
        } catch (GeneralSecurityException e2) {
            throw new IllegalStateException(e2);
        }
    }
}
