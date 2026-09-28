package com.google.android.datatransport.runtime.firebase.transport;

/* loaded from: classes3.dex */
public final class GlobalMetrics {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f20809b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final StorageMetrics f20810a;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public StorageMetrics f20811a = null;

        public final GlobalMetrics a() {
            return new GlobalMetrics(this.f20811a);
        }
    }

    static {
        new Builder().a();
    }

    public GlobalMetrics(StorageMetrics storageMetrics) {
        this.f20810a = storageMetrics;
    }
}
