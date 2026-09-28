package androidx.constraintlayout.core;

import android.support.v4.media.b;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class Metrics {

    /* renamed from: a, reason: collision with root package name */
    public long f1677a;

    /* renamed from: b, reason: collision with root package name */
    public long f1678b;

    /* renamed from: c, reason: collision with root package name */
    public long f1679c;

    /* renamed from: d, reason: collision with root package name */
    public long f1680d;

    /* renamed from: e, reason: collision with root package name */
    public long f1681e;

    /* renamed from: f, reason: collision with root package name */
    public long f1682f;

    /* renamed from: g, reason: collision with root package name */
    public long f1683g;

    public Metrics() {
        new ArrayList();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("\n*** Metrics ***\nmeasures: ");
        sb.append(this.f1677a);
        sb.append("\nmeasuresWrap: 0\nmeasuresWrapInfeasible: 0\ndetermineGroups: 0\ninfeasibleDetermineGroups: 0\ngraphOptimizer: ");
        sb.append(this.f1679c);
        sb.append("\nwidgets: ");
        sb.append(this.f1683g);
        sb.append("\ngraphSolved: ");
        sb.append(this.f1680d);
        sb.append("\nlinearSolved: ");
        return b.p(sb, 0L, StringUtils.LF);
    }
}
