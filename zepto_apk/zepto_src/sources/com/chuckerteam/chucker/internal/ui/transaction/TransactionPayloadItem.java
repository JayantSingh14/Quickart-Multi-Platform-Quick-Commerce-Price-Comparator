package com.chuckerteam.chucker.internal.ui.transaction;

import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public abstract class TransactionPayloadItem {

    @Metadata
    public static final class BodyLineItem extends TransactionPayloadItem {

        /* renamed from: a, reason: collision with root package name */
        public SpannableStringBuilder f16962a;

        public BodyLineItem(SpannableStringBuilder line) {
            Intrinsics.checkNotNullParameter(line, "line");
            this.f16962a = line;
        }
    }

    @Metadata
    public static final class CopyItem extends TransactionPayloadItem {
    }

    @Metadata
    public static final class HeaderItem extends TransactionPayloadItem {

        /* renamed from: a, reason: collision with root package name */
        public final Spanned f16963a;

        public HeaderItem(Spanned headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            this.f16963a = headers;
        }
    }

    @Metadata
    public static final class ImageItem extends TransactionPayloadItem {

        /* renamed from: a, reason: collision with root package name */
        public final Bitmap f16964a;

        /* renamed from: b, reason: collision with root package name */
        public final Double f16965b;

        public ImageItem(Bitmap image, Double d2) {
            Intrinsics.checkNotNullParameter(image, "image");
            this.f16964a = image;
            this.f16965b = d2;
        }
    }
}
