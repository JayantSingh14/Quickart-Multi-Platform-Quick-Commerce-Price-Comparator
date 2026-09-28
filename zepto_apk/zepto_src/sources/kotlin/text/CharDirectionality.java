package kotlin.text;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class CharDirectionality {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Companion f53951b;

    /* renamed from: c, reason: collision with root package name */
    public static final Lazy f53952c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ CharDirectionality[] f53953d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f53954e;

    /* renamed from: a, reason: collision with root package name */
    public final int f53955a;

    /* JADX WARN: Type inference failed for: r0v9, types: [kotlin.text.CharDirectionality$Companion] */
    static {
        CharDirectionality[] charDirectionalityArr = {new CharDirectionality("UNDEFINED", 0, -1), new CharDirectionality("LEFT_TO_RIGHT", 1, 0), new CharDirectionality("RIGHT_TO_LEFT", 2, 1), new CharDirectionality("RIGHT_TO_LEFT_ARABIC", 3, 2), new CharDirectionality("EUROPEAN_NUMBER", 4, 3), new CharDirectionality("EUROPEAN_NUMBER_SEPARATOR", 5, 4), new CharDirectionality("EUROPEAN_NUMBER_TERMINATOR", 6, 5), new CharDirectionality("ARABIC_NUMBER", 7, 6), new CharDirectionality("COMMON_NUMBER_SEPARATOR", 8, 7), new CharDirectionality("NONSPACING_MARK", 9, 8), new CharDirectionality("BOUNDARY_NEUTRAL", 10, 9), new CharDirectionality("PARAGRAPH_SEPARATOR", 11, 10), new CharDirectionality("SEGMENT_SEPARATOR", 12, 11), new CharDirectionality("WHITESPACE", 13, 12), new CharDirectionality("OTHER_NEUTRALS", 14, 13), new CharDirectionality("LEFT_TO_RIGHT_EMBEDDING", 15, 14), new CharDirectionality("LEFT_TO_RIGHT_OVERRIDE", 16, 15), new CharDirectionality("RIGHT_TO_LEFT_EMBEDDING", 17, 16), new CharDirectionality("RIGHT_TO_LEFT_OVERRIDE", 18, 17), new CharDirectionality("POP_DIRECTIONAL_FORMAT", 19, 18)};
        f53953d = charDirectionalityArr;
        f53954e = EnumEntriesKt.a(charDirectionalityArr);
        f53951b = new Object(null) { // from class: kotlin.text.CharDirectionality.Companion
        };
        f53952c = LazyKt.b(new coil3.decode.b(16));
    }

    public CharDirectionality(String str, int i2, int i3) {
        this.f53955a = i3;
    }

    public static CharDirectionality valueOf(String str) {
        return (CharDirectionality) Enum.valueOf(CharDirectionality.class, str);
    }

    public static CharDirectionality[] values() {
        return (CharDirectionality[]) f53953d.clone();
    }
}
