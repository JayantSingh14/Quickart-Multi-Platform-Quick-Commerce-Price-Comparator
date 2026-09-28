package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text._OneToManyTitlecaseMappingsKt;
import kotlin.time.Duration;
import kotlinx.serialization.builtins.BuiltinSerializersKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class PrimitivesKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f55891a;

    static {
        ClassReference classReferenceA = Reflection.a(String.class);
        BuiltinSerializersKt.d(StringCompanionObject.f53805a);
        Pair pair = new Pair(classReferenceA, StringSerializer.f55902a);
        ClassReference classReferenceA2 = Reflection.a(Character.TYPE);
        Intrinsics.checkNotNullParameter(CharCompanionObject.f53784a, "<this>");
        Pair pair2 = new Pair(classReferenceA2, CharSerializer.f55785a);
        Pair pair3 = new Pair(Reflection.a(char[].class), CharArraySerializer.f55784c);
        ClassReference classReferenceA3 = Reflection.a(Double.TYPE);
        Intrinsics.checkNotNullParameter(DoubleCompanionObject.f53791a, "<this>");
        Pair pair4 = new Pair(classReferenceA3, DoubleSerializer.f55801a);
        Pair pair5 = new Pair(Reflection.a(double[].class), DoubleArraySerializer.f55800c);
        ClassReference classReferenceA4 = Reflection.a(Float.TYPE);
        Intrinsics.checkNotNullParameter(FloatCompanionObject.f53793a, "<this>");
        Pair pair6 = new Pair(classReferenceA4, FloatSerializer.f55822a);
        Pair pair7 = new Pair(Reflection.a(float[].class), FloatArraySerializer.f55821c);
        ClassReference classReferenceA5 = Reflection.a(Long.TYPE);
        Intrinsics.checkNotNullParameter(LongCompanionObject.f53795a, "<this>");
        Pair pair8 = new Pair(classReferenceA5, LongSerializer.f55842a);
        Pair pair9 = new Pair(Reflection.a(long[].class), LongArraySerializer.f55841c);
        ClassReference classReferenceA6 = Reflection.a(ULong.class);
        Intrinsics.checkNotNullParameter(ULong.f53561b, "<this>");
        Pair pair10 = new Pair(classReferenceA6, ULongSerializer.f55929a);
        Pair pair11 = new Pair(Reflection.a(ULongArray.class), ULongArraySerializer.f55928c);
        ClassReference classReferenceA7 = Reflection.a(Integer.TYPE);
        Intrinsics.checkNotNullParameter(IntCompanionObject.f53794a, "<this>");
        Pair pair12 = new Pair(classReferenceA7, IntSerializer.f55831a);
        Pair pair13 = new Pair(Reflection.a(int[].class), IntArraySerializer.f55830c);
        ClassReference classReferenceA8 = Reflection.a(UInt.class);
        Intrinsics.checkNotNullParameter(UInt.f53556b, "<this>");
        Pair pair14 = new Pair(classReferenceA8, UIntSerializer.f55924a);
        Pair pair15 = new Pair(Reflection.a(UIntArray.class), UIntArraySerializer.f55923c);
        ClassReference classReferenceA9 = Reflection.a(Short.TYPE);
        Intrinsics.checkNotNullParameter(ShortCompanionObject.f53804a, "<this>");
        Pair pair16 = new Pair(classReferenceA9, ShortSerializer.f55900a);
        Pair pair17 = new Pair(Reflection.a(short[].class), ShortArraySerializer.f55899c);
        ClassReference classReferenceA10 = Reflection.a(UShort.class);
        Intrinsics.checkNotNullParameter(UShort.f53567b, "<this>");
        Pair pair18 = new Pair(classReferenceA10, UShortSerializer.f55934a);
        Pair pair19 = new Pair(Reflection.a(UShortArray.class), UShortArraySerializer.f55933c);
        ClassReference classReferenceA11 = Reflection.a(Byte.TYPE);
        Intrinsics.checkNotNullParameter(ByteCompanionObject.f53782a, "<this>");
        Pair pair20 = new Pair(classReferenceA11, ByteSerializer.f55778a);
        Pair pair21 = new Pair(Reflection.a(byte[].class), ByteArraySerializer.f55777c);
        ClassReference classReferenceA12 = Reflection.a(UByte.class);
        Intrinsics.checkNotNullParameter(UByte.f53551b, "<this>");
        Pair pair22 = new Pair(classReferenceA12, UByteSerializer.f55919a);
        Pair pair23 = new Pair(Reflection.a(UByteArray.class), UByteArraySerializer.f55918c);
        ClassReference classReferenceA13 = Reflection.a(Boolean.TYPE);
        Intrinsics.checkNotNullParameter(BooleanCompanionObject.f53781a, "<this>");
        Pair pair24 = new Pair(classReferenceA13, BooleanSerializer.f55773a);
        Pair pair25 = new Pair(Reflection.a(boolean[].class), BooleanArraySerializer.f55772c);
        ClassReference classReferenceA14 = Reflection.a(Unit.class);
        Intrinsics.checkNotNullParameter(Unit.f53572a, "<this>");
        Pair pair26 = new Pair(classReferenceA14, UnitSerializer.f55936b);
        Pair pair27 = new Pair(Reflection.a(Void.class), NothingSerializer.f55857a);
        ClassReference classReferenceA15 = Reflection.a(Duration.class);
        Intrinsics.checkNotNullParameter(Duration.f54014b, "<this>");
        f55891a = MapsKt.h(pair, pair2, pair3, pair4, pair5, pair6, pair7, pair8, pair9, pair10, pair11, pair12, pair13, pair14, pair15, pair16, pair17, pair18, pair19, pair20, pair21, pair22, pair23, pair24, pair25, pair26, pair27, new Pair(classReferenceA15, DurationSerializer.f55803a));
    }

    public static final String a(String str) {
        if (str.length() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = str.charAt(0);
        sb.append((Object) (Character.isLowerCase(cCharAt) ? _OneToManyTitlecaseMappingsKt.a(cCharAt) : String.valueOf(cCharAt)));
        String strSubstring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        sb.append(strSubstring);
        return sb.toString();
    }
}
