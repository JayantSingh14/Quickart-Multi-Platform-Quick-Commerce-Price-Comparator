package com.google.android.datatransport.runtime.firebase.transport;

/* loaded from: classes3.dex */
public final class TimeWindow {

    /* renamed from: a, reason: collision with root package name */
    public final long f20836a;

    /* renamed from: b, reason: collision with root package name */
    public final long f20837b;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public long f20838a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f20839b = 0;

        public final TimeWindow a() {
            return new TimeWindow(this.f20838a, this.f20839b);
        }
    }

    static {
        new Builder().a();
    }

    public TimeWindow(long j2, long j3) {
        this.f20836a = j2;
        this.f20837b = j3;
    }

    public static Builder a() {
        return new Builder();
    }
}
