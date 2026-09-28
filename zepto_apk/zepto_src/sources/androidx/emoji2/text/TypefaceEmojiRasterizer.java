package androidx.emoji2.text;

import androidx.annotation.AnyThread;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import org.apache.commons.lang3.StringUtils;

@AnyThread
@RequiresApi
/* loaded from: classes3.dex */
public class TypefaceEmojiRasterizer {

    /* renamed from: d, reason: collision with root package name */
    public static final ThreadLocal f4354d = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    public final int f4355a;

    /* renamed from: b, reason: collision with root package name */
    public final MetadataRepo f4356b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f4357c = 0;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface HasGlyph {
    }

    public TypefaceEmojiRasterizer(MetadataRepo metadataRepo, int i2) {
        this.f4356b = metadataRepo;
        this.f4355a = i2;
    }

    public final int a(int i2) {
        MetadataItem metadataItemB = b();
        int iA = metadataItemB.a(16);
        if (iA == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = metadataItemB.f4386b;
        int i3 = iA + metadataItemB.f4385a;
        return byteBuffer.getInt((i2 * 4) + byteBuffer.getInt(i3) + i3 + 4);
    }

    public final MetadataItem b() {
        ThreadLocal threadLocal = f4354d;
        MetadataItem metadataItem = (MetadataItem) threadLocal.get();
        if (metadataItem == null) {
            metadataItem = new MetadataItem();
            threadLocal.set(metadataItem);
        }
        MetadataList metadataList = this.f4356b.f4344a;
        int iA = metadataList.a(6);
        if (iA != 0) {
            int i2 = iA + metadataList.f4385a;
            int i3 = (this.f4355a * 4) + metadataList.f4386b.getInt(i2) + i2 + 4;
            int i4 = metadataList.f4386b.getInt(i3) + i3;
            ByteBuffer byteBuffer = metadataList.f4386b;
            metadataItem.f4386b = byteBuffer;
            if (byteBuffer != null) {
                metadataItem.f4385a = i4;
                int i5 = i4 - byteBuffer.getInt(i4);
                metadataItem.f4387c = i5;
                metadataItem.f4388d = metadataItem.f4386b.getShort(i5);
                return metadataItem;
            }
            metadataItem.f4385a = 0;
            metadataItem.f4387c = 0;
            metadataItem.f4388d = 0;
        }
        return metadataItem;
    }

    public final String toString() {
        int i2;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        MetadataItem metadataItemB = b();
        int iA = metadataItemB.a(4);
        sb.append(Integer.toHexString(iA != 0 ? metadataItemB.f4386b.getInt(iA + metadataItemB.f4385a) : 0));
        sb.append(", codepoints:");
        MetadataItem metadataItemB2 = b();
        int iA2 = metadataItemB2.a(16);
        if (iA2 != 0) {
            int i3 = iA2 + metadataItemB2.f4385a;
            i2 = metadataItemB2.f4386b.getInt(metadataItemB2.f4386b.getInt(i3) + i3);
        } else {
            i2 = 0;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            sb.append(Integer.toHexString(a(i4)));
            sb.append(StringUtils.SPACE);
        }
        return sb.toString();
    }
}
