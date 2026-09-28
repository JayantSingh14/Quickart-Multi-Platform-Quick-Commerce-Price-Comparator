package com.google.android.play.core.review;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.review.internal.zzt;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes4.dex */
public final class zzd implements ReviewManager {

    /* renamed from: a, reason: collision with root package name */
    public final zzi f41888a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f41889b = new Handler(Looper.getMainLooper());

    public zzd(zzi zziVar) {
        this.f41888a = zziVar;
    }

    @Override // com.google.android.play.core.review.ReviewManager
    public final Task a(Activity activity, ReviewInfo reviewInfo) {
        if (reviewInfo.b()) {
            return Tasks.e(null);
        }
        Intent intent = new Intent(activity, (Class<?>) PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", reviewInfo.a());
        intent.putExtra("window_flags", activity.getWindow().getDecorView().getWindowSystemUiVisibility());
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        intent.putExtra("result_receiver", new zzc(this.f41889b, taskCompletionSource));
        activity.startActivity(intent);
        return taskCompletionSource.f39750a;
    }

    public final Task b() {
        zzi zziVar = this.f41888a;
        Object[] objArr = {zziVar.f41897b};
        com.google.android.play.core.review.internal.zzi zziVar2 = zzi.f41895c;
        zziVar2.a("requestInAppReview (%s)", objArr);
        zzt zztVar = zziVar.f41896a;
        if (zztVar != null) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            zztVar.b(new zzf(zziVar, taskCompletionSource, taskCompletionSource), taskCompletionSource);
            return taskCompletionSource.f39750a;
        }
        Object[] objArr2 = new Object[0];
        if (Log.isLoggable("PlayCore", 6)) {
            Log.e("PlayCore", com.google.android.play.core.review.internal.zzi.b(zziVar2.f41857a, "Play Store app is either not installed or not the official version", objArr2));
        }
        return Tasks.d(new ReviewException(-1));
    }
}
