package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import javax.crypto.Mac;

/* loaded from: classes4.dex */
final class zzym extends ThreadLocal {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzyn f38154a;

    public zzym(zzyn zzynVar) {
        this.f38154a = zzynVar;
    }

    @Override // java.lang.ThreadLocal
    public final Object initialValue() throws InvalidKeyException {
        zzyn zzynVar = this.f38154a;
        try {
            Mac mac = (Mac) zzxz.f38142f.a(zzynVar.f38156b);
            mac.init(zzynVar.f38157c);
            return mac;
        } catch (GeneralSecurityException e2) {
            throw new IllegalStateException(e2);
        }
    }
}
