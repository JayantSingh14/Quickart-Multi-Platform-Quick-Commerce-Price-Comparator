package io.sentry;

import io.sentry.Scope;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.Request;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* loaded from: classes.dex */
public interface IScope {
    PropagationContext A();

    void B(String str);

    List C();

    void D();

    PropagationContext E(Scope.IWithPropagationContext iWithPropagationContext);

    void F(Scope.IWithTransaction iWithTransaction);

    List G();

    void H(PropagationContext propagationContext);

    SentryLevel a();

    void b(Breadcrumb breadcrumb, Hint hint);

    void c(User user);

    void clear();

    IScope clone();

    void d(Breadcrumb breadcrumb);

    void e(String str, String str2);

    void f(String str, String str2);

    void g(SentryId sentryId);

    Map getExtras();

    Request getRequest();

    ISpan h();

    Queue i();

    ITransaction j();

    String k();

    Session l();

    Session m(Scope.IWithSession iWithSession);

    Map n();

    void o();

    Scope.SessionPair p();

    Contexts q();

    void r(ITransaction iTransaction);

    List s();

    User t();

    void u(String str, HashMap map);

    String v();

    void w();

    void x(String str);

    Session y();

    SentryId z();
}
