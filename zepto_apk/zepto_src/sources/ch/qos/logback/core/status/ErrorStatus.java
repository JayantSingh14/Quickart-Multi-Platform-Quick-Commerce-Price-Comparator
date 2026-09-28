package ch.qos.logback.core.status;

/* loaded from: classes3.dex */
public class ErrorStatus extends StatusBase {
    public ErrorStatus(String str, Object obj, Throwable th) {
        super(2, str, obj, th);
    }

    public ErrorStatus(String str, Object obj) {
        super(2, str, obj, null);
    }
}
