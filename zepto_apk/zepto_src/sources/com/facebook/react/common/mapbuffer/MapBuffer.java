package com.facebook.react.common.mapbuffer;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import org.xbill.DNS.Message;

@Metadata
/* loaded from: classes.dex */
public interface MapBuffer extends Iterable<Entry>, KMappedMarker {
    public static final Companion m0 = Companion.f18720a;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f18720a = new Companion();

        /* renamed from: b, reason: collision with root package name */
        public static final IntRange f18721b = new IntRange(0, Message.MAXLENGTH, 1);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    /* loaded from: classes3.dex */
    public static final class DataType {

        /* renamed from: a, reason: collision with root package name */
        public static final DataType f18722a;

        /* renamed from: b, reason: collision with root package name */
        public static final DataType f18723b;

        /* renamed from: c, reason: collision with root package name */
        public static final DataType f18724c;

        /* renamed from: d, reason: collision with root package name */
        public static final DataType f18725d;

        /* renamed from: e, reason: collision with root package name */
        public static final DataType f18726e;

        /* renamed from: f, reason: collision with root package name */
        public static final DataType f18727f;

        /* renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ DataType[] f18728g;

        /* renamed from: h, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f18729h;

        static {
            DataType dataType = new DataType("BOOL", 0);
            f18722a = dataType;
            DataType dataType2 = new DataType("INT", 1);
            f18723b = dataType2;
            DataType dataType3 = new DataType("DOUBLE", 2);
            f18724c = dataType3;
            DataType dataType4 = new DataType("STRING", 3);
            f18725d = dataType4;
            DataType dataType5 = new DataType("MAP", 4);
            f18726e = dataType5;
            DataType dataType6 = new DataType("LONG", 5);
            f18727f = dataType6;
            DataType[] dataTypeArr = {dataType, dataType2, dataType3, dataType4, dataType5, dataType6};
            f18728g = dataTypeArr;
            f18729h = EnumEntriesKt.a(dataTypeArr);
        }

        public static DataType valueOf(String str) {
            return (DataType) Enum.valueOf(DataType.class, str);
        }

        public static DataType[] values() {
            return (DataType[]) f18728g.clone();
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public interface Entry {
        long a();

        double b();

        String c();

        int d();

        MapBuffer e();

        boolean f();

        int getKey();

        DataType getType();
    }

    boolean c1(int i2);

    boolean getBoolean(int i2);

    int getCount();

    double getDouble(int i2);

    int getInt(int i2);

    String getString(int i2);

    MapBuffer j0(int i2);
}
