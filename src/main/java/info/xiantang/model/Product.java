package info.xiantang.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String productId;

    private String productType;

    private String assortment;

    public Product(String productId, String productType, String assortment, String createTime, String imgUrl) {
        this.productId = productId;
        this.productType = productType;
        this.assortment = assortment;
        this.createTime = createTime;
        this.imgUrl = imgUrl;
    }

    public Product() {
    }

    private String createTime;

    private String imgUrl;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public String getAssortment() {
        return assortment;
    }

    public void setAssortment(String assortment) {
        this.assortment = assortment == null ? null : assortment.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }
}