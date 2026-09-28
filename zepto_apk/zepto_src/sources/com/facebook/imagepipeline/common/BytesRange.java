package com.facebook.imagepipeline.common;

import coil3.decode.b;
import com.google.android.gms.common.api.Api;
import java.util.Arrays;
import java.util.regex.Pattern;
import javax.annotation.concurrent.Immutable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@Immutable
/* loaded from: classes3.dex */
public final class BytesRange {

    /* renamed from: c, reason: collision with root package name */
    public static final Lazy f17773c = LazyKt.b(new b(8));

    /* renamed from: a, reason: collision with root package name */
    public final int f17774a;

    /* renamed from: b, reason: collision with root package name */
    public final int f17775b;

    @Metadata
    public static final class Companion {
        public static final String a(int i2) {
            Lazy lazy = BytesRange.f17773c;
            return i2 == Integer.MAX_VALUE ? "" : String.valueOf(i2);
        }

        public static BytesRange b(String str) throws NumberFormatException {
            if (str == null) {
                return null;
            }
            try {
                Object value = BytesRange.f17773c.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
                String[] strArrSplit = ((Pattern) value).split(str);
                if (!(strArrSplit.length == 4)) {
                    throw new IllegalArgumentException();
                }
                if (!Intrinsics.b(strArrSplit[0], "bytes")) {
                    throw new IllegalArgumentException();
                }
                String str2 = strArrSplit[1];
                Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
                int i2 = Integer.parseInt(str2);
                String str3 = strArrSplit[2];
                Intrinsics.checkNotNullExpressionValue(str3, "get(...)");
                int i3 = Integer.parseInt(str3);
                String str4 = strArrSplit[3];
                Intrinsics.checkNotNullExpressionValue(str4, "get(...)");
                int i4 = Integer.parseInt(str4);
                if (!(i3 > i2)) {
                    throw new IllegalArgumentException();
                }
                if (i4 > i3) {
                    return i3 < i4 - 1 ? new BytesRange(i2, i3) : new BytesRange(i2, Api.BaseClientBuilder.API_PRIORITY_OTHER);
                }
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e2) {
                String str5 = String.format(null, "Invalid Content-Range header value: \"%s\"", Arrays.copyOf(new Object[]{str}, 1));
                Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                throw new IllegalArgumentException(str5, e2);
            }
        }
    }

    public BytesRange(int i2, int i3) {
        this.f17774a = i2;
        this.f17775b = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!BytesRange.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.d(obj, "null cannot be cast to non-null type com.facebook.imagepipeline.common.BytesRange");
        BytesRange bytesRange = (BytesRange) obj;
        return this.f17774a == bytesRange.f17774a && this.f17775b == bytesRange.f17775b;
    }

    public final int hashCode() {
        return (this.f17774a * 31) + this.f17775b;
    }

    public final String toString() {
        String str = String.format(null, "%s-%s", Arrays.copyOf(new Object[]{Companion.a(this.f17774a), Companion.a(this.f17775b)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
