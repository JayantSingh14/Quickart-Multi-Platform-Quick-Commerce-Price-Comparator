package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class ClassDiscriminatorMode {

    /* renamed from: a, reason: collision with root package name */
    public static final ClassDiscriminatorMode f55938a;

    /* renamed from: b, reason: collision with root package name */
    public static final ClassDiscriminatorMode f55939b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ ClassDiscriminatorMode[] f55940c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f55941d;

    static {
        ClassDiscriminatorMode classDiscriminatorMode = new ClassDiscriminatorMode("NONE", 0);
        f55938a = classDiscriminatorMode;
        ClassDiscriminatorMode classDiscriminatorMode2 = new ClassDiscriminatorMode("ALL_JSON_OBJECTS", 1);
        ClassDiscriminatorMode classDiscriminatorMode3 = new ClassDiscriminatorMode("POLYMORPHIC", 2);
        f55939b = classDiscriminatorMode3;
        ClassDiscriminatorMode[] classDiscriminatorModeArr = {classDiscriminatorMode, classDiscriminatorMode2, classDiscriminatorMode3};
        f55940c = classDiscriminatorModeArr;
        f55941d = EnumEntriesKt.a(classDiscriminatorModeArr);
    }

    public static ClassDiscriminatorMode valueOf(String str) {
        return (ClassDiscriminatorMode) Enum.valueOf(ClassDiscriminatorMode.class, str);
    }

    public static ClassDiscriminatorMode[] values() {
        return (ClassDiscriminatorMode[]) f55940c.clone();
    }
}
