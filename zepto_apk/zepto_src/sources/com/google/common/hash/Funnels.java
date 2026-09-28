package com.google.common.hash;

import com.google.common.annotations.Beta;
import java.io.OutputStream;
import java.io.Serializable;

@Beta
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class Funnels {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class ByteArrayFunnel implements Funnel<byte[]> {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ByteArrayFunnel[] f43202a = {new ByteArrayFunnel("INSTANCE", 0)};

        /* JADX INFO: Fake field, exist only in values array */
        ByteArrayFunnel EF5;

        public static ByteArrayFunnel valueOf(String str) {
            return (ByteArrayFunnel) Enum.valueOf(ByteArrayFunnel.class, str);
        }

        public static ByteArrayFunnel[] values() {
            return (ByteArrayFunnel[]) f43202a.clone();
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "Funnels.byteArrayFunnel()";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class IntegerFunnel implements Funnel<Integer> {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ IntegerFunnel[] f43203a = {new IntegerFunnel("INSTANCE", 0)};

        /* JADX INFO: Fake field, exist only in values array */
        IntegerFunnel EF5;

        public static IntegerFunnel valueOf(String str) {
            return (IntegerFunnel) Enum.valueOf(IntegerFunnel.class, str);
        }

        public static IntegerFunnel[] values() {
            return (IntegerFunnel[]) f43203a.clone();
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "Funnels.integerFunnel()";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class LongFunnel implements Funnel<Long> {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LongFunnel[] f43204a = {new LongFunnel("INSTANCE", 0)};

        /* JADX INFO: Fake field, exist only in values array */
        LongFunnel EF5;

        public static LongFunnel valueOf(String str) {
            return (LongFunnel) Enum.valueOf(LongFunnel.class, str);
        }

        public static LongFunnel[] values() {
            return (LongFunnel[]) f43204a.clone();
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "Funnels.longFunnel()";
        }
    }

    public static class SequentialFunnel<E> implements Funnel<Iterable<? extends E>>, Serializable {
        public final boolean equals(Object obj) {
            if (!(obj instanceof SequentialFunnel)) {
                return false;
            }
            ((SequentialFunnel) obj).getClass();
            throw null;
        }

        public final int hashCode() {
            SequentialFunnel.class.hashCode();
            throw null;
        }

        public final String toString() {
            return "Funnels.sequentialFunnel(null)";
        }
    }

    public static class SinkAsStream extends OutputStream {
        public final String toString() {
            return "Funnels.asOutputStream(null)";
        }

        @Override // java.io.OutputStream
        public final void write(int i2) {
            throw null;
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr) {
            throw null;
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr, int i2, int i3) {
            throw null;
        }
    }

    public static class StringCharsetFunnel implements Funnel<CharSequence>, Serializable {

        public static class SerializedForm implements Serializable {
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof StringCharsetFunnel)) {
                return false;
            }
            ((StringCharsetFunnel) obj).getClass();
            throw null;
        }

        public final int hashCode() {
            StringCharsetFunnel.class.hashCode();
            throw null;
        }

        public final String toString() {
            throw null;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class UnencodedCharsFunnel implements Funnel<CharSequence> {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ UnencodedCharsFunnel[] f43205a = {new UnencodedCharsFunnel("INSTANCE", 0)};

        /* JADX INFO: Fake field, exist only in values array */
        UnencodedCharsFunnel EF5;

        public static UnencodedCharsFunnel valueOf(String str) {
            return (UnencodedCharsFunnel) Enum.valueOf(UnencodedCharsFunnel.class, str);
        }

        public static UnencodedCharsFunnel[] values() {
            return (UnencodedCharsFunnel[]) f43205a.clone();
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "Funnels.unencodedCharsFunnel()";
        }
    }
}
