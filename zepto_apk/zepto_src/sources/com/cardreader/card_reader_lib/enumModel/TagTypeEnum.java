package com.cardreader.card_reader_lib.enumModel;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class TagTypeEnum {

    /* renamed from: a, reason: collision with root package name */
    public static final TagTypeEnum f16547a;

    /* renamed from: b, reason: collision with root package name */
    public static final TagTypeEnum f16548b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ TagTypeEnum[] f16549c;

    static {
        TagTypeEnum tagTypeEnum = new TagTypeEnum("PRIMITIVE", 0);
        f16547a = tagTypeEnum;
        TagTypeEnum tagTypeEnum2 = new TagTypeEnum("CONSTRUCTED", 1);
        f16548b = tagTypeEnum2;
        f16549c = new TagTypeEnum[]{tagTypeEnum, tagTypeEnum2};
    }

    public static TagTypeEnum valueOf(String str) {
        return (TagTypeEnum) Enum.valueOf(TagTypeEnum.class, str);
    }

    public static TagTypeEnum[] values() {
        return (TagTypeEnum[]) f16549c.clone();
    }
}
