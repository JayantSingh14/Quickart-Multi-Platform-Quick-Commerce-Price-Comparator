package com.google.firebase.crashlytics.internal;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.File;

/* loaded from: classes.dex */
public interface NativeSessionFileProvider {
    File a();

    CrashlyticsReport.ApplicationExitInfo b();

    File c();

    File d();

    File e();

    File f();

    File g();
}
