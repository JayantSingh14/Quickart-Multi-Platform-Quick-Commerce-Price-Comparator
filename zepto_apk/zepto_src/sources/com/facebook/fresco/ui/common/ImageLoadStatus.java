package com.facebook.fresco.ui.common;

import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.google.ads.interactivemedia.v3.impl.data.zzck;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class ImageLoadStatus {

    /* renamed from: a, reason: collision with root package name */
    public static final ImageLoadStatus f17468a;

    /* renamed from: b, reason: collision with root package name */
    public static final ImageLoadStatus f17469b;

    /* renamed from: c, reason: collision with root package name */
    public static final ImageLoadStatus f17470c;

    /* renamed from: d, reason: collision with root package name */
    public static final ImageLoadStatus f17471d;

    /* renamed from: e, reason: collision with root package name */
    public static final ImageLoadStatus f17472e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ ImageLoadStatus[] f17473f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f17474g;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
    }

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[ImageLoadStatus.values().length];
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                ImageLoadStatus imageLoadStatus = ImageLoadStatus.f17468a;
                iArr[3] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                ImageLoadStatus imageLoadStatus2 = ImageLoadStatus.f17468a;
                iArr[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                ImageLoadStatus imageLoadStatus3 = ImageLoadStatus.f17468a;
                iArr[4] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                ImageLoadStatus imageLoadStatus4 = ImageLoadStatus.f17468a;
                iArr[6] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        ImageLoadStatus imageLoadStatus = new ImageLoadStatus("UNKNOWN", 0);
        ImageLoadStatus imageLoadStatus2 = new ImageLoadStatus("REQUESTED", 1);
        f17468a = imageLoadStatus2;
        ImageLoadStatus imageLoadStatus3 = new ImageLoadStatus("INTERMEDIATE_AVAILABLE", 2);
        f17469b = imageLoadStatus3;
        ImageLoadStatus imageLoadStatus4 = new ImageLoadStatus(MerchantConstants.SUCCESS, 3);
        f17470c = imageLoadStatus4;
        ImageLoadStatus imageLoadStatus5 = new ImageLoadStatus(MerchantConstants.ERROR, 4);
        f17471d = imageLoadStatus5;
        ImageLoadStatus imageLoadStatus6 = new ImageLoadStatus("EMPTY_EVENT", 5);
        ImageLoadStatus imageLoadStatus7 = new ImageLoadStatus("RELEASED", 6);
        f17472e = imageLoadStatus7;
        ImageLoadStatus[] imageLoadStatusArr = {imageLoadStatus, imageLoadStatus2, imageLoadStatus3, imageLoadStatus4, imageLoadStatus5, imageLoadStatus6, imageLoadStatus7};
        f17473f = imageLoadStatusArr;
        f17474g = EnumEntriesKt.a(imageLoadStatusArr);
        values();
    }

    public static ImageLoadStatus valueOf(String str) {
        return (ImageLoadStatus) Enum.valueOf(ImageLoadStatus.class, str);
    }

    public static ImageLoadStatus[] values() {
        return (ImageLoadStatus[]) f17473f.clone();
    }

    @Override // java.lang.Enum
    public final String toString() {
        int iOrdinal = ordinal();
        return iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 4 ? iOrdinal != 6 ? zzck.UNKNOWN_CONTENT_TYPE : "released" : "error" : APayConstants.SUCCESS : "intermediate_available" : "requested";
    }
}
