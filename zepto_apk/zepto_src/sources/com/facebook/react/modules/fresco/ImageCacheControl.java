package com.facebook.react.modules.fresco;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class ImageCacheControl {

    /* renamed from: a, reason: collision with root package name */
    public static final ImageCacheControl f19112a;

    /* renamed from: b, reason: collision with root package name */
    public static final ImageCacheControl f19113b;

    /* renamed from: c, reason: collision with root package name */
    public static final ImageCacheControl f19114c;

    /* renamed from: d, reason: collision with root package name */
    public static final ImageCacheControl f19115d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ ImageCacheControl[] f19116e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f19117f;

    static {
        ImageCacheControl imageCacheControl = new ImageCacheControl("DEFAULT", 0);
        f19112a = imageCacheControl;
        ImageCacheControl imageCacheControl2 = new ImageCacheControl("RELOAD", 1);
        f19113b = imageCacheControl2;
        ImageCacheControl imageCacheControl3 = new ImageCacheControl("FORCE_CACHE", 2);
        f19114c = imageCacheControl3;
        ImageCacheControl imageCacheControl4 = new ImageCacheControl("ONLY_IF_CACHED", 3);
        f19115d = imageCacheControl4;
        ImageCacheControl[] imageCacheControlArr = {imageCacheControl, imageCacheControl2, imageCacheControl3, imageCacheControl4};
        f19116e = imageCacheControlArr;
        f19117f = EnumEntriesKt.a(imageCacheControlArr);
    }

    public static ImageCacheControl valueOf(String str) {
        return (ImageCacheControl) Enum.valueOf(ImageCacheControl.class, str);
    }

    public static ImageCacheControl[] values() {
        return (ImageCacheControl[]) f19116e.clone();
    }
}
