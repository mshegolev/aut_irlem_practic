package io.cucumber.zituorden;

public class Belly {
    public void eat(int cukes) {
        String result = "i eat cukes: " + cukes;
        System.out.println(result);
    }

    public void waiting(Integer int1) {
        String result = "i waite: " + int1;
        System.out.println(result);
    }

    public void growl() {
        System.out.println("Belly growl");
    }
}
