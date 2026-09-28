package com.google.firebase;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes4.dex */
public final class Timestamp implements Comparable<Timestamp>, Parcelable {

    @JvmField
    @NotNull
    public static final Parcelable.Creator<Timestamp> CREATOR = new Timestamp$Companion$CREATOR$1();

    /* renamed from: a, reason: collision with root package name */
    public final long f43520a;

    /* renamed from: b, reason: collision with root package name */
    public final int f43521b;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    /* renamed from: com.google.firebase.Timestamp$compareTo$1, reason: invalid class name */
    final /* synthetic */ class AnonymousClass1 extends PropertyReference1Impl {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass1 f43522c = new AnonymousClass1("seconds", "getSeconds()J", Timestamp.class);

        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
        public final Object get(Object obj) {
            return Long.valueOf(((Timestamp) obj).f43520a);
        }
    }

    @Metadata
    /* renamed from: com.google.firebase.Timestamp$compareTo$2, reason: invalid class name */
    final /* synthetic */ class AnonymousClass2 extends PropertyReference1Impl {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass2 f43523c = new AnonymousClass2("nanoseconds", "getNanoseconds()I", Timestamp.class);

        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
        public final Object get(Object obj) {
            return Integer.valueOf(((Timestamp) obj).f43521b);
        }
    }

    public Timestamp(long j2, int i2) {
        if (i2 < 0 || i2 >= 1000000000) {
            throw new IllegalArgumentException(android.support.v4.media.b.f(i2, "Timestamp nanoseconds out of range: ").toString());
        }
        if (-62135596800L > j2 || j2 >= 253402300800L) {
            throw new IllegalArgumentException(android.support.v4.media.b.i(j2, "Timestamp seconds out of range: ").toString());
        }
        this.f43520a = j2;
        this.f43521b = i2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Timestamp timestamp) {
        Timestamp other = timestamp;
        Intrinsics.checkNotNullParameter(other, "other");
        return ComparisonsKt.b(this, other, AnonymousClass1.f43522c, AnonymousClass2.f43523c);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof Timestamp) {
                Timestamp other = (Timestamp) obj;
                Intrinsics.checkNotNullParameter(other, "other");
                if (ComparisonsKt.b(this, other, AnonymousClass1.f43522c, AnonymousClass2.f43523c) == 0) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        long j2 = this.f43520a;
        return (((((int) j2) * 1369) + ((int) (j2 >> 32))) * 37) + this.f43521b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Timestamp(seconds=");
        sb.append(this.f43520a);
        sb.append(", nanoseconds=");
        return android.support.v4.media.b.n(sb, this.f43521b, ')');
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i2) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeLong(this.f43520a);
        dest.writeInt(this.f43521b);
    }
}
