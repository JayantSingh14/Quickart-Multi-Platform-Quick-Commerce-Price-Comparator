package com.google.firebase.messaging;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
class TopicsSubscriber {

    /* renamed from: i, reason: collision with root package name */
    public static final long f44780i = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f44781j = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Context f44782a;

    /* renamed from: b, reason: collision with root package name */
    public final Metadata f44783b;

    /* renamed from: c, reason: collision with root package name */
    public final GmsRpc f44784c;

    /* renamed from: d, reason: collision with root package name */
    public final FirebaseMessaging f44785d;

    /* renamed from: f, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f44787f;

    /* renamed from: h, reason: collision with root package name */
    public final TopicsStore f44789h;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayMap f44786e = new ArrayMap();

    /* renamed from: g, reason: collision with root package name */
    public boolean f44788g = false;

    public TopicsSubscriber(FirebaseMessaging firebaseMessaging, Metadata metadata, TopicsStore topicsStore, GmsRpc gmsRpc, Context context, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.f44785d = firebaseMessaging;
        this.f44783b = metadata;
        this.f44789h = topicsStore;
        this.f44784c = gmsRpc;
        this.f44782a = context;
        this.f44787f = scheduledThreadPoolExecutor;
    }

    public static void a(Task task) throws IOException {
        try {
            Tasks.b(task, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException | TimeoutException e2) {
            throw new IOException("SERVICE_NOT_AVAILABLE", e2);
        } catch (ExecutionException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            if (!(cause instanceof RuntimeException)) {
                throw new IOException(e3);
            }
            throw ((RuntimeException) cause);
        }
    }

    public final void b(String str) throws IOException {
        String strA = this.f44785d.a();
        GmsRpc gmsRpc = this.f44784c;
        gmsRpc.getClass();
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str);
        a(gmsRpc.a(gmsRpc.c(strA, "/topics/" + str, bundle)));
    }

    public final void c(String str) throws IOException {
        String strA = this.f44785d.a();
        GmsRpc gmsRpc = this.f44784c;
        gmsRpc.getClass();
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str);
        bundle.putString("delete", "1");
        a(gmsRpc.a(gmsRpc.c(strA, "/topics/" + str, bundle)));
    }

    public final Task d(TopicOperation topicOperation) {
        ArrayDeque arrayDeque;
        TopicsStore topicsStore = this.f44789h;
        synchronized (topicsStore) {
            SharedPreferencesQueue sharedPreferencesQueue = topicsStore.f44778a;
            String str = topicOperation.f44776c;
            sharedPreferencesQueue.getClass();
            if (!TextUtils.isEmpty(str) && !str.contains(sharedPreferencesQueue.f44759c)) {
                synchronized (sharedPreferencesQueue.f44760d) {
                    if (sharedPreferencesQueue.f44760d.add(str)) {
                        sharedPreferencesQueue.f44761e.execute(new s(sharedPreferencesQueue, 0));
                    }
                }
            }
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        synchronized (this.f44786e) {
            try {
                String str2 = topicOperation.f44776c;
                if (this.f44786e.containsKey(str2)) {
                    arrayDeque = (ArrayDeque) this.f44786e.get(str2);
                } else {
                    ArrayDeque arrayDeque2 = new ArrayDeque();
                    this.f44786e.put(str2, arrayDeque2);
                    arrayDeque = arrayDeque2;
                }
                arrayDeque.add(taskCompletionSource);
            } catch (Throwable th) {
                throw th;
            }
        }
        return taskCompletionSource.f39750a;
    }

    public final synchronized void e(boolean z) {
        this.f44788g = z;
    }

    public final void f() {
        boolean z;
        if (this.f44789h.a() != null) {
            synchronized (this) {
                z = this.f44788g;
            }
            if (z) {
                return;
            }
            h(0L);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 347
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.TopicsSubscriber.g():boolean");
    }

    public final void h(long j2) {
        this.f44787f.schedule(new TopicsSyncTask(this, this.f44782a, this.f44783b, Math.min(Math.max(30L, 2 * j2), f44780i)), j2, TimeUnit.SECONDS);
        e(true);
    }
}
