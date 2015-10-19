package sevenWonders.client.presenter.interfaces;

import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.view.LazyView;

public interface IGameView extends IsWidget, LazyView {

	public interface IGamePresenter {

	}

	void initHand();

}
