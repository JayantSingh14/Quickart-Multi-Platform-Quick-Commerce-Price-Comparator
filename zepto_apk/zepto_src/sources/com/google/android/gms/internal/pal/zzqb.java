package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzqb {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f38018a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f38019b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f38020c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f38021d;

    public /* synthetic */ zzqb(zzpv zzpvVar) {
        this.f38018a = new HashMap(zzpvVar.f38009a);
        this.f38019b = new HashMap(zzpvVar.f38010b);
        this.f38020c = new HashMap(zzpvVar.f38011c);
        this.f38021d = new HashMap(zzpvVar.f38012d);
    }

    public final zzka a(zzps zzpsVar) throws GeneralSecurityException {
        zzpx zzpxVar = new zzpx(zzps.class, zzpsVar.f38004b);
        HashMap map = this.f38019b;
        if (map.containsKey(zzpxVar)) {
            return ((zzou) map.get(zzpxVar)).a(zzpsVar);
        }
        throw new GeneralSecurityException(android.support.v4.media.b.D("No Key Parser for requested key type ", zzpxVar.toString(), " available"));
    }
}
