package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;

/* loaded from: classes4.dex */
public final class zzhrh {

    /* renamed from: a, reason: collision with root package name */
    public zzhre f34103a = null;

    /* renamed from: b, reason: collision with root package name */
    public ECPoint f34104b = null;

    /* renamed from: c, reason: collision with root package name */
    public Integer f34105c = null;

    public final zzhri a() throws GeneralSecurityException {
        zzhxc zzhxcVarA;
        zzhre zzhreVar = this.f34103a;
        if (zzhreVar == null) {
            throw new GeneralSecurityException("Cannot build without parameters");
        }
        ECPoint eCPoint = this.f34104b;
        if (eCPoint == null) {
            throw new GeneralSecurityException("Cannot build without public point");
        }
        zzhhq.a(eCPoint, zzhreVar.f34096b.f34082b.getCurve());
        if (this.f34103a.a() && this.f34105c == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.f34103a.a() && this.f34105c != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        zzhrd zzhrdVar = this.f34103a.f34098d;
        if (zzhrdVar == zzhrd.f34093e) {
            zzhxcVarA = zzhjf.f33886a;
        } else if (zzhrdVar == zzhrd.f34092d || zzhrdVar == zzhrd.f34091c) {
            zzhxcVarA = zzhjf.a(this.f34105c.intValue());
        } else {
            if (zzhrdVar != zzhrd.f34090b) {
                throw new IllegalStateException("Unknown EcdsaParameters.Variant: ".concat(this.f34103a.f34098d.f34094a));
            }
            zzhxcVarA = zzhjf.b(this.f34105c.intValue());
        }
        return new zzhri(this.f34103a, this.f34104b, zzhxcVarA, this.f34105c);
    }
}
