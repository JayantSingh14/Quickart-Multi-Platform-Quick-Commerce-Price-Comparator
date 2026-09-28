package ch.qos.logback.core;

/* loaded from: classes3.dex */
public class LogbackException extends RuntimeException {
    public LogbackException(String str) {
        super(str);
    }

    public LogbackException(String str, Exception exc) {
        super(str, exc);
    }
}
