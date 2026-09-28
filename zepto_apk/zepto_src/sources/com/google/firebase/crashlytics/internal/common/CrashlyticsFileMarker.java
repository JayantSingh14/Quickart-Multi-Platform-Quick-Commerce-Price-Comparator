package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
class CrashlyticsFileMarker {

    /* renamed from: a, reason: collision with root package name */
    public final String f43790a;

    /* renamed from: b, reason: collision with root package name */
    public final FileStore f43791b;

    public CrashlyticsFileMarker(FileStore fileStore, String str) {
        this.f43790a = str;
        this.f43791b = fileStore;
    }

    public final void a() throws IOException {
        String str = this.f43790a;
        try {
            FileStore fileStore = this.f43791b;
            fileStore.getClass();
            new File(fileStore.f44386c, str).createNewFile();
        } catch (IOException e2) {
            Logger.f43705a.c("Error creating marker: ".concat(str), e2);
        }
    }
}
