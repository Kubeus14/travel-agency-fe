package com.kodilla.travelagencyfrontend.domain;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.data.binder.Binder;

import java.util.HashSet;
import java.util.Set;


public class TravelService {

    private Set travels;
    private static TravelService travelService;
    private Binder<Travel> binder = new Binder<Travel>(Travel.class);

    private TravelService() {
        this.travels = travelData();
    }

    public static TravelService getInstance() {
        if (travelService == null) {
            travelService = new TravelService();
        }

        return travelService;
    }

    public Set getTravels() {
        return new HashSet<>(travels);
    }

    public void addTravel(Travel travel) {
        this.travels.add(travel);
    }
    public void save(Travel travel) {
        this.travels.add(travel);
    }

    public void delete(Travel travel) {
        this.travels.remove(travel);
    }

    public void setTravel(Travel travel) {
        binder.setBean(travel);

    }

    private Set travelData() {
        Set travels = new HashSet<>();
        travels.add(new Travel("2451","Piramids and Pharaons", TravelType.bustrip, "Tour in Egipt by Bus", "2021-12-14", "2021-12-24", "2200 $"));
        travels.add(new Travel("8932","Relax in Greece", TravelType.allinclusive, "Spend time on the beach in Greece", "2021-07-10", "2021-07-17", "2000 $"));
        travels.add(new Travel("3577","Climbing Mont Blanc", TravelType.alpinism, "Explore Alps, climbing on the top of MB", "2021-06-22", "2021-06-27", "4500 $"));
        travels.add(new Travel("4213","Valley of Fiords", TravelType.bustrip, "Explore Norway, and north part of Europe", "2021-05-11", "2021-05-19", "3700 $"));
        travels.add(new Travel("5578","Memories from Holiday", TravelType.allinclusive, "Relax in Isla Gran Canaria", "2021-08-14", "2021-08-22", "2100 $"));
        travels.add(new Travel("6786","Mountains of Dracula", TravelType.alpinism, "Explore mountains in Romania", "2021-03-10", "2021-03-20", "3000 $"));
        travels.add(new Travel("7690","Benelux in one week", TravelType.bustrip, "Visit all countries of Benelux by Bus", "2021-11-23", "2021-11-30", "3400 $"));
        return travels;
    }

    /*public Set findByType(String type){
        return travels.stream().filter(travel -> travel.getType().contains(type)).collect(Collectors.toSet());
    }

     */
}



