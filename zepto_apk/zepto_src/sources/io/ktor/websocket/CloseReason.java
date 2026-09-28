package io.ktor.websocket;

import androidx.fragment.app.e;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
/* loaded from: classes3.dex */
public final class CloseReason {

    /* renamed from: a, reason: collision with root package name */
    public final short f51380a;

    /* renamed from: b, reason: collision with root package name */
    public final String f51381b;

    @Metadata
    @SourceDebugExtension
    public enum Codes {
        NORMAL(1000),
        /* JADX INFO: Fake field, exist only in values array */
        GOING_AWAY(1001),
        /* JADX INFO: Fake field, exist only in values array */
        PROTOCOL_ERROR(1002),
        /* JADX INFO: Fake field, exist only in values array */
        CANNOT_ACCEPT(1003),
        CLOSED_ABNORMALLY(1006),
        /* JADX INFO: Fake field, exist only in values array */
        NOT_CONSISTENT(1007),
        /* JADX INFO: Fake field, exist only in values array */
        VIOLATED_POLICY(1008),
        TOO_BIG(1009),
        /* JADX INFO: Fake field, exist only in values array */
        NO_EXTENSION(1010),
        INTERNAL_ERROR(1011),
        /* JADX INFO: Fake field, exist only in values array */
        SERVICE_RESTART(1012),
        /* JADX INFO: Fake field, exist only in values array */
        TRY_AGAIN_LATER(1013);


        /* renamed from: b, reason: collision with root package name */
        public static final LinkedHashMap f51382b;

        /* renamed from: a, reason: collision with root package name */
        public final short f51388a;

        @Metadata
        public static final class Companion {
        }

        static {
            Codes[] codesArrValues = values();
            int iF = MapsKt.f(codesArrValues.length);
            LinkedHashMap linkedHashMap = new LinkedHashMap(iF < 16 ? 16 : iF);
            for (Codes codes : codesArrValues) {
                linkedHashMap.put(Short.valueOf(codes.f51388a), codes);
            }
            f51382b = linkedHashMap;
        }

        Codes(short s) {
            this.f51388a = s;
        }
    }

    public CloseReason(String message, short s) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.f51380a = s;
        this.f51381b = message;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CloseReason)) {
            return false;
        }
        CloseReason closeReason = (CloseReason) obj;
        return this.f51380a == closeReason.f51380a && Intrinsics.b(this.f51381b, closeReason.f51381b);
    }

    public final int hashCode() {
        return this.f51381b.hashCode() + (Short.hashCode(this.f51380a) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CloseReason(reason=");
        LinkedHashMap linkedHashMap = Codes.f51382b;
        LinkedHashMap linkedHashMap2 = Codes.f51382b;
        short s = this.f51380a;
        Object objValueOf = (Codes) linkedHashMap2.get(Short.valueOf(s));
        if (objValueOf == null) {
            objValueOf = Short.valueOf(s);
        }
        sb.append(objValueOf);
        sb.append(", message=");
        return e.t(sb, this.f51381b, ')');
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CloseReason(Codes code, String message) {
        this(message, code.f51388a);
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
