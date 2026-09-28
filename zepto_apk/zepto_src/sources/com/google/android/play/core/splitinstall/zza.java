package com.google.android.play.core.splitinstall;

import android.app.PendingIntent;
import android.support.v4.media.b;
import java.util.List;

/* loaded from: classes4.dex */
final class zza extends SplitInstallSessionState {

    /* renamed from: a, reason: collision with root package name */
    public final int f42072a;

    /* renamed from: b, reason: collision with root package name */
    public final int f42073b;

    /* renamed from: c, reason: collision with root package name */
    public final int f42074c;

    /* renamed from: d, reason: collision with root package name */
    public final long f42075d;

    /* renamed from: e, reason: collision with root package name */
    public final long f42076e;

    /* renamed from: f, reason: collision with root package name */
    public final List f42077f;

    /* renamed from: g, reason: collision with root package name */
    public final List f42078g;

    /* renamed from: h, reason: collision with root package name */
    public final PendingIntent f42079h;

    /* renamed from: i, reason: collision with root package name */
    public final List f42080i;

    public zza(int i2, int i3, int i4, long j2, long j3, List list, List list2, PendingIntent pendingIntent, List list3) {
        this.f42072a = i2;
        this.f42073b = i3;
        this.f42074c = i4;
        this.f42075d = j2;
        this.f42076e = j3;
        this.f42077f = list;
        this.f42078g = list2;
        this.f42079h = pendingIntent;
        this.f42080i = list3;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallSessionState
    public final long a() {
        return this.f42075d;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallSessionState
    public final int c() {
        return this.f42074c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SplitInstallSessionState)) {
            return false;
        }
        SplitInstallSessionState splitInstallSessionState = (SplitInstallSessionState) obj;
        if (this.f42072a != splitInstallSessionState.g() || this.f42073b != splitInstallSessionState.h() || this.f42074c != splitInstallSessionState.c() || this.f42075d != splitInstallSessionState.a() || this.f42076e != splitInstallSessionState.i()) {
            return false;
        }
        List list = this.f42077f;
        if (list == null) {
            if (splitInstallSessionState.k() != null) {
                return false;
            }
        } else if (!list.equals(splitInstallSessionState.k())) {
            return false;
        }
        List list2 = this.f42078g;
        if (list2 == null) {
            if (splitInstallSessionState.j() != null) {
                return false;
            }
        } else if (!list2.equals(splitInstallSessionState.j())) {
            return false;
        }
        PendingIntent pendingIntent = this.f42079h;
        if (pendingIntent == null) {
            if (splitInstallSessionState.f() != null) {
                return false;
            }
        } else if (!pendingIntent.equals(splitInstallSessionState.f())) {
            return false;
        }
        List list3 = this.f42080i;
        return list3 == null ? splitInstallSessionState.l() == null : list3.equals(splitInstallSessionState.l());
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallSessionState
    public final PendingIntent f() {
        return this.f42079h;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallSessionState
    public final int g() {
        return this.f42072a;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallSessionState
    public final int h() {
        return this.f42073b;
    }

    public final int hashCode() {
        int i2 = ((((this.f42072a ^ 1000003) * 1000003) ^ this.f42073b) * 1000003) ^ this.f42074c;
        long j2 = this.f42075d;
        long j3 = j2 ^ (j2 >>> 32);
        long j4 = this.f42076e;
        long j5 = (j4 >>> 32) ^ j4;
        List list = this.f42077f;
        int iHashCode = ((((((i2 * 1000003) ^ ((int) j3)) * 1000003) ^ ((int) j5)) * 1000003) ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List list2 = this.f42078g;
        int iHashCode2 = (iHashCode ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        PendingIntent pendingIntent = this.f42079h;
        int iHashCode3 = (iHashCode2 ^ (pendingIntent == null ? 0 : pendingIntent.hashCode())) * 1000003;
        List list3 = this.f42080i;
        return iHashCode3 ^ (list3 != null ? list3.hashCode() : 0);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallSessionState
    public final long i() {
        return this.f42076e;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallSessionState
    public final List j() {
        return this.f42078g;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallSessionState
    public final List k() {
        return this.f42077f;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallSessionState
    public final List l() {
        return this.f42080i;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f42077f);
        String strValueOf2 = String.valueOf(this.f42078g);
        String strValueOf3 = String.valueOf(this.f42079h);
        String strValueOf4 = String.valueOf(this.f42080i);
        StringBuilder sb = new StringBuilder("SplitInstallSessionState{sessionId=");
        sb.append(this.f42072a);
        sb.append(", status=");
        sb.append(this.f42073b);
        sb.append(", errorCode=");
        sb.append(this.f42074c);
        sb.append(", bytesDownloaded=");
        sb.append(this.f42075d);
        sb.append(", totalBytesToDownload=");
        sb.append(this.f42076e);
        sb.append(", moduleNamesNullable=");
        sb.append(strValueOf);
        b.B(sb, ", languagesNullable=", strValueOf2, ", resolutionIntent=", strValueOf3);
        return b.s(sb, ", splitFileIntents=", strValueOf4, "}");
    }
}
