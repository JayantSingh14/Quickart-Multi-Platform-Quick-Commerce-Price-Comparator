package com.google.firebase.crashlytics.internal.persistence;

import io.sentry.cache.EnvelopeCache;
import java.io.File;
import java.io.FilenameFilter;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements FilenameFilter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f44392a;

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        switch (this.f44392a) {
            case 0:
                Charset charset = CrashlyticsReportPersistence.f44375e;
                return str.startsWith("event");
            default:
                int i2 = EnvelopeCache.f52676h;
                return str.endsWith(".envelope");
        }
    }
}
