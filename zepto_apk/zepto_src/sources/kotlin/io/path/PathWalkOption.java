package kotlin.io.path;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@SinceKotlin
@Metadata
@WasExperimental
/* loaded from: classes3.dex */
public final class PathWalkOption {

    /* renamed from: a, reason: collision with root package name */
    public static final PathWalkOption f53765a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ PathWalkOption[] f53766b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f53767c;

    static {
        PathWalkOption pathWalkOption = new PathWalkOption("INCLUDE_DIRECTORIES", 0);
        PathWalkOption pathWalkOption2 = new PathWalkOption("BREADTH_FIRST", 1);
        f53765a = pathWalkOption2;
        PathWalkOption[] pathWalkOptionArr = {pathWalkOption, pathWalkOption2, new PathWalkOption("FOLLOW_LINKS", 2)};
        f53766b = pathWalkOptionArr;
        f53767c = EnumEntriesKt.a(pathWalkOptionArr);
    }

    public static PathWalkOption valueOf(String str) {
        return (PathWalkOption) Enum.valueOf(PathWalkOption.class, str);
    }

    public static PathWalkOption[] values() {
        return (PathWalkOption[]) f53766b.clone();
    }
}
