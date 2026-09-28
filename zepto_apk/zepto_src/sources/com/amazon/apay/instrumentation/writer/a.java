package com.amazon.apay.instrumentation.writer;

import android.content.Context;
import android.support.v4.media.b;
import androidx.fragment.app.e;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final File f15065a;

    /* renamed from: b, reason: collision with root package name */
    public final File f15066b;

    public a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File file = new File(context.getFilesDir().toString() + "/MetricEvent");
        this.f15065a = file;
        file.mkdir();
        File file2 = new File(context.getFilesDir().toString() + "/CrashEvent");
        this.f15066b = file2;
        file2.mkdir();
    }

    public final ArrayList a(String eventType) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        String[] list = ("MetricEvent".equals(eventType) ? this.f15065a : this.f15066b).list();
        Intrinsics.checkNotNullExpressionValue(list, "currDirectory.list()");
        return ArraysKt.G(list);
    }

    public final void b(String fileName, String eventType) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        new File("MetricEvent".equals(eventType) ? this.f15065a : this.f15066b, fileName).delete();
    }

    public final void c(String currFileName, String newFileName, String eventType) throws Exception {
        Intrinsics.checkNotNullParameter(currFileName, "currFileName");
        Intrinsics.checkNotNullParameter(newFileName, "newFileName");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        File file = "MetricEvent".equals(eventType) ? this.f15065a : this.f15066b;
        if (!new File(file, currFileName).renameTo(new File(file, newFileName))) {
            throw new Exception(e.p("Unable to rename file from ", currFileName, " to ", newFileName));
        }
    }

    public final long d(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter("MetricEvent", "eventType");
        return new File(this.f15065a, fileName).lastModified();
    }

    public final void e(String fileName, String data, String eventType) throws Exception {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File("MetricEvent".equals(eventType) ? this.f15065a : this.f15066b, fileName), true);
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                try {
                    Charset UTF_8 = StandardCharsets.UTF_8;
                    Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                    byte[] bytes = data.getBytes(UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    bufferedOutputStream.write(bytes);
                    bufferedOutputStream.close();
                    fileOutputStream.close();
                } finally {
                }
            } finally {
            }
        } catch (IOException e2) {
            throw new Exception(e.p("Unable to write data to file with file name: ", fileName, " and data: ", data), e2);
        }
    }

    public final String f(String fileName, String eventType) throws Exception {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        File file = "MetricEvent".equals(eventType) ? this.f15065a : this.f15066b;
        StringBuilder sb = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(file, fileName));
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                while (true) {
                    try {
                        int i2 = bufferedInputStream.read();
                        if (i2 == -1) {
                            bufferedInputStream.close();
                            fileInputStream.close();
                            String string = sb.toString();
                            Intrinsics.checkNotNullExpressionValue(string, "stringBuilder.toString()");
                            return string;
                        }
                        sb.append((char) i2);
                    } finally {
                    }
                }
            } finally {
            }
        } catch (IOException e2) {
            throw new Exception(b.C("Error occured when trying to read file with file name: ", fileName), e2);
        }
    }
}
