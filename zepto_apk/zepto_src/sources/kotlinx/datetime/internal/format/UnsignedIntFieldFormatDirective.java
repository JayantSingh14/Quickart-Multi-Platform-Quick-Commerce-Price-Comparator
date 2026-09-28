package kotlinx.datetime.internal.format;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.formatter.SpacePaddedFormatter;
import kotlinx.datetime.internal.format.formatter.UnsignedIntFormatterStructure;
import kotlinx.datetime.internal.format.parser.ParserOperationKt;
import kotlinx.datetime.internal.format.parser.ParserStructure;

@Metadata
/* loaded from: classes3.dex */
public abstract class UnsignedIntFieldFormatDirective<Target> implements FieldFormatDirective<Target> {

    /* renamed from: a, reason: collision with root package name */
    public final UnsignedFieldSpec f55570a;

    /* renamed from: b, reason: collision with root package name */
    public final int f55571b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f55572c;

    /* renamed from: d, reason: collision with root package name */
    public final int f55573d;

    public UnsignedIntFieldFormatDirective(UnsignedFieldSpec field, int i2, Integer num) {
        Intrinsics.checkNotNullParameter(field, "field");
        this.f55570a = field;
        this.f55571b = i2;
        this.f55572c = num;
        int i3 = field.f55569g;
        this.f55573d = i3;
        if (i2 < 0) {
            throw new IllegalArgumentException(b.g(i2, "The minimum number of digits (", ") is negative").toString());
        }
        if (i3 < i2) {
            throw new IllegalArgumentException(("The maximum number of digits (" + i3 + ") is less than the minimum number of digits (" + i2 + ')').toString());
        }
        if (num == null || num.intValue() > i2) {
            return;
        }
        throw new IllegalArgumentException(("The space padding (" + num + ") should be more than the minimum number of digits (" + i2 + ')').toString());
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public final FormatterStructure a() {
        UnsignedIntFormatterStructure unsignedIntFormatterStructure = new UnsignedIntFormatterStructure(this.f55571b, new UnsignedIntFieldFormatDirective$formatter$formatter$1(1, this.f55570a.f55563a, Accessor.class, "getterNotNull", "getterNotNull(Ljava/lang/Object;)Ljava/lang/Object;", 0));
        return this.f55572c != null ? new SpacePaddedFormatter(unsignedIntFormatterStructure) : unsignedIntFormatterStructure;
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public final ParserStructure b() {
        Integer numValueOf = Integer.valueOf(this.f55571b);
        Integer numValueOf2 = Integer.valueOf(this.f55573d);
        UnsignedFieldSpec unsignedFieldSpec = this.f55570a;
        return ParserOperationKt.a(numValueOf, numValueOf2, this.f55572c, unsignedFieldSpec.f55563a, unsignedFieldSpec.f55566d, false);
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public final /* bridge */ /* synthetic */ FieldSpec c() {
        return this.f55570a;
    }
}
