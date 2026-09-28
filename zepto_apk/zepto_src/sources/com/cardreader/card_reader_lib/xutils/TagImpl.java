package com.cardreader.card_reader_lib.xutils;

import com.cardreader.card_reader_lib.enumModel.TagTypeEnum;
import com.cardreader.card_reader_lib.enumModel.TagValueTypeEnum;
import com.cardreader.card_reader_lib.xutils.ITag;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class TagImpl implements ITag {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f16589a;

    /* renamed from: b, reason: collision with root package name */
    public final String f16590b;

    /* renamed from: c, reason: collision with root package name */
    public final TagValueTypeEnum f16591c;

    /* renamed from: d, reason: collision with root package name */
    public final ITag.Class f16592d;

    /* renamed from: e, reason: collision with root package name */
    public final TagTypeEnum f16593e;

    public TagImpl(String str, TagValueTypeEnum tagValueTypeEnum, String str2) {
        this(BytesUtils.b(str), tagValueTypeEnum, str2);
    }

    @Override // com.cardreader.card_reader_lib.xutils.ITag
    public final byte[] a() {
        return this.f16589a;
    }

    @Override // com.cardreader.card_reader_lib.xutils.ITag
    public final boolean b() {
        return this.f16593e == TagTypeEnum.f16548b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ITag)) {
            return false;
        }
        ITag iTag = (ITag) obj;
        byte[] bArr = this.f16589a;
        if (bArr.length != iTag.a().length) {
            return false;
        }
        return Arrays.equals(bArr, iTag.a());
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f16589a) + 177;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Tag[");
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bArr = this.f16589a;
        if (bArr == null) {
            stringBuffer.append("");
        } else {
            for (byte b2 : bArr) {
                stringBuffer.append(String.format("%02x ", Integer.valueOf(b2 & 255)));
            }
        }
        sb.append(stringBuffer.toString().toUpperCase(Locale.getDefault()).trim());
        sb.append("] Name=");
        sb.append(this.f16590b);
        sb.append(", TagType=");
        sb.append(this.f16593e);
        sb.append(", ValueType=");
        sb.append(this.f16591c);
        sb.append(", Class=");
        sb.append(this.f16592d);
        return sb.toString();
    }

    public TagImpl(byte[] bArr, TagValueTypeEnum tagValueTypeEnum, String str) {
        if (bArr == null) {
            throw new IllegalArgumentException("Param id cannot be null");
        }
        if (bArr.length == 0) {
            throw new IllegalArgumentException("Param id cannot be empty");
        }
        this.f16589a = bArr;
        this.f16590b = str;
        this.f16591c = tagValueTypeEnum;
        if (BytesUtils.c(bArr[0], 5)) {
            this.f16593e = TagTypeEnum.f16548b;
        } else {
            this.f16593e = TagTypeEnum.f16547a;
        }
        byte b2 = (byte) ((bArr[0] >>> 6) & 3);
        if (b2 == 1) {
            this.f16592d = ITag.Class.f16581b;
            return;
        }
        if (b2 == 2) {
            this.f16592d = ITag.Class.f16582c;
        } else if (b2 != 3) {
            this.f16592d = ITag.Class.f16580a;
        } else {
            this.f16592d = ITag.Class.f16583d;
        }
    }
}
