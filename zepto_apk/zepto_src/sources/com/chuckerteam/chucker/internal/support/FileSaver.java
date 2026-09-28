package com.chuckerteam.chucker.internal.support;

import android.content.ContentResolver;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okio.Source;

@Metadata
/* loaded from: classes3.dex */
public final class FileSaver {
    public static Object a(Source source, Uri uri, ContentResolver contentResolver, SuspendLambda suspendLambda) {
        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
        return BuildersKt.e(DefaultIoScheduler.f55150b, new FileSaver$saveFile$2(contentResolver, uri, source, null), suspendLambda);
    }
}
