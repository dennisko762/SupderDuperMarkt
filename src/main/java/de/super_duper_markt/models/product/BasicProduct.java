package de.super_duper_markt.models.product;

import java.text.NumberFormat;
import java.util.*;

public abstract class BasicProduct implements Storable {

    private final double basePrice;
    private final Type type;
    private final String description;
    private Date storageDate;
    private int quality;
    private UUID productId;

    private final double maxStorageTemperatureCelsius;

    protected BasicProduct(String description, int quality, double basePrice, Type type, double maxStorageTemperatureCelsius) {
        this.description = description;
        this.quality = quality;
        this.basePrice = basePrice;
        this.productId = UUID.randomUUID();
        this.type = type;
        this.storageDate = Calendar.getInstance().getTime();
        this.maxStorageTemperatureCelsius = maxStorageTemperatureCelsius;
    }

    public double getMaxStorageTemperatureCelsius() {
        return maxStorageTemperatureCelsius;
    }

    public double getDailyPrice() {
        return this.basePrice;
    }

    public String getDescription() {
        return description;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public Date getStorageDate() {
        return this.storageDate;
    }

    public void setStorageDate(Date storageDate) {
        this.storageDate = storageDate;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "description= " + description +
                ", quality= " + quality + ", daily price= " + (NumberFormat.getCurrencyInstance(Locale.GERMANY)).format(this.getDailyPrice());
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }

        BasicProduct product = (BasicProduct) obj;
        return hashCode() == product.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }

}
