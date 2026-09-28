package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.InputStream;

/* loaded from: classes4.dex */
interface NativeSessionFile {
    CrashlyticsReport.FilesPayload.File a();

    String b();

    InputStream j();
}
