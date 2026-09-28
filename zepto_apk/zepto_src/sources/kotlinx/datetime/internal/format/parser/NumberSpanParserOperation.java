package kotlinx.datetime.internal.format.parser;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.internal.UtilKt;
import kotlinx.datetime.internal.format.parser.ParseResult;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class NumberSpanParserOperation<Output> implements ParserOperation<Output> {

    /* renamed from: a, reason: collision with root package name */
    public final List f55593a;

    /* renamed from: b, reason: collision with root package name */
    public final int f55594b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f55595c;

    public NumberSpanParserOperation(List consumers) {
        boolean z;
        boolean z2;
        int i2;
        Intrinsics.checkNotNullParameter(consumers, "consumers");
        this.f55593a = consumers;
        Iterator it = consumers.iterator();
        int i3 = 0;
        while (true) {
            int iIntValue = 1;
            if (!it.hasNext()) {
                break;
            }
            Integer numB = ((NumberConsumer) it.next()).b();
            if (numB != null) {
                iIntValue = numB.intValue();
            }
            i3 += iIntValue;
        }
        this.f55594b = i3;
        List list = this.f55593a;
        if ((list instanceof Collection) && list.isEmpty()) {
            z = false;
        } else {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                if (((NumberConsumer) it2.next()).b() == null) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        this.f55595c = z;
        List list2 = this.f55593a;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            z2 = true;
        } else {
            Iterator it3 = list2.iterator();
            while (it3.hasNext()) {
                Integer numB2 = ((NumberConsumer) it3.next()).b();
                if (!((numB2 != null ? numB2.intValue() : Api.BaseClientBuilder.API_PRIORITY_OTHER) > 0)) {
                    z2 = false;
                    break;
                }
            }
            z2 = true;
        }
        if (!z2) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        List list3 = this.f55593a;
        if ((list3 instanceof Collection) && list3.isEmpty()) {
            i2 = 0;
        } else {
            Iterator it4 = list3.iterator();
            i2 = 0;
            while (it4.hasNext()) {
                if ((((NumberConsumer) it4.next()).b() == null) && (i2 = i2 + 1) < 0) {
                    throw new ArithmeticException("Count overflow has happened.");
                }
            }
        }
        if (i2 <= 1) {
            return;
        }
        List list4 = this.f55593a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list4) {
            if (((NumberConsumer) obj).b() == null) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.r(arrayList, 10));
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            arrayList2.add(((NumberConsumer) it5.next()).f55587b);
        }
        throw new IllegalArgumentException(("At most one variable-length numeric field in a row is allowed, but got several: " + arrayList2 + ". Parsing is undefined: for example, with variable-length month number and variable-length day of month, '111' can be parsed as Jan 11th or Nov 1st.").toString());
    }

    @Override // kotlinx.datetime.internal.format.parser.ParserOperation
    public final Object a(Copyable copyable, String input, int i2) {
        Intrinsics.checkNotNullParameter(input, "input");
        int i3 = this.f55594b;
        if (i2 + i3 > input.length()) {
            return ParseResult.Companion.a(i2, new Function0<String>() { // from class: kotlinx.datetime.internal.format.parser.NumberSpanParserOperation$consume$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return "Unexpected end of input: yet to parse " + this.f55596c.b();
                }
            });
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        while (intRef.f53799a + i2 < input.length() && UtilKt.a(input.charAt(intRef.f53799a + i2))) {
            intRef.f53799a++;
        }
        if (intRef.f53799a < i3) {
            return ParseResult.Companion.a(i2, new Function0<String>() { // from class: kotlinx.datetime.internal.format.parser.NumberSpanParserOperation$consume$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return "Only found " + intRef.f53799a + " digits in a row, but need to parse " + this.b();
                }
            });
        }
        List list = this.f55593a;
        int size = list.size();
        final int i4 = 0;
        while (i4 < size) {
            Integer numB = ((NumberConsumer) list.get(i4)).b();
            int iIntValue = (numB != null ? numB.intValue() : (intRef.f53799a - i3) + 1) + i2;
            final NumberConsumptionError numberConsumptionErrorA = ((NumberConsumer) list.get(i4)).a(copyable, input, i2, iIntValue);
            if (numberConsumptionErrorA != null) {
                final String string = input.subSequence(i2, iIntValue).toString();
                return ParseResult.Companion.a(i2, new Function0<String>() { // from class: kotlinx.datetime.internal.format.parser.NumberSpanParserOperation$consume$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return "Can not interpret the string '" + string + "' as " + ((NumberConsumer) this.f55593a.get(i4)).f55587b + ": " + numberConsumptionErrorA.a();
                    }
                });
            }
            i4++;
            i2 = iIntValue;
        }
        return Integer.valueOf(i2);
    }

    public final String b() {
        List<NumberConsumer> list = this.f55593a;
        ArrayList arrayList = new ArrayList(CollectionsKt.r(list, 10));
        for (NumberConsumer numberConsumer : list) {
            StringBuilder sb = new StringBuilder();
            Integer numB = numberConsumer.b();
            sb.append(numB == null ? "at least one digit" : numB + " digits");
            sb.append(" for ");
            sb.append(numberConsumer.f55587b);
            arrayList.add(sb.toString());
        }
        boolean z = this.f55595c;
        int i2 = this.f55594b;
        if (z) {
            return "a number with at least " + i2 + " digits: " + arrayList;
        }
        return "a number with exactly " + i2 + " digits: " + arrayList;
    }

    public final String toString() {
        return b();
    }
}
