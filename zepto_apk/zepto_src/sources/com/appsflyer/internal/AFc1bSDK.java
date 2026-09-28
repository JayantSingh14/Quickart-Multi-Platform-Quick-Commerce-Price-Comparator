package com.appsflyer.internal;

import android.content.Context;
import androidx.annotation.WorkerThread;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFc1cSDK;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.SetsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@WorkerThread
@SourceDebugExtension
/* loaded from: classes.dex */
public final class AFc1bSDK implements AFc1aSDK {

    @NotNull
    private final AFc1iSDK AFAdRevenueData;

    public AFc1bSDK(@NotNull AFc1iSDK aFc1iSDK) {
        Intrinsics.checkNotNullParameter(aFc1iSDK, "");
        this.AFAdRevenueData = aFc1iSDK;
    }

    private final File getRevenue() {
        Context context = this.AFAdRevenueData.getMonetizationNetwork;
        if (context == null) {
            return null;
        }
        File file = new File(context.getFilesDir(), "AFExceptionsCache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    @Override // com.appsflyer.internal.AFc1aSDK
    @Nullable
    public final String AFAdRevenueData(@NotNull Throwable th, @NotNull String str) {
        String str2;
        File file;
        Intrinsics.checkNotNullParameter(th, "");
        Intrinsics.checkNotNullParameter(str, "");
        synchronized (this) {
            File revenue = getRevenue();
            str2 = null;
            if (revenue != null) {
                file = new File(revenue, "6.17.0");
                if (!file.exists()) {
                    file.mkdirs();
                }
            } else {
                file = null;
            }
            if (file != null) {
                try {
                    AFc1cSDK currencyIso4217Code = AFd1qSDK.getCurrencyIso4217Code(th, str);
                    String str3 = currencyIso4217Code.getMonetizationNetwork;
                    File file2 = new File(file, str3);
                    if (file2.exists()) {
                        AFc1cSDK.AFa1ySDK aFa1ySDK = AFc1cSDK.AFa1ySDK;
                        AFc1cSDK revenue2 = AFc1cSDK.AFa1ySDK.getRevenue(FilesKt.c(file2));
                        if (revenue2 != null) {
                            revenue2.getMediationNetwork++;
                            currencyIso4217Code = revenue2;
                        }
                    }
                    FilesKt.d(file2, currencyIso4217Code.AFAdRevenueData());
                    str2 = str3;
                } catch (Exception e2) {
                    AFg1gSDK.v$default(AFLogger.INSTANCE, AFg1cSDK.EXCEPTION_MANAGER, "Could not cache exception\n " + e2.getMessage(), false, 4, null);
                }
            }
        }
        return str2;
    }

    @Override // com.appsflyer.internal.AFc1aSDK
    public final int getCurrencyIso4217Code() {
        Iterator<T> it = getMediationNetwork().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 += ((AFc1cSDK) it.next()).getMediationNetwork;
        }
        return i2;
    }

    @Override // com.appsflyer.internal.AFc1aSDK
    @NotNull
    public final List<AFc1cSDK> getMediationNetwork() {
        List<AFc1cSDK> arrayList;
        File[] fileArrListFiles;
        ArrayList arrayList2;
        File[] fileArrListFiles2;
        synchronized (this) {
            try {
                File revenue = getRevenue();
                arrayList = null;
                if (revenue != null && (fileArrListFiles = revenue.listFiles()) != null) {
                    ArrayList arrayList3 = new ArrayList();
                    for (File file : fileArrListFiles) {
                        try {
                            fileArrListFiles2 = file.listFiles();
                        } catch (Throwable th) {
                            AFg1gSDK.v$default(AFLogger.INSTANCE, AFg1cSDK.EXCEPTION_MANAGER, "Could not get stored exceptions\n " + th.getMessage(), false, 4, null);
                        }
                        if (fileArrListFiles2 != null) {
                            Intrinsics.checkNotNullExpressionValue(fileArrListFiles2, "");
                            arrayList2 = new ArrayList();
                            for (File file2 : fileArrListFiles2) {
                                AFc1cSDK.AFa1ySDK aFa1ySDK = AFc1cSDK.AFa1ySDK;
                                Intrinsics.checkNotNullExpressionValue(file2, "");
                                AFc1cSDK revenue2 = AFc1cSDK.AFa1ySDK.getRevenue(FilesKt.c(file2));
                                if (revenue2 != null) {
                                    arrayList2.add(revenue2);
                                }
                            }
                        } else {
                            arrayList2 = null;
                        }
                        if (arrayList2 != null) {
                            arrayList3.add(arrayList2);
                        }
                    }
                    Intrinsics.checkNotNullParameter(arrayList3, "<this>");
                    arrayList = new ArrayList<>();
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        CollectionsKt.i(arrayList, (Iterable) it.next());
                    }
                }
                if (arrayList == null) {
                    arrayList = EmptyList.f53609a;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return arrayList;
    }

    @Override // com.appsflyer.internal.AFc1aSDK
    public final boolean getMonetizationNetwork() {
        return getRevenue(new String[0]);
    }

    @Override // com.appsflyer.internal.AFc1aSDK
    public final boolean getRevenue(@NotNull String... strArr) {
        boolean zB;
        Intrinsics.checkNotNullParameter(strArr, "");
        synchronized (this) {
            try {
                File revenue = getRevenue();
                zB = true;
                if (revenue != null) {
                    if (strArr.length == 0) {
                        AFg1gSDK.v$default(AFLogger.INSTANCE, AFg1cSDK.EXCEPTION_MANAGER, "delete all exceptions", false, 4, null);
                        zB = FilesKt.b(revenue);
                    } else {
                        AFg1gSDK.v$default(AFLogger.INSTANCE, AFg1cSDK.EXCEPTION_MANAGER, "delete all exceptions except for: " + ArraysKt.A(62, ", ", strArr), false, 4, null);
                        File[] fileArrListFiles = revenue.listFiles();
                        if (fileArrListFiles != null) {
                            Intrinsics.checkNotNullExpressionValue(fileArrListFiles, "");
                            ArrayList arrayList = new ArrayList();
                            for (File file : fileArrListFiles) {
                                if (!ArraysKt.h(strArr, file.getName())) {
                                    arrayList.add(file);
                                }
                            }
                            ArrayList arrayList2 = new ArrayList(CollectionsKt.r(arrayList, 10));
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                File file2 = (File) it.next();
                                Intrinsics.checkNotNullExpressionValue(file2, "");
                                arrayList2.add(Boolean.valueOf(FilesKt.b(file2)));
                            }
                            Set setH0 = CollectionsKt.h0(arrayList2);
                            if (setH0.isEmpty()) {
                                setH0 = SetsKt.e(Boolean.TRUE);
                            }
                            if (setH0.size() != 1 || !((Boolean) CollectionsKt.y(setH0)).booleanValue()) {
                                zB = false;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zB;
    }

    @Override // com.appsflyer.internal.AFc1aSDK
    public final void AFAdRevenueData(int i2, int i3) {
        File[] fileArrListFiles;
        synchronized (this) {
            try {
                File revenue = getRevenue();
                if (revenue != null && (fileArrListFiles = revenue.listFiles()) != null) {
                    Intrinsics.checkNotNullExpressionValue(fileArrListFiles, "");
                    ArrayList<File> arrayList = new ArrayList();
                    for (File file : fileArrListFiles) {
                        String name = file.getName();
                        Intrinsics.checkNotNullExpressionValue(name, "");
                        int monetizationNetwork = AFj1aSDK.getMonetizationNetwork(name);
                        if (i2 > monetizationNetwork || monetizationNetwork > i3) {
                            arrayList.add(file);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.r(arrayList, 10));
                    for (File file2 : arrayList) {
                        Intrinsics.checkNotNullExpressionValue(file2, "");
                        arrayList2.add(Boolean.valueOf(FilesKt.b(file2)));
                    }
                }
                Unit unit = Unit.f53572a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
