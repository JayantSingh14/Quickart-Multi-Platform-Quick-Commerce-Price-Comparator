package kotlinx.datetime.format;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class UtcOffsetFormatKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Lazy f55497a = LazyKt.b(UtcOffsetFormatKt$ISO_OFFSET$2.f55503c);

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f55498b = LazyKt.b(UtcOffsetFormatKt$ISO_OFFSET_BASIC$2.f55509c);

    /* renamed from: c, reason: collision with root package name */
    public static final Lazy f55499c = LazyKt.b(UtcOffsetFormatKt$FOUR_DIGIT_OFFSET$2.f55501c);

    /* renamed from: d, reason: collision with root package name */
    public static final IncompleteUtcOffset f55500d = new IncompleteUtcOffset(null, null, null, null);

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[WhenToOutput.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                WhenToOutput[] whenToOutputArr = WhenToOutput.f55519a;
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                WhenToOutput[] whenToOutputArr2 = WhenToOutput.f55519a;
                iArr[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
