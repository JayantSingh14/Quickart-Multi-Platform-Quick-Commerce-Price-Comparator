package org.slf4j.helpers;

import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

/* loaded from: classes.dex */
public class SubstituteLoggerFactory implements ILoggerFactory {

    /* renamed from: a, reason: collision with root package name */
    public boolean f57899a = false;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f57900b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final LinkedBlockingQueue f57901c = new LinkedBlockingQueue();

    @Override // org.slf4j.ILoggerFactory
    public final synchronized Logger c(String str) {
        SubstituteLogger substituteLogger;
        substituteLogger = (SubstituteLogger) this.f57900b.get(str);
        if (substituteLogger == null) {
            substituteLogger = new SubstituteLogger(str, this.f57901c, this.f57899a);
            this.f57900b.put(str, substituteLogger);
        }
        return substituteLogger;
    }
}
