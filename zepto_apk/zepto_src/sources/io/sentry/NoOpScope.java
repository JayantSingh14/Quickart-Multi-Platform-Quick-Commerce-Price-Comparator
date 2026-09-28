package io.sentry;

import io.sentry.Scope;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.Request;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.User;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* loaded from: classes3.dex */
public final class NoOpScope implements IScope {

    /* renamed from: a, reason: collision with root package name */
    public static final NoOpScope f51710a;

    static {
        NoOpScope noOpScope = new NoOpScope();
        SentryOptions.empty();
        f51710a = noOpScope;
    }

    @Override // io.sentry.IScope
    public final PropagationContext A() {
        return new PropagationContext();
    }

    @Override // io.sentry.IScope
    public final void B(String str) {
    }

    @Override // io.sentry.IScope
    public final List C() {
        return new ArrayList();
    }

    @Override // io.sentry.IScope
    public final void D() {
    }

    @Override // io.sentry.IScope
    public final PropagationContext E(Scope.IWithPropagationContext iWithPropagationContext) {
        return new PropagationContext();
    }

    @Override // io.sentry.IScope
    public final void F(Scope.IWithTransaction iWithTransaction) {
    }

    @Override // io.sentry.IScope
    public final List G() {
        return new ArrayList();
    }

    @Override // io.sentry.IScope
    public final void H(PropagationContext propagationContext) {
    }

    @Override // io.sentry.IScope
    public final SentryLevel a() {
        return null;
    }

    @Override // io.sentry.IScope
    public final void b(Breadcrumb breadcrumb, Hint hint) {
    }

    @Override // io.sentry.IScope
    public final void c(User user) {
    }

    @Override // io.sentry.IScope
    public final void clear() {
    }

    @Override // io.sentry.IScope
    public final IScope clone() {
        return f51710a;
    }

    @Override // io.sentry.IScope
    public final void d(Breadcrumb breadcrumb) {
    }

    @Override // io.sentry.IScope
    public final void e(String str, String str2) {
    }

    @Override // io.sentry.IScope
    public final void f(String str, String str2) {
    }

    @Override // io.sentry.IScope
    public final void g(SentryId sentryId) {
    }

    @Override // io.sentry.IScope
    public final Map getExtras() {
        return new HashMap();
    }

    @Override // io.sentry.IScope
    public final Request getRequest() {
        return null;
    }

    @Override // io.sentry.IScope
    public final ISpan h() {
        return null;
    }

    @Override // io.sentry.IScope
    public final Queue i() {
        return new ArrayDeque();
    }

    @Override // io.sentry.IScope
    public final ITransaction j() {
        return null;
    }

    @Override // io.sentry.IScope
    public final String k() {
        return null;
    }

    @Override // io.sentry.IScope
    public final Session l() {
        return null;
    }

    @Override // io.sentry.IScope
    public final Session m(Scope.IWithSession iWithSession) {
        return null;
    }

    @Override // io.sentry.IScope
    public final Map n() {
        return new HashMap();
    }

    @Override // io.sentry.IScope
    public final void o() {
    }

    @Override // io.sentry.IScope
    public final Scope.SessionPair p() {
        return null;
    }

    @Override // io.sentry.IScope
    public final Contexts q() {
        return new Contexts();
    }

    @Override // io.sentry.IScope
    public final void r(ITransaction iTransaction) {
    }

    @Override // io.sentry.IScope
    public final List s() {
        return new ArrayList();
    }

    @Override // io.sentry.IScope
    public final User t() {
        return null;
    }

    @Override // io.sentry.IScope
    public final String v() {
        return null;
    }

    @Override // io.sentry.IScope
    public final void w() {
    }

    @Override // io.sentry.IScope
    public final void x(String str) {
    }

    @Override // io.sentry.IScope
    public final Session y() {
        return null;
    }

    @Override // io.sentry.IScope
    public final SentryId z() {
        return SentryId.f52907b;
    }

    /* renamed from: clone, reason: collision with other method in class */
    public final Object m70clone() {
        return f51710a;
    }

    @Override // io.sentry.IScope
    public final void u(String str, HashMap map) {
    }
}
