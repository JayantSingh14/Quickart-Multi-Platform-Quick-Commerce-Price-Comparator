package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import java.util.logging.Logger;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes4.dex */
final class LazyLogger {

    /* renamed from: a, reason: collision with root package name */
    public final String f43460a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Logger f43461b;

    public LazyLogger(Class cls) {
        this.f43460a = cls.getName();
    }

    public final Logger a() {
        Logger logger = this.f43461b;
        if (logger != null) {
            return logger;
        }
        synchronized (this) {
            try {
                Logger logger2 = this.f43461b;
                if (logger2 != null) {
                    return logger2;
                }
                Logger logger3 = Logger.getLogger(this.f43460a);
                this.f43461b = logger3;
                return logger3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
