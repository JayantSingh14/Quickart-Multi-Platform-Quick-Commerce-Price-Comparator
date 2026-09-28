package com.chuckerteam.chucker.internal.data.har.log.entry.response;

import android.support.v4.media.a;
import android.support.v4.media.b;
import androidx.fragment.app.e;
import coil3.network.internal.UtilsKt;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public final class Content {

    /* renamed from: a, reason: collision with root package name */
    public static final Content f16712a = new Content(0L, UtilsKt.MIME_TYPE_TEXT_PLAIN, "", 48);

    @SerializedName("comment")
    @Nullable
    private final String comment;

    @SerializedName("compression")
    @Nullable
    private final Integer compression;

    @SerializedName("encoding")
    @Nullable
    private final String encoding;

    @SerializedName("mimeType")
    @NotNull
    private final String mimeType;

    @SerializedName("size")
    @Nullable
    private final Long size;

    @SerializedName("text")
    @Nullable
    private final String text;

    @Metadata
    public static final class Companion {
    }

    public Content(Long l2, String mimeType, String str, int i2) {
        Integer num = (i2 & 2) != 0 ? null : 0;
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        this.size = l2;
        this.compression = num;
        this.mimeType = mimeType;
        this.text = str;
        this.encoding = null;
        this.comment = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Content)) {
            return false;
        }
        Content content = (Content) obj;
        return Intrinsics.b(this.size, content.size) && Intrinsics.b(this.compression, content.compression) && Intrinsics.b(this.mimeType, content.mimeType) && Intrinsics.b(this.text, content.text) && Intrinsics.b(this.encoding, content.encoding) && Intrinsics.b(this.comment, content.comment);
    }

    public final int hashCode() {
        Long l2 = this.size;
        int iHashCode = (l2 == null ? 0 : l2.hashCode()) * 31;
        Integer num = this.compression;
        int iE = e.e((iHashCode + (num == null ? 0 : num.hashCode())) * 31, 31, this.mimeType);
        String str = this.text;
        int iHashCode2 = (iE + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.encoding;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.comment;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        Long l2 = this.size;
        Integer num = this.compression;
        String str = this.mimeType;
        String str2 = this.text;
        String str3 = this.encoding;
        String str4 = this.comment;
        StringBuilder sb = new StringBuilder("Content(size=");
        sb.append(l2);
        sb.append(", compression=");
        sb.append(num);
        sb.append(", mimeType=");
        b.B(sb, str, ", text=", str2, ", encoding=");
        return a.n(sb, str3, ", comment=", str4, ")");
    }
}
