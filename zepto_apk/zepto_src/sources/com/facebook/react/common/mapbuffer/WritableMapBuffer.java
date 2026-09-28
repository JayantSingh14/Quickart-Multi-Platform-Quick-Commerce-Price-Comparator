package com.facebook.react.common.mapbuffer;

import android.support.v4.media.b;
import android.util.SparseArray;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.common.mapbuffer.MapBuffer;
import java.util.Iterator;
import javax.annotation.concurrent.NotThreadSafe;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;

@DoNotStrip
@NotThreadSafe
@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class WritableMapBuffer implements MapBuffer {

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f18740a = new SparseArray();

    @Metadata
    public static final class Companion {
    }

    @Metadata
    @SourceDebugExtension
    public final class MapBufferEntry implements MapBuffer.Entry {

        /* renamed from: a, reason: collision with root package name */
        public final int f18741a;

        /* renamed from: b, reason: collision with root package name */
        public final int f18742b;

        /* renamed from: c, reason: collision with root package name */
        public final MapBuffer.DataType f18743c;

        public MapBufferEntry(int i2) {
            MapBuffer.DataType dataType;
            this.f18741a = i2;
            SparseArray sparseArray = WritableMapBuffer.this.f18740a;
            int iKeyAt = sparseArray.keyAt(i2);
            this.f18742b = iKeyAt;
            Object objValueAt = sparseArray.valueAt(i2);
            Intrinsics.checkNotNullExpressionValue(objValueAt, "valueAt(...)");
            if (objValueAt instanceof Boolean) {
                dataType = MapBuffer.DataType.f18722a;
            } else if (objValueAt instanceof Integer) {
                dataType = MapBuffer.DataType.f18723b;
            } else if (objValueAt instanceof Long) {
                dataType = MapBuffer.DataType.f18727f;
            } else if (objValueAt instanceof Double) {
                dataType = MapBuffer.DataType.f18724c;
            } else if (objValueAt instanceof String) {
                dataType = MapBuffer.DataType.f18725d;
            } else {
                if (!(objValueAt instanceof MapBuffer)) {
                    throw new IllegalStateException("Key " + iKeyAt + " has value of unknown type: " + objValueAt.getClass());
                }
                dataType = MapBuffer.DataType.f18726e;
            }
            this.f18743c = dataType;
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public final long a() {
            Object objValueAt = WritableMapBuffer.this.f18740a.valueAt(this.f18741a);
            int i2 = this.f18742b;
            if (objValueAt == null) {
                throw new IllegalArgumentException(b.f(i2, "Key not found: ").toString());
            }
            if (objValueAt instanceof Long) {
                return ((Number) objValueAt).longValue();
            }
            throw new IllegalStateException(("Expected " + Long.class + " for key: " + i2 + ", found " + objValueAt.getClass() + " instead.").toString());
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public final double b() {
            Object objValueAt = WritableMapBuffer.this.f18740a.valueAt(this.f18741a);
            int i2 = this.f18742b;
            if (objValueAt == null) {
                throw new IllegalArgumentException(b.f(i2, "Key not found: ").toString());
            }
            if (objValueAt instanceof Double) {
                return ((Number) objValueAt).doubleValue();
            }
            throw new IllegalStateException(("Expected " + Double.class + " for key: " + i2 + ", found " + objValueAt.getClass() + " instead.").toString());
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public final String c() {
            Object objValueAt = WritableMapBuffer.this.f18740a.valueAt(this.f18741a);
            int i2 = this.f18742b;
            if (objValueAt == null) {
                throw new IllegalArgumentException(b.f(i2, "Key not found: ").toString());
            }
            if (objValueAt instanceof String) {
                return (String) objValueAt;
            }
            throw new IllegalStateException(("Expected " + String.class + " for key: " + i2 + ", found " + objValueAt.getClass() + " instead.").toString());
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public final int d() {
            Object objValueAt = WritableMapBuffer.this.f18740a.valueAt(this.f18741a);
            int i2 = this.f18742b;
            if (objValueAt == null) {
                throw new IllegalArgumentException(b.f(i2, "Key not found: ").toString());
            }
            if (objValueAt instanceof Integer) {
                return ((Number) objValueAt).intValue();
            }
            throw new IllegalStateException(("Expected " + Integer.class + " for key: " + i2 + ", found " + objValueAt.getClass() + " instead.").toString());
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public final MapBuffer e() {
            Object objValueAt = WritableMapBuffer.this.f18740a.valueAt(this.f18741a);
            int i2 = this.f18742b;
            if (objValueAt == null) {
                throw new IllegalArgumentException(b.f(i2, "Key not found: ").toString());
            }
            if (objValueAt instanceof MapBuffer) {
                return (MapBuffer) objValueAt;
            }
            throw new IllegalStateException(("Expected " + MapBuffer.class + " for key: " + i2 + ", found " + objValueAt.getClass() + " instead.").toString());
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public final boolean f() {
            Object objValueAt = WritableMapBuffer.this.f18740a.valueAt(this.f18741a);
            int i2 = this.f18742b;
            if (objValueAt == null) {
                throw new IllegalArgumentException(b.f(i2, "Key not found: ").toString());
            }
            if (objValueAt instanceof Boolean) {
                return ((Boolean) objValueAt).booleanValue();
            }
            throw new IllegalStateException(("Expected " + Boolean.class + " for key: " + i2 + ", found " + objValueAt.getClass() + " instead.").toString());
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public final int getKey() {
            return this.f18742b;
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public final MapBuffer.DataType getType() {
            return this.f18743c;
        }
    }

    @Metadata
    /* renamed from: com.facebook.react.common.mapbuffer.WritableMapBuffer$iterator$1, reason: invalid class name */
    public final class AnonymousClass1 implements Iterator<MapBuffer.Entry>, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        public int f18745a;

        public AnonymousClass1() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f18745a < WritableMapBuffer.this.f18740a.size();
        }

        @Override // java.util.Iterator
        public final MapBuffer.Entry next() {
            int i2 = this.f18745a;
            this.f18745a = i2 + 1;
            return WritableMapBuffer.this.new MapBufferEntry(i2);
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
    private final int[] getKeys() {
        SparseArray sparseArray = this.f18740a;
        int size = sparseArray.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = sparseArray.keyAt(i2);
        }
        return iArr;
    }

    @DoNotStrip
    private final Object[] getValues() {
        SparseArray sparseArray = this.f18740a;
        int size = sparseArray.size();
        Object[] objArr = new Object[size];
        for (int i2 = 0; i2 < size; i2++) {
            Object objValueAt = sparseArray.valueAt(i2);
            Intrinsics.checkNotNullExpressionValue(objValueAt, "valueAt(...)");
            objArr[i2] = objValueAt;
        }
        return objArr;
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public final boolean c1(int i2) {
        return this.f18740a.get(i2) != null;
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public final boolean getBoolean(int i2) {
        Object obj = this.f18740a.get(i2);
        if (obj == null) {
            throw new IllegalArgumentException(b.f(i2, "Key not found: ").toString());
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        throw new IllegalStateException(("Expected " + Boolean.class + " for key: " + i2 + ", found " + obj.getClass() + " instead.").toString());
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public final int getCount() {
        return this.f18740a.size();
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public final double getDouble(int i2) {
        Object obj = this.f18740a.get(i2);
        if (obj == null) {
            throw new IllegalArgumentException(b.f(i2, "Key not found: ").toString());
        }
        if (obj instanceof Double) {
            return ((Number) obj).doubleValue();
        }
        throw new IllegalStateException(("Expected " + Double.class + " for key: " + i2 + ", found " + obj.getClass() + " instead.").toString());
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public final int getInt(int i2) {
        Object obj = this.f18740a.get(i2);
        if (obj == null) {
            throw new IllegalArgumentException(b.f(i2, "Key not found: ").toString());
        }
        if (obj instanceof Integer) {
            return ((Number) obj).intValue();
        }
        throw new IllegalStateException(("Expected " + Integer.class + " for key: " + i2 + ", found " + obj.getClass() + " instead.").toString());
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public final String getString(int i2) {
        Object obj = this.f18740a.get(i2);
        if (obj == null) {
            throw new IllegalArgumentException(b.f(i2, "Key not found: ").toString());
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        throw new IllegalStateException(("Expected " + String.class + " for key: " + i2 + ", found " + obj.getClass() + " instead.").toString());
    }

    @Override // java.lang.Iterable
    public final Iterator<MapBuffer.Entry> iterator() {
        return new AnonymousClass1();
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public final MapBuffer j0(int i2) {
        Object obj = this.f18740a.get(i2);
        if (obj == null) {
            throw new IllegalArgumentException(b.f(i2, "Key not found: ").toString());
        }
        if (obj instanceof MapBuffer) {
            return (MapBuffer) obj;
        }
        throw new IllegalStateException(("Expected " + MapBuffer.class + " for key: " + i2 + ", found " + obj.getClass() + " instead.").toString());
    }
}
