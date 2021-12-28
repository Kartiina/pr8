package com.example.pr_8;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Pet {
    Random random = new Random();
    private final StringProperty Name;
    private final StringProperty Type;
    private final ObjectProperty<LocalDate> BirthDate;
    private final IntegerProperty age;
    public final ArrayList<Vaccine> vaccines = new ArrayList<Vaccine>();

    String[] names = new String[]{"Овальчик", "Любимка", "Марк", "Боня", "Пушок"};
    String[] type = new String[]{"Собакен","Кiшка"};
    int now = (int) LocalDate.of(2021, 12, 29).toEpochDay();
    int minDay = (int) LocalDate.of(2010, 1, 1).toEpochDay();
    int maxDay = (int) LocalDate.of(2021, 1, 1).toEpochDay();
    int randomDay = minDay + random.nextInt(maxDay - minDay);

    public Pet(String Name, String Type){
        this.Name = new SimpleStringProperty(Name);
        this.Type = new SimpleStringProperty(Type);
        this.age = new SimpleIntegerProperty<LocalDate>(LocalDate.ofYearDay(now - randomDay, now - randomDay));
//        this.age = new SimpleIntegerProperty(ThreadLocalRandom.curresnt().nextInt(10));
//        this.age = new SimpleIntegerProperty((2021 - randomDay));
        this.BirthDate = new SimpleObjectProperty<LocalDate>(LocalDate.ofEpochDay(randomDay));
        getVaccines();
    }
//    public Pet() {
//        //Name = names[ThreadLocalRandom.current().nextInt(0, names.length - 1)];
//        Type = type[ThreadLocalRandom.current().nextInt(0, type.length - 1)];
//        age = ThreadLocalRandom.current().nextInt(10);
//        BirthDate = LocalDate.ofEpochDay(randomDay);
//        setVaccines();
//    }
    public void getVaccines(){
        for (int i = 0; i < 5; i++){
            vaccines.add(new Vaccine());
        }
    }

    public String getName() {
        return Name.get();
    }

    public void setName(String Name) {
        this.Name.set(Name);
    }

    public StringProperty nameProperty() {
        return Name;
    }

    public String getType() {
        return Type.get();
    }

    public void setType(String Type) {
        this.Type.set(Type);
    }

    public StringProperty typeProperty() {
        return Type;
    }

    public int getAge() {
        return age.get();
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public LocalDate getBhday() {
        return BirthDate.get();
    }

    public void setBday(LocalDate BirthDate) {
        this.BirthDate.set(BirthDate);
    }

    public ObjectProperty<LocalDate> bdayProperty() {
        return BirthDate;
    }

    public void setVaccine(String NameV, String TypeV){
        NameV = Vaccine.setNameV();
    }
}
