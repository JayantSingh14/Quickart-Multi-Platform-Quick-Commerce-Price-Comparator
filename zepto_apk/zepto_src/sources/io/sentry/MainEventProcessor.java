package io.sentry;

import io.sentry.exception.ExceptionMechanismException;
import io.sentry.hints.AbnormalExit;
import io.sentry.hints.Cached;
import io.sentry.protocol.DebugImage;
import io.sentry.protocol.DebugMeta;
import io.sentry.protocol.Mechanism;
import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryException;
import io.sentry.protocol.SentryTransaction;
import io.sentry.protocol.User;
import io.sentry.util.CollectionUtils;
import io.sentry.util.HintUtils;
import io.sentry.util.Objects;
import java.io.Closeable;
import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class MainEventProcessor implements EventProcessor, Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final SentryOptions f51676a;

    /* renamed from: b, reason: collision with root package name */
    public final SentryThreadFactory f51677b;

    /* renamed from: c, reason: collision with root package name */
    public final SentryExceptionFactory f51678c;

    /* renamed from: d, reason: collision with root package name */
    public volatile HostnameCache f51679d = null;

    public MainEventProcessor(SentryOptions sentryOptions) {
        Objects.b(sentryOptions, "The SentryOptions is required.");
        this.f51676a = sentryOptions;
        SentryStackTraceFactory sentryStackTraceFactory = new SentryStackTraceFactory(sentryOptions);
        this.f51678c = new SentryExceptionFactory(sentryStackTraceFactory);
        this.f51677b = new SentryThreadFactory(sentryStackTraceFactory, sentryOptions);
    }

    @Override // io.sentry.EventProcessor
    public final SentryReplayEvent a(SentryReplayEvent sentryReplayEvent, Hint hint) {
        if (sentryReplayEvent.f51798h == null) {
            sentryReplayEvent.f51798h = "java";
        }
        if (r(sentryReplayEvent, hint)) {
            e(sentryReplayEvent);
            SdkVersion sdkVersion = this.f51676a.getSessionReplay().f51869m;
            if (sdkVersion != null) {
                sentryReplayEvent.f51793c = sdkVersion;
            }
        }
        return sentryReplayEvent;
    }

    @Override // io.sentry.EventProcessor
    public final SentryEvent b(SentryEvent sentryEvent, Hint hint) {
        ArrayList arrayList;
        Thread threadCurrentThread;
        Mechanism mechanism;
        boolean zD;
        if (sentryEvent.f51798h == null) {
            sentryEvent.f51798h = "java";
        }
        Throwable cause = sentryEvent.f51800j;
        if (cause != null) {
            SentryExceptionFactory sentryExceptionFactory = this.f51678c;
            sentryExceptionFactory.getClass();
            ArrayDeque arrayDeque = new ArrayDeque();
            HashSet hashSet = new HashSet();
            while (cause != null && hashSet.add(cause)) {
                if (cause instanceof ExceptionMechanismException) {
                    ExceptionMechanismException exceptionMechanismException = (ExceptionMechanismException) cause;
                    Mechanism mechanismA = exceptionMechanismException.a();
                    Throwable thC = exceptionMechanismException.c();
                    threadCurrentThread = exceptionMechanismException.b();
                    zD = exceptionMechanismException.d();
                    cause = thC;
                    mechanism = mechanismA;
                } else {
                    threadCurrentThread = Thread.currentThread();
                    mechanism = null;
                    zD = false;
                }
                arrayDeque.addFirst(SentryExceptionFactory.a(cause, mechanism, Long.valueOf(threadCurrentThread.getId()), sentryExceptionFactory.f51832a.a(cause.getStackTrace(), mechanism != null && Boolean.FALSE.equals(mechanism.f52851d)), zD));
                cause = cause.getCause();
            }
            sentryEvent.g(new ArrayList(arrayDeque));
        }
        l(sentryEvent);
        SentryOptions sentryOptions = this.f51676a;
        Map mapA = sentryOptions.getModulesLoader().a();
        if (mapA != null) {
            AbstractMap abstractMap = sentryEvent.y;
            if (abstractMap == null) {
                sentryEvent.y = CollectionUtils.d(mapA);
            } else {
                abstractMap.putAll(mapA);
            }
        }
        if (r(sentryEvent, hint)) {
            e(sentryEvent);
            if (sentryEvent.d() == null) {
                ArrayList arrayListC = sentryEvent.c();
                if (arrayListC == null || arrayListC.isEmpty()) {
                    arrayList = null;
                } else {
                    Iterator it = arrayListC.iterator();
                    arrayList = null;
                    while (it.hasNext()) {
                        SentryException sentryException = (SentryException) it.next();
                        if (sentryException.f52905f != null && sentryException.f52903d != null) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(sentryException.f52903d);
                        }
                    }
                }
                boolean zIsAttachThreads = sentryOptions.isAttachThreads();
                SentryThreadFactory sentryThreadFactory = this.f51677b;
                if (zIsAttachThreads || AbnormalExit.class.isInstance(HintUtils.b(hint))) {
                    Object objB = HintUtils.b(hint);
                    boolean zF = objB instanceof AbnormalExit ? ((AbnormalExit) objB).f() : false;
                    sentryThreadFactory.getClass();
                    sentryEvent.h(sentryThreadFactory.a(Thread.getAllStackTraces(), arrayList, zF));
                } else if (sentryOptions.isAttachStacktrace() && ((arrayListC == null || arrayListC.isEmpty()) && !Cached.class.isInstance(HintUtils.b(hint)))) {
                    sentryThreadFactory.getClass();
                    HashMap map = new HashMap();
                    Thread threadCurrentThread2 = Thread.currentThread();
                    map.put(threadCurrentThread2, threadCurrentThread2.getStackTrace());
                    sentryEvent.h(sentryThreadFactory.a(map, null, false));
                    return sentryEvent;
                }
            }
        }
        return sentryEvent;
    }

    @Override // io.sentry.EventProcessor
    public final SentryTransaction c(SentryTransaction sentryTransaction, Hint hint) {
        if (sentryTransaction.f51798h == null) {
            sentryTransaction.f51798h = "java";
        }
        l(sentryTransaction);
        if (r(sentryTransaction, hint)) {
            e(sentryTransaction);
        }
        return sentryTransaction;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f51679d != null) {
            this.f51679d.a();
        }
    }

    public final void e(SentryBaseEvent sentryBaseEvent) {
        if (sentryBaseEvent.f51796f == null) {
            sentryBaseEvent.f51796f = this.f51676a.getRelease();
        }
        if (sentryBaseEvent.f51797g == null) {
            sentryBaseEvent.f51797g = this.f51676a.getEnvironment();
        }
        if (sentryBaseEvent.f51801k == null) {
            sentryBaseEvent.f51801k = this.f51676a.getServerName();
        }
        if (this.f51676a.isAttachServerName() && sentryBaseEvent.f51801k == null) {
            if (this.f51679d == null) {
                synchronized (this) {
                    try {
                        if (this.f51679d == null) {
                            this.f51679d = HostnameCache.c();
                        }
                    } finally {
                    }
                }
            }
            if (this.f51679d != null) {
                sentryBaseEvent.f51801k = this.f51679d.b();
            }
        }
        if (sentryBaseEvent.f51802l == null) {
            sentryBaseEvent.f51802l = this.f51676a.getDist();
        }
        if (sentryBaseEvent.f51793c == null) {
            sentryBaseEvent.f51793c = this.f51676a.getSdkVersion();
        }
        AbstractMap abstractMap = sentryBaseEvent.f51795e;
        SentryOptions sentryOptions = this.f51676a;
        if (abstractMap == null) {
            sentryBaseEvent.f51795e = CollectionUtils.d(new HashMap(sentryOptions.getTags()));
        } else {
            for (Map.Entry<String, String> entry : sentryOptions.getTags().entrySet()) {
                if (!sentryBaseEvent.f51795e.containsKey(entry.getKey())) {
                    sentryBaseEvent.b(entry.getKey(), entry.getValue());
                }
            }
        }
        User user = sentryBaseEvent.f51799i;
        if (user == null) {
            user = new User();
            sentryBaseEvent.f51799i = user;
        }
        if (user.f52963e == null && this.f51676a.isSendDefaultPii()) {
            user.f52963e = "{{auto}}";
        }
    }

    public final void l(SentryBaseEvent sentryBaseEvent) {
        ArrayList arrayList = new ArrayList();
        SentryOptions sentryOptions = this.f51676a;
        if (sentryOptions.getProguardUuid() != null) {
            DebugImage debugImage = new DebugImage();
            debugImage.setType(DebugImage.PROGUARD);
            debugImage.setUuid(sentryOptions.getProguardUuid());
            arrayList.add(debugImage);
        }
        for (String str : sentryOptions.getBundleIds()) {
            DebugImage debugImage2 = new DebugImage();
            debugImage2.setType(DebugImage.JVM);
            debugImage2.setDebugId(str);
            arrayList.add(debugImage2);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        DebugMeta debugMeta = sentryBaseEvent.n;
        if (debugMeta == null) {
            debugMeta = new DebugMeta();
        }
        List list = debugMeta.f52816b;
        if (list == null) {
            debugMeta.f52816b = new ArrayList(arrayList);
        } else {
            list.addAll(arrayList);
        }
        sentryBaseEvent.n = debugMeta;
    }

    public final boolean r(SentryBaseEvent sentryBaseEvent, Hint hint) {
        if (HintUtils.e(hint)) {
            return true;
        }
        this.f51676a.getLogger().c(SentryLevel.DEBUG, "Event was cached so not applying data relevant to the current app execution/version: %s", sentryBaseEvent.f51791a);
        return false;
    }
}
