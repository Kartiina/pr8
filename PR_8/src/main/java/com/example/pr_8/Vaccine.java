package com.example.pr_8;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Vaccine<get> {
    Random random = new Random();
    private final StringProperty NameV;
    private final StringProperty TypeV;
    private final ObjectProperty<LocalDate> DateOfVaccination;

    String[] names = new String[]{"Биовак-D", "Нобивак Lepto", "Рабизин", "Нобивак Piro", "Мультикан-1"};
    String[] type = new String[]{"По желанию владельца","Обязательно"};
    int minDay = (int) LocalDate.of(2010, 1, 1).toEpochDay();
    int maxDay = (int) LocalDate.of(2021, 1, 1).toEpochDay();
    long randomDay = minDay + random.nextInt(maxDay - minDay);

    public Vaccine(){
        NameV = new SimpleStringProperty(names[ThreadLocalRandom.current().nextInt(0, names.length - 1)]);
        TypeV = new SimpleStringProperty(type[ThreadLocalRandom.current().nextInt(0, type.length - 1)]);
        DateOfVaccination = new SimpleObjectProperty<LocalDate>(LocalDate.ofEpochDay(randomDay));
    }

    public String getTypeV() {
        return TypeV.get();
    }

    public StringProperty namevProperty() { return NameV;}
    public StringProperty typeProperty() { return TypeV;}
    public ObjectProperty<LocalDate> dateProperty() { return DateOfVaccination;}

    public String getNameV() {
        return NameV.get();
    }

    public LocalDate getDateOfVaccination() {
        return DateOfVaccination.get();
    }
    
    public static void setNameV(String NameV){
        NameV.set(NameV);
    }
    public void setTypeV(String TypeV){
        this.TypeV.set(TypeV);
    }
}
