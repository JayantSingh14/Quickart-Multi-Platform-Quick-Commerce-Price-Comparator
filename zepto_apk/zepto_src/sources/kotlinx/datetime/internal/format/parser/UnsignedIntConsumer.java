package kotlinx.datetime.internal.format.parser;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlinx.datetime.internal.format.Accessor;
import kotlinx.datetime.internal.format.parser.NumberConsumptionError;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class UnsignedIntConsumer<Receiver> extends NumberConsumer<Receiver> {

    /* renamed from: c, reason: collision with root package name */
    public final Integer f55636c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f55637d;

    /* renamed from: e, reason: collision with root package name */
    public final Accessor f55638e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f55639f;

    /* JADX WARN: Illegal instructions before constructor call */
    public UnsignedIntConsumer(Integer num, Integer num2, Accessor setter, String name, boolean z) {
        Intrinsics.checkNotNullParameter(setter, "setter");
        Intrinsics.checkNotNullParameter(name, "name");
        Integer num3 = Intrinsics.b(num, num2) ? num : null;
        super(num3, name);
        this.f55636c = num;
        this.f55637d = num2;
        this.f55638e = setter;
        this.f55639f = z;
        if (num3 == null || new IntRange(1, 9, 1).c1(num3.intValue())) {
            return;
        }
        throw new IllegalArgumentException(("Invalid length for field " + name + ": " + num3).toString());
    }

    @Override // kotlinx.datetime.internal.format.parser.NumberConsumer
    public final NumberConsumptionError a(Copyable copyable, String input, int i2, int i3) {
        Integer numValueOf;
        Intrinsics.checkNotNullParameter(input, "input");
        Integer num = this.f55637d;
        if (num != null && i3 - i2 > num.intValue()) {
            return new NumberConsumptionError.TooManyDigits(num.intValue());
        }
        Integer num2 = this.f55636c;
        if (num2 != null && i3 - i2 < num2.intValue()) {
            return new NumberConsumptionError.TooFewDigits(num2.intValue());
        }
        int iCharAt = 0;
        while (true) {
            if (i2 >= i3) {
                numValueOf = Integer.valueOf(iCharAt);
                break;
            }
            iCharAt = (iCharAt * 10) + (input.charAt(i2) - '0');
            if (iCharAt < 0) {
                numValueOf = null;
                break;
            }
            i2++;
        }
        if (numValueOf == null) {
            return NumberConsumptionError.ExpectedInt.f55589a;
        }
        boolean z = this.f55639f;
        int iIntValue = numValueOf.intValue();
        if (z) {
            iIntValue = -iIntValue;
        }
        Object objC = this.f55638e.c(copyable, Integer.valueOf(iIntValue));
        if (objC == null) {
            return null;
        }
        return new NumberConsumptionError.Conflicting(objC);
    }
}
