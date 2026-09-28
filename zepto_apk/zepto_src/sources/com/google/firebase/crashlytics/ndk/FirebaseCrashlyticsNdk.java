package com.google.firebase.crashlytics.ndk;

import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.NativeSessionFileProvider;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.crashlytics.ndk.SessionFiles;
import java.io.IOException;

/* loaded from: classes.dex */
class FirebaseCrashlyticsNdk implements CrashlyticsNativeComponent {

    /* renamed from: a, reason: collision with root package name */
    public final CrashpadController f44468a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f44469b;

    /* renamed from: c, reason: collision with root package name */
    public String f44470c;

    public interface SignalHandlerInstaller {
    }

    public FirebaseCrashlyticsNdk(CrashpadController crashpadController, boolean z) {
        this.f44468a = crashpadController;
        this.f44469b = z;
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public final NativeSessionFileProvider a(String str) {
        return new SessionFilesProvider(this.f44468a.b(str));
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public final boolean b() {
        String str = this.f44470c;
        return str != null && d(str);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.firebase.crashlytics.ndk.b] */
    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public final synchronized void c(final String str, final long j2, final StaticSessionData staticSessionData) throws Throwable {
        try {
            try {
                this.f44470c = str;
                ?? r0 = new SignalHandlerInstaller() { // from class: com.google.firebase.crashlytics.ndk.b
                    public final void a() throws Throwable {
                        long j3 = j2;
                        StaticSessionData staticSessionData2 = staticSessionData;
                        FirebaseCrashlyticsNdk firebaseCrashlyticsNdk = this.f44490a;
                        firebaseCrashlyticsNdk.getClass();
                        Logger logger = Logger.f43705a;
                        StringBuilder sb = new StringBuilder("Initializing native session: ");
                        String str2 = str;
                        sb.append(str2);
                        logger.b(sb.toString(), null);
                        CrashpadController crashpadController = firebaseCrashlyticsNdk.f44468a;
                        try {
                            if (crashpadController.f44466b.b(crashpadController.f44465a.getAssets(), crashpadController.f44467c.b(str2).getCanonicalPath())) {
                                crashpadController.d(j3, str2);
                                crashpadController.e(str2, staticSessionData2.a());
                                crashpadController.h(str2, staticSessionData2.d());
                                crashpadController.f(str2, staticSessionData2.c());
                                return;
                            }
                        } catch (IOException e2) {
                            logger.c("Error initializing Crashlytics NDK", e2);
                        }
                        logger.f("Failed to initialize Crashlytics NDK for session " + str2, null);
                    }
                };
                if (this.f44469b) {
                    r0.a();
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public final boolean d(String str) {
        SessionFiles.NativeCore nativeCore = this.f44468a.b(str).f44474a;
        return nativeCore != null && nativeCore.a();
    }
}
