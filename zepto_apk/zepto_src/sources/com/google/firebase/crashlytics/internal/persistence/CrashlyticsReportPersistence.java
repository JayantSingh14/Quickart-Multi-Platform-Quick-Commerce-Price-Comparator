package com.google.firebase.crashlytics.internal.persistence;

import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsAppQualitySessionsSubscriber;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.settings.Settings;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import org.xbill.DNS.KEYRecord;

/* loaded from: classes.dex */
public class CrashlyticsReportPersistence {

    /* renamed from: e, reason: collision with root package name */
    public static final Charset f44375e = Charset.forName("UTF-8");

    /* renamed from: f, reason: collision with root package name */
    public static final int f44376f = 15;

    /* renamed from: g, reason: collision with root package name */
    public static final CrashlyticsReportJsonTransform f44377g = new CrashlyticsReportJsonTransform();

    /* renamed from: h, reason: collision with root package name */
    public static final a f44378h = new a(0);

    /* renamed from: i, reason: collision with root package name */
    public static final b f44379i = new b(0);

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f44380a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    public final FileStore f44381b;

    /* renamed from: c, reason: collision with root package name */
    public final SettingsController f44382c;

    /* renamed from: d, reason: collision with root package name */
    public final CrashlyticsAppQualitySessionsSubscriber f44383d;

    public CrashlyticsReportPersistence(FileStore fileStore, SettingsController settingsController, CrashlyticsAppQualitySessionsSubscriber crashlyticsAppQualitySessionsSubscriber) {
        this.f44381b = fileStore;
        this.f44382c = settingsController;
        this.f44383d = crashlyticsAppQualitySessionsSubscriber;
    }

    public static void a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    public static String e(File file) throws IOException {
        byte[] bArr = new byte[KEYRecord.Flags.FLAG2];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int i2 = fileInputStream.read(bArr);
                if (i2 <= 0) {
                    String str = new String(byteArrayOutputStream.toByteArray(), f44375e);
                    fileInputStream.close();
                    return str;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public static void f(File file, String str) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), f44375e);
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.close();
        } catch (Throwable th) {
            try {
                outputStreamWriter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList();
        FileStore fileStore = this.f44381b;
        arrayList.addAll(FileStore.f(fileStore.f44389f.listFiles()));
        arrayList.addAll(FileStore.f(fileStore.f44390g.listFiles()));
        a aVar = f44378h;
        Collections.sort(arrayList, aVar);
        List listF = FileStore.f(fileStore.f44388e.listFiles());
        Collections.sort(listF, aVar);
        arrayList.addAll(listF);
        return arrayList;
    }

    public final NavigableSet c() {
        return new TreeSet(FileStore.f(this.f44381b.f44387d.list())).descendingSet();
    }

    public final void d(CrashlyticsReport.Session.Event event, String str, boolean z) {
        FileStore fileStore = this.f44381b;
        Settings.SessionData sessionData = this.f44382c.d().f44421a;
        f44377g.getClass();
        try {
            f(fileStore.c(str, android.support.v4.media.b.D("event", String.format(Locale.US, "%010d", Integer.valueOf(this.f44380a.getAndIncrement())), z ? Attributes.PREDEFINED_ATTRIBUTE_PREFIX : "")), CrashlyticsReportJsonTransform.f44368a.encode(event));
        } catch (IOException e2) {
            Logger.f43705a.f("Could not persist event for session " + str, e2);
        }
        FilenameFilter filenameFilter = new FilenameFilter() { // from class: com.google.firebase.crashlytics.internal.persistence.c
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str2) {
                Charset charset = CrashlyticsReportPersistence.f44375e;
                return str2.startsWith("event") && !str2.endsWith(Attributes.PREDEFINED_ATTRIBUTE_PREFIX);
            }
        };
        fileStore.getClass();
        File file = new File(fileStore.f44387d, str);
        file.mkdirs();
        List<File> listF = FileStore.f(file.listFiles(filenameFilter));
        Collections.sort(listF, new androidx.media3.datasource.cache.a(2));
        int size = listF.size();
        for (File file2 : listF) {
            if (size <= sessionData.f44430a) {
                return;
            }
            FileStore.e(file2);
            size--;
        }
    }
}
