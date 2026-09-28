package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class JsonConfiguration {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f55966a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f55967b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f55968c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f55969d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f55970e;

    /* renamed from: f, reason: collision with root package name */
    public final String f55971f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f55972g;

    /* renamed from: h, reason: collision with root package name */
    public final String f55973h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f55974i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f55975j;

    /* renamed from: k, reason: collision with root package name */
    public final ClassDiscriminatorMode f55976k;

    public JsonConfiguration() {
        this(0);
    }

    public final String toString() {
        return "JsonConfiguration(encodeDefaults=" + this.f55966a + ", ignoreUnknownKeys=" + this.f55967b + ", isLenient=" + this.f55968c + ", allowStructuredMapKeys=" + this.f55969d + ", prettyPrint=false, explicitNulls=" + this.f55970e + ", prettyPrintIndent='" + this.f55971f + "', coerceInputValues=" + this.f55972g + ", useArrayPolymorphism=false, classDiscriminator='" + this.f55973h + "', allowSpecialFloatingPointValues=" + this.f55974i + ", useAlternativeNames=" + this.f55975j + ", namingStrategy=null, decodeEnumsCaseInsensitive=false, allowTrailingComma=false, classDiscriminatorMode=" + this.f55976k + ')';
    }

    public JsonConfiguration(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String prettyPrintIndent, boolean z6, String classDiscriminator, boolean z7, boolean z8, ClassDiscriminatorMode classDiscriminatorMode) {
        Intrinsics.checkNotNullParameter(prettyPrintIndent, "prettyPrintIndent");
        Intrinsics.checkNotNullParameter(classDiscriminator, "classDiscriminator");
        Intrinsics.checkNotNullParameter(classDiscriminatorMode, "classDiscriminatorMode");
        this.f55966a = z;
        this.f55967b = z2;
        this.f55968c = z3;
        this.f55969d = z4;
        this.f55970e = z5;
        this.f55971f = prettyPrintIndent;
        this.f55972g = z6;
        this.f55973h = classDiscriminator;
        this.f55974i = z7;
        this.f55975j = z8;
        this.f55976k = classDiscriminatorMode;
    }

    public /* synthetic */ JsonConfiguration(int i2) {
        this(false, false, false, false, true, "    ", false, "type", false, true, ClassDiscriminatorMode.f55939b);
    }
}
