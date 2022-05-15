package de.htwberlin.werbringts.web.api;

public class ItemsBroughtManipulationRequest {
    private Long personId;
    private Long productId;
    private int quantityBrought;

    public ItemsBroughtManipulationRequest(Long personId, Long productId, int quantityBrought) {
        this.personId = personId;
        this.productId = productId;
        this.quantityBrought = quantityBrought;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantityBrought() {
        return quantityBrought;
    }

    public void setQuantityBrought(int quantityBrought) {
        this.quantityBrought = quantityBrought;
    }
}
