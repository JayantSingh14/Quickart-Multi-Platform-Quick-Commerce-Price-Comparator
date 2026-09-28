package com.google.firebase.crashlytics.internal.settings;

/* loaded from: classes.dex */
public class Settings {

    /* renamed from: a, reason: collision with root package name */
    public final SessionData f44421a;

    /* renamed from: b, reason: collision with root package name */
    public final FeatureFlagData f44422b;

    /* renamed from: c, reason: collision with root package name */
    public final long f44423c;

    /* renamed from: d, reason: collision with root package name */
    public final double f44424d;

    /* renamed from: e, reason: collision with root package name */
    public final double f44425e;

    /* renamed from: f, reason: collision with root package name */
    public final int f44426f;

    public static class FeatureFlagData {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f44427a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f44428b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f44429c;

        public FeatureFlagData(boolean z, boolean z2, boolean z3) {
            this.f44427a = z;
            this.f44428b = z2;
            this.f44429c = z3;
        }
    }

    public static class SessionData {

        /* renamed from: a, reason: collision with root package name */
        public final int f44430a;

        public SessionData(int i2) {
            this.f44430a = i2;
        }
    }

    public Settings(long j2, SessionData sessionData, FeatureFlagData featureFlagData, double d2, double d3, int i2) {
        this.f44423c = j2;
        this.f44421a = sessionData;
        this.f44422b = featureFlagData;
        this.f44424d = d2;
        this.f44425e = d3;
        this.f44426f = i2;
    }
}
