package co.touchlab.kermit;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class Severity {

    /* renamed from: a, reason: collision with root package name */
    public static final Severity f13849a;

    /* renamed from: b, reason: collision with root package name */
    public static final Severity f13850b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ Severity[] f13851c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f13852d;

    static {
        Severity severity = new Severity("Verbose", 0);
        f13849a = severity;
        Severity severity2 = new Severity("Debug", 1);
        Severity severity3 = new Severity("Info", 2);
        f13850b = severity3;
        Severity[] severityArr = {severity, severity2, severity3, new Severity("Warn", 3), new Severity("Error", 4), new Severity("Assert", 5)};
        f13851c = severityArr;
        f13852d = EnumEntriesKt.a(severityArr);
    }

    public static Severity valueOf(String str) {
        return (Severity) Enum.valueOf(Severity.class, str);
    }

    public static Severity[] values() {
        return (Severity[]) f13851c.clone();
    }
}
