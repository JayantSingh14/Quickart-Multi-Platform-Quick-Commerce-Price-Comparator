package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.util.Comparator;

/* loaded from: classes3.dex */
public class Table {

    /* renamed from: a, reason: collision with root package name */
    public int f4385a;

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f4386b;

    /* renamed from: c, reason: collision with root package name */
    public int f4387c;

    /* renamed from: d, reason: collision with root package name */
    public int f4388d;

    /* renamed from: androidx.emoji2.text.flatbuffer.Table$1, reason: invalid class name */
    class AnonymousClass1 implements Comparator<Integer> {
        @Override // java.util.Comparator
        public final int compare(Integer num, Integer num2) {
            throw null;
        }
    }

    public Table() {
        if (Utf8.f4389a == null) {
            Utf8.f4389a = new Utf8Safe();
        }
    }

    public final int a(int i2) {
        if (i2 < this.f4388d) {
            return this.f4386b.getShort(this.f4387c + i2);
        }
        return 0;
    }
}
