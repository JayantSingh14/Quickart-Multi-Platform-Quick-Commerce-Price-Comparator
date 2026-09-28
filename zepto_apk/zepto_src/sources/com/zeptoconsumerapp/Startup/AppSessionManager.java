package com.zeptoconsumerapp.Startup;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class AppSessionManager {

    /* renamed from: a, reason: collision with root package name */
    public static final AppSessionManager f47556a = new AppSessionManager();

    /* renamed from: b, reason: collision with root package name */
    public static volatile String f47557b;

    public final String a() {
        String str = f47557b;
        if (str == null || str.length() == 0) {
            synchronized (this) {
                try {
                    String str2 = f47557b;
                    if (str2 == null || str2.length() == 0) {
                        f47557b = UUID.randomUUID().toString();
                    }
                    Unit unit = Unit.f53572a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        String str3 = f47557b;
        Intrinsics.c(str3);
        return str3;
    }
}
