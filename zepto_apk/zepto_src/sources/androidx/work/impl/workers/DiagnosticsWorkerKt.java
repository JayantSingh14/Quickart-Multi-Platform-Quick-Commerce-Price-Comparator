package androidx.work.impl.workers;

import android.support.v4.media.b;
import androidx.work.Logger;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.model.WorkTagDao;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.lang3.StringUtils;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class DiagnosticsWorkerKt {

    /* renamed from: a, reason: collision with root package name */
    public static final String f13072a;

    static {
        String strG = Logger.g("DiagnosticsWrkr");
        Intrinsics.checkNotNullExpressionValue(strG, "tagWithPrefix(\"DiagnosticsWrkr\")");
        f13072a = strG;
    }

    public static final String a(WorkNameDao workNameDao, WorkTagDao workTagDao, SystemIdInfoDao systemIdInfoDao, List list) {
        StringBuilder sb = new StringBuilder("\n Id \t Class Name\t Job Id\t State\t Unique Name\t Tags\t");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            WorkSpec workSpec = (WorkSpec) it.next();
            SystemIdInfo systemIdInfoC = systemIdInfoDao.c(WorkSpecKt.a(workSpec));
            Integer numValueOf = systemIdInfoC != null ? Integer.valueOf(systemIdInfoC.f12888c) : null;
            String str = workSpec.f12905a;
            String strE = CollectionsKt.E(workNameDao.b(str), ",", null, null, null, 62);
            String strE2 = CollectionsKt.E(workTagDao.a(str), ",", null, null, null, 62);
            StringBuilder sbY = b.y(StringUtils.LF, str, "\t ");
            sbY.append(workSpec.f12907c);
            sbY.append("\t ");
            sbY.append(numValueOf);
            sbY.append("\t ");
            sbY.append(workSpec.f12906b.name());
            sbY.append("\t ");
            sbY.append(strE);
            sbY.append("\t ");
            sbY.append(strE2);
            sbY.append('\t');
            sb.append(sbY.toString());
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
