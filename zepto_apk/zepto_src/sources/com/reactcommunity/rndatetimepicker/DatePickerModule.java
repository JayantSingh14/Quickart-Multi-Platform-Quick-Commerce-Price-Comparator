package com.reactcommunity.rndatetimepicker;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.DatePicker;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.media3.exoplayer.source.h;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;
import java.util.Calendar;

@ReactModule(name = DatePickerModule.NAME)
/* loaded from: classes4.dex */
public class DatePickerModule extends NativeModuleDatePickerSpec {

    @VisibleForTesting
    public static final String NAME = "RNCDatePicker";

    public class DatePickerDialogListener implements DatePickerDialog.OnDateSetListener, DialogInterface.OnDismissListener, DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final Promise f46134a;

        /* renamed from: b, reason: collision with root package name */
        public final Bundle f46135b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f46136c = false;

        public DatePickerDialogListener(Promise promise, Bundle bundle) {
            this.f46134a = promise;
            this.f46135b = bundle;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i2) {
            if (this.f46136c || !DatePickerModule.this.getReactApplicationContext().hasActiveReactInstance()) {
                return;
            }
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("action", "neutralButtonAction");
            this.f46134a.resolve(writableNativeMap);
            this.f46136c = true;
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public final void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
            if (this.f46136c || !DatePickerModule.this.getReactApplicationContext().hasActiveReactInstance()) {
                return;
            }
            Bundle bundle = this.f46135b;
            RNDate rNDate = new RNDate(bundle);
            Calendar calendar = Calendar.getInstance(Common.c(bundle));
            calendar.set(i2, i3, i4, rNDate.f46150a.get(11), rNDate.f46150a.get(12), 0);
            calendar.set(14, 0);
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("action", "dateSetAction");
            writableNativeMap.putDouble("timestamp", calendar.getTimeInMillis());
            writableNativeMap.putDouble("utcOffset", (calendar.getTimeZone().getOffset(calendar.getTimeInMillis()) / 1000) / 60);
            this.f46134a.resolve(writableNativeMap);
            this.f46136c = true;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            if (this.f46136c || !DatePickerModule.this.getReactApplicationContext().hasActiveReactInstance()) {
                return;
            }
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("action", "dismissedAction");
            this.f46134a.resolve(writableNativeMap);
            this.f46136c = true;
        }
    }

    public DatePickerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private Bundle createFragmentArguments(ReadableMap readableMap) {
        Bundle bundleA = Common.a(readableMap);
        if (readableMap.hasKey("minimumDate") && !readableMap.isNull("minimumDate")) {
            bundleA.putLong("minimumDate", (long) readableMap.getDouble("minimumDate"));
        }
        if (readableMap.hasKey("maximumDate") && !readableMap.isNull("maximumDate")) {
            bundleA.putLong("maximumDate", (long) readableMap.getDouble("maximumDate"));
        }
        if (readableMap.hasKey("display") && !readableMap.isNull("display")) {
            bundleA.putString("display", readableMap.getString("display"));
        }
        if (readableMap.hasKey("dialogButtons") && !readableMap.isNull("dialogButtons")) {
            bundleA.putBundle("dialogButtons", Arguments.toBundle(readableMap.getMap("dialogButtons")));
        }
        if (readableMap.hasKey("timeZoneOffsetInMinutes") && !readableMap.isNull("timeZoneOffsetInMinutes")) {
            bundleA.putLong("timeZoneOffsetInMinutes", (long) readableMap.getDouble("timeZoneOffsetInMinutes"));
        }
        if (readableMap.hasKey("testID") && !readableMap.isNull("testID")) {
            bundleA.putString("testID", readableMap.getString("testID"));
        }
        if (readableMap.hasKey("firstDayOfWeek") && !readableMap.isNull("firstDayOfWeek")) {
            bundleA.putInt("firstDayOfWeek", readableMap.getInt("firstDayOfWeek") + 1);
        }
        return bundleA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$open$0(FragmentManager fragmentManager, ReadableMap readableMap, Promise promise) {
        RNDatePickerDialogFragment rNDatePickerDialogFragment = (RNDatePickerDialogFragment) fragmentManager.E(NAME);
        Bundle bundleCreateFragmentArguments = createFragmentArguments(readableMap);
        if (rNDatePickerDialogFragment != null) {
            RNDate rNDate = new RNDate(bundleCreateFragmentArguments);
            rNDatePickerDialogFragment.Q.updateDate(rNDate.f46150a.get(1), rNDate.f46150a.get(2), rNDate.f46150a.get(5));
            return;
        }
        RNDatePickerDialogFragment rNDatePickerDialogFragment2 = new RNDatePickerDialogFragment();
        rNDatePickerDialogFragment2.setArguments(bundleCreateFragmentArguments);
        DatePickerDialogListener datePickerDialogListener = new DatePickerDialogListener(promise, bundleCreateFragmentArguments);
        rNDatePickerDialogFragment2.Y = datePickerDialogListener;
        rNDatePickerDialogFragment2.X = datePickerDialogListener;
        rNDatePickerDialogFragment2.Z = datePickerDialogListener;
        rNDatePickerDialogFragment2.show(fragmentManager, NAME);
    }

    @Override // com.reactcommunity.rndatetimepicker.NativeModuleDatePickerSpec
    @ReactMethod
    public void dismiss(Promise promise) {
        Common.b((FragmentActivity) getCurrentActivity(), NAME, promise);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NonNull
    public String getName() {
        return NAME;
    }

    @Override // com.reactcommunity.rndatetimepicker.NativeModuleDatePickerSpec
    @ReactMethod
    public void open(ReadableMap readableMap, Promise promise) {
        FragmentActivity fragmentActivity = (FragmentActivity) getCurrentActivity();
        if (fragmentActivity == null) {
            promise.reject("E_NO_ACTIVITY", "Tried to open a DatePicker dialog while not attached to an Activity");
        } else {
            UiThreadUtil.runOnUiThread(new h(this, fragmentActivity.getSupportFragmentManager(), readableMap, promise, 6));
        }
    }
}
