package id.renaldirey.daggermvp.ui.base;

/**
 * Created by Kwikku on 15/05/2018.
 */

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);
    void detachView();
    boolean isViewAttached();
    void destroy();

}