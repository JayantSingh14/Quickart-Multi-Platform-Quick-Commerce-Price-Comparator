package com.facebook.react.common.mapbuffer;

import android.support.v4.media.b;
import com.brentvatne.common.react.r;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.common.mapbuffer.MapBuffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import javax.annotation.concurrent.NotThreadSafe;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;
import org.jetbrains.annotations.Nullable;

@DoNotStrip
@NotThreadSafe
@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ReadableMapBuffer implements MapBuffer {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f18731d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final ByteBuffer f18732a;

    /* renamed from: b, reason: collision with root package name */
    public final int f18733b;

    /* renamed from: c, reason: collision with root package name */
    public final int f18734c;

    @DoNotStrip
    @Nullable
    private final HybridData mHybridData;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public final class MapBufferEntry implements MapBuffer.Entry {

        /* renamed from: a, reason: collision with root package name */
        public final int f18735a;

        public MapBufferEntry(int i2) {
            this.f18735a = i2;
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public final long a() {
            g(MapBuffer.DataType.f18727f);
            return ReadableMapBuffer.this.f18732a.getLong(this.f18735a + 4);
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public final double b() {
            g(MapBuffer.DataType.f18724c);
            return ReadableMapBuffer.this.f18732a.getDouble(this.f18735a + 4);
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public final String c() {
            g(MapBuffer.DataType.f18725d);
            return ReadableMapBuffer.this.g(this.f18735a + 4);
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public final int d() {
            g(MapBuffer.DataType.f18723b);
            return ReadableMapBuffer.this.f18732a.getInt(this.f18735a + 4);
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public final MapBuffer e() {
            g(MapBuffer.DataType.f18726e);
            int i2 = this.f18735a + 4;
            ReadableMapBuffer readableMapBuffer = ReadableMapBuffer.this;
            int iD = readableMapBuffer.d(readableMapBuffer.f18734c);
            ByteBuffer byteBuffer = readableMapBuffer.f18732a;
            return new ReadableMapBuffer(byteBuffer.getInt(i2) + iD + 4, byteBuffer);
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public final boolean f() {
            g(MapBuffer.DataType.f18722a);
            return ReadableMapBuffer.this.f18732a.getInt(this.f18735a + 4) == 1;
        }

        public final void g(MapBuffer.DataType dataType) {
            MapBuffer.DataType type = getType();
            if (dataType == type) {
                return;
            }
            throw new IllegalStateException(("Expected " + dataType + " for key: " + getKey() + " found " + type + " instead.").toString());
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public final int getKey() {
            int i2 = ReadableMapBuffer.f18731d;
            return ReadableMapBuffer.this.i(this.f18735a) & 65535;
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public final MapBuffer.DataType getType() {
            MapBuffer.DataType[] dataTypeArrValues = MapBuffer.DataType.values();
            int i2 = this.f18735a + 2;
            int i3 = ReadableMapBuffer.f18731d;
            return dataTypeArrValues[ReadableMapBuffer.this.i(i2) & 65535];
        }
    }

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[MapBuffer.DataType.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MapBuffer.DataType dataType = MapBuffer.DataType.f18722a;
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                MapBuffer.DataType dataType2 = MapBuffer.DataType.f18722a;
                iArr[5] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                MapBuffer.DataType dataType3 = MapBuffer.DataType.f18722a;
                iArr[2] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                MapBuffer.DataType dataType4 = MapBuffer.DataType.f18722a;
                iArr[3] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                MapBuffer.DataType dataType5 = MapBuffer.DataType.f18722a;
                iArr[4] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Metadata
    /* renamed from: com.facebook.react.common.mapbuffer.ReadableMapBuffer$iterator$1, reason: invalid class name */
    public final class AnonymousClass1 implements Iterator<MapBuffer.Entry>, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        public int f18737a;

        /* renamed from: b, reason: collision with root package name */
        public final int f18738b;

        public AnonymousClass1() {
            this.f18738b = ReadableMapBuffer.this.f18734c - 1;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f18737a <= this.f18738b;
        }

        @Override // java.util.Iterator
        public final MapBuffer.Entry next() {
            int i2 = this.f18737a;
            this.f18737a = i2 + 1;
            int i3 = ReadableMapBuffer.f18731d;
            ReadableMapBuffer readableMapBuffer = ReadableMapBuffer.this;
            return readableMapBuffer.new MapBufferEntry(readableMapBuffer.d(i2));
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    static {
        MapBufferSoLoader.a();
    }

    @DoNotStrip
    private ReadableMapBuffer(HybridData hybridData) {
        this.mHybridData = hybridData;
        ByteBuffer byteBufferImportByteBuffer = importByteBuffer();
        this.f18732a = byteBufferImportByteBuffer;
        this.f18733b = 0;
        if (byteBufferImportByteBuffer.getShort() != 254) {
            byteBufferImportByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        }
        this.f18734c = i(byteBufferImportByteBuffer.position()) & 65535;
    }

    private final native ByteBuffer importByteBuffer();

    public final int b(int i2) {
        MapBuffer.m0.getClass();
        IntRange intRange = MapBuffer.Companion.f18721b;
        int i3 = intRange.f53838a;
        if (i2 <= intRange.f53839b && i3 <= i2) {
            short s = (short) i2;
            UShort.Companion companion = UShort.f53567b;
            int i4 = this.f18734c - 1;
            int i5 = 0;
            while (i5 <= i4) {
                int i6 = (i5 + i4) >>> 1;
                int i7 = i(d(i6)) & 65535;
                int i8 = 65535 & s;
                if (Intrinsics.e(i7, i8) < 0) {
                    i5 = i6 + 1;
                } else {
                    if (Intrinsics.e(i7, i8) <= 0) {
                        return i6;
                    }
                    i4 = i6 - 1;
                }
            }
        }
        return -1;
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public final boolean c1(int i2) {
        return b(i2) != -1;
    }

    public final int d(int i2) {
        return (i2 * 12) + this.f18733b + 8;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ReadableMapBuffer)) {
            return false;
        }
        ByteBuffer byteBuffer = ((ReadableMapBuffer) obj).f18732a;
        ByteBuffer byteBuffer2 = this.f18732a;
        if (byteBuffer2 == byteBuffer) {
            return true;
        }
        byteBuffer2.rewind();
        byteBuffer.rewind();
        return byteBuffer2.equals(byteBuffer);
    }

    public final int f(int i2, MapBuffer.DataType dataType) {
        int iB = b(i2);
        if (iB == -1) {
            throw new IllegalArgumentException(b.f(i2, "Key not found: ").toString());
        }
        MapBuffer.DataType dataType2 = MapBuffer.DataType.values()[i(d(iB) + 2) & 65535];
        if (dataType2 == dataType) {
            return d(iB) + 4;
        }
        throw new IllegalStateException(("Expected " + dataType + " for key: " + i2 + ", found " + dataType2 + " instead.").toString());
    }

    public final String g(int i2) {
        int iD = d(this.f18734c);
        ByteBuffer byteBuffer = this.f18732a;
        int i3 = byteBuffer.getInt(i2) + iD;
        int i4 = byteBuffer.getInt(i3);
        byte[] bArr = new byte[i4];
        byteBuffer.position(i3 + 4);
        byteBuffer.get(bArr, 0, i4);
        return new String(bArr, Charsets.UTF_8);
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public final boolean getBoolean(int i2) {
        return this.f18732a.getInt(f(i2, MapBuffer.DataType.f18722a)) == 1;
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public final int getCount() {
        return this.f18734c;
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public final double getDouble(int i2) {
        return this.f18732a.getDouble(f(i2, MapBuffer.DataType.f18724c));
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public final int getInt(int i2) {
        return this.f18732a.getInt(f(i2, MapBuffer.DataType.f18723b));
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public final String getString(int i2) {
        return g(f(i2, MapBuffer.DataType.f18725d));
    }

    public final int hashCode() {
        ByteBuffer byteBuffer = this.f18732a;
        byteBuffer.rewind();
        return byteBuffer.hashCode();
    }

    public final short i(int i2) {
        short s = this.f18732a.getShort(i2);
        UShort.Companion companion = UShort.f53567b;
        return s;
    }

    @Override // java.lang.Iterable
    public final Iterator<MapBuffer.Entry> iterator() {
        return new AnonymousClass1();
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public final MapBuffer j0(int i2) {
        int iF = f(i2, MapBuffer.DataType.f18726e);
        int iD = d(this.f18734c);
        ByteBuffer byteBuffer = this.f18732a;
        return new ReadableMapBuffer(byteBuffer.getInt(iF) + iD + 4, byteBuffer);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        CollectionsKt.D(this, sb, null, new r(9), 62);
        sb.append('}');
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public ReadableMapBuffer(int i2, ByteBuffer byteBuffer) {
        this.mHybridData = null;
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position(i2);
        this.f18732a = byteBufferDuplicate;
        this.f18733b = i2;
        if (byteBufferDuplicate.getShort() != 254) {
            byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
        }
        this.f18734c = i(byteBufferDuplicate.position()) & 65535;
    }
}
