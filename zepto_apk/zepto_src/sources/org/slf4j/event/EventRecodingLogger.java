package org.slf4j.event;

import j$.time.Instant;
import java.io.Serializable;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.Logger;
import org.slf4j.helpers.SubstituteLogger;

/* loaded from: classes5.dex */
public class EventRecodingLogger implements Logger {

    /* renamed from: a, reason: collision with root package name */
    public String f57878a;

    /* renamed from: b, reason: collision with root package name */
    public SubstituteLogger f57879b;

    /* renamed from: c, reason: collision with root package name */
    public LinkedBlockingQueue f57880c;

    @Override // org.slf4j.Logger
    public final void a(String str, Exception exc) {
        v(null);
    }

    @Override // org.slf4j.Logger
    public final boolean b() {
        return true;
    }

    @Override // org.slf4j.Logger
    public final void c(String str) {
        v(new Object[]{str});
    }

    @Override // org.slf4j.Logger
    public final void d(String str, Object obj, Object obj2) {
        w(obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void e(String str, Object... objArr) {
        x(objArr);
    }

    @Override // org.slf4j.Logger
    public final boolean f() {
        return true;
    }

    @Override // org.slf4j.Logger
    public final void g(String str, Object... objArr) {
        x(objArr);
    }

    @Override // org.slf4j.Logger
    public final String getName() {
        return this.f57878a;
    }

    @Override // org.slf4j.Logger
    public final void h(String str, Object obj, Exception exc) {
        w(obj, exc);
    }

    @Override // org.slf4j.Logger
    public final void i(String str, Object... objArr) {
        x(objArr);
    }

    @Override // org.slf4j.Logger
    public final void j(String str, Exception exc) {
        v(null);
    }

    @Override // org.slf4j.Logger
    public final void k(Object... objArr) {
        x(objArr);
    }

    @Override // org.slf4j.Logger
    public final void l(Instant instant) {
        v(new Object[]{instant});
    }

    @Override // org.slf4j.Logger
    public final void m(Object obj, String str) {
        v(new Object[]{obj});
    }

    @Override // org.slf4j.Logger
    public final void n(Object obj, String str) {
        v(new Object[]{obj});
    }

    @Override // org.slf4j.Logger
    public final void o(String str) {
        v(null);
    }

    @Override // org.slf4j.Logger
    public final void p(Object... objArr) {
        x(objArr);
    }

    @Override // org.slf4j.Logger
    public final void q(String str) {
        v(null);
    }

    @Override // org.slf4j.Logger
    public final void r(String str) {
        v(null);
    }

    @Override // org.slf4j.Logger
    public final void s(Object obj, String str) {
        v(new Object[]{obj});
    }

    @Override // org.slf4j.Logger
    public final void t(String str, Exception exc) {
        v(null);
    }

    @Override // org.slf4j.Logger
    public final void u(String str, Object obj, Serializable serializable) {
        w(obj, serializable);
    }

    public final void v(Object[] objArr) {
        SubstituteLoggingEvent substituteLoggingEvent = new SubstituteLoggingEvent();
        System.currentTimeMillis();
        substituteLoggingEvent.f57883a = this.f57879b;
        Thread.currentThread().getName();
        substituteLoggingEvent.f57884b = objArr;
        this.f57880c.add(substituteLoggingEvent);
    }

    public final void w(Object obj, Object obj2) {
        if (obj2 instanceof Throwable) {
            v(new Object[]{obj});
        } else {
            v(new Object[]{obj, obj2});
        }
    }

    public final void x(Object[] objArr) {
        Throwable th = null;
        if (objArr.length != 0) {
            Object obj = objArr[objArr.length - 1];
            if (obj instanceof Throwable) {
                th = (Throwable) obj;
            }
        }
        if (th == null) {
            v(objArr);
            return;
        }
        if (objArr.length == 0) {
            throw new IllegalStateException("non-sensical empty or null argument array");
        }
        int length = objArr.length - 1;
        Object[] objArr2 = new Object[length];
        if (length > 0) {
            System.arraycopy(objArr, 0, objArr2, 0, length);
        }
        v(objArr2);
    }
}
