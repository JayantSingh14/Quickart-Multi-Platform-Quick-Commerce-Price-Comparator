package in.juspay.widget.qrscanner.com.google.zxing.qrcode.detector;

/* loaded from: classes4.dex */
public final class FinderPatternInfo {

    /* renamed from: a, reason: collision with root package name */
    private final FinderPattern f48970a;

    /* renamed from: b, reason: collision with root package name */
    private final FinderPattern f48971b;

    /* renamed from: c, reason: collision with root package name */
    private final FinderPattern f48972c;

    public FinderPatternInfo(FinderPattern[] finderPatternArr) {
        this.f48970a = finderPatternArr[0];
        this.f48971b = finderPatternArr[1];
        this.f48972c = finderPatternArr[2];
    }

    public FinderPattern getBottomLeft() {
        return this.f48970a;
    }

    public FinderPattern getTopLeft() {
        return this.f48971b;
    }

    public FinderPattern getTopRight() {
        return this.f48972c;
    }
}
