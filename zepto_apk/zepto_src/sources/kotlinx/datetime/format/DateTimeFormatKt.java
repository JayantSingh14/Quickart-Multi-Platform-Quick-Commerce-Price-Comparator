package kotlinx.datetime.format;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class DateTimeFormatKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Lazy f55409a = LazyKt.b(DateTimeFormatKt$allFormatConstants$2.f55410c);

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[Padding.values().length];
            try {
                Padding padding = Padding.f55478a;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Padding padding2 = Padding.f55478a;
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Padding padding3 = Padding.f55478a;
                iArr[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
