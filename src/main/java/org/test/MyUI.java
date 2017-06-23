package org.test;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**

 * 先把这里做成一个用户登录界面，同时在数据库里面建立用户表，再开一个用页面用于用户管理，如何？
 * test tse
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        
        
        final TextField userNameInput = new TextField();
        userNameInput.setCaption("user name:");
        
        final TextField userPasswordInput = new TextField();
        userPasswordInput.setCaption("password:");

        Button button = new Button("Login");
        button.addClickListener( e -> {
            //layout.addComponent(new Label("Thanks " + userNameInput.getValue() 
              //      + ", it works!"));
        	 layout.addComponent(new Label("下一步干嘛呢？？"));
        });
        
        layout.addComponents(userNameInput, userPasswordInput,button);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
