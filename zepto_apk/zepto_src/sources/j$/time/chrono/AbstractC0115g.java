package j$.time.chrono;

/* renamed from: j$.time.chrono.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC0115g {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f53231a;

    static {
        int[] iArr = new int[j$.time.temporal.a.values().length];
        f53231a = iArr;
        try {
            iArr[j$.time.temporal.a.INSTANT_SECONDS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f53231a[j$.time.temporal.a.OFFSET_SECONDS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
