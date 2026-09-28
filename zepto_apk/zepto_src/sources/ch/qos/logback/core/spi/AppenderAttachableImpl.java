package ch.qos.logback.core.spi;

import ch.qos.logback.core.Appender;
import ch.qos.logback.core.util.COWArrayList;

/* loaded from: classes.dex */
public class AppenderAttachableImpl<E> implements AppenderAttachable<E> {

    /* renamed from: a, reason: collision with root package name */
    public final COWArrayList f13731a = new COWArrayList(new Appender[0]);

    static {
        System.currentTimeMillis();
    }

    public final int a(Object obj) {
        COWArrayList cOWArrayList = this.f13731a;
        cOWArrayList.d();
        int i2 = 0;
        for (Appender appender : (Appender[]) cOWArrayList.f13798c) {
            appender.A(obj);
            i2++;
        }
        return i2;
    }

    @Override // ch.qos.logback.core.spi.AppenderAttachable
    public final void r0(Appender appender) {
        COWArrayList cOWArrayList = this.f13731a;
        cOWArrayList.f13797b.addIfAbsent(appender);
        cOWArrayList.b();
    }
}
