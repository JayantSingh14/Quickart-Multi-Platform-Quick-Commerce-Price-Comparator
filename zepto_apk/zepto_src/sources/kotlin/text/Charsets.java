package kotlin.text;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class Charsets {

    @JvmField
    @NotNull
    public static final Charset UTF_8;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final Charsets f53956a = new Charsets();

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f53957b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile Charset f53958c;

    /* renamed from: d, reason: collision with root package name */
    public static volatile Charset f53959d;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
        UTF_8 = charsetForName;
        Intrinsics.checkNotNullExpressionValue(Charset.forName("UTF-16"), "forName(...)");
        Intrinsics.checkNotNullExpressionValue(Charset.forName("UTF-16BE"), "forName(...)");
        Intrinsics.checkNotNullExpressionValue(Charset.forName("UTF-16LE"), "forName(...)");
        Intrinsics.checkNotNullExpressionValue(Charset.forName("US-ASCII"), "forName(...)");
        Charset charsetForName2 = Charset.forName("ISO-8859-1");
        Intrinsics.checkNotNullExpressionValue(charsetForName2, "forName(...)");
        f53957b = charsetForName2;
    }
}
