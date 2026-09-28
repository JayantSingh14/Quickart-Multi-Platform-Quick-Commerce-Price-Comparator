package com.facebook.imageformat;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata
/* loaded from: classes3.dex */
public final class DefaultImageFormats {

    /* renamed from: a, reason: collision with root package name */
    public static final ImageFormat f17681a;

    /* renamed from: b, reason: collision with root package name */
    public static final ImageFormat f17682b;

    /* renamed from: c, reason: collision with root package name */
    public static final ImageFormat f17683c;

    /* renamed from: d, reason: collision with root package name */
    public static final ImageFormat f17684d;

    /* renamed from: e, reason: collision with root package name */
    public static final ImageFormat f17685e;

    /* renamed from: f, reason: collision with root package name */
    public static final ImageFormat f17686f;

    /* renamed from: g, reason: collision with root package name */
    public static final ImageFormat f17687g;

    /* renamed from: h, reason: collision with root package name */
    public static final ImageFormat f17688h;

    /* renamed from: i, reason: collision with root package name */
    public static final ImageFormat f17689i;

    /* renamed from: j, reason: collision with root package name */
    public static final ImageFormat f17690j;

    /* renamed from: k, reason: collision with root package name */
    public static final ImageFormat f17691k;

    /* renamed from: l, reason: collision with root package name */
    public static final ImageFormat f17692l;

    /* renamed from: m, reason: collision with root package name */
    public static final ImageFormat f17693m;
    public static final ImageFormat n;
    public static final List o;

    static {
        ImageFormat imageFormat = new ImageFormat("JPEG", "jpeg");
        f17681a = imageFormat;
        ImageFormat imageFormat2 = new ImageFormat("PNG", "png");
        f17682b = imageFormat2;
        ImageFormat imageFormat3 = new ImageFormat("GIF", "gif");
        f17683c = imageFormat3;
        ImageFormat imageFormat4 = new ImageFormat("BMP", "bmp");
        f17684d = imageFormat4;
        ImageFormat imageFormat5 = new ImageFormat("ICO", "ico");
        f17685e = imageFormat5;
        ImageFormat imageFormat6 = new ImageFormat("WEBP_SIMPLE", "webp");
        f17686f = imageFormat6;
        ImageFormat imageFormat7 = new ImageFormat("WEBP_LOSSLESS", "webp");
        f17687g = imageFormat7;
        ImageFormat imageFormat8 = new ImageFormat("WEBP_EXTENDED", "webp");
        f17688h = imageFormat8;
        ImageFormat imageFormat9 = new ImageFormat("WEBP_EXTENDED_WITH_ALPHA", "webp");
        f17689i = imageFormat9;
        ImageFormat imageFormat10 = new ImageFormat("WEBP_ANIMATED", "webp");
        f17690j = imageFormat10;
        ImageFormat imageFormat11 = new ImageFormat("HEIF", "heif");
        f17691k = imageFormat11;
        f17692l = new ImageFormat("DNG", "dng");
        ImageFormat imageFormat12 = new ImageFormat("BINARY_XML", "xml");
        f17693m = imageFormat12;
        ImageFormat imageFormat13 = new ImageFormat("AVIF", "avif");
        n = imageFormat13;
        o = CollectionsKt.I(imageFormat, imageFormat2, imageFormat3, imageFormat4, imageFormat5, imageFormat6, imageFormat7, imageFormat8, imageFormat9, imageFormat10, imageFormat11, imageFormat12, imageFormat13);
    }
}
