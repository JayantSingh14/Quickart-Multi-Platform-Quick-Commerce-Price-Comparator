package in.juspay.hypersdk.core;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.JavascriptInterface;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hypersdk.mystique.Callback;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
final class AndroidInterface {
    private final DynamicUI dynamicUI;
    private String state;
    private final Map<String, PendingAddScreenMapItem> pendingAddScreenMap = new HashMap();
    private final Set<String> onGoingPrepareScreenSet = new HashSet();

    public static final class PendingAddScreenMapItem {
        String callbackName;
        int index;
        String parentId;
        boolean replaceChild;
        String runInUIprop;
        String screenName;

        public PendingAddScreenMapItem(String str, String str2, int i2, String str3, boolean z, String str4) {
            this.parentId = str;
            this.screenName = str2;
            this.index = i2;
            this.callbackName = str3;
            this.replaceChild = z;
            this.runInUIprop = str4;
        }
    }

    public static class PreRenderThread extends Thread {
        public PreRenderThread(Runnable runnable) {
            super(runnable);
            setName("PreRenderThread");
        }
    }

    public AndroidInterface(@NonNull DynamicUI dynamicUI) {
        this.dynamicUI = dynamicUI;
    }

    private int findChildIndex(int i2, ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (viewGroup.getChildAt(i3).getId() == i2) {
                return i3;
            }
        }
        return -1;
    }

    @NonNull
    private String getJSONResult(String str) {
        JSONArray jSONArray = new JSONArray(str);
        InflateJSON inflateJSON = new InflateJSON(this.dynamicUI);
        inflateJSON.setUseAppContext(this.dynamicUI.getActivity() == null);
        Object objRunJSON = inflateJSON.runJSON(null, jSONArray, inflateJSON.getUseAppContext(), null);
        return objRunJSON != null ? objRunJSON.toString() : "_null_";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addStoredViewToParent$3(String str, String str2, int i2, String str3, boolean z, String str4, String str5) {
        try {
            if (this.onGoingPrepareScreenSet.contains(str)) {
                this.pendingAddScreenMap.put(str, new PendingAddScreenMapItem(str2, str, i2, str3, z, str4));
                return;
            }
            this.dynamicUI.getRenderer().addStoredViewToParent(str2, str, i2, z, str5);
            InflateJSON inflateJSON = new InflateJSON(this.dynamicUI);
            inflateJSON.setUseAppContext(true);
            this.dynamicUI.getRenderer().parseAndRunPipe(this.dynamicUI.getAppContext(), str4, "", "", inflateJSON.getUseAppContext());
            if (str3 != null) {
                this.dynamicUI.addJsToWebView("window.callUICallback('" + str3 + "','success');");
            }
        } catch (Exception e2) {
            this.dynamicUI.getLogger().e(MerchantConstants.ERROR, " excep: fn__addStoredViewToParent  - " + this.dynamicUI.getRenderer().getErrorDetails());
            this.dynamicUI.getErrorCallback().onException(MerchantConstants.ERROR, " excep: fn__addStoredViewToParent  - " + this.dynamicUI.getRenderer().getErrorDetails(), e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addViewToParent$1(String str, JSONObject jSONObject, int i2, boolean z, String str2, String str3) {
        try {
            this.dynamicUI.getRenderer().addViewToParent(str, jSONObject, i2, z, str2);
            if (str3 != null) {
                this.dynamicUI.addJsToWebView("window.callUICallback('" + str3 + "','success');");
            }
        } catch (Exception e2) {
            this.dynamicUI.getLogger().e(MerchantConstants.ERROR, " excep: fn__addViewToParent  - " + this.dynamicUI.getRenderer().getErrorDetails());
            this.dynamicUI.getErrorCallback().onException(MerchantConstants.ERROR, " excep: fn__addViewToParent  - " + this.dynamicUI.getRenderer().getErrorDetails(), e2);
            if (str3 != null) {
                this.dynamicUI.addJsToWebView(android.support.v4.media.b.D("window.callUICallback('", str3, "','failure');"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cancelAnim$18(ObjectAnimator objectAnimator, String str, String str2) {
        try {
            objectAnimator.cancel();
            float fFloatValue = ((Float) objectAnimator.getAnimatedValue()).floatValue();
            this.dynamicUI.addJsToWebView("window.callUICallback('" + str + "', '" + fFloatValue + "');");
        } catch (Exception unused) {
            this.dynamicUI.getLogger().e("JSONERROR", "Error parsing json for animation with id " + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$generateUIElement$15(String str, String str2, int i2, final String[] strArr, final String str3) {
        ViewGroup container = this.dynamicUI.getContainer(str);
        if (container == null) {
            this.dynamicUI.getLogger().e("missing_container", "render, no container");
        } else if (str2.equals("PopupMenu")) {
            container.findViewById(i2).setOnClickListener(new View.OnClickListener() { // from class: in.juspay.hypersdk.core.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f48575a.lambda$generateUIElement$14(strArr, str3, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$moveView$5(String str, String str2, String str3) {
        try {
            ViewGroup container = this.dynamicUI.getContainer(str);
            if (container == null) {
                this.dynamicUI.getLogger().e("missing_container", "moveView, no container");
                return;
            }
            View viewFindViewById = container.findViewById(Integer.parseInt(str2));
            ViewGroup viewGroup = (ViewGroup) viewFindViewById.getParent();
            viewGroup.removeView(viewFindViewById);
            viewGroup.addView(viewFindViewById, Integer.parseInt(str3));
        } catch (Exception unused) {
            this.dynamicUI.getLogger().e(MerchantConstants.ERROR, " fn__moveView - " + this.dynamicUI.getRenderer().getErrorDetails());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$prepareAndStoreView$2(String str, JSONObject jSONObject, String str2) {
        try {
            setPrepareScreenTaskStatus(str, true);
            this.dynamicUI.getRenderer().prepareAndStoreView(str, jSONObject);
            if (str2 != null) {
                this.dynamicUI.addJsToWebView("window.callUICallback('" + str2 + "','success');");
            }
        } catch (Exception e2) {
            this.dynamicUI.getLogger().e(MerchantConstants.ERROR, " excep: fn__prepareAndStoreView  - " + this.dynamicUI.getRenderer().getErrorDetails());
            this.dynamicUI.getErrorCallback().onException(MerchantConstants.ERROR, " excep: fn__prepareAndStoreView  - " + this.dynamicUI.getRenderer().getErrorDetails(), e2);
            if (str2 != null) {
                this.dynamicUI.addJsToWebView(android.support.v4.media.b.D("window.callUICallback('", str2, "','failure');"));
            }
        }
        setPrepareScreenTaskStatus(str, false);
        processPendingAddScreen(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processPendingAddScreen$21(String str) {
        PendingAddScreenMapItem pendingAddScreenMapItem = this.pendingAddScreenMap.get(str);
        if (pendingAddScreenMapItem != null) {
            this.pendingAddScreenMap.remove(str);
            addStoredViewToParent(pendingAddScreenMapItem.parentId, pendingAddScreenMapItem.screenName, pendingAddScreenMapItem.index, pendingAddScreenMapItem.callbackName, pendingAddScreenMapItem.replaceChild, pendingAddScreenMapItem.runInUIprop, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeView$6(String str, int i2) {
        ViewGroup container = this.dynamicUI.getContainer(str);
        if (container == null) {
            this.dynamicUI.getLogger().e("missing_container", "removeView, no container");
            return;
        }
        View viewFindViewById = container.findViewById(i2);
        if (viewFindViewById == null) {
            return;
        }
        ((ViewGroup) viewFindViewById.getParent()).removeView(viewFindViewById);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$render$0(JSONObject jSONObject, String str, String str2, String str3) {
        try {
            this.dynamicUI.getRenderer().renderUI(jSONObject, this.dynamicUI.getContainer(str), Boolean.parseBoolean(str2), str);
            if (str3 != null) {
                this.dynamicUI.addJsToWebView("window.callUICallback(" + str3 + ",'success');");
            }
        } catch (Exception e2) {
            this.dynamicUI.getLogger().e(MerchantConstants.ERROR, " excep: fn__Render  - " + this.dynamicUI.getRenderer().getErrorDetails());
            this.dynamicUI.getErrorCallback().onException(MerchantConstants.ERROR, " excep: fn__Render  - " + this.dynamicUI.getRenderer().getErrorDetails(), e2);
            if (str3 != null) {
                this.dynamicUI.addJsToWebView(android.support.v4.media.b.D("window.callUICallback(", str3, ",'failure');"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$replaceView$4(String str, JSONObject jSONObject, int i2) {
        try {
            ViewGroup container = this.dynamicUI.getContainer(str);
            if (container == null) {
                this.dynamicUI.getLogger().e("missing_container", "replaceView, no container");
                return;
            }
            View viewCreateView = this.dynamicUI.getRenderer().createView(jSONObject);
            View viewFindViewById = container.findViewById(i2);
            if (viewFindViewById != null) {
                if (viewFindViewById instanceof ViewGroup) {
                    int childCount = ((ViewGroup) viewFindViewById).getChildCount();
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View childAt = ((ViewGroup) viewFindViewById).getChildAt(0);
                        if (childAt != null) {
                            ((ViewGroup) viewFindViewById).removeViewAt(0);
                            ((ViewGroup) viewCreateView).addView(childAt, i3);
                        }
                    }
                }
                if (replaceViewImpl(viewCreateView, viewFindViewById)) {
                    viewCreateView.requestLayout();
                }
            }
        } catch (JSONException unused) {
        } catch (Exception e2) {
            this.dynamicUI.getLogger().e(e2.getLocalizedMessage(), "excep: fn__replaceView - Error while replaceView " + e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runInUI$7(String str, String str2, String str3, String str4) {
        try {
            InflateJSON inflateJSON = new InflateJSON(this.dynamicUI);
            if (this.dynamicUI.getActivity() != null) {
                inflateJSON.setUseAppContext(false);
                this.dynamicUI.getRenderer().parseAndRunPipe(this.dynamicUI.getActivity(), str, str2, str3, inflateJSON.getUseAppContext());
            } else {
                inflateJSON.setUseAppContext(true);
                this.dynamicUI.getRenderer().parseAndRunPipe(this.dynamicUI.getAppContext(), str, str2, str3, inflateJSON.getUseAppContext());
            }
            if (str4 != null) {
                this.dynamicUI.addJsToWebView("window.callUICallback(" + str4 + ",'success');");
            }
        } catch (Exception e2) {
            this.dynamicUI.getLogger().e(MerchantConstants.ERROR, " excep: fn__runInUI  - " + this.dynamicUI.getRenderer().getErrorDetails());
            this.dynamicUI.getErrorCallback().onException(MerchantConstants.ERROR, " excep: fn__runInUI  - " + this.dynamicUI.getRenderer().getErrorDetails(), e2);
            if (str4 != null) {
                this.dynamicUI.addJsToWebView(android.support.v4.media.b.D("window.callUICallback(", str4, ",'failure');"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runInUI$8(String str, String str2) {
        try {
            InflateJSON inflateJSON = new InflateJSON(this.dynamicUI);
            if (this.dynamicUI.getActivity() != null) {
                inflateJSON.setUseAppContext(false);
                this.dynamicUI.getRenderer().parseAndRunPipe(this.dynamicUI.getActivity(), str, "", "", inflateJSON.getUseAppContext());
            } else {
                inflateJSON.setUseAppContext(true);
                this.dynamicUI.getRenderer().parseAndRunPipe(this.dynamicUI.getAppContext(), str, "", "", inflateJSON.getUseAppContext());
            }
            if (str2 != null) {
                this.dynamicUI.addJsToWebView("window.callUICallback(" + str2 + ",'success');");
            }
        } catch (Exception e2) {
            String name = e2.getClass().getName();
            DuiLogger logger = this.dynamicUI.getLogger();
            StringBuilder sbY = android.support.v4.media.b.y(" excep: fn__runInUI  - ", name, " - ");
            sbY.append(this.dynamicUI.getRenderer().getErrorDetails());
            logger.e(MerchantConstants.ERROR, sbY.toString());
            Callback errorCallback = this.dynamicUI.getErrorCallback();
            StringBuilder sbY2 = android.support.v4.media.b.y(" excep: fn__runInUI  - ", name, " - ");
            sbY2.append(this.dynamicUI.getRenderer().getErrorDetails());
            errorCallback.onError(MerchantConstants.ERROR, sbY2.toString());
            if (str2 != null) {
                this.dynamicUI.addJsToWebView(android.support.v4.media.b.D("window.callUICallback(", str2, ",'failure');"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setImage$12(String str, int i2, String str2) {
        try {
            ViewGroup container = this.dynamicUI.getContainer(str);
            if (container == null) {
                this.dynamicUI.getLogger().e("missing_container", "setImage, no container");
                return;
            }
            ImageView imageView = (ImageView) container.findViewById(i2);
            byte[] bArrDecode = Base64.decode(str2, 0);
            imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        } catch (Exception e2) {
            this.dynamicUI.getLogger().e(MerchantConstants.ERROR, " excep: fn__setImage  - " + this.dynamicUI.getRenderer().getErrorDetails());
            this.dynamicUI.getErrorCallback().onException(MerchantConstants.ERROR, " excep: fn__setImage  - " + this.dynamicUI.getRenderer().getErrorDetails(), e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setPrepareScreenTaskStatus$20(boolean z, String str) {
        if (z) {
            this.onGoingPrepareScreenSet.add(str);
        } else {
            this.onGoingPrepareScreenSet.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$showPopup$16(String str, MenuItem menuItem) {
        DynamicUI dynamicUI = this.dynamicUI;
        StringBuilder sbY = android.support.v4.media.b.y("window.callUICallback('", str, "', '");
        sbY.append(menuItem.getItemId());
        sbY.append("');");
        dynamicUI.addJsToWebView(sbY.toString());
        Toast.makeText(this.dynamicUI.getActivity(), "You Clicked : " + ((Object) menuItem.getTitle()), 0).show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startAnim$17(Pair pair, final String str, final String str2) {
        if (pair != null) {
            try {
                Object obj = pair.second;
                if (obj != null) {
                    ((ObjectAnimator) obj).start();
                    ((ObjectAnimator) pair.second).addListener(new Animator.AnimatorListener() { // from class: in.juspay.hypersdk.core.AndroidInterface.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(@NonNull Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(@NonNull Animator animator) {
                            String str3 = str;
                            if (str3 == null || str3.isEmpty()) {
                                return;
                            }
                            DynamicUI dynamicUI = AndroidInterface.this.dynamicUI;
                            StringBuilder sb = new StringBuilder("window.callUICallback('");
                            sb.append(str);
                            sb.append("', '");
                            dynamicUI.addJsToWebView(android.support.v4.media.b.r(sb, str2, "');"));
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(@NonNull Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(@NonNull Animator animator) {
                        }
                    });
                }
            } catch (Exception unused) {
                this.dynamicUI.getLogger().e("JSONERROR", "Error parsing json for animation with id " + str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toggleKeyboard$13(String str, int i2, String str2) {
        ViewGroup container = this.dynamicUI.getContainer(str);
        if (container == null) {
            this.dynamicUI.getLogger().e("missing_container", "removeView, no container");
            return;
        }
        View viewFindViewById = container.findViewById(i2);
        InputMethodManager inputMethodManager = (InputMethodManager) this.dynamicUI.getActivity().getSystemService("input_method");
        if (str2.equals("show")) {
            inputMethodManager.showSoftInput(viewFindViewById, 1);
        } else {
            inputMethodManager.hideSoftInputFromWindow(viewFindViewById.getWindowToken(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateAnim$19(String str, int i2, JSONArray jSONArray) {
        try {
            ViewGroup container = this.dynamicUI.getContainer(str);
            if (container == null) {
                this.dynamicUI.getLogger().e("missing_container", "updateAnim, no container");
            } else {
                this.dynamicUI.getRenderer().getInflateView().handleAnimation(container.findViewById(i2), jSONArray);
            }
        } catch (Exception unused) {
            this.dynamicUI.getLogger().e(MerchantConstants.ERROR, "updateAnim: View doesn't exist for id -" + i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateProperties$11(String str, String str2) {
        try {
            ViewGroup container = this.dynamicUI.getContainer(str);
            if (container == null) {
                this.dynamicUI.getLogger().e("missing_container", "updateProperties, no container");
                return;
            }
            JSONObject jSONObject = new JSONObject(str2);
            View viewFindViewById = container.findViewById(jSONObject.getInt(CLConstants.SHARED_PREFERENCE_ITEM_ID));
            jSONObject.remove(CLConstants.SHARED_PREFERENCE_ITEM_ID);
            InflateJSON inflateJSON = new InflateJSON(this.dynamicUI);
            inflateJSON.setUseAppContext(true);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                this.dynamicUI.getRenderer().getInflateView().parseKeys(itKeys.next(), jSONObject, viewFindViewById, inflateJSON.getUseAppContext());
            }
        } catch (Exception e2) {
            this.dynamicUI.getLogger().e(e2.getLocalizedMessage(), "excep: fn__updateProperties- Error while updateProperties " + e2);
        }
    }

    private boolean replaceViewImpl(View view, View view2) {
        ViewGroup viewGroup = (ViewGroup) view2.getParent();
        int iFindChildIndex = findChildIndex(view2.getId(), viewGroup);
        if (iFindChildIndex == -1) {
            return false;
        }
        viewGroup.removeViewAt(iFindChildIndex);
        viewGroup.addView(view, iFindChildIndex);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: runJSONWithCallback, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void lambda$runCmdsInUI$10(String str, String str2) {
        try {
            String jSONResult = getJSONResult(str);
            if (str2 != null) {
                this.dynamicUI.addJsToWebView("window.callUICallback('" + str2 + "'," + this.dynamicUI.encodeUtfAndWrapDecode(jSONResult, MerchantConstants.ERROR) + ");");
            }
        } catch (Exception e2) {
            this.dynamicUI.getLogger().e(MerchantConstants.ERROR, " excep: fn__runInUIJSON  - " + this.dynamicUI.getRenderer().getErrorDetails());
            this.dynamicUI.getErrorCallback().onException(MerchantConstants.ERROR, " excep: fn__runInUIJSON  - " + this.dynamicUI.getRenderer().getErrorDetails(), e2);
            if (str2 != null) {
                this.dynamicUI.addJsToWebView(android.support.v4.media.b.D("window.callUICallbackJSON(", str2, ",'failure');"));
            }
        }
    }

    @JavascriptInterface
    @Deprecated
    public void Render(String str, String str2) {
        Log.d("DynamicUI", "Method Android.Render is deprecated. Use Android.render() instead");
        render(str, str2, null);
    }

    @JavascriptInterface
    public void addStoredViewToParent(String str, String str2, int i2, String str3, boolean z, String str4) {
        addStoredViewToParent(str, str2, i2, str3, z, str4, null);
    }

    @JavascriptInterface
    public String addToContainerList(int i2, String str) {
        ViewGroup container = this.dynamicUI.getContainer(str);
        return (container == null || !(container.findViewById(i2) instanceof ViewGroup)) ? "__failed" : this.dynamicUI.addToContainerList((ViewGroup) container.findViewById(i2));
    }

    @JavascriptInterface
    public void addViewToParent(String str, String str2, int i2, String str3, boolean z) {
        addViewToParent(str, str2, i2, str3, z, null);
    }

    @JavascriptInterface
    public void cancelAnim(String str, String str2) {
        ExecutorManager.runOnMainThread(new h(this, (ObjectAnimator) ((Pair) this.dynamicUI.getRenderer().getInflateView().getStateValFromKey("M_anim_" + str)).second, str2, str, 3));
    }

    @JavascriptInterface
    public void dismissPopUp() {
        this.dynamicUI.getRenderer().dismissPopUp();
    }

    @JavascriptInterface
    public int dpToPx(int i2) {
        if (i2 > 0) {
            return Math.round(i2 * this.dynamicUI.getAppContext().getResources().getDisplayMetrics().density);
        }
        return 0;
    }

    @JavascriptInterface
    public String fetchData(String str) {
        return this.dynamicUI.getAppContext().getSharedPreferences("DUI", 0).getString(str, "null");
    }

    @JavascriptInterface
    public void generateUIElement(String str, int i2, String[] strArr, String str2) {
        generateUIElement(str, i2, strArr, str2, null);
    }

    @JavascriptInterface
    public String getInternalStorageBaseFilePath() {
        return this.dynamicUI.getAppContext().getDir("juspay", 0).getAbsolutePath();
    }

    @JavascriptInterface
    public String getNewID() {
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        return String.valueOf(View.generateViewId());
    }

    public Renderer getRenderer() {
        return this.dynamicUI.getRenderer();
    }

    @JavascriptInterface
    public String getScreenDimensions() throws JSONException {
        int iHeight;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        Rect rect = new Rect();
        try {
            if (this.dynamicUI.getActivity() != null) {
                this.dynamicUI.getActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                this.dynamicUI.getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                if (Build.VERSION.SDK_INT >= 30) {
                    iHeight = this.dynamicUI.getActivity().getWindowManager().getCurrentWindowMetrics().getBounds().height();
                } else {
                    this.dynamicUI.getActivity().getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics2);
                    iHeight = displayMetrics2.heightPixels;
                }
            } else {
                displayMetrics = Resources.getSystem().getDisplayMetrics();
                iHeight = 0;
            }
            jSONObject.put(Snapshot.WIDTH, displayMetrics.widthPixels);
            jSONObject.put(Snapshot.HEIGHT, displayMetrics.heightPixels);
            jSONObject.put("screenHeight", iHeight);
            jSONObject2.put("top", rect.top);
            jSONObject2.put("bottom", rect.bottom);
            jSONObject2.put("left", rect.left);
            jSONObject2.put("right", rect.right);
            jSONObject.put("viewportDimensions", jSONObject2);
        } catch (JSONException e2) {
            this.dynamicUI.getLogger().e("JSON_EXCEPTION", e2.toString());
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String getState() {
        String str = this.state;
        return str != null ? str : "{}";
    }

    @JavascriptInterface
    public boolean isFilePresent(String str) {
        return new File(str).exists();
    }

    @JavascriptInterface
    public void moveView(String str, String str2) {
        moveView(str, str2, null);
    }

    @JavascriptInterface
    public void prepareAndStoreView(String str, String str2, String str3) {
        try {
            new PreRenderThread(new h(this, str, new JSONObject(str2), str3)).start();
        } catch (JSONException unused) {
            this.dynamicUI.getLogger().e("JSONERROR", "Error while parsing " + str2);
        }
    }

    public void processPendingAddScreen(String str) {
        ExecutorManager.runOnMainThread(new l(0, this, str));
    }

    @JavascriptInterface
    public void removeView(int i2) {
        removeView(i2, null);
    }

    @JavascriptInterface
    public void render(String str, String str2) {
        render(str, str2, "true", null);
    }

    @JavascriptInterface
    public void replaceView(String str, int i2) {
        replaceView(str, i2, null);
    }

    @JavascriptInterface
    public void run(String str, String str2) {
        try {
            InflateJSON inflateJSON = new InflateJSON(this.dynamicUI);
            if (this.dynamicUI.getActivity() != null) {
                inflateJSON.setUseAppContext(false);
                this.dynamicUI.getRenderer().parseAndRunPipe(this.dynamicUI.getActivity(), str, "", "", inflateJSON.getUseAppContext());
            } else {
                inflateJSON.setUseAppContext(true);
                this.dynamicUI.getRenderer().parseAndRunPipe(this.dynamicUI.getAppContext(), str, "", "", inflateJSON.getUseAppContext());
            }
            if (str2 != null) {
                this.dynamicUI.addJsToWebView("window.callUICallback(" + str2 + ",'success');");
            }
        } catch (Exception e2) {
            String name = e2.getClass().getName();
            this.dynamicUI.getLogger().e("runInUI", name);
            Callback errorCallback = this.dynamicUI.getErrorCallback();
            StringBuilder sbX = android.support.v4.media.b.x(name, " - ");
            sbX.append(this.dynamicUI.getRenderer().getErrorDetails());
            errorCallback.onError("runInUI", sbX.toString());
            if (str2 != null) {
                this.dynamicUI.addJsToWebView(android.support.v4.media.b.D("window.callUICallback(", str2, ",'failure');"));
            }
        }
    }

    @NonNull
    @JavascriptInterface
    public String runCmds(String str) {
        try {
            return getJSONResult(str);
        } catch (Exception e2) {
            this.dynamicUI.getLogger().e(MerchantConstants.ERROR, " excep: fn__runInUIJSON  - " + this.dynamicUI.getRenderer().getErrorDetails());
            this.dynamicUI.getErrorCallback().onException(MerchantConstants.ERROR, " excep: fn__runInUIJSON  - " + this.dynamicUI.getRenderer().getErrorDetails(), e2);
            return "__failure__";
        }
    }

    @JavascriptInterface
    public void runCmdsInBg(String str, String str2) {
        ExecutorManager.runOnBackgroundThread(new e(0, this, str, str2));
    }

    @JavascriptInterface
    public void runCmdsInUI(String str, String str2) {
        ExecutorManager.runOnMainThread(new e(3, this, str, str2));
    }

    @JavascriptInterface
    public void runInUI(String str, String str2, String str3, String str4) {
        ExecutorManager.runOnMainThread(new b(this, str, str3, str4, str2, 0));
    }

    @JavascriptInterface
    public void saveData(String str, String str2) {
        this.dynamicUI.getAppContext().getSharedPreferences("DUI", 0).edit().putString(str, str2).apply();
    }

    @JavascriptInterface
    public void saveState(String str) {
        this.state = str;
    }

    @JavascriptInterface
    public String setFragmentContainer(int i2, String str) {
        ViewGroup container = this.dynamicUI.getContainer(str);
        if (container == null) {
            return "__failed";
        }
        View viewFindViewById = container.findViewById(i2);
        return viewFindViewById instanceof ViewGroup ? this.dynamicUI.addToContainerList((ViewGroup) viewFindViewById) : "__failed";
    }

    @JavascriptInterface
    public void setImage(int i2, String str, String str2) {
        ExecutorManager.runOnMainThread(new d(this, str2, i2, str, 1));
    }

    public void setPrepareScreenTaskStatus(final String str, final boolean z) {
        ExecutorManager.runOnMainThread(new Runnable() { // from class: in.juspay.hypersdk.core.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f48531a.lambda$setPrepareScreenTaskStatus$20(z, str);
            }
        });
    }

    @JavascriptInterface
    public void setState(String str) {
        this.state = str;
    }

    @JavascriptInterface
    @Deprecated
    public void showLoading() {
        Log.d("DynamicUI", "Android.showLoading() method is deprecated. This method does nothing.");
    }

    /* renamed from: showPopup, reason: merged with bridge method [inline-methods] */
    public void lambda$generateUIElement$14(View view, String[] strArr, String str) {
        if (this.dynamicUI.getActivity() == null) {
            this.dynamicUI.getLogger().e("Missing Activity", "showPopup, it is not  activity, it is applicationContext");
            return;
        }
        PopupMenu popupMenu = new PopupMenu(this.dynamicUI.getActivity(), view);
        for (int i2 = 0; i2 < strArr.length; i2++) {
            popupMenu.getMenu().add(0, i2, 0, strArr[i2]);
        }
        popupMenu.setOnMenuItemClickListener(new k(str, 0, this));
        popupMenu.show();
    }

    @JavascriptInterface
    public void startAnim(String str) {
        startAnim(str, null);
    }

    @JavascriptInterface
    public void throwError(String str) {
        this.dynamicUI.getLogger().e("throwError", str);
    }

    @JavascriptInterface
    public void toggleKeyboard(int i2, String str, String str2) {
        if (this.dynamicUI.getActivity() != null) {
            ExecutorManager.runOnMainThread(new d(this, str2, i2, str, 0));
        } else {
            this.dynamicUI.getLogger().e("Missing Activity", "toggleKeyboard, it is not  activity, it is applicationContext");
        }
    }

    @JavascriptInterface
    public void updateAnim(int i2, String str) {
        updateAnim(i2, str, null);
    }

    @JavascriptInterface
    public void updateProperties(String str) {
        updateProperties(str, null);
    }

    @JavascriptInterface
    public void addStoredViewToParent(final String str, final String str2, final int i2, final String str3, final boolean z, final String str4, final String str5) {
        ExecutorManager.runOnMainThread(new Runnable() { // from class: in.juspay.hypersdk.core.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f48598a.lambda$addStoredViewToParent$3(str2, str, i2, str3, z, str4, str5);
            }
        });
    }

    @JavascriptInterface
    public void addViewToParent(String str, String str2, int i2, String str3, boolean z, String str4) {
        AndroidInterface androidInterface;
        try {
            androidInterface = this;
        } catch (JSONException unused) {
            androidInterface = this;
        }
        try {
            ExecutorManager.runOnMainThread(new i(androidInterface, str, new JSONObject(str2), i2, z, str4, str3));
        } catch (JSONException unused2) {
            androidInterface.dynamicUI.getLogger().e("JSONERROR", "Error while parsing " + str2);
        }
    }

    @JavascriptInterface
    public void generateUIElement(final String str, final int i2, final String[] strArr, final String str2, final String str3) {
        ExecutorManager.runOnMainThread(new Runnable() { // from class: in.juspay.hypersdk.core.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f48616a.lambda$generateUIElement$15(str3, str, i2, strArr, str2);
            }
        });
    }

    @JavascriptInterface
    public void moveView(String str, String str2, String str3) {
        ExecutorManager.runOnMainThread(new h((Object) this, str3, str, (Object) str2, 0));
    }

    @JavascriptInterface
    public void removeView(int i2, String str) {
        ExecutorManager.runOnMainThread(new f(this, str, i2));
    }

    @JavascriptInterface
    public void render(String str, String str2, String str3) {
        render(str, str2, str3, null);
    }

    @JavascriptInterface
    public void replaceView(String str, int i2, String str2) {
        try {
            ExecutorManager.runOnMainThread(new c(this, str2, new JSONObject(str), i2));
        } catch (JSONException unused) {
            this.dynamicUI.getLogger().e("JSON_ERROR", "fn__replaceView - " + this.dynamicUI.getRenderer().getErrorDetails() + " - " + str);
        }
    }

    @JavascriptInterface
    public void runInUI(String str, String str2) {
        ExecutorManager.runOnMainThread(new e(2, this, str, str2));
    }

    @JavascriptInterface
    public void startAnim(String str, String str2) {
        ExecutorManager.runOnMainThread(new h(this, this.dynamicUI.getRenderer().getInflateView().findAnimationById(str), str2, str, 1));
    }

    @JavascriptInterface
    public void updateAnim(int i2, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            ExecutorManager.runOnMainThread(new c(this, str2, i2, jSONArray));
        } catch (JSONException unused) {
            this.dynamicUI.getLogger().e("JSONERROR", "Error parsing json for animation string " + str);
        }
    }

    @JavascriptInterface
    public void updateProperties(String str, String str2) {
        ExecutorManager.runOnMainThread(new e(1, this, str2, str));
    }

    @JavascriptInterface
    @Deprecated
    public void Render(String str, String str2, String str3) {
        Log.d("DynamicUI", "Method Android.Render is deprecated. Use Android.render() instead");
        render(str, str2, str3, null);
    }

    @JavascriptInterface
    public void render(String str, String str2, String str3, String str4) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                if (this.dynamicUI.getContainer(str4) != null) {
                    ExecutorManager.runOnMainThread(new b(this, jSONObject, str4, str3, str2));
                    return;
                }
                this.dynamicUI.getLogger().e("missing_container", "render, it is not activity, it is applicationContext/ no container");
                this.dynamicUI.getErrorCallback().onError(MerchantConstants.ERROR, " excep: fn__Render  - missing_container - " + this.dynamicUI.getRenderer().getErrorDetails());
                if (str2 != null) {
                    this.dynamicUI.addJsToWebView("window.callUICallback(" + str2 + ",'failure');");
                }
            } catch (JSONException unused) {
                this.dynamicUI.getLogger().e("JSONERROR", "fn__render - " + this.dynamicUI.getRenderer().getErrorDetails() + " - " + str);
            }
        } catch (JSONException unused2) {
        }
    }

    @JavascriptInterface
    public void addViewToParent(String str, String str2, int i2, String str3) {
        addViewToParent(str, str2, i2, str3, (String) null);
    }

    @JavascriptInterface
    public void addViewToParent(String str, String str2, int i2, String str3, String str4) {
        addViewToParent(str, str2, i2, str3, false, str4);
    }
}
