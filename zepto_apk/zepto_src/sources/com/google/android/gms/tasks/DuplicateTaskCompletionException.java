package com.google.android.gms.tasks;

/* loaded from: classes4.dex */
public final class DuplicateTaskCompletionException extends IllegalStateException {
    public static IllegalStateException a(Task task) {
        if (!task.o()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception excK = task.k();
        return new DuplicateTaskCompletionException("Complete with: ".concat(excK != null ? "failure" : task.p() ? "result ".concat(String.valueOf(task.l())) : ((zzw) task).f39807d ? "cancellation" : "unknown issue"), excK);
    }
}
