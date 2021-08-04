package com.kodilla.travelagencyfrontend.domain;

import com.kodilla.travelagencyfrontend.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class CartForm extends FormLayout {
    private TextField travelId = new TextField("travelId");
    private TextField name = new TextField("clientName");
    private TextField surname = new TextField("clientSurname");
    private TextField clientId = new TextField("clientId");
    private TextField mail = new TextField("mail");
    private ComboBox<TravelType> type = new ComboBox<>("Travel type");
    private Binder<Travel> binder = new Binder<Travel>(Travel.class);
    private MainView mainView;
    private TravelService service = TravelService.getInstance();
    private Button save = new Button("Add Travel To Cart");
    private Button delete = new Button("Buy Travel Now");
    public CartForm(MainView mainView) {
        type.setItems(TravelType.values());
        HorizontalLayout buttons = new HorizontalLayout(save, delete);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(travelId, name, surname, clientId, mail, buttons);
        binder.bindInstanceFields(this);
        this.mainView=mainView;
        save.addClickListener(event -> save());
        delete.addClickListener(event -> delete());
    }
    private void save() {
        Travel travel = binder.getBean();
        service.save(travel);
        mainView.refresh();

    }

    private void delete() {
        Travel travel = binder.getBean();
        service.delete(travel);
        mainView.refresh();

    }

}
