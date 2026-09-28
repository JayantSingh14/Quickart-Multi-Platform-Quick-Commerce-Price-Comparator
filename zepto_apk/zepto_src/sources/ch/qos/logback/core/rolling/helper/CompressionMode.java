package ch.qos.logback.core.rolling.helper;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class CompressionMode {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CompressionMode[] f13722a = {new CompressionMode("NONE", 0), new CompressionMode("GZ", 1), new CompressionMode("ZIP", 2)};

    /* JADX INFO: Fake field, exist only in values array */
    CompressionMode EF5;

    public static CompressionMode valueOf(String str) {
        return (CompressionMode) Enum.valueOf(CompressionMode.class, str);
    }

    public static CompressionMode[] values() {
        return (CompressionMode[]) f13722a.clone();
    }
}
