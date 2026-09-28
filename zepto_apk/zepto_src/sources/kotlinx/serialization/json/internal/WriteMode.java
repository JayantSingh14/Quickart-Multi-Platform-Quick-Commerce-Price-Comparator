package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class WriteMode {

    /* renamed from: c, reason: collision with root package name */
    public static final WriteMode f56108c;

    /* renamed from: d, reason: collision with root package name */
    public static final WriteMode f56109d;

    /* renamed from: e, reason: collision with root package name */
    public static final WriteMode f56110e;

    /* renamed from: f, reason: collision with root package name */
    public static final WriteMode f56111f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ WriteMode[] f56112g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f56113h;

    /* renamed from: a, reason: collision with root package name */
    public final char f56114a;

    /* renamed from: b, reason: collision with root package name */
    public final char f56115b;

    static {
        WriteMode writeMode = new WriteMode("OBJ", 0, '{', '}');
        f56108c = writeMode;
        WriteMode writeMode2 = new WriteMode("LIST", 1, '[', ']');
        f56109d = writeMode2;
        WriteMode writeMode3 = new WriteMode("MAP", 2, '{', '}');
        f56110e = writeMode3;
        WriteMode writeMode4 = new WriteMode("POLY_OBJ", 3, '[', ']');
        f56111f = writeMode4;
        WriteMode[] writeModeArr = {writeMode, writeMode2, writeMode3, writeMode4};
        f56112g = writeModeArr;
        f56113h = EnumEntriesKt.a(writeModeArr);
    }

    public WriteMode(String str, int i2, char c2, char c3) {
        this.f56114a = c2;
        this.f56115b = c3;
    }

    public static WriteMode valueOf(String str) {
        return (WriteMode) Enum.valueOf(WriteMode.class, str);
    }

    public static WriteMode[] values() {
        return (WriteMode[]) f56112g.clone();
    }
}
