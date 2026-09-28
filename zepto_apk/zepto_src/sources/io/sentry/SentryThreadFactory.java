package io.sentry;

import io.sentry.protocol.SentryStackTrace;
import io.sentry.protocol.SentryThread;
import io.sentry.util.Objects;
import java.util.ArrayList;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class SentryThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final SentryStackTraceFactory f51873a;

    /* renamed from: b, reason: collision with root package name */
    public final SentryOptions f51874b;

    public SentryThreadFactory(SentryStackTraceFactory sentryStackTraceFactory, SentryOptions sentryOptions) {
        this.f51873a = sentryStackTraceFactory;
        Objects.b(sentryOptions, "The SentryOptions is required");
        this.f51874b = sentryOptions;
    }

    public final ArrayList a(Map map, ArrayList arrayList, boolean z) {
        Thread threadCurrentThread = Thread.currentThread();
        if (map.isEmpty()) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        if (!map.containsKey(threadCurrentThread)) {
            map.put(threadCurrentThread, threadCurrentThread.getStackTrace());
        }
        for (Map.Entry entry : map.entrySet()) {
            Thread thread = (Thread) entry.getKey();
            boolean z2 = (thread == threadCurrentThread && !z) || (arrayList != null && arrayList.contains(Long.valueOf(thread.getId())));
            StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) entry.getValue();
            Thread thread2 = (Thread) entry.getKey();
            SentryThread sentryThread = new SentryThread();
            sentryThread.f52948c = thread2.getName();
            sentryThread.f52947b = Integer.valueOf(thread2.getPriority());
            sentryThread.f52946a = Long.valueOf(thread2.getId());
            sentryThread.f52952g = Boolean.valueOf(thread2.isDaemon());
            sentryThread.f52949d = thread2.getState().name();
            sentryThread.f52950e = Boolean.valueOf(z2);
            ArrayList arrayListA = this.f51873a.a(stackTraceElementArr, false);
            if (this.f51874b.isAttachStacktrace() && arrayListA != null && !arrayListA.isEmpty()) {
                SentryStackTrace sentryStackTrace = new SentryStackTrace(arrayListA);
                sentryStackTrace.f52944c = Boolean.TRUE;
                sentryThread.f52954i = sentryStackTrace;
            }
            arrayList2.add(sentryThread);
        }
        return arrayList2;
    }
}
