package org.test;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * 
 * 
 */
@Theme("mytheme")
public class MyUI extends UI {
	
	//Add the next two lines:
	private CustomerService service = CustomerService.getInstance();
	private Grid<Customer>grid = new Grid<>(Customer.class);

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        
        grid.setColumns("firstName", "lastName", "email");

        // add Grid to the layout
        layout.addComponent(grid);

        updateList();
   
        final TextField userNameInput = new TextField();
        userNameInput.setCaption("wut do u like to say:");
        Button button = new Button("GO.........");
        button.addClickListener( e -> {
            //layout.addComponent(new Label("Thanks " + userNameInput.getValue() 
              //      + ", it works!"));
        	 layout.addComponent(new Label("only bullshit？？"));
        });
        
        layout.addComponents(userNameInput,button);
        
        setContent(layout);
    }
    
    public void updateList() {
        // fetch list of Customers from service and assign it to Grid
        List<Customer> customers = service.findAll();
        grid.setItems(customers);
    }
    
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
