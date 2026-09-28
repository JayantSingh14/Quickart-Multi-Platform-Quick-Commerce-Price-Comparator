package com.google.android.datatransport.runtime.backends;

import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes3.dex */
public abstract class BackendResponse {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Status {

        /* renamed from: a, reason: collision with root package name */
        public static final Status f20779a;

        /* renamed from: b, reason: collision with root package name */
        public static final Status f20780b;

        /* renamed from: c, reason: collision with root package name */
        public static final Status f20781c;

        /* renamed from: d, reason: collision with root package name */
        public static final Status f20782d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ Status[] f20783e;

        static {
            Status status = new Status("OK", 0);
            f20779a = status;
            Status status2 = new Status("TRANSIENT_ERROR", 1);
            f20780b = status2;
            Status status3 = new Status("FATAL_ERROR", 2);
            f20781c = status3;
            Status status4 = new Status("INVALID_PAYLOAD", 3);
            f20782d = status4;
            f20783e = new Status[]{status, status2, status3, status4};
        }

        public static Status valueOf(String str) {
            return (Status) Enum.valueOf(Status.class, str);
        }

        public static Status[] values() {
            return (Status[]) f20783e.clone();
        }
    }

    public static BackendResponse a() {
        return new AutoValue_BackendResponse(Status.f20781c, -1L);
    }

    public static BackendResponse d() {
        return new AutoValue_BackendResponse(Status.f20782d, -1L);
    }

    public static BackendResponse e(long j2) {
        return new AutoValue_BackendResponse(Status.f20779a, j2);
    }

    public static BackendResponse f() {
        return new AutoValue_BackendResponse(Status.f20780b, -1L);
    }

    public abstract long b();

    public abstract Status c();
}
