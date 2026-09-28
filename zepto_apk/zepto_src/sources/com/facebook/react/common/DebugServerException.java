package com.facebook.react.common;

import android.net.Uri;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes3.dex */
public final class DebugServerException extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f18690a = 0;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        public static DebugServerException a(String url, String reason, String extra, Exception exc) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(reason, "reason");
            Intrinsics.checkNotNullParameter(extra, "extra");
            Uri uri = Uri.parse(url);
            int i2 = DebugServerException.f18690a;
            String detailMessage = reason + StringsKt.K("\n\nTry the following to fix the issue:\n\\u2022 Ensure that Metro is running\n\\u2022 Ensure that your device/emulator is connected to your machine and has USB debugging enabled - run 'adb devices' to see a list of connected devices\n\\u2022 Ensure Airplane Mode is disabled\n\\u2022 If you're on a physical device connected to the same machine, run 'adb reverse tcp:<PORT> tcp:<PORT> to forward requests from your device\n\\u2022 If your device is on the same Wi-Fi network, set 'Debug server host & port for device' in 'Dev settings' to your machine's IP address and the port of the local dev server - e.g. 10.0.1.1:<PORT>\n\n", "<PORT>", String.valueOf(uri.getPort())) + extra;
            Intrinsics.checkNotNullParameter(detailMessage, "detailMessage");
            return new DebugServerException(detailMessage, exc);
        }

        public static String b(String str) {
            Collection collectionZ;
            List listE = new Regex("/").e(str);
            if (listE.isEmpty()) {
                collectionZ = EmptyList.f53609a;
            } else {
                ListIterator listIterator = listE.listIterator(listE.size());
                while (listIterator.hasPrevious()) {
                    if (((String) listIterator.previous()).length() != 0) {
                        collectionZ = CollectionsKt.Z(listE, listIterator.nextIndex() + 1);
                        break;
                    }
                }
                collectionZ = EmptyList.f53609a;
            }
            String[] strArr = (String[]) collectionZ.toArray(new String[0]);
            Intrinsics.checkNotNullParameter(strArr, "<this>");
            if (strArr.length == 0) {
                throw new NoSuchElementException("Array is empty.");
            }
            Intrinsics.checkNotNullParameter(strArr, "<this>");
            return strArr[strArr.length - 1];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugServerException(String description) {
        super(description);
        Intrinsics.checkNotNullParameter(description, "description");
    }
}
