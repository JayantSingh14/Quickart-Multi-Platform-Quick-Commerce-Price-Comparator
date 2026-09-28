package in.juspay.widget.qrscanner.com.google.zxing;

/* loaded from: classes4.dex */
public final class NotFoundException extends ReaderException {

    /* renamed from: c, reason: collision with root package name */
    private static final NotFoundException f48811c;

    static {
        NotFoundException notFoundException = new NotFoundException();
        f48811c = notFoundException;
        notFoundException.setStackTrace(ReaderException.f48823b);
    }

    private NotFoundException() {
    }

    public static NotFoundException getNotFoundInstance() {
        return ReaderException.f48822a ? new NotFoundException() : f48811c;
    }
}
