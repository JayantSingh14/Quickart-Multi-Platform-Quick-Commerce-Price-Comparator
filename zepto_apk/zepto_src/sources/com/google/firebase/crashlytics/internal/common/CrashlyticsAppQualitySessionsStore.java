package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.IOException;

/* loaded from: classes.dex */
class CrashlyticsAppQualitySessionsStore {

    /* renamed from: d, reason: collision with root package name */
    public static final b f43745d = new b(1);

    /* renamed from: e, reason: collision with root package name */
    public static final a f43746e = new a();

    /* renamed from: a, reason: collision with root package name */
    public final FileStore f43747a;

    /* renamed from: b, reason: collision with root package name */
    public String f43748b = null;

    /* renamed from: c, reason: collision with root package name */
    public String f43749c = null;

    public CrashlyticsAppQualitySessionsStore(FileStore fileStore) {
        this.f43747a = fileStore;
    }

    public static void a(FileStore fileStore, String str, String str2) throws IOException {
        if (str == null || str2 == null) {
            return;
        }
        try {
            fileStore.c(str, "aqs.".concat(str2)).createNewFile();
        } catch (IOException e2) {
            Logger.f43705a.f("Failed to persist App Quality Sessions session id.", e2);
        }
    }
}
