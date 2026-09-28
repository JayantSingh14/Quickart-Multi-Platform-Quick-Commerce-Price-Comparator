package com.cardreader.card_reader_lib.xutils;

import com.cardreader.card_reader_lib.enumModel.TagValueTypeEnum;
import java.util.LinkedHashMap;

/* loaded from: classes3.dex */
public final class EmvTags {

    /* renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap f16569a = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final TagImpl f16570b;

    /* renamed from: c, reason: collision with root package name */
    public static final TagImpl f16571c;

    /* renamed from: d, reason: collision with root package name */
    public static final TagImpl f16572d;

    /* renamed from: e, reason: collision with root package name */
    public static final TagImpl f16573e;

    /* renamed from: f, reason: collision with root package name */
    public static final TagImpl f16574f;

    /* renamed from: g, reason: collision with root package name */
    public static final TagImpl f16575g;

    /* renamed from: h, reason: collision with root package name */
    public static final TagImpl f16576h;

    /* renamed from: i, reason: collision with root package name */
    public static final TagImpl f16577i;

    /* renamed from: j, reason: collision with root package name */
    public static final TagImpl f16578j;

    /* renamed from: k, reason: collision with root package name */
    public static final TagImpl f16579k;

    static {
        TagValueTypeEnum tagValueTypeEnum = TagValueTypeEnum.f16550a;
        f16570b = new TagImpl("4f", tagValueTypeEnum, "Application Identifier (AID) - card");
        f16571c = new TagImpl("84", tagValueTypeEnum, "Dedicated File (DF) Name");
        f16572d = new TagImpl("57", tagValueTypeEnum, "Track 2 Equivalent Data");
        f16573e = new TagImpl("80", tagValueTypeEnum, "Response Message Template Format 1");
        f16574f = new TagImpl("83", tagValueTypeEnum, "Command Template");
        f16575g = new TagImpl("94", tagValueTypeEnum, "Application File Locator (AFL)");
        f16576h = new TagImpl("9f38", TagValueTypeEnum.f16551b, "Processing Options Data Object List (PDOL)");
        f16577i = new TagImpl("9f66", tagValueTypeEnum, "Terminal Transaction Qualifiers");
        f16578j = new TagImpl("9f6b", tagValueTypeEnum, "Track 2 Data");
        f16579k = new TagImpl("9f2a", tagValueTypeEnum, "The value to be appended to the ADF Name in the data field of the SELECT command, if the Extended Selection Support flag is present and set to 1");
    }

    public static void a() {
        b(f16570b);
        b(f16571c);
        b(f16572d);
        b(f16573e);
        b(f16574f);
        b(f16575g);
        b(f16576h);
        b(f16577i);
        b(f16578j);
        b(f16579k);
    }

    public static void b(TagImpl tagImpl) {
        byte[] bArr = tagImpl.f16589a;
        bArr.getClass();
        f16569a.put(new ByteArrayWrapper(bArr), tagImpl);
    }
}
