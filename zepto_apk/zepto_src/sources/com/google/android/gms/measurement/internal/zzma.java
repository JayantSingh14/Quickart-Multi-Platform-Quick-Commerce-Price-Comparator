package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.ConcurrentHashMap;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public final class zzma extends zzg {

    /* renamed from: c, reason: collision with root package name */
    public volatile zzlt f39379c;

    /* renamed from: d, reason: collision with root package name */
    public volatile zzlt f39380d;

    /* renamed from: e, reason: collision with root package name */
    public zzlt f39381e;

    /* renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap f39382f;

    /* renamed from: g, reason: collision with root package name */
    public com.google.android.gms.internal.measurement.zzdf f39383g;

    /* renamed from: h, reason: collision with root package name */
    public volatile boolean f39384h;

    /* renamed from: i, reason: collision with root package name */
    public volatile zzlt f39385i;

    /* renamed from: j, reason: collision with root package name */
    public zzlt f39386j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f39387k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f39388l;

    public zzma(zzib zzibVar) {
        super(zzibVar);
        this.f39388l = new Object();
        this.f39382f = new ConcurrentHashMap();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final boolean j() {
        return false;
    }

    public final void k(zzlt zzltVar, boolean z, long j2) {
        zzib zzibVar = this.f39180a;
        zzd zzdVar = zzibVar.n;
        zzib.i(zzdVar);
        zzdVar.j(zzibVar.f39094k.elapsedRealtime());
        boolean z2 = zzltVar != null && zzltVar.f39355d;
        zzob zzobVar = zzibVar.f39091h;
        zzib.k(zzobVar);
        if (!zzobVar.f39535f.a(j2, z2, z) || zzltVar == null) {
            return;
        }
        zzltVar.f39355d = false;
    }

    public final zzlt l(com.google.android.gms.internal.measurement.zzdf zzdfVar) {
        Preconditions.checkNotNull(zzdfVar);
        Integer numValueOf = Integer.valueOf(zzdfVar.f36836a);
        ConcurrentHashMap concurrentHashMap = this.f39382f;
        zzlt zzltVar = (zzlt) concurrentHashMap.get(numValueOf);
        if (zzltVar == null) {
            String strN = n(zzdfVar.f36837b);
            zzpo zzpoVar = this.f39180a.f39092i;
            zzib.j(zzpoVar);
            zzlt zzltVar2 = new zzlt(zzpoVar.b0(), null, strN);
            concurrentHashMap.put(numValueOf, zzltVar2);
            zzltVar = zzltVar2;
        }
        return this.f39385i != null ? this.f39385i : zzltVar;
    }

    public final zzlt m(boolean z) {
        h();
        g();
        if (!z) {
            return this.f39381e;
        }
        zzlt zzltVar = this.f39381e;
        return zzltVar != null ? zzltVar : this.f39386j;
    }

    public final String n(String str) {
        if (str == null) {
            return "Activity";
        }
        String[] strArrSplit = str.split("\\.");
        int length = strArrSplit.length;
        String str2 = length > 0 ? strArrSplit[length - 1] : "";
        int length2 = str2.length();
        zzib zzibVar = this.f39180a;
        zzibVar.f39087d.getClass();
        if (length2 <= 500) {
            return str2;
        }
        zzibVar.f39087d.getClass();
        return str2.substring(0, 500);
    }

    public final void o(com.google.android.gms.internal.measurement.zzdf zzdfVar, Bundle bundle) {
        Bundle bundle2;
        if (!this.f39180a.f39087d.u() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.f39382f.put(Integer.valueOf(zzdfVar.f36836a), new zzlt(bundle2.getLong(CLConstants.SHARED_PREFERENCE_ITEM_ID), bundle2.getString(CLConstants.FIELD_PAY_INFO_NAME), bundle2.getString("referrer_name")));
    }

    public final void p(String str, zzlt zzltVar, boolean z) {
        zzlt zzltVar2;
        zzlt zzltVar3 = this.f39379c == null ? this.f39380d : this.f39379c;
        if (zzltVar.f39353b == null) {
            zzltVar2 = new zzlt(zzltVar.f39352a, str != null ? n(str) : null, zzltVar.f39354c, zzltVar.f39356e, zzltVar.f39357f);
        } else {
            zzltVar2 = zzltVar;
        }
        this.f39380d = this.f39379c;
        this.f39379c = zzltVar2;
        zzib zzibVar = this.f39180a;
        long jElapsedRealtime = zzibVar.f39094k.elapsedRealtime();
        zzhy zzhyVar = zzibVar.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.p(new zzlv(this, zzltVar2, zzltVar3, jElapsedRealtime, z));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(com.google.android.gms.measurement.internal.zzlt r18, com.google.android.gms.measurement.internal.zzlt r19, long r20, boolean r22, android.os.Bundle r23) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzma.q(com.google.android.gms.measurement.internal.zzlt, com.google.android.gms.measurement.internal.zzlt, long, boolean, android.os.Bundle):void");
    }
}
