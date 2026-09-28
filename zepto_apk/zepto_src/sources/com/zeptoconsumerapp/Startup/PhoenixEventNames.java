package com.zeptoconsumerapp.Startup;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class PhoenixEventNames {
    public static Set a() {
        String[] elements = {"UPDATE_STATUS", "DOWNLOADING_START", "DOWNLOAD_BUNDLE_FROM_SERVER_FAILED", "UNZIPPED_BUNDLE_STATUS", "DOWNLOAD_BUNDLE_REQUEST_SUCCESS", "GET_UPDATE_REQUEST_SUCCESS", "BUNDLE_MD5_STATUS", "DOWNLOAD_PATCH_FROM_SERVER_FAILED", "DOWNLOAD_PATCH_REQUEST_SUCCESS", "UNZIPPED_PATCH_STATUS", "PATCH_APPLICATION_STATUS", "PATCH_MD5_STATUS"};
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ArraysKt.H(elements);
    }
}
