package com.google.android.gms.internal.ads;

import android.os.Parcelable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzbuf implements NativeMediationAdRequest {

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f25568a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f25569b;

    /* renamed from: c, reason: collision with root package name */
    public final int f25570c;

    /* renamed from: d, reason: collision with root package name */
    public final zzbjn f25571d;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f25573f;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f25572e = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f25574g = new HashMap();

    public zzbuf(HashSet hashSet, boolean z, int i2, zzbjn zzbjnVar, ArrayList arrayList, boolean z2) {
        this.f25568a = hashSet;
        this.f25569b = z;
        this.f25570c = i2;
        this.f25571d = zzbjnVar;
        this.f25573f = z2;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (str.startsWith("custom:")) {
                    String[] strArrSplit = str.split(":", 3);
                    if (strArrSplit.length == 3) {
                        String str2 = strArrSplit[2];
                        if ("true".equals(str2)) {
                            this.f25574g.put(strArrSplit[1], Boolean.TRUE);
                        } else if ("false".equals(str2)) {
                            this.f25574g.put(strArrSplit[1], Boolean.FALSE);
                        }
                    }
                } else {
                    this.f25572e.add(str);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.ads.nativead.NativeAdOptions a() {
        /*
            r6 = this;
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbjn> r0 = com.google.android.gms.internal.ads.zzbjn.CREATOR
            com.google.android.gms.ads.nativead.NativeAdOptions$Builder r0 = new com.google.android.gms.ads.nativead.NativeAdOptions$Builder
            r0.<init>()
            com.google.android.gms.internal.ads.zzbjn r1 = r6.f25571d
            if (r1 != 0) goto L11
            com.google.android.gms.ads.nativead.NativeAdOptions r1 = new com.google.android.gms.ads.nativead.NativeAdOptions
            r1.<init>(r0)
            return r1
        L11:
            r2 = 2
            int r3 = r1.f25249a
            if (r3 == r2) goto L47
            r4 = 3
            if (r3 == r4) goto L3c
            r5 = 4
            if (r3 == r5) goto L1d
            goto L4b
        L1d:
            boolean r3 = r1.f25255g
            r0.f21735f = r3
            int r3 = r1.f25256h
            r0.f21731b = r3
            boolean r3 = r1.f25258j
            r0.f21736g = r3
            int r3 = r1.f25257i
            r0.f21737h = r3
            r3 = 1
            int r5 = r1.f25259k
            if (r5 != 0) goto L34
        L32:
            r2 = r3
            goto L3a
        L34:
            if (r5 != r2) goto L38
            r2 = r4
            goto L3a
        L38:
            if (r5 != r3) goto L32
        L3a:
            r0.f21738i = r2
        L3c:
            com.google.android.gms.ads.internal.client.zzga r2 = r1.f25254f
            if (r2 == 0) goto L47
            com.google.android.gms.ads.VideoOptions r3 = new com.google.android.gms.ads.VideoOptions
            r3.<init>(r2)
            r0.f21733d = r3
        L47:
            int r2 = r1.f25253e
            r0.f21734e = r2
        L4b:
            boolean r2 = r1.f25250b
            r0.f21730a = r2
            boolean r1 = r1.f25252d
            r0.f21732c = r1
            com.google.android.gms.ads.nativead.NativeAdOptions r1 = new com.google.android.gms.ads.nativead.NativeAdOptions
            r1.<init>(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbuf.a():com.google.android.gms.ads.nativead.NativeAdOptions");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final int b() {
        return this.f25570c;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final boolean c() {
        return this.f25573f;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final boolean d() {
        return this.f25569b;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final NativeAdOptions e() {
        Parcelable.Creator<zzbjn> creator = zzbjn.CREATOR;
        NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
        zzbjn zzbjnVar = this.f25571d;
        if (zzbjnVar == null) {
            return new NativeAdOptions(builder);
        }
        int i2 = zzbjnVar.f25249a;
        if (i2 == 2) {
            builder.f21057f = zzbjnVar.f25253e;
        } else {
            if (i2 != 3) {
                if (i2 == 4) {
                    builder.f21058g = zzbjnVar.f25255g;
                    builder.f21054c = zzbjnVar.f25256h;
                }
            }
            com.google.android.gms.ads.internal.client.zzga zzgaVar = zzbjnVar.f25254f;
            if (zzgaVar != null) {
                builder.f21056e = new VideoOptions(zzgaVar);
            }
            builder.f21057f = zzbjnVar.f25253e;
        }
        builder.f21052a = zzbjnVar.f25250b;
        builder.f21053b = zzbjnVar.f25251c;
        builder.f21055d = zzbjnVar.f25252d;
        return new NativeAdOptions(builder);
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean f() {
        return this.f25572e.contains(CLConstants.CREDTYPE_DEBIT_DLENGTH);
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Set g() {
        return this.f25568a;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean zza() {
        return this.f25572e.contains("3");
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final HashMap zzb() {
        return this.f25574g;
    }
}
