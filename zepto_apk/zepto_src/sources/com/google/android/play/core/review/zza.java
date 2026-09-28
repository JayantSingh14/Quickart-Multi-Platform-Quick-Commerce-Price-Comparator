package com.google.android.play.core.review;

import android.app.PendingIntent;

/* loaded from: classes4.dex */
final class zza extends ReviewInfo {

    /* renamed from: a, reason: collision with root package name */
    public final PendingIntent f41885a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f41886b;

    public zza(PendingIntent pendingIntent, boolean z) {
        if (pendingIntent == null) {
            throw new NullPointerException("Null pendingIntent");
        }
        this.f41885a = pendingIntent;
        this.f41886b = z;
    }

    @Override // com.google.android.play.core.review.ReviewInfo
    public final PendingIntent a() {
        return this.f41885a;
    }

    @Override // com.google.android.play.core.review.ReviewInfo
    public final boolean b() {
        return this.f41886b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReviewInfo)) {
            return false;
        }
        ReviewInfo reviewInfo = (ReviewInfo) obj;
        return this.f41885a.equals(reviewInfo.a()) && this.f41886b == reviewInfo.b();
    }

    public final int hashCode() {
        return ((this.f41885a.hashCode() ^ 1000003) * 1000003) ^ (true != this.f41886b ? 1237 : 1231);
    }

    public final String toString() {
        return "ReviewInfo{pendingIntent=" + this.f41885a.toString() + ", isNoOp=" + this.f41886b + "}";
    }
}
