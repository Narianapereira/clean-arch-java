package br.com.alura.codechella.domain;

public class Address {

    private String postalCode;
    private Integer number;
    private String extra;

    public Address(String postalCode, Integer number, String extra) {
        this.postalCode = postalCode;
        this.number = number;
        this.extra = extra;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
