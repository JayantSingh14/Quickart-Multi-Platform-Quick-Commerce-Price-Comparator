package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.annotation.AnyThread;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import androidx.emoji2.text.flatbuffer.MetadataList;

@AnyThread
@RequiresApi
/* loaded from: classes3.dex */
public final class MetadataRepo {

    /* renamed from: a, reason: collision with root package name */
    public final MetadataList f4344a;

    /* renamed from: b, reason: collision with root package name */
    public final char[] f4345b;

    /* renamed from: c, reason: collision with root package name */
    public final Node f4346c = new Node(1024);

    /* renamed from: d, reason: collision with root package name */
    public final Typeface f4347d;

    @RestrictTo
    public static class Node {

        /* renamed from: a, reason: collision with root package name */
        public final SparseArray f4348a;

        /* renamed from: b, reason: collision with root package name */
        public TypefaceEmojiRasterizer f4349b;

        public Node(int i2) {
            this.f4348a = new SparseArray(i2);
        }

        public final void a(TypefaceEmojiRasterizer typefaceEmojiRasterizer, int i2, int i3) {
            int iA = typefaceEmojiRasterizer.a(i2);
            SparseArray sparseArray = this.f4348a;
            Node node = sparseArray == null ? null : (Node) sparseArray.get(iA);
            if (node == null) {
                node = new Node(1);
                sparseArray.put(typefaceEmojiRasterizer.a(i2), node);
            }
            if (i3 > i2) {
                node.a(typefaceEmojiRasterizer, i2 + 1, i3);
            } else {
                node.f4349b = typefaceEmojiRasterizer;
            }
        }
    }

    public MetadataRepo(Typeface typeface, MetadataList metadataList) {
        int i2;
        int i3;
        int i4;
        int i5;
        this.f4347d = typeface;
        this.f4344a = metadataList;
        int iA = metadataList.a(6);
        if (iA != 0) {
            int i6 = iA + metadataList.f4385a;
            i2 = metadataList.f4386b.getInt(metadataList.f4386b.getInt(i6) + i6);
        } else {
            i2 = 0;
        }
        this.f4345b = new char[i2 * 2];
        int iA2 = metadataList.a(6);
        if (iA2 != 0) {
            int i7 = iA2 + metadataList.f4385a;
            i3 = metadataList.f4386b.getInt(metadataList.f4386b.getInt(i7) + i7);
        } else {
            i3 = 0;
        }
        for (int i8 = 0; i8 < i3; i8++) {
            TypefaceEmojiRasterizer typefaceEmojiRasterizer = new TypefaceEmojiRasterizer(this, i8);
            MetadataItem metadataItemB = typefaceEmojiRasterizer.b();
            int iA3 = metadataItemB.a(4);
            Character.toChars(iA3 != 0 ? metadataItemB.f4386b.getInt(iA3 + metadataItemB.f4385a) : 0, this.f4345b, i8 * 2);
            MetadataItem metadataItemB2 = typefaceEmojiRasterizer.b();
            int iA4 = metadataItemB2.a(16);
            if (iA4 != 0) {
                int i9 = iA4 + metadataItemB2.f4385a;
                i4 = metadataItemB2.f4386b.getInt(metadataItemB2.f4386b.getInt(i9) + i9);
            } else {
                i4 = 0;
            }
            Preconditions.a(i4 > 0, "invalid metadata codepoint length");
            MetadataItem metadataItemB3 = typefaceEmojiRasterizer.b();
            int iA5 = metadataItemB3.a(16);
            if (iA5 != 0) {
                int i10 = iA5 + metadataItemB3.f4385a;
                i5 = metadataItemB3.f4386b.getInt(metadataItemB3.f4386b.getInt(i10) + i10);
            } else {
                i5 = 0;
            }
            this.f4346c.a(typefaceEmojiRasterizer, 0, i5 - 1);
        }
    }

    public final int a() {
        MetadataList metadataList = this.f4344a;
        int iA = metadataList.a(4);
        if (iA != 0) {
            return metadataList.f4386b.getInt(iA + metadataList.f4385a);
        }
        return 0;
    }
}
