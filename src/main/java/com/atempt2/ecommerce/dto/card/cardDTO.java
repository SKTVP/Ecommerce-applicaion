package com.atempt2.ecommerce.dto.card;

import java.util.List;

public class cardDTO {
    List<CardItemDto> carditems;
    private double totalcost;

    public List<CardItemDto> getCarditems() {
        return carditems;
    }

    public cardDTO() {
    }

    public void setCarditems(List<CardItemDto> carditems) {
        this.carditems = carditems;
    }

    public double getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(double totalcost) {
        this.totalcost = totalcost;
    }
}
