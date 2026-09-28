package okio;

import java.util.ArrayList;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
/* loaded from: classes.dex */
public final class Options extends AbstractList<ByteString> implements RandomAccess {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f56967d = 0;

    /* renamed from: b, reason: collision with root package name */
    public final ByteString[] f56968b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f56969c;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        public static void a(long j2, Buffer buffer, int i2, ArrayList arrayList, int i3, int i4, ArrayList arrayList2) {
            int i5;
            int i6;
            ArrayList arrayList3;
            long j3;
            int i7;
            int i8 = i2;
            ArrayList arrayList4 = arrayList;
            ArrayList arrayList5 = arrayList2;
            if (i3 >= i4) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            for (int i9 = i3; i9 < i4; i9++) {
                if (((ByteString) arrayList4.get(i9)).d() < i8) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
            }
            ByteString byteString = (ByteString) arrayList.get(i3);
            ByteString byteString2 = (ByteString) arrayList4.get(i4 - 1);
            if (i8 == byteString.d()) {
                int iIntValue = ((Number) arrayList5.get(i3)).intValue();
                int i10 = i3 + 1;
                ByteString byteString3 = (ByteString) arrayList4.get(i10);
                i5 = i10;
                i6 = iIntValue;
                byteString = byteString3;
            } else {
                i5 = i3;
                i6 = -1;
            }
            if (byteString.l(i8) == byteString2.l(i8)) {
                int iMin = Math.min(byteString.d(), byteString2.d());
                int i11 = 0;
                for (int i12 = i8; i12 < iMin && byteString.l(i12) == byteString2.l(i12); i12++) {
                    i11++;
                }
                long j4 = 4;
                long j5 = (buffer.f56914b / j4) + j2 + 2 + i11 + 1;
                buffer.U1(-i11);
                buffer.U1(i6);
                int i13 = i8 + i11;
                while (i8 < i13) {
                    buffer.U1(byteString.l(i8) & 255);
                    i8++;
                }
                if (i5 + 1 == i4) {
                    if (i13 != ((ByteString) arrayList4.get(i5)).d()) {
                        throw new IllegalStateException("Check failed.");
                    }
                    buffer.U1(((Number) arrayList5.get(i5)).intValue());
                    return;
                } else {
                    Buffer buffer2 = new Buffer();
                    buffer.U1(((int) ((buffer2.f56914b / j4) + j5)) * (-1));
                    a(j5, buffer2, i13, arrayList4, i5, i4, arrayList5);
                    buffer.g0(buffer2);
                    return;
                }
            }
            int i14 = 1;
            for (int i15 = i5 + 1; i15 < i4; i15++) {
                if (((ByteString) arrayList4.get(i15 - 1)).l(i8) != ((ByteString) arrayList4.get(i15)).l(i8)) {
                    i14++;
                }
            }
            long j6 = 4;
            long j7 = (buffer.f56914b / j6) + j2 + 2 + (i14 * 2);
            buffer.U1(i14);
            buffer.U1(i6);
            for (int i16 = i5; i16 < i4; i16++) {
                int iL = ((ByteString) arrayList4.get(i16)).l(i8);
                if (i16 == i5 || iL != ((ByteString) arrayList4.get(i16 - 1)).l(i8)) {
                    buffer.U1(iL & 255);
                }
            }
            Buffer buffer3 = new Buffer();
            int i17 = i5;
            while (i17 < i4) {
                byte bL = ((ByteString) arrayList4.get(i17)).l(i8);
                int i18 = i17 + 1;
                int i19 = i18;
                while (true) {
                    if (i19 >= i4) {
                        i19 = i4;
                        break;
                    } else if (bL != ((ByteString) arrayList4.get(i19)).l(i8)) {
                        break;
                    } else {
                        i19++;
                    }
                }
                if (i18 == i19 && i8 + 1 == ((ByteString) arrayList4.get(i17)).d()) {
                    buffer.U1(((Number) arrayList5.get(i17)).intValue());
                    arrayList3 = arrayList5;
                    j3 = j7;
                    i7 = i19;
                } else {
                    buffer.U1(((int) ((buffer3.f56914b / j6) + j7)) * (-1));
                    arrayList3 = arrayList5;
                    j3 = j7;
                    i7 = i19;
                    a(j3, buffer3, i8 + 1, arrayList, i17, i7, arrayList3);
                    arrayList4 = arrayList;
                }
                j7 = j3;
                i17 = i7;
                arrayList5 = arrayList3;
            }
            buffer.g0(buffer3);
        }

        /* JADX WARN: Code restructure failed: missing block: B:43:0x00c7, code lost:
        
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static okio.Options b(okio.ByteString... r11) {
            /*
                Method dump skipped, instructions count: 262
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.Options.Companion.b(okio.ByteString[]):okio.Options");
        }
    }

    public Options(ByteString[] byteStringArr, int[] iArr) {
        this.f56968b = byteStringArr;
        this.f56969c = iArr;
    }

    @Override // kotlin.collections.AbstractCollection
    public final int b() {
        return this.f56968b.length;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return super.contains((ByteString) obj);
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final Object get(int i2) {
        return this.f56968b[i2];
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return super.indexOf((ByteString) obj);
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return super.lastIndexOf((ByteString) obj);
        }
        return -1;
    }
}
