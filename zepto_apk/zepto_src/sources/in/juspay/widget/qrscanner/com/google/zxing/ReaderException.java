package in.juspay.widget.qrscanner.com.google.zxing;

/* loaded from: classes4.dex */
public abstract class ReaderException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    protected static boolean f48822a;

    /* renamed from: b, reason: collision with root package name */
    protected static final StackTraceElement[] f48823b;

    static {
        f48822a = System.getProperty("surefire.test.class.path") != null;
        f48823b = new StackTraceElement[0];
    }

    public ReaderException() {
    }

    public static void setStackTrace(boolean z) {
        f48822a = z;
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        return null;
    }

    public ReaderException(Throwable th) {
        super(th);
    }
}
