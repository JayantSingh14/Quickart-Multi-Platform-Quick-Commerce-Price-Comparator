package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.errorprone.annotations.Immutable;
import java.util.Arrays;

@Immutable
@Beta
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class ElementOrder<T> {

    /* renamed from: com.google.common.graph.ElementOrder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f43187a;

        static {
            int[] iArr = new int[Type.values().length];
            f43187a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43187a[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f43187a[1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f43187a[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Type {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f43188a = {new Type("UNORDERED", 0), new Type("STABLE", 1), new Type("INSERTION", 2), new Type("SORTED", 3)};

        /* JADX INFO: Fake field, exist only in values array */
        Type EF5;

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) f43188a.clone();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ElementOrder)) {
            return false;
        }
        ((ElementOrder) obj).getClass();
        return Objects.a(null, null);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{null, null});
    }

    public final String toString() {
        MoreObjects.ToStringHelper toStringHelperB = MoreObjects.b(this);
        toStringHelperB.a(null, "type");
        return toStringHelperB.toString();
    }
}
