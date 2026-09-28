package in.juspay.widget.qrscanner.com.google.zxing;

/* loaded from: classes4.dex */
public final class ChecksumException extends ReaderException {

    /* renamed from: c, reason: collision with root package name */
    private static final ChecksumException f48801c;

    static {
        ChecksumException checksumException = new ChecksumException();
        f48801c = checksumException;
        checksumException.setStackTrace(ReaderException.f48823b);
    }

    private ChecksumException() {
    }

    public static ChecksumException getChecksumInstance() {
        return ReaderException.f48822a ? new ChecksumException() : f48801c;
    }

    private ChecksumException(Throwable th) {
        super(th);
    }

    public static ChecksumException getChecksumInstance(Throwable th) {
        return ReaderException.f48822a ? new ChecksumException(th) : f48801c;
    }
}
