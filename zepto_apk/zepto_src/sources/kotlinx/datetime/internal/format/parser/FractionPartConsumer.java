package kotlinx.datetime.internal.format.parser;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.DecimalFraction;
import kotlinx.datetime.internal.format.Accessor;
import kotlinx.datetime.internal.format.parser.NumberConsumptionError;

@Metadata
/* loaded from: classes3.dex */
public final class FractionPartConsumer<Receiver> extends NumberConsumer<Receiver> {

    /* renamed from: c, reason: collision with root package name */
    public final int f55583c;

    /* renamed from: d, reason: collision with root package name */
    public final int f55584d;

    /* renamed from: e, reason: collision with root package name */
    public final Accessor f55585e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FractionPartConsumer(int i2, int i3, Accessor setter, String name) {
        super(i2 == i3 ? Integer.valueOf(i2) : null, name);
        Intrinsics.checkNotNullParameter(setter, "setter");
        Intrinsics.checkNotNullParameter(name, "name");
        this.f55583c = i2;
        this.f55584d = i3;
        this.f55585e = setter;
        if (1 > i2 || i2 >= 10) {
            throw new IllegalArgumentException(("Invalid minimum length " + i2 + " for field " + name + ": expected 1..9").toString());
        }
        if (i2 > i3 || i3 >= 10) {
            StringBuilder sb = new StringBuilder("Invalid maximum length ");
            sb.append(i3);
            sb.append(" for field ");
            sb.append(name);
            sb.append(": expected ");
            throw new IllegalArgumentException(b.o(sb, i2, "..9").toString());
        }
    }

    @Override // kotlinx.datetime.internal.format.parser.NumberConsumer
    public final NumberConsumptionError a(Copyable copyable, String input, int i2, int i3) {
        Intrinsics.checkNotNullParameter(input, "input");
        int i4 = i3 - i2;
        int i5 = this.f55583c;
        if (i4 < i5) {
            return new NumberConsumptionError.TooFewDigits(i5);
        }
        int i6 = this.f55584d;
        if (i4 > i6) {
            return new NumberConsumptionError.TooManyDigits(i6);
        }
        int iCharAt = 0;
        while (i2 < i3) {
            iCharAt = (iCharAt * 10) + (input.charAt(i2) - '0');
            i2++;
        }
        Object objC = this.f55585e.c(copyable, new DecimalFraction(iCharAt, i4));
        if (objC == null) {
            return null;
        }
        return new NumberConsumptionError.Conflicting(objC);
    }
}
