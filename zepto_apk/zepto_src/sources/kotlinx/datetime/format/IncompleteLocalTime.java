package kotlinx.datetime.format;

import android.support.v4.media.b;
import com.amazon.apay.hardened.external.model.APayConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.DateTimeFormatException;
import kotlinx.datetime.LocalTime;
import kotlinx.datetime.internal.DecimalFraction;
import kotlinx.datetime.internal.format.parser.Copyable;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class IncompleteLocalTime implements TimeFieldContainer, Copyable<IncompleteLocalTime> {

    /* renamed from: a, reason: collision with root package name */
    public Integer f55428a;

    /* renamed from: b, reason: collision with root package name */
    public Integer f55429b;

    /* renamed from: c, reason: collision with root package name */
    public AmPmMarker f55430c;

    /* renamed from: d, reason: collision with root package name */
    public Integer f55431d;

    /* renamed from: e, reason: collision with root package name */
    public Integer f55432e;

    /* renamed from: f, reason: collision with root package name */
    public Integer f55433f;

    public IncompleteLocalTime() {
        this(0);
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final void B(Integer num) {
        this.f55428a = num;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final Integer D() {
        return this.f55428a;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final void a(AmPmMarker amPmMarker) {
        this.f55430c = amPmMarker;
    }

    @Override // kotlinx.datetime.internal.format.parser.Copyable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final IncompleteLocalTime copy() {
        return new IncompleteLocalTime(this.f55428a, this.f55429b, this.f55430c, this.f55431d, this.f55432e, this.f55433f);
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final Integer c() {
        return this.f55429b;
    }

    public final LocalTime d() {
        int iIntValue;
        int iIntValue2;
        Integer num = this.f55428a;
        if (num != null) {
            iIntValue = num.intValue();
            Integer num2 = this.f55429b;
            if (num2 != null && ((iIntValue + 11) % 12) + 1 != (iIntValue2 = num2.intValue())) {
                throw new IllegalArgumentException(b.d(iIntValue, iIntValue2, "Inconsistent hour and hour-of-am-pm: hour is ", ", but hour-of-am-pm is ").toString());
            }
            AmPmMarker amPmMarker = this.f55430c;
            if (amPmMarker != null) {
                if ((amPmMarker == AmPmMarker.f55370a) != (iIntValue >= 12)) {
                    throw new IllegalArgumentException(("Inconsistent hour and the AM/PM marker: hour is " + iIntValue + ", but the AM/PM marker is " + amPmMarker).toString());
                }
            }
        } else {
            Integer num3 = this.f55429b;
            Integer numValueOf = null;
            if (num3 != null) {
                int iIntValue3 = num3.intValue();
                AmPmMarker amPmMarker2 = this.f55430c;
                if (amPmMarker2 != null) {
                    if (iIntValue3 == 12) {
                        iIntValue3 = 0;
                    }
                    numValueOf = Integer.valueOf(iIntValue3 + (amPmMarker2 != AmPmMarker.f55370a ? 0 : 12));
                }
            }
            if (numValueOf == null) {
                Intrinsics.checkNotNullParameter("Incomplete time: missing hour", APayConstants.Error.MESSAGE);
                throw new DateTimeFormatException("Incomplete time: missing hour");
            }
            iIntValue = numValueOf.intValue();
        }
        Integer num4 = this.f55431d;
        LocalDateFormatKt.b(num4, "minute");
        int iIntValue4 = num4.intValue();
        Integer num5 = this.f55432e;
        int iIntValue5 = num5 != null ? num5.intValue() : 0;
        Integer num6 = this.f55433f;
        return new LocalTime(iIntValue, iIntValue4, iIntValue5, num6 != null ? num6.intValue() : 0);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof IncompleteLocalTime)) {
            return false;
        }
        IncompleteLocalTime incompleteLocalTime = (IncompleteLocalTime) obj;
        return Intrinsics.b(this.f55428a, incompleteLocalTime.f55428a) && Intrinsics.b(this.f55429b, incompleteLocalTime.f55429b) && this.f55430c == incompleteLocalTime.f55430c && Intrinsics.b(this.f55431d, incompleteLocalTime.f55431d) && Intrinsics.b(this.f55432e, incompleteLocalTime.f55432e) && Intrinsics.b(this.f55433f, incompleteLocalTime.f55433f);
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final void h(DecimalFraction decimalFraction) {
        this.f55433f = decimalFraction != null ? Integer.valueOf(decimalFraction.a(9)) : null;
    }

    public final int hashCode() {
        Integer num = this.f55428a;
        int iIntValue = (num != null ? num.intValue() : 0) * 31;
        Integer num2 = this.f55429b;
        int iIntValue2 = ((num2 != null ? num2.intValue() : 0) * 31) + iIntValue;
        AmPmMarker amPmMarker = this.f55430c;
        int iHashCode = ((amPmMarker != null ? amPmMarker.hashCode() : 0) * 31) + iIntValue2;
        Integer num3 = this.f55431d;
        int iIntValue3 = ((num3 != null ? num3.intValue() : 0) * 31) + iHashCode;
        Integer num4 = this.f55432e;
        int iIntValue4 = ((num4 != null ? num4.intValue() : 0) * 31) + iIntValue3;
        Integer num5 = this.f55433f;
        return iIntValue4 + (num5 != null ? num5.intValue() : 0);
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final Integer i() {
        return this.f55432e;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final void k(Integer num) {
        this.f55432e = num;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final AmPmMarker o() {
        return this.f55430c;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final void p(Integer num) {
        this.f55429b = num;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final Integer s() {
        return this.f55431d;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final void t(Integer num) {
        this.f55431d = num;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.Integer r1 = r4.f55428a
            java.lang.String r2 = "??"
            if (r1 != 0) goto Lc
            r1 = r2
        Lc:
            r0.append(r1)
            r1 = 58
            r0.append(r1)
            java.lang.Integer r3 = r4.f55431d
            if (r3 != 0) goto L19
            r3 = r2
        L19:
            r0.append(r3)
            r0.append(r1)
            java.lang.Integer r1 = r4.f55432e
            if (r1 != 0) goto L24
            goto L25
        L24:
            r2 = r1
        L25:
            r0.append(r2)
            r1 = 46
            r0.append(r1)
            java.lang.Integer r1 = r4.f55433f
            if (r1 == 0) goto L45
            int r1 = r1.intValue()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r2 = r1.length()
            int r2 = 9 - r2
            java.lang.String r1 = kotlin.text.StringsKt.D(r2, r1)
            if (r1 != 0) goto L47
        L45:
            java.lang.String r1 = "???"
        L47:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.datetime.format.IncompleteLocalTime.toString():java.lang.String");
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final DecimalFraction w() {
        Integer num = this.f55433f;
        if (num != null) {
            return new DecimalFraction(num.intValue(), 9);
        }
        return null;
    }

    public /* synthetic */ IncompleteLocalTime(int i2) {
        this(null, null, null, null, null, null);
    }

    public IncompleteLocalTime(Integer num, Integer num2, AmPmMarker amPmMarker, Integer num3, Integer num4, Integer num5) {
        this.f55428a = num;
        this.f55429b = num2;
        this.f55430c = amPmMarker;
        this.f55431d = num3;
        this.f55432e = num4;
        this.f55433f = num5;
    }
}
