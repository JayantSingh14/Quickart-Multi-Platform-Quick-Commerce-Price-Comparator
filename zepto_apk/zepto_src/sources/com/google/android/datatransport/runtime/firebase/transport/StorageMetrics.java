package com.google.android.datatransport.runtime.firebase.transport;

/* loaded from: classes3.dex */
public final class StorageMetrics {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f20831c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final long f20832a;

    /* renamed from: b, reason: collision with root package name */
    public final long f20833b;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public long f20834a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f20835b = 0;

        public final StorageMetrics a() {
            return new StorageMetrics(this.f20834a, this.f20835b);
        }
    }

    static {
        new Builder().a();
    }

    public StorageMetrics(long j2, long j3) {
        this.f20832a = j2;
        this.f20833b = j3;
    }
}
