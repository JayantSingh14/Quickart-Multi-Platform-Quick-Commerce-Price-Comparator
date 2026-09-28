package in.juspay.widget.qrscanner.com.google.zxing;

/* loaded from: classes4.dex */
public final class FormatException extends ReaderException {

    /* renamed from: c, reason: collision with root package name */
    private static final FormatException f48805c;

    static {
        FormatException formatException = new FormatException();
        f48805c = formatException;
        formatException.setStackTrace(ReaderException.f48823b);
    }

    private FormatException() {
    }

    public static FormatException getFormatInstance() {
        return ReaderException.f48822a ? new FormatException() : f48805c;
    }

    private FormatException(Throwable th) {
        super(th);
    }

    public static FormatException getFormatInstance(Throwable th) {
        return ReaderException.f48822a ? new FormatException(th) : f48805c;
    }
}
