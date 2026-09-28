package kotlinx.datetime.internal.format;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.parser.ParserStructure;

@Metadata
/* loaded from: classes3.dex */
public final class CachedFormatStructure<T> extends ConcatenatedFormatStructure<T> {

    /* renamed from: b, reason: collision with root package name */
    public final FormatterStructure f55530b;

    /* renamed from: c, reason: collision with root package name */
    public final ParserStructure f55531c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CachedFormatStructure(ArrayList formats) {
        super(formats);
        Intrinsics.checkNotNullParameter(formats, "formats");
        this.f55530b = super.a();
        this.f55531c = super.b();
    }

    @Override // kotlinx.datetime.internal.format.ConcatenatedFormatStructure, kotlinx.datetime.internal.format.FormatStructure
    public final FormatterStructure a() {
        return this.f55530b;
    }

    @Override // kotlinx.datetime.internal.format.ConcatenatedFormatStructure, kotlinx.datetime.internal.format.FormatStructure
    public final ParserStructure b() {
        return this.f55531c;
    }
}
