package ch.qos.logback.core.pattern.parser;

import ch.qos.logback.core.pattern.Converter;
import ch.qos.logback.core.spi.ContextAwareBase;
import java.util.HashMap;

/* loaded from: classes3.dex */
class Compiler<E> extends ContextAwareBase {

    /* renamed from: d, reason: collision with root package name */
    public Converter f13665d;

    /* renamed from: e, reason: collision with root package name */
    public Converter f13666e;

    /* renamed from: f, reason: collision with root package name */
    public final Node f13667f;

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f13668g;

    public Compiler(Node node, HashMap map) {
        this.f13667f = node;
        this.f13668g = map;
    }

    public final void T1(Converter converter) {
        if (this.f13665d == null) {
            this.f13666e = converter;
            this.f13665d = converter;
            return;
        }
        Converter converter2 = this.f13666e;
        if (converter2.f13648a != null) {
            throw new IllegalStateException("Next converter has been already set");
        }
        converter2.f13648a = converter;
        this.f13666e = converter;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ch.qos.logback.core.pattern.Converter U1() {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ch.qos.logback.core.pattern.parser.Compiler.U1():ch.qos.logback.core.pattern.Converter");
    }
}
