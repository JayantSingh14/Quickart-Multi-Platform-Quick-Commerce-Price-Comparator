package org.slf4j.helpers;

import j$.time.Instant;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.Logger;
import org.slf4j.event.EventRecodingLogger;
import org.slf4j.event.LoggingEvent;
import org.slf4j.event.SubstituteLoggingEvent;

/* loaded from: classes5.dex */
public class SubstituteLogger implements Logger {

    /* renamed from: a, reason: collision with root package name */
    public final String f57892a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Logger f57893b;

    /* renamed from: c, reason: collision with root package name */
    public Boolean f57894c;

    /* renamed from: d, reason: collision with root package name */
    public Method f57895d;

    /* renamed from: e, reason: collision with root package name */
    public EventRecodingLogger f57896e;

    /* renamed from: f, reason: collision with root package name */
    public final LinkedBlockingQueue f57897f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f57898g;

    public SubstituteLogger(String str, LinkedBlockingQueue linkedBlockingQueue, boolean z) {
        this.f57892a = str;
        this.f57897f = linkedBlockingQueue;
        this.f57898g = z;
    }

    public final void A(Logger logger) {
        this.f57893b = logger;
    }

    @Override // org.slf4j.Logger
    public final void a(String str, Exception exc) {
        v().a(str, exc);
    }

    @Override // org.slf4j.Logger
    public final boolean b() {
        return v().b();
    }

    @Override // org.slf4j.Logger
    public final void c(String str) {
        v().c(str);
    }

    @Override // org.slf4j.Logger
    public final void d(String str, Object obj, Object obj2) {
        v().d(str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void e(String str, Object... objArr) {
        v().e(str, objArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f57892a.equals(((SubstituteLogger) obj).f57892a);
    }

    @Override // org.slf4j.Logger
    public final boolean f() {
        return v().f();
    }

    @Override // org.slf4j.Logger
    public final void g(String str, Object... objArr) {
        v().g(str, objArr);
    }

    @Override // org.slf4j.Logger
    public final String getName() {
        return this.f57892a;
    }

    @Override // org.slf4j.Logger
    public final void h(String str, Object obj, Exception exc) {
        v().h(str, obj, exc);
    }

    public final int hashCode() {
        return this.f57892a.hashCode();
    }

    @Override // org.slf4j.Logger
    public final void i(String str, Object... objArr) {
        v().i(str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void j(String str, Exception exc) {
        v().j(str, exc);
    }

    @Override // org.slf4j.Logger
    public final void k(Object... objArr) {
        v().k(objArr);
    }

    @Override // org.slf4j.Logger
    public final void l(Instant instant) {
        v().l(instant);
    }

    @Override // org.slf4j.Logger
    public final void m(Object obj, String str) {
        v().m(obj, str);
    }

    @Override // org.slf4j.Logger
    public final void n(Object obj, String str) {
        v().n(obj, str);
    }

    @Override // org.slf4j.Logger
    public final void o(String str) {
        v().o(str);
    }

    @Override // org.slf4j.Logger
    public final void p(Object... objArr) {
        v().p(objArr);
    }

    @Override // org.slf4j.Logger
    public final void q(String str) {
        v().q(str);
    }

    @Override // org.slf4j.Logger
    public final void r(String str) {
        v().r(str);
    }

    @Override // org.slf4j.Logger
    public final void s(Object obj, String str) {
        v().s(obj, str);
    }

    @Override // org.slf4j.Logger
    public final void t(String str, Exception exc) {
        v().t(str, exc);
    }

    @Override // org.slf4j.Logger
    public final void u(String str, Object obj, Serializable serializable) {
        v().u(str, obj, serializable);
    }

    public final Logger v() {
        if (this.f57893b != null) {
            return this.f57893b;
        }
        if (this.f57898g) {
            return NOPLogger.f57891a;
        }
        if (this.f57896e == null) {
            EventRecodingLogger eventRecodingLogger = new EventRecodingLogger();
            eventRecodingLogger.f57879b = this;
            eventRecodingLogger.f57878a = this.f57892a;
            eventRecodingLogger.f57880c = this.f57897f;
            this.f57896e = eventRecodingLogger;
        }
        return this.f57896e;
    }

    public final boolean w() {
        Boolean bool = this.f57894c;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.f57895d = this.f57893b.getClass().getMethod("log", LoggingEvent.class);
            this.f57894c = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.f57894c = Boolean.FALSE;
        }
        return this.f57894c.booleanValue();
    }

    public final boolean x() {
        return this.f57893b instanceof NOPLogger;
    }

    public final boolean y() {
        return this.f57893b == null;
    }

    public final void z(SubstituteLoggingEvent substituteLoggingEvent) {
        if (w()) {
            try {
                this.f57895d.invoke(this.f57893b, substituteLoggingEvent);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }
}
