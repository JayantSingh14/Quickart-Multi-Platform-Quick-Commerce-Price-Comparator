package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public final class WorkSpecDao_Impl implements WorkSpecDao {

    /* renamed from: a, reason: collision with root package name */
    public final WorkDatabase_Impl f12939a;

    /* renamed from: b, reason: collision with root package name */
    public final EntityInsertionAdapter f12940b;

    /* renamed from: c, reason: collision with root package name */
    public final SharedSQLiteStatement f12941c;

    /* renamed from: d, reason: collision with root package name */
    public final SharedSQLiteStatement f12942d;

    /* renamed from: e, reason: collision with root package name */
    public final SharedSQLiteStatement f12943e;

    /* renamed from: f, reason: collision with root package name */
    public final SharedSQLiteStatement f12944f;

    /* renamed from: g, reason: collision with root package name */
    public final SharedSQLiteStatement f12945g;

    /* renamed from: h, reason: collision with root package name */
    public final SharedSQLiteStatement f12946h;

    /* renamed from: i, reason: collision with root package name */
    public final SharedSQLiteStatement f12947i;

    /* renamed from: j, reason: collision with root package name */
    public final SharedSQLiteStatement f12948j;

    /* renamed from: k, reason: collision with root package name */
    public final SharedSQLiteStatement f12949k;

    /* renamed from: l, reason: collision with root package name */
    public final SharedSQLiteStatement f12950l;

    /* renamed from: m, reason: collision with root package name */
    public final SharedSQLiteStatement f12951m;
    public final SharedSQLiteStatement n;

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$1, reason: invalid class name */
    class AnonymousClass1 extends EntityInsertionAdapter<WorkSpec> {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`last_enqueue_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`period_count`,`generation`,`next_schedule_time_override`,`next_schedule_time_override_generation`,`stop_reason`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.EntityInsertionAdapter
        public final void e(SupportSQLiteStatement supportSQLiteStatement, Object obj) throws Throwable {
            int i2;
            WorkSpec workSpec = (WorkSpec) obj;
            String str = workSpec.f12905a;
            int i3 = 1;
            if (str == null) {
                supportSQLiteStatement.y1(1);
            } else {
                supportSQLiteStatement.m(1, str);
            }
            supportSQLiteStatement.e1(2, WorkTypeConverters.h(workSpec.f12906b));
            String str2 = workSpec.f12907c;
            if (str2 == null) {
                supportSQLiteStatement.y1(3);
            } else {
                supportSQLiteStatement.m(3, str2);
            }
            String str3 = workSpec.f12908d;
            if (str3 == null) {
                supportSQLiteStatement.y1(4);
            } else {
                supportSQLiteStatement.m(4, str3);
            }
            byte[] bArrC = Data.c(workSpec.f12909e);
            if (bArrC == null) {
                supportSQLiteStatement.y1(5);
            } else {
                supportSQLiteStatement.i1(5, bArrC);
            }
            byte[] bArrC2 = Data.c(workSpec.f12910f);
            if (bArrC2 == null) {
                supportSQLiteStatement.y1(6);
            } else {
                supportSQLiteStatement.i1(6, bArrC2);
            }
            supportSQLiteStatement.e1(7, workSpec.f12911g);
            supportSQLiteStatement.e1(8, workSpec.f12912h);
            supportSQLiteStatement.e1(9, workSpec.f12913i);
            supportSQLiteStatement.e1(10, workSpec.f12915k);
            BackoffPolicy backoffPolicy = workSpec.f12916l;
            Intrinsics.checkNotNullParameter(backoffPolicy, "backoffPolicy");
            int iOrdinal = backoffPolicy.ordinal();
            if (iOrdinal == 0) {
                i2 = 0;
            } else {
                if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                i2 = 1;
            }
            supportSQLiteStatement.e1(11, i2);
            supportSQLiteStatement.e1(12, workSpec.f12917m);
            supportSQLiteStatement.e1(13, workSpec.n);
            supportSQLiteStatement.e1(14, workSpec.o);
            supportSQLiteStatement.e1(15, workSpec.p);
            supportSQLiteStatement.e1(16, workSpec.q ? 1L : 0L);
            OutOfQuotaPolicy policy = workSpec.r;
            Intrinsics.checkNotNullParameter(policy, "policy");
            int iOrdinal2 = policy.ordinal();
            if (iOrdinal2 == 0) {
                i3 = 0;
            } else if (iOrdinal2 != 1) {
                throw new NoWhenBranchMatchedException();
            }
            supportSQLiteStatement.e1(17, i3);
            supportSQLiteStatement.e1(18, workSpec.s);
            supportSQLiteStatement.e1(19, workSpec.t);
            supportSQLiteStatement.e1(20, workSpec.u);
            supportSQLiteStatement.e1(21, workSpec.v);
            supportSQLiteStatement.e1(22, workSpec.w);
            Constraints constraints = workSpec.f12914j;
            if (constraints == null) {
                supportSQLiteStatement.y1(23);
                supportSQLiteStatement.y1(24);
                supportSQLiteStatement.y1(25);
                supportSQLiteStatement.y1(26);
                supportSQLiteStatement.y1(27);
                supportSQLiteStatement.y1(28);
                supportSQLiteStatement.y1(29);
                supportSQLiteStatement.y1(30);
                return;
            }
            supportSQLiteStatement.e1(23, WorkTypeConverters.f(constraints.f12487a));
            supportSQLiteStatement.e1(24, constraints.f12488b ? 1L : 0L);
            supportSQLiteStatement.e1(25, constraints.f12489c ? 1L : 0L);
            supportSQLiteStatement.e1(26, constraints.f12490d ? 1L : 0L);
            supportSQLiteStatement.e1(27, constraints.f12491e ? 1L : 0L);
            supportSQLiteStatement.e1(28, constraints.f12492f);
            supportSQLiteStatement.e1(29, constraints.f12493g);
            byte[] bArrG = WorkTypeConverters.g(constraints.f12494h);
            if (bArrG == null) {
                supportSQLiteStatement.y1(30);
            } else {
                supportSQLiteStatement.i1(30, bArrG);
            }
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$10, reason: invalid class name */
    class AnonymousClass10 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$11, reason: invalid class name */
    class AnonymousClass11 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "UPDATE workspec SET next_schedule_time_override=? WHERE id=?";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$12, reason: invalid class name */
    class AnonymousClass12 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "UPDATE workspec SET next_schedule_time_override=9223372036854775807 WHERE (id=? AND next_schedule_time_override_generation=?)";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$13, reason: invalid class name */
    class AnonymousClass13 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$14, reason: invalid class name */
    class AnonymousClass14 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$15, reason: invalid class name */
    class AnonymousClass15 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$16, reason: invalid class name */
    class AnonymousClass16 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "UPDATE workspec SET generation=generation+1 WHERE id=?";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$17, reason: invalid class name */
    class AnonymousClass17 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "UPDATE workspec SET stop_reason=? WHERE id=?";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$18, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass18 implements Callable<List<String>> {
        @Override // java.util.concurrent.Callable
        public final List<String> call() {
            throw null;
        }

        public final void finalize() {
            throw null;
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$19, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass19 implements Callable<List<WorkSpec.WorkInfoPojo>> {
        @Override // java.util.concurrent.Callable
        public final List<WorkSpec.WorkInfoPojo> call() {
            throw null;
        }

        public final void finalize() {
            throw null;
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$2, reason: invalid class name */
    class AnonymousClass2 extends EntityDeletionOrUpdateAdapter<WorkSpec> {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "UPDATE OR ABORT `WorkSpec` SET `id` = ?,`state` = ?,`worker_class_name` = ?,`input_merger_class_name` = ?,`input` = ?,`output` = ?,`initial_delay` = ?,`interval_duration` = ?,`flex_duration` = ?,`run_attempt_count` = ?,`backoff_policy` = ?,`backoff_delay_duration` = ?,`last_enqueue_time` = ?,`minimum_retention_duration` = ?,`schedule_requested_at` = ?,`run_in_foreground` = ?,`out_of_quota_policy` = ?,`period_count` = ?,`generation` = ?,`next_schedule_time_override` = ?,`next_schedule_time_override_generation` = ?,`stop_reason` = ?,`required_network_type` = ?,`requires_charging` = ?,`requires_device_idle` = ?,`requires_battery_not_low` = ?,`requires_storage_not_low` = ?,`trigger_content_update_delay` = ?,`trigger_max_content_delay` = ?,`content_uri_triggers` = ? WHERE `id` = ?";
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        public final void e(SupportSQLiteStatement supportSQLiteStatement, Object obj) throws Throwable {
            int i2;
            WorkSpec workSpec = (WorkSpec) obj;
            String str = workSpec.f12905a;
            int i3 = 1;
            if (str == null) {
                supportSQLiteStatement.y1(1);
            } else {
                supportSQLiteStatement.m(1, str);
            }
            supportSQLiteStatement.e1(2, WorkTypeConverters.h(workSpec.f12906b));
            String str2 = workSpec.f12907c;
            if (str2 == null) {
                supportSQLiteStatement.y1(3);
            } else {
                supportSQLiteStatement.m(3, str2);
            }
            String str3 = workSpec.f12908d;
            if (str3 == null) {
                supportSQLiteStatement.y1(4);
            } else {
                supportSQLiteStatement.m(4, str3);
            }
            byte[] bArrC = Data.c(workSpec.f12909e);
            if (bArrC == null) {
                supportSQLiteStatement.y1(5);
            } else {
                supportSQLiteStatement.i1(5, bArrC);
            }
            byte[] bArrC2 = Data.c(workSpec.f12910f);
            if (bArrC2 == null) {
                supportSQLiteStatement.y1(6);
            } else {
                supportSQLiteStatement.i1(6, bArrC2);
            }
            supportSQLiteStatement.e1(7, workSpec.f12911g);
            supportSQLiteStatement.e1(8, workSpec.f12912h);
            supportSQLiteStatement.e1(9, workSpec.f12913i);
            supportSQLiteStatement.e1(10, workSpec.f12915k);
            BackoffPolicy backoffPolicy = workSpec.f12916l;
            Intrinsics.checkNotNullParameter(backoffPolicy, "backoffPolicy");
            int iOrdinal = backoffPolicy.ordinal();
            if (iOrdinal == 0) {
                i2 = 0;
            } else {
                if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                i2 = 1;
            }
            supportSQLiteStatement.e1(11, i2);
            supportSQLiteStatement.e1(12, workSpec.f12917m);
            supportSQLiteStatement.e1(13, workSpec.n);
            supportSQLiteStatement.e1(14, workSpec.o);
            supportSQLiteStatement.e1(15, workSpec.p);
            supportSQLiteStatement.e1(16, workSpec.q ? 1L : 0L);
            OutOfQuotaPolicy policy = workSpec.r;
            Intrinsics.checkNotNullParameter(policy, "policy");
            int iOrdinal2 = policy.ordinal();
            if (iOrdinal2 == 0) {
                i3 = 0;
            } else if (iOrdinal2 != 1) {
                throw new NoWhenBranchMatchedException();
            }
            supportSQLiteStatement.e1(17, i3);
            supportSQLiteStatement.e1(18, workSpec.s);
            supportSQLiteStatement.e1(19, workSpec.t);
            supportSQLiteStatement.e1(20, workSpec.u);
            supportSQLiteStatement.e1(21, workSpec.v);
            supportSQLiteStatement.e1(22, workSpec.w);
            Constraints constraints = workSpec.f12914j;
            if (constraints != null) {
                supportSQLiteStatement.e1(23, WorkTypeConverters.f(constraints.f12487a));
                supportSQLiteStatement.e1(24, constraints.f12488b ? 1L : 0L);
                supportSQLiteStatement.e1(25, constraints.f12489c ? 1L : 0L);
                supportSQLiteStatement.e1(26, constraints.f12490d ? 1L : 0L);
                supportSQLiteStatement.e1(27, constraints.f12491e ? 1L : 0L);
                supportSQLiteStatement.e1(28, constraints.f12492f);
                supportSQLiteStatement.e1(29, constraints.f12493g);
                byte[] bArrG = WorkTypeConverters.g(constraints.f12494h);
                if (bArrG == null) {
                    supportSQLiteStatement.y1(30);
                } else {
                    supportSQLiteStatement.i1(30, bArrG);
                }
            } else {
                supportSQLiteStatement.y1(23);
                supportSQLiteStatement.y1(24);
                supportSQLiteStatement.y1(25);
                supportSQLiteStatement.y1(26);
                supportSQLiteStatement.y1(27);
                supportSQLiteStatement.y1(28);
                supportSQLiteStatement.y1(29);
                supportSQLiteStatement.y1(30);
            }
            String str4 = workSpec.f12905a;
            if (str4 == null) {
                supportSQLiteStatement.y1(31);
            } else {
                supportSQLiteStatement.m(31, str4);
            }
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$20, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass20 implements Callable<List<WorkSpec.WorkInfoPojo>> {
        @Override // java.util.concurrent.Callable
        public final List<WorkSpec.WorkInfoPojo> call() {
            throw null;
        }

        public final void finalize() {
            throw null;
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$21, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass21 implements Callable<List<WorkSpec.WorkInfoPojo>> {
        @Override // java.util.concurrent.Callable
        public final List<WorkSpec.WorkInfoPojo> call() {
            throw null;
        }

        public final void finalize() {
            throw null;
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$22, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass22 implements Callable<List<WorkSpec.WorkInfoPojo>> {
        @Override // java.util.concurrent.Callable
        public final List<WorkSpec.WorkInfoPojo> call() {
            throw null;
        }

        public final void finalize() {
            throw null;
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$23, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass23 implements Callable<List<WorkSpec.WorkInfoPojo>> {
        @Override // java.util.concurrent.Callable
        public final List<WorkSpec.WorkInfoPojo> call() {
            throw null;
        }

        public final void finalize() {
            throw null;
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$24, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass24 implements Callable<List<WorkSpec.WorkInfoPojo>> {
        @Override // java.util.concurrent.Callable
        public final List<WorkSpec.WorkInfoPojo> call() {
            throw null;
        }

        public final void finalize() {
            throw null;
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$25, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass25 implements Callable<Long> {
        @Override // java.util.concurrent.Callable
        public final Long call() {
            throw null;
        }

        public final void finalize() {
            throw null;
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$3, reason: invalid class name */
    class AnonymousClass3 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "DELETE FROM workspec WHERE id=?";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$4, reason: invalid class name */
    class AnonymousClass4 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "UPDATE workspec SET state=? WHERE id=?";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$5, reason: invalid class name */
    class AnonymousClass5 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "UPDATE workspec SET stop_reason = CASE WHEN state=1 THEN 1 ELSE -256 END, state=5 WHERE id=?";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$6, reason: invalid class name */
    class AnonymousClass6 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "UPDATE workspec SET period_count=period_count+1 WHERE id=?";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$7, reason: invalid class name */
    class AnonymousClass7 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "UPDATE workspec SET output=? WHERE id=?";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$8, reason: invalid class name */
    class AnonymousClass8 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "UPDATE workspec SET last_enqueue_time=? WHERE id=?";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$9, reason: invalid class name */
    class AnonymousClass9 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
        }
    }

    public WorkSpecDao_Impl(WorkDatabase_Impl database) {
        this.f12939a = database;
        Intrinsics.checkNotNullParameter(database, "database");
        this.f12940b = new AnonymousClass1(database);
        Intrinsics.checkNotNullParameter(database, "database");
        new AnonymousClass2(database);
        this.f12941c = new AnonymousClass3(database);
        this.f12942d = new AnonymousClass4(database);
        this.f12943e = new AnonymousClass5(database);
        this.f12944f = new AnonymousClass6(database);
        this.f12945g = new AnonymousClass7(database);
        this.f12946h = new AnonymousClass8(database);
        this.f12947i = new AnonymousClass9(database);
        this.f12948j = new AnonymousClass10(database);
        new AnonymousClass11(database);
        this.f12949k = new AnonymousClass12(database);
        this.f12950l = new AnonymousClass13(database);
        this.f12951m = new AnonymousClass14(database);
        new AnonymousClass15(database);
        new AnonymousClass16(database);
        this.n = new AnonymousClass17(database);
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final int A(String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f12939a;
        workDatabase_Impl.b();
        SharedSQLiteStatement sharedSQLiteStatement = this.f12947i;
        SupportSQLiteStatement supportSQLiteStatementA = sharedSQLiteStatement.a();
        if (str == null) {
            supportSQLiteStatementA.y1(1);
        } else {
            supportSQLiteStatementA.m(1, str);
        }
        workDatabase_Impl.c();
        try {
            int iH = supportSQLiteStatementA.H();
            workDatabase_Impl.o();
            return iH;
        } finally {
            workDatabase_Impl.j();
            sharedSQLiteStatement.d(supportSQLiteStatementA);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final int B() {
        RoomSQLiteQuery roomSQLiteQueryA = RoomSQLiteQuery.a(0, "Select COUNT(*) FROM workspec WHERE LENGTH(content_uri_triggers)<>0 AND state NOT IN (2, 3, 5)");
        WorkDatabase_Impl workDatabase_Impl = this.f12939a;
        workDatabase_Impl.b();
        Cursor cursorB = DBUtil.b(workDatabase_Impl, roomSQLiteQueryA, false);
        try {
            return cursorB.moveToFirst() ? cursorB.getInt(0) : 0;
        } finally {
            cursorB.close();
            roomSQLiteQueryA.release();
        }
    }

    public final void C(HashMap map) {
        int i2;
        Set<String> setKeySet = map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (map.size() > 999) {
            HashMap map2 = new HashMap(999);
            loop0: while (true) {
                i2 = 0;
                for (String str : setKeySet) {
                    map2.put(str, (ArrayList) map.get(str));
                    i2++;
                    if (i2 == 999) {
                        break;
                    }
                }
                C(map2);
                map2 = new HashMap(999);
            }
            if (i2 > 0) {
                C(map2);
                return;
            }
            return;
        }
        StringBuilder sbB = StringUtil.b();
        sbB.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
        int size = setKeySet.size();
        StringUtil.a(size, sbB);
        sbB.append(")");
        RoomSQLiteQuery roomSQLiteQueryA = RoomSQLiteQuery.a(size, sbB.toString());
        int i3 = 1;
        for (String str2 : setKeySet) {
            if (str2 == null) {
                roomSQLiteQueryA.y1(i3);
            } else {
                roomSQLiteQueryA.m(i3, str2);
            }
            i3++;
        }
        Cursor cursorB = DBUtil.b(this.f12939a, roomSQLiteQueryA, false);
        try {
            int iA = CursorUtil.a(cursorB, "work_spec_id");
            if (iA == -1) {
                return;
            }
            while (cursorB.moveToNext()) {
                ArrayList arrayList = (ArrayList) map.get(cursorB.getString(iA));
                if (arrayList != null) {
                    arrayList.add(Data.a(cursorB.isNull(0) ? null : cursorB.getBlob(0)));
                }
            }
        } finally {
            cursorB.close();
        }
    }

    public final void D(HashMap map) {
        int i2;
        Set<String> setKeySet = map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (map.size() > 999) {
            HashMap map2 = new HashMap(999);
            loop0: while (true) {
                i2 = 0;
                for (String str : setKeySet) {
                    map2.put(str, (ArrayList) map.get(str));
                    i2++;
                    if (i2 == 999) {
                        break;
                    }
                }
                D(map2);
                map2 = new HashMap(999);
            }
            if (i2 > 0) {
                D(map2);
                return;
            }
            return;
        }
        StringBuilder sbB = StringUtil.b();
        sbB.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
        int size = setKeySet.size();
        StringUtil.a(size, sbB);
        sbB.append(")");
        RoomSQLiteQuery roomSQLiteQueryA = RoomSQLiteQuery.a(size, sbB.toString());
        int i3 = 1;
        for (String str2 : setKeySet) {
            if (str2 == null) {
                roomSQLiteQueryA.y1(i3);
            } else {
                roomSQLiteQueryA.m(i3, str2);
            }
            i3++;
        }
        Cursor cursorB = DBUtil.b(this.f12939a, roomSQLiteQueryA, false);
        try {
            int iA = CursorUtil.a(cursorB, "work_spec_id");
            if (iA == -1) {
                return;
            }
            while (cursorB.moveToNext()) {
                ArrayList arrayList = (ArrayList) map.get(cursorB.getString(iA));
                if (arrayList != null) {
                    arrayList.add(cursorB.isNull(0) ? null : cursorB.getString(0));
                }
            }
        } finally {
            cursorB.close();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final void a(String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f12939a;
        workDatabase_Impl.b();
        SharedSQLiteStatement sharedSQLiteStatement = this.f12941c;
        SupportSQLiteStatement supportSQLiteStatementA = sharedSQLiteStatement.a();
        if (str == null) {
            supportSQLiteStatementA.y1(1);
        } else {
            supportSQLiteStatementA.m(1, str);
        }
        workDatabase_Impl.c();
        try {
            supportSQLiteStatementA.H();
            workDatabase_Impl.o();
        } finally {
            workDatabase_Impl.j();
            sharedSQLiteStatement.d(supportSQLiteStatementA);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final void b(String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f12939a;
        workDatabase_Impl.b();
        SharedSQLiteStatement sharedSQLiteStatement = this.f12944f;
        SupportSQLiteStatement supportSQLiteStatementA = sharedSQLiteStatement.a();
        if (str == null) {
            supportSQLiteStatementA.y1(1);
        } else {
            supportSQLiteStatementA.m(1, str);
        }
        workDatabase_Impl.c();
        try {
            supportSQLiteStatementA.H();
            workDatabase_Impl.o();
        } finally {
            workDatabase_Impl.j();
            sharedSQLiteStatement.d(supportSQLiteStatementA);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final int c(long j2, String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f12939a;
        workDatabase_Impl.b();
        SharedSQLiteStatement sharedSQLiteStatement = this.f12950l;
        SupportSQLiteStatement supportSQLiteStatementA = sharedSQLiteStatement.a();
        supportSQLiteStatementA.e1(1, j2);
        if (str == null) {
            supportSQLiteStatementA.y1(2);
        } else {
            supportSQLiteStatementA.m(2, str);
        }
        workDatabase_Impl.c();
        try {
            int iH = supportSQLiteStatementA.H();
            workDatabase_Impl.o();
            return iH;
        } finally {
            workDatabase_Impl.j();
            sharedSQLiteStatement.d(supportSQLiteStatementA);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final ArrayList d(long j2) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryA = RoomSQLiteQuery.a(1, "SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC");
        roomSQLiteQueryA.e1(1, j2);
        WorkDatabase_Impl workDatabase_Impl = this.f12939a;
        workDatabase_Impl.b();
        Cursor cursorB = DBUtil.b(workDatabase_Impl, roomSQLiteQueryA, false);
        try {
            int iB = CursorUtil.b(cursorB, CLConstants.SHARED_PREFERENCE_ITEM_ID);
            int iB2 = CursorUtil.b(cursorB, "state");
            int iB3 = CursorUtil.b(cursorB, "worker_class_name");
            int iB4 = CursorUtil.b(cursorB, "input_merger_class_name");
            int iB5 = CursorUtil.b(cursorB, "input");
            int iB6 = CursorUtil.b(cursorB, "output");
            int iB7 = CursorUtil.b(cursorB, "initial_delay");
            int iB8 = CursorUtil.b(cursorB, "interval_duration");
            int iB9 = CursorUtil.b(cursorB, "flex_duration");
            int iB10 = CursorUtil.b(cursorB, "run_attempt_count");
            int iB11 = CursorUtil.b(cursorB, "backoff_policy");
            int iB12 = CursorUtil.b(cursorB, "backoff_delay_duration");
            int iB13 = CursorUtil.b(cursorB, "last_enqueue_time");
            roomSQLiteQuery = roomSQLiteQueryA;
            try {
                int iB14 = CursorUtil.b(cursorB, "minimum_retention_duration");
                int iB15 = CursorUtil.b(cursorB, "schedule_requested_at");
                int iB16 = CursorUtil.b(cursorB, "run_in_foreground");
                int iB17 = CursorUtil.b(cursorB, "out_of_quota_policy");
                int iB18 = CursorUtil.b(cursorB, "period_count");
                int iB19 = CursorUtil.b(cursorB, "generation");
                int iB20 = CursorUtil.b(cursorB, "next_schedule_time_override");
                int iB21 = CursorUtil.b(cursorB, "next_schedule_time_override_generation");
                int iB22 = CursorUtil.b(cursorB, "stop_reason");
                int iB23 = CursorUtil.b(cursorB, "required_network_type");
                int iB24 = CursorUtil.b(cursorB, "requires_charging");
                int iB25 = CursorUtil.b(cursorB, "requires_device_idle");
                int iB26 = CursorUtil.b(cursorB, "requires_battery_not_low");
                int iB27 = CursorUtil.b(cursorB, "requires_storage_not_low");
                int iB28 = CursorUtil.b(cursorB, "trigger_content_update_delay");
                int iB29 = CursorUtil.b(cursorB, "trigger_max_content_delay");
                int iB30 = CursorUtil.b(cursorB, "content_uri_triggers");
                int i2 = iB14;
                ArrayList arrayList = new ArrayList(cursorB.getCount());
                while (cursorB.moveToNext()) {
                    byte[] blob = null;
                    String string = cursorB.isNull(iB) ? null : cursorB.getString(iB);
                    WorkInfo.State stateE = WorkTypeConverters.e(cursorB.getInt(iB2));
                    String string2 = cursorB.isNull(iB3) ? null : cursorB.getString(iB3);
                    String string3 = cursorB.isNull(iB4) ? null : cursorB.getString(iB4);
                    Data dataA = Data.a(cursorB.isNull(iB5) ? null : cursorB.getBlob(iB5));
                    Data dataA2 = Data.a(cursorB.isNull(iB6) ? null : cursorB.getBlob(iB6));
                    long j3 = cursorB.getLong(iB7);
                    long j4 = cursorB.getLong(iB8);
                    long j5 = cursorB.getLong(iB9);
                    int i3 = cursorB.getInt(iB10);
                    BackoffPolicy backoffPolicyB = WorkTypeConverters.b(cursorB.getInt(iB11));
                    long j6 = cursorB.getLong(iB12);
                    long j7 = cursorB.getLong(iB13);
                    int i4 = i2;
                    long j8 = cursorB.getLong(i4);
                    int i5 = iB;
                    int i6 = iB15;
                    long j9 = cursorB.getLong(i6);
                    iB15 = i6;
                    int i7 = iB16;
                    boolean z = cursorB.getInt(i7) != 0;
                    iB16 = i7;
                    int i8 = iB17;
                    OutOfQuotaPolicy outOfQuotaPolicyD = WorkTypeConverters.d(cursorB.getInt(i8));
                    iB17 = i8;
                    int i9 = iB18;
                    int i10 = cursorB.getInt(i9);
                    iB18 = i9;
                    int i11 = iB19;
                    int i12 = cursorB.getInt(i11);
                    iB19 = i11;
                    int i13 = iB20;
                    long j10 = cursorB.getLong(i13);
                    iB20 = i13;
                    int i14 = iB21;
                    int i15 = cursorB.getInt(i14);
                    iB21 = i14;
                    int i16 = iB22;
                    int i17 = cursorB.getInt(i16);
                    iB22 = i16;
                    int i18 = iB23;
                    NetworkType networkTypeC = WorkTypeConverters.c(cursorB.getInt(i18));
                    iB23 = i18;
                    int i19 = iB24;
                    boolean z2 = cursorB.getInt(i19) != 0;
                    iB24 = i19;
                    int i20 = iB25;
                    boolean z3 = cursorB.getInt(i20) != 0;
                    iB25 = i20;
                    int i21 = iB26;
                    boolean z4 = cursorB.getInt(i21) != 0;
                    iB26 = i21;
                    int i22 = iB27;
                    boolean z5 = cursorB.getInt(i22) != 0;
                    iB27 = i22;
                    int i23 = iB28;
                    long j11 = cursorB.getLong(i23);
                    iB28 = i23;
                    int i24 = iB29;
                    long j12 = cursorB.getLong(i24);
                    iB29 = i24;
                    int i25 = iB30;
                    if (!cursorB.isNull(i25)) {
                        blob = cursorB.getBlob(i25);
                    }
                    iB30 = i25;
                    arrayList.add(new WorkSpec(string, stateE, string2, string3, dataA, dataA2, j3, j4, j5, new Constraints(networkTypeC, z2, z3, z4, z5, j11, j12, WorkTypeConverters.a(blob)), i3, backoffPolicyB, j6, j7, j8, j9, z, outOfQuotaPolicyD, i10, i12, j10, i15, i17));
                    iB = i5;
                    i2 = i4;
                }
                cursorB.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorB.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryA;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final void e(WorkSpec workSpec) {
        WorkDatabase_Impl workDatabase_Impl = this.f12939a;
        workDatabase_Impl.b();
        workDatabase_Impl.c();
        try {
            this.f12940b.f(workSpec);
            workDatabase_Impl.o();
        } finally {
            workDatabase_Impl.j();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final void f(int i2, String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f12939a;
        workDatabase_Impl.b();
        SharedSQLiteStatement sharedSQLiteStatement = this.f12949k;
        SupportSQLiteStatement supportSQLiteStatementA = sharedSQLiteStatement.a();
        if (str == null) {
            supportSQLiteStatementA.y1(1);
        } else {
            supportSQLiteStatementA.m(1, str);
        }
        supportSQLiteStatementA.e1(2, i2);
        workDatabase_Impl.c();
        try {
            supportSQLiteStatementA.H();
            workDatabase_Impl.o();
        } finally {
            workDatabase_Impl.j();
            sharedSQLiteStatement.d(supportSQLiteStatementA);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final ArrayList g() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryA = RoomSQLiteQuery.a(0, "SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1");
        WorkDatabase_Impl workDatabase_Impl = this.f12939a;
        workDatabase_Impl.b();
        Cursor cursorB = DBUtil.b(workDatabase_Impl, roomSQLiteQueryA, false);
        try {
            int iB = CursorUtil.b(cursorB, CLConstants.SHARED_PREFERENCE_ITEM_ID);
            int iB2 = CursorUtil.b(cursorB, "state");
            int iB3 = CursorUtil.b(cursorB, "worker_class_name");
            int iB4 = CursorUtil.b(cursorB, "input_merger_class_name");
            int iB5 = CursorUtil.b(cursorB, "input");
            int iB6 = CursorUtil.b(cursorB, "output");
            int iB7 = CursorUtil.b(cursorB, "initial_delay");
            int iB8 = CursorUtil.b(cursorB, "interval_duration");
            int iB9 = CursorUtil.b(cursorB, "flex_duration");
            int iB10 = CursorUtil.b(cursorB, "run_attempt_count");
            int iB11 = CursorUtil.b(cursorB, "backoff_policy");
            int iB12 = CursorUtil.b(cursorB, "backoff_delay_duration");
            int iB13 = CursorUtil.b(cursorB, "last_enqueue_time");
            roomSQLiteQuery = roomSQLiteQueryA;
            try {
                int iB14 = CursorUtil.b(cursorB, "minimum_retention_duration");
                int iB15 = CursorUtil.b(cursorB, "schedule_requested_at");
                int iB16 = CursorUtil.b(cursorB, "run_in_foreground");
                int iB17 = CursorUtil.b(cursorB, "out_of_quota_policy");
                int iB18 = CursorUtil.b(cursorB, "period_count");
                int iB19 = CursorUtil.b(cursorB, "generation");
                int iB20 = CursorUtil.b(cursorB, "next_schedule_time_override");
                int iB21 = CursorUtil.b(cursorB, "next_schedule_time_override_generation");
                int iB22 = CursorUtil.b(cursorB, "stop_reason");
                int iB23 = CursorUtil.b(cursorB, "required_network_type");
                int iB24 = CursorUtil.b(cursorB, "requires_charging");
                int iB25 = CursorUtil.b(cursorB, "requires_device_idle");
                int iB26 = CursorUtil.b(cursorB, "requires_battery_not_low");
                int iB27 = CursorUtil.b(cursorB, "requires_storage_not_low");
                int iB28 = CursorUtil.b(cursorB, "trigger_content_update_delay");
                int iB29 = CursorUtil.b(cursorB, "trigger_max_content_delay");
                int iB30 = CursorUtil.b(cursorB, "content_uri_triggers");
                int i2 = iB14;
                ArrayList arrayList = new ArrayList(cursorB.getCount());
                while (cursorB.moveToNext()) {
                    byte[] blob = null;
                    String string = cursorB.isNull(iB) ? null : cursorB.getString(iB);
                    WorkInfo.State stateE = WorkTypeConverters.e(cursorB.getInt(iB2));
                    String string2 = cursorB.isNull(iB3) ? null : cursorB.getString(iB3);
                    String string3 = cursorB.isNull(iB4) ? null : cursorB.getString(iB4);
                    Data dataA = Data.a(cursorB.isNull(iB5) ? null : cursorB.getBlob(iB5));
                    Data dataA2 = Data.a(cursorB.isNull(iB6) ? null : cursorB.getBlob(iB6));
                    long j2 = cursorB.getLong(iB7);
                    long j3 = cursorB.getLong(iB8);
                    long j4 = cursorB.getLong(iB9);
                    int i3 = cursorB.getInt(iB10);
                    BackoffPolicy backoffPolicyB = WorkTypeConverters.b(cursorB.getInt(iB11));
                    long j5 = cursorB.getLong(iB12);
                    long j6 = cursorB.getLong(iB13);
                    int i4 = i2;
                    long j7 = cursorB.getLong(i4);
                    int i5 = iB;
                    int i6 = iB15;
                    long j8 = cursorB.getLong(i6);
                    iB15 = i6;
                    int i7 = iB16;
                    boolean z = cursorB.getInt(i7) != 0;
                    iB16 = i7;
                    int i8 = iB17;
                    OutOfQuotaPolicy outOfQuotaPolicyD = WorkTypeConverters.d(cursorB.getInt(i8));
                    iB17 = i8;
                    int i9 = iB18;
                    int i10 = cursorB.getInt(i9);
                    iB18 = i9;
                    int i11 = iB19;
                    int i12 = cursorB.getInt(i11);
                    iB19 = i11;
                    int i13 = iB20;
                    long j9 = cursorB.getLong(i13);
                    iB20 = i13;
                    int i14 = iB21;
                    int i15 = cursorB.getInt(i14);
                    iB21 = i14;
                    int i16 = iB22;
                    int i17 = cursorB.getInt(i16);
                    iB22 = i16;
                    int i18 = iB23;
                    NetworkType networkTypeC = WorkTypeConverters.c(cursorB.getInt(i18));
                    iB23 = i18;
                    int i19 = iB24;
                    boolean z2 = cursorB.getInt(i19) != 0;
                    iB24 = i19;
                    int i20 = iB25;
                    boolean z3 = cursorB.getInt(i20) != 0;
                    iB25 = i20;
                    int i21 = iB26;
                    boolean z4 = cursorB.getInt(i21) != 0;
                    iB26 = i21;
                    int i22 = iB27;
                    boolean z5 = cursorB.getInt(i22) != 0;
                    iB27 = i22;
                    int i23 = iB28;
                    long j10 = cursorB.getLong(i23);
                    iB28 = i23;
                    int i24 = iB29;
                    long j11 = cursorB.getLong(i24);
                    iB29 = i24;
                    int i25 = iB30;
                    if (!cursorB.isNull(i25)) {
                        blob = cursorB.getBlob(i25);
                    }
                    iB30 = i25;
                    arrayList.add(new WorkSpec(string, stateE, string2, string3, dataA, dataA2, j2, j3, j4, new Constraints(networkTypeC, z2, z3, z4, z5, j10, j11, WorkTypeConverters.a(blob)), i3, backoffPolicyB, j5, j6, j7, j8, z, outOfQuotaPolicyD, i10, i12, j9, i15, i17));
                    iB = i5;
                    i2 = i4;
                }
                cursorB.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorB.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryA;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final ArrayList h(String str) {
        RoomSQLiteQuery roomSQLiteQueryA = RoomSQLiteQuery.a(1, "SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)");
        if (str == null) {
            roomSQLiteQueryA.y1(1);
        } else {
            roomSQLiteQueryA.m(1, str);
        }
        WorkDatabase_Impl workDatabase_Impl = this.f12939a;
        workDatabase_Impl.b();
        Cursor cursorB = DBUtil.b(workDatabase_Impl, roomSQLiteQueryA, false);
        try {
            ArrayList arrayList = new ArrayList(cursorB.getCount());
            while (cursorB.moveToNext()) {
                arrayList.add(cursorB.isNull(0) ? null : cursorB.getString(0));
            }
            return arrayList;
        } finally {
            cursorB.close();
            roomSQLiteQueryA.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final WorkInfo.State i(String str) {
        RoomSQLiteQuery roomSQLiteQueryA = RoomSQLiteQuery.a(1, "SELECT state FROM workspec WHERE id=?");
        if (str == null) {
            roomSQLiteQueryA.y1(1);
        } else {
            roomSQLiteQueryA.m(1, str);
        }
        WorkDatabase_Impl workDatabase_Impl = this.f12939a;
        workDatabase_Impl.b();
        Cursor cursorB = DBUtil.b(workDatabase_Impl, roomSQLiteQueryA, false);
        try {
            WorkInfo.State stateE = null;
            if (cursorB.moveToFirst()) {
                Integer numValueOf = cursorB.isNull(0) ? null : Integer.valueOf(cursorB.getInt(0));
                if (numValueOf != null) {
                    stateE = WorkTypeConverters.e(numValueOf.intValue());
                }
            }
            return stateE;
        } finally {
            cursorB.close();
            roomSQLiteQueryA.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final WorkSpec j(String str) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryA = RoomSQLiteQuery.a(1, "SELECT * FROM workspec WHERE id=?");
        if (str == null) {
            roomSQLiteQueryA.y1(1);
        } else {
            roomSQLiteQueryA.m(1, str);
        }
        WorkDatabase_Impl workDatabase_Impl = this.f12939a;
        workDatabase_Impl.b();
        Cursor cursorB = DBUtil.b(workDatabase_Impl, roomSQLiteQueryA, false);
        try {
            int iB = CursorUtil.b(cursorB, CLConstants.SHARED_PREFERENCE_ITEM_ID);
            int iB2 = CursorUtil.b(cursorB, "state");
            int iB3 = CursorUtil.b(cursorB, "worker_class_name");
            int iB4 = CursorUtil.b(cursorB, "input_merger_class_name");
            int iB5 = CursorUtil.b(cursorB, "input");
            int iB6 = CursorUtil.b(cursorB, "output");
            int iB7 = CursorUtil.b(cursorB, "initial_delay");
            int iB8 = CursorUtil.b(cursorB, "interval_duration");
            int iB9 = CursorUtil.b(cursorB, "flex_duration");
            int iB10 = CursorUtil.b(cursorB, "run_attempt_count");
            int iB11 = CursorUtil.b(cursorB, "backoff_policy");
            int iB12 = CursorUtil.b(cursorB, "backoff_delay_duration");
            int iB13 = CursorUtil.b(cursorB, "last_enqueue_time");
            roomSQLiteQuery = roomSQLiteQueryA;
            try {
                int iB14 = CursorUtil.b(cursorB, "minimum_retention_duration");
                int iB15 = CursorUtil.b(cursorB, "schedule_requested_at");
                int iB16 = CursorUtil.b(cursorB, "run_in_foreground");
                int iB17 = CursorUtil.b(cursorB, "out_of_quota_policy");
                int iB18 = CursorUtil.b(cursorB, "period_count");
                int iB19 = CursorUtil.b(cursorB, "generation");
                int iB20 = CursorUtil.b(cursorB, "next_schedule_time_override");
                int iB21 = CursorUtil.b(cursorB, "next_schedule_time_override_generation");
                int iB22 = CursorUtil.b(cursorB, "stop_reason");
                int iB23 = CursorUtil.b(cursorB, "required_network_type");
                int iB24 = CursorUtil.b(cursorB, "requires_charging");
                int iB25 = CursorUtil.b(cursorB, "requires_device_idle");
                int iB26 = CursorUtil.b(cursorB, "requires_battery_not_low");
                int iB27 = CursorUtil.b(cursorB, "requires_storage_not_low");
                int iB28 = CursorUtil.b(cursorB, "trigger_content_update_delay");
                int iB29 = CursorUtil.b(cursorB, "trigger_max_content_delay");
                int iB30 = CursorUtil.b(cursorB, "content_uri_triggers");
                WorkSpec workSpec = null;
                byte[] blob = null;
                if (cursorB.moveToFirst()) {
                    String string = cursorB.isNull(iB) ? null : cursorB.getString(iB);
                    WorkInfo.State stateE = WorkTypeConverters.e(cursorB.getInt(iB2));
                    String string2 = cursorB.isNull(iB3) ? null : cursorB.getString(iB3);
                    String string3 = cursorB.isNull(iB4) ? null : cursorB.getString(iB4);
                    Data dataA = Data.a(cursorB.isNull(iB5) ? null : cursorB.getBlob(iB5));
                    Data dataA2 = Data.a(cursorB.isNull(iB6) ? null : cursorB.getBlob(iB6));
                    long j2 = cursorB.getLong(iB7);
                    long j3 = cursorB.getLong(iB8);
                    long j4 = cursorB.getLong(iB9);
                    int i2 = cursorB.getInt(iB10);
                    BackoffPolicy backoffPolicyB = WorkTypeConverters.b(cursorB.getInt(iB11));
                    long j5 = cursorB.getLong(iB12);
                    long j6 = cursorB.getLong(iB13);
                    long j7 = cursorB.getLong(iB14);
                    long j8 = cursorB.getLong(iB15);
                    boolean z = cursorB.getInt(iB16) != 0;
                    OutOfQuotaPolicy outOfQuotaPolicyD = WorkTypeConverters.d(cursorB.getInt(iB17));
                    int i3 = cursorB.getInt(iB18);
                    int i4 = cursorB.getInt(iB19);
                    long j9 = cursorB.getLong(iB20);
                    int i5 = cursorB.getInt(iB21);
                    int i6 = cursorB.getInt(iB22);
                    NetworkType networkTypeC = WorkTypeConverters.c(cursorB.getInt(iB23));
                    boolean z2 = cursorB.getInt(iB24) != 0;
                    boolean z3 = cursorB.getInt(iB25) != 0;
                    boolean z4 = cursorB.getInt(iB26) != 0;
                    boolean z5 = cursorB.getInt(iB27) != 0;
                    long j10 = cursorB.getLong(iB28);
                    long j11 = cursorB.getLong(iB29);
                    if (!cursorB.isNull(iB30)) {
                        blob = cursorB.getBlob(iB30);
                    }
                    workSpec = new WorkSpec(string, stateE, string2, string3, dataA, dataA2, j2, j3, j4, new Constraints(networkTypeC, z2, z3, z4, z5, j10, j11, WorkTypeConverters.a(blob)), i2, backoffPolicyB, j5, j6, j7, j8, z, outOfQuotaPolicyD, i3, i4, j9, i5, i6);
                }
                cursorB.close();
                roomSQLiteQuery.release();
                return workSpec;
            } catch (Throwable th) {
                th = th;
                cursorB.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryA;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final int k(String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f12939a;
        workDatabase_Impl.b();
        SharedSQLiteStatement sharedSQLiteStatement = this.f12943e;
        SupportSQLiteStatement supportSQLiteStatementA = sharedSQLiteStatement.a();
        if (str == null) {
            supportSQLiteStatementA.y1(1);
        } else {
            supportSQLiteStatementA.m(1, str);
        }
        workDatabase_Impl.c();
        try {
            int iH = supportSQLiteStatementA.H();
            workDatabase_Impl.o();
            return iH;
        } finally {
            workDatabase_Impl.j();
            sharedSQLiteStatement.d(supportSQLiteStatementA);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final ArrayList l(String str) {
        RoomSQLiteQuery roomSQLiteQueryA = RoomSQLiteQuery.a(1, "SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)");
        roomSQLiteQueryA.m(1, str);
        WorkDatabase_Impl workDatabase_Impl = this.f12939a;
        workDatabase_Impl.b();
        Cursor cursorB = DBUtil.b(workDatabase_Impl, roomSQLiteQueryA, false);
        try {
            ArrayList arrayList = new ArrayList(cursorB.getCount());
            while (cursorB.moveToNext()) {
                arrayList.add(cursorB.isNull(0) ? null : cursorB.getString(0));
            }
            return arrayList;
        } finally {
            cursorB.close();
            roomSQLiteQueryA.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final ArrayList m(String str) {
        RoomSQLiteQuery roomSQLiteQueryA = RoomSQLiteQuery.a(1, "SELECT output FROM workspec WHERE id IN\n             (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)");
        if (str == null) {
            roomSQLiteQueryA.y1(1);
        } else {
            roomSQLiteQueryA.m(1, str);
        }
        WorkDatabase_Impl workDatabase_Impl = this.f12939a;
        workDatabase_Impl.b();
        Cursor cursorB = DBUtil.b(workDatabase_Impl, roomSQLiteQueryA, false);
        try {
            ArrayList arrayList = new ArrayList(cursorB.getCount());
            while (cursorB.moveToNext()) {
                arrayList.add(Data.a(cursorB.isNull(0) ? null : cursorB.getBlob(0)));
            }
            return arrayList;
        } finally {
            cursorB.close();
            roomSQLiteQueryA.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final int n() {
        WorkDatabase_Impl workDatabase_Impl = this.f12939a;
        workDatabase_Impl.b();
        SharedSQLiteStatement sharedSQLiteStatement = this.f12951m;
        SupportSQLiteStatement supportSQLiteStatementA = sharedSQLiteStatement.a();
        workDatabase_Impl.c();
        try {
            int iH = supportSQLiteStatementA.H();
            workDatabase_Impl.o();
            return iH;
        } finally {
            workDatabase_Impl.j();
            sharedSQLiteStatement.d(supportSQLiteStatementA);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final ArrayList o() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryA = RoomSQLiteQuery.a(1, "SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT ?");
        roomSQLiteQueryA.e1(1, 200);
        WorkDatabase_Impl workDatabase_Impl = this.f12939a;
        workDatabase_Impl.b();
        Cursor cursorB = DBUtil.b(workDatabase_Impl, roomSQLiteQueryA, false);
        try {
            int iB = CursorUtil.b(cursorB, CLConstants.SHARED_PREFERENCE_ITEM_ID);
            int iB2 = CursorUtil.b(cursorB, "state");
            int iB3 = CursorUtil.b(cursorB, "worker_class_name");
            int iB4 = CursorUtil.b(cursorB, "input_merger_class_name");
            int iB5 = CursorUtil.b(cursorB, "input");
            int iB6 = CursorUtil.b(cursorB, "output");
            int iB7 = CursorUtil.b(cursorB, "initial_delay");
            int iB8 = CursorUtil.b(cursorB, "interval_duration");
            int iB9 = CursorUtil.b(cursorB, "flex_duration");
            int iB10 = CursorUtil.b(cursorB, "run_attempt_count");
            int iB11 = CursorUtil.b(cursorB, "backoff_policy");
            int iB12 = CursorUtil.b(cursorB, "backoff_delay_duration");
            int iB13 = CursorUtil.b(cursorB, "last_enqueue_time");
            roomSQLiteQuery = roomSQLiteQueryA;
            try {
                int iB14 = CursorUtil.b(cursorB, "minimum_retention_duration");
                int iB15 = CursorUtil.b(cursorB, "schedule_requested_at");
                int iB16 = CursorUtil.b(cursorB, "run_in_foreground");
                int iB17 = CursorUtil.b(cursorB, "out_of_quota_policy");
                int iB18 = CursorUtil.b(cursorB, "period_count");
                int iB19 = CursorUtil.b(cursorB, "generation");
                int iB20 = CursorUtil.b(cursorB, "next_schedule_time_override");
                int iB21 = CursorUtil.b(cursorB, "next_schedule_time_override_generation");
                int iB22 = CursorUtil.b(cursorB, "stop_reason");
                int iB23 = CursorUtil.b(cursorB, "required_network_type");
                int iB24 = CursorUtil.b(cursorB, "requires_charging");
                int iB25 = CursorUtil.b(cursorB, "requires_device_idle");
                int iB26 = CursorUtil.b(cursorB, "requires_battery_not_low");
                int iB27 = CursorUtil.b(cursorB, "requires_storage_not_low");
                int iB28 = CursorUtil.b(cursorB, "trigger_content_update_delay");
                int iB29 = CursorUtil.b(cursorB, "trigger_max_content_delay");
                int iB30 = CursorUtil.b(cursorB, "content_uri_triggers");
                int i2 = iB14;
                ArrayList arrayList = new ArrayList(cursorB.getCount());
                while (cursorB.moveToNext()) {
                    byte[] blob = null;
                    String string = cursorB.isNull(iB) ? null : cursorB.getString(iB);
                    WorkInfo.State stateE = WorkTypeConverters.e(cursorB.getInt(iB2));
                    String string2 = cursorB.isNull(iB3) ? null : cursorB.getString(iB3);
                    String string3 = cursorB.isNull(iB4) ? null : cursorB.getString(iB4);
                    Data dataA = Data.a(cursorB.isNull(iB5) ? null : cursorB.getBlob(iB5));
                    Data dataA2 = Data.a(cursorB.isNull(iB6) ? null : cursorB.getBlob(iB6));
                    long j2 = cursorB.getLong(iB7);
                    long j3 = cursorB.getLong(iB8);
                    long j4 = cursorB.getLong(iB9);
                    int i3 = cursorB.getInt(iB10);
                    BackoffPolicy backoffPolicyB = WorkTypeConverters.b(cursorB.getInt(iB11));
                    long j5 = cursorB.getLong(iB12);
                    long j6 = cursorB.getLong(iB13);
                    int i4 = i2;
                    long j7 = cursorB.getLong(i4);
                    int i5 = iB;
                    int i6 = iB15;
                    long j8 = cursorB.getLong(i6);
                    iB15 = i6;
                    int i7 = iB16;
                    boolean z = cursorB.getInt(i7) != 0;
                    iB16 = i7;
                    int i8 = iB17;
                    OutOfQuotaPolicy outOfQuotaPolicyD = WorkTypeConverters.d(cursorB.getInt(i8));
                    iB17 = i8;
                    int i9 = iB18;
                    int i10 = cursorB.getInt(i9);
                    iB18 = i9;
                    int i11 = iB19;
                    int i12 = cursorB.getInt(i11);
                    iB19 = i11;
                    int i13 = iB20;
                    long j9 = cursorB.getLong(i13);
                    iB20 = i13;
                    int i14 = iB21;
                    int i15 = cursorB.getInt(i14);
                    iB21 = i14;
                    int i16 = iB22;
                    int i17 = cursorB.getInt(i16);
                    iB22 = i16;
                    int i18 = iB23;
                    NetworkType networkTypeC = WorkTypeConverters.c(cursorB.getInt(i18));
                    iB23 = i18;
                    int i19 = iB24;
                    boolean z2 = cursorB.getInt(i19) != 0;
                    iB24 = i19;
                    int i20 = iB25;
                    boolean z3 = cursorB.getInt(i20) != 0;
                    iB25 = i20;
                    int i21 = iB26;
                    boolean z4 = cursorB.getInt(i21) != 0;
                    iB26 = i21;
                    int i22 = iB27;
                    boolean z5 = cursorB.getInt(i22) != 0;
                    iB27 = i22;
                    int i23 = iB28;
                    long j10 = cursorB.getLong(i23);
                    iB28 = i23;
                    int i24 = iB29;
                    long j11 = cursorB.getLong(i24);
                    iB29 = i24;
                    int i25 = iB30;
                    if (!cursorB.isNull(i25)) {
                        blob = cursorB.getBlob(i25);
                    }
                    iB30 = i25;
                    arrayList.add(new WorkSpec(string, stateE, string2, string3, dataA, dataA2, j2, j3, j4, new Constraints(networkTypeC, z2, z3, z4, z5, j10, j11, WorkTypeConverters.a(blob)), i3, backoffPolicyB, j5, j6, j7, j8, z, outOfQuotaPolicyD, i10, i12, j9, i15, i17));
                    iB = i5;
                    i2 = i4;
                }
                cursorB.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorB.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryA;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final ArrayList p(String str) {
        RoomSQLiteQuery roomSQLiteQueryA = RoomSQLiteQuery.a(1, "SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)");
        if (str == null) {
            roomSQLiteQueryA.y1(1);
        } else {
            roomSQLiteQueryA.m(1, str);
        }
        WorkDatabase_Impl workDatabase_Impl = this.f12939a;
        workDatabase_Impl.b();
        Cursor cursorB = DBUtil.b(workDatabase_Impl, roomSQLiteQueryA, false);
        try {
            ArrayList arrayList = new ArrayList(cursorB.getCount());
            while (cursorB.moveToNext()) {
                String id = cursorB.isNull(0) ? null : cursorB.getString(0);
                WorkInfo.State state = WorkTypeConverters.e(cursorB.getInt(1));
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(state, "state");
                WorkSpec.IdAndState idAndState = new WorkSpec.IdAndState();
                idAndState.f12918a = id;
                idAndState.f12919b = state;
                arrayList.add(idAndState);
            }
            return arrayList;
        } finally {
            cursorB.close();
            roomSQLiteQueryA.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final ArrayList q(int i2) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryA = RoomSQLiteQuery.a(1, "SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND LENGTH(content_uri_triggers)=0 AND state NOT IN (2, 3, 5))");
        roomSQLiteQueryA.e1(1, i2);
        WorkDatabase_Impl workDatabase_Impl = this.f12939a;
        workDatabase_Impl.b();
        Cursor cursorB = DBUtil.b(workDatabase_Impl, roomSQLiteQueryA, false);
        try {
            int iB = CursorUtil.b(cursorB, CLConstants.SHARED_PREFERENCE_ITEM_ID);
            int iB2 = CursorUtil.b(cursorB, "state");
            int iB3 = CursorUtil.b(cursorB, "worker_class_name");
            int iB4 = CursorUtil.b(cursorB, "input_merger_class_name");
            int iB5 = CursorUtil.b(cursorB, "input");
            int iB6 = CursorUtil.b(cursorB, "output");
            int iB7 = CursorUtil.b(cursorB, "initial_delay");
            int iB8 = CursorUtil.b(cursorB, "interval_duration");
            int iB9 = CursorUtil.b(cursorB, "flex_duration");
            int iB10 = CursorUtil.b(cursorB, "run_attempt_count");
            int iB11 = CursorUtil.b(cursorB, "backoff_policy");
            int iB12 = CursorUtil.b(cursorB, "backoff_delay_duration");
            int iB13 = CursorUtil.b(cursorB, "last_enqueue_time");
            roomSQLiteQuery = roomSQLiteQueryA;
            try {
                int iB14 = CursorUtil.b(cursorB, "minimum_retention_duration");
                int iB15 = CursorUtil.b(cursorB, "schedule_requested_at");
                int iB16 = CursorUtil.b(cursorB, "run_in_foreground");
                int iB17 = CursorUtil.b(cursorB, "out_of_quota_policy");
                int iB18 = CursorUtil.b(cursorB, "period_count");
                int iB19 = CursorUtil.b(cursorB, "generation");
                int iB20 = CursorUtil.b(cursorB, "next_schedule_time_override");
                int iB21 = CursorUtil.b(cursorB, "next_schedule_time_override_generation");
                int iB22 = CursorUtil.b(cursorB, "stop_reason");
                int iB23 = CursorUtil.b(cursorB, "required_network_type");
                int iB24 = CursorUtil.b(cursorB, "requires_charging");
                int iB25 = CursorUtil.b(cursorB, "requires_device_idle");
                int iB26 = CursorUtil.b(cursorB, "requires_battery_not_low");
                int iB27 = CursorUtil.b(cursorB, "requires_storage_not_low");
                int iB28 = CursorUtil.b(cursorB, "trigger_content_update_delay");
                int iB29 = CursorUtil.b(cursorB, "trigger_max_content_delay");
                int iB30 = CursorUtil.b(cursorB, "content_uri_triggers");
                int i3 = iB14;
                ArrayList arrayList = new ArrayList(cursorB.getCount());
                while (cursorB.moveToNext()) {
                    byte[] blob = null;
                    String string = cursorB.isNull(iB) ? null : cursorB.getString(iB);
                    WorkInfo.State stateE = WorkTypeConverters.e(cursorB.getInt(iB2));
                    String string2 = cursorB.isNull(iB3) ? null : cursorB.getString(iB3);
                    String string3 = cursorB.isNull(iB4) ? null : cursorB.getString(iB4);
                    Data dataA = Data.a(cursorB.isNull(iB5) ? null : cursorB.getBlob(iB5));
                    Data dataA2 = Data.a(cursorB.isNull(iB6) ? null : cursorB.getBlob(iB6));
                    long j2 = cursorB.getLong(iB7);
                    long j3 = cursorB.getLong(iB8);
                    long j4 = cursorB.getLong(iB9);
                    int i4 = cursorB.getInt(iB10);
                    BackoffPolicy backoffPolicyB = WorkTypeConverters.b(cursorB.getInt(iB11));
                    long j5 = cursorB.getLong(iB12);
                    long j6 = cursorB.getLong(iB13);
                    int i5 = i3;
                    long j7 = cursorB.getLong(i5);
                    int i6 = iB;
                    int i7 = iB15;
                    long j8 = cursorB.getLong(i7);
                    iB15 = i7;
                    int i8 = iB16;
                    boolean z = cursorB.getInt(i8) != 0;
                    iB16 = i8;
                    int i9 = iB17;
                    OutOfQuotaPolicy outOfQuotaPolicyD = WorkTypeConverters.d(cursorB.getInt(i9));
                    iB17 = i9;
                    int i10 = iB18;
                    int i11 = cursorB.getInt(i10);
                    iB18 = i10;
                    int i12 = iB19;
                    int i13 = cursorB.getInt(i12);
                    iB19 = i12;
                    int i14 = iB20;
                    long j9 = cursorB.getLong(i14);
                    iB20 = i14;
                    int i15 = iB21;
                    int i16 = cursorB.getInt(i15);
                    iB21 = i15;
                    int i17 = iB22;
                    int i18 = cursorB.getInt(i17);
                    iB22 = i17;
                    int i19 = iB23;
                    NetworkType networkTypeC = WorkTypeConverters.c(cursorB.getInt(i19));
                    iB23 = i19;
                    int i20 = iB24;
                    boolean z2 = cursorB.getInt(i20) != 0;
                    iB24 = i20;
                    int i21 = iB25;
                    boolean z3 = cursorB.getInt(i21) != 0;
                    iB25 = i21;
                    int i22 = iB26;
                    boolean z4 = cursorB.getInt(i22) != 0;
                    iB26 = i22;
                    int i23 = iB27;
                    boolean z5 = cursorB.getInt(i23) != 0;
                    iB27 = i23;
                    int i24 = iB28;
                    long j10 = cursorB.getLong(i24);
                    iB28 = i24;
                    int i25 = iB29;
                    long j11 = cursorB.getLong(i25);
                    iB29 = i25;
                    int i26 = iB30;
                    if (!cursorB.isNull(i26)) {
                        blob = cursorB.getBlob(i26);
                    }
                    iB30 = i26;
                    arrayList.add(new WorkSpec(string, stateE, string2, string3, dataA, dataA2, j2, j3, j4, new Constraints(networkTypeC, z2, z3, z4, z5, j10, j11, WorkTypeConverters.a(blob)), i4, backoffPolicyB, j5, j6, j7, j8, z, outOfQuotaPolicyD, i11, i13, j9, i16, i18));
                    iB = i6;
                    i3 = i5;
                }
                cursorB.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorB.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryA;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final int r(WorkInfo.State state, String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f12939a;
        workDatabase_Impl.b();
        SharedSQLiteStatement sharedSQLiteStatement = this.f12942d;
        SupportSQLiteStatement supportSQLiteStatementA = sharedSQLiteStatement.a();
        supportSQLiteStatementA.e1(1, WorkTypeConverters.h(state));
        if (str == null) {
            supportSQLiteStatementA.y1(2);
        } else {
            supportSQLiteStatementA.m(2, str);
        }
        workDatabase_Impl.c();
        try {
            int iH = supportSQLiteStatementA.H();
            workDatabase_Impl.o();
            return iH;
        } finally {
            workDatabase_Impl.j();
            sharedSQLiteStatement.d(supportSQLiteStatementA);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final void s(long j2, String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f12939a;
        workDatabase_Impl.b();
        SharedSQLiteStatement sharedSQLiteStatement = this.f12946h;
        SupportSQLiteStatement supportSQLiteStatementA = sharedSQLiteStatement.a();
        supportSQLiteStatementA.e1(1, j2);
        if (str == null) {
            supportSQLiteStatementA.y1(2);
        } else {
            supportSQLiteStatementA.m(2, str);
        }
        workDatabase_Impl.c();
        try {
            supportSQLiteStatementA.H();
            workDatabase_Impl.o();
        } finally {
            workDatabase_Impl.j();
            sharedSQLiteStatement.d(supportSQLiteStatementA);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final void t(String str, Data data) throws Throwable {
        WorkDatabase_Impl workDatabase_Impl = this.f12939a;
        workDatabase_Impl.b();
        SharedSQLiteStatement sharedSQLiteStatement = this.f12945g;
        SupportSQLiteStatement supportSQLiteStatementA = sharedSQLiteStatement.a();
        byte[] bArrC = Data.c(data);
        if (bArrC == null) {
            supportSQLiteStatementA.y1(1);
        } else {
            supportSQLiteStatementA.i1(1, bArrC);
        }
        if (str == null) {
            supportSQLiteStatementA.y1(2);
        } else {
            supportSQLiteStatementA.m(2, str);
        }
        workDatabase_Impl.c();
        try {
            supportSQLiteStatementA.H();
            workDatabase_Impl.o();
        } finally {
            workDatabase_Impl.j();
            sharedSQLiteStatement.d(supportSQLiteStatementA);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final ArrayList u() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryA = RoomSQLiteQuery.a(0, "SELECT * FROM workspec WHERE state=1");
        WorkDatabase_Impl workDatabase_Impl = this.f12939a;
        workDatabase_Impl.b();
        Cursor cursorB = DBUtil.b(workDatabase_Impl, roomSQLiteQueryA, false);
        try {
            int iB = CursorUtil.b(cursorB, CLConstants.SHARED_PREFERENCE_ITEM_ID);
            int iB2 = CursorUtil.b(cursorB, "state");
            int iB3 = CursorUtil.b(cursorB, "worker_class_name");
            int iB4 = CursorUtil.b(cursorB, "input_merger_class_name");
            int iB5 = CursorUtil.b(cursorB, "input");
            int iB6 = CursorUtil.b(cursorB, "output");
            int iB7 = CursorUtil.b(cursorB, "initial_delay");
            int iB8 = CursorUtil.b(cursorB, "interval_duration");
            int iB9 = CursorUtil.b(cursorB, "flex_duration");
            int iB10 = CursorUtil.b(cursorB, "run_attempt_count");
            int iB11 = CursorUtil.b(cursorB, "backoff_policy");
            int iB12 = CursorUtil.b(cursorB, "backoff_delay_duration");
            int iB13 = CursorUtil.b(cursorB, "last_enqueue_time");
            roomSQLiteQuery = roomSQLiteQueryA;
            try {
                int iB14 = CursorUtil.b(cursorB, "minimum_retention_duration");
                int iB15 = CursorUtil.b(cursorB, "schedule_requested_at");
                int iB16 = CursorUtil.b(cursorB, "run_in_foreground");
                int iB17 = CursorUtil.b(cursorB, "out_of_quota_policy");
                int iB18 = CursorUtil.b(cursorB, "period_count");
                int iB19 = CursorUtil.b(cursorB, "generation");
                int iB20 = CursorUtil.b(cursorB, "next_schedule_time_override");
                int iB21 = CursorUtil.b(cursorB, "next_schedule_time_override_generation");
                int iB22 = CursorUtil.b(cursorB, "stop_reason");
                int iB23 = CursorUtil.b(cursorB, "required_network_type");
                int iB24 = CursorUtil.b(cursorB, "requires_charging");
                int iB25 = CursorUtil.b(cursorB, "requires_device_idle");
                int iB26 = CursorUtil.b(cursorB, "requires_battery_not_low");
                int iB27 = CursorUtil.b(cursorB, "requires_storage_not_low");
                int iB28 = CursorUtil.b(cursorB, "trigger_content_update_delay");
                int iB29 = CursorUtil.b(cursorB, "trigger_max_content_delay");
                int iB30 = CursorUtil.b(cursorB, "content_uri_triggers");
                int i2 = iB14;
                ArrayList arrayList = new ArrayList(cursorB.getCount());
                while (cursorB.moveToNext()) {
                    byte[] blob = null;
                    String string = cursorB.isNull(iB) ? null : cursorB.getString(iB);
                    WorkInfo.State stateE = WorkTypeConverters.e(cursorB.getInt(iB2));
                    String string2 = cursorB.isNull(iB3) ? null : cursorB.getString(iB3);
                    String string3 = cursorB.isNull(iB4) ? null : cursorB.getString(iB4);
                    Data dataA = Data.a(cursorB.isNull(iB5) ? null : cursorB.getBlob(iB5));
                    Data dataA2 = Data.a(cursorB.isNull(iB6) ? null : cursorB.getBlob(iB6));
                    long j2 = cursorB.getLong(iB7);
                    long j3 = cursorB.getLong(iB8);
                    long j4 = cursorB.getLong(iB9);
                    int i3 = cursorB.getInt(iB10);
                    BackoffPolicy backoffPolicyB = WorkTypeConverters.b(cursorB.getInt(iB11));
                    long j5 = cursorB.getLong(iB12);
                    long j6 = cursorB.getLong(iB13);
                    int i4 = i2;
                    long j7 = cursorB.getLong(i4);
                    int i5 = iB;
                    int i6 = iB15;
                    long j8 = cursorB.getLong(i6);
                    iB15 = i6;
                    int i7 = iB16;
                    boolean z = cursorB.getInt(i7) != 0;
                    iB16 = i7;
                    int i8 = iB17;
                    OutOfQuotaPolicy outOfQuotaPolicyD = WorkTypeConverters.d(cursorB.getInt(i8));
                    iB17 = i8;
                    int i9 = iB18;
                    int i10 = cursorB.getInt(i9);
                    iB18 = i9;
                    int i11 = iB19;
                    int i12 = cursorB.getInt(i11);
                    iB19 = i11;
                    int i13 = iB20;
                    long j9 = cursorB.getLong(i13);
                    iB20 = i13;
                    int i14 = iB21;
                    int i15 = cursorB.getInt(i14);
                    iB21 = i14;
                    int i16 = iB22;
                    int i17 = cursorB.getInt(i16);
                    iB22 = i16;
                    int i18 = iB23;
                    NetworkType networkTypeC = WorkTypeConverters.c(cursorB.getInt(i18));
                    iB23 = i18;
                    int i19 = iB24;
                    boolean z2 = cursorB.getInt(i19) != 0;
                    iB24 = i19;
                    int i20 = iB25;
                    boolean z3 = cursorB.getInt(i20) != 0;
                    iB25 = i20;
                    int i21 = iB26;
                    boolean z4 = cursorB.getInt(i21) != 0;
                    iB26 = i21;
                    int i22 = iB27;
                    boolean z5 = cursorB.getInt(i22) != 0;
                    iB27 = i22;
                    int i23 = iB28;
                    long j10 = cursorB.getLong(i23);
                    iB28 = i23;
                    int i24 = iB29;
                    long j11 = cursorB.getLong(i24);
                    iB29 = i24;
                    int i25 = iB30;
                    if (!cursorB.isNull(i25)) {
                        blob = cursorB.getBlob(i25);
                    }
                    iB30 = i25;
                    arrayList.add(new WorkSpec(string, stateE, string2, string3, dataA, dataA2, j2, j3, j4, new Constraints(networkTypeC, z2, z3, z4, z5, j10, j11, WorkTypeConverters.a(blob)), i3, backoffPolicyB, j5, j6, j7, j8, z, outOfQuotaPolicyD, i10, i12, j9, i15, i17));
                    iB = i5;
                    i2 = i4;
                }
                cursorB.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorB.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryA;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final void v(int i2, String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f12939a;
        workDatabase_Impl.b();
        SharedSQLiteStatement sharedSQLiteStatement = this.n;
        SupportSQLiteStatement supportSQLiteStatementA = sharedSQLiteStatement.a();
        supportSQLiteStatementA.e1(1, i2);
        if (str == null) {
            supportSQLiteStatementA.y1(2);
        } else {
            supportSQLiteStatementA.m(2, str);
        }
        workDatabase_Impl.c();
        try {
            supportSQLiteStatementA.H();
            workDatabase_Impl.o();
        } finally {
            workDatabase_Impl.j();
            sharedSQLiteStatement.d(supportSQLiteStatementA);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final boolean w() {
        boolean z = false;
        RoomSQLiteQuery roomSQLiteQueryA = RoomSQLiteQuery.a(0, "SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1");
        WorkDatabase_Impl workDatabase_Impl = this.f12939a;
        workDatabase_Impl.b();
        Cursor cursorB = DBUtil.b(workDatabase_Impl, roomSQLiteQueryA, false);
        try {
            if (cursorB.moveToFirst()) {
                if (cursorB.getInt(0) != 0) {
                    z = true;
                }
            }
            return z;
        } finally {
            cursorB.close();
            roomSQLiteQueryA.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final ArrayList x() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryA = RoomSQLiteQuery.a(0, "SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 AND LENGTH(content_uri_triggers)<>0 ORDER BY last_enqueue_time");
        WorkDatabase_Impl workDatabase_Impl = this.f12939a;
        workDatabase_Impl.b();
        Cursor cursorB = DBUtil.b(workDatabase_Impl, roomSQLiteQueryA, false);
        try {
            int iB = CursorUtil.b(cursorB, CLConstants.SHARED_PREFERENCE_ITEM_ID);
            int iB2 = CursorUtil.b(cursorB, "state");
            int iB3 = CursorUtil.b(cursorB, "worker_class_name");
            int iB4 = CursorUtil.b(cursorB, "input_merger_class_name");
            int iB5 = CursorUtil.b(cursorB, "input");
            int iB6 = CursorUtil.b(cursorB, "output");
            int iB7 = CursorUtil.b(cursorB, "initial_delay");
            int iB8 = CursorUtil.b(cursorB, "interval_duration");
            int iB9 = CursorUtil.b(cursorB, "flex_duration");
            int iB10 = CursorUtil.b(cursorB, "run_attempt_count");
            int iB11 = CursorUtil.b(cursorB, "backoff_policy");
            int iB12 = CursorUtil.b(cursorB, "backoff_delay_duration");
            int iB13 = CursorUtil.b(cursorB, "last_enqueue_time");
            roomSQLiteQuery = roomSQLiteQueryA;
            try {
                int iB14 = CursorUtil.b(cursorB, "minimum_retention_duration");
                int iB15 = CursorUtil.b(cursorB, "schedule_requested_at");
                int iB16 = CursorUtil.b(cursorB, "run_in_foreground");
                int iB17 = CursorUtil.b(cursorB, "out_of_quota_policy");
                int iB18 = CursorUtil.b(cursorB, "period_count");
                int iB19 = CursorUtil.b(cursorB, "generation");
                int iB20 = CursorUtil.b(cursorB, "next_schedule_time_override");
                int iB21 = CursorUtil.b(cursorB, "next_schedule_time_override_generation");
                int iB22 = CursorUtil.b(cursorB, "stop_reason");
                int iB23 = CursorUtil.b(cursorB, "required_network_type");
                int iB24 = CursorUtil.b(cursorB, "requires_charging");
                int iB25 = CursorUtil.b(cursorB, "requires_device_idle");
                int iB26 = CursorUtil.b(cursorB, "requires_battery_not_low");
                int iB27 = CursorUtil.b(cursorB, "requires_storage_not_low");
                int iB28 = CursorUtil.b(cursorB, "trigger_content_update_delay");
                int iB29 = CursorUtil.b(cursorB, "trigger_max_content_delay");
                int iB30 = CursorUtil.b(cursorB, "content_uri_triggers");
                int i2 = iB14;
                ArrayList arrayList = new ArrayList(cursorB.getCount());
                while (cursorB.moveToNext()) {
                    byte[] blob = null;
                    String string = cursorB.isNull(iB) ? null : cursorB.getString(iB);
                    WorkInfo.State stateE = WorkTypeConverters.e(cursorB.getInt(iB2));
                    String string2 = cursorB.isNull(iB3) ? null : cursorB.getString(iB3);
                    String string3 = cursorB.isNull(iB4) ? null : cursorB.getString(iB4);
                    Data dataA = Data.a(cursorB.isNull(iB5) ? null : cursorB.getBlob(iB5));
                    Data dataA2 = Data.a(cursorB.isNull(iB6) ? null : cursorB.getBlob(iB6));
                    long j2 = cursorB.getLong(iB7);
                    long j3 = cursorB.getLong(iB8);
                    long j4 = cursorB.getLong(iB9);
                    int i3 = cursorB.getInt(iB10);
                    BackoffPolicy backoffPolicyB = WorkTypeConverters.b(cursorB.getInt(iB11));
                    long j5 = cursorB.getLong(iB12);
                    long j6 = cursorB.getLong(iB13);
                    int i4 = i2;
                    long j7 = cursorB.getLong(i4);
                    int i5 = iB;
                    int i6 = iB15;
                    long j8 = cursorB.getLong(i6);
                    iB15 = i6;
                    int i7 = iB16;
                    boolean z = cursorB.getInt(i7) != 0;
                    iB16 = i7;
                    int i8 = iB17;
                    OutOfQuotaPolicy outOfQuotaPolicyD = WorkTypeConverters.d(cursorB.getInt(i8));
                    iB17 = i8;
                    int i9 = iB18;
                    int i10 = cursorB.getInt(i9);
                    iB18 = i9;
                    int i11 = iB19;
                    int i12 = cursorB.getInt(i11);
                    iB19 = i11;
                    int i13 = iB20;
                    long j9 = cursorB.getLong(i13);
                    iB20 = i13;
                    int i14 = iB21;
                    int i15 = cursorB.getInt(i14);
                    iB21 = i14;
                    int i16 = iB22;
                    int i17 = cursorB.getInt(i16);
                    iB22 = i16;
                    int i18 = iB23;
                    NetworkType networkTypeC = WorkTypeConverters.c(cursorB.getInt(i18));
                    iB23 = i18;
                    int i19 = iB24;
                    boolean z2 = cursorB.getInt(i19) != 0;
                    iB24 = i19;
                    int i20 = iB25;
                    boolean z3 = cursorB.getInt(i20) != 0;
                    iB25 = i20;
                    int i21 = iB26;
                    boolean z4 = cursorB.getInt(i21) != 0;
                    iB26 = i21;
                    int i22 = iB27;
                    boolean z5 = cursorB.getInt(i22) != 0;
                    iB27 = i22;
                    int i23 = iB28;
                    long j10 = cursorB.getLong(i23);
                    iB28 = i23;
                    int i24 = iB29;
                    long j11 = cursorB.getLong(i24);
                    iB29 = i24;
                    int i25 = iB30;
                    if (!cursorB.isNull(i25)) {
                        blob = cursorB.getBlob(i25);
                    }
                    iB30 = i25;
                    arrayList.add(new WorkSpec(string, stateE, string2, string3, dataA, dataA2, j2, j3, j4, new Constraints(networkTypeC, z2, z3, z4, z5, j10, j11, WorkTypeConverters.a(blob)), i3, backoffPolicyB, j5, j6, j7, j8, z, outOfQuotaPolicyD, i10, i12, j9, i15, i17));
                    iB = i5;
                    i2 = i4;
                }
                cursorB.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorB.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryA;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final int y(String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f12939a;
        workDatabase_Impl.b();
        SharedSQLiteStatement sharedSQLiteStatement = this.f12948j;
        SupportSQLiteStatement supportSQLiteStatementA = sharedSQLiteStatement.a();
        if (str == null) {
            supportSQLiteStatementA.y1(1);
        } else {
            supportSQLiteStatementA.m(1, str);
        }
        workDatabase_Impl.c();
        try {
            int iH = supportSQLiteStatementA.H();
            workDatabase_Impl.o();
            return iH;
        } finally {
            workDatabase_Impl.j();
            sharedSQLiteStatement.d(supportSQLiteStatementA);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public final ArrayList z(String str) {
        RoomSQLiteQuery roomSQLiteQueryA = RoomSQLiteQuery.a(1, "SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)");
        roomSQLiteQueryA.m(1, str);
        WorkDatabase_Impl workDatabase_Impl = this.f12939a;
        workDatabase_Impl.b();
        workDatabase_Impl.c();
        try {
            Cursor cursorB = DBUtil.b(workDatabase_Impl, roomSQLiteQueryA, true);
            try {
                HashMap map = new HashMap();
                HashMap map2 = new HashMap();
                while (cursorB.moveToNext()) {
                    String string = cursorB.getString(0);
                    if (((ArrayList) map.get(string)) == null) {
                        map.put(string, new ArrayList());
                    }
                    String string2 = cursorB.getString(0);
                    if (((ArrayList) map2.get(string2)) == null) {
                        map2.put(string2, new ArrayList());
                    }
                }
                cursorB.moveToPosition(-1);
                D(map);
                C(map2);
                ArrayList arrayList = new ArrayList(cursorB.getCount());
                while (cursorB.moveToNext()) {
                    byte[] blob = null;
                    String string3 = cursorB.isNull(0) ? null : cursorB.getString(0);
                    WorkInfo.State stateE = WorkTypeConverters.e(cursorB.getInt(1));
                    Data dataA = Data.a(cursorB.isNull(2) ? null : cursorB.getBlob(2));
                    int i2 = cursorB.getInt(3);
                    int i3 = cursorB.getInt(4);
                    long j2 = cursorB.getLong(13);
                    long j3 = cursorB.getLong(14);
                    long j4 = cursorB.getLong(15);
                    BackoffPolicy backoffPolicyB = WorkTypeConverters.b(cursorB.getInt(16));
                    long j5 = cursorB.getLong(17);
                    long j6 = cursorB.getLong(18);
                    int i4 = cursorB.getInt(19);
                    long j7 = cursorB.getLong(20);
                    int i5 = cursorB.getInt(21);
                    NetworkType networkTypeC = WorkTypeConverters.c(cursorB.getInt(5));
                    boolean z = cursorB.getInt(6) != 0;
                    boolean z2 = cursorB.getInt(7) != 0;
                    boolean z3 = cursorB.getInt(8) != 0;
                    boolean z4 = cursorB.getInt(9) != 0;
                    long j8 = cursorB.getLong(10);
                    long j9 = cursorB.getLong(11);
                    if (!cursorB.isNull(12)) {
                        blob = cursorB.getBlob(12);
                    }
                    Constraints constraints = new Constraints(networkTypeC, z, z2, z3, z4, j8, j9, WorkTypeConverters.a(blob));
                    ArrayList arrayList2 = (ArrayList) map.get(cursorB.getString(0));
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    ArrayList arrayList3 = (ArrayList) map2.get(cursorB.getString(0));
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    arrayList.add(new WorkSpec.WorkInfoPojo(string3, stateE, dataA, j2, j3, j4, constraints, i2, backoffPolicyB, j5, j6, i4, i3, j7, i5, arrayList2, arrayList3));
                }
                workDatabase_Impl.o();
                cursorB.close();
                roomSQLiteQueryA.release();
                return arrayList;
            } catch (Throwable th) {
                cursorB.close();
                roomSQLiteQueryA.release();
                throw th;
            }
        } finally {
            workDatabase_Impl.j();
        }
    }
}
