package ch.qos.logback.core.status;

/* loaded from: classes3.dex */
public class WarnStatus extends StatusBase {
    public WarnStatus(String str, Object obj, Exception exc) {
        super(1, str, obj, exc);
    }

    public WarnStatus(String str, Object obj) {
        super(1, str, obj, null);
    }
}
