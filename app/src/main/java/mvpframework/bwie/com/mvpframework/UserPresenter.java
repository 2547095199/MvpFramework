package mvpframework.bwie.com.mvpframework;

/**
 * Created by CZ on 2017/11/7.
 */
public class UserPresenter {
    private final Iview userView;
        private final Imodxel userModel;

                public UserPresenter(Iview userView) {
                this.userView = userView;
                this.userModel = new Imodxel();
            }

                /**
     25.     * 登录
     26.     */
                public void Login(final User user) {

                final String res = userModel.login(user);

                if ("true".equals(res)) {
                        userView.onLoginSuccess();


                    } else {
                        userView.onLoginFailed(res);
                    }
            }

    private class Imodxel {
        public String login(User user) {
            return null;
        }
    }
}

