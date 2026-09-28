package javax.annotation.meta;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class When {

    /* renamed from: a, reason: collision with root package name */
    public static final When f53505a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ When[] f53506b;

    static {
        When when = new When("ALWAYS", 0);
        f53505a = when;
        f53506b = new When[]{when, new When("UNKNOWN", 1), new When("MAYBE", 2), new When("NEVER", 3)};
    }

    public static When valueOf(String str) {
        return (When) Enum.valueOf(When.class, str);
    }

    public static When[] values() {
        return (When[]) f53506b.clone();
    }
}
