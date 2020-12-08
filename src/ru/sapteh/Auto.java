package ru.sapteh;

public class Auto {
    private int id;
    private String marka;
    private String model;
    private String proizvoditel;
    private String year;
    private String color;

    public Auto (int id,String marka,String model,String proizvoditel,String year,String color){
        this.id = id;
        this.marka = marka;
        this.model = model;
        this.proizvoditel = proizvoditel;
        this.year = year;
        this.color = color;
    }
    public int getId(){
        return id;
    }
    public void setId(){
        this.getId();
    }
    public String getMarka(){
        return marka;
    }
    public void setMarka(){
        this.getMarka();
    }
    public String getModel(){
        return model;
    }
    public void setModel(){
        this.getModel();
    }
    public String getProizvoditel(){
        return proizvoditel;
    }
    public void setProizvoditel(){
        this.getProizvoditel();
    }
    public String getYear(){
        return year;
    }
    public void setYear(){
        this.getYear();
    }
    public String getColor(){
        return color;
    }
    public void setColor(){
        this.getColor();
    }
    public String toString(){
        return String.format("%d %s %s %s %s %s",getId(),getMarka(),getModel(),getProizvoditel(),getYear(),getColor());
    }
}
