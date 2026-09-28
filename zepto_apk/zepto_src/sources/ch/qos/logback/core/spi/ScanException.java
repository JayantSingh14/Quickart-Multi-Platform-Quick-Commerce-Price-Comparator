package ch.qos.logback.core.spi;

/* loaded from: classes.dex */
public class ScanException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public IllegalArgumentException f13743a;

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.f13743a;
    }
}
