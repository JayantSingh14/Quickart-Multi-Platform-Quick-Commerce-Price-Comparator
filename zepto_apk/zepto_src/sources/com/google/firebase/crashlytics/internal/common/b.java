package com.google.firebase.crashlytics.internal.common;

import java.io.File;
import java.io.FilenameFilter;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements FilenameFilter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f43843a;

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        switch (this.f43843a) {
            case 0:
                b bVar = CrashlyticsController.s;
                return str.startsWith(".ae");
            default:
                return str.startsWith("aqs.");
        }
    }
}
