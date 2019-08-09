package com.msm.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box implements Comparable<Box> {

    private int number;

    public Box(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static void main(String[] args) {
        Box box1 = new Box(2);

        Box box2 = new Box(10);


        Box box3 = new Box(-9);

        Box box4 = new Box(200);


        Box box5 = new Box(7);

        Box box6 = new Box(-10);

        List<Box> boxList = new ArrayList<>();
        boxList.add(box1);
        boxList.add(box2);
        boxList.add(box3);
        boxList.add(box4);
        boxList.add(box5);
        boxList.add(box6);

        Collections.sort(boxList);

        System.out.println(boxList);

        System.out.println(box1);
        System.out.println(box2);

        System.out.println(box1.compareTo(box2));
    }

    @Override
    public String toString() {
        return "Box{" + "number=" + number + '}';
    }

    @Override
    public int compareTo(Box newBox) {
        if(this.number < newBox.getNumber()) {
            return -1;
        } else if (this.number == newBox.number) {
            return 0;
        } else {
            return 1;
        }
    }
}

/*
HW:

1. Create a 2dimensional vector class: ie.  new MyVector(3.8, 4.3)
similar to box, make this comparable and compare based on euclidian length.

2.  experiment with array/list of strings, and sort them and print them out.

3.   experiment with array/list of strings, and sort in reverse (investigate Comparators).
      (create Comparator that reverses string comparison alphabetically).

 */
