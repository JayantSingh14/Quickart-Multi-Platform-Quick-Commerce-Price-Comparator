package com.google.firebase.crashlytics.ndk;

import com.google.firebase.crashlytics.internal.NativeSessionFileProvider;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.ndk.SessionFiles;
import java.io.File;

/* loaded from: classes4.dex */
class SessionFilesProvider implements NativeSessionFileProvider {

    /* renamed from: a, reason: collision with root package name */
    public final SessionFiles f44488a;

    public SessionFilesProvider(SessionFiles sessionFiles) {
        this.f44488a = sessionFiles;
    }

    @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
    public final File a() {
        return this.f44488a.f44478e;
    }

    @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
    public final CrashlyticsReport.ApplicationExitInfo b() {
        SessionFiles.NativeCore nativeCore = this.f44488a.f44474a;
        if (nativeCore != null) {
            return nativeCore.f44487b;
        }
        return null;
    }

    @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
    public final File c() {
        return this.f44488a.f44474a.f44486a;
    }

    @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
    public final File d() {
        return this.f44488a.f44475b;
    }

    @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
    public final File e() {
        return this.f44488a.f44477d;
    }

    @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
    public final File f() {
        return this.f44488a.f44479f;
    }

    @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
    public final File g() {
        return this.f44488a.f44476c;
    }
}
