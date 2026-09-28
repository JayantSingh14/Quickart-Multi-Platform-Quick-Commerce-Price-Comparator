package com.facebook.fresco.ui.common;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class ImageRenderingInfra {

    /* renamed from: a, reason: collision with root package name */
    public static final ImageRenderingInfra f17483a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ ImageRenderingInfra[] f17484b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f17485c;

    static {
        ImageRenderingInfra imageRenderingInfra = new ImageRenderingInfra("VITO_V2", 0);
        ImageRenderingInfra imageRenderingInfra2 = new ImageRenderingInfra("VITO_V1", 1);
        ImageRenderingInfra imageRenderingInfra3 = new ImageRenderingInfra("DRAWEE", 2);
        f17483a = imageRenderingInfra3;
        ImageRenderingInfra[] imageRenderingInfraArr = {imageRenderingInfra, imageRenderingInfra2, imageRenderingInfra3, new ImageRenderingInfra("OTHER", 3)};
        f17484b = imageRenderingInfraArr;
        f17485c = EnumEntriesKt.a(imageRenderingInfraArr);
    }

    public static ImageRenderingInfra valueOf(String str) {
        return (ImageRenderingInfra) Enum.valueOf(ImageRenderingInfra.class, str);
    }

    public static ImageRenderingInfra[] values() {
        return (ImageRenderingInfra[]) f17484b.clone();
    }
}
