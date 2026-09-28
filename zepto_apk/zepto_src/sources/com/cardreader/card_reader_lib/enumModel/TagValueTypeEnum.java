package com.cardreader.card_reader_lib.enumModel;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class TagValueTypeEnum {

    /* renamed from: a, reason: collision with root package name */
    public static final TagValueTypeEnum f16550a;

    /* renamed from: b, reason: collision with root package name */
    public static final TagValueTypeEnum f16551b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ TagValueTypeEnum[] f16552c;

    static {
        TagValueTypeEnum tagValueTypeEnum = new TagValueTypeEnum("BINARY", 0);
        f16550a = tagValueTypeEnum;
        TagValueTypeEnum tagValueTypeEnum2 = new TagValueTypeEnum("NUMERIC", 1);
        TagValueTypeEnum tagValueTypeEnum3 = new TagValueTypeEnum("TEXT", 2);
        TagValueTypeEnum tagValueTypeEnum4 = new TagValueTypeEnum("MIXED", 3);
        TagValueTypeEnum tagValueTypeEnum5 = new TagValueTypeEnum("DOL", 4);
        f16551b = tagValueTypeEnum5;
        f16552c = new TagValueTypeEnum[]{tagValueTypeEnum, tagValueTypeEnum2, tagValueTypeEnum3, tagValueTypeEnum4, tagValueTypeEnum5, new TagValueTypeEnum("TEMPLATE", 5)};
    }

    public static TagValueTypeEnum valueOf(String str) {
        return (TagValueTypeEnum) Enum.valueOf(TagValueTypeEnum.class, str);
    }

    public static TagValueTypeEnum[] values() {
        return (TagValueTypeEnum[]) f16552c.clone();
    }
}
