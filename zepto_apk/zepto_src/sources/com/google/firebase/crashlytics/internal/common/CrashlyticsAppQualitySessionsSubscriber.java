package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.sessions.api.SessionSubscriber;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class CrashlyticsAppQualitySessionsSubscriber implements SessionSubscriber {

    /* renamed from: a, reason: collision with root package name */
    public final DataCollectionArbiter f43750a;

    /* renamed from: b, reason: collision with root package name */
    public final CrashlyticsAppQualitySessionsStore f43751b;

    public CrashlyticsAppQualitySessionsSubscriber(DataCollectionArbiter dataCollectionArbiter, FileStore fileStore) {
        this.f43750a = dataCollectionArbiter;
        this.f43751b = new CrashlyticsAppQualitySessionsStore(fileStore);
    }

    @Override // com.google.firebase.sessions.api.SessionSubscriber
    public final boolean a() {
        return this.f43750a.b();
    }

    @Override // com.google.firebase.sessions.api.SessionSubscriber
    public final void b(SessionSubscriber.SessionDetails sessionDetails) {
        Logger.f43705a.b("App Quality Sessions session changed: " + sessionDetails, null);
        CrashlyticsAppQualitySessionsStore crashlyticsAppQualitySessionsStore = this.f43751b;
        String strA = sessionDetails.a();
        synchronized (crashlyticsAppQualitySessionsStore) {
            if (!Objects.equals(crashlyticsAppQualitySessionsStore.f43749c, strA)) {
                CrashlyticsAppQualitySessionsStore.a(crashlyticsAppQualitySessionsStore.f43747a, crashlyticsAppQualitySessionsStore.f43748b, strA);
                crashlyticsAppQualitySessionsStore.f43749c = strA;
            }
        }
    }

    public final String c(String str) {
        String strSubstring;
        CrashlyticsAppQualitySessionsStore crashlyticsAppQualitySessionsStore = this.f43751b;
        synchronized (crashlyticsAppQualitySessionsStore) {
            if (Objects.equals(crashlyticsAppQualitySessionsStore.f43748b, str)) {
                return crashlyticsAppQualitySessionsStore.f43749c;
            }
            FileStore fileStore = crashlyticsAppQualitySessionsStore.f43747a;
            b bVar = CrashlyticsAppQualitySessionsStore.f43745d;
            File file = new File(fileStore.f44387d, str);
            file.mkdirs();
            List listF = FileStore.f(file.listFiles(bVar));
            if (listF.isEmpty()) {
                strSubstring = null;
                Logger.f43705a.f("Unable to read App Quality Sessions session id.", null);
            } else {
                strSubstring = ((File) Collections.min(listF, CrashlyticsAppQualitySessionsStore.f43746e)).getName().substring(4);
            }
            return strSubstring;
        }
    }

    public final void d(String str) {
        CrashlyticsAppQualitySessionsStore crashlyticsAppQualitySessionsStore = this.f43751b;
        synchronized (crashlyticsAppQualitySessionsStore) {
            if (!Objects.equals(crashlyticsAppQualitySessionsStore.f43748b, str)) {
                CrashlyticsAppQualitySessionsStore.a(crashlyticsAppQualitySessionsStore.f43747a, str, crashlyticsAppQualitySessionsStore.f43749c);
                crashlyticsAppQualitySessionsStore.f43748b = str;
            }
        }
    }
}
