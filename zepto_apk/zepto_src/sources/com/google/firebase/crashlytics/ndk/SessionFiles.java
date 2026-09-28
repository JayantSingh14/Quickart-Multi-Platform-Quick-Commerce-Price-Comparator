package com.google.firebase.crashlytics.ndk;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.File;

/* loaded from: classes4.dex */
final class SessionFiles {

    /* renamed from: a, reason: collision with root package name */
    public final NativeCore f44474a;

    /* renamed from: b, reason: collision with root package name */
    public final File f44475b;

    /* renamed from: c, reason: collision with root package name */
    public final File f44476c;

    /* renamed from: d, reason: collision with root package name */
    public final File f44477d;

    /* renamed from: e, reason: collision with root package name */
    public final File f44478e;

    /* renamed from: f, reason: collision with root package name */
    public final File f44479f;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public NativeCore f44480a;

        /* renamed from: b, reason: collision with root package name */
        public File f44481b;

        /* renamed from: c, reason: collision with root package name */
        public File f44482c;

        /* renamed from: d, reason: collision with root package name */
        public File f44483d;

        /* renamed from: e, reason: collision with root package name */
        public File f44484e;

        /* renamed from: f, reason: collision with root package name */
        public File f44485f;

        public final void a(File file) {
            this.f44483d = file;
        }

        public final SessionFiles b() {
            return new SessionFiles(this);
        }

        public final void c(File file) {
            this.f44484e = file;
        }

        public final void d(File file) {
            this.f44481b = file;
        }

        public final void e(NativeCore nativeCore) {
            this.f44480a = nativeCore;
        }

        public final void f(File file) {
            this.f44485f = file;
        }

        public final void g(File file) {
            this.f44482c = file;
        }
    }

    public static final class NativeCore {

        /* renamed from: a, reason: collision with root package name */
        public final File f44486a;

        /* renamed from: b, reason: collision with root package name */
        public final CrashlyticsReport.ApplicationExitInfo f44487b;

        public NativeCore(File file, CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
            this.f44486a = file;
            this.f44487b = applicationExitInfo;
        }

        public final boolean a() {
            File file = this.f44486a;
            return (file != null && file.exists()) || this.f44487b != null;
        }
    }

    public SessionFiles(Builder builder) {
        this.f44474a = builder.f44480a;
        this.f44475b = builder.f44481b;
        this.f44476c = builder.f44482c;
        this.f44477d = builder.f44483d;
        this.f44478e = builder.f44484e;
        this.f44479f = builder.f44485f;
    }
}
