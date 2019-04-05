package com.warems.warehouse.entity;

public class Food {
    private Integer id; //主键
    private String name; //名称
    private String standard; //规格
    private String unit; //单位
    private Float price; //价格
    private String producedate; //生产日期
    private String guaranteeperiod; //保质期
    private Integer number; //剩余数量

    public Food() { }


    public Food(Integer id, String name, String standard, String unit, Float price, String producedate, String guaranteeperiod, Integer number) {
        this.id = id;
        this.name = name;
        this.standard = standard;
        this.unit = unit;
        this.price = price;
        this.producedate = producedate;
        this.guaranteeperiod = guaranteeperiod;
        this.number = number;
    }
    public Food( String name, String standard, String unit, Float price, String producedate, String guaranteeperiod, Integer number) {

        this.name = name;
        this.standard = standard;
        this.unit = unit;
        this.price = price;
        this.producedate = producedate;
        this.guaranteeperiod = guaranteeperiod;
        this.number = number;
    }
    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", standard='" + standard + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", producedate='" + producedate + '\'' +
                ", guaranteeperiod='" + guaranteeperiod + '\'' +
                ", number=" + number +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getProducedate() {
        return producedate;
    }

    public void setProducedate(String producedate) {
        this.producedate = producedate;
    }

    public String getGuaranteeperiod() {
        return guaranteeperiod;
    }

    public void setGuaranteeperiod(String guaranteeperiod) {
        this.guaranteeperiod = guaranteeperiod;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
