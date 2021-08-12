package Modul2;

import java.util.Arrays;

public class GenericStack<E> {
    private int MAX_SIZE;
    private int size;
    private E[] elements;


    public GenericStack(int capacity){
        MAX_SIZE = capacity;
        elements = (E[]) new Object[getCapacity()];
    }

    public int size() {
        return size;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return elements[size - 1];
    }

    public void push(E o) {
        if(o != null) {
            if (isFull()) {
                E[] elementsCopy = (E[]) new Object[elements.length + MAX_SIZE];
                System.arraycopy(elements, 0, elementsCopy, 0, elements.length);
                elements = elementsCopy;
                MAX_SIZE *= 2;
            }
            elements[size++] = o;
        }
    }

    public E pop() {
        size--;
        E o = elements[size];
        elements[size] = null;
        return o;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public int getCapacity(){
        return MAX_SIZE;
    }

    @Override
    public String toString() {
        return "stack: " + Arrays.toString(elements);
    }
}