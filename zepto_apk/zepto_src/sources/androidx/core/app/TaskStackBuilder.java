package androidx.core.app;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class TaskStackBuilder implements Iterable<Intent> {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2718a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatActivity f2719b;

    /* loaded from: classes.dex */
    public interface SupportParentable {
        Intent getSupportParentActivityIntent();
    }

    public TaskStackBuilder(AppCompatActivity appCompatActivity) {
        this.f2719b = appCompatActivity;
    }

    public static TaskStackBuilder d(AppCompatActivity appCompatActivity) {
        return new TaskStackBuilder(appCompatActivity);
    }

    public final void b(AppCompatActivity appCompatActivity) {
        Intent supportParentActivityIntent = appCompatActivity.getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = NavUtils.a(appCompatActivity);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            AppCompatActivity appCompatActivity2 = this.f2719b;
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(appCompatActivity2.getPackageManager());
            }
            ArrayList arrayList = this.f2718a;
            int size = arrayList.size();
            try {
                for (Intent intentB = NavUtils.b(appCompatActivity2, component); intentB != null; intentB = NavUtils.b(appCompatActivity2, intentB.getComponent())) {
                    arrayList.add(size, intentB);
                }
                arrayList.add(supportParentActivityIntent);
            } catch (PackageManager.NameNotFoundException e2) {
                Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                throw new IllegalArgumentException(e2);
            }
        }
    }

    public final void f() {
        ArrayList arrayList = this.f2718a;
        if (arrayList.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        this.f2719b.startActivities(intentArr, null);
    }

    @Override // java.lang.Iterable
    public final Iterator<Intent> iterator() {
        return this.f2718a.iterator();
    }
}
