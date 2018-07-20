package com.clakestudio.pc.fizykor;

import android.support.annotation.NonNull;

import java.util.Iterator;
/**
 * Created by Jan on 7/20/2018.
 */

class Stack<Item> implements Iterable<Item> {

    private int len = 0;
    private Item[] stack = (Item[]) new Object[1];


    public Item pop() {
        Item item = stack[--len];
        stack[len] = null;
        if (len > 0 && len == stack.length/4)
            resize(stack.length/2);
        return item;
    }
    public void push(Item item) {
        if (len == stack.length) {
            resize(stack.length*2);
        }
        stack[len++] = item;
    }



    public boolean isEmpty() {
        return len == 0;
    }
    public int size() {
        return len;
    }
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        System.arraycopy(stack, 0, temp, 0, len);
        stack = temp;
    }



    public class ReverseStackIterator implements Iterator<Item> {

        private int i = len;

        public boolean hasNext() {
            return i > 0;
        }
        public Item next() {
            return stack[--i];
        }
        public void remove() {

        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i< len; i++) {
            stringBuilder.append(i).append(" ");
        }
        return stringBuilder.toString();
    }


    @NonNull
    @Override
    public Iterator<Item> iterator() {
        return new ReverseStackIterator();
    }

}
