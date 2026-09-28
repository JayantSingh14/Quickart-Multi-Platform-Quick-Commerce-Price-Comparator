package io.sentry;

import java.util.concurrent.ConcurrentHashMap;
import okio.Path;

/* loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static String a(Path path, String str) {
        return str + path;
    }

    public static void b(ConcurrentHashMap concurrentHashMap, String str, ObjectWriter objectWriter, String str2, ILogger iLogger) {
        Object obj = concurrentHashMap.get(str);
        objectWriter.d(str2);
        objectWriter.h(iLogger, obj);
    }
}
