package org.slf4j.helpers;

import j$.time.Instant;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class NOPLogger extends MarkerIgnoringBase {

    /* renamed from: a, reason: collision with root package name */
    public static final NOPLogger f57891a = new NOPLogger();

    @Override // org.slf4j.Logger
    public final boolean b() {
        return false;
    }

    @Override // org.slf4j.Logger
    public final void d(String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.Logger
    public final void e(String str, Object... objArr) {
    }

    @Override // org.slf4j.Logger
    public final boolean f() {
        return false;
    }

    @Override // org.slf4j.Logger
    public final void g(String str, Object... objArr) {
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase, org.slf4j.Logger
    public final String getName() {
        return "NOP";
    }

    @Override // org.slf4j.Logger
    public final void i(String str, Object... objArr) {
    }

    @Override // org.slf4j.Logger
    public final void o(String str) {
    }

    @Override // org.slf4j.Logger
    public final void q(String str) {
    }

    @Override // org.slf4j.Logger
    public final void r(String str) {
    }

    @Override // org.slf4j.Logger
    public final void c(String str) {
    }

    @Override // org.slf4j.Logger
    public final void k(Object... objArr) {
    }

    @Override // org.slf4j.Logger
    public final void l(Instant instant) {
    }

    @Override // org.slf4j.Logger
    public final void p(Object... objArr) {
    }

    @Override // org.slf4j.Logger
    public final void a(String str, Exception exc) {
    }

    @Override // org.slf4j.Logger
    public final void j(String str, Exception exc) {
    }

    @Override // org.slf4j.Logger
    public final void m(Object obj, String str) {
    }

    @Override // org.slf4j.Logger
    public final void n(Object obj, String str) {
    }

    @Override // org.slf4j.Logger
    public final void s(Object obj, String str) {
    }

    @Override // org.slf4j.Logger
    public final void t(String str, Exception exc) {
    }

    @Override // org.slf4j.Logger
    public final void h(String str, Object obj, Exception exc) {
    }

    @Override // org.slf4j.Logger
    public final void u(String str, Object obj, Serializable serializable) {
    }
}
