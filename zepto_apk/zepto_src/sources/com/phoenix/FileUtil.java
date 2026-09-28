package com.phoenix;

import android.support.v4.media.b;
import com.phoenix.Phoenix;
import com.phoenix.PhoenixAnalyticsLogger;
import com.phoenix.PhoenixUtils;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.xbill.DNS.KEYRecord;

@Metadata
/* loaded from: classes4.dex */
public final class FileUtil {

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        public static String a(String base, String fileName) {
            Intrinsics.checkNotNullParameter(base, "base");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            String absolutePath = new File(b.l(base, "/", fileName)).getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
            return absolutePath;
        }

        public static String b(int i2, int i3, String str) {
            if (str != null) {
                String strI = i();
                StringBuilder sb = new StringBuilder();
                sb.append(strI);
                sb.append("/phoenix/");
                sb.append(i2);
                sb.append("-");
                sb.append(i3);
                String absolutePath = new File(b.r(sb, "/", str)).getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                return absolutePath;
            }
            String absolutePath2 = new File(i() + "/phoenix/" + i2 + "-" + i3 + "/").getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath2, "getAbsolutePath(...)");
            return absolutePath2;
        }

        public static String d(FileInputStream inputStream) throws NoSuchAlgorithmException, IOException {
            int i2;
            Intrinsics.checkNotNullParameter(inputStream, "inputStream");
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            byte[] bArr = new byte[4096];
            while (true) {
                int i3 = inputStream.read(bArr);
                if (i3 == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, i3);
            }
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b2 : bArrDigest) {
                String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b2)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                sb.append(str);
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        public static boolean e(File sourceDir, File targetDir) throws IOException {
            ArrayList<File> arrayList;
            Intrinsics.checkNotNullParameter(sourceDir, "sourceDir");
            Intrinsics.checkNotNullParameter(targetDir, "targetDir");
            try {
                File[] fileArrListFiles = sourceDir.listFiles();
                if (fileArrListFiles != null) {
                    arrayList = new ArrayList();
                    for (File file : fileArrListFiles) {
                        if (!Intrinsics.b(file.getName(), "index.patch") && !Intrinsics.b(file.getName(), "__MACOSX") && !Intrinsics.b(file.getName(), "manifest.json")) {
                            arrayList.add(file);
                        }
                    }
                } else {
                    arrayList = null;
                }
                if (arrayList == null) {
                    return true;
                }
                for (File file2 : arrayList) {
                    File file3 = new File(targetDir, file2.getName());
                    if (file2.isDirectory()) {
                        file3.mkdirs();
                        e(file2, file3);
                    } else {
                        FileInputStream fileInputStream = new FileInputStream(file2);
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(file3);
                            try {
                                ByteStreamsKt.a(fileInputStream, fileOutputStream);
                                fileOutputStream.close();
                                fileInputStream.close();
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    CloseableKt.a(fileOutputStream, th);
                                    throw th2;
                                }
                            }
                        } catch (Throwable th3) {
                            try {
                                throw th3;
                            } catch (Throwable th4) {
                                CloseableKt.a(fileInputStream, th3);
                                throw th4;
                            }
                        }
                    }
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public static File f(String filePath) {
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            File file = new File(filePath);
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            return file;
        }

        public static void g(String path) {
            Intrinsics.checkNotNullParameter(path, "path");
            File file = new File(path);
            if (file.exists()) {
                FilesKt.b(file);
            }
        }

        public static boolean h(String filePath) {
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            return new File(filePath).exists();
        }

        public static String i() {
            String absolutePath = Phoenix.Companion.b().getFilesDir().getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
            return absolutePath;
        }

        public static byte[] j(InputStream inputStream) throws IOException {
            Intrinsics.checkNotNullParameter(inputStream, "inputStream");
            byte[] bArr = new byte[KEYRecord.Flags.FLAG2];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            }
        }

        public static StringBuilder k(InputStream inputStream) throws IOException {
            Intrinsics.checkNotNullParameter(inputStream, "inputStream");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    inputStream.close();
                    return sb;
                }
                sb.append(line);
                sb.append(StringUtils.LF);
            }
        }

        public static boolean l(File destinationDir, InputStream inputStream) throws IOException {
            File parentFile;
            Intrinsics.checkNotNullParameter(inputStream, "inputStream");
            Intrinsics.checkNotNullParameter(destinationDir, "destinationDir");
            try {
                byte[] bArr = new byte[1024];
                ZipInputStream zipInputStream = new ZipInputStream(inputStream);
                try {
                    for (ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
                        File file = new File(destinationDir, nextEntry.getName());
                        if (!nextEntry.isDirectory()) {
                            File parentFile2 = file.getParentFile();
                            Boolean boolValueOf = parentFile2 != null ? Boolean.valueOf(parentFile2.exists()) : null;
                            Intrinsics.c(boolValueOf);
                            if (!boolValueOf.booleanValue() && (parentFile = file.getParentFile()) != null) {
                                parentFile.mkdirs();
                            }
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            while (true) {
                                int i2 = zipInputStream.read(bArr);
                                if (i2 <= 0) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, i2);
                            }
                            fileOutputStream.close();
                        }
                        zipInputStream.closeEntry();
                    }
                    Unit unit = Unit.f53572a;
                    zipInputStream.close();
                    return true;
                } finally {
                }
            } catch (Exception unused) {
                return false;
            }
        }

        public static void m(String path, byte[] content) throws IOException {
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(path, "path");
            File file = new File(path);
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            try {
                fileOutputStream.write(content);
                fileOutputStream.close();
            } catch (IOException e2) {
                String message = e2.getMessage();
                JSONObject jSONObject = new JSONObject();
                PhoenixUtils.Companion.a(jSONObject, new Pair("error_message", message));
                PhoenixAnalyticsLogger.Companion.a("FAILED_TO_COPY_CONTENT", jSONObject);
                e2.printStackTrace();
                Unit.f53572a.getClass();
                Intrinsics.checkNotNullParameter("kotlin.Unit", "data");
            } finally {
                fileOutputStream.close();
            }
        }
    }
}
