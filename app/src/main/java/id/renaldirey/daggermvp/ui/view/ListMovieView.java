package id.renaldirey.daggermvp.ui.view;

import id.renaldirey.daggermvp.ui.base.BaseView;

/**
 * Created by Kwikku on 13/05/2018.
 */

public interface ListMovieView<T> extends BaseView {

    void showData(T data);
    void showProgress();
    void hideProgress();

}
