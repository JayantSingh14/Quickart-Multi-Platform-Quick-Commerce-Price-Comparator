package androidx.work;

import android.app.Notification;

/* loaded from: classes3.dex */
public final class ForegroundInfo {

    /* renamed from: a, reason: collision with root package name */
    public final int f12521a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12522b;

    /* renamed from: c, reason: collision with root package name */
    public final Notification f12523c;

    public ForegroundInfo(int i2, int i3, Notification notification) {
        this.f12521a = i2;
        this.f12523c = notification;
        this.f12522b = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ForegroundInfo.class != obj.getClass()) {
            return false;
        }
        ForegroundInfo foregroundInfo = (ForegroundInfo) obj;
        if (this.f12521a == foregroundInfo.f12521a && this.f12522b == foregroundInfo.f12522b) {
            return this.f12523c.equals(foregroundInfo.f12523c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f12523c.hashCode() + (((this.f12521a * 31) + this.f12522b) * 31);
    }

    public final String toString() {
        return "ForegroundInfo{mNotificationId=" + this.f12521a + ", mForegroundServiceType=" + this.f12522b + ", mNotification=" + this.f12523c + '}';
    }
}
