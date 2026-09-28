package com.amazon.android.apay.commonlibrary.instrumentationlib.utils;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f14922a = new b();

    static {
        Reflection.a(b.class).i();
    }

    public static String a(com.amazon.android.apay.commonlibrary.instrumentationlib.writer.a fileWriter, String currentActiveFile, String eventType) {
        Intrinsics.checkNotNullParameter(fileWriter, "fileWriter");
        Intrinsics.checkNotNullParameter(currentActiveFile, "currentActiveFile");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        StringBuilder sb = new StringBuilder();
        String strSubstring = currentActiveFile.substring(0, currentActiveFile.length() - 4);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        sb.append(strSubstring);
        sb.append(".log");
        String string = sb.toString();
        try {
            fileWriter.c(currentActiveFile, string, eventType);
            return string;
        } catch (Exception e2) {
            fileWriter.b(currentActiveFile, eventType);
            throw e2;
        }
    }

    public static void b(ArrayList listOfFiles, com.amazon.android.apay.commonlibrary.instrumentationlib.writer.a fileWriter, String eventType) {
        Intrinsics.checkNotNullParameter(listOfFiles, "listOfFiles");
        Intrinsics.checkNotNullParameter(fileWriter, "fileWriter");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        if (listOfFiles.size() > 30) {
            CollectionsKt.V(listOfFiles);
            fileWriter.b((String) CollectionsKt.z(listOfFiles), eventType);
            CollectionsKt.O(listOfFiles);
        }
    }
}
