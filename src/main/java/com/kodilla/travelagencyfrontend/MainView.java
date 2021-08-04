package com.kodilla.travelagencyfrontend;

import com.kodilla.travelagencyfrontend.domain.Travel;
import com.kodilla.travelagencyfrontend.domain.CartForm;
import com.kodilla.travelagencyfrontend.domain.TravelService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    private TravelService travelService = TravelService.getInstance();
    private Grid<Travel> grid = new Grid<>(Travel.class);
    private TextField filter1 = new TextField();
    private TextField filter2 = new TextField();
    private CartForm form = new CartForm(this);

    public MainView(){

        filter1.setPlaceholder("Filter by type");
        filter2.setPlaceholder("Filter by travelId");
        add(new Button("Search"));
        filter1.setClearButtonVisible(true);
        filter1.setValueChangeMode(ValueChangeMode.EAGER);
        //filter.addValueChangeListener(e -> update());
        grid.setColumns("travelId","name","type","description","startDate","endDate","price");
        HorizontalLayout mainContent = new HorizontalLayout(grid, form);
        mainContent.setSizeFull();
        grid.setSizeFull();

        add(filter1,filter2, mainContent);
        setSizeFull();
        refresh();
    }
    public void refresh(){
        grid.setItems(travelService.getTravels());
    }
    /*private void update(){
        grid.setItems(travelService.findByType(filter.getValue()));
    }

     */


}
