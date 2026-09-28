package androidx.work.impl;

import androidx.annotation.RestrictTo;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.SystemClock;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestrictTo
/* loaded from: classes.dex */
public class Schedulers {

    /* renamed from: a, reason: collision with root package name */
    public static final String f12628a = Logger.g("Schedulers");

    public static void a(WorkSpecDao workSpecDao, SystemClock systemClock, List list) {
        if (list.size() > 0) {
            systemClock.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                workSpecDao.c(jCurrentTimeMillis, ((WorkSpec) it.next()).f12905a);
            }
        }
    }

    public static void b(Configuration configuration, WorkDatabase workDatabase, List list) {
        if (list == null || list.size() == 0) {
            return;
        }
        WorkSpecDao workSpecDaoV = workDatabase.v();
        workDatabase.c();
        try {
            ArrayList arrayListX = workSpecDaoV.x();
            a(workSpecDaoV, configuration.f12476c, arrayListX);
            ArrayList arrayListQ = workSpecDaoV.q(configuration.f12483j);
            a(workSpecDaoV, configuration.f12476c, arrayListQ);
            arrayListQ.addAll(arrayListX);
            ArrayList arrayListO = workSpecDaoV.o();
            workDatabase.o();
            workDatabase.j();
            if (arrayListQ.size() > 0) {
                WorkSpec[] workSpecArr = (WorkSpec[]) arrayListQ.toArray(new WorkSpec[arrayListQ.size()]);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    Scheduler scheduler = (Scheduler) it.next();
                    if (scheduler.d()) {
                        scheduler.b(workSpecArr);
                    }
                }
            }
            if (arrayListO.size() > 0) {
                WorkSpec[] workSpecArr2 = (WorkSpec[]) arrayListO.toArray(new WorkSpec[arrayListO.size()]);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    Scheduler scheduler2 = (Scheduler) it2.next();
                    if (!scheduler2.d()) {
                        scheduler2.b(workSpecArr2);
                    }
                }
            }
        } catch (Throwable th) {
            workDatabase.j();
            throw th;
        }
    }
}
