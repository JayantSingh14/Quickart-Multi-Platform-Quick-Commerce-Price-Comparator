package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzhdy {

    /* renamed from: a, reason: collision with root package name */
    public static final zzhjl f33629a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzhji f33630b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzhig f33631c;

    /* renamed from: d, reason: collision with root package name */
    public static final zzhid f33632d;

    static {
        zzhxc zzhxcVarA = zzhkl.a("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        f33629a = new zzhjj(zzhdt.class, zzhdx.f33628a);
        f33630b = new zzhjg(zzhxcVarA, zzhdu.f33625a);
        f33631c = new zzhie(zzhdp.class, zzhdv.f33626a);
        f33632d = new zzhib(zzhxcVarA, zzhdw.f33627a);
    }

    public static zzhpw a(zzhds zzhdsVar) throws GeneralSecurityException {
        if (zzhds.f33618b.equals(zzhdsVar)) {
            return zzhpw.TINK;
        }
        if (zzhds.f33619c.equals(zzhdsVar)) {
            return zzhpw.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzhdsVar)));
    }

    public static zzhpv b(zzhdt zzhdtVar) {
        byte[] bArrG = ((zzhka) zzhje.f33884b.h(zzhdtVar.f33624d)).f33917b.g();
        try {
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            zzhpd zzhpdVarF = zzhpd.F(bArrG, zziab.f34621c);
            zzhpu zzhpuVarF = zzhpv.F();
            String str = zzhdtVar.f33622b;
            zzhpuVarF.j();
            ((zzhpv) zzhpuVarF.f34638b).H(str);
            zzhpuVarF.j();
            ((zzhpv) zzhpuVarF.f34638b).I(zzhpdVarF);
            return (zzhpv) zzhpuVarF.l();
        } catch (zzibg e2) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e2);
        }
    }

    public static zzhdt c(zzhpv zzhpvVar, zzhpw zzhpwVar) throws GeneralSecurityException {
        zzhdr zzhdrVar;
        zzhds zzhdsVar;
        zzhpc zzhpcVarG = zzhpd.G();
        zzhpcVarG.n(zzhpvVar.D().C());
        zzhpcVarG.o(zzhpvVar.D().D());
        zzhpcVarG.p(zzhpw.RAW);
        zzhan zzhanVarA = zzhat.a(((zzhpd) zzhpcVarG.l()).g());
        boolean z = zzhanVarA instanceof zzhck;
        Object obj = zzhdr.f33616g;
        zzhdr zzhdrVar2 = zzhdr.f33615f;
        zzhdr zzhdrVar3 = zzhdr.f33614e;
        zzhdr zzhdrVar4 = zzhdr.f33612c;
        zzhdr zzhdrVar5 = zzhdr.f33613d;
        zzhdr zzhdrVar6 = zzhdr.f33611b;
        if (z) {
            zzhdrVar = zzhdrVar6;
        } else if (zzhanVarA instanceof zzhcz) {
            zzhdrVar = zzhdrVar5;
        } else if (zzhanVarA instanceof zzhev) {
            zzhdrVar = zzhdrVar4;
        } else if (zzhanVarA instanceof zzhbt) {
            zzhdrVar = zzhdrVar3;
        } else if (zzhanVarA instanceof zzhcb) {
            zzhdrVar = zzhdrVar2;
        } else {
            if (!(zzhanVarA instanceof zzhct)) {
                throw new GeneralSecurityException("Unsupported DEK parameters when parsing ".concat(zzhanVarA.toString()));
            }
            zzhdrVar = obj;
        }
        zzhdq zzhdqVar = new zzhdq();
        int iOrdinal = zzhpwVar.ordinal();
        zzhds zzhdsVar2 = zzhds.f33619c;
        if (iOrdinal == 1) {
            zzhdsVar = zzhds.f33618b;
        } else {
            if (iOrdinal != 3) {
                int iZza = zzhpwVar.zza();
                throw new GeneralSecurityException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(iZza).length() + 34), iZza, "Unable to parse OutputPrefixType: "));
            }
            zzhdsVar = zzhdsVar2;
        }
        zzhdqVar.f33607a = zzhdsVar;
        String strC = zzhpvVar.C();
        zzhdqVar.f33608b = strC;
        zzhbf zzhbfVar = (zzhbf) zzhanVarA;
        zzhdqVar.f33610d = zzhbfVar;
        zzhdqVar.f33609c = zzhdrVar;
        if (zzhdqVar.f33607a == null) {
            zzhdqVar.f33607a = zzhdsVar2;
        }
        if (strC == null) {
            throw new GeneralSecurityException("kekUri must be set");
        }
        if (zzhbfVar == null) {
            throw new GeneralSecurityException("dekParametersForNewKeys must be set");
        }
        if (zzhbfVar.a()) {
            throw new GeneralSecurityException("dekParametersForNewKeys must not have ID Requirements");
        }
        if ((zzhdrVar.equals(zzhdrVar6) && (zzhbfVar instanceof zzhck)) || ((zzhdrVar.equals(zzhdrVar5) && (zzhbfVar instanceof zzhcz)) || ((zzhdrVar.equals(zzhdrVar4) && (zzhbfVar instanceof zzhev)) || ((zzhdrVar.equals(zzhdrVar3) && (zzhbfVar instanceof zzhbt)) || ((zzhdrVar.equals(zzhdrVar2) && (zzhbfVar instanceof zzhcb)) || (zzhdrVar.equals(obj) && (zzhbfVar instanceof zzhct))))))) {
            return new zzhdt(zzhdqVar.f33607a, zzhdqVar.f33608b, zzhdqVar.f33609c, zzhdqVar.f33610d);
        }
        String str = zzhdqVar.f33609c.f33617a;
        String strValueOf = String.valueOf(zzhdqVar.f33610d);
        StringBuilder sb = new StringBuilder(strValueOf.length() + str.length() + 67 + 1);
        android.support.v4.media.b.B(sb, "Cannot use parsing strategy ", str, " when new keys are picked according to ", strValueOf);
        sb.append(CLConstants.DOT_SALT_DELIMETER);
        throw new GeneralSecurityException(sb.toString());
    }
}
