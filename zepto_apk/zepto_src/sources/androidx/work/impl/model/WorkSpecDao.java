package androidx.work.impl.model;

import android.annotation.SuppressLint;
import androidx.room.Dao;
import androidx.work.Data;
import androidx.work.WorkInfo;
import java.util.ArrayList;
import kotlin.Metadata;

@Dao
@Metadata
@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public interface WorkSpecDao {
    int A(String str);

    int B();

    void a(String str);

    void b(String str);

    int c(long j2, String str);

    ArrayList d(long j2);

    void e(WorkSpec workSpec);

    void f(int i2, String str);

    ArrayList g();

    ArrayList h(String str);

    WorkInfo.State i(String str);

    WorkSpec j(String str);

    int k(String str);

    ArrayList l(String str);

    ArrayList m(String str);

    int n();

    ArrayList o();

    ArrayList p(String str);

    ArrayList q(int i2);

    int r(WorkInfo.State state, String str);

    void s(long j2, String str);

    void t(String str, Data data);

    ArrayList u();

    void v(int i2, String str);

    boolean w();

    ArrayList x();

    int y(String str);

    ArrayList z(String str);
}
