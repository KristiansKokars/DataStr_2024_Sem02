package com.kristianskokars.datastructures;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;


public class MyGenericList<T> {
    private final int LIST_DEFAULT_SIZE = 10;
    private final Class<T> clazz;
    private T[] array;
    private int size = LIST_DEFAULT_SIZE;
    private int count;

    public MyGenericList(Class<T> clazz) {
        this.clazz = clazz;
        array = createNewArray(size);
        count = 0;
    }

    public MyGenericList(Class<T> clazz, int size) {
        if (size <= 0) throw new IllegalArgumentException("Invalid array size");

        this.clazz = clazz;
        this.size = size;
        array = createNewArray(size);
        count = 0;
    }

    public boolean isFull() {
        return array.length == size;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int getCount() {
        return count;
    }

    public void doubleArray() {
        T[] newArray = createNewArray(size * 2);
        size = size * 2;

        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public void push(T element) {
        if (count == size) {
            doubleArray();
        };

        array[count] = element;
        count++;
    }

    // TODO: I do not remember if you could do direct [] overloading in Java
    public void addAtIndex(int index, T number) {
        if (isInvalidIndex(index)) return;

        array[index] = number;
    }

    public void deleteAtIndex(int index, T element) {
        // TODO: not sure what behaviour to do here for the task: throw or just do nothing?
        if (isInvalidIndex(index)) return;

        array[index] = null; // NullPointerExceptions here I come
    }

    public T getAtIndex(int index) {
        if (isInvalidIndex(index)) throw new ArrayIndexOutOfBoundsException();

        return array[index];
    }

    public int findElement(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i] == element) {
                return i;
            }
        }

        return -1;
    }
    // TODO: can't add @Nullable?
    public T returnNextElement(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i] == element && i != size - 1) {
                return array[i + 1];
            }
        }

        return null;
    }

    // Note: this does not sort in place
    public void sort() {
        array = Arrays
                .stream(array)
                .filter(Objects::nonNull)
                .sorted()
                .toArray((unusedSize) -> createNewArray(size)); // filtering out nulls changes the size of the array, so we put it back
    }

    public void print() {
        for (T element : array) {
            if (element == null) continue;

            System.out.print(String.format("%s ", element));
            System.out.println();
        }
    }

    public void empty() {
        array = createNewArray(size);
    }

    private boolean isInvalidIndex(int index) {
        return index > size - 1 || index < 0;
    }

    @SuppressWarnings("unchecked")
    private T[] createNewArray(int size) {
        return (T[]) Array.newInstance(clazz, size);
    }
}
