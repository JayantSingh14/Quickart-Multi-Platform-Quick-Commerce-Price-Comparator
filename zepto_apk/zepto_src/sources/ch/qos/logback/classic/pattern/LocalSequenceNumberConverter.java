package ch.qos.logback.classic.pattern;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public class LocalSequenceNumberConverter extends ClassicConverter {

    /* renamed from: f, reason: collision with root package name */
    public final AtomicLong f13315f = new AtomicLong(System.currentTimeMillis());

    @Override // ch.qos.logback.core.pattern.Converter
    public final String b(Object obj) {
        return Long.toString(this.f13315f.getAndIncrement());
    }
}
