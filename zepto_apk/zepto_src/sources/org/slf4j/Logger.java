package org.slf4j;

import j$.time.Instant;
import java.io.Serializable;

/* loaded from: classes.dex */
public interface Logger {
    void a(String str, Exception exc);

    boolean b();

    void c(String str);

    void d(String str, Object obj, Object obj2);

    void e(String str, Object... objArr);

    boolean f();

    void g(String str, Object... objArr);

    String getName();

    void h(String str, Object obj, Exception exc);

    void i(String str, Object... objArr);

    void j(String str, Exception exc);

    void k(Object... objArr);

    void l(Instant instant);

    void m(Object obj, String str);

    void n(Object obj, String str);

    void o(String str);

    void p(Object... objArr);

    void q(String str);

    void r(String str);

    void s(Object obj, String str);

    void t(String str, Exception exc);

    void u(String str, Object obj, Serializable serializable);
}
