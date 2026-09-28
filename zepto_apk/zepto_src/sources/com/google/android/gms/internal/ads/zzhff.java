package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzhff {

    /* renamed from: a, reason: collision with root package name */
    public static final zzhjl f33704a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzhji f33705b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzhig f33706c;

    /* renamed from: d, reason: collision with root package name */
    public static final zzhid f33707d;

    static {
        zzhxc zzhxcVarA = zzhkl.a("type.googleapis.com/google.crypto.tink.AesEaxKey");
        f33704a = new zzhjj(zzhcb.class, zzhfe.f33703a);
        f33705b = new zzhjg(zzhxcVarA, zzhfb.f33700a);
        f33706c = new zzhie(zzhbv.class, zzhfc.f33701a);
        f33707d = new zzhib(zzhxcVarA, zzhfd.f33702a);
    }

    public static zzhpw a(zzhca zzhcaVar) throws GeneralSecurityException {
        if (zzhca.f33506b.equals(zzhcaVar)) {
            return zzhpw.TINK;
        }
        if (zzhca.f33507c.equals(zzhcaVar)) {
            return zzhpw.CRUNCHY;
        }
        if (zzhca.f33508d.equals(zzhcaVar)) {
            return zzhpw.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzhcaVar)));
    }

    public static zzhca b(zzhpw zzhpwVar) throws GeneralSecurityException {
        int iOrdinal = zzhpwVar.ordinal();
        if (iOrdinal == 1) {
            return zzhca.f33506b;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzhca.f33508d;
            }
            if (iOrdinal != 4) {
                int iZza = zzhpwVar.zza();
                throw new GeneralSecurityException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(iZza).length() + 34), iZza, "Unable to parse OutputPrefixType: "));
            }
        }
        return zzhca.f33507c;
    }
}
