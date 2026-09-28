package com.facebook.react.views.image;

import com.amazon.identity.auth.device.authorization.RegionUtil;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class ImageResizeMethod {

    /* renamed from: a, reason: collision with root package name */
    public static final ImageResizeMethod f19945a;

    /* renamed from: b, reason: collision with root package name */
    public static final ImageResizeMethod f19946b;

    /* renamed from: c, reason: collision with root package name */
    public static final ImageResizeMethod f19947c;

    /* renamed from: d, reason: collision with root package name */
    public static final ImageResizeMethod f19948d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ ImageResizeMethod[] f19949e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f19950f;

    static {
        ImageResizeMethod imageResizeMethod = new ImageResizeMethod(RegionUtil.REGION_STRING_AUTO, 0);
        f19945a = imageResizeMethod;
        ImageResizeMethod imageResizeMethod2 = new ImageResizeMethod("RESIZE", 1);
        f19946b = imageResizeMethod2;
        ImageResizeMethod imageResizeMethod3 = new ImageResizeMethod("SCALE", 2);
        f19947c = imageResizeMethod3;
        ImageResizeMethod imageResizeMethod4 = new ImageResizeMethod("NONE", 3);
        f19948d = imageResizeMethod4;
        ImageResizeMethod[] imageResizeMethodArr = {imageResizeMethod, imageResizeMethod2, imageResizeMethod3, imageResizeMethod4};
        f19949e = imageResizeMethodArr;
        f19950f = EnumEntriesKt.a(imageResizeMethodArr);
    }

    public static ImageResizeMethod valueOf(String str) {
        return (ImageResizeMethod) Enum.valueOf(ImageResizeMethod.class, str);
    }

    public static ImageResizeMethod[] values() {
        return (ImageResizeMethod[]) f19949e.clone();
    }
}
