package io.sentry;

import io.sentry.protocol.SentryPackage;
import io.sentry.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class SentryIntegrationPackageStorage {

    /* renamed from: c, reason: collision with root package name */
    public static volatile SentryIntegrationPackageStorage f51836c;

    /* renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet f51837a = new CopyOnWriteArraySet();

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArraySet f51838b = new CopyOnWriteArraySet();

    public static SentryIntegrationPackageStorage c() {
        if (f51836c == null) {
            synchronized (SentryIntegrationPackageStorage.class) {
                try {
                    if (f51836c == null) {
                        f51836c = new SentryIntegrationPackageStorage();
                    }
                } finally {
                }
            }
        }
        return f51836c;
    }

    public final void a(String str) {
        Objects.b(str, "integration is required.");
        this.f51837a.add(str);
    }

    public final void b(String str, String str2) {
        Objects.b(str, "name is required.");
        Objects.b(str2, "version is required.");
        this.f51838b.add(new SentryPackage(str, str2));
    }
}
