package com.facebook.react.bridge.queue;

import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.media.b;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.lifecycle.a;
import com.facebook.common.logging.FLog;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.queue.MessageQueueThreadSpec;
import com.facebook.react.common.futures.SimpleSettableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.StringUtils;

@DoNotStrip
/* loaded from: classes.dex */
public class MessageQueueThreadImpl implements MessageQueueThread {
    private final String mAssertionErrorMessage;
    private final MessageQueueThreadHandler mHandler;
    private volatile boolean mIsFinished;
    private final Looper mLooper;
    private final String mName;

    @Nullable
    private final MessageQueueThreadPerfStats mPerfStats;

    /* renamed from: com.facebook.react.bridge.queue.MessageQueueThreadImpl$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$queue$MessageQueueThreadSpec$ThreadType;

        static {
            int[] iArr = new int[MessageQueueThreadSpec.ThreadType.values().length];
            $SwitchMap$com$facebook$react$bridge$queue$MessageQueueThreadSpec$ThreadType = iArr;
            try {
                iArr[MessageQueueThreadSpec.ThreadType.MAIN_UI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$queue$MessageQueueThreadSpec$ThreadType[MessageQueueThreadSpec.ThreadType.NEW_BACKGROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private MessageQueueThreadImpl(String str, Looper looper, QueueThreadExceptionHandler queueThreadExceptionHandler) {
        this(str, looper, queueThreadExceptionHandler, null);
    }

    private static void assignToPerfStats(@Nullable MessageQueueThreadPerfStats messageQueueThreadPerfStats, long j2, long j3) {
        if (messageQueueThreadPerfStats == null) {
            return;
        }
        messageQueueThreadPerfStats.wallTime = j2;
        messageQueueThreadPerfStats.cpuTime = j3;
    }

    public static MessageQueueThreadImpl create(MessageQueueThreadSpec messageQueueThreadSpec, QueueThreadExceptionHandler queueThreadExceptionHandler) {
        int i2 = AnonymousClass1.$SwitchMap$com$facebook$react$bridge$queue$MessageQueueThreadSpec$ThreadType[messageQueueThreadSpec.getThreadType().ordinal()];
        if (i2 == 1) {
            return createForMainThread(messageQueueThreadSpec.getName(), queueThreadExceptionHandler);
        }
        if (i2 == 2) {
            return startNewBackgroundThread(messageQueueThreadSpec.getName(), messageQueueThreadSpec.getStackSize(), queueThreadExceptionHandler);
        }
        throw new RuntimeException("Unknown thread type: " + messageQueueThreadSpec.getThreadType());
    }

    private static MessageQueueThreadImpl createForMainThread(String str, QueueThreadExceptionHandler queueThreadExceptionHandler) {
        return new MessageQueueThreadImpl(str, Looper.getMainLooper(), queueThreadExceptionHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void lambda$callOnQueue$0(SimpleSettableFuture simpleSettableFuture, Callable callable) throws Exception {
        try {
            Object objCall = callable.call();
            CountDownLatch countDownLatch = simpleSettableFuture.f18717a;
            if (countDownLatch.getCount() == 0) {
                throw new RuntimeException("Result has already been set!");
            }
            simpleSettableFuture.f18718b = objCall;
            countDownLatch.countDown();
        } catch (Exception exception) {
            simpleSettableFuture.getClass();
            Intrinsics.checkNotNullParameter(exception, "exception");
            CountDownLatch countDownLatch2 = simpleSettableFuture.f18717a;
            if (countDownLatch2.getCount() == 0) {
                throw new RuntimeException("Result has already been set!");
            }
            simpleSettableFuture.f18719c = exception;
            countDownLatch2.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resetPerfStats$1() {
        assignToPerfStats(this.mPerfStats, SystemClock.uptimeMillis(), SystemClock.currentThreadTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void lambda$startNewBackgroundThread$2(SimpleSettableFuture simpleSettableFuture) throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(-4);
        Looper.prepare();
        MessageQueueThreadPerfStats messageQueueThreadPerfStats = new MessageQueueThreadPerfStats();
        assignToPerfStats(messageQueueThreadPerfStats, SystemClock.uptimeMillis(), SystemClock.currentThreadTimeMillis());
        Pair pair = new Pair(Looper.myLooper(), messageQueueThreadPerfStats);
        CountDownLatch countDownLatch = simpleSettableFuture.f18717a;
        if (countDownLatch.getCount() == 0) {
            throw new RuntimeException("Result has already been set!");
        }
        simpleSettableFuture.f18718b = pair;
        countDownLatch.countDown();
        Looper.loop();
    }

    private static MessageQueueThreadImpl startNewBackgroundThread(String str, long j2, QueueThreadExceptionHandler queueThreadExceptionHandler) {
        SimpleSettableFuture simpleSettableFuture = new SimpleSettableFuture();
        new Thread(null, new a(simpleSettableFuture, 2), b.C("mqt_", str), j2).start();
        try {
            Pair pair = (Pair) simpleSettableFuture.get();
            return new MessageQueueThreadImpl(str, (Looper) pair.first, queueThreadExceptionHandler, (MessageQueueThreadPerfStats) pair.second);
        } catch (InterruptedException e2) {
            throw new RuntimeException(e2);
        } catch (ExecutionException e3) {
            throw new RuntimeException(e3);
        }
    }

    @Override // com.facebook.react.bridge.queue.MessageQueueThread
    @DoNotStrip
    public void assertIsOnThread() {
        SoftAssertions.assertCondition(isOnThread(), this.mAssertionErrorMessage);
    }

    @Override // com.facebook.react.bridge.queue.MessageQueueThread
    @DoNotStrip
    public <T> Future<T> callOnQueue(Callable<T> callable) {
        SimpleSettableFuture simpleSettableFuture = new SimpleSettableFuture();
        runOnQueue(new androidx.constraintlayout.motion.widget.a(19, simpleSettableFuture, callable));
        return simpleSettableFuture;
    }

    public Looper getLooper() {
        return this.mLooper;
    }

    public String getName() {
        return this.mName;
    }

    @Override // com.facebook.react.bridge.queue.MessageQueueThread
    @Nullable
    @DoNotStrip
    public MessageQueueThreadPerfStats getPerfStats() {
        return this.mPerfStats;
    }

    @Override // com.facebook.react.bridge.queue.MessageQueueThread
    @DoNotStrip
    public boolean isIdle() {
        return this.mLooper.getQueue().isIdle();
    }

    @Override // com.facebook.react.bridge.queue.MessageQueueThread
    @DoNotStrip
    public boolean isOnThread() {
        return this.mLooper.getThread() == Thread.currentThread();
    }

    @Override // com.facebook.react.bridge.queue.MessageQueueThread
    @DoNotStrip
    public void quitSynchronous() throws InterruptedException {
        this.mIsFinished = true;
        this.mLooper.quit();
        if (this.mLooper.getThread() != Thread.currentThread()) {
            try {
                this.mLooper.getThread().join();
            } catch (InterruptedException unused) {
                throw new RuntimeException("Got interrupted waiting to join thread " + this.mName);
            }
        }
    }

    @Override // com.facebook.react.bridge.queue.MessageQueueThread
    @DoNotStrip
    public void resetPerfStats() {
        assignToPerfStats(this.mPerfStats, -1L, -1L);
        runOnQueue(new androidx.constraintlayout.helper.widget.a(this, 12));
    }

    @Override // com.facebook.react.bridge.queue.MessageQueueThread
    @DoNotStrip
    public boolean runOnQueue(Runnable runnable) {
        if (!this.mIsFinished) {
            this.mHandler.post(runnable);
            return true;
        }
        FLog.q("ReactNative", "Tried to enqueue runnable on already finished thread: '" + getName() + "... dropping Runnable.");
        return false;
    }

    private MessageQueueThreadImpl(String str, Looper looper, QueueThreadExceptionHandler queueThreadExceptionHandler, @Nullable MessageQueueThreadPerfStats messageQueueThreadPerfStats) {
        this.mIsFinished = false;
        this.mName = str;
        this.mLooper = looper;
        this.mHandler = new MessageQueueThreadHandler(looper, queueThreadExceptionHandler);
        this.mPerfStats = messageQueueThreadPerfStats;
        this.mAssertionErrorMessage = "Expected to be called from the '" + getName() + "' thread!";
    }

    @Override // com.facebook.react.bridge.queue.MessageQueueThread
    @DoNotStrip
    public void assertIsOnThread(String str) {
        SoftAssertions.assertCondition(isOnThread(), this.mAssertionErrorMessage + StringUtils.SPACE + str);
    }
}
