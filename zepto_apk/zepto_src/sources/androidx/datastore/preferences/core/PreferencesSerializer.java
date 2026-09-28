package androidx.datastore.preferences.core;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.okio.OkioSerializer;
import androidx.datastore.preferences.PreferencesMapCompat;
import androidx.datastore.preferences.PreferencesProto;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.RealBufferedSink;
import okio.RealBufferedSink$outputStream$1;
import okio.RealBufferedSource;
import okio.RealBufferedSource$inputStream$1;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class PreferencesSerializer implements OkioSerializer<Preferences> {

    /* renamed from: a, reason: collision with root package name */
    public static final PreferencesSerializer f3729a = new PreferencesSerializer();

    @Metadata
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3730a;

        static {
            int[] iArr = new int[PreferencesProto.Value.ValueCase.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[6] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[2] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[3] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[4] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[5] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[7] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[8] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            f3730a = iArr;
        }
    }

    public final Object a(RealBufferedSource realBufferedSource) throws CorruptionException {
        PreferencesProto.PreferenceMap preferenceMapA = PreferencesMapCompat.Companion.a(new RealBufferedSource$inputStream$1(realBufferedSource));
        Preferences.Pair[] pairs = new Preferences.Pair[0];
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        MutablePreferences mutablePreferences = new MutablePreferences(false, 1);
        Preferences.Pair[] pairs2 = (Preferences.Pair[]) Arrays.copyOf(pairs, 0);
        Intrinsics.checkNotNullParameter(pairs2, "pairs");
        mutablePreferences.c();
        if (pairs2.length > 0) {
            pairs2[0].getClass();
            mutablePreferences.d(null, null);
            throw null;
        }
        Map mapZ = preferenceMapA.z();
        Intrinsics.checkNotNullExpressionValue(mapZ, "preferencesProto.preferencesMap");
        for (Map.Entry entry : mapZ.entrySet()) {
            String name = (String) entry.getKey();
            PreferencesProto.Value value = (PreferencesProto.Value) entry.getValue();
            Intrinsics.checkNotNullExpressionValue(name, "name");
            Intrinsics.checkNotNullExpressionValue(value, "value");
            PreferencesProto.Value.ValueCase valueCaseP = value.P();
            switch (valueCaseP == null ? -1 : WhenMappings.f3730a[valueCaseP.ordinal()]) {
                case -1:
                    throw new CorruptionException("Value case is null.", 0);
                case 0:
                default:
                    throw new NoWhenBranchMatchedException();
                case 1:
                    Intrinsics.checkNotNullParameter(name, "name");
                    Preferences.Key key = new Preferences.Key(name);
                    Boolean boolValueOf = Boolean.valueOf(value.G());
                    Intrinsics.checkNotNullParameter(key, "key");
                    mutablePreferences.d(key, boolValueOf);
                    break;
                case 2:
                    Intrinsics.checkNotNullParameter(name, "name");
                    Preferences.Key key2 = new Preferences.Key(name);
                    Float fValueOf = Float.valueOf(value.K());
                    Intrinsics.checkNotNullParameter(key2, "key");
                    mutablePreferences.d(key2, fValueOf);
                    break;
                case 3:
                    Intrinsics.checkNotNullParameter(name, "name");
                    Preferences.Key key3 = new Preferences.Key(name);
                    Double dValueOf = Double.valueOf(value.J());
                    Intrinsics.checkNotNullParameter(key3, "key");
                    mutablePreferences.d(key3, dValueOf);
                    break;
                case 4:
                    Intrinsics.checkNotNullParameter(name, "name");
                    Preferences.Key key4 = new Preferences.Key(name);
                    Integer numValueOf = Integer.valueOf(value.L());
                    Intrinsics.checkNotNullParameter(key4, "key");
                    mutablePreferences.d(key4, numValueOf);
                    break;
                case 5:
                    Intrinsics.checkNotNullParameter(name, "name");
                    Preferences.Key key5 = new Preferences.Key(name);
                    Long lValueOf = Long.valueOf(value.M());
                    Intrinsics.checkNotNullParameter(key5, "key");
                    mutablePreferences.d(key5, lValueOf);
                    break;
                case 6:
                    Preferences.Key key6 = PreferencesKeys.a(name);
                    String strN = value.N();
                    Intrinsics.checkNotNullExpressionValue(strN, "value.string");
                    Intrinsics.checkNotNullParameter(key6, "key");
                    mutablePreferences.d(key6, strN);
                    break;
                case 7:
                    Intrinsics.checkNotNullParameter(name, "name");
                    Preferences.Key key7 = new Preferences.Key(name);
                    Internal.ProtobufList protobufListA = value.O().A();
                    Intrinsics.checkNotNullExpressionValue(protobufListA, "value.stringSet.stringsList");
                    Set setH0 = CollectionsKt.h0(protobufListA);
                    Intrinsics.checkNotNullParameter(key7, "key");
                    mutablePreferences.d(key7, setH0);
                    break;
                case 8:
                    Intrinsics.checkNotNullParameter(name, "name");
                    Preferences.Key key8 = new Preferences.Key(name);
                    byte[] bArrU = value.H().u();
                    Intrinsics.checkNotNullExpressionValue(bArrU, "value.bytes.toByteArray()");
                    Intrinsics.checkNotNullParameter(key8, "key");
                    mutablePreferences.d(key8, bArrU);
                    break;
                case 9:
                    throw new CorruptionException("Value not set.", 0);
            }
        }
        return new MutablePreferences(MapsKt.n(mutablePreferences.a()), true);
    }

    public final Object b(Object obj, RealBufferedSink realBufferedSink) throws IOException {
        GeneratedMessageLite generatedMessageLiteI;
        Map mapA = ((Preferences) obj).a();
        PreferencesProto.PreferenceMap.Builder builderA = PreferencesProto.PreferenceMap.A();
        for (Map.Entry entry : mapA.entrySet()) {
            Preferences.Key key = (Preferences.Key) entry.getKey();
            Object value = entry.getValue();
            String str = key.f3725a;
            if (value instanceof Boolean) {
                PreferencesProto.Value.Builder builderQ = PreferencesProto.Value.Q();
                builderQ.o(((Boolean) value).booleanValue());
                generatedMessageLiteI = builderQ.i();
                Intrinsics.checkNotNullExpressionValue(generatedMessageLiteI, "newBuilder().setBoolean(value).build()");
            } else if (value instanceof Float) {
                PreferencesProto.Value.Builder builderQ2 = PreferencesProto.Value.Q();
                builderQ2.t(((Number) value).floatValue());
                generatedMessageLiteI = builderQ2.i();
                Intrinsics.checkNotNullExpressionValue(generatedMessageLiteI, "newBuilder().setFloat(value).build()");
            } else if (value instanceof Double) {
                PreferencesProto.Value.Builder builderQ3 = PreferencesProto.Value.Q();
                builderQ3.q(((Number) value).doubleValue());
                generatedMessageLiteI = builderQ3.i();
                Intrinsics.checkNotNullExpressionValue(generatedMessageLiteI, "newBuilder().setDouble(value).build()");
            } else if (value instanceof Integer) {
                PreferencesProto.Value.Builder builderQ4 = PreferencesProto.Value.Q();
                builderQ4.u(((Number) value).intValue());
                generatedMessageLiteI = builderQ4.i();
                Intrinsics.checkNotNullExpressionValue(generatedMessageLiteI, "newBuilder().setInteger(value).build()");
            } else if (value instanceof Long) {
                PreferencesProto.Value.Builder builderQ5 = PreferencesProto.Value.Q();
                builderQ5.v(((Number) value).longValue());
                generatedMessageLiteI = builderQ5.i();
                Intrinsics.checkNotNullExpressionValue(generatedMessageLiteI, "newBuilder().setLong(value).build()");
            } else if (value instanceof String) {
                PreferencesProto.Value.Builder builderQ6 = PreferencesProto.Value.Q();
                builderQ6.w((String) value);
                generatedMessageLiteI = builderQ6.i();
                Intrinsics.checkNotNullExpressionValue(generatedMessageLiteI, "newBuilder().setString(value).build()");
            } else if (value instanceof Set) {
                PreferencesProto.Value.Builder builderQ7 = PreferencesProto.Value.Q();
                PreferencesProto.StringSet.Builder builderB = PreferencesProto.StringSet.B();
                Intrinsics.d(value, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
                builderB.o((Set) value);
                builderQ7.x(builderB);
                generatedMessageLiteI = builderQ7.i();
                Intrinsics.checkNotNullExpressionValue(generatedMessageLiteI, "newBuilder().setStringSe…                ).build()");
            } else {
                if (!(value instanceof byte[])) {
                    throw new IllegalStateException("PreferencesSerializer does not support type: ".concat(value.getClass().getName()));
                }
                PreferencesProto.Value.Builder builderQ8 = PreferencesProto.Value.Q();
                builderQ8.p(ByteString.j((byte[]) value));
                generatedMessageLiteI = builderQ8.i();
                Intrinsics.checkNotNullExpressionValue(generatedMessageLiteI, "newBuilder().setBytes(By….copyFrom(value)).build()");
            }
            builderA.o((PreferencesProto.Value) generatedMessageLiteI, str);
        }
        ((PreferencesProto.PreferenceMap) builderA.i()).l(new RealBufferedSink$outputStream$1(realBufferedSink));
        return Unit.f53572a;
    }
}
