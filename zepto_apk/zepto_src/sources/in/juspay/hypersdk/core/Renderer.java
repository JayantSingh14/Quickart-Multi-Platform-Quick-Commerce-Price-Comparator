package in.juspay.hypersdk.core;

import android.content.Context;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hypersdk.analytics.LogConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public class Renderer {

    @NonNull
    private final DynamicUI dynamicUI;
    private int viewCacheCapacity;

    @NonNull
    ConcurrentHashMap<String, List<View>> viewCache = new ConcurrentHashMap<>();

    @NonNull
    private final ConcurrentHashMap<String, ViewGroup> container = new ConcurrentHashMap<>();

    @NonNull
    private final ConcurrentHashMap<String, View> prevView = new ConcurrentHashMap<>();

    public static class RenderTreeNode {
        View itself;
        ViewGroup parent;

        public RenderTreeNode(ViewGroup viewGroup, View view) {
            this.parent = viewGroup;
            this.itself = view;
        }
    }

    public Renderer(@NonNull DynamicUI dynamicUI, @NonNull JSONObject jSONObject) {
        this.dynamicUI = dynamicUI;
        try {
            this.viewCacheCapacity = jSONObject.getJSONObject("uiFeatures").getJSONObject("nbListItemCaching").getInt("bgCacheCapacity");
        } catch (Exception unused) {
            this.viewCacheCapacity = 4;
        }
        try {
            initCache();
        } catch (Exception e2) {
            dynamicUI.getLogger().e("Error while initializing cache", e2.toString());
        }
    }

    private void addViewFromRenderTreeNodeQueue(Queue<RenderTreeNode> queue) {
        while (!queue.isEmpty()) {
            RenderTreeNode renderTreeNodePoll = queue.poll();
            if (renderTreeNodePoll != null) {
                renderTreeNodePoll.parent.addView(renderTreeNodePoll.itself);
            }
        }
    }

    private View createAllNodesAndReturnRoot(JSONObject jSONObject, Queue<RenderTreeNode> queue, boolean z) throws JSONException {
        ViewGroup viewGroup;
        View merchantView;
        String string = jSONObject.getString("type");
        JSONObject jSONObject2 = jSONObject.getJSONObject("props");
        if (jSONObject.has("props")) {
            setCurrentNodeDetails(string, jSONObject2);
        }
        Object newInstanceFromClassName = getNewInstanceFromClassName(string);
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            this.dynamicUI.getInflateView().parseKeys(itKeys.next(), jSONObject2, newInstanceFromClassName, z);
        }
        String strOptString = jSONObject2.optString("viewType");
        if (!strOptString.isEmpty() && (merchantView = this.dynamicUI.getMerchantView((viewGroup = (ViewGroup) newInstanceFromClassName), MerchantViewType.valueOf(strOptString))) != null) {
            queue.add(new RenderTreeNode(viewGroup, merchantView));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("children");
        if (jSONArray.length() != 0) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                queue.add(new RenderTreeNode((ViewGroup) newInstanceFromClassName, createAllNodesAndReturnRoot(jSONArray.getJSONObject(i2), queue, z)));
            }
        }
        return (View) newInstanceFromClassName;
    }

    private View createNodesAndReturnRoot(JSONObject jSONObject, InflateView inflateView) throws JSONException {
        String string = jSONObject.getString("type");
        JSONObject jSONObject2 = jSONObject.getJSONObject("props");
        if (jSONObject.has("props")) {
            setCurrentNodeDetails(string, jSONObject2);
        }
        Object newInstanceFromClassName = getNewInstanceFromClassName(string);
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            inflateView.parseKeys(itKeys.next(), jSONObject2, newInstanceFromClassName, inflateView.getUseAppContext());
        }
        JSONArray jSONArray = jSONObject.getJSONArray("children");
        if (jSONArray.length() != 0) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                ((ViewGroup) newInstanceFromClassName).addView(createNodesAndReturnRoot(jSONArray.getJSONObject(i2), inflateView));
            }
        }
        return (View) newInstanceFromClassName;
    }

    private Object getNewInstanceFromClassName(String str) {
        Context appContext = this.dynamicUI.getAppContext();
        View cachedViewFor = getCachedViewFor(str);
        if (cachedViewFor != null) {
            return cachedViewFor;
        }
        str.getClass();
        switch (str) {
            case "android.widget.FrameLayout":
                return new FrameLayout(appContext);
            case "android.widget.RelativeLayout":
                return new RelativeLayout(appContext);
            case "android.view.TextureView":
                return new TextureView(appContext);
            case "android.widget.LinearLayout":
                return new LinearLayout(appContext);
            case "androidx.swiperefreshlayout.widget.SwipeRefreshLayout":
                return new SwipeRefreshLayout(appContext, null);
            case "android.widget.CheckBox":
                return new CheckBox(appContext);
            case "android.widget.EditText":
                return new EditText(appContext);
            case "android.widget.ImageButton":
                return new ImageButton(appContext);
            case "android.widget.ImageView":
                return new ImageView(appContext);
            case "android.widget.ScrollView":
                return new ScrollView(appContext);
            case "android.widget.TextView":
                return new TextView(appContext);
            case "android.widget.Button":
                return new Button(appContext);
            case "android.widget.RadioButton":
                return new RadioButton(appContext);
            default:
                return getInflateView().getClassName(str).getConstructor(Context.class).newInstance(appContext);
        }
    }

    private void initCache() {
        ExecutorManager.runOnBackgroundThread(new l(9, this, new String[]{"android.widget.RelativeLayout", "android.widget.LinearLayout", "android.widget.ImageView", "android.widget.ScrollView", "android.widget.TextView", "android.widget.EditText", "android.widget.FrameLayout"}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCache$0(String[] strArr) {
        List<View> listSynchronizedList = Collections.synchronizedList(new ArrayList());
        for (String str : strArr) {
            for (int i2 = 0; i2 < this.viewCacheCapacity; i2++) {
                try {
                    listSynchronizedList.add((View) Class.forName(str).getConstructor(Context.class).newInstance(this.dynamicUI.getAppContext()));
                } catch (Exception e2) {
                    this.dynamicUI.getLogger().e("Error while initializing cache in function", e2.toString());
                }
            }
            this.viewCache.put(str, listSynchronizedList);
            listSynchronizedList = Collections.synchronizedList(new ArrayList());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$replenishCache$1(String str) {
        List<View> listSynchronizedList = this.viewCache.get(str);
        if (listSynchronizedList == null) {
            listSynchronizedList = Collections.synchronizedList(new ArrayList());
            this.viewCache.put(str, listSynchronizedList);
        }
        if (listSynchronizedList.size() < this.viewCacheCapacity) {
            try {
                listSynchronizedList.add((View) Class.forName(str).getConstructor(Context.class).newInstance(this.dynamicUI.getAppContext()));
            } catch (Exception unused) {
            }
        }
    }

    private void removeViewFromContainer(View view, String str) {
        ViewGroup viewGroup = this.container.get(str);
        if (viewGroup != null) {
            viewGroup.removeViewAt(viewGroup.indexOfChild(view));
        }
    }

    private void render(View view, String str) {
        ViewGroup viewGroup = this.container.get(str);
        if (view != null && viewGroup != null) {
            viewGroup.addView(view);
            return;
        }
        this.dynamicUI.getErrorCallback().onError(MerchantConstants.ERROR, " isNull : fn__Render -  instance null " + getErrorDetails());
    }

    public void addStoredViewToParent(String str, String str2, int i2, boolean z, String str3) {
        int identifier = this.dynamicUI.getAppContext().getResources().getIdentifier(str, CLConstants.SHARED_PREFERENCE_ITEM_ID, this.dynamicUI.getAppContext().getPackageName());
        if (i2 < 0) {
            this.dynamicUI.getErrorCallback().onError(MerchantConstants.ERROR, " isNull : fn__addViewToParent - negative index " + getErrorDetails());
            return;
        }
        ViewGroup container = this.dynamicUI.getContainer(str3);
        if (container == null) {
            this.dynamicUI.getErrorCallback().onError(MerchantConstants.ERROR, " isNull : fn__addViewToParent - container null " + getErrorDetails());
            return;
        }
        ViewGroup viewGroup = (ViewGroup) container.findViewById(identifier);
        if (z) {
            viewGroup.removeAllViews();
        }
        View view = (View) this.dynamicUI.getViewFromScreenName(str2);
        if (view != null) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view, i2);
        } else {
            this.dynamicUI.getErrorCallback().onError(MerchantConstants.ERROR, " isNull : fn__addViewToParent - child null " + getErrorDetails());
        }
    }

    public void addViewToParent(String str, JSONObject jSONObject, int i2, boolean z, String str2) {
        int identifier = this.dynamicUI.getAppContext().getResources().getIdentifier(str, CLConstants.SHARED_PREFERENCE_ITEM_ID, this.dynamicUI.getAppContext().getPackageName());
        ViewGroup container = this.dynamicUI.getContainer(str2);
        if (i2 < 0 || container == null) {
            if (container == null) {
                this.dynamicUI.getLogger().e("Missing Container", "addViewToParent, InflateView, it is not  activity, it is applicationContext");
            }
            if (jSONObject.has("props")) {
                setCurrentNodeDetails(jSONObject.getString("type"), jSONObject.getJSONObject("props"));
            }
            this.dynamicUI.getErrorCallback().onError(MerchantConstants.ERROR, " isNull : fn__addViewToParent - negative index " + getErrorDetails());
            return;
        }
        ViewGroup viewGroup = (ViewGroup) container.findViewById(identifier);
        if (z) {
            viewGroup.removeAllViews();
        }
        LinkedList linkedList = new LinkedList();
        InflateJSON inflateJSON = new InflateJSON(this.dynamicUI);
        inflateJSON.setUseAppContext(true);
        View viewCreateAllNodesAndReturnRoot = createAllNodesAndReturnRoot(jSONObject, linkedList, inflateJSON.getUseAppContext());
        addViewFromRenderTreeNodeQueue(linkedList);
        viewGroup.addView(viewCreateAllNodesAndReturnRoot, i2);
    }

    public View createView(JSONObject jSONObject) {
        String string = jSONObject.getString("type");
        JSONObject jSONObject2 = jSONObject.getJSONObject("props");
        if (jSONObject.has("props")) {
            setCurrentNodeDetails(string, jSONObject2);
        }
        Object newInstanceFromClassName = getNewInstanceFromClassName(string);
        Iterator<String> itKeys = jSONObject2.keys();
        InflateJSON inflateJSON = new InflateJSON(this.dynamicUI);
        inflateJSON.setUseAppContext(true);
        while (itKeys.hasNext()) {
            this.dynamicUI.getInflateView().parseKeys(itKeys.next(), jSONObject2, newInstanceFromClassName, inflateJSON.getUseAppContext());
        }
        JSONArray jSONArray = jSONObject.getJSONArray("children");
        if (jSONArray.length() != 0) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                View viewCreateView = createView(jSONArray.getJSONObject(i2));
                if (viewCreateView != null) {
                    ((ViewGroup) newInstanceFromClassName).addView(viewCreateView);
                }
            }
        }
        return (View) newInstanceFromClassName;
    }

    public void dismissPopUp() {
        this.dynamicUI.getInflateView().dismissPopUp();
    }

    public View getCachedViewFor(String str) {
        List<View> list = this.viewCache.get(str);
        if (list == null) {
            return null;
        }
        int size = list.size();
        if (size == 0) {
            replenishCache(str);
            return null;
        }
        View viewRemove = list.remove(0);
        if (size < this.viewCacheCapacity) {
            replenishCache(str);
        }
        return viewRemove;
    }

    public String getErrorDetails() {
        return this.dynamicUI.getInflateView().getErrorDetails();
    }

    public InflateView getInflateView() {
        return this.dynamicUI.getInflateView();
    }

    public void parseAndRunPipe(Object obj, String str, String str2, String str3, boolean z) {
        this.dynamicUI.getInflateView().setCurrView("modifyDom");
        this.dynamicUI.getInflateView().setCurrViewId("");
        this.dynamicUI.getInflateView().setFileOrigin("ln: " + str2 + StringUtils.SPACE + str3);
        this.dynamicUI.getInflateView().parseAndRunPipe(obj, str, z);
    }

    public void prepareAndStoreView(String str, JSONObject jSONObject) {
        InflateJSON inflateJSON = new InflateJSON(this.dynamicUI);
        inflateJSON.setUseAppContext(true);
        this.dynamicUI.addToScreenMap(str, createNodesAndReturnRoot(jSONObject, inflateJSON));
    }

    public void renderUI(JSONObject jSONObject, ViewGroup viewGroup, String str) {
        renderUI(jSONObject, viewGroup, true, str);
    }

    public void replenishCache(String str) {
        ExecutorManager.runOnBackgroundThread(new l(10, this, str));
    }

    public void resetContainer(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.container.containsValue(viewGroup)) {
                for (Map.Entry<String, ViewGroup> entry : this.container.entrySet()) {
                    if (viewGroup.equals(entry.getValue())) {
                        this.container.remove(entry.getKey());
                    }
                }
            }
            if (this.prevView.containsValue(viewGroup)) {
                for (Map.Entry<String, View> entry2 : this.prevView.entrySet()) {
                    if (viewGroup.equals(entry2.getValue())) {
                        this.prevView.remove(entry2.getKey());
                    }
                }
            }
        }
    }

    public void setCurrentNodeDetails(String str, JSONObject jSONObject) throws JSONException {
        this.dynamicUI.getInflateView().setCurrView(str);
        if (jSONObject.has("node_id")) {
            this.dynamicUI.getInflateView().setCurrViewId(jSONObject.getString("node_id"));
        }
        if (jSONObject.has("__filename")) {
            this.dynamicUI.getInflateView().setFileOrigin(jSONObject.getString("__filename"));
        }
    }

    public void renderUI(JSONObject jSONObject, ViewGroup viewGroup, boolean z, String str) {
        if (str == null) {
            str = LogConstants.DEFAULT_CHANNEL;
        }
        this.container.put(str, viewGroup);
        LinkedList linkedList = new LinkedList();
        InflateJSON inflateJSON = new InflateJSON(this.dynamicUI);
        inflateJSON.setUseAppContext(true);
        View viewCreateAllNodesAndReturnRoot = createAllNodesAndReturnRoot(jSONObject, linkedList, inflateJSON.getUseAppContext());
        if (z && this.prevView.get(str) != viewCreateAllNodesAndReturnRoot) {
            removeViewFromContainer(this.prevView.get(str), str);
        }
        addViewFromRenderTreeNodeQueue(linkedList);
        render(viewCreateAllNodesAndReturnRoot, str);
        this.dynamicUI.setContainerInMap((ViewGroup) viewCreateAllNodesAndReturnRoot);
        this.prevView.put(str, viewCreateAllNodesAndReturnRoot);
    }
}
