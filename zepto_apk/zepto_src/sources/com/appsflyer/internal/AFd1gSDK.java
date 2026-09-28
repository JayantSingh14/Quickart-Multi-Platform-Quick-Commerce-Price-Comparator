package com.appsflyer.internal;

import coil3.network.internal.UtilsKt;
import com.reactnativecommunity.clipboard.ClipboardModule;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public enum AFd1gSDK {
    TEXT(UtilsKt.MIME_TYPE_TEXT_PLAIN),
    JSON("application/json"),
    OCTET_STREAM("application/octet-stream"),
    XML("application/xml"),
    HTML("text/html"),
    FORM("application/x-www-form-urlencoded"),
    IMAGE_JPEG("image/jpeg"),
    IMAGE_PNG(ClipboardModule.MIMETYPE_PNG);


    @NotNull
    public final String getRevenue;

    AFd1gSDK(String str) {
        this.getRevenue = str;
    }
}
